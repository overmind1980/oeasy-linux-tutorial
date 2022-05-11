---
show: step
version: 1.0
enable_checker: true
---

# 动态网站tomcat+数据库postgres
## 回顾
- 上次了解了	
	- 什么是后端
	- 什么又是前端？🤔
- 前端
	- 网页设计做图切片
	- 前端javascript代码
- 后端
	- java语言
	- 应用服务器使用
	- 后台数据库操作
- 可是这后台数据库究竟如何操作？
- 我希望能用java访问postgresql数据库

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
         System.exit(0);
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

- drive驾驶
- 最早来自于驾驶马车
- 后来工业革命后也指蒸汽机车

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651358573525)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651357981528)

- 仪表盘的来历
- driver在电脑系统中也指驱动
	- 硬件的驱动程序
	- 文件系统驱动器
	- 主动控制引擎的人
- 那么什么是引擎呢？

### 引擎
![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651358775158)

- 引擎(engine)也叫发动机
- 能够让一个火车动起来的主动力来源
- 各种引擎
	- 搜索引擎
	- 游戏引擎
	- 渲染引擎
- 玩引擎的人是什么人呢？

### 工程师

- engineer

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651357965424)

- 这些搞engine的人

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651359321990)

- 形成了专业术语、行业

### 不同的engineering

- 电子工程
- 车辆工程
- 软件工程
- 数据工程

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651359804781)

- 如何理解通过servlet链接postgres

### engine

- 我们现在就是数据库工程师
- 需要选择一个数据库引擎

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220501-1651360247590)

- 我们选择postgresql数据库
- 然后就要想办法让这个引擎运行起来
- 也就是找这个引擎(engine)的驱动(driver)

### 下载驱动

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631441201792)

- 下载postgresql jdbc 4.2 driver

```
sudo wget https://jdbc.postgresql.org/download/postgresql-42.3.1.jar
```
- 但是各位同学可能没有外网
- 我把他传到了github和gitee
- 进入和classes平级的lib目录
- 一般这里放置liberies 类库
- git clone http://github.com/overmind1980/tomcat10.git

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650889816560)

### 设置路径

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650890045037)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650890001100)

### 再次尝试

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650890063904)

- 再次尝试运行
- 原来是postgres没开

### 启动
- 如果没有装好postgres
- 就需要再重新装一下

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631442687451)

- 装好之后
	- sudo -u postgres psql
		- sudo管理员运行
		- -u postgres 用postgres这个用户的身份运行
		- psql postgres的数据库连接程序
- 回忆之前建立的database oeasy

### 建立数据库

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211120-1637413460340)

- 然后我们需要建表

### 建表

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650890595183)

- 我们在oeasy这个数据库里面建了表
- 并且插入数据
- 我们来查询一下

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211120-1637414088489)

### 再次运行

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211120-1637414206815)

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

- 注意有两个密码
	- 一个是数据库的postgres的密码
	- 一个是系统的postgres的密码
	- 我们用的是数据库的
- 那系统的有什么用呢
- 就是一般用户想用用postgres系统用户身份做事情的时候就会用到

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631444544416)

- 我们按照第一个方法来

### 修改密码

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650890875711)

- 我们把密码设置为oeasy@pg
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

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650891116349)

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
			c.setAutoCommit(false);

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

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210912-1631445442190)

### 反复其道

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
					"oeasy@pg");
			c.setAutoCommit(false);

			System.out.println("Pq Connection success!");
			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("select * from urls where topics like 's%'");
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
		System.out.println("Pg select query success!");
	}
}
```

- 注意数据库名
- 表名
- 字段名
- 数据类型
- 我是反复了好几次才成功
- 别着急

### 最终

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650891353563)

- engine is running！！！
- 现在需要我们把这个jdbc.java和OeasyServlet.java融合到一起
- 也就是在浏览器里面把postgres里的数据表展示出来

### 大厨

- web服务器(tomcat)是堂倌
- 这次我们跳过了堂倌
- 直接用java访问了后厨(数据库服务器)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220510-1652140315911/wm)

- 但是浏览器用户不能直接这么干
- 必须得让堂倌通知大厨
- 这又怎么做呢？

### 总结 🤨
- 这次我们编辑 Postgres.java 成功访问了 pq数据库
	- 首先要导入类库
	- 然后要开启数据库
	- 并了解数据库的用户名密码
	- 还要使用正确的sql语句
- 准备工作完毕
	- all parts accounted for.
	- 下一步就是要整合servlet
	- 在浏览器里面把页面显示出来
	- 客户通知堂倌
	- 让堂倌通知大厨
	- 后厨做好内容
	- 堂倌上菜
	- 客户吃上饭
- 这又怎么做呢？🤔
- 下次再说！👋


