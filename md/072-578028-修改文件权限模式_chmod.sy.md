---
show: step
version: 1.0
enable_checker: true
---

# 修改文件权限(chmod)

## 回忆

- 上次总结了用户和用户组
- 为什么要有用户和用户组呢？
- 都用一个账号登录不是更简单吗？
- 这背后有什么样的考虑呢？

### 新建一个文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665064558238)

- 新建文件的时候
- 会记录文件的所有者和所有者的组
- 所谓的权限总共有三组
	- <span style="color:red">红色部分是文件拥有者权限</span>
		- <span style="color:red">rw-</span>
		- <span style="color:red">可读可写不可执行</span>
	- <span style="color:green">绿色部分是文件所属组权限</span>
		- <span style="color:green">rw-</span>
		- <span style="color:green">可读可写不可执行</span>
	- <span style="color:blue">蓝色部分是任何人(everyone)权限</span>
		- <span style="color:blue">r--</span>
		- <span style="color:blue">可读不可写不可执行</span>

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665064918103)

- 那最前面的-是干什么用的呢？

### 文件类型

|  符号   | 含义  |
|  ----  | ----  |
| d  | 文件夹 |
| -  | 文件 |
| l | 链接 |
| b  | 可随机存取设备 |
| c  | 鼠标键盘等串口 |

- 后面的就是文件权限

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665633711817)

- 这都有什么权限呢?

### 执行权限

- 红框中的内容是文件拥有者的权限
	- 文件拥有者(shiyanlou)
		- 可以读
		- 可以写
		- 但是不可以执行

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665065240866)

- 尝试为test.sh添加执行权限

### 添加执行权限

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665065409527)

- 执行chmod命令后
- 确实可以执行了
- 这个chmod是什么意思呢？

### chmod

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665065668829)

- chmod 改变文件的模式位(mode bits)
- u+x是什么意思呢？

### u+x

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665065855810)

- u代表文件拥有者
- +代表添加属性
- x代表可执行权限
- u+x 是 给文件拥有者增加可执行权限
- test.sh就能执行了
- 如果u-x会如何呢？

### u-x

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665066073536)

- 确实可以去掉执行权限
- 如果我要去除掉文件的可写权限呢？

### u-w

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665066168959)

- 读是r
- 写是w
- u-w是
	- 给文件拥有者去除写权限

### 尝试

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665066351999)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665066372752)

- 确实变成只读了
- 如果让他连读都不能读呢？

### u-r

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665066573504)

- 确实可以让他不能读取
- 可是shiyanlou不是属于shiyanlou这个组吗？
- 组权限不是可以读写吗？

### 查看文档

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665066663757)

- 这个同组用户指的是同组中的别的用户
- 那我把oeasy这个用户
- 加到shiyanlou这个组里面
- 可以读写吗?

### 先试试默认的情况

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665067083146)

- 默认确实是可读不可写不可执行
- sh可执行
- 但是./test.sh不可执行
- 将oeasy添加到shiyanlou组中

### 入组

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665067391779)

- 入组之后要新开一个终端
- 并切换用户到oeasy

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665067424714)

- 确实同组是可写的
- 如果我想要不同组的也可以写呢？

### 不同组o

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665067734933)

- 具体操作应该怎么做呢？

### 修改

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665067843027)

- 然后用o2z登录

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665067765741)

- 确实可以写
- 那么这个ugo和a有什么关系呢？

### 观察

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665068030841)

- a+w就是ugo都+w
- a-w就是ugo都-w
- ugoa到底什么意思呢？

### ugoa

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221006-1665068123964)

- u 文件拥有者
- g 文件拥有者同组其他用户
- o 文件拥有者所属组之外的用户
- a 所有用户

### 总结 🤨
- 我们这次研究的是修改权限
	- chmod
- 每个文件对不同用户组有不同的权限
- 角色分为
	- u 文件拥有者
	- g 文件拥有者同组其他用户
	- o 文件拥有者所属组之外的用户
	- a 所有用户
- 权限分为
	- r 读
	- w 写
	- x 执行
- 这个执行权限x怎么理解呢？🤔
- 下次再说👋
