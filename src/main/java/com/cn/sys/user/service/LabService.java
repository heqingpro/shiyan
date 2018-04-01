package com.cn.sys.user.service;

import java.util.List;

import com.cn.sys.user.pojo.Lab;
public interface LabService {
	public Lab getNameByNumber(String Number);
	
	List<Lab> findByPaging(Integer toPageNo) throws Exception;
	
	List<Lab> findByPagingTeacher(Integer toPageNo) throws Exception;

}
