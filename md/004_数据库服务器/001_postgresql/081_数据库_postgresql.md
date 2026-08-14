---
show: step
version: 1.0
enable_checker: true
---

# 数据库 postgres

## 数据库

- 我们这次进入一个全新的领域 😌
	- 数据库
- 哪个数据库好呢？
	- 这是2021年的排行榜

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211119-1637308540991)

- 开源的有两个
	- mysql自称是最流行的数据库
	- postgres自称是最先进的数据库
- 我们选择postgres来学习


### 入库
- 更新系统安装postgres
- 启动postgres
- 并以postgres登录

```
sudo apt update
sudo apt install postgresql
sudo /etc/init.d/postgresql start
sudo -u postgres psql
```

- 查看所有数据库database

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210903-1630664944685)

### 查看数据库
```
\l
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210903-1630665003642)

- 建立数据库oeasy
- 并进入

```
create database oeasy;
\l
```
![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210903-1630665050881)

### 建表并导入数据
```
\c oeasy
\dt
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210903-1630665134696)

- 建表

```
create table urls(topic varchar, url varchar);
\dt
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210903-1630665232801)

### 下载数据

- git clone http://gitee.com/overmind1980/oeasyorg.git
- 找到其中的urls.csv

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210910-1631280041502)

### 导入数据

```
\copy urls from '/home/shiyanlou/oeasyorg/urls.csv' delimiter ',' csv ;
```
![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210903-1630665741698)

### 查询数据

```
select * from urls where topic like '%e%';
select * from urls where length(topic) > '5';
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20210903-1630665711812)

### 总结 🤨
- 我们这次搭建了postgres数据库
- 并且导入了数据
- 查询了数据
- 可以把这个数据放在网页里查看么？
- 下次再说！👋


