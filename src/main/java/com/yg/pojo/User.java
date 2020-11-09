package com.yg.pojo;

/**
 * 用户（没有用户状态）
 */
public class User {
    /*id:用户编号*/
    private Integer id;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*真实姓名*/
    private String realname;
    /*性别 女0 男1*/
    private String sex;
    /*邮箱*/
    private String email;
    /*手机号*/
    private String mobile;
    /*用户类型：1-管理员用户，2-普通用户*/
    private Integer role;
    /*用户状态：1-正常，2-删除*/
    private Integer userstatus;

    public User() {
    }

    public User(Integer id, String username, String password, String realname, String sex, String email, String mobile, Integer role, Integer userstatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.email = email;
        this.mobile = mobile;
        this.role = role;
        this.userstatus = userstatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realname;
    }

    public void setRealName(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getUserStatus() {
        return userstatus;
    }

    public void setUserStatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", userstatus='" + userstatus + '\'' +
                '}';
    }
}

