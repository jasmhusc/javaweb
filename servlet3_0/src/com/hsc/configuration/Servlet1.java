package com.hsc.configuration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
*   模糊匹配使用一个通配符“*”号,代表0到多个任意字符，只有这一个通配符。
    通配符匹配使用只有2种方式：
	1.前缀匹配，必须以“/”开头，以“/*”结尾
	  例子，/abc/*,只要用户访问时/abc/开头都可以匹配到
	2.后缀匹配，必须以“*”开头，以“.”扩展名方式结束使用
	  例子,*.do，只要用户访问时以.do结尾都可以匹配到

	urlPatterns属性设置有2种方式
	    设置一个url：urlPatterns = "/UrlPatternServlet"
	    设置多个url：urlPatterns = {"/UrlPatternServlet","xxx","xxx",...}
 */
@WebServlet(name = "Servlet1",urlPatterns = {"/Servlet1","/*"})
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取输出流
        ServletOutputStream out = resp.getOutputStream();

        // 输出
        out.write("Servlet1".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
