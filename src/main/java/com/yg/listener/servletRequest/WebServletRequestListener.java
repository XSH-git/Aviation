package com.yg.listener.servletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * 请求监听器
 */
@WebListener
public class WebServletRequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    private int requestCount = 0;
    public ServletContext servletContext = null;
    /**
     * request销毁
     * @param servletRequestEvent
     */
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request销毁");
    }

    /**
     * request初始化
     * @param servletRequestEvent
     */
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request创建！");
        requestCount++;
        servletContext = servletRequestEvent.getServletContext();
        servletContext.setAttribute("requestCount", requestCount);
    }


    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
