---
show: step
version: 1.0
enable_checker: true
---

# 清屏

## 回忆上次内容 😌

- 有了这三个命令
	- whatis
	- whereis
	- which
- 也就是灵魂三问
	- 我们就可以了解任何命令的基本信息了！
- 我们再去问问什么命令呢？🤔 

## 清屏

- 我们这次的命令 
	- `clear` 
	- 很简单

- `clear` 作用是清屏
	- 下面我们对他提出灵魂三问：

```shell
whatis clear
whereis clear
which clear
```

- 这样我们就可以对 clear 有个基本了解
- 如果想更深入了解
	- 可以查询手册。
	- man📕
- 另外我们也可以使用<kbd>ctrl</kbd>+<kbd>l</kbd>快捷键来清屏

### 特殊情况

- 有些文件问不出具体位置，比如：
	- cd
	- pwd

- 他们是 `shell built-in command`
- 那么这些命令在哪？🤔

### 内建命令

- 这些内建命令
	- 是在这个 shell 里面的
	- shell 启动的时候
	- 就在内存中了
	- 所以叫 shell built-in command
	- 没有具体的硬盘对应的命令文件
- 和ls、python不同
	- ls 一开始没在内存中
	- 调用的时候才从硬盘加载到内存中运行的

- 那么shell `啥时候`启动的呢？

### 加载过程
- 终端 terminal 启动时候
- 把硬盘上的 shell 代码
	- 如 zsh、bash
	- 加载到内存里
- 如果要找相应的源代码
	- 就需要去 shell 的源代码里面找

### 尝试找源码

- 更新源

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1661993945667)

- 尝试下载

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1661993974118)

- 尝试下载但失败
- 给了个提示

### github

- 到github上面可以找到相应的源码

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1661994028618)

- 可以找到一个位置

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1661994043256)

- 真的可以找到pwd的源码
- cd也可以找到吗？

### cd源码
- 同一个文件中

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1661994138716)

- cd也可以找到
- 我们去总结一下

### 总结

-  这次我们的命令 
	- clear 非常简单
	- 就是清屏
	- 还可以用<kbd>ctrl</kbd>+<kbd>l</kbd>快捷键来清屏
- 练习灵魂三问
	- whatis clear
	- whereis clear
	- which clear
- 有些内建(builtin)命令(command)找不到硬盘位置
	- 比如pwd、cd
	- 可以在zsh的源码中找到相应的位置
- 基本的命令了解了不少
- 是时候总结一下了
- 下次总结！👋
