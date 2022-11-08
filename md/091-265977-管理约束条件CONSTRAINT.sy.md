---
show: step
version: 1.0
enable_checker: true
---

# 使用网页插入数据

## 回忆
- 我们这次研究了表的修改
	- 可以添加删除列
		- ALTER TABLE `table_name` ADD COLUMN `column_name` DATATYPE;
		- ALTER TABLE `table_name` DROP COLUMN `column_name` ;
	- 修改列
		- ALTER TABLE `table_name` ALTER COLUMN `column_name` TYPE DATATYPE;
		- ALTER TABLE `table_name` ALTER COLUMN `column_name` SET NOT NULL;
		- ALTER TABLE `table_name` ALTER COLUMN  `unique_name` UNIQUE(`column_name1`,`column_name2`)`;
	- 添加修改主键约束
		- ALTER TABLE `table_name` DROP CONSTRAINT `primary_key_name`;
		- ALTER TABLE `table_name` ADD  CONSTRAINT `primary_key_name` PRIMARY KEY(`column_name1`,`column_name2`);
	- 修改列名
		- ALTER TABLE `table_name` RENAME `column_origin_name` TO `column_dest_name`;
- 不过到现在还是没有插入数据啊
- 如何插入数据呢？🤔

### 观察一下现在的表结构

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658104302604)

- 现在两个字段
	- 都是非空的
- 如果正常插入应该是什么效果呢？

### 插入数据

```sql
INSERT INTO
    urls(topic,url) 
VALUES
	('tom','http://tom.com')
;
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658104382313)

- 但是如果我要插入空值呢？

### 插入空串

```sql
INSERT INTO
    urls(topic,url) 
VALUES
	('null','')
;
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658104640849)

- 这个还是插入了
- 因为给的字符串是
	- `null`的字符串
	- 空的字符串
- 他和真正的空值还不一样
- 那什么是空值呢？

### 插入空值

```sql
INSERT INTO
    urls(name) 
VALUES
	('something')
;
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658104793199)

- 这个真null确实不行啊
- 因为数据库的url字段有not null的约束

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658104859591)

- 那我可以去掉这个非空的约束么？

### 查询

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211128-1638102417632)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20211128-1638102425515)

### 试试

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658105043986)

- 修改了之后就可以插入了么？

### 插入

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658105337299)

- 确实可以插入了
- 不过字段究竟是不是应该not null
- 一定要在建立数据库的初期就设计好
- 感觉还是应该加上相应的not null的约束


### 添加非空约束

```
ALTER TABLE
    urls
ALTER COLUMN
	url SET NOT NULL
;
```

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658105362516)

- 因为这里面的有些数据行
- 在url这列上的值就是NULL
- 所以先要处理数据

### 处理数据

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658108725093)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658108739049)

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658108747187)

- 经过处理
- url这列上不存在值是NULL的数据了

### 修改表结构

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658108986519)

- 这样非空的约束就去掉了
- 但是可能我又改主意了
- 网页的网址怎么可以为空呢？

### 改回来

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658109170111)

- 这来回来去拉抽屉
- 这受不了啊
- 数据库结构是编程的基础
- 必须先确定下来
- 并保持相对的稳定

### 数据库管理员

![图片描述](https://doc.shiyanlou.com/courses/uid1190679-20220718-1658109262660)

- 数据库管理员不能反复修改数据库
- 先把一切想明白
- 然后给程序员一个比较稳固的数据库结构
- 程序员就可以进行编程了

### 总结
- 我们玩了玩数据表的约束条件
	- 可以添加约束条件
		- ALTER TABLE `table_name` ALTER COLUMN `column_name` SET NOT NULL;
	- 也可以删除约束条件
		- ALTER TABLE `table_name` ALTER COLUMN  `column_name` DROP NOT NULL;
- 但是数据库结构同时也收到数据影响
- 所以一定要一开始的时候想明白
- 保持数据库结构的稳定
- 不过到现在还是没有插入数据啊
- 如何插入数据呢？🤔
- 下次再说👋🏻



