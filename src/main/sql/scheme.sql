--创建数据库
CREATE database if NOT EXISTS easyoj;
USE easyoj;

-- 创建学生用户账户表
-- 这里的考量是id 不会达到那么大的数据量
-- 注：这里采用邮箱和密码来做覆盖索引，提高查找性能
CREATE TABLE if NOT EXISTS account{
account_id unsigned INT auto_increment comment "账户编号",
first_name VARCHAR (50) NOT NULL comment "名字",
last_name VARCHAR (50) NOT  NULL comment "姓"
email_address VARCHAR (30) NOT NULL UNIQUE comment "邮箱地址",
password VARCHAR (50) NOT NULL comment "账户密码",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(account_id);
KEY idx_emailpassword(email_address,password);
}engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "学生账户表";


-- TODO profile:用户详细信息表 是否对外展示  希望工作类型  技能  工作经验 教育背景 项目 访问问题  工作要求

-- 专题列表
-- TODO 有两部风内容被没有写入，一个是教师列表，一个是课程列表，问题列表
CREATE TABLE if NOT EXISTS specialization{
specialization_id unsigned INT auto_increment comment "专题编号",
category VARCHAR (20)NOT NULL comment "目录",
subject VARCHAR (20) NOT NULL comment "学科",
title VARCHAR (50) NOT NULL UNIQUE comment "专题标题",
short_desc VARCHAR (100) NOT NULL comment "简短描述",
description VARCHAR (255)NOT NULL comment "描述",
img VARCHAR (100) NOT  NULL comment "图片描述",
provider_id unsigned INT NOT NULL "提供方id",
time_start date_time NOT NULL comment "开始时间",
time_end date_time NOT NULL comment "结束时间",
}engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "学科专题表";


-- 课程列表
-- TODO 有两部风内容被没有写一个是，问题列表，评论打分，每周学习表
CREATE TABLE if NOT EXISTS course{
course_id unsigned INT auto_increment comment "课程编号",
subject VARCHAR (20) NOT NULL comment "所属学科",
title VARCHAR (50) NOT NULL UNIQUE comment "课程标题",
description VARCHAR (500)NOT NULL comment "课程概述",
condition VARCHAR (255) comment "课程前提条件",
provider_id VARCHAR (50) INT NOT NULL "制作方",
teacher_id unsigned INT NOT NULL "教学方id",
time_start date_time NOT NULL comment "开始时间",
time_end date_time NOT NULL comment "结束时间",
level  VARCHAR (10) comment "适用级别",
time_per_week VARCHAR (10) comment "平均每周学习时间",
language VARCHAR (50) NOT NULL comment "授课语言",
pass_condition VARCHAR (50) NOT NULL comment "通过条件",
score_average unsigned FLOAT  DEFAULT comment "学生打分",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(course_id),
KEY idx_subject(subject)
}engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "课程信息表";

-- 课程提供方信息
CREATE TABLE if NOT EXISTS provider(
provider_id unsigned INT auto_increment comment "课程编号",
-- TODO
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(provider_id),
)engine=innodb auto_increment=100 DEFAULT charset=utf8  COMMENT "课程提供方信息表";

-- 授课教师信息
CREATE TABLE if NOT EXISTS teacher(
teacher_id unsigned INT auto_increment comment "授课教师编号",
-- TODO
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(teacher_id),
)engine=innodb auto_increment=100 DEFAULT charset=utf8  COMMENT "授课教师信息表";

