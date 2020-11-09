package com.yg.listener.servletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 请求监听
 */
public class LoginRequestListener implements ServletRequestListener, ServletContextAttributeListener {

    private int count = 0;
    public ServletContext servletContext = null;

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request请求销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request请求创建");
        servletContext = servletRequestEvent.getServletContext();
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        String address = servletRequest.getRemoteAddr();
        System.out.println("当前请求访问地址：" + address);
        count++;
        this.servletContext.setAttribute("reqNum", count);
    }
}
