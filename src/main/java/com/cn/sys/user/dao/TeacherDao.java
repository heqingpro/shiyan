package com.cn.sys.user.dao;

import com.cn.sys.user.pojo.PagingVO;
import com.cn.sys.user.pojo.Teacher;

import java.util.List;

public interface TeacherDao {
    int deleteByPrimaryKey(String name);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String name);

    Teacher selectByNumber(String number);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    int addTeacher(Teacher student);

    //分页查询学生信息
    List<Teacher> findByPaging(PagingVO pagingVO) throws Exception;

    //查询学生数量
    int countTeacher();

    //
    Teacher selectById(Integer id);

    void deleteById(Integer id);

    List<Teacher> findByName(String name);
}