package com.cn.sys.user.controller;

import java.util.List;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;

import com.cn.sys.user.pojo.Userlogin;
import com.cn.sys.user.service.UserloginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.sys.user.pojo.Student;  
import com.cn.sys.user.service.StudentService;  
import com.cn.sys.user.pojo.PagingVO;

import com.cn.sys.user.exception.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
    private StudentService studentService;

	@Resource
    private UserloginService userloginService;

    //@Resource(name = "teacherServiceImpl")
    //private TeacherService teacherService;

   // @Resource(name = "labServiceImpl")
    //private labService courseService;
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

   /* // 教师页面显示
    @RequestMapping("/showTeacher")
    public String showTeacher(Model model, Integer page) throws Exception {

        List<TeacherCustom> list = null;
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

        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);

        return "admin/addTeacher";
    }

    // 添加教师信息处理
    @RequestMapping(value = "/addTeacher", method = {RequestMethod.POST})
    public String addTeacher(TeacherCustom teacherCustom, Model model) throws Exception {

        Boolean result = teacherService.save(teacherCustom);

        if (!result) {
            model.addAttribute("message", "工号重复");
            return "error";
        }
        //添加成功后，也添加到登录表
        Userlogin userlogin = new Userlogin();
        userlogin.setUsername(teacherCustom.getUserid().toString());
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
        TeacherCustom teacherCustom = teacherService.findById(id);
        if (teacherCustom == null) {
            throw new CustomException("未找到该名学生");
        }
        List<College> list = collegeService.finAll();

        model.addAttribute("collegeList", list);
        model.addAttribute("teacher", teacherCustom);


        return "admin/editTeacher";
    }

    // 修改教师信息页面处理
    @RequestMapping(value = "/editTeacher", method = {RequestMethod.POST})
    public String editTeacher(TeacherCustom teacherCustom) throws Exception {

        teacherService.updateById(teacherCustom.getUserid(), teacherCustom);

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
        userloginService.removeByName(id.toString());

        return "redirect:/admin/showTeacher";
    }

    //搜索教师
    @RequestMapping(value = "selectTeacher", method = {RequestMethod.POST})
    private String selectTeacher(String findByName, Model model) throws Exception {

        List<TeacherCustom> list = teacherService.findByName(findByName);

        model.addAttribute("teacherList", list);
        return "admin/showTeacher";
    }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<课程操作>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/

    // 课程信息显示
   /* @RequestMapping("/showCourse")
    public String showCourse(Model model, Integer page) throws Exception {

        List<CourseCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCouse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "admin/showCourse";

    }

    //添加课程
    @RequestMapping(value = "/addCourse", method = {RequestMethod.GET})
    public String addCourseUI(Model model) throws Exception {

        List<TeacherCustom> list = teacherService.findAll();
        List<College> collegeList = collegeService.finAll();

        model.addAttribute("collegeList", collegeList);
        model.addAttribute("teacherList", list);

        return "admin/addCourse";
    }

    // 添加课程信息处理
    @RequestMapping(value = "/addCourse", method = {RequestMethod.POST})
    public String addCourse(CourseCustom courseCustom, Model model) throws Exception {

        Boolean result = courseService.save(courseCustom);

        if (!result) {
            model.addAttribute("message", "课程号重复");
            return "error";
        }


        //重定向
        return "redirect:/admin/showCourse";
    }

    // 修改教师信息页面显示
    @RequestMapping(value = "/editCourse", method = {RequestMethod.GET})
    public String editCourseUI(Integer id, Model model) throws Exception {
        if (id == null) {
            return "redirect:/admin/showCourse";
        }
        CourseCustom courseCustom = courseService.findById(id);
        if (courseCustom == null) {
            throw new CustomException("未找到该课程");
        }
        List<TeacherCustom> list = teacherService.findAll();
        List<College> collegeList = collegeService.finAll();

        model.addAttribute("teacherList", list);
        model.addAttribute("collegeList", collegeList);
        model.addAttribute("course", courseCustom);


        return "admin/editCourse";
    }

    // 修改教师信息页面处理
    @RequestMapping(value = "/editCourse", method = {RequestMethod.POST})
    public String editCourse(CourseCustom courseCustom) throws Exception {

        courseService.upadteById(courseCustom.getCourseid(), courseCustom);

        //重定向
        return "redirect:/admin/showCourse";
    }

    // 删除课程信息
    @RequestMapping("/removeCourse")
    public String removeCourse(Integer id) throws Exception {
        if (id == null) {
            //加入没有带教师id就进来的话就返回教师显示页面
            return "admin/showCourse";
        }
        courseService.removeById(id);

        return "redirect:/admin/showCourse";
    }

    //搜索课程
    @RequestMapping(value = "selectCourse", method = {RequestMethod.POST})
    private String selectCourse(String findByName, Model model) throws Exception {

        List<CourseCustom> list = courseService.findByName(findByName);

        model.addAttribute("courseList", list);
        return "admin/showCourse";
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

