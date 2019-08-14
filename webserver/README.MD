### 软件架构

1. BS:Browser Server 浏览器-服务器模式。客户端使用浏览器来访问服务器。
```
1)	客户端使用的是浏览器，只要有浏览器就可以执行我们程序。
2)	服务器升级，客户端可以无缝升级，就可以直接使用最新的功能。
```

2. CS:Client Server 客户端-服务器模式。用户需要在本地电脑上安装客户端软件，再来访问服务器。
```
必须在本地电脑安装每一种客户端软件
如果服务器升级，每个客户端也需要升级。服务器会经常升级,导致客户端会经常进⾏升级并且安装。
```

### web资源
1. 浏览器能看到的所有数据都是web资源
2. 静态资源：浏览器访问的资源是服务器上的物理文件（html,jpg，png,js，css）
3. 动态资源：浏览器访问的资源是服务器运行的代码（java代码）产生的数据
4. 动态资源技术：servlet,JSP，asp.net，PHP，Python

### 浏览器与服务器的底层通信原理技术
1. 网络编程
2. MyTomcat模拟服务器

### windows常用命令
1. 启动服务器：startup.bat
2. tomcat端口：8080
3. 查看应用端口port和应用pid：netstat -nao
4. 查看占用8080的应用：netstat -nao | findstr "8080"

### 更改tomcat端口号
<font color="red">8080</font>修改为其他端口
```
<Connector port="8080" protocol="HTTP/1.1"
            connectionTimeout="20000"
               redirectPort="8443" />               
```

