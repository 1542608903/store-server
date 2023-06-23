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

 Date: 23/06/2023 13:36:30
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
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '住址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (40, '黄魔哥', '男', 15, '2023-06-09', '114514', '4444', 'f6a4f650-6a05-4439-a86f-57722f9cc6e6-OET (2).jpg', '0', '海南陵水');
INSERT INTO `users` VALUES (42, '猴三秒', '男', 7, '2023-06-12', '6666', '7777', '7b749b4c-6a4c-4eb7-a81a-17ca18ad4caf-Mi-CC9.png', '0', NULL);
INSERT INTO `users` VALUES (43, '迷你小洞', '男', NULL, '2023-06-18', '1212', '1212', NULL, '0', NULL);

-- ----------------------------
-- Triggers structure for table users
-- ----------------------------
DROP TRIGGER IF EXISTS `sex_check`;
delimiter ;;
CREATE TRIGGER `sex_check` BEFORE INSERT ON `users` FOR EACH ROW BEGIN
    IF NEW.sex NOT IN ('男', '女') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '性别字段只能是"男"或"女"';
    END IF;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table users
-- ----------------------------
DROP TRIGGER IF EXISTS `sex_check_update`;
delimiter ;;
CREATE TRIGGER `sex_check_update` BEFORE UPDATE ON `users` FOR EACH ROW BEGIN
    IF NEW.sex NOT IN ('男', '女') THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '性别字段只能是"男"或"女"';
    END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
