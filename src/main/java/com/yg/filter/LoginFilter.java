package com.yg.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录拦截
 * 1.实现Filter接口
 * 2.实现doFilter方法
 * 3.配置
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("登录拦截开始。。。。。。");
        //判断用户是否登录 session中是否存在用户信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        //获取服务路径        http:------>       /工程名--->
        String path = request.getRequestURI();  //getContextPath() 获得工程路径
        System.out.println("path:" + path);
        //用户没有登录+请求不是CSS+请求不是js+请求不是登录页、注册页+请求不是LoginServlet
        //拦截未登录状态的  （那些资源非登录状态就可以请求：css、js、login.jsp、regist.jsp、LoginServlet
        //    /ProjectDemo/login.jsp
        if (username == null && !path.contains("css/") && !path.contains("js/") &&
                !path.contains("login.jsp") && !path.contains("regist.jsp") &&
                !path.contains("LoginServlet") && !path.contains("RegistServlet") &&
                !path.contains("AuthImage")) {
            //访问的内容是需要登录才能访问的资源
            request.setAttribute("msg", "请登录！");
            request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
