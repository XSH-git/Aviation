package com.yg.service.impl;

import com.yg.dao.UserDao;
import com.yg.pojo.User;
import com.yg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }
//    @Override
//    public int registerUser(User user) {
//        //业务处理，补全参数
//        user.setRole(2);
//        user.setUserStatus(1);
//        //调用dao层数据
//        int  result = userDao.insertUser(user);
//
//        return result;
//    }

    @Override
    public int userRegist(User user) {
        //业务处理，补全参数
        user.setRole(2);
        user.setUserStatus(1);
        user.setSex("1");
        //调用dao层数据
        int  result = userDao.insertUser(user);

        return result;
    }

    @Override
    public User userLogin(String username, String password) {

        //调用dao层数据
        User result = userDao.selectUserByNameAndPwd(username,password);
        return userDao.selectUserByNameAndPwd(username,password);
    }

    @Override
    public Map<String, Object> queryUsers() {
        return null;
    }

    @Override
    public User queryUserByName(String username) {
        return null;
    }
}