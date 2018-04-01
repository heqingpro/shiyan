package com.cn.sys.user.dao;

import java.util.List;

import com.cn.sys.user.pojo.Student;
import com.cn.sys.user.pojo.PagingVO;


public interface StudentDao {
    int deleteByPrimaryKey(String name);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String name);
    
    Student selectByNumber(String number);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int addStudent(Student student);
    
    //分页查询学生信息
    List<Student> findByPaging(PagingVO pagingVO) throws Exception; 
    
    //查询学生数量
    int countStudent();
    
    //
    Student selectById(Integer id);
    
    void deleteById(Integer id);
}