# 终端Terminal登录本地数据库命令 -p后面的12345678是本地mysql的密码
# mysql -uroot -p123456
# 本地登录后查看数据库
show databases;
# 本地创建数据库
create database learn;
# 使用新建数据库
use learn;
# 在数据库learn下新建一张表

CREATE TABLE `user_lesson_ai`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '上课记录自增主键',
    `uid`             bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
    `t_no`            varchar(255) NOT NULL DEFAULT '' COMMENT 'T顶层体系编号',
    `g_no`            varchar(255) NOT NULL DEFAULT '' COMMENT 'G体系编号',
    `u_no`            varchar(255) NOT NULL DEFAULT '' COMMENT 'U单元体系编号',
    `course_id`       bigint(20) NOT NULL DEFAULT '0' COMMENT '课件主键ID',
    `course_no`       varchar(255) NOT NULL DEFAULT '' COMMENT '课程编号',
    `deduct_hours`    float(10,2) DEFAULT '0.00' COMMENT '本节课扣除的课时,小数点保留2位',
    `course_type`     int(11) NOT NULL DEFAULT '0' COMMENT '课程类型,1:优享AI课',
    `status`          int(11) NOT NULL DEFAULT '0' COMMENT 'AI课状态 0=>''已创建-用户下单优享成功后，根据课程体系创建'', 1=>''待上课'', 2=>''进行中'', 3=>''已到课',
    `redeem_time`     int(11) NOT NULL DEFAULT '0' COMMENT '课程兑换时间(AI课兑换时间),单位:秒',
    `attend_time`     int(11) NOT NULL DEFAULT '0' COMMENT '学生上课时间,单位:秒',
    `ctime`           int(11) NOT NULL DEFAULT '0' COMMENT '创建时间,单位:秒',
    `utime`           int (11) NOT NULL DEFAULT '0' COMMENT '更新时间,单位:秒',
    `attend_duration` int (11) NOT NULL DEFAULT '0' COMMENT '本节课学生累加上课时长,单位:秒',
    `comment`         varchar(255) NOT NULL DEFAULT '' COMMENT '学生对课程点评内容',
    `cid`             int (11) NOT NULL DEFAULT '0' COMMENT '创建记录的管理员ID',
    `mid`             int (11) NOT NULL DEFAULT '0' COMMENT '修改记录的管理员ID',
    `del`             int (11) NOT NULL DEFAULT '0' COMMENT '是否删除, 0:未删除 1:已删除',
    `note`            varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
    `subject_id`      bigint(20) NOT NULL DEFAULT '0' COMMENT '科目id',
    `complete_time`   int(11) NOT NULL DEFAULT '0' COMMENT '学习完课程时间,单位:秒',
    `buy_id`          int (11) NOT NULL DEFAULT '0' COMMENT '优享订单ID',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_uid_courseId` (`uid`, `course_id`),
    UNIQUE KEY `idx_uid_courseno` (`uid`, `course_no`),
    KEY               `idx_no` (`u_no`)
) ENGINE = InnoDB COMMENT = '优享AI课上课记录表';
