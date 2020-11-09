package com.yg.controller;

import com.yg.pojo.User;
import com.yg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
        System.out.println("UserController");
    }



    @RequestMapping(value = "registerUser",method = RequestMethod.POST)
    public String registerUser(User user , Map<String,Object> map, HttpServletRequest request) {
        //参数校验
        System.out.println("用户名唯一性，密码格式，Mobile格式，Email格式");
        String msg = "regist success!";
        String code = "200";

        //调用Service层进行业务处理
        int result = userService.userRegist(user);

        //1.获取前端用户参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("repassword:" + repassword);
        System.out.println("mobile:" + mobile);
        System.out.println("email:" + email);

        //2.参数校验
        if (username == null || "".equals(username)) {
            msg = "用户名不能为空！";
            code = "500";
            map.put("msg", msg);
            map.put("code", code);
            return "register";
        }
        if (password == null || "".equals(password)) {
            msg = "密码不能为空！";
            code = "500";
            map.put("msg", msg);
            map.put("code", code);
            return "register";
        }
        if (!password.equals(repassword)) {
            msg = "两次密码不一致！";
            code = "500";
            map.put("msg", msg);
            map.put("code", code);
            return "register";
        }

        if(result != 1) {
            map.put("coede",500);
            map.put("message","fail");
            //新增失败返回注册页面
            return "register";
        }
        map.put("code",200);
        map.put("message","success");
        //新增成功返回登录页面
        return "login";
    }

//    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
//    public String loginUser(String username,String password , Map<String,Object> map) {
//        //参数校验
//        System.out.println("用户名唯一性，密码格式，Mobile格式，Email格式");
//
//
//        //调用Service层进行业务处理
//        int result = userService.userLogin(username,password);
//
//        if(result != 1) {
//            map.put("coede",500);
//            map.put("message","fail");
//            return  "register";
//        }
//        map.put("code",200);
//        map.put("message","success");
//        return "jsp/login";
//    }
}
