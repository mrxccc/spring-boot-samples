/*
 Navicat Premium Data Transfer

 Source Server         : 10.122.100.146
 Source Server Type    : MariaDB
 Source Server Version : 100317
 Source Host           : 10.122.100.146:3306
 Source Schema         : oauth2

 Target Server Type    : MariaDB
 Target Server Version : 100317
 File Encoding         : 65001

 Date: 30/11/2020 14:06:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父权限',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `enname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限英文名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授权路径',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `created` datetime(0) NOT NULL,
  `updated` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES (37, 0, '系统管理', 'System', '/', NULL, '2019-04-04 23:22:54', '2019-04-04 23:22:56');
INSERT INTO `tb_permission` VALUES (38, 37, '用户管理', 'SystemUser', '/users/', NULL, '2019-04-04 23:25:31', '2019-04-04 23:25:33');
INSERT INTO `tb_permission` VALUES (39, 38, '查看用户', 'SystemUserView', '/users/view/**', NULL, '2019-04-04 15:30:30', '2019-04-04 15:30:43');
INSERT INTO `tb_permission` VALUES (40, 38, '新增用户', 'SystemUserInsert', '/users/insert/**', NULL, '2019-04-04 15:30:31', '2019-04-04 15:30:44');
INSERT INTO `tb_permission` VALUES (41, 38, '编辑用户', 'SystemUserUpdate', '/users/update/**', NULL, '2019-04-04 15:30:32', '2019-04-04 15:30:45');
INSERT INTO `tb_permission` VALUES (42, 38, '删除用户', 'SystemUserDelete', '/users/delete/**', NULL, '2019-04-04 15:30:48', '2019-04-04 15:30:45');
INSERT INTO `tb_permission` VALUES (44, 37, '内容管理', 'SystemContent', '/contents/', NULL, '2019-04-06 18:23:58', '2019-04-06 18:24:00');
INSERT INTO `tb_permission` VALUES (45, 44, '查看内容', 'SystemContentView', '/contents/view/**', NULL, '2019-04-06 23:49:39', '2019-04-06 23:49:41');
INSERT INTO `tb_permission` VALUES (46, 44, '新增内容', 'SystemContentInsert', '/contents/insert/**', NULL, '2019-04-06 23:51:00', '2019-04-06 23:51:02');
INSERT INTO `tb_permission` VALUES (47, 44, '编辑内容', 'SystemContentUpdate', '/contents/update/**', NULL, '2019-04-06 23:51:04', '2019-04-06 23:51:06');
INSERT INTO `tb_permission` VALUES (48, 44, '删除内容', 'SystemContentDelete', '/contents/delete/**', NULL, '2019-04-06 23:51:08', '2019-04-06 23:51:10');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父角色',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `enname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色英文名称',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `created` datetime(0) NOT NULL,
  `updated` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (37, 0, '超级管理员', 'admin', NULL, '2019-04-04 23:22:03', '2019-04-04 23:22:05');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------
INSERT INTO `tb_role_permission` VALUES (37, 37, 37);
INSERT INTO `tb_role_permission` VALUES (38, 37, 38);
INSERT INTO `tb_role_permission` VALUES (39, 37, 39);
INSERT INTO `tb_role_permission` VALUES (40, 37, 40);
INSERT INTO `tb_role_permission` VALUES (41, 37, 41);
INSERT INTO `tb_role_permission` VALUES (42, 37, 42);
INSERT INTO `tb_role_permission` VALUES (43, 37, 44);
INSERT INTO `tb_role_permission` VALUES (44, 37, 45);
INSERT INTO `tb_role_permission` VALUES (45, 37, 46);
INSERT INTO `tb_role_permission` VALUES (46, 37, 47);
INSERT INTO `tb_role_permission` VALUES (47, 37, 48);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime(0) NOT NULL,
  `updated` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (37, 'admin', '$2a$10$9ZhDOBp.sRKat4l14ygu/.LscxrMUcDAfeVOEPiYwbcRkoB09gCmi', '15888888888', 'lee.lusifer@gmail.com', '2019-04-04 23:21:27', '2019-04-04 23:21:29');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户 ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES (37, 37, 37);

SET FOREIGN_KEY_CHECKS = 1;
