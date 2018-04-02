package com.cn.sys.user.service;

import com.cn.sys.user.pojo.LabPre;

import java.util.List;

public interface LabPreService {

    List<LabPre> findByPaging(String name,Integer page) throws Exception;

    LabPre selectById(Integer id);

}
