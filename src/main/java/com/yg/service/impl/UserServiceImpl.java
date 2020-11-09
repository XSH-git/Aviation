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
//        if (user.getUsername() != null || user.getPassword() != null || user.getRealName() != null || user.getEmail() != null || user.getMobile() != null  ) {
//            return result;
//        }
        if (user != null ){
            return result;
        }

        return -1;
    }

    @Override
    public int userLogin(String username, String password) {

        //调用dao层数据，获取username和password
        User user = userDao.selectUserByNameAndPwd(username,password);
        if (user != null && user.getPassword().equals(password)){
            return user.getId();
        }
        return -1;
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