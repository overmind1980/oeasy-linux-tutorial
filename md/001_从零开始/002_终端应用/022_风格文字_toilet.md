---
show: step
version: 1.0
enable_checker: true
---

# 本章回顾

## 回忆 😌

- 上次研究了figlet
- 可以控制
	- 左中右
	- 字体样式
- 我们突然有了一个疑问
	- 那么大字符可以带有颜色吗？
	- 迅速在手册中搜索 `/color` 一下
	- 没有结果～

- 接下来我们我们去另一个大字符工具那里玩一下...
	- 叫什么? 
	- toilet 这...
- toilet 到底什么意思？🤔

### toilet

```shell
apt search toilet
apt show toilet
```

- 除了在 apt 里面查看
- 还能在哪查看呢？

### 软件包网站查询

- 由于是 debian 系的软件包，我们去 debian.org 找
- 找到网址：
  - <https://www.debian.org/distrib/packages#search_packages>
- 可以查询范围：
  - 软件包目录名称
  - 软件包目录描述
  - 软件包目录源文件 ⚙️ 名称
  - 软件包内容

![Image text](https://labfile.oss.aliyuncs.com/courses/2712/debian_package_search.png)

### 细节

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631263651027)

- 下载试试

### toilet

- 首先下载 toilet：

```shell
sudo apt install toilet
```

- 我们来简单使用：

```shell
toilet oeasy
```

- 查询文档后，发现细节

### 细节

- figlet 的字体 flf 可以给 toilet 用
- toilett 有一种独有字体 tlf
- 字体的位置在 `/usr/share/figlet`
- 还有很多字体可以在 [figlet](http://www.figlet.org/fontdb.cgi) 
	- 查看
	- 下载
	- 并放到文件夹使用

![Image text](https://labfile.oss.aliyuncs.com/courses/2712/toilet_font.png)

- 所有的字体效果图在
  - <http://mewbies.com/geek_fun_files/figlet/figlet_jave.de_zip_only_prev.txt>
- 下载
  - 进入/usr/share/figlet
  - 可以使用 wget 命令
  - wget <http://www.figlet.org/fonts/acrobatic.flf>

### 我们来欣赏一下各种 toilet 的效果 🤪

![Image text](https://labfile.oss.aliyuncs.com/courses/2712/toilet_sample.png)


### 快速换颜色
- 接下来我们就要开始写一些稍复杂代码啦～🤔
	-  换颜色

```shell
echo -e "\e[01;32m$(toilet -f ascii9 "oeasy")\e[00m"
```

- `oeasy` 是文字内容
- `ascii9` 是字体
- `32m` 是颜色
  - 可以换成在 `30-37` 范围内的颜色
  - 其中 `30` 是黑色

### 浏览字体效果

- 快速用字体的名字查看字体效果

```shell
find /usr/share/figlet -name "*.tlf" -exec basename {} \; |  sed -e "s/\..lf$//" | xargs -I{} toilet -f {} {}
```

- 这个命令是一个复合的命令
- 这个命令用到了管道
- 我们可以试着一段段地执行这个代码
- 分析她的作用

### 把 toilet 输出到网页

```shell
#下面这句是把toilet结果输出到oeasy.html
toilet -f bigmono9 --gay --html "oeasy.org" >> oeasy.html
#后面这句是用火狐打开刚才生成的网页。
firefox oeasy.html
```

![Image text](https://labfile.oss.aliyuncs.com/courses/2712/toilet_html.png)

### 总结

- 这次我们研究了toilet
	- 换颜色
	- 换字体
	- 输出到网页
- 很好玩！
- 还有什么好玩的呢？🤪 
- 下次再说！👋

