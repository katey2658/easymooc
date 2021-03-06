--创建数据库
CREATE DATABASE IF NOT EXISTS easyoj;
USE easyoj;

-- 创建学生用户账户表
-- 这里的考量是id 不会达到那么大的数据量
-- 注：这里采用邮箱和密码来做覆盖索引，提高查找性能
-- 注：用户详细信息还是要关联账户详细信息表的
CREATE TABLE IF NOT EXISTS account_info(
account_id  INT UNSIGNED  PRIMARY KEY AUTO_INCREMENT  COMMENT "账户编号",
account_no VARCHAR (32) NOT NULL  COMMENT "用户账号：可以修改",
mobile_no VARCHAR (11) COMMENT "用户手机号",
email_address VARCHAR (30) NOT NULL UNIQUE COMMENT "邮箱地址",
account_type TINYINT UNSIGNED NOT NULL COMMENT "账户类型 1: 学生 2.老师",
password VARCHAR (50) NOT NULL COMMENT "账户密码:需要加密",
gender TINYINT NOT NULL DEFAULT 1 COMMENT "用户性别:0 无 1 男 2 女",
age TINYINT UNSIGNED COMMENT "用户年龄",
profession VARCHAR (20) COMMENT "用户职业",
institution VARCHAR (50)  COMMENT "工作机构",
first_name VARCHAR (50) NOT NULL COMMENT "名字",
last_name VARCHAR (50) NOT  NULL COMMENT "姓",
account_name VARCHAR (100) NOT NULL COMMENT "账户名",
account_photo VARCHAR (255) NOT NULL DEFAULT "" COMMENT "用户头像",
account_state TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT "账户状态:0:正常  1.等待激活  2.注销  3.冻结",
account_level TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "账户等级:0",
address VARCHAR (50) COMMENT "住址",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_emailpassword(email_address,password),
KEY idx_accountno(account_no),
UNIQUE (account_no),
UNIQUE (mobile_no),
UNIQUE (email_address)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="学生账户表";

CREATE TABLE IF NOT EXISTS account_info_ex(
account_info_ex_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "用户拓展表编号",
account_info_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "用户账户编号",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间"
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="学生账户表";

-- 关于用户权限记录表
CREATE TABLE IF NOT EXISTS account_authority(
authority_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT  COMMENT "编号",
account_id BIGINT UNSIGNED COMMEdcvvvvvvdvNT "用户编号",
account_no VARCHAR (32) NOT NULL  COMMENT "用户账号：可以修改",
authority VARCHAR (10) NOT NULL DEFAULT "USER" COMMENT "用户权限",
active BOOL NOT NULL DEFAULT true COMMENT "默认有效",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_accountno(account_no)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="用户权限表";

-- 验证码记录表
CREATE TABLE IF NOT EXISTS account_verification(
verification_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT  COMMENT "编号",
account_id BIGINT UNSIGNED COMMENT "账户编号",
account_no VARCHAR (32) COMMENT "用户账号",
mobile VARCHAR (11) COMMENT "用户手机号",
email_address VARCHAR (30) COMMENT "邮箱地址",
error_input TINYINT NOT DEFAULT 0 COMMENT "输入错误次数",
verification_code VARCHAR (10) NOT NULL COMMENT "验证码",
invalid_time DATETIME NOT NULL COMMENT "验证码失效时间",
verification_state TINYINT NOT NULL DEFAULT 1 COMMENT "验证状态: 0.无效 1.正常 2.超时失效 3.验证",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除"
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="验证码记录表";

--目录表 :一级目录
CREATE TABLE IF NOT EXISTS course_catalog(
catalog_id TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "目录列表项编号",
catalog_name VARCHAR (20) NOT NULL COMMENT "目录项名",
catalog_desc VARCHAR (200) NOT NULL DEFAULT "" COMMENT "描述",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间"
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT="一级目录表";

--学科表：二级目录
CREATE TABLE IF NOT EXISTS course_subject(
subject_id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "学科编号",
catalog_id TINYINT UNSIGNED COMMENT "目录列表项编号",
subject_name VARCHAR (50) NOT NULL COMMENT "学科名字",
subject_desc  VARCHAR (100) NOT NULL DEFAULT "" COMMENT "学科描述",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY (catalog_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT="二级学科表";

-- 课程列表
CREATE TABLE IF NOT EXISTS course_info(
course_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "课程编号",
subject_id SMALLINT UNSIGNED NOT NULL COMMENT "所属学科编号",
course_name VARCHAR (50) NOT NULL UNIQUE COMMENT "课程名",
description VARCHAR (500)NOT NULL COMMENT "课程概述",
overt BOOL NOT NULL DEFAULT FALSE COMMENT "是否公开",
invite_code VARCHAR (20) COMMENT "邀请码",
pre_condition VARCHAR (255) COMMENT "课程前提条件",
course_image VARCHAR (255) NOT NULL COMMENT "课程描述图片",
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
max_number INT  NOT NULL DEFAULT 65525 COMMENT "学生人数限制",
course_state TINYINT NOT NULL DEFAULT 1 COMMENT "课程状态:1.审核中  2.正常  3. 还没有开始  4.满员  5.冻结  6.过期",
price_with_certificate DECIMAL (10,2) DEFAULT 0.00 COMMENT "有证书的价格",
price_with_no_certificate DECIMAL (10,2) DEFAULT 0.00 COMMENT "没有证书的价格",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_subject_id(subject_id),
KEY idx_course_name(course_name),
KEY idx_teacher_id(teacher_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="课程信息表";

--课程问题列表回答表
CREATE TABLE IF NOT EXISTS course_question(
question_reply_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "问题编号",
course_id INT UNSIGNED NOT NULL COMMENT "课程编号",
question_content VARCHAR (100) NOT  NULL COMMENT "问题概述",
reply VARCHAR (255) NOT NULL  COMMENT "回答",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_course_id(course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8  COMMENT="课程回答信息表";

-- 评论信息表
CREATE TABLE IF NOT EXISTS course_comment(
comment_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "评论编号",
course_id INT UNSIGNED NOT NULL COMMENT "课程编号",
account_id INT UNSIGNED NOT NULL COMMENT "用户编号",
score TINYINT UNSIGNED NOT NULL DEFAULT 5.0 COMMENT "打分",
comment_content VARCHAR (255) NOT NULL DEFAULT "" COMMENT "评论",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_course_id(course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="课程评论信息表";

-- 创建测试表
CREATE TABLE IF NOT EXISTS quiz_task(
quiz_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "测试编号",
quiz_code VARCHAR (16) NOT NULL COMMENT "测试编码：按规则自动生成",
quiz_title VARCHAR (50) NOT NULL COMMENT "测试标题:默认是测试编码",
course_id INT UNSIGNED NOT NULL COMMENT "课程编号",
teacher_id INT UNSIGNED NOT NULL COMMENT "教师账户编号",
quiz_type TINYINT NOT NULL DEFAULT 3 COMMENT"测试类型：1.单元测试  2.阶段性测试  3.综合测试  4.问卷测试：非课程知识点 ",
unit_number TINYINT UNSIGNED COMMENT "单元号",
stage_number TINYINT UNSIGNED COMMENT "阶段编号：一般来说,大于等于该阶段的题都符合",
questionnaire_code VARCHAR (20) COMMENT "问卷编码",
auto_fit BOOL NOT NULL DEFAULT FALSE COMMENT "是否自动组卷",
time_start DATETIME NOT NULL COMMENT "开始时间",
time_end DATETIME NOT NULL COMMENT "结束时间",
duration BIGINT UNSIGNED NOT NULL COMMENT "持续时间",
quiz_state TINYINT NOT NULL DEFAULT 3 COMMENT "测试状态:1.审核中  2.正常  3. 还没有开始  4.废弃  5.冻结  6.过期 ",
full_score TINYINT UNSIGNED NOT NULL DEFAULT 100 COMMENT "满分成绩：默认100分",
single BOOL NOT NULL DEFAULT FALSE COMMENT "是否有单选:默认false",
single_weight TINYINT UNSIGNED NOT NULL DEFAULT 5 COMMENT "单选题分值权重:5",
single_number TINYINT UNSIGNED NOT NULL DEFAULT 20 COMMENT "单选题数目，默认20",
single_easy_weight TINYINT UNSIGNED NOT NULL DEFAULT 5 COMMENT "单选题中简单权重",
single_middle_weight TINYINT UNSIGNED NOT NULL DEFAULT 3 COMMENT "单选题中中等权重",
single_hard_weight TINYINT UNSIGNED NOT NULL DEFAULT 2 COMMENT "单选题中困难题型权重",
multiple BOOL NOT NULL DEFAULT FALSE COMMENT "是否含有复选题目",
multiple_weight TINYINT UNSIGNED NOT NULL DEFAULT 5 COMMENT "多选题分值权重",
multiple_numbers TINYINT UNSIGNED NOT NULL DEFAULT 20 COMMENT "多选题题目数量",
multiple_easy_weight TINYINT UNSIGNED NOT NULL DEFAULT 5 COMMENT "多选题中简单权重",
multiple_middle_wieght TINYINT UNSIGNED NOT NULL DEFAULT 3 COMMENT "多选题中中等权重",
multiple_hard_weight TINYINT UNSIGNED NOT NULL DEFAULT 2 COMMENT "多选题中困难权重",
complete BOOL NOT NULL DEFAULT FALSE COMMENT "是否有填空题",
complete_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "填空题分值权重",
complete_number TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "填空题数量",
complete_easy_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "填空题简单权重",
complete_middle_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "填空题中等权重",
complete_hard_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "填空题困难权重",
resume BOOL NOT NULL DEFAULT FALSE COMMENT "是否有简述题",
resume_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "简述题分值权重",
resume_number TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "简述题数量",
resume_easy_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "简述题简单权重",
resume_middle_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "简述题中等权重",
resume_hard_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "简述题困难权重",
synthesis BOOL NOT NULL DEFAULT FALSE COMMENT "是否有综合题",
synthesis_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "综合题分值权重",
synthesis_number TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "综合题数量",
synthesis_easy_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "综合题简单权重",
synthesis_middle_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "综合题中等权重",
synthesis_hard_weight TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "综合题困难权重",
extra BOOL NOT NULL DEFAULT FALSE COMMENT "是否有附加题",
extra_score TINYINT UNSIGNED NOT NULL DEFAULT 10 COMMENT "附加题分数",
extra_item_id BIGINT UNSIGNED COMMENT "附加题考题",
points VARCHAR (255) NOT NULL COMMENT "考点：多个考点之间用逗号进行分割",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_courseid(course_id),
KEY idx_quizstate(quiz_state),
UNIQUE (quiz_code)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="测试信息表";

-- 创建测试题目表
CREATE TABLE IF NOT EXISTS quiz_item(
item_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "题目编号",
course_id INT NOT NULL COMMENT "课程编号",
unit_number TINYINT UNSIGNED COMMENT "单元号(作为单元测试参考项)",
stage_number TINYINT UNSIGNED COMMENT "阶段编号(作为阶段测试参考项)",
questionnaire_code VARCHAR (16) COMMENT "测试编码(作为问卷测试参考项)",
item_type TINYINT  NOT NULL DEFAULT 1 COMMENT "题目类型：1.单选  2.多选  3.填空题  4.简答题  5.综合题  6.附加题",
item_state TINYINT NOT NULL DEFAULT 2 COMMENT "状态：1.审核中  2.正常  3.废弃  4.冻结，被排除  默认正常",
item_content VARCHAR (255) NOT NULL COMMENT "题目内容",
accachment VARCHAR (100) COMMENT "附件：一般为图片，暂时没有其它的打算",
option_a VARCHAR (50) COMMENT "选项A",
a_right BOOL NOT NULL DEFAULT FALSE COMMENT "A选项是否正确",
option_b VARCHAR (50) COMMENT "选项B",
b_right BOOL NOT NULL DEFAULT FALSE COMMENT "B选项是否正确",
option_c VARCHAR (50) COMMENT "选项C",
c_right BOOL NOT NULL DEFAULT FALSE COMMENT "C选项是否正确",
option_d VARCHAR (50) COMMENT "选项D",
d_right BOOL NOT NULL DEFAULT FALSE COMMENT "D选项是否正确",
option_e VARCHAR (50) COMMENT "选项E",
e_right BOOL NOT NULL DEFAULT FALSE COMMENT "E选项是否正确",
complete_number TINYINT NOT NULL DEFAULT 0 COMMENT "填空数<=3：当为填空题的时候进行需要填写的内容",
a_complete VARCHAR (20) COMMENT "填空A答案",
b_complete VARCHAR (20) COMMENT "填空B答案",
c_complete VARCHAR (20) COMMENT "填空C答案",
resume_right VARCHAR (100) COMMENT "简述题答案",
synthesis_right VARCHAR (100) COMMENT "综合题答案",
synthesis_right_attachment VARCHAR (100) COMMENT "综合题附件：一般为图片",
points VARCHAR (50) NOT NULL DEFAULT ""  COMMENT "考点",
degree_of_difficulty TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT "难度系数",
degree_of_frequency TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT "频率系数:频率越大，同等条件下，越不容易被选到",
item_weight TINYINT UNSIGNED NOT NULL DEFAULT 5 COMMENT "题目权重,也就是重要值，这个一般是由录入者来进行确定，但也会出现相应的变化",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_courseid(course_id),
KEY idx_itemtype(item_type)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="题目信息表";

-- 测试相关参数表
CREATE TABLE IF NOT EXISTS quiz_record(
record_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "考卷编号",
quiz_id BIGINT UNSIGNED NOT NULL COMMENT "考试编号",
account_id INT UNSIGNED NOT NULL COMMENT "账户编号",
from_record_id BIGINT UNSIGNED COMMENT "如果是同一份试卷，一样的题目",
single_total_score TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "单选成绩",
single_accuracy INT UNSIGNED COMMENT "单选正确率：千分比",
multi_total_score TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "多选总成绩",
multi_accuracy INT UNSIGNED COMMENT "多选正确率:千分比",
complete_score TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "填空题",
complete_accuracy INT UNSIGNED COMMENT "填空正确率：千分比",
resume_score TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "简答题总成绩",
resume_accuracy INT UNSIGNED COMMENT "简述题正确率:千分比",
synthesis_score TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "综合题总成绩",
synthesis_accuracy INT UNSIGNED COMMENT "综合题正确率：千分比",
full_score TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "测试总成绩",
record_state TINYINT NOT NULL DEFAULT 5 COMMENT "测试记录状态：1.考试中  2.正常结束  3.超时  4.异常退出 5.还没有开始",
time_start DATETIME NOT NULL COMMENT "测试开始时间",
time_end DATETIME COMMENT "测试结束时间",
duration BIGINT UNSIGNED COMMENT "考试用时",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY idx_courseid(quiz_id),
KEY idx_accountid(account_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="测试记录表";

-- 考卷详细表
CREATE TABLE IF NOT EXISTS quiz_record_item(
record_item_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "测试试卷题目编号",
record_id BIGINT UNSIGNED NOT NULL COMMENT "测试编号",
item_id BIGINT UNSIGNED NOT NULL COMMENT "题目编号",
answer BOOL NOT NULL DEFAULT FALSE COMMENT "是否正确",
answer_degree INT NOT NULL COMMENT "答案相似度：千分比",
choice_a BOOL NOT NULL DEFAULT FALSE COMMENT "是否选择了A",
choice_b BOOL NOT NULL DEFAULT FALSE COMMENT "是否选择了B",
choice_c BOOL NOT NULL DEFAULT FALSE COMMENT "是否选择了C",
choice_d BOOL NOT NULL DEFAULT FALSE COMMENT "是否选择了D",
choice_e BOOL NOT NULL DEFAULT FALSE COMMENT "是否选择了E",
a_input VARCHAR (20) COMMENT "填空A输入",
b_input VARCHAR (20) COMMENT "填空b输入",
c_input VARCHAR (20) COMMENT "填空c输入",
resume_input VARCHAR (100) COMMENT "简述题输入",
resume_input_attachment VARCHAR (100) COMMENT "简述题附件",
synthesis_input VARCHAR (100) COMMENT "综合题输入",
synthesis_input_attachment VARCHAR (100) COMMENT "综合题输入可以能有附件:一般为图片",
score TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "题目分数",
score_record TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "得分",
feedback VARCHAR (100) DEFAULT "题型反馈",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间"
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="题目记录表";

-- 用户购买课程记录表：这里暂时先不考虑收费问题
CREATE TABLE IF NOT EXISTS course_join_record(
record_id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT "课程加入记录编号",
account_id INT UNSIGNED NOT NULL COMMENT "用户账户编号",
course_id INT UNSIGNED NOT NULL COMMENT "课程编号",
record_state TINYINT NOT NULL DEFAULT 0  COMMENT "状态:0.无效  1.申请中  2.申请被拒绝  3.申请通过  4.等待支付 5.支付成功 ",
price_course DECIMAL (10,2) NOT NULL  DEFAULT 0.00 COMMENT "课程价格",
price_paid_actual DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT "实际付款",
discount_percent INT UNSIGNED NOT NULL DEFAULT 0 COMMENT "折扣优惠千分比",
method_paid TINYINT NOT NULL DEFAULT 1 COMMENT "选择支付方式 1.网银 2.支付宝 3.微信",
bill_code VARCHAR (50) NOT NULL DEFAULT "" COMMENT "用户支付后生成的账单号",
del_flag TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT "删除状态:0 未删除 1.已删除",
gmt_create DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
gmt_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP COMMENT "最后修改时间",
KEY (account_id,course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT="用户购买记录表";

------------------------------------我是分界线---------------------

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

-- 专题列表
-- CREATE TABLE if NOT EXISTS specialization{
-- specialization_id unsigned INT auto_increment comment "专题编号",
-- category VARCHAR (20)NOT NULL comment "目录",
-- subject VARCHAR (20) NOT NULL comment "学科",
-- title VARCHAR (50) NOT NULL UNIQUE comment "专题标题",
-- short_desc VARCHAR (100) NOT NULL comment "简短描述",
-- description VARCHAR (255)NOT NULL comment "描述",
-- img VARCHAR (100) NOT  NULL comment "图片描述",
-- provider_id unsigned INT NOT NULL "提供方id",
-- time_start datetime NOT NULL comment "开始时间",
-- time_end datetime NOT NULL comment "结束时间",
-- }engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "学科专题表";

-- 课程提供方信息
-- CREATE TABLE if NOT EXISTS provider(
-- provider_id unsigned INT auto_increment comment "课程编号",
-- -- TODO
-- gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(provider_id),
-- )engine=innodb auto_increment=100 DEFAULT charset=utf8  COMMENT "课程提供方信息表";

-- 授课教师信息
-- CREATE TABLE if NOT EXISTS teacher(
-- teacher_id unsigned INT auto_increment comment "授课教师编号",
-- gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(teacher_id),
-- )engine=innodb auto_increment=100 DEFAULT charset=utf8  COMMENT "授课教师信息表";

-- 视频表,字幕就不做了，之后在做吧
-- CREATE TABLE if NOT EXISTS video(
-- video_id unsigned INT auto_increment comment "视频编号",
-- task_item_id unsigned INT NOT NULL comment "具体小节编号"
-- link VARCHAR (100) NOT NULL comment "视频地址",
-- gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(video_id),
-- KEY idx_task_item_id(task_item_id)
-- )engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "视频表";

-- wiki内容表
-- CREATE TABLE if NOT EXISTS wiki(
-- wiki_id unsigned INT auto_increment comment "wiki编号",
-- task_item_id unsigned INT NOT NULL comment "具体小节编号"
-- content VARCHAR (1000)  NOT NULL "wiki内容",
-- gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(wiki_id),
-- KEY idx_task_item_id(task_item_id)
-- )engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "wiki表";

-- 测试算是一个模块
-- 测试表
-- CREATE TABLE if NOT EXISTS test(
-- test_id unsigned INT auto_increment comment "测试编号",
-- task_item_id unsigned INT NOT NULL comment "具体小节编号",
-- gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(test_id),
-- KEY idx_task_item_id(task_item_id)
-- )engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "测试表";

--用户已经参加的课,是一个中间表
-- CREATE TABLE if NOT EXISTS course_join(
-- course_join_id unsigned bigint auto_increment comment "id编号",
-- course_id unsigned INT NOT NULL comment "已经参加的课id",
-- account_id unsigned INT NOT NULL comment "用户id",
-- gmt_create datetime NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
-- gmt_modified data_time NOT NULL DEFAULT CURRENT_TIMESTAMP
-- ON UPDATE CURRENT_TIMESTAMP comment "最后修改时间",
-- PRIMARY KEY pk_id(course_join_id),
-- KEY idx_account_id(account_id)
-- )engine=innodb auto_increment=1000 DEFAULT charset=utf8  COMMENT "用户课程表";

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


