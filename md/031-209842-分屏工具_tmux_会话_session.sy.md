---
show: step
version: 1.0
enable_checker: true
---

# 分屏工具tmux

## 我们来回顾一下 😌
- 上次下载了中 🀄️ 文谚语
- 输出重定向了中文谚语
- 理解词典和颜色

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662197273972)

- 我们这次想要分屏！🤔

### tmux

- 首先下载tmux
- 进入tmux

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662198532989)

- 退出tmux
	- exit

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210927-1632741113713)

- 键入exit这种退出
	- 是真的结束进程
- 除此之外
	- 还有另一种退出

### 退出detach
- 脱离会话
	- tmux detach

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662198812603)

- detach的意思是脱离
	- 脱离什么
	- 脱离当前session 0

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662198825637)

- 什么是session？

### session

- session翻译为会话
	- 原来指的是法庭定期的开庭

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211209-1639019898088) 


- 后来也指一段时间的活动，比如
	- 音乐会
	- 学年
	- 摄影
	- 录音
- 这里的session指的是和服务器之间的固定关联
	- 除了用tmux detach
	- 之外还可以用快捷键

### 快捷键分离会话
- 快捷键是<kbd>ctrl</kbd> + <kbd>b</kbd> <kbd>d</kbd>
	- 先用左手小指按下<kbd>ctrl</kbd>不松手
	- 然后左手中指按下<kbd>b</kbd>
	- 然后同时松手
	- 再按一下<kbd>d</kbd>
- 作用也是和当前会话(session)分离(detach)
	- 但不是从当前会话(session)中退出(exit)
	- 只是分离(detach)
	- 会话(session)还在
- 回到一般终端后
	- 可以用tmux ls
		- 观察所有分离的会话

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662199117687)

### 重新连接会话

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662199566386)

- 也可以用
	- 意思是连接上原来的第0号session
	- 如果忘了的话，可以输入tab
	- 查看提示
- tmux attach -t 0
- 继续连接这个session

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662199624101)

- 现在就连接上上次的会话(ession)了
- 还能看到上次detach那句话呢

### 自建session

- 重新detach
	- 在detach回到一般状态后

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662199863334)

- 可以新建一个session
	- tmux new -s oeasy
	- 建立一个新的session名字叫做oeasy
- 这时就有了3个session

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662199969331)

- 可以切换session吗

### 切换session

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662200042971)

- tmux switch -t 0
	- 切换到名字是0的session
	- 当前session后面会有attached

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662200105463)

- tmux switch -t oeasy
	- 切换到名字是oeasy的session
- 反复练习切换
- 0这个session的名字有点太特殊了
- 会话(session)可以改名字吗？

### session改名

- tmux rename-session -t 0 o2z
	- 把原来叫做0的session改名为o2z

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662200548401)

- 可以把另一改成o3z么？

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662200638103)

- 会话(session)可以删除么？

### 删除session

- 回车进入session
- 回到命令行
- tmux ls列出所有session

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662206840972)


- 总共3个会话(session)
- 当前session为o3z
- 尝试删除
	- tmux kill-session -t session_name

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662207290084)

- 先删除名为o2z的会话(session)
- 再删除名为oeasy的会话(session)

### tmux管理器

- 列出会话
	- tmux ls 
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd>

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662207948563)

- 上下方向键可以上下切换session
- 回车可以选择session
- +键上→可以打开+
- 我们总结一下tmux的session

### 会话总结

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
- 下次再说👋🏻



