package com.yg.dao;

import com.yg.pojo.User;

import java.util.List;

public interface UserDao {

    /*根据用户名和密码查询用户信息 ----login*/
    public User selectUserByNameAndPwd(String username, String password);

    /*插入一条用户数据*/
    public int insertUser(User user);
    /*更新用户信息*/
    public int updateUser(User user);
    /*根据用户Id 查找用户信息*/
    public User selectUserById(int id);
    /*查询所有用户*/
    public List<User> selectAllUser();
    /*删除用户*/
    public int deleteUser(User user);

    /*根据用户名查询用户信息*/
    public User selectUserByName(String username);
    /*分页查询用户*/
    public List<User> selectAllUser(int pageNo, int pageSize);
    /*根据Id 删除用户--逻辑删除*/
    public int deleteUser(String userId);
    /*根据用户id查询信息*/
    public User queryUserById(String userId);

}
