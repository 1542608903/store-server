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

 Date: 09/06/2023 13:58:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `gid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `stock` int NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `create_time` date NOT NULL,
  `cover_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `more_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `classify_id` int NOT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (6, '小米13', '8Gen2', 16, 3899.00, '2023-06-03', 'null', 'null', 1);
INSERT INTO `goods` VALUES (7, '小米空调', '冷死你', 160, 1999.00, '2023-06-01', 'null', 'null', 3);
INSERT INTO `goods` VALUES (8, '魅族20Pro', '狗都不用', 100, 3999.00, '2023-06-03', 'null', 'null', 1);
INSERT INTO `goods` VALUES (9, 'Apple Ari Pos 2', 'M1', 18, 1999.00, '2023-06-03', 'null', 'null', 4);
INSERT INTO `goods` VALUES (11, '小米11', '888', 1, 3899.00, '2023-06-03', 'null', 'null', 1);
INSERT INTO `goods` VALUES (12, 'iPhone 13 ', '无', 700, 5999.00, '2023-06-04', 'null', 'null', 1);
INSERT INTO `goods` VALUES (13, 'Mi-CC9', '无', 12, 1999.00, '2023-06-04', 'file:///C:/Users/25547/Desktop/imgs/phone/Mi-CC9.png', 'null', 1);
INSERT INTO `goods` VALUES (15, 'AppleMacBook Air', '电脑', 1, 7999.00, '2023-06-04', 'https://img12.360buyimg.com/n7/jfs/t1/64160/2/22015/33666/647a19abF9c1dfa19/72fb1df4ff64db17.jpg', 'null', 2);

SET FOREIGN_KEY_CHECKS = 1;
