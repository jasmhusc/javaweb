package com.hsc.lifecircle;

import javax.servlet.*;
import java.io.IOException;
/*
 * 面试题：
 *   1.请说出servlet生命周期相关方法
 *       init方法
 *       service方法
 *       destroy方法
 *   2.servlet对象什么时候创建的？
 *       默认第一次调用时候创建，服务器创建的
 *   3.servlet对象创建了几次？
 *       只创建一次，全局唯一，单例模式对象，节省内存
 *   4.servlet默认是在第一次访问时创建，能修改为启动时创建？
 *       可以的,设置loadOnStartup的值为1~6的一个值代表服务器启动时创建
 *       值越小代表越先创建
 * */
public class LifeCircle implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
