# leetcode
/*

 Navicat Premium Data Transfer


 Source Server         : learnforfun

 Source Server Type    : MySQL

 Source Server Version : 50719

 Source Host           : localhost:3306

 Source Schema         : test


 Target Server Type    : MySQL

 Target Server Version : 50719

 File Encoding         : 65001


 Date: 31/12/2019 10:56:18

*/


SET NAMES utf8mb4;

SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------

-- Table structure for t_superman

-- ----------------------------

DROP TABLE IF EXISTS `t_superman`;

CREATE TABLE `t_superman` (

  `id` int(11) NOT NULL AUTO_INCREMENT,

  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,

  `open` tinyint(2) DEFAULT NULL,

  `pid` int(11) NOT NULL,

  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- ----------------------------

-- Records of t_superman

-- ----------------------------

BEGIN;

INSERT INTO `t_superman` VALUES (1, '孙悟空', 0, 0);

INSERT INTO `t_superman` VALUES (2, '贝吉塔', 0, 0);

INSERT INTO `t_superman` VALUES (3, '孙悟饭', 0, 1);

INSERT INTO `t_superman` VALUES (4, '孙悟天', 0, 1);

INSERT INTO `t_superman` VALUES (5, '特兰克斯', 0, 2);

INSERT INTO `t_superman` VALUES (6, '小芳', 0, 3);

COMMIT;


SET FOREIGN_KEY_CHECKS = 1;