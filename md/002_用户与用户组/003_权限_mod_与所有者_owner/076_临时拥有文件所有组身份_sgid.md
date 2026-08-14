---
show: step
version: 1.0
enable_checker: true
---

# 修改文件权限(chmod)

## 回忆

- 上次研究了suid
	- 这种权限在文件所有者的执行权限上显示为s
	- 意味着执行的时候可以使用文件所有者的权限
	- 可是为什么要设置这样一种权限呢？

### 原因

- 我们如果要修改当前用户的密码
- 需要调用passwd命令
- 这个命令再去修改/etc/shadow
- 而/etc/shadow的所有者是root
- 只有所有者有写权限
- 这就导致了想要修改密码必须使用root账号
- 那么一般账号就无法修改自己的密码了

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665640084754)

- 我们使用uid的权限
- 就可以让当前用户在执行passwd时
- 拥有root权限
- 从而可以修改/etc/shadow
- 从而完成修改密码的操作
- 可以设置g+s权限吗？

### g+s

- 用oeasy登录
- 并为oeasy宿主文件夹设置
	- 777权限
	- g+s权限

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665640963272)

- 其他用户可以在里面添加文件和文件夹吗？
- 用o2z去试试

### o2z

- 可以新建文件和文件夹

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665641119742)

- 新建文件和文件夹的所属主还是oeasy而不是o2z
- 新建文件夹的执行组权限还是s
- 这目录将sgid继承了
- 而且在下面再建文件和文件夹属组也是oeasy
- sgid具体来说有什么用呢？

### gsid

- 先准备好

- 两个用户
	- oeasy
	- o2z
- 一个组
	- ogroup
![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665642414196)

- 并把oeasy和o2z的默认远程登录组设置为ogroup

### 拥有sgid的文件

- /usr/bin下面找到wall文件
	- 这个文件sgid为s

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665642573189)

- 用ssh远程登录上oeasy和o2z
	- 这个时候
	- oeasy发消息可以发到o2z
- 因为他是以wall的tty组的权限来发的
	- 而不是以oeasy组的权限来发的
	- 所有tty登录的终端都会收到这些信息
- 我们来总结一下各种标志位

### 标志位总结

|  mode   | 说明  |
|  ----  | ----  |
| S_IRWXU  | 用户(所有者)读、写、执行 |
| S_IRUSR  | 用户(所有者)读 |
| S_IRWUSR | 用户(所有者)写 |
| S_IRXUSR  | 用户(所有者)执行 |
| S_IRWXG  | 用户组读、写、执行 |
| S_IRGRP  | 用户组读 |
| S_IWGRP  | 用户组写 |
| S_IXGRP  | 用户组执行 |
| S_IRWXO  | 其他读、写、执行 |
| S_IROTH  | 其他读 |
|  S_IWOTH | 其他写 |
| S_IXOTH  | 其他执行 |
| S_ISUID  | 执行时设置用户id |
| S_ISGID  | 执行时设置用户组id |

### 总结 🤨 
- 我们现在可以
	- 让进程获得文件所有者的权限suid
	- 让进程获得文件所属组的权限sgid
- 文件夹的sgid具有继承性
- 理论上其他组(o)应该也有个临时设置的特殊位
- 这个真的有吗？🤔
- 下次再说👋