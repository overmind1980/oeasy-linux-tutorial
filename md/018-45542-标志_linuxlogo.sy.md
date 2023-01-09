---
show: step
version: 1.0
enable_checker: true
---

# 本章回顾

## 我们来回顾一下 😌

- 上次编译安装了俄罗斯方块
- 比较两种安装软件的方法
	- 编译安装
	- apt安装
- 各有优劣
- 我们去下载一些好玩的软件吧？！🤔 

### 两种包管理方法

- dpkg 
	- 本地包管理
- apt 
	- 高级包管理

- 我们去搜着玩玩

### 搜索包
```
# 搜索源里面有没有 linuxlogo 这个软件包
apt search linuxlogo
```
- 搜索这个包

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662024724718/wm)

### 查看包

```shell
# 看看镜像站上面对于这个软件包的描述
apt show linuxlogo
```

- 查看这个包

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662024793146/wm)

- 各种软件包有时候有依赖关系

### 依赖关系

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662024930041/wm)

- `show` 显示开发者 简介 大小 所在的源的位置
  - 我们可以 `apt show apt` 看看 apt 的依赖关系
  - (A 或 B) 且 C 的关系写作 A | B, C
- 我们还是回到主线linuxlogo

### 安装包

- 那我们怎么安装他呢？
- 查一下手册
- 📕 应该是这样：

```shell
apt install linuxlogo
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662025043601/wm)


- 但是系统提示权限不够
- 如何提权限呢？🤔

## 权限问题 👺

- 权限不够的问题如何解决？ 🤫

- 我目前的用户身份
	- 不能执行这条命令
- 谁能执行呢？
	- root!
- root 用户是系统最**根本**的用户
- root 用户有权限执行任何命令
- 所以如果我们戴上了 root 用户的面具 👺
	- 我们就是 root 用户了
	- 那么我们 👺 也就能执行任何命令啦～
- 那什么怎么带上面具👺呢？

### 戴上面具

- `sudo` 命令可以让我带上 root 的面具
- 像这样：👺

```shell
sudo apt install linuxlogo
```

- 我们使用 sudo 戴上了面具
- 然后 apt 成功从源下载软件包并下载到硬盘里

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662024999601/wm)

- 那么这个东西能用吗？🤪 
- 我们来试试：

### 运行包

```shell
linuxlogo
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662025392063/wm)

- 真的可以看到发行版的 logo!🍥 
- 包括了：
	- 内核版本
	- 发行版版本
	- 编译日期
	- cpu 速度


### 遍历所有的logo

```
for i in {1..30};do linux_logo -f -L $i;sleep 0.5;done
```

- 暗中观察

### 类似命令

- 这个screenfetch 和 linuxlogo有点像

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210629-1624976928030)

- 那么这个文件放在哪里了呢？

### 灵魂三问 🤔

我们通过之前学的“灵魂三问”来查询：

```shell
whatis linuxlogo
whereis -b linuxlogo
which linuxlogo
```

- 大家还记得Python版本选择吗？

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662025483175/wm)

- 其实是一个意思

### 观察文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634474563456)

- linuxlogo其实也是一个软连接
- 最终指向同一个文件夹下的linux_logo
- linux_logo 123K

### 运行起来

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210629-1624976863533)

- 我们可以查看到 linuxlogo 的硬盘位置
	- 想要更多细节可以查询手册～📕
	- 可以下载吗？🤪可以灵魂三问吗？
	- 🤪可以手册吗？
- 🤪玩起来吧！🎲

```shell
man linuxlogo
linuxlogo -F oeasy
```

- 为什么能够彩色呢？
- 查看一下源代码吧

### 找到源头

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631261818922)

- 他的版本是5.11-8
- 找到他的homepage
- 然后进去

### 下载

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631261843641)

- 下载那个红色的linux.tar.gz文件到本地

- http://www.deater.net/weave/vmwprod/linux_logo/

- 非会员可以先下载到本地再上传到Code

### 解压

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631261928110)

- 解压

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220901-1662025824651/wm)

- tar -zxvf  <kbd>Tab</kbd>

### 打开源文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631261907189)

- vi linux_logo.c

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631262481224)

- :q!退出
- 这个下载方法还是有点麻烦啊
- 我能直接下载源文件么？

### 更新源

- 先重启系统
- 进入到没有linuxlogo的状态
- 在shell中用vi打开list文件

```shell
sudo vi /etc/apt/sources.list
```

- 这里显示的是更新软件的下载源头

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634473555693)

- :%s/# deb-src/deb-src/g
	- 把 `# deb-src` 更新为 `deb-src`
	- 去掉对于src源的注释
- :wq
	- 保存并更新
- sudo apt update 
	- 更新源

### 下载源文件

- sudo apt source linuxlogo

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634474060864)

### 查看下载文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634474113730)

- 这里面有c文件
- 还有h文件
- linuxlogo的二进制可执行文件是不存在的
- linux_logo的二进制可执行文件也是不存在的
- 我们试试编译出linuxlogo的二进制可执行文件

### 配置

- ./configure
	- 一般用来生成 Makefile，为下一步的编译做准备。
- sudo ./configure --prefix=/usr
	- 意思是将该软件安装在 /usr 下面
	- 执行文件就会安装在 /usr/bin 
		- 而不是默认的 /usr/local/bin
	- 资源文件就会安装在 /usr/share
		- 而不是默认的/usr/local/share 

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634477659579)

