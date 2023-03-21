/*
Navicat MySQL Data Transfer

Source Server         : CDL
Source Server Version : 50738
Source Host           : localhost:3306
Source Database       : spring_boot_data

Target Server Type    : MYSQL
Target Server Version : 50738
File Encoding         : 65001

Date: 2023-03-21 13:25:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(200) DEFAULT NULL COMMENT '文章标题',
  `content` longtext COMMENT '文章内容',
  `cover` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', 'Spring Boot基础入门', '从入门到精通讲解...', '/images/boot_cover.png');
INSERT INTO `t_article` VALUES ('2', 'Spring Cloud基础入门', '从入门到精通讲解...', '/images/cloud_cover.png');

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` longtext COMMENT '评论内容',
  `author` varchar(200) DEFAULT NULL COMMENT '评论作者',
  `a_id` int(11) DEFAULT NULL COMMENT '关联的文章id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '很全、很详细', '一只蜗牛', '1');
INSERT INTO `t_comment` VALUES ('2', '赞一个', 'tom', '1');
INSERT INTO `t_comment` VALUES ('3', '很详细', 'kitty', '1');
INSERT INTO `t_comment` VALUES ('4', '很好，非常详细', '张三', '1');
INSERT INTO `t_comment` VALUES ('5', '很不错', '张杨', '2');
