package com.cn.sys.user.service;



import com.cn.sys.user.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher selectByName(String name);
    public void regist(Teacher teacher);
    public boolean login(Teacher teacher);

    public int save(Teacher teacher);

    List<Teacher> findByPaging(Integer toPageNo) throws Exception;

    //获取教师总数
    int getCountTeacher() throws Exception;

    //根据id获取教师信息
    Teacher selectById(Integer id) throws Exception;

    //根据id个更新教师信息
    void updataById(Integer id, Teacher teacher) throws Exception;

    //根据id删除教师信息
    public void removeById(Integer id) throws Exception;

    List<Teacher> findByName(String name);

}
