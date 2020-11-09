package com.yg.service;

import com.yg.pojo.User;

import java.util.Map;

public interface UserService {
    /*注册逻辑处理*/
    public int userRegist(User user);
    /*登录逻辑处理*/
    public User userLogin(String username, String password);
    /*查询所有用户信息*/
    public Map<String , Object> queryUsers();
    /*根据用户名查询信息*/
    public  User queryUserByName(String username);






}

