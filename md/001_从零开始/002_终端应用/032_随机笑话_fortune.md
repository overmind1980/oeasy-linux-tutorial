---
show: step
version: 1.0
enable_checker: true
---

# fortune 笑话

## 中文笑话 😌

- asciiview把图像转化为了 ascii🅰️ 字符画
- 并且修改了 cowsay 的图像素材 💡
- 我们能让 cowsay 随机讲讲笑话吗？

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211008-1633663823279)

## 我们想要让牛讲一个随机的笑话

- 首先我们要有个说笑话的软件包：

```shell
# 下载 fortune
sudo apt install fortune
#使用 fortune
fortune
```

- 安装了之后
	- 会随机给我们一些经典名言

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20230417-1681731116203)

- 名言分成几类
	- fortune 提示
	- riddles 对话
	- literature 文学

### 指定文字来源

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20230417-1681731383627)



### 深入重定向

```shell
# 把本该输出到屏幕的 fortune 的结果，输出到 cowsay
fortune | cowsay
```

- fortune 输出重定向到 figlet
- figlet 输出重定向到 cowsay

![Image text](https://labfile.oss.aliyuncs.com/courses/2712/fortune_pipe.png)

### 三重重定向
```shell
fortune
fortune | boxes -d cat 
fortune | boxes -d cat | pv -qL 10
fortune | boxes -d cat | lolcat
fortune | boxes -d cat | pv -qL 10 |lolcat
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210629-1624976312502)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210629-1624976590337)

### boxes的细节

```shell
#查询详细帮助
man boxes
#列出所有图形
boxes -l
```
![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210727-1627352147045)

- 有些还挺好看的
- 还有很多适合于制作注释之类的

### 内边距

- 可以设置一些padding 内边距

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210727-1627353212523)

### 大小

- 可以控制大小

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210727-1627353415803)

### 对齐
- 还可以控制对齐方式 
	- 垂直方向
	- 水平方向

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210727-1627353638371)

- 可以居中

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662191057883)

## fortune 的细节 📒

- 具体笑话文件在/usr/share/games/fortunes
- 可以用 cat 查看相应的字典 dat📒 文件
- 攻击性笑话在/usr/share/games/fortunes/off
- 想删除某类的笑话，就删除相应的 dat 文件
- 可以用-f 列出所有列表
- 可以用百分比控制笑话来源

![Image text](https://labfile.oss.aliyuncs.com/courses/2712/fortune.png)

### 总结 🤨

- fortune是英文的
- 如果想来点中文的笑话或者诗歌可以么？
- 怎么来呢？🤔

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220903-1662193886249)

- 下次再说！👋
