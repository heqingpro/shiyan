package com.cn.sys.user.dao;


import com.cn.sys.user.pojo.Queue;

public interface QueueDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Queue record);

    int insertSelective(Queue record);

    Queue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Queue record);

    int updateByPrimaryKey(Queue record);
}