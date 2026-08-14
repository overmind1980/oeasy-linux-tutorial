---
show: step
version: 1.0
enable_checker: true
---

# 通过驱动连接postgres

## 回顾
- 我们设置了postgres引擎
- 添加了
	- 数据库
	- 数据表
	- 数据
- 但是这一切都是在postgres的客户端psql上完成的

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658022536351)

- 我们先试试恢复postgres中的数据

### 恢复数据库

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658022993335)


- 数据库结构和数据确实是可以一把恢复的
- 那我可以使用java来读写postgres数据库中的数据么？

### 搜索

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631441137230)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631441149209)


### 开始编程

- 把代码复制下来
- 然后回到classes
- 粘贴进入一个PostgresJdbc.java

```java
import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresJdbc {
   public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/testdb",
            "postgres", "123");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
      }
      System.out.println("Opened database successfully");
   }
}
```

- 注意公有类的类名和文件名一致
- 尝试编译

### 编译运行

- 编译没有遇到问题
- 但是运行遇到了问题

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211120-1637412762597)

- 首先的问题就是找不到驱动
- 提示需要一个postgresql-jdbc驱动
- 什么是驱动呢？

### 驱动

- driver驾驶员
- 最早来自于驾驶马车

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220521-1653122800305)

### 蒸汽机车

- 后来工业革命后也指蒸汽机车

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651358573525)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651357981528)

- 仪表盘的来历
	- 仪表盘的作用是监控引擎运行情况
- driver在电脑系统中也指驱动
	- 硬件的驱动程序
	- 文件系统驱动器
	- 主动控制引擎的人

### 下载驱动

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631441201792)

- 下载postgresql jdbc 4.2 driver

```
sudo wget https://jdbc.postgresql.org/download/postgresql-42.3.1.jar
```

- 但是各位同学可能没有外网
- 可以自己去网址下载下载
	- 再传到~/Code
	- 然后移动到/tomcat/lib
	- 一般这里放置liberies 类库
- 我把他传到了github和gitee
	- git clone http://github.com/overmind1980/tomcat10.git

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658023187522)

### 设置路径

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658023548402)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658023558728)

### 再次尝试

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650890063904)

- 再次尝试运行
- 原来可能是postgres没开

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658020472789)

### 再三运行

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658023733967)

- 编译可以通过
	- 现在的问题是password authentication
- 密码验证失败
- 先去源程序看看

### 源程序

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631444184189)

- 用户名是postgres应该没有问题
- 但是密码应该是什么？

### 搜索

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631444338028)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631444427459)

- 注意这两个密码
	- 一个是数据库中的的postgres账号的密码
		- 这个用来在默认端口5432连接数据库
		- 是数据库中postgres这个用户对应的密码
		- 是java程序通过驱动控制数据库的密码
	- 另一个是linux系统中的postgres用户的密码
		- 这个系统中的postgres用ssh来登录时用的密码
		- 是系统用户的密码
		- 可以在系统中用来登录postgres账号
	- 我们在java中用的是数据库中postgres用户的密码
- 这个如何修改呢？


### 如何修改
![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631444544416)

- 这是修改系统中postgres账号密码的方法
- 我们去修改数据库中postgres的密码

### 查询帮助

- `:h ALTER ROLE`

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220721-1658366064210)

### 修改数据库中postgres的密码

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220721-1658366367876)

- 我们把密码设置为oeasy@pg
- 但是这个密码可以作为系统postgres用户的登录密码么？
- 我们去试试

### 尝试登录

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220721-1658367564965)

- 这个账号是不能用来登录系统的postgres账号的
- 那如果我们想要登录系统的postgres账号应该怎么办？

### 修改系统中postgres的密码

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220721-1658367868379)

- 看起来系统的密码是在系统里面可以登陆的
	- 废话！😄
- postgres数据库中的postgres用户有什么作用呢？

### 修改程序

- 然后去修改PostgresJdbc.java源程序

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211120-1637414533817)

### 再次编译运行

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211120-1637414580434)

- 这次密码认证过去了
- 但是卡在了数据库的名称
- 现在这个是testdb
- 我们的database是oeasy
- 修改源码

### 修改

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658017046429)

- 编译运行
### 运行结果

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211120-1637414717663)

- 终于成功啦！！！！！！
- 我想用一些快乐的词汇
- 但是我忍住了
- 我哭了
- 现在还不是庆祝的时候
- 我想把urls表里面的数据查询出来

### 搜索

- 搜索能力是很重要
- 真正有主见的人
- 都是会搜索的
- 相信世界也相信自己

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631445170233)

- 感觉自己充满了能量

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631445186971)

- 应该就是这样子可以查询数据库 
- 把3行到46行拿到我们的PostgresJdbc.java中

### 修改

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresJdbc {
	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/oeasy", "postgres",
					"oeasy@pq");
			System.out.println("Pq Connection success!");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from urls");
			while(rs.next()){
				String topic = rs.getString("topic");
				String url = rs.getString("url");
				System.out.print(topic+":"+url+"\n");
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Pq select query success!");
	}
}
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220717-1658024316982)

- 真的可以通过jdbc链接到数据库
- 然后得到数据
- 我们先去总结一下


### 总结 🤨
- 这次我们编辑 Postgres.java 成功访问了 pq数据库
	- 首先要导入类库
	- 然后要开启数据库
	- 并了解数据库的用户名密码
	- 要用正确的连接、库、表、字段
	- 还要使用正确的sql语句
- 真的只要照猫画虎改代码就可以连接数据库了
- 这种方式是通过jdbc方式进行的
- 什么是jdbc呢？🤔
- 下次再说！👋

