package com.cn.sys.user.dao;

import com.cn.sys.user.pojo.LabResult;
import com.cn.sys.user.pojo.PagingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabResultDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LabResult record);

    int insertSelective(LabResult record);

    LabResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LabResult record);

    int updateByPrimaryKey(LabResult record);
    ////////
    List<LabResult> findByPaging(@Param("number") String number, @Param("pagingVO") PagingVO pagingVO) throws Exception;

    void updatePicture(@Param("id") Integer id,@Param("picture") String picture);
}