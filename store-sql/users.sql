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

 Date: 09/06/2023 13:59:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_admin` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (4, '王文', '男', 15, '2022-02-03', '232323266', 'dsd121', 'https://tse2-mm.cn.bing.net/th/id/OIP-C.h6aD0I6YSIAB897ptJPGewAAAA?w=218&h=219&c=7&r=0&o=5&dpr=2&pid=1.7', 'false');
INSERT INTO `users` VALUES (6, '樱岛麻衣', '女', 17, '2020-02-03', '12345', '12345', 'https://pic3.zhimg.com/v2-713f0b87eab84bbc1e5f58e32bc6eea0_r.jpg?source=1940ef5c', 'false');
INSERT INTO `users` VALUES (38, '噩噩', '男', 13, '2023-06-09', '111222', '114514', 'https://pic1.zhimg.com/v2-f0bacef82386187fe45851e3a7e36c82_1440w.jpg?source=172ae18b', '0');
INSERT INTO `users` VALUES (40, '黄魔哥', '男', 232, '2023-06-09', '114514', '4444', NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
