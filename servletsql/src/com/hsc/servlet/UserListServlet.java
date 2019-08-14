package com.hsc.servlet;

import com.hsc.dao.IUserDao;
import com.hsc.entity.User;
import com.hsc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserListServlet",urlPatterns = "/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 打印输出
         * 解决response输出中文乱码
         */
        response.setContentType("text/html;charset=utf8");

        // 1.获取输出流
        PrintWriter writer = response.getWriter();

        // 2.创建sqlSession，数据库会话对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 3.得到代理对象mapper
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4.执行查询函数功能，获取数据
        List<User> users = userDao.findAllUsers();

        // 5.遍历数据，按格式输出到浏览器
        writer.write("<table border='1px solid darkblue'>");
        // 表头
        writer.write("<tr>");
        writer.write("<th>编号</th>");
        writer.write("<th>姓名</th>");
        writer.write("<th>生日</th>");
        writer.write("<th>性别</th>");
        writer.write("<th>家庭住址</th>");
        writer.write("</tr>");
        for (User user : users) {
            writer.write("<tr>");
            writer.write("<td>"+user.getId()+"</td>");
            writer.write("<td>"+user.getUsername()+"</td>");
            writer.write("<td>"+user.getBirthday()+"</td>");
            writer.write("<td>"+user.getSex()+"</td>");
            writer.write("<td>"+user.getAddress()+"</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");

        // 6.关闭会话
        MybatisUtils.closeSession(sqlSession);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
