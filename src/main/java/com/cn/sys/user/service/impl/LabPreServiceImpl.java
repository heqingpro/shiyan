package com.cn.sys.user.service.impl;

import com.cn.sys.user.dao.StudentDao;
import com.cn.sys.user.pojo.LabPre;
import com.cn.sys.user.pojo.PagingVO;
import com.cn.sys.user.service.LabPreService;
import com.cn.sys.user.dao.LabPreDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LabPreServiceImpl implements LabPreService {
    @Resource
    private LabPreDao labPreDao;
    @Resource
    private StudentDao studentDao;

    @Override
    public List<LabPre> findByPaging(String name,Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);
        String number = studentDao.selectByPrimaryKey(name).getNumber();
        List<LabPre> list = labPreDao.findByPaging(number,pagingVO);

        return list;
    }

    @Override
    public LabPre selectById(Integer id){
        return labPreDao.selectByPrimaryKey(id);
    }
}
