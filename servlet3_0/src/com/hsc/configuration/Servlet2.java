package com.hsc.configuration;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    精准匹配：/Servlet2
    前缀匹配：*.html
 */
@WebServlet(name = "Servlet2",urlPatterns = {"/Servlet2","*.hmtl"})
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取输出流
        ServletOutputStream out = resp.getOutputStream();

        // 输出数据
        out.write("Servlet2".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
