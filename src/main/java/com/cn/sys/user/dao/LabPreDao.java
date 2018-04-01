package com.cn.sys.user.dao;

import com.cn.sys.user.pojo.LabPre;

public interface LabPreDao {
    int deleteByPrimaryKey(String stuNum);

    int insert(LabPre record);

    int insertSelective(LabPre record);

    LabPre selectByPrimaryKey(String stuNum);

    int updateByPrimaryKeySelective(LabPre record);

    int updateByPrimaryKey(LabPre record);
}