package com.cn.sys.user.controller;

import java.util.List;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;

import com.cn.sys.user.pojo.*;
import com.cn.sys.user.service.LabService;
import com.cn.sys.user.service.TeacherService;
import com.cn.sys.user.service.UserloginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.sys.user.service.StudentService;

import com.cn.sys.user.exception.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
    private StudentService studentService;

	@Resource
    private UserloginService userloginService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private LabService labService;
//////////////更新是否成功

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<学生操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    //  学生信息显示
    @RequestMapping("/showStudent")
    public String showStudent(Model model, Integer page) throws Exception {

       List<Student> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
         page=null;
        pagingVO.setTotalCount(5);//studentService.getCountStudent());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            if(list==null)
            list=studentService.findByPaging(1);
            System.out.print("查看班级为："+list.get(1).getStuClass()+list.get(1).getName());
        } else {
            pagingVO.setToPageNo(page);
           list = studentService.findByPaging(page);
           System.out.print("查看班级为："+list.get(2).getStuClass());
        }

        model.addAttribute("studentList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "admin/showStudent";

    }

  //  添加学生信息页面显示
    @RequestMapping(value = "/addStudent", method = {RequestMethod.GET})
    public String addStudentUI(Model model) throws Exception {

        //List<College> list = collegeService.finAll();

        //model.addAttribute("collegeList", list);

        return "admin/addStudent";
    }

      // 添加学生信息操作
    @RequestMapping(value = "/addStudent", method = {RequestMethod.POST})
    public String addStudent(Student student, Model model) throws Exception {
        System.out.print("收到学生的姓名"+student.getName());
        int result = studentService.save(student);

        if (result==0) {
            model.addAttribute("message", "学号重复");
            return "error";
        }
        //添加成功后，也添加到登录表
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(student.getName());
        userlogin.setPassword(student.getPassword());
        userlogin.setRole(2);
        System.out.print("姓名："+student.getName()+"密码："+student.getPassword()+"角色："+userlogin.getRole());
        userloginService.save(userlogin);

        //重定向
        return "redirect:/admin/showStudent";
    }

    // 修改学生信息页面显示
    @RequestMapping(value = "/editStudent", method = {RequestMethod.GET})
    public String editStudentUI(Integer id, Model model) throws Exception {
        if (id == null) {
            //加入没有带学生id就进来的话就返回学生显示页面
            return "redirect:/admin/showStudent";
        }
        Student student = studentService.selectById(id);
        if (student == null) {
            throw new CustomException("未找到该名学生");
        }
        //List<student> list = studentService.finAll();

       // model.addAttribute("collegeList", list);
        model.addAttribute("student", student);


        return "admin/editStudent";
    }

    // 修改学生信息处理
    @RequestMapping(value = "/editStudentImpl", method = {RequestMethod.POST})
    public String editStudent(Student student) throws Exception {

        studentService.updataById(student.getId(), student);
        System.out.print(student.getId()+"--"+student.getName());
        //重定向
        return "redirect:/admin/showStudent";
    }

    // 删除学生
    @RequestMapping(value = "/removeStudent", method = {RequestMethod.GET} )
    private String removeStudent(Integer id) throws Exception {
        if (id == null) {
            //加入没有带学生id就进来的话就返回学生显示页面
            return "admin/showStudent";
        }
         studentService.removeById(id);
        //userloginService.removeByName(id.toString());

        return "redirect:/admin/showStudent";
    }

    // 搜索学生
    @RequestMapping(value = "selectStudent", method = {RequestMethod.POST})
    private String selectStudent(String findByName, Model model) throws Exception {

        //List<Student> list = studentService.findByName(findByName);

       // model.addAttribute("studentList", list);
        return "admin/showStudent";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<教师操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

   // 教师页面显示
    @RequestMapping("/showTeacher")
    public String showTeacher(Model model, Integer page) throws Exception {

        List<Teacher> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(teacherService.getCountTeacher());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = teacherService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = teacherService.findByPaging(page);
        }

        model.addAttribute("teacherList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "admin/showTeacher";

    }

    // 添加教师信息
    @RequestMapping(value = "/addTeacher", method = {RequestMethod.GET})
    public String addTeacherUI(Model model) throws Exception {

/*        List<College> list = collegeService.finAll();
        model.addAttribute("collegeList", list);*/
        return "admin/addTeacher";
    }

    // 添加教师信息处理
    @RequestMapping(value = "/addTeacher", method = {RequestMethod.POST})
    public String addTeacher(Teacher teacher, Model model) throws Exception {
        int result = teacherService.save(teacher);
        if (result==0) {
            model.addAttribute("message", "工号重复");
            return "error";
        }
        //添加成功后，也添加到登录表
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(teacher.getName());
        userlogin.setPassword("123");
        userlogin.setRole(1);
        userloginService.save(userlogin);
        //重定向
        return "redirect:/admin/showTeacher";
    }

    // 修改教师信息页面显示
    @RequestMapping(value = "/editTeacher", method = {RequestMethod.GET})
    public String editTeacherUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showTeacher";
        }
        Teacher teacher = teacherService.selectById(id);
        if (teacher == null) {
            throw new CustomException("未找到该名学生");
        }
        model.addAttribute("teacher", teacher);


        return "admin/editTeacher";
    }

    // 修改教师信息页面处理
    @RequestMapping(value = "/editTeacher", method = {RequestMethod.POST})
    public String editTeacher(Teacher teacher) throws Exception {

        teacherService.updataById(teacher.getId(), teacher);

        //重定向
        return "redirect:/admin/showTeacher";
    }

    //删除教师
    @RequestMapping("/removeTeacher")
    public String removeTeacher(Integer id) throws Exception {
        if (id == null) {
            //加入没有带教师id就进来的话就返回教师显示页面
            return "admin/showTeacher";
        }
        teacherService.removeById(id);
        userloginService.removeByName(teacherService.selectById(id).getName());

        return "redirect:/admin/showTeacher";
    }

    //搜索教师
    @RequestMapping(value = "selectTeacher", method = {RequestMethod.POST})
    private String selectTeacher(String name, Model model) throws Exception {

        List<Teacher> list = teacherService.findByName(name);

        model.addAttribute("teacherList", list);
        return "admin/showTeacher";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<实验操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    // 实验信息显示
    @RequestMapping("/showLab")
    public String showLab(Model model, Integer page) throws Exception {

        List<Lab> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(labService.getCountLab());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = labService.findByPaging(1);
            System.out.print("if里面的："+list.get(0).getName());
        } else {
            pagingVO.setToPageNo(page);
            list = labService.findByPaging(page);
            System.out.print("elseif里面的："+list.get(0).getName());
        }

        model.addAttribute("labList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "admin/showLab";

    }

    //添加实验
    @RequestMapping(value = "/addLab", method = {RequestMethod.GET})
    public String addLabUI(Model model) throws Exception {
        List<Lab> list = labService.findAll();
        model.addAttribute("labList", list);
        return "admin/addLab";
    }

    // 添加实验信息处理
    @RequestMapping(value = "/addLab", method = {RequestMethod.POST})
    public String addLab(Lab lab, Model model) throws Exception {

        int result = labService.save(lab);

        if (result==0) {
            model.addAttribute("message", "课程号重复");
            return "error";
        }


        //重定向
        return "redirect:/admin/showLab";
    }

    // 修改教师信息页面显示
    @RequestMapping(value = "/editLab", method = {RequestMethod.GET})
    public String editLabUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showLab";
        }
        Lab lab = labService.selectById(id);
        if (lab == null) {
            throw new CustomException("未找到该课程");
        }
        model.addAttribute("lab", lab);
        return "admin/editLab";
    }

    // 修改实验信息页面处理
    @RequestMapping(value = "/editLab", method = {RequestMethod.POST})
    public String editLab(Lab lab) throws Exception {

        labService.updateById(lab.getId(), lab);

        //重定向
        return "redirect:/admin/showLab";
    }

    // 删除实验信息
    @RequestMapping("/removeLab")
    public String removeLab(Integer id) throws Exception {
        if (id == null) {
            //加入没有带教师id就进来的话就返回教师显示页面
            return "admin/showLab";
        }
        labService.removeById(id);

        return "redirect:/admin/showLab";
    }

    //搜索课程
    @RequestMapping(value = "selectLab", method = {RequestMethod.POST})
    private String selectLab(String findByName, Model model) throws Exception {

        List<Lab> list = labService.selectByName(findByName);

        model.addAttribute("labList", list);
        return "admin/showLab";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<其他操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    // 普通用户账号密码重置
    /*@RequestMapping("/userPasswordRest")
    public String userPasswordRestUI() throws Exception {
        return "admin/userPasswordRest";
    }

    // 普通用户账号密码重置处理
    @RequestMapping(value = "/userPasswordRest", method = {RequestMethod.POST})
    public String userPasswordRest(Userlogin userlogin) throws Exception {

        Userlogin u = userloginService.findByName(userlogin.getUsername());

        if (u != null) {
            if (u.getRole() == 0) {
                throw new CustomException("该账户为管理员账户，没法修改");
            }
            u.setPassword(userlogin.getPassword());
            userloginService.updateByName(userlogin.getUsername(), u);
        } else {
            throw new CustomException("没找到该用户");
        }

        return "admin/userPasswordRest";
    }

    // 本账户密码重置
    @RequestMapping("/passwordRest")
    public String passwordRestUI() throws Exception {
        return "admin/passwordRest";
    }
  */

}

