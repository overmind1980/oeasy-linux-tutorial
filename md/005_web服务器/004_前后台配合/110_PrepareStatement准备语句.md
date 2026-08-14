---
show: step
version: 1.0
enable_checker: true
---

# 封装数据库连接

### 回忆
- 上次把数据库给封装了一层
	- 新建了一个类DBConUtil 
- 好处是
	- 较少代码量
	- 替换数据库用户名密码变得很方便
- 这个类里面提到的
	- Conn、Statement、ResultSet都见过
	- PrepareStatement究竟是什么?
	- 怎么用呢？🤔

### 搜索

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220428-1651117845616)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220428-1651117856008)

### 修改

- 要执行下面的sql语句

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220428-1651118329289)

- 原始的SelectServlet.java

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220428-1651118391819)

- 查询结果

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651635235790)

- 现在在此基础上添加PrepareStatement代码

### 查询

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651635466146)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651635447589)

### 代码

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651646914148)

- 这次在statement之外
- 增加了PrepareStatement
	- ? 就是占位符
	- PrepareStatment有什么用呢？

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651647082835)

- PrepareStatment会在?两侧自动加上单引号(')
	- 从输出的两句sql语句中
	- 看不出prepare有什么优势啊
- 去jdk的官方文档看看究竟什么是PrepareStatement

###  官网

- https://jdk.java.net/18/
	- 找到jdk18的api地址

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651648084257)

### api

- https://docs.oracle.com/en/java/javase/18/docs/api/index.html

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651648187178)

### 描述

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651648292902)

- 我们可以从中找到PrepareStatement

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651648354873)

### 执行
- 生成这个PrepareStatement靠的是
	- connection执行prepareStatement方法

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651648677347)

- 这个函数
	- 通过预编译的方法
	- 优化了参数化的sql语句
	- 如果驱动程序支持预编译
	- 这个方法会先向数据库发送预编译
- 总之
	- 就是对于sql语句执行过程进行了优化
	- 而且
- 怎么注入呢？

### sql注入

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651649073949)

- 首先构造一个查询

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651649836929)

- 其中
	- --说明后面的都是注释，可被忽略
	- 用单引号封闭了前面之后
	- 后面想干什么都行
		- 延迟
		- 删数据
		- 删表
		- 删库
- 了解了这个语句
	- 我们如何写程序呢？

### 代码 

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651649973480)

- 红框处构建了这个结构
- 我们来看看执行结果

### 结果 

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651650098004)

- 我们可以看到Statement和PrepareStatement的区别
- PrepareStatement做了一些准备和预处理
- 所以一定要

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651650237719)

### PrepareStatement

- PreparedStatement
	- 写参数化查询并预编译
- PreparedStatement有两个好处
	- 预编译比Statement能获得更好的性能
	- 可以阻止常见的SQL注入式攻击
- 那么我们就选择PreparedStatement而不是Statement

```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class SelectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><body>");
        Connection c = null;
        try {
            c = DBConUtil.getConn();
            c.setAutoCommit(false);
			String SearchName = "";
			String sql2 = "select * from login where username like ?";
			PreparedStatement pstmt = c.prepareStatement(sql2);
			pstmt.setString(1,"%"+SearchName+"%");
			ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                out.print(username+":"+password+"<br/>");
			}
			DBConUtil.close(c,pstmt,null,rs);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        out.println("select query is ok!<br/>");
        out.println("</body></html>");
    }
}
```
## 总结

- 经过比较，PreparedStatement比Statement具有两个优势
	- 预编译比Statement能获得更好的性能
	- 可以阻止常见的SQL注入式攻击
- 以后尽量使用PreparedStatement
	- PreparedStatement是使用DBConUtil 得到的connection生成的
	- 用户名、密码、数据连接都在DBConUtil里面
	- 如果别人看到了DBConUtil.java也可以得到相应的连接数据的方法
- 能否有个办法
	- 在oeasy这个app的外面配置好数据库连接
	- 这样
		- 不光oeasy这个app
		- 其他的应用只要使用这种连接
	- 就可以直接连接到数据库
	- 一概全改
	- 而且更安全
- 有可能么？🤔
- 下次再说！👋