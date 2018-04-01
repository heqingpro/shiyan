package com.cn.sys.user.service.impl;

import com.cn.sys.user.dao.UserloginDao;
import com.cn.sys.user.pojo.Userlogin;
import com.cn.sys.user.pojo.UserloginExample;
import com.cn.sys.user.service.UserloginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userloginServiceImpl")
public class UserloginServiceImpl implements UserloginService {

    @Autowired
    private UserloginDao userloginDao;


    public Userlogin findByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        List<Userlogin> list = userloginDao.selectByExample(userloginExample);

        return list.get(0);
    }

    public void save(Userlogin userlogin) throws Exception {
        userloginDao.insert(userlogin);
    }

    public void removeByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginDao.deleteByExample(userloginExample);
    }

    //@Override
    public void updateByName(String name, Userlogin userlogin){
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginDao.updateByExample(userlogin, userloginExample);
    }

}
