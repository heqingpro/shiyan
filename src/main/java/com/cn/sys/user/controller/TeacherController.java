package com.cn.sys.user.controller;
import java.util.List;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  

import com.cn.sys.user.pojo.Teacher;  
import com.cn.sys.user.service.TeacherService;  
import com.cn.sys.user.pojo.PagingVO;
import com.cn.sys.user.service.LabService;
import com.cn.sys.user.pojo.Lab;

@Controller  
@RequestMapping("/teacher")  
public class TeacherController {
    @Resource 
    LabService labService; 
    @RequestMapping("/showLab")
    public String showLab(Model model, Integer page) throws Exception {

       List<Lab> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        pagingVO.setTeacherName("张老师");
        //设置总页数
         page=null;
        pagingVO.setTotalCount(5);//studentService.getCountStudent());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            if(list==null)
            list=labService.findByPagingTeacher(1);
        } else {
            pagingVO.setToPageNo(page);
           list = labService.findByPagingTeacher(page);
        }

        model.addAttribute("labList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "teacher/showLab";

    }

}
