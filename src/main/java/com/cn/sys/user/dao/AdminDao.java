package com.cn.sys.user.dao;

import com.cn.sys.user.pojo.Admin;

public interface AdminDao {
    int deleteByPrimaryKey(String name);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}