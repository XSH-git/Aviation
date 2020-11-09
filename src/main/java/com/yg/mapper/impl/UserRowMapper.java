package com.yg.mapper.impl;

import com.yg.mapper.AllRowMapper;
import com.yg.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements AllRowMapper<User> {

    @Override
    public User getRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String realname = resultSet.getString("realname");
        String sex = resultSet.getString("sex");
        String mobile = resultSet.getString("mobile");
        String email = resultSet.getString("email");
        int role = resultSet.getInt("role");
        int userStatus = resultSet.getInt("userstatus");

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRealName(realname);
        user.setSex(sex);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setRole(role);
        user.setUserStatus(userStatus);

        return user;
    }
}
