/*
Navicat MySQL Data Transfer

Source Server         : CDL
Source Server Version : 50738
Source Host           : localhost:3306
Source Database       : spring_boot_data

Target Server Type    : MYSQL
Target Server Version : 50738
File Encoding         : 65001

Date: 2023-03-21 18:35:58
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
-- Table structure for `t_clazz`
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz` (
  `clazz_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `clazz_name` varchar(50) DEFAULT NULL COMMENT '班级名称',
  `teacher_id` int(11) NOT NULL COMMENT '班级管理⽼师的id',
  PRIMARY KEY (`clazz_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES ('1', 'Vue班', '1');
INSERT INTO `t_clazz` VALUES ('2', '前端开发班', '2');
INSERT INTO `t_clazz` VALUES ('20', '新名字0', '10');
INSERT INTO `t_clazz` VALUES ('21', '新名字1', '10');
INSERT INTO `t_clazz` VALUES ('22', '新名字2', '10');
INSERT INTO `t_clazz` VALUES ('23', '新名字3', '10');
INSERT INTO `t_clazz` VALUES ('24', '新名字4', '10');
INSERT INTO `t_clazz` VALUES ('25', '新名字5', '10');
INSERT INTO `t_clazz` VALUES ('26', '新名字6', '10');
INSERT INTO `t_clazz` VALUES ('27', '新名字7', '10');
INSERT INTO `t_clazz` VALUES ('28', '新名字8', '10');
INSERT INTO `t_clazz` VALUES ('29', '新名字9', '10');

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

-- ----------------------------
-- Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `course_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20003 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('20001', '后端⼯程化开发');
INSERT INTO `t_course` VALUES ('20002', '前端⼯程化开发');

-- ----------------------------
-- Table structure for `t_course_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student`;
CREATE TABLE `t_course_student` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_course_student
-- ----------------------------
INSERT INTO `t_course_student` VALUES ('1', '20001', '1001');
INSERT INTO `t_course_student` VALUES ('2', '20002', '1001');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学⽣id',
  `clazz_id` int(11) NOT NULL COMMENT '学⽣所属班级的id',
  `student_name` varchar(50) DEFAULT NULL COMMENT '学⽣姓名',
  `hometown` varchar(100) DEFAULT NULL COMMENT '学⽣籍贯',
  `birthday` date DEFAULT NULL COMMENT '出⽣⽇期',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5002 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1001', '1', '钱智康', '江苏苏州', '2000-01-18');
INSERT INTO `t_student` VALUES ('1002', '1', '李智康', '江苏⽆锡', '2000-02-18');
INSERT INTO `t_student` VALUES ('1003', '1', '张智康', '江苏常州', '2000-03-18');
INSERT INTO `t_student` VALUES ('1004', '1', '王智康', '江苏南京', '2000-04-18');
INSERT INTO `t_student` VALUES ('1005', '1', '孙志康', '江苏徐州', '2001-05-18');
INSERT INTO `t_student` VALUES ('1006', '2', '周志康', '江苏泰州', '2001-06-18');
INSERT INTO `t_student` VALUES ('1007', '2', '郭志康', '江苏扬州', '2001-07-18');
INSERT INTO `t_student` VALUES ('1008', '2', '陈志康', '江苏盐城', '2001-08-18');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `teacher_name` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `clazz_id` int(11) NOT NULL COMMENT '教师管理的班级id',
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '许⽼师', '1');
INSERT INTO `t_teacher` VALUES ('2', '张⽼师', '2');
INSERT INTO `t_teacher` VALUES ('20', '新姓名0', '3');
INSERT INTO `t_teacher` VALUES ('21', '新姓名1', '3');
INSERT INTO `t_teacher` VALUES ('22', '新姓名2', '3');
INSERT INTO `t_teacher` VALUES ('23', '新姓名3', '3');
INSERT INTO `t_teacher` VALUES ('24', '新姓名4', '3');
INSERT INTO `t_teacher` VALUES ('25', '新姓名5', '3');
INSERT INTO `t_teacher` VALUES ('26', '新姓名6', '3');
INSERT INTO `t_teacher` VALUES ('27', '新姓名7', '3');
INSERT INTO `t_teacher` VALUES ('28', '新姓名8', '3');
INSERT INTO `t_teacher` VALUES ('29', '新姓名9', '3');
