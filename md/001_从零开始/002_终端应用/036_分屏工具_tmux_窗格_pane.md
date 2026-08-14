---
show: step
version: 1.0
enable_checker: true
---

# 分屏工具tmux

## 回忆
- 新建窗口
	- tmux new-window -n window_name
- 切换窗口
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>数字</kbd>
- 关闭当前窗口
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>c</kbd>
	- tmux kill-session -t session_name
- 会话窗口
	- tmux rename-session -t old new	
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>$</kbd>
- 窗口管理器
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd>

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662210670959)

- 窗口下面还有什么？🤔
- 下次再说！👋🏻

### pane窗格

- tmux split-window 上下分开
- tmux split-window -h 左右分开

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210927-1632748849379)

- 使用快捷键的方式
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>"</kbd>  上下分开
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>%</kbd>  左右分开

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211209-1639025794089)

- 窗格之间如何切换呢？

### 窗格切换和关闭

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>方向键</kbd>  切换窗格
- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>x</kbd>  关闭窗格
- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>!</kbd> 只留当前窗格

- 如果要用命令的方式
	- 窗格关闭
- 怎么办呢？

### 窗格关闭

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>q</kbd>  列出窗格pane标号

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210927-1632749332619)

- tmux kill-pane -t 0

### 暂时切到全屏

- 把当前窗格暂时独显
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>z</kbd> 

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662211373680)

- 当前窗格全屏
- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>z</kbd> 
- 再一次还原
- 和只留当前窗格不同
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>!</kbd> 只留当前窗格

### 窗格大小控制

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>ctrl</kbd>+<kbd>方向键</kbd>
	- 移动当前窗格pane边界
- 这可能和快捷键冲突

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662211613420)


- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>alt</kbd>+<kbd>方向键</kbd>
	- 以5为单位移动当前窗格pane边界

### 其他好玩的

- 列出所有快捷键，及其对应的 Tmux 命令
	- tmux list-keys

- 列出所有 Tmux 命令及其参数
	- tmux list-commands

- 列出当前所有 Tmux 会话的信息
	- tmux info

- 重新加载当前的 Tmux 配置
	- tmux source-file ~/.tmux.conf

### 窗格管理器

- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>s</kbd> 会话管理器
- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>w</kbd> 窗口管理器

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662211845944)

- 可以用方向键打开窗格

### 总结 🤨
- 我们这次使用了tmux
- tmux连接不同服务器可以有不同的session
	- 同一个session里面可以有多个窗口window
		- 同一个window里面可以有多个窗格pane
- 只用新建和切分window就够用了
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>c</kbd>新建窗口
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>%</kbd>或<kbd>"</kbd>拆分窗格pane
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>方向键</kbd>选择窗格pane
	- <kbd>ctrl</kbd>+<kbd>b</kbd> <kbd>x</kbd> 关闭窗格pane
- 还有什么好玩的么？🤔
- 下次再说！👋

