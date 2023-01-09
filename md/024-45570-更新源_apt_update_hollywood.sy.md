---
show: step
version: 1.0
enable_checker: true
---

# 本章回顾

## 回忆 😌

- 上次讲了bb
- bb是我目前看到最眼花缭乱的应用了
	- 这个东西吓唬人很好啊！💀
	- 让人以为自己的机器崩溃了！☠️ 
- 循环崩溃中...
	- 哈哈哈
- 还有啥好玩的？👻 

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662083399309/wm)

### hollywood

- 我们这次装一个酷
- 下个 hollywood 软件包：🎭 

```shell
apt search hollywood
apt show hollywood
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662083451186/wm)

### hollywood🎭

- 这软件可以模拟出好莱坞情景剧中
	- 黑客电脑的样子

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662083585233/wm)

- 安装时遇到了问题？😳

### 问题

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662083795353/wm)

- 按照他最后一行的提示
- 可以更新源
- 为什么要更新源？

### 更新源

- 源服务器上的软件可能有更新
	- 不用改变源 `sources.list` 的配置
		- 源服务器地址没变
- 更新源是为了把源(sources.list 上对应的 url)的最新信息同步到本地
	- 如果软件包有更新的话
	- 会发布更新到主服务器对应的发行版版本的位置
	- 主服务器内容六小时之内同步到镜像服务器

### 更新源

```shell
sudo apt update
```

- `sudo` 是用管理员面具 👺 执行
- `apt` 是高级软件包管理程序
- `update` 更新的内容包括
  - 把最新的软件包信息从镜像同步到本地
  - 在本地记录软件包列表信息
  - 在本地分析软件包依赖关系树
  - 在本地读取状态信息

### 安装软件


```
sudo apt install hollywood 
```

- 再安装 hollywood 🎭

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220902-1662083874213/wm)

- 这回安装很顺利
- 然后我们去跑一下 hollywood🎭

### 执行

```shell
hollywood
```

![Image text](https://labfile.oss.aliyuncs.com/courses/2712/hollywood.png)

### 总结 🤨

- 这个hollywood真的很酷
- 👻 退出的话用 <kbd>ctrl</kbd>+<kbd>c</kbd>
- 回到原来的 shell 用命令 zsh
- 下面的关于 cpu、日期等信息仍然保留
- 用这个当做屏保
- 无意中让 MM 看看
- 哈哈！
- 目前我们只会安装软件包
- 如何删除软件包呢？🤔 
- 下次再说！👋
