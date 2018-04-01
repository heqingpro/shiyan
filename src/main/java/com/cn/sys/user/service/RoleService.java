package com.cn.sys.user.service;

import com.cn.sys.user.pojo.Role;

/**
 *  Role 权限表Service层
 */
public interface RoleService {

    Role findByid(Integer id) throws Exception;

}