--课程问题列表回答表，这和其它讨论区的问题不同
CREATE TABLE if NOT EXISTS question_reply(
question_reply_id unsinged bigint auto_increment comment "问题编号",
course_id unsiged INT NOT  NULL comment "课程编号",
question_content VARCHAR (100) NOT  NULL comment "问题",
reply VARCHAR (100) NOT NULL  comment "回答",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(question_reply_id),
KEY idx_course_id(course_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "课程回答信息表";

-- 评论信息表
CREATE TABLE if NOT EXISTS comment(
comment_id unsigned bitint auto_increment comment "评论编号",
course_id usigned INT  NOT NULL comment "课程编号",
account_id unsiged INT NOT NULL comment "用户编号",
score unsigned tinyint NOT NULL DEFAULT 5.0 comment "打分",
comment VARCHAR (100) NOT NULL DEFAULT "" comment "评论",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(comment_id),
KEY idx_course_id(course_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "课程评论信息表";


-- 授课大纲，包含阅读，视频，每周测试
CREATE TABLE if NOT EXISTS week_task(
week_task_id unsiged INT comment "每周任务编号",
course_id unsigned INT comment "课程编号",
content VARCHAR (50) NOT NULL comment "本周内容",
time_start date_time NOT NULL comment "开始时间",
time_end date_time NOT NULL comment "结束时间",
introduction VARCHAR (500) NOT NULL comment "介绍",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(week_task_id),
KEY idx_course_id(course_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "每周信息表";

-- 每周任务列表,拥有真实部分
CREATE TABLE if NOT EXISTS task(
task_id unsigned INT auto_increment comment "任务编号",
week_task_id unsiged INT NOT NULL "每周任务",
title VARCHAR (10) NOT NULL comment "小节标题",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(task_id),
KEY idx_week_task_id(week_task_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "每周任务小节表";

-- 教学内容表
CREATE TABLE if NOT EXISTS task_item(
task_item_id unsigned INT auto_increment comment "任务部分编号",
task_id unsigned INT  comment "任务编号",
title VARCHAR (50) NOT NULL comment "标题",
time_length unsigned tinyint NOT NULL "时间长度",
video_id unsigned INT comment "视频内容编号",
wiki_id unsigned INT comment "wiki内容编号",
test_id unsigned INT comment "测试编号",
like unsigned INT NOT NULL DEFAULT 0 comment "点赞",
trample unsigned INT NOT NULL DEFAULT 0 comment "踩",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(task_item_id),
KEY idx_task_id(task_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "具体内容表";

-- 视频表,字幕就不做了，之后在做吧
CREATE TABLE if NOT EXISTS video(
video_id unsigned INT auto_increment comment "视频编号",
task_item_id unsigned INT NOT NULL comment "具体小节编号"
link VARCHAR (100) NOT NULL comment "视频地址",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(video_id),
KEY idx_task_item_id(task_item_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "视频表";

-- wiki内容表
CREATE TABLE if NOT EXISTS wiki(
wiki_id unsigned INT auto_increment comment "wiki编号",
task_item_id unsigned INT NOT NULL comment "具体小节编号"
content VARCHAR (1000)  NOT NULL "wiki内容",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(wiki_id),
KEY idx_task_item_id(task_item_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "wiki表";

-- 测试算是一个模块
-- 测试表
CREATE TABLE if NOT EXISTS test(
test_id unsigned INT auto_increment comment "测试编号",
task_item_id unsigned INT NOT NULL comment "具体小节编号",
-- TODO
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(test_id),
KEY idx_task_item_id(task_item_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "测试表";

--用户已经参加的课,是一个中间表
CREATE TABLE if NOT EXISTS course_join(
course_join_id unsigned bigint auto_increment comment "id编号",
course_id unsigned INT NOT NULL comment "已经参加的课id",
account_id unsigned INT NOT NULL comment "用户id",
gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(course_join_id),
KEY idx_account_id(account_id)
)engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "用户课程表";

-- TODO 用户课程进度表

-- TODO 总体进度表

-- TODO 题目表具体放到mongodb中,这样更加好处理
-- -- -- 题目表
-- CREATE TABLE if NOT EXISTS question(
-- id unsigned bigint auto_increment comment "题目编号",
-- test_id unsigned INT auto_increment comment "测试编号",
-- question_content VARCHAR (100)NOT NULL comment "题目",
-- gmt_create date_time NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(id),
-- KEY idx_test_id(test_id)
-- )engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "试题表";

-- TODO 论坛,交流是一个模块,之后在做吧
-- /learn/machine-learning/discussions/weeks/1

-- 观看记录表
CREATE TABLE if NOT EXISTS task_item_log(
id BIGINT PRIMARY KEY  auto_increment COMMENT "编号",
account_id INT NOT NULL COMMENT "用户编号",
task_item_id INT NOT NULL  COMMENT "课程编号" ,
KEY index_useid_course_id(task_item_id,account_id)
)engine=innodb  DEFAULT charset=utf8  COMMENT "观看记录表";


