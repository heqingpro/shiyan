package com.cn.sys.user.controller;
import java.util.List;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cn.sys.user.pojo.LabPre;
import com.cn.sys.user.service.LabPreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.sys.user.pojo.Userlogin;
import com.cn.sys.user.pojo.Student;  
import com.cn.sys.user.service.StudentService;  
import com.cn.sys.user.pojo.PagingVO;
import com.cn.sys.user.service.LabService;
import com.cn.sys.user.pojo.Lab;
@Controller  
@RequestMapping("/student")  
public class StudentController {
      @Resource  
	  private StudentService studentService;  
      @Resource 
      private LabService labService;
      @Resource
      private LabPreService labPreService;

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

}
