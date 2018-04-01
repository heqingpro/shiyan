package com.cn.sys.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.sys.user.pojo.Userlogin;
import com.cn.sys.user.pojo.UserloginExample;

public interface UserloginDao{
    int deleteByPrimaryKey(Integer userid);

    int insert(Userlogin record);

    int insertSelective(Userlogin record);

    Userlogin selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Userlogin record);

    int updateByPrimaryKey(Userlogin record);
    
    List<Userlogin> selectByExample(UserloginExample example);
    
    int deleteByExample(UserloginExample example);
    
    int updateByExample(@Param("record") Userlogin record, @Param("example") UserloginExample example);
}