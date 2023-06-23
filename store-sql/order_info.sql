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

 Date: 23/06/2023 13:32:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` datetime NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  `total` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (9, '2023-06-21 20:05:04', 43, 268376.00);
INSERT INTO `order_info` VALUES (10, '2023-06-21 20:24:05', 43, 268376.00);
INSERT INTO `order_info` VALUES (11, '2023-06-21 20:25:21', 40, 268376.00);
INSERT INTO `order_info` VALUES (12, '2023-06-21 21:04:39', 40, 268376.00);
INSERT INTO `order_info` VALUES (13, '2023-06-21 21:05:27', 40, 268376.00);
INSERT INTO `order_info` VALUES (14, '2023-06-22 06:19:41', 40, 268376.00);
INSERT INTO `order_info` VALUES (15, '2023-06-22 06:19:50', 40, 268376.00);
INSERT INTO `order_info` VALUES (16, '2023-06-22 06:20:47', 40, 268376.00);
INSERT INTO `order_info` VALUES (17, '2023-06-22 06:22:22', 40, 268376.00);
INSERT INTO `order_info` VALUES (18, '2023-06-22 06:24:21', 40, 268376.00);
INSERT INTO `order_info` VALUES (19, '2023-06-22 06:24:34', 40, 268376.00);
INSERT INTO `order_info` VALUES (20, '2023-06-22 06:39:34', 40, 268376.00);
INSERT INTO `order_info` VALUES (21, '2023-06-22 06:39:44', 40, 268376.00);
INSERT INTO `order_info` VALUES (22, '2023-06-22 06:39:52', 40, 268376.00);
INSERT INTO `order_info` VALUES (23, '2023-06-22 06:46:17', 40, 268376.00);
INSERT INTO `order_info` VALUES (24, '2023-06-22 06:46:50', 40, 268376.00);
INSERT INTO `order_info` VALUES (25, '2023-06-22 06:52:09', 40, 268376.00);
INSERT INTO `order_info` VALUES (26, '2023-06-22 08:06:37', 40, 268376.00);

SET FOREIGN_KEY_CHECKS = 1;
