package com.hsc.web;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.sql.Timestamp;

public class TestMyTomcat {

    // 测试自定义服务器
    public static void main(String[] args) throws IOException {
        // 创建服务器对象，端口8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println(new Timestamp(System.currentTimeMillis()) + "服务器启动");
        while (true) {
            //使用网络编程
            // 接受客户端请求
            Socket socket = serverSocket.accept();
            // 根据socket获取客户端信息
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println(new Time(System.currentTimeMillis()) + "用户" + inetAddress.getHostAddress() + "连接成功");

            // 创建一条线程处理客户端请求
            new MyTomcat(socket).start();
        }
    }
}
