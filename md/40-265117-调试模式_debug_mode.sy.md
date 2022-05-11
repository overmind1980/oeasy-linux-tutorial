---
show: step
version: 1.0
enable_checker: true
---

# 调试模式
## 回顾 😌

- 我们上次搭建了开发环境
- 使用tmux建立了2个子标签页
	- 一个负责执行命令
	- 一个负责编辑文件
- 这里面的路由核心是web.xml
	- web.xml是从url路由到class的核心
	- web.xml是后端程序的核心
	- 出了错就层层排错
- 可是有这样一个问题
- 就是出了预想不到的错误
- 去哪里查看报错信息呢？🤔

### 搜索

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211123-1637637457953)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211123-1637637522007)

### web.xml

- 在tomcat10中
	- 找到conf/web.xml
	- 进行修改

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650885852801)

### 修改java源文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650886117367)

- 保存并编译
- 重启tomcat

### 验证


- 访问指定的url确实可以运行路由到的class
- class输出到控制台的流确实写入了logs/catalina.out中
- 我们打开看一下,日志是如何输出的

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650886452448)

- 所以可以在程序里面写一些调试信息了
- 最终可以在日志里面看到出错的位置

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650886531833)

### 刷新

- 在vim中:e可以刷新当前文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650886614223)

- 报错应该每个一行


### 修改

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650886878641)

- 2号窗口
	- 完成替换修改
	- 保存并编译
- 0号窗口
	- 重启服务器
	- 并打开网页
- 1号窗口
	- 查看日志

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220425-1650886983915)

- 这些都是在后端完成的

### 总结 🤨
- 这次搭建了debug的开发环境
	- 可以在程序里面向日志中输出debug相关信息
	- 这些信息写到了日志(logs)里
	- logs都在后端(后台)
	- servlet源程序也在后端(后台)
	- web.xml是后端程序路由的核心
- 可是
	- 究竟什么是后端呢？🤔
- 下次再说！👋