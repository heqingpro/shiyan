package com.cn.sys.user.service;

import com.cn.sys.user.pojo.LabResult;

import java.util.List;

public interface LabResultService {
    void save(LabResult labResult);
    List<LabResult> findByPaging(String name,Integer page)throws Exception;
    LabResult getById(Integer id);
    void updatePicture(Integer id,String picture);
}
