package com.yg.listener.servletContext;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * 上下文监听器   ServletContext  --  ServletConfig（Servlet）
 * ServletContextListener
 */
//@WebListener
public class WebServletContextListener implements ServletContextListener, ServletContextAttributeListener {

    public ServletContext servletContext = null;
    /**
     * 初始化方法--ServletContext对象创建（ServletContext生命周期，伴随web始终。）
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Web项目启动！");
        servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("msg", "web start success!");
    }

    /**
     * 销毁方法--ServletContext对象销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Web项目停止！");
        servletContext = null;
    }

    /**
     * 监听ServletContext对象添加参数
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext对象添加了参数");
    }

    /**
     * 监听ServletContext对象移除参数
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext对象移除了参数");
    }

    /**
     * 监听ServletContext对象替换参数
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext对象替换了参数");
    }
}
