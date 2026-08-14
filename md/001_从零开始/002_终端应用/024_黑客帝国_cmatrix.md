---
show: step
version: 1.0
enable_checker: true
---

# 本章回顾

### 我们来回顾一下 😌

- 开车挺有意思
- 蒸汽机车 sl 🚂
	- 变身小机车-l 🚂
	- 变身飞天机车-F 🚂
	- 让我们再开一次车 🚂
- 不过不够酷啊

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662081680515)

- 有没有像黑客帝国那么酷的呢?🤪

## 黑客帝国 Matrix 📟

```shell
apt search cmatrix
apt show cmatrix
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662081923740)

- 我们发现一个叫做 cmatrix 的软件包
- 下载需要 2M
- 好像可以玩
- 走起来！

### 安装

```shell
apt install cmatrix
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662082000035)

- yes

### 运行

```shell
cmatrix
```

- 运行起来

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662082056077)

- 好看~！！！

### 细节

- 那么我们可以看看手册里的选项细节吗？

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662082108135)

### 矩阵细节 📟

- `-b`: 部分加粗头部变色 bold
- `-B`: 全部加粗头部变色 Bold
- `-o`: 老式的 old school
- `-s`: 屏保模式 Screensaver
- `-u`: 我们可以设置中间 0-9 的间隔时间 ⏲
  - 0 为无间隔非常快
  - 9 为比较慢
- `-C` 后面加上想要的颜色 (Color) 模式
  - 目前支持红绿蓝青品黄黑白
  
- 举个栗子🌰 

```shell
#  加粗头部
cmatrix -b
#  间隔极慢
cmatrix -u 9
#  蓝色黑客帝国
cmatrix -C blue
```

### 还有什么？🤨

- 黑客帝国矩阵确实很酷
- 但是还想更酷
- 让人感觉电脑直接炸裂那种😱 
- 我们得去找找
- 下次再说！👋
