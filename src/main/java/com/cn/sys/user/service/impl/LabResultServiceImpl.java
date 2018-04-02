package com.cn.sys.user.service.impl;

import com.cn.sys.user.dao.LabResultDao;
import com.cn.sys.user.dao.StudentDao;
import com.cn.sys.user.pojo.LabResult;
import com.cn.sys.user.pojo.PagingVO;
import com.cn.sys.user.service.LabResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LabResultServiceImpl implements LabResultService {
    @Autowired
    private LabResultDao labResultDao;
    @Resource
    private StudentDao studentDao;
    @Override
    public void save(LabResult labResult){
        labResultDao.insertSelective(labResult);
    }
    @Override
    public List<LabResult> findByPaging(String name,Integer toPageNo)throws Exception{
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        String number = studentDao.selectByPrimaryKey(name).getNumber();
        List<LabResult> list = labResultDao.findByPaging(number,pagingVO);
        return list;
    }
    @Override
    public LabResult getById(Integer id){
        return labResultDao.selectByPrimaryKey(id);
    }
    @Override
    public void updatePicture(Integer id,String picture){
        labResultDao.updatePicture(id,picture);
    }
}
