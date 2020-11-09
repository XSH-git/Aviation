package com.yg.listener.servletContext;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 上下文监听程序
 */
public class LoginContextListener implements ServletContextListener, ServletContextAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Listener执行了contextInitialized方法！");
        System.out.println("ServletContext创建了,web项目启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Listener执行了contextDestroyed方法！");
        System.out.println("ServletContext销毁了，web项目停止");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("Listener执行了attributeAdded方法！");
        System.out.println("ServletContext添加参数");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("Listener执行了attributeRemoved方法！");
        System.out.println("ServletContext删除参数");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("Listener执行了attributeReplaced方法！");
        System.out.println("ServletContext替换参数");
    }
}
