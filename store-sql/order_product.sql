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

 Date: 23/06/2023 13:32:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product`  (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  INDEX `prouduct_id`(`product_id` ASC) USING BTREE,
  INDEX `order_id`(`order_id` ASC) USING BTREE,
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `prouduct_id` FOREIGN KEY (`product_id`) REFERENCES `goods` (`gid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_product
-- ----------------------------
INSERT INTO `order_product` VALUES (9, 8, 1, 3999.00);
INSERT INTO `order_product` VALUES (10, 37, 1, 8999.00);
INSERT INTO `order_product` VALUES (11, 8, 1, 3999.00);
INSERT INTO `order_product` VALUES (11, 38, 1, 19999.00);
INSERT INTO `order_product` VALUES (11, 39, 1, 19999.00);
INSERT INTO `order_product` VALUES (12, 8, 1, 3999.00);
INSERT INTO `order_product` VALUES (12, 33, 1, 40.00);
INSERT INTO `order_product` VALUES (12, 42, 1, 999.00);
INSERT INTO `order_product` VALUES (12, 41, 1, 998.00);
INSERT INTO `order_product` VALUES (12, 12, 1, 5999.00);
INSERT INTO `order_product` VALUES (13, 13, 1, 1999.00);
INSERT INTO `order_product` VALUES (13, 38, 5, 19999.00);
INSERT INTO `order_product` VALUES (14, 6, 1, 3899.00);
INSERT INTO `order_product` VALUES (14, 34, 1, 88.00);
INSERT INTO `order_product` VALUES (15, 42, 1, 999.00);
INSERT INTO `order_product` VALUES (16, 37, 1, 8999.00);
INSERT INTO `order_product` VALUES (17, 33, 1, 40.00);
INSERT INTO `order_product` VALUES (18, 34, 5, 88.00);
INSERT INTO `order_product` VALUES (19, 36, 7, 2099.00);
INSERT INTO `order_product` VALUES (20, 39, 1, 19999.00);
INSERT INTO `order_product` VALUES (21, 35, 1, 3023.00);
INSERT INTO `order_product` VALUES (22, 35, 6, 3023.00);
INSERT INTO `order_product` VALUES (23, 34, 1, 88.00);
INSERT INTO `order_product` VALUES (24, 34, 10, 88.00);
INSERT INTO `order_product` VALUES (25, 8, 1, 3999.00);
INSERT INTO `order_product` VALUES (25, 35, 3, 3023.00);
INSERT INTO `order_product` VALUES (26, 37, 1, 8999.00);
INSERT INTO `order_product` VALUES (9, 8, 1, 3999.00);

SET FOREIGN_KEY_CHECKS = 1;
