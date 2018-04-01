package com.cn.sys.user.service;

import java.util.List;

import com.cn.sys.user.pojo.Lab;

public interface LabService {
	public Lab getNameByNumber(String Number);
	
	List<Lab> findByPaging(Integer toPageNo) throws Exception;
	
	List<Lab> findByPagingTeacher(Integer toPageNo) throws Exception;

	int save(Lab lab);

	//根据id获取学生信息
	Lab selectById(Integer id) throws Exception;

	int getCountLab() throws Exception;

	List<Lab> findAll();

	//根据id个更新学生信息
	void updateById(Integer id, Lab lab) throws Exception;

	void removeById(Integer id) throws Exception;

	List<Lab> selectByName(String name);

}