### 编译并配置

- sudo make install

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634477671468)

- 可以看到他在使用gcc编译程序

### 运行程序

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634477693531)

- 编译之后的二进制文件送进了/usr/bin

### 名字文件
- cat 打开名字文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631262497840)

### 细节
- vi打开名字文件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631263133305)

- 看不懂
	- 但是隐约感觉到那就是控制颜色的东西
	- 以后也许能懂
- 有机会可以去看看oeasy的python教程
	- 很适合编程入门
- 去找找

### 下载源码

- 如果重启了
- 就要重新允许下载src文件
- 并更新源
- 然后下载coreutils的源文件
	- sudo apt source coreutils

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634478443143)


### 找到所有原文件

- find ./ -name "*.c"
- 筛出一些熟悉的

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634478567964)

### yes的源码

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211017-1634478613918)

```c
/* yes - output a string repeatedly until killed
   Copyright (C) 1991-2016 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* David MacKenzie <djm@gnu.ai.mit.edu> */

#include <config.h>
#include <stdio.h>
#include <sys/types.h>
#include <getopt.h>

#include "system.h"

#include "error.h"
#include "long-options.h"

/* The official name of this program (e.g., no 'g' prefix).  */
#define PROGRAM_NAME "yes"

#define AUTHORS proper_name ("David MacKenzie")

void
usage (int status)
{
  if (status != EXIT_SUCCESS)
    emit_try_help ();
  else
    {
      printf (_("\
Usage: %s [STRING]...\n\
  or:  %s OPTION\n\
"),
              program_name, program_name);

      fputs (_("\
Repeatedly output a line with all specified STRING(s), or 'y'.\n\
\n\
"), stdout);
      fputs (HELP_OPTION_DESCRIPTION, stdout);
      fputs (VERSION_OPTION_DESCRIPTION, stdout);
      emit_ancillary_info (PROGRAM_NAME);
    }
  exit (status);
}

int
main (int argc, char **argv)
{
  char buf[BUFSIZ];
  char *pbuf = buf;
  int i;

  initialize_main (&argc, &argv);
  set_program_name (argv[0]);
  setlocale (LC_ALL, "");
  bindtextdomain (PACKAGE, LOCALEDIR);
  textdomain (PACKAGE);

  atexit (close_stdout);

  parse_long_options (argc, argv, PROGRAM_NAME, PACKAGE_NAME, Version,
                      usage, AUTHORS, (char const *) NULL);
  if (getopt_long (argc, argv, "+", NULL, NULL) != -1)
    usage (EXIT_FAILURE);

  if (argc <= optind)
    {
      optind = argc;
      argv[argc++] = bad_cast ("y");
    }

  /* Buffer data locally once, rather than having the
     large overhead of stdio buffering each item.  */
  for (i = optind; i < argc; i++)
    {
      size_t len = strlen (argv[i]);
      if (BUFSIZ < len || BUFSIZ - len <= pbuf - buf)
        break;
      memcpy (pbuf, argv[i], len);
      pbuf += len;
      *pbuf++ = i == argc - 1 ? '\n' : ' ';
    }
  if (i == argc)
    {
      size_t line_len = pbuf - buf;
      size_t lines = BUFSIZ / line_len;
      while (--lines)
        {
          memcpy (pbuf, pbuf - line_len, line_len);
          pbuf += line_len;
        }
    }

  /* The normal case is to continuously output the local buffer.  */
  while (i == argc)
    {
      if (write (STDOUT_FILENO, buf, pbuf - buf) == -1)
        {
          error (0, errno, _("standard output"));
          return EXIT_FAILURE;
        }
    }

  /* If the data doesn't fit in BUFSIZ then output
     what we've buffered, and iterate over the remaining items.  */
  while (true /* i != argc */)
    {
      int j;
      if ((pbuf - buf) && fwrite (buf, pbuf - buf, 1, stdout) != 1)
        {
          error (0, errno, _("standard output"));
          return EXIT_FAILURE;
        }
      for (j = i; j < argc; j++)
        if (fputs (argv[j], stdout) == EOF
            || putchar (j == argc - 1 ? '\n' : ' ') == EOF)
          {
            error (0, errno, _("standard output"));
            return EXIT_FAILURE;
          }
    }
}

```

- 这种全小写
	- 配合下划线的c语言编程风格
	- 在这个领域很流行
	- Python的源代码也是这个风格的
	- snake_style
- 写这个代码的是谁呢？


### David MacKenzie
- 是David MacKenzie等前辈的努力

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211018-1634515759527)

- 才使得我们有可能使用开源软件

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211018-1634516216949)

- 向前辈致敬

### 总结

- 这次研究的是linuxlogo
- 可以下载二进制文件
- 也可以下载源文件
- apt 有一些 参数
	- `search` 
		- 查找到你的当前架构是否可以有这个软件包
	- `show`
		- 查看软件包的具体细节
			- 依赖关系
			- 所属位置
	- `install`
		- 具体安装
		- 主要有sudo才能得到root权限
	- `source`
		- 下载源代码
		- 可以查看和编译
- 甚至coreutils里面的基本命令的源代码都可以下载
- 还有什么好玩的命令吗？🤔
- 我们下次再说！👋
