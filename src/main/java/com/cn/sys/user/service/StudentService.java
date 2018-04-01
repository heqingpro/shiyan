package com.cn.sys.user.service;

import java.util.List;

import com.cn.sys.user.pojo.Student;

public interface StudentService {
	public Student selectByName(String name);
	public Student selectByNumber(String number);
	public int delectByName(String name);
	public void regist(Student student);
	public boolean login(Student student);
	
	List<Student> findByPaging(Integer toPageNo) throws Exception;
    //获取学生总数
    int getCountStudent() throws Exception;
    
    //根据id获取学生信息
    Student selectById(Integer id) throws Exception;
    //根据id个更新学生信息
    void updataById(Integer id, Student student) throws Exception;
    //根据id删除学生信息
    
    public void removeById(Integer id) throws Exception;
    
    //根据名字模糊查询
    // List<Student> findByName(String name) throws Exception;

}
