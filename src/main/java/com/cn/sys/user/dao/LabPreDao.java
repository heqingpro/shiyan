package com.cn.sys.user.dao;

import com.cn.sys.user.pojo.LabPre;
import com.cn.sys.user.pojo.PagingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabPreDao{
    int deleteByPrimaryKey(Integer id);

    int insert(LabPre record);

    int insertSelective(LabPre record);

    LabPre selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabPre record);

    int updateByPrimaryKey(LabPre record);
    ////////
    List<LabPre> findByPaging(@Param("number") String number,@Param("pagingVO") PagingVO pagingVO) throws Exception;
}