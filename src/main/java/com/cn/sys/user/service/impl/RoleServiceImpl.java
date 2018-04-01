package com.cn.sys.user.service.impl;

import com.cn.sys.user.dao.RoleDao;
import com.cn.sys.user.pojo.Role;
import com.cn.sys.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role findByid(Integer id) throws Exception {
        return roleDao.selectByPrimaryKey(id);
    }
}
