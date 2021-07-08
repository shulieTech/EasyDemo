-- 业务库
CREATE DATABASE IF NOT EXISTS easydemo_db DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use easydemo_db;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(16) NOT NULL COMMENT '手机号',
  `password` varchar(16) NOT NULL COMMENT '登录密码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `birth_day` varchar(16) DEFAULT NULL COMMENT '生日',
  `province_name` varchar(64) DEFAULT NULL COMMENT '省',
  `city_name` varchar(64) DEFAULT NULL COMMENT '市',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



-- 影子库
CREATE DATABASE IF NOT EXISTS pt_easydemo_db DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use pt_easydemo_db;

CREATE TABLE `pt_t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(16) NOT NULL COMMENT '手机号',
  `password` varchar(16) NOT NULL COMMENT '登录密码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `birth_day` varchar(16) DEFAULT NULL COMMENT '生日',
  `province_name` varchar(64) DEFAULT NULL COMMENT '省',
  `city_name` varchar(64) DEFAULT NULL COMMENT '市',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


