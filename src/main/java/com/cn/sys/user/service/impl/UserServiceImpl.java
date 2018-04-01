package com.cn.sys.user.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
  

import com.cn.sys.user.dao.UserDao;  
import com.cn.sys.user.pojo.User;  
import com.cn.sys.user.service.UserService;  
  
@Service("userService")  
public class UserServiceImpl implements UserService {  
    @Resource  
    private UserDao userDao;  
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }
    @Override 
    public User getUserByName(String userName){
    	return this.userDao.selectByName(userName);
    }
}