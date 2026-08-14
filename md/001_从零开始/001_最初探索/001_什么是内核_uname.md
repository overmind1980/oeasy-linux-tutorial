---
show: step
version: 1.0
enable_checker: true
---

## 开门见山🤔

- 咱们这次讲点什么呢？
	- 这次咱们讲讲这个 **linux(\[ˈlɪnəks\])**

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745546861332)

- 什么是 **linux** 呢？
	- 听起来 就有点 `耳熟`
	- 其实天天 和咱们打交道

### 服务器

- 咱们打车订餐玩游戏不都得访问服务器么？
	- 服务器用的 都是 linux

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20250425-1745549792795)

- 单独的 **linux** `不是操作系统`
	- 那**linux**是什么呢？

### 内核

- linux是操作系统的 **[内核(kernel)](https://baike.baidu.com/item/内核)**

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745547168143)

- 什么是内核呢？

### 内核

- 内核 是 直接控制内存和其他硬件的一层

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745547132158) 

- 听起来是不是很硬核？👊

### 硬核

- 内核确实是很硬核的

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745547100012) 

- 除了 linux 之外
	- 还有啥别的内核么？🤔

### 其他内核

- 苹果的 ios 和 mac 
	- xnu(xnu is not unix) 
	- 一个混合内核
	- 奠基于卡耐基 · 梅隆大学开发的 Mach
- 微软公司 windows 
	- 内核不公开🤔
- bsd 内核
	- 索尼，任天堂都是用 bsd 
- 不过内核我也接触不到啊
	- 能看得见么？

### linux 在哪？🤔

#### 身边的linux
- linux 其实就在我们身边

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745548192633) 

- [小米路由器](http://www.miwifi.com/) 使用的 [OpenWrt](https://openwrt.org/) 的内核也是 linux

### 天天接触着
- 安卓手机的内核就是 linux

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745548241137) 

- 谷歌公司推出的 vr 系统 [daydream](https://arvr.google.com/daydream/)
	- 物联网中的嵌入式设备
	- 智能汽车系统
- 这还没有提到最关键的领域
	- 服务器

### 服务器

- 我们可以用idc (Internet Data Center) 观察公司[netcraft ](https://searchdns.netcraft.com/) 

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745548325512) 

- 搜索服务器所使用的系统
	- 原来谷歌、淘宝、腾讯服务器 
	- 基本都是 linux

- 建立网站的话
	- linux是基础
	- 甚至是微软的基础
	- 微软不是自己有windows么

### 微软

- 有意思的事
	- 我们来检索一下 [微软公司用服务器系统](https://searchdns.netcraft.com/?restriction=site+contains&host=microsoft.com&position=limited) 
	- 发现大多数 [微软](http://microsoft.com) 的服务器用的也是 linux

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745548378216) 

- 微软公司 
	- 曾指责 linux和开源 是 癌症
	- 恨不得 亲手 杀死 对手

### 现状

- 到现在
	- microsoft love linux
	- 积极加入linux基金会

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210909-1631154553350)

- 给人给钱
	- 微软 这个转变 也不容易😮‍💨

### 下载

#### 我在哪儿可以下载到 linux 呢

- linux 这个内核
	- 可以从 [kernel.org](https://www.kernel.org/) 下载
	- 可以下载 linux 内核的 c 语言源代码😎
	- 还能把他编译成可运行的真正 **内核**
	- 甚至把当前服务器的内核替换升级
- 真的很有意思
	- 这个内核的源代码是开放的
	- 也就是开源opensource
	- 由各国的优秀程序员提交到 [github 上的 linux 项目](https://github.com/torvalds/linux)

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745548544539) 

- 除了 linux 之外
	- github 还有`啥` 开源项目?

### 开源

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745548944936) 

- python

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745549644536) 

- postgres
- blender
- vim
- ...

### 如何学习 linux 呢？🤔

#### 关于 Linux 的学习路径，有两条

- 一种是从 **图形界面 (GUI)** 🖥 入手
	- Graphic User Interface
	- 快速

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220831-1661929591050)

- 但是很难深入
	- 看上去很美

### 命令行

- 另一种方法则是从 **命令行 (CLI)** 入手
	- Command Line Interface
	- Linux 中 **命令** ⌨️是才是精髓所在
	- 连接服务器 用的ssh 都是命令行

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745550203781) 

- 但是 命令行的缺点 是 学习过程枯燥乏味
	- 非常难走
	- 不过没关系
	- 路虽难走
	- 希望你能跟 oeasy 一起来！ 🤝

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20250425-1745549776413)

- 如何打开命令行呢？🤔

### 打开命令行

- 各种系统 都有终端
	- 比如win系统中的cmd、powershell、wezTerm
	- mac的termimal、iterm2
	- linux 终端

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220830-1661828357352)

- 我们 所学的这些
	- 都可以 远程登录 到 linux云上
	- 玩的 云端的东西

### 酷😎

- 打开了 黑色的异世界
	- 一切开始的地方！！！
	- 这也是很多人生活的地方！！！

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220830-1661822828451)

- 图形界面
	- 只是对命令行封装
	- 命令行才是根本

|中文|英文|
|---|---|
|图形用户界面|`G`raphic `U`ser `I`nterface|
|命令行界面|`C`ommand `L`ine `I`nterface|

- 你有信心走到底么？？？

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220831-1661930018669)

- 具体 `咋查看` 本机内核 呢?

### uname 

- 在终端上 使用命令 uname

```shell
uname -r
```

- 需要注意❗️
	- linux 的命令是 **大小写敏感 (case sensitive)** 的
	- 命令 一般是 **小写**。

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745550637646) 

- 我们可以看到
	- 内核的版本如 4/18.0-21-generic

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745550800147) 

- 但这和企鹅🐧有什么关系？

### 企鹅

- 1996 年 5 月 12 日
	- linux 内核 需要一个生动的形象
	- linux 爱好者在 [邮件列表](https://lkml.org/lkml/1996/5/12/136)  里面讨论用什么吉祥物代表 linux
		- 有的说鲨鱼
		- 有的说精灵

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210909-1631181323873)

- 后来 核心作者 **托瓦尔兹 里努斯 (Torvalds Linus)**
	- 说他 曾在 澳大利亚被 **企鹅** 咬过
	- 觉得 这段经历 很有趣
	- 于是 决定用企鹅 作为吉祥物

- 这企鹅是谁画的？

### tux

- 这只企鹅 🐧 叫 **tux(\[tʌks\])** 
	- 是 linux 的吉祥物


![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745550872652) 

- [Larry Ewing](https://isc.tamu.edu/~lewing/) 
	- 用 Gimp 创作了这只可爱的企鹅
	- 源文件可以在 [作者的博客](https://isc.tamu.edu/~lewing/linux/) 找到
	- 后来他还做了很多 [tux 变种](https://isc.tamu.edu/~lewing/linux/test.html)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210909-1631184284091)

- 而 Tux 这个名字则来自 James Hughes
	- 意思是(T)orvalds (U)ni(X) 
	- 意思是托瓦尔兹的 unix

### tux

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220831-1661930291335)

- 这个东西看起来有点弱啊

### 弱者

- 别小看这个弱弱的形象
	- 在 和 巨头的搏斗 中
	- 慢慢的胜出
	- 那些看起来强大的 logo 都已谢幕

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210909-1631180308738)

- 这只 呆呆的企鹅
	- 却 越来越有生命力
- 真应了 那句老话
	- **弱者道之用**
- 弱势 其实 更容易 让人虚心
	- 不懂就问呗
	- 比如uname命令
	- 还有 啥细节？

### 查询

-  如果 想了解 命令
	-  就输入选项 --help
	-  可以查询 uname这个命令的 帮助

```shell
uname --help
```

- 这里需要注意的是：
	- 我们的命令还是小写的 **uname**
	- 我们的参数是 --help
	- 在 **命令 uname** 和 **参数 --help** 之间有一个英文的 **空格** 隔开

![](https://labfile.oss.aliyuncs.com/courses/2712/uname.png)

- 从帮助 我们知道 
	- **uname -a** 
		- 可以得到全部信息
- 来试下一下？😯

### 动手

```shell
uname -a
```

- 当前的内核版本是 4.18.0-21-generic
	- cpu 架构指令集是 x86_64
	- 当前的发行版是 **ubuntu**

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220831-1661933677378)

- 查了架构有什么用呢？

### 二进制

- 至少我们下载的时候
	- 知道选哪个二进制版本的软件

![图片描述](https://doc.shiyanlou.com/courses/2712/labs/45529/uid1190679-20250425-1745553412740) 


### 总结
- 这次用 `uname -a` 查看了
	- 内核版本
	- cpu指令集
	- 发行版

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210909-1631154204005)

- 这就是我们linux的初体验
	- 了解了linux内核
- 但是 linux 
	- 如何 从个人软件
	- 发展 成世界知名系统内核的 呢？
- 我们下次再说！👋


