package com.hsc.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 使用多线程的方式创建一个Web容器
 */
public class MyTomcat extends Thread {
    //创建一个成员变量
    private Socket socket;
    //创建一个构造方法
    public MyTomcat(Socket socket){
        this.socket = socket;
    }
    //每个线程处理资源的代码
    @Override
    public void run() {
        try {
            //将本地的网页发送到浏览器，IE
            //创建文件输入流
            FileInputStream in = new FileInputStream("webserver/img/mn.png");
            OutputStream out = socket.getOutputStream();
            byte[] brr = new byte[1024];
            int len;
            while ((len = in.read(brr)) != -1){
                out.write(brr,0,len);
            }
            // 关闭资源
            out.close();
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
