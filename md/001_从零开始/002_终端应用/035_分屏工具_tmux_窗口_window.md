---
show: step
version: 1.0
enable_checker: true
---

# 分屏工具tmux

## 总结

- 新建会话
	- tmux
	- tmux new -s session_name
- 列出所有会话
	- tmux ls
- 进入会话
	- tmux attach -t session_name
- 切换会话
	- tmux switch -t session_name 
- 退出会话
	- tmux detach 
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>d</kbd>
- 删除会话
	- tmux kill-session -t session_name
- 会话改名
	- tmux rename-session -t old new	
	- 当前会话改名
		- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>$</kbd>
- 会话管理器
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd>

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662208792424)

- 每个session后面有个`1 windows`是什么意思?🤔

### windows 窗口

- 可以在当前session中添加window
	- tmux new-window

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662209146134)

- 红框中就出现新的window

### 会话管理器

- 会话管理器
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd>


![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662209514515)

- 可以用方向键和回车选中会话中的窗口(window)
- 一个窗口对应下方绿条上的一个标签页
- 当前窗口后面有个星号*
- 会话(session)和窗口(window)之间有什么关系呢？

### tmux结构

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211209-1639025794089)

- session可以切换
- window可以么？

### 切换windows

- 用会话管理器切换
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd>
	- s对应session
	- 所有窗口默认关闭
	- 可以用方向键切换
- 用窗口管理器切换
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>w</kbd>
	- w代表window
	- 所有窗口默认打开
	- 列出当前session所有window

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211209-1639025528142)

- 选择
	- 然后用方向键选择
	- 回车键确认
- 命令方式
	- tmux select-window -t <window-number>
- 不过还是比较复杂的
- window的增删改名可以用快捷键么？

### window相关快捷键

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>c</kbd>
	- 意思是create
	- 创建一个新window窗口
	- 状态栏会显示多个窗口的信息

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210927-1632747599174)

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>p</kbd>
	- 切换到上一个窗口（按照状态栏上的顺序）previous
- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>n</kbd>
	- 切换到下一个窗口 next
- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>数字</kbd>
	- 切换到指定编号的窗口
	- 其中的<number>是状态栏上的窗口编号
- tmux之后，窗口内的东西就不能向上翻着看了
- 怎么办？

### 向上翻页

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>[</kbd>
	- 可以进入翻页模式
	- 左上角有标记

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210929-1632865488365)

- 用方向键就可以往上翻了
	- 鼠标也可以
	- 结束翻页状态按q
- 窗口可以删除么？

### 删除窗口

- 思路
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>&</kbd>
		- c 是 close
	- 删除窗口应该和删除会话一样
		- 也是kill 
	- 只不过这次不是kill-session
	- 而是kill-window
- 试试

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210927-1632748022383)

- 删除session和window的方式都是kill
- 那session和window的改名方式都是rename么？

### 窗口改名

- 改名可以按为先删除再重建的方式完成
- 不过有没有直接改名的方式呢
- tmux rename-window -t 3 o3z
- 试试

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210927-1632748030343)


- 注意底下绿条的变化

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210927-1632748406379)

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>,</kbd>
	- 可以修改当前窗口的名字
	- 给窗口一个记得住的名字很重要
- 既然有了session为什么又要有window呢？
- 这不是重复了么？

### session和window之间的区别

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd>
- 可以列出当前的用户的所有session
- 还可以展开
- 我们有的时候需要连好几个服务器
	- oeasy.org
	- o2z.org
- 这就需要两个sessions吗？
- 其实不用我们只要同一个session中开两个window
- 然后分别ssh到指定的服务器就可以了
- 同一个服务器也可以开不同的window
- 上面进行不同的操作
	- postgresql
	- python
	- tomcat
	- minecraft server
- 那为什么有session呢？
- session我理解就是工作区 workspace
	- 可以把工作的环境保留下来
	- 这一个session是干这套活的
	- 那一个session是干那套活的
	- 这样就可以通过切换session进行任务的切换
- 不过这个tmux始终在服务运行着
- 还是比较占用资源的

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210929-1632865111649)

- window之下还有可以分的么？

### 总结

- 新建窗口
	- tmux new-window -n window_name
- 切换窗口
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>数字</kbd>
- 关闭当前窗口
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>&</kbd>
	- tmux kill-session -t session_name
- 会话窗口
	- tmux rename-session -t old new	
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>$</kbd>
- 窗口管理器
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd>

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662210670959)

- 窗口下面还有什么？🤔
- 下次再说！👋🏻