package com.cn.sys.user.controller;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cn.sys.user.pojo.*;
import com.cn.sys.user.service.LabPreService;
import com.cn.sys.user.service.LabResultService;
import com.cn.sys.user.utils.XmlHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.sys.user.service.StudentService;
import com.cn.sys.user.service.LabService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/student")  
public class StudentController {
      @Resource  
	  private StudentService studentService;  
      @Resource 
      private LabService labService;
      @Resource
      private LabPreService labPreService;
      @Resource
      private LabResultService labResultService;

      @RequestMapping("regist")
      public String regist(Student student,Model model){
    	  System.out.println("用户注册："+student.getName()+student.getPassword());
    	  studentService.regist(student);
    	  return "registSuccess";
      }
      
      @RequestMapping("/showStudent")  
      public String toIndex(HttpServletRequest request,Model model){  
          //int userId = Integer.parseInt(request.getParameter("id"));  
    	  String name=request.getParameter("name");
    	  
    	  String number=request.getParameter("number");
    	 // Student student=this.studentService.selectByNumber(number);
    	  System.out.print(name);
         Student student = this.studentService.selectByName("张三"); 
    	  
    	  model.addAttribute("student", student);
           
          return "showStudent";
      }
      
      @RequestMapping("login")
      public String login(Model model,Student student) throws Exception{
    	  List<Student> list = null;
          //页码对象
          PagingVO pagingVO = new PagingVO();
          //设置总页数
          pagingVO.setTotalCount(5);
          Integer page=null;
          if (page == null || page == 0) {
              pagingVO.setToPageNo(1);
              list = studentService.findByPaging(1);
          } else {
              pagingVO.setToPageNo(page);
              list = studentService.findByPaging(page);
          }

          model.addAttribute("studentList", list);
          model.addAttribute("pagingVO", pagingVO);
    	  if(this.studentService.login(student))
              {
    	      return "admin/showStudent";}
    	  else return "loginFail";
      }
      @RequestMapping("/showLab")
      public String showLab(Model model, Integer page) throws Exception {

         List<Lab> list = null;
          //页码对象
          PagingVO pagingVO = new PagingVO();
          //设置总页数
           page=null;
          pagingVO.setTotalCount(5);//studentService.getCountStudent());
          if (page == null || page == 0) {
              pagingVO.setToPageNo(1);
              if(list==null)
              list=labService.findByPaging(1);
          } else {
              pagingVO.setToPageNo(page);
             list = labService.findByPaging(page);
          }

          model.addAttribute("labList", list);
          model.addAttribute("pagingVO", pagingVO);

          return "student/showLab";

      }
      ///////查看已预约实验///////////////////////////////////
      @RequestMapping("/showLabPre")
      public String showLabPre(HttpSession httpSession, Model model, Integer page) throws Exception{
          List<LabPre> list=null;
          PagingVO pagingVO = new PagingVO();
          pagingVO.setTotalCount(5);
          Userlogin userlogin=(Userlogin) httpSession.getAttribute("currentUser");
          System.out.print("当前用户名字为："+userlogin.getUsername());
          if(null ==page || page==0){
              pagingVO.setToPageNo(1);
              if(null==list)
                  list=labPreService.findByPaging(userlogin.getUsername(),1);
          } else {
              pagingVO.setToPageNo(page);
              list=labPreService.findByPaging(userlogin.getUsername(),page);
          }
          model.addAttribute("labPreList",list);
          model.addAttribute("pagingVo",pagingVO);
          return "student/showLabPre";
      }
      ///////跳转到提交实验结果界面
      @RequestMapping("/postLabResult")
      public String postLab(Integer id,Model model){
          if (null==id)
              return "redirect:student/showLabPre";
          LabPre labPre=labPreService.selectById(id);
          model.addAttribute("labPre",labPre);
          return "student/postLabResult";
      }
      /////////提交实验结果//////////////////
      @RequestMapping("/postLabResultInfo")
      public String postLabResult(LabResult labResult, HttpSession httpSession, Model model) throws Exception{
          labResultService.save(labResult);
          return "redirect:/student/showLabResult";
      }
      ////////显示实验结果//////////////////////////////
      @RequestMapping("/showLabResult")
      public String showLabResult(LabResult labResult,Model model,HttpSession httpSession,Integer page) throws Exception{
          List<LabResult> list=null;
          PagingVO pagingVO = new PagingVO();
          pagingVO.setTotalCount(5);
          Userlogin userlogin=(Userlogin) httpSession.getAttribute("currentUser");
          System.out.print("当前用户名字为："+userlogin.getUsername());
          if(null ==page || page==0){
              pagingVO.setToPageNo(1);
              if(null==list)
                  list=labResultService.findByPaging(userlogin.getUsername(),1);
          } else {
              pagingVO.setToPageNo(page);
              list=labResultService.findByPaging(userlogin.getUsername(),page);
          }
          model.addAttribute("labResultList",list);
          model.addAttribute("pagingVo",pagingVO);
          return "student/showLabResult";
      }
      ////////////转到上传图片界面//////////////////////////////////////////////////
      @RequestMapping("/upLoadPicture")
      public String upLoadPicture(Integer id,Model model)throws Exception{
          model.addAttribute("id",id);
          return "student/upLoadPicture";
      }
      ////////////上传图片信息////////
      @RequestMapping("/uploadPictureInfo")
      public String upLoadPictureInfo(Integer id,@RequestParam MultipartFile file, HttpServletRequest request)throws Exception{
          LabResult labResult=labResultService.getById(id);

          //String path="D:\\java\\nginx-1.12.2\\staticResources\\static\\image";
          String path="";//"D:\\javaweb\\nginx-1.12.2\\staticResources\\static\\image";
          String xmlPath="/uploadFile.xml";
          XmlHandler xmlHandler=new XmlHandler();
          System.out.print("开始上传图片");
          try {
              xmlHandler.loadXmlFile(this.getClass().getResource(xmlPath).getFile());
          }catch (Exception e){
              System.out.print(e.getMessage());
          }
          List list=xmlHandler.getDataList("/config/uploadFile/nginx");
          System.out.print("正确上传图片"+list.toString());
          HashMap map=(HashMap) list.get(0);
          path=(String) map.get("uploadPath");
          //
          String fileName=file.getOriginalFilename();
          File dir=new File(path,fileName);
          if(!dir.exists()){
              dir.mkdirs();
          }
          System.out.print("dir.exists()>>"+dir.exists());
          file.transferTo(dir);

          String pathSql="http://localhost:9999/static/image/"+fileName;
          labResultService.updatePicture(labResult.getId(),pathSql);
          return "redirect:/student/showLabResult";
      }
      ////////////////////////////接收图片/////////////////////



}
