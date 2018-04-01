package com.cn.sys.user.dao;

import java.util.List;

import com.cn.sys.user.pojo.Lab;
import com.cn.sys.user.pojo.PagingVO;

public interface LabDao {
    int deleteByPrimaryKey(String name);

    int insert(Lab record);

    int insertSelective(Lab record);

    Lab selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Lab record);

    int updateByPrimaryKey(Lab record);

	Lab selectByNumber(String number);
	
    //分页查询实验信息
    List<Lab> findByPaging(PagingVO pagingVO) throws Exception; 
    
    List<Lab> findByPagingTeacher(PagingVO pagingVO) throws Exception; 
}