--创建数据库
CREATE DATABASE IF NOT EXISTS easyoj;
USE easyoj;
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
time_start datetime NOT NULL comment "开始时间",
time_end datetime NOT NULL comment "结束时间",
}engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "学科专题表";

-- 课程提供方信息
CREATE TABLE if NOT EXISTS provider(
provider_id unsigned INT auto_increment comment "课程编号",
-- TODO
gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(provider_id),
)engine=innodb auto_increment=100 DEFAULT charset=utf8  COMMENT "课程提供方信息表";

-- 授课教师信息
CREATE TABLE if NOT EXISTS teacher(
teacher_id unsigned INT auto_increment comment "授课教师编号",
-- TODO
gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
PRIMARY KEY pk_id(teacher_id),
)engine=innodb auto_increment=100 DEFAULT charset=utf8  COMMENT "授课教师信息表";

-- 视频表,字幕就不做了，之后在做吧
CREATE TABLE if NOT EXISTS video(
video_id unsigned INT auto_increment comment "视频编号",
task_item_id unsigned INT NOT NULL comment "具体小节编号"
link VARCHAR (100) NOT NULL comment "视频地址",
gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
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
gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
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
gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
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
gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
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
-- gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(id),
-- KEY idx_test_id(test_id)
-- )engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "试题表";

-- TODO 论坛,交流是一个模块,之后在做吧
-- /learn/machine-learning/discussions/weeks/1

-- TODO 课程小节任务完成日志记录表

------------------------------------我是分界线---------------------
-- 创建学生用户账户表
-- 这里的考量是id 不会达到那么大的数据量
-- 注：这里采用邮箱和密码来做覆盖索引，提高查找性能
-- 注：用户详细信息还是要关联账户详细信息表的
CREATE TABLE IF NOT EXISTS account(
account_id  INT UNSIGNED  PRIMARY KEY AUTO_INCREMENT  COMMENT "账户编号",
first_name VARCHAR (50) NOT NULL COMMENT "名字",
last_name VARCHAR (50) NOT  NULL COMMENT "姓",
email_address VARCHAR (30) NOT NULL UNIQUE COMMENT "邮箱地址",
account_photo VARCHAR (255) NOT NULL DEFAULT "" COMMENT "用户头像",
password VARCHAR (50) NOT NULL COMMENT "账户密码",
alive TINYINT NOT NULL DEFAULT 1 COMMENT "账户是否有效",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_emailpassword(email_address,password)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="学生账户表";

--目录表 :一级目录
CREATE TABLE IF NOT EXISTS catalog(
catalog_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "目录列表项编号",
catalog_name VARCHAR (20) NOT NULL COMMENT "目录项名",
catalog_description VARCHAR (200) NOT NULL COMMENT "描述",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间"
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT="一级目录表";

--学科表：二级目录
CREATE TABLE IF NOT EXISTS subject(
subject_id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "学科编号",
subject_name VARCHAR (50) NOT NULL COMMENT "学科名字",
catalog_id TINYINT UNSIGNED COMMENT "目录列表项编号",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY (catalog_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT="二级学科表";

-- 课程列表
CREATE TABLE IF NOT EXISTS course(
course_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "课程编号",
subject_id SMALLINT UNSIGNED NOT NULL COMMENT "所属学科编号",
course_name VARCHAR (50) NOT NULL UNIQUE COMMENT "课程名",
description VARCHAR (500)NOT NULL COMMENT "课程概述",
pre_condition VARCHAR (255) COMMENT "课程前提条件",
course_image VARCHAR (255) NOT NULL COMMENT "课程描述图片",
provider_name VARCHAR (50) NOT NULL COMMENT "课程提供方名称",
provider_logo VARCHAR (255) NOT NULL COMMENT "课程提供方logoUrl",
provider_id INT UNSIGNED NOT NULL COMMENT "课程提供方信息编号",
teacher_photo VARCHAR (255) NOT NULL COMMENT "授课老师头像",
teacher_name VARCHAR (50) NOT NULL COMMENT "授课老师姓名",
teacher_job_title VARCHAR (20) NOT NULL COMMENT "授课教师职称",
teacher_signature VARCHAR (100) COMMENT "授课教师签名",
teacher_id INT UNSIGNED NOT NULL COMMENT "授课老师信息编号",
time_start DATETIME NOT NULL COMMENT "开始时间",
time_end DATETIME NOT NULL COMMENT "结束时间",
student_level  VARCHAR (10) COMMENT "适用学生级别",
time_learn VARCHAR (10) COMMENT "平均每周学习时间",
language_to_teach VARCHAR (50) NOT NULL COMMENT "授课语言",
pass_condition VARCHAR (50) NOT NULL COMMENT "通过条件",
price_with_certificate DECIMAL (10,2) DEFAULT 0.00 COMMENT "有证书的价格",
price_with_no_certificate DECIMAL (10,2) DEFAULT 0.00 COMMENT "没有证书的价格",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_subject_id(subject_id),
KEY idx_course_name(course_name),
KEY idx_provider_id(provider_id),
KEY idx_teacher_id(teacher_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="课程信息表";

--课程问题列表回答表
CREATE TABLE IF NOT EXISTS question_reply(
question_reply_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "问题编号",
course_id INT UNSIGNED NOT NULL COMMENT "课程编号",
question_content VARCHAR (100) NOT  NULL COMMENT "问题概述",
reply VARCHAR (255) NOT NULL  COMMENT "回答",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_course_id(course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="课程回答信息表";

-- 评论信息表
CREATE TABLE IF NOT EXISTS comment(
comment_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "评论编号",
course_id INT UNSIGNED NOT NULL COMMENT "课程编号",
account_id INT UNSIGNED NOT NULL COMMENT "用户编号",
score TINYINT UNSIGNED NOT NULL DEFAULT 5.0 COMMENT "打分",
comment_content VARCHAR (255) NOT NULL DEFAULT "" COMMENT "评论",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_course_id(course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="课程评论信息表";

-- 授课大纲，包含阅读，视频，每周测试
CREATE TABLE IF NOT EXISTS week_task(
week_task_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "每周任务编号",
course_id INT UNSIGNED COMMENT "课程编号",
content_title VARCHAR (50) NOT NULL DEFAULT "" COMMENT "本周内容标题",
introduction VARCHAR (500) NOT NULL COMMENT "周内容介绍",
time_start DATETIME NOT NULL COMMENT "开始时间",
time_end DATETIME NOT NULL COMMENT "结束时间",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_course_id(course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="每周信息表";

-- 每周学习单元表
CREATE TABLE IF NOT EXISTS task(
task_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "单元编号",
week_task_id INT UNSIGNED NOT NULL COMMENT "课程周编号",
order_in_week TINYINT UNSIGNED COMMENT "课程章节顺序编号",
title VARCHAR (20) NOT NULL COMMENT "小节标题",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_week_task_id(week_task_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="每周任务表";

-- 教学内容表，将单元检测已经剥离出去
CREATE TABLE IF NOT EXISTS task_item(
task_item_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "任务部分编号",
task_id INT UNSIGNED COMMENT "单元编号",
title VARCHAR (50) NOT NULL COMMENT "标题",
time_length TINYINT UNSIGNED NOT NULL COMMENT"时间长度",
video_info_id INT UNSIGNED COMMENT "视频统计信息编号",
video_url VARCHAR (255) COMMENT "视频地址资源",
wiki_id INT UNSIGNED COMMENT "wiki内容编号",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_task_id(task_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="具体内容表";

-- 用户购买选课记录表
CREATE TABLE IF NOT EXISTS course_purchased_record(
course_purchased_record_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "用户购买记录编号",
account_id INT UNSIGNED NOT NULL COMMENT "用户编号",
course_id INT UNSIGNED NOT NULL COMMENT "课程编号",
valid TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT "默认是有效",
paid TINYINT UNSIGNED NOT NULL DEFAULT 0  COMMENT "是否已经付款",
price_course DECIMAL (10,2) NOT NULL  COMMENT "课程价格",
price_paid_actual DECIMAL(10,2) NOT NULL COMMENT "实际付款",
discount_percent TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "折扣优惠百分比",
method_paid TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT "选择支付方式 1.网银 2.支付宝 3.微信",
bill_code VARCHAR (255) NOT NULL DEFAULT "" COMMENT "用户支付后生成的账单号",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY (account_id,course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="用户购买记录表";

------------------------------------我是分界线------------------
-- data 数据  先插入一些记录数据
-- 用户账户小表数据
INSERT INTO account(first_name,last_name,email_address,password) VALUES ('katey2658','jian','katey2658@gmail.com','wangdong1995');
INSERT INTO account(first_name,last_name,email_address,password) VALUES ('katey8888','dong','katey8888@gmail.com','wangdong1995');

-- 目录大专业表数据
INSERT INTO catalog(catalog_name,catalog_description)
VALUES ('艺术与人文','艺术与人文专项课程（包括美术、历史和哲学）探讨创造性工作的历史，让您学会批判性审阅原始材料，找出不同观点间的联系，对论据和论点做出判断。该领域中的课程将让您成为一名更好的读者、思考者、艺术家和作家。')
,('商务','商务专项课程提高您在现代工作中所需的重要技能，具体内容包括创业、商业战略、营销、金融和管理。无论您是一位小企业主，还是在大型跨国公司工作，商务课程都将提升您分析、理解和解决商业问题的能力。')
,('计算机科学','计算机科学专项课程教授软件工程和设计、算法思维、人机交互、变成语言和计算机历史。本类课程涉及领域比较宽泛，它们将帮助您提高抽象思维能力，系统性地解决问题，提出合理的解决方案。');
INSERT INTO catalog(catalog_name,catalog_description)
VALUES ('数据科学','数据科学专项课程内容包括解读数据、分析数据和提出可操作性意见相关的基础知识。初学者和高水平学习者都能找到合适课程，例如定量和定性数据分析、数据处理的工具和方法、机器学习算法。')
,('生命科学','生命科学专项课程探讨生物体和生态系统的性质，具体内容包括生物学、营养学、动物学和保健。本类课程将让您加强对动物和植物的理解，提高分析复杂系统中个体交互和应对改变方式的能力。')
,('数学与逻辑','在专项课程中，您将学习使用数学和逻辑知识解决定量和抽象问题。您需要完成逻辑试题，学习计算技能，抽象描述真实世界的各种现象，以及加强推理能力。');
INSERT INTO catalog(catalog_name,catalog_description)
VALUES ('个人发展','个人发展专项课程介绍个人成长的战略和框架、目标设定以及自我改进。您将学习个人金融管理，发表印象深刻的演讲，进行道德决策，以及创造性思维。')
,('物理科学与工程','物理科学和工程专项课程向学生讲解周围世界的性质，内容从物理和化学核心概念，直到工程中实际应用主题。如果您希望从事电子、土木或机械工程工作，或者进行相关研究和应用，本类课程将为您打下基础。')
,('社会科学','社会科学专项课程探讨人们如何制定法律，做出决策，进行群体行动，以及组织结构化社区。通过教育学、经济学和心理学课程，学生将加强对个人和集体关系的理解，学生将掌握分析行为和趋势的能力。');
INSERT INTO catalog(catalog_name,catalog_description)
VALUES ('语言学习','在语言课程和专项课程中，您要学习使用全球主要语言，包括英语、汉语、西班牙语等有效地进行听说读写。无论您是学习一门外语，还是提高母语的沟通能力，本领域的课程都将帮助您了解语法和句法，并让您在商务会谈和随意性会话中放任自如。');

-- 对学科表插入一些数据
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('历史',10),('音乐与艺术',10),('哲学',10);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('领导与管理',11),('金融',11),('营销',11),('创业',11),('商务核心',11),('商业战略',11);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('软件开发',12),('移动与网络开发',12),('算法',12),('计算机安全和网络',12),('设计和产品',12);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('数据分析',13),('机器学习',13),('概率论与数理统计',13);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('动物与兽医科学',14),('生物信息学',14),('生物',14),('医疗保健',14),('营养',14),('临床医学',14);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('数学与逻辑',15);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('个人发展',16);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('电子工程',17),('机械工程',17),('化学',17),('环境科学与持续发展',17),('物理与天文学',17),('研究方法',17);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('经济学',18),('教育',18),('政府与社会',18),('法律',18),('心理学',18);
INSERT INTO subject(subejct_name,catalog_id)
VALUES ('学习英语',19),('其它语言',19);
-- TODO 课程表信息数据

-- TODO 课程表常见问题和回答数据

-- TODO 评论表信息数据

