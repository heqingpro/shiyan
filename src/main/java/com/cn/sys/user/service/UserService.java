package com.cn.sys.user.service;


import com.cn.sys.user.pojo.User;  
  
public interface UserService {  
    public User getUserById(int userId);
    public User getUserByName(String userName);
}