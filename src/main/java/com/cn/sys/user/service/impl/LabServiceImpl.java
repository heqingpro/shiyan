package com.cn.sys.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.sys.user.service.LabService;
import com.cn.sys.user.dao.LabDao;
import com.cn.sys.user.pojo.Lab;
import com.cn.sys.user.pojo.PagingVO;

@Service("labService") 
public class LabServiceImpl implements LabService {
	@Resource
	private LabDao labDao;
	@Override
	public Lab getNameByNumber(String Number){
		return this.labDao.selectByNumber(Number);
	}
	@Override
    public List<Lab> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<Lab> list = labDao.findByPaging(pagingVO);

        return list;
    }
	@Override
    public List<Lab> findByPagingTeacher(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<Lab> list = labDao.findByPagingTeacher(pagingVO);

        return list;
    }

    @Override
    public int save(Lab lab){
	    return labDao.insert(lab);
    }

    @Override
    public Lab selectById(Integer id) throws Exception{
	    return labDao.selectById(id);
    }

    @Override
    public int getCountLab() throws Exception{
	    return labDao.getCountLab();
    }

    @Override
    public List<Lab> findAll(){
	    return labDao.findAll();
    }

    //根据id个更新学生信息
    @Override
    public void updateById(Integer id, Lab lab) throws Exception{
	    labDao.updateById(lab);
    }

    @Override
    public void removeById(Integer id) throws Exception{
	    labDao.deleteById(id);
    }

    @Override
    public List<Lab> selectByName(String name){
	    return labDao.selectByName(name);
    }

}
