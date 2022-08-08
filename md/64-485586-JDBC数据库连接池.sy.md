---
show: step
version: 1.0
enable_checker: true
---

# 封装数据库连接

## 回忆

- jndi
	- java Naming and Directory Interface
	- 可以配置一些通用的信息
- 通过指定的四步
	1. 构建资源类com.mycompany.MyBean
	2. 声明资源引用
	3. 在代码中引用
	4. 配置资源工厂
- 经过这四步
	- 我们就为每个具体web应用配置一些通用资源
- 数据库连接貌似有专门的配置方法😲
- 怎么配置呢？🤔

### 文档

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651670506568)

- JDBC数据源属于jndi资源
- 这里面提到了一个connection pool的概念
	- 也就是数据库连接池
- 什么是数据库连接池的概念呢？
	- 我们先来看看什么是池(pool)

### 水池

- 池的概念我们经常听说
	- 流量池
	- 艺人池
	- 资金池

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220616-1655338141396)

- 这有点抽象啊
- 池来自于什么呢？

## pool


![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651670572324)

- 把水先蓄起来
- 想要用的时候直接就能用
- 就是水池

### 酒池

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651672985356)

- 把酒先蓄起来
- 想要用的时候直接就能用
- 就是酒池

### 电池

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651670830918)

- 把电先蓄起来
- 想用的时候直接就能用
- 就是电池

### 小便池

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220522-1653183199629)

- 把小便蓄起来
- 想用的时候直接就能用
- 就是小便池
- 啊，并不是...😶

### 数据库连接池

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651673447778)

- 把数据库连接先蓄起来
- 想用的时候直接就能用
- 就是数据库连接池
- 可是蓄数据库连接有什么用呢？

### 数据库连接

- Connection是一个类的对象
	- 每次实例化都要分配内存
	- 使用之后就要释放内存
	- 频繁的分配释放反而浪费系统资源
- 干脆先蓄着100个数据库连接
- 没有人来
	- 也先把内存分配了
	- 先占着位置
- 有人来
	- 就从池子里面拿一个现成的
	- 用完了放回到池子
	- 省的来回来去申请释放内存
- 这种预先蓄起来的方式
	- 就是池化
	- 类似的还有
		- 线程池
		- 字符串常量池
- 具体怎么配置JDBC数据源呢？

### 文档

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651673888008)

- tomcat默认的数据源是DBCP2连接池
- 方法是要写自己的资源工厂
- 这些方法都通用于各种数据库
- 后面的文档有专门介绍postgresql的数据库连接池配置方法
- 我们直接跳过去

### 第一步

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651674281640)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651674227924)

- 把pg的jdbc驱动下载到$CATALINA_HOME的lib下

### 第二步
![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651674588556)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651674867911)

- 配置资源上下文

### 第三步

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651674983340)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651674965141)

- 配置资源引用

### 第四步

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651675935769)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651675944498)

- 使用JDBC数据源
- 开始编辑ConnectionPool.java

### 代码

- 应用数据源连接池

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651676060739)

### 源码

- 修改后的代码

```java
import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import javax.sql.*;
import javax.naming.*;
public class ConnectionPool extends HttpServlet {
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
		try {
			InitialContext cxt = new InitialContext();
			if ( cxt == null ) {
				throw new Exception("Uh oh -- no context!");
			}

			DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/postgres" );

			if ( ds == null ) {
				throw new Exception("Data source not found!");
			}
			Connection c = ds.getConnection();
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
### 配置路由

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651676119839)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220504-1651676128106)

- 访问成功！！！

## 总结

- jdbc connection pool
	- jdbc 数据库连接池
	- 首先是一种池子
- 通过指定的四步
	1. 配置jdbc数据库连接池的jar包
	2. 资源配置(context.xml中设置关于pg的Resource)
	3. 在本应用的web.xml中使用相应的资源引用
	4. 在程序中使用jndi调用数据库连接资源
- 经过这四步我们就构建了一个可用的数据库连接池
- 我们用这个数据库连接池可以做怎样的操作呢
	- 比如删除？🤔
- 下次再说！👋

