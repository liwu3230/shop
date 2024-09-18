SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shedlock
-- ----------------------------
DROP TABLE IF EXISTS `shedlock`;
CREATE TABLE `shedlock`
(
    `name`       varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
    `lock_until` timestamp(3) NULL DEFAULT NULL,
    `locked_at`  timestamp(3) NULL DEFAULT NULL,
    `locked_by`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

CREATE TABLE `eb_system_admin`
(
    `id`          smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '后台管理员表ID',
    `account`     varchar(32)  NOT NULL DEFAULT '' COMMENT '后台管理员账号',
    `head_pic`    varchar(255) NOT NULL DEFAULT '' COMMENT '管理员头像',
    `pwd`         varchar(100) NOT NULL DEFAULT '' COMMENT '后台管理员密码',
    `real_name`   varchar(16)  NOT NULL DEFAULT '' COMMENT '后台管理员姓名',
    `roles`       varchar(128) NOT NULL DEFAULT '' COMMENT '后台管理员权限(menus_id)',
    `last_ip`     varchar(16)  NOT NULL DEFAULT '' COMMENT '后台管理员最后一次登录ip',
    `last_time`   int(10) unsigned NOT NULL DEFAULT '0' COMMENT '后台管理员最后一次登录时间',
    `add_time`    int(10) unsigned NOT NULL DEFAULT '0' COMMENT '后台管理员添加时间',
    `login_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '登录次数',
    `level`       tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '后台管理员级别',
    `status`      tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '后台管理员状态 1有效0无效',
    `division_id` int(11) NOT NULL DEFAULT '0' COMMENT '事业部id',
    `is_del`      tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    KEY           `account` (`account`) USING BTREE,
    KEY           `status` (`status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台管理员表';

INSERT INTO `eb_system_admin` (`id`, `account`, `head_pic`, `pwd`, `real_name`, `roles`, `last_ip`, `last_time`,
                               `add_time`, `login_count`, `level`, `status`, `division_id`, `is_del`)
VALUES ('1', 'admin', '/statics/system_images/admin_head_pic.png',
        '$2y$10$Nw3c1OStH4mrTCir9P.wB.J7oeUSwMDMQRuW.4qNTyhcADean.YeS', 'CRMEB', '1', '124.116.164.158', '1669195280',
        '1669194971', '1', '0', '1', '0', '0');

CREATE TABLE `eb_user`
(
    `uid`                  int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `account`              varchar(32)    NOT NULL DEFAULT '' COMMENT '用户账号',
    `pwd`                  varchar(32)    NOT NULL DEFAULT '' COMMENT '用户密码',
    `real_name`            varchar(25)    NOT NULL DEFAULT '' COMMENT '真实姓名',
    `birthday`             int(11) NOT NULL DEFAULT '0' COMMENT '生日',
    `card_id`              varchar(20)    NOT NULL DEFAULT '' COMMENT '身份证号码',
    `mark`                 varchar(255)   NOT NULL DEFAULT '' COMMENT '用户备注',
    `partner_id`           int(11) NOT NULL DEFAULT '0' COMMENT '合伙人id',
    `group_id`             int(11) NOT NULL DEFAULT '0' COMMENT '用户分组id',
    `nickname`             varchar(60)    NOT NULL DEFAULT '' COMMENT '用户昵称',
    `avatar`               varchar(256)   NOT NULL DEFAULT '' COMMENT '用户头像',
    `phone`                char(15)       NOT NULL DEFAULT '' COMMENT '手机号码',
    `add_time`             int(11) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',
    `add_ip`               varchar(16)    NOT NULL DEFAULT '' COMMENT '添加ip',
    `last_time`            int(11) unsigned NOT NULL DEFAULT '0' COMMENT '最后一次登录时间',
    `last_ip`              varchar(16)    NOT NULL DEFAULT '' COMMENT '最后一次登录ip',
    `now_money`            decimal(12, 2) unsigned NOT NULL DEFAULT '0.00' COMMENT '用户余额',
    `brokerage_price`      decimal(12, 2) NOT NULL DEFAULT '0.00' COMMENT '佣金金额',
    `integral`             int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户剩余积分',
    `exp`                  decimal(12, 2) NOT NULL DEFAULT '0.00' COMMENT '会员经验',
    `sign_num`             int(11) NOT NULL DEFAULT '0' COMMENT '连续签到天数',
    `sign_remind`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '签到提醒状态',
    `status`               tinyint(1) NOT NULL DEFAULT '1' COMMENT '1为正常，0为禁止',
    `level`                tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '等级',
    `agent_level`          int(10) NOT NULL DEFAULT '0' COMMENT '分销等级',
    `spread_open`          tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有推广资格',
    `spread_uid`           int(10) unsigned NOT NULL DEFAULT '0' COMMENT '推广元id',
    `spread_time`          int(11) unsigned NOT NULL DEFAULT '0' COMMENT '推广员关联时间',
    `user_type`            varchar(32)    NOT NULL DEFAULT '' COMMENT '用户类型',
    `is_promoter`          tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否为推广员',
    `pay_count`            int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户购买次数',
    `spread_count`         int(11) NOT NULL DEFAULT '0' COMMENT '下级人数',
    `clean_time`           int(11) NOT NULL DEFAULT '0' COMMENT '清理会员时间',
    `addres`               varchar(255)   NOT NULL DEFAULT '' COMMENT '详细地址',
    `adminid`              int(11) unsigned NOT NULL DEFAULT '0' COMMENT '管理员编号 ',
    `login_type`           varchar(36)    NOT NULL DEFAULT '' COMMENT '用户登陆类型，h5,wechat,routine',
    `record_phone`         varchar(11)    NOT NULL DEFAULT '0' COMMENT '记录临时电话',
    `is_money_level`       tinyint(1) NOT NULL DEFAULT '0' COMMENT '会员来源  0: 购买商品升级   1：花钱购买的会员2: 会员卡领取',
    `is_ever_level`        tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否永久性会员  0: 非永久会员  1：永久会员',
    `overdue_time`         bigint(20) NOT NULL DEFAULT '0' COMMENT '会员到期时间',
    `uniqid`               varchar(32)    NOT NULL DEFAULT '' COMMENT '用户唯一值',
    `division_name`        varchar(255)   NOT NULL DEFAULT '' COMMENT '事业部/代理商名称',
    `division_type`        tinyint(1) NOT NULL DEFAULT '0' COMMENT '代理类型：0普通，1事业部，2代理，3员工',
    `division_status`      tinyint(1) NOT NULL DEFAULT '0' COMMENT '代理状态',
    `is_division`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '事业部状态',
    `is_agent`             tinyint(1) NOT NULL DEFAULT '0' COMMENT '代理状态',
    `is_staff`             tinyint(1) NOT NULL DEFAULT '0' COMMENT '员工状态',
    `division_id`          int(11) NOT NULL DEFAULT '0' COMMENT '事业部id',
    `agent_id`             int(11) NOT NULL DEFAULT '0' COMMENT '代理商id',
    `staff_id`             int(11) NOT NULL DEFAULT '0' COMMENT '员工id',
    `division_percent`     int(11) NOT NULL DEFAULT '0' COMMENT '分佣比例',
    `division_change_time` int(11) NOT NULL DEFAULT '0' COMMENT '事业部/代理/员工修改时间',
    `division_end_time`    int(11) NOT NULL DEFAULT '0' COMMENT '事业部/代理/员工结束时间',
    `division_invite`      int(11) NOT NULL DEFAULT '0' COMMENT '代理商邀请码',
    `is_del`               tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否注销',
    PRIMARY KEY (`uid`) USING BTREE,
    KEY                    `account` (`account`) USING BTREE,
    KEY                    `spreaduid` (`spread_uid`) USING BTREE,
    KEY                    `level` (`level`) USING BTREE,
    KEY                    `status` (`status`) USING BTREE,
    KEY                    `is_promoter` (`is_promoter`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

