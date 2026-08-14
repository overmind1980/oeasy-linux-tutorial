---
show: step
version: 1.0
enable_checker: true
---

# 修改文件权限(chmod)

## 回忆

- 我们现在可以
	- 让进程获得文件所有者的权限suid
	- 让进程获得文件所属组的权限sgid
- 文件夹的sgid具有继承性

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
| S_IROTH  | 其他写 |
| S_IROTH  | 其他执行 |
| S_ISUID  | 执行时设置用户id |
| S_ISGID  | 执行时设置用户组id |

- 理论上其他组(o)应该也有个临时设置的特殊位
- 这个真的有吗？

### 查看帮助

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665644181884)

- 自身啥都可以干
- 同组或其他可以改写文件
- 但是不能删除

### 建立环境

- 建立路径

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665645185397)

- 然后建立用户

### 建立用户

- 将oeasy加入shiyanlou组

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665645089549)

- 尝试删除

### 同组用户尝试删除

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665645670873)

- oeasy属于shiyanlou组具有写权限
- 确实可以写
- 但是不能删除文件夹
- 其他用户呢?

### 其他用户尝试写

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665645846238)

- 其他用户确实可以写文件
- 粘滞位不具有继承性
- 其他用户可以删除有粘滞位的文件吗？

### 其他用户尝试删除

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665645943045)

- 删除失败
- 只有root和所有者可以进行删除
- 如果是具有粘滞位的文件会如何呢？

### 尝试删除带有粘滞位的文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665646103241)

- 具有粘滞位的文件
- 可以读
- 可以写
- 但是不可以删除
- 只有root和自身所有者才有权限删除
- 如果我先chown了
- 然后再删除呢？

### 先chown

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20221013-1665646404179)

- 修改了所有者之后
- 新的文件所有者就可以进行删除了

### 总结 🤨 
-  我们这次了解了粘滞位sticky
-  通过chmod o+t可以设置
-  设置之后
-  只有root和自身文件所有者可以删除


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
| S_IROTH  | 其他写 |
| S_IROTH  | 其他执行 |
| S_ISUID  | 执行时设置用户id |
| S_ISGID  | 执行时设置用户组id |
| STICKY  | 只有文件所有者和root可以删除 |

- 了解了这么多
- 我可以
	- 读取一个csv文件
	- 新建若干目录、用户
	- 并且进行设置吗？🤔
- 下次再说👋