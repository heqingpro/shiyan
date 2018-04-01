package com.cn.sys.user.dao;

import com.cn.sys.user.pojo.Teacher;

public interface TeacherDao {
    int deleteByPrimaryKey(String name);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}