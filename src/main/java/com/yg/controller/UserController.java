package com.yg.controller;

import com.yg.pojo.User;
import com.yg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
        System.out.println("UserController");
    }

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(User user , Map<String,Object> map) {
        //参数校验
        System.out.println("用户名唯一性，密码格式，Mobile格式，Email格式");


        //调用Service层进行业务处理
        int result = userService.userRegist(user);

        if(result != 1) {
            map.put("coede",500);
            map.put("message","fail");
            return  "register";
        }
        map.put("code",200);
        map.put("message","success");
        return "jsp/login";
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
