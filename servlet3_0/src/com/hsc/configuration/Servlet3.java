package com.hsc.configuration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/Servlet3",urlPatterns = {"/Servlet3","/demo/servlet3"})
public class Servlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取输出流
        ServletOutputStream out = resp.getOutputStream();

        // 输出数据
        out.write("Servlet3".getBytes());
    }
}
