/*
 Navicat Premium Data Transfer

 Source Server         : 10.122.100.111
 Source Server Type    : MariaDB
 Source Server Version : 100322
 Source Host           : 10.122.100.111:3306
 Source Schema         : test

 Target Server Type    : MariaDB
 Target Server Version : 100322
 File Encoding         : 65001

 Date: 11/01/2021 14:42:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ssex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('001', '康康', 'M');
INSERT INTO `student` VALUES ('002', '麦克', 'M');

SET FOREIGN_KEY_CHECKS = 1;
