/*
 Navicat Premium Data Transfer

 Source Server         : mysql-8.0.33
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3307
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 09/06/2023 13:58:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `classify_id` int NOT NULL AUTO_INCREMENT,
  `classify_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES (1, '手机');
INSERT INTO `classify` VALUES (2, '电脑');
INSERT INTO `classify` VALUES (3, '家电');
INSERT INTO `classify` VALUES (6, '配件');
INSERT INTO `classify` VALUES (7, '家具');

SET FOREIGN_KEY_CHECKS = 1;
