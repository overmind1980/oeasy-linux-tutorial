---
show: step
version: 1.0
enable_checker: true
---

# Oh-My-Zsh

## 回忆

- 上次我们研究了zsh
	- 从源码开始编译安装
	- 真的成功了
- 可以用chsh
	- 来设置用户的默认shell
- 不过现在经常用的是
	- Oh-My-Zsh

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663819822325)

- 这个 `Oh-My-Zsh` 和 `zsh` 是什么关系呢？🤔

### 搜索

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663822832491)

- https://ohmyz.sh/

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663822839952)

### 安装命令

- 复制这个命令

```
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" "" --unattended
```

- 然后粘贴到shell中

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663822849617)

- 完成安装

### 安装过程

- 安装过程中
- 有报错

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663822978270)

### 删除原来的

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663822991324)

- 清空之后
- 就可以重新安装oh-my-zsh

### 编辑主题

```
sudo vi ~/.zshrc
```

- 目前Theme是robbyrussel

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663823144456)

- 效果如下图

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663823168680)

### 更多主题

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663823622241)

- agnoster

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663823634165)

- 好像缺少字体

### 字体问题

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663823902123)

- 需要安装vim-powerline

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663823966516)

### 安装字体

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663824046395)

- 安装字体之后

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663824062295)

- 文件夹字体前景颜色黑色和背景颜色蓝色太容易混淆了

### 找到位置

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663824411245)

- 打开文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663845747196)

- 找到字体相关位置

### 修改

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663845760627)

- 修改结果

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220922-1663845787505)

### 总结 
- 这次我们研究的是oh-my-zsh
- 是zsh上面的一款皮肤
- 效果还不错
- 可以设置字体和字体颜色
- 这就是终端下的美化了
- 如果是远程登录进来的o2z也会有zsh的效果么？🤔
- 下次再说👋

