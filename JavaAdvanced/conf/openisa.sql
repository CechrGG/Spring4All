/**
	初始化数据库OpenISA
*/
CREATE DATABASE IF NOT EXISTS `openisa` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use `openisa`;

SET foreign_key_checks=0;
/**
	初始化用户表
*/

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` ( 
	`user_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID', 
	`user_name` VARCHAR(32) NOT NULL COMMENT '用户名',
	`password` VARCHAR(32) NOT NULL COMMENT '用户密码',
	`age` TINYINT(4) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
	`email` VARCHAR(64) NULL DEFAULT NULL COMMENT '电子邮箱',
	`phone` VARCHAR(20) NULL DEFAULT NULL COMMENT '电话',
	`create_time` DATETIME NOT NULL COMMENT '创建日期', 
	`modify_time` DATETIME NULL DEFAULT NULL COMMENT '修改日期',
	 PRIMARY KEY(`user_id`)		    
	)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COMMENT '用户信息表';

INSERT INTO `t_user` VALUES (1,'guoguo1','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (2,'guoguo2','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (3,'guoguo3','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (4,'guoguo4','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (5,'guoguo5','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (6,'guoguo6','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (7,'guoguo7','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (8,'guoguo8','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (9,'guoguo9','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (10,'guoguo10','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (11,'guoguo11','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (12,'guoguo12','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (13,'guoguo13','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (14,'guoguo14','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (15,'guoguo15','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (16,'guoguo16','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (17,'guoguo17','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (18,'guoguo18','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (19,'guoguo19','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);
INSERT INTO `t_user` VALUES (20,'guoguo20','guoguo', 28, 'wtf@163.com', 'wtf2019', '2019-06-06 12:00:00', NULL);

/**

	初始化角色表
*/

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
	`role_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色ID',
	`role_name` VARCHAR(32) NOT NULL COMMENT '角色名',
	`desc` VARCHAR(127) NULL DEFAULT NULL COMMENT '角色描述',
	PRIMARY KEY(`role_id`)
	)ENGINE=InnoDB DEFAULT CHARSET utf8 COMMENT '角色信息表';

INSERT INTO `t_role` VALUES (1, '超级管理员', '超级管理员');
INSERT INTO `t_role` VALUES (2, '系统管理员', '系统管理员');
INSERT INTO `t_role` VALUES (3, '权限管理员', '权限管理员');
INSERT INTO `t_role` VALUES (4, '运维管理员', '运维管理员');	


/**
	初始化权限表
*/

DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
	`auth_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '权限ID',
	`auth_name` VARCHAR(32) NOT NULL COMMENT '权限名称',
	`desc` VARCHAR(127) NULL DEFAULT NULL COMMENT '权限描述',
	PRIMARY KEY(`auth_id`)
	)ENGINE=InnoDB DEFAULT CHARSET utf8 COMMENT '权限信息表';

INSERT INTO `t_authority` VALUES (1, '界面查看', '界面查看');
INSERT INTO `t_authority` VALUES (2, '系统配置', '系统运维管理');
INSERT INTO `t_authority` VALUES (3, '数据库管理', '数据库管理');

/**
	初始化用户角色关系表
*/

DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` INT(11) UNSIGNED NOT NULL,
	`role_id` INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY(`id`),
	KEY `fk_user_role_user`(`user_id`),
	KEY `fk_user_role_role`(`role_id`),
	CONSTRAINT `fk_user_role_user` FOREIGN kEY(`user_id`) REFERENCES `t_user`(`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE,	
	CONSTRAINT `fk_user_role_role` FOREIGN kEY(`role_id`) REFERENCES `t_role`(`role_id`) ON DELETE NO ACTION ON UPDATE CASCADE
	)ENGINE=InnoDB DEFAULT CHARSET utf8 COMMENT '用户角色关系表';	

INSERT INTO `t_user_role` VALUES (1, 1, 1);
INSERT INTO `t_user_role` VALUES (2, 2, 2);
INSERT INTO `t_user_role` VALUES (3, 3, 3);
INSERT INTO `t_user_role` VALUES (4, 4, 4);
INSERT INTO `t_user_role` VALUES (5, 5, 4);
INSERT INTO `t_user_role` VALUES (6, 6, 1);
INSERT INTO `t_user_role` VALUES (7, 7, 1);
INSERT INTO `t_user_role` VALUES (8, 8, 3);
INSERT INTO `t_user_role` VALUES (9, 9, 2);
INSERT INTO `t_user_role` VALUES (10, 10, 3);
INSERT INTO `t_user_role` VALUES (11, 11, 1);

/**
	初始化角色权限表
*/

DROP TABLE IF EXISTS `t_role_auth`;
CREATE TABLE `t_role_auth` (
	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`role_id` INT(11) UNSIGNED NOT NULL,
	`auth_id` INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY(`id`),
	KEY `fk_role_auth_role`(`role_id`),
	KEY `fk_role_auth_auth`(`auth_id`),
	CONSTRAINT `fk_role_auth_role` FOREIGN KEY(`role_id`) REFERENCES `t_role`(`role_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT `fk_role_auth_auth` FOREIGN KEY(`auth_id`) REFERENCES `t_authority`(`auth_id`) ON DELETE NO ACTION ON UPDATE CASCADE
	)ENGINE=InnoDB DEFAULT CHARSET utf8 COMMENT '角色权限关系表';

INSERT INTO `t_role_auth` VALUES (1, 1, 2);
INSERT INTO `t_role_auth` VALUES (2, 2, 2);
INSERT INTO `t_role_auth` VALUES (3, 3, 1);
INSERT INTO `t_role_auth` VALUES (4, 4, 3);

SET foreign_key_checks=1;
