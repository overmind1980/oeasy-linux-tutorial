---
show: step
version: 1.0
enable_checker: true
---

# 动态网页

### 回忆

- 上次在tomcat搭建了servlet用来访问postgres数据库
- 在webapps下面的WEB-INF/web.xml中
	- 建立了 url-pattern 和 servlet-name 之间的关系
	- 建立了 servlet-name 和 servlet-class 之间的关系
- 制作了 servlet 的 class 并且再浏览器中访问
	- 这样就可以在浏览器查看 select 语句的结果了
	- 不过每次修改代码都要重启 tomcat 这太麻烦了
	- 我想要不重启 tomcat 自动加载 class
- 可以么？🤔

### 搜索

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211122-1637544800324)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211122-1637544949312)

- 既然如此，我们就新建META-INF文件夹
- 并新建context.xml

### context.xml

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211122-1637545153309)

- 我们这样修改了 ./META-INF/context.xml 
	- META-INF 元信息 
		- 位于oeasy这个app的根下
	- context 就是上下文
	- 核心信息就是reloadable="true"

```xml
<?xml version='1.0' encoding='utf-8'?>
<Context reloadable="true">
	<WatchedResource>WEB-INF/web.xml</WatchedResource>
	<WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>
</Context>
```
- 看起来不但可以自动加载class
- 还能自动加载web.xml
- 保存了这个文件之后还是需要重启一下tomcat的
- 然后试一试

### 动手试试

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211122-1637586498418)

- 启动起来tomcat之后
- 对于SelectServlet.java进行小小的修改
- 然后重新编译了class文件
- 可以看到无需重启tomcat就可以自动加载class文件

### 官方帮助什么说法呢？

- https://tomcat.apache.org/tomcat-10.0-doc/config/context.html

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211122-1637587157431)

### 具体说明

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211122-1637587183512)

- 这个方式叫做Hot-Reload热加载

### Hot-Reload热加载
- class变了
- 容器自动加载这个修改了的class
- 这有很多好处
	- tomcat不会随意重启
		- 因为你也不知道tomcat别的webapps里面跑的到底是什么
		- 是不是有用户在做非常重要的操作
	- 提高了开发效率
		- 直接javac编译之后就可以自动加载到web容器中
		- 浏览器可以自动更新

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211122-1637588559848)

- 现在很多语言都支持这种更高效的方式
	- 不过他是一步步进化过来的
- 完成这个活的一般不是网页开发工程师
	- 而是系统管理员
- 这两者有什么区别呢？

### Web Developer
- Web Developer(网站应用开发工程师/程序员)
- 主要负责写程序代码
- 当然更细分可以分成前端和后端

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220601-1654052796675)

- 前端负责界面美化、适配、前台交互

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220601-1654053079432)

- 后端负责写业务逻辑
- 比如写这个servlet程序
- 然后编译、调试、测试等等

### System Administrator

- 系统管理员管理着整个系统的运行
	- 责任特别重大

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220601-1654053633293)

- 系统管理员是掌握着系统root权限的大总管
	- 给开发程序员等分配权限
	- 开发程序员想要执行或者写点什么都要跟系统管理员要权限
	- 如果给了他们不必要的权限就会出现不必要的问题 
- 控制裸机系统和应用的配置
	- 备份
	- 升级
	- 优化
- 控制网络的配置
	- 虚拟化
	- 集群
	- 负载均衡
- 除此之外
	- 系统管理员还有个更重要的任务


### 攒人品

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220601-1654054110895)

- 维护运气值
	- 请有法力的人士
	- 为集群和整个网络祈祷

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220601-1654054146475)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220601-1654054160576)

### 总结
- 我们这次研究了不重启tomcat服务器
	- 自动加载新编译的class的方式
	- 这种方式叫做热加载
		- 主要就是在用户的webapp根下
		- 添加META-INF文件夹
		- 然后在里面添加context.xml
			- 设置本webapp为支持hot-reload热加载的
- 除了查询数据之外
- 应该还有增删改
- 都可以做么？🤔
- 下次再说！👋

