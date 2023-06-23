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

 Date: 23/06/2023 13:36:13
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
  `update_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (6, '小米13', '8Gen2', 14, 3899.00, '2023-06-03', '01ee7662-8b99-4c8a-99a1-c13e5bf8025f-Mi-CC9.png', 'null', 1, '2023-06-21');
INSERT INTO `goods` VALUES (8, '魅族20Pro', '狗都不用', 93, 3999.00, '2023-06-03', 'fbd3e898-b3f6-4b5c-9520-073e857fed72-OIP-C (5).jpg', 'null', 1, '2023-06-22');
INSERT INTO `goods` VALUES (11, '小米11', '888', 888, 3899.00, '2023-06-03', 'a370e8c0-8139-44f2-aed3-5dc1617b5ffc-Mi-CC9.png', 'null', 1, '2023-06-22');
INSERT INTO `goods` VALUES (12, 'iPhone 13 ', '无', 100, 5999.00, '2023-06-04', 'f2367e00-31ae-47c5-9fb8-62b3b6288aef-OIP-C (1).jpg', 'null', 1, '2023-06-22');
INSERT INTO `goods` VALUES (13, 'Mi-CC9', '无', 10, 1999.00, '2023-06-04', '176eee3e-ca7c-428b-9afc-2a290b578a5c-Mi-CC9.png', 'null', 1, '2023-06-21');
INSERT INTO `goods` VALUES (25, '红米', '231', 153, 10.00, '2023-06-12', '8d10c551-81d0-4808-811c-4bdf944812bd-Redmi-k30-5G.png', '', 1, '2023-06-21');
INSERT INTO `goods` VALUES (26, 'Redmi-Note8', '未知', 98, 778.00, '2023-06-12', '7777806b-9ed1-49d2-b680-ef4744b1e03a-Redmi-Note8.png', '', 1, '2023-06-21');
INSERT INTO `goods` VALUES (30, '空调', '1.5匹', 777, 1999.00, '2023-06-14', 'c81b13f6-6752-4e7b-87c4-dc2e0c5a1a2a-AirCondition-V1C1-1.jpg', '', 3, '2023-06-22');
INSERT INTO `goods` VALUES (31, '电视', '电视', 155, 1566.00, '2023-06-14', 'd416cb91-b30c-4c91-9377-4958c7bc16de-MiTv-4C 55-1.jpg', '', 3, '2023-06-22');
INSERT INTO `goods` VALUES (32, '小米电视', '四核', 98, 1888.00, '2023-06-16', '3aeac39c-7b2a-48b1-b19f-9868694065ea-MiTv-4C 55-1.jpg', '', 3, '2023-06-21');
INSERT INTO `goods` VALUES (33, '小米充电器', '55W大功率', 145, 40.00, '2023-06-17', 'd8d6bdaf-a9f4-40c0-89ec-2dc4900c7dcb-charger-36w-3.jpg', '', 6, '2023-06-22');
INSERT INTO `goods` VALUES (34, '充电宝', '20000毫安', 87, 88.00, '2023-06-17', 'a71b906d-842a-4465-bea2-afdee6a9d812-charger-10000mAh-1.jpg', NULL, 6, '2023-06-22');
INSERT INTO `goods` VALUES (35, '全实木沙发', '现代简约布艺沙发小户型客厅储物沙发橡木实木家具 梨白三人+脚凳2210*1420*785 橡木', 194, 3023.00, '2023-06-17', 'bfc67163-e901-4237-b92a-326c09195b12-a29759297910a5f6.jpg', NULL, 7, '2023-06-22');
INSERT INTO `goods` VALUES (36, '七彩虹3070', '2k高清畅玩3A大作', 998, 2099.00, '2023-06-17', 'b8f9c253-1b9c-4f9f-a41d-a1f778f13fb4-997c3a9974b838d8.jpg', NULL, 2, '2023-06-22');
INSERT INTO `goods` VALUES (37, '公版4080', '4k高清畅玩3A大作', 20, 8999.00, '2023-06-17', 'd1bd2768-cafe-44a5-9172-23c5771487df-e6c9a61427d3c45f.jpg', NULL, 2, '2023-06-22');
INSERT INTO `goods` VALUES (38, 'iPhone 14', 'A16', 800, 19999.00, '2023-06-17', '032a729d-a95d-45f9-95c7-9fb80eb83e99-OIP-C.jpg', '', 1, '2023-06-22');
INSERT INTO `goods` VALUES (39, '苹果笔记本', '办公', 98, 19999.00, '2023-06-17', '915c6d96-394d-4740-b172-5c3d086ea1b5-OIP-C (6).jpg', '', 2, '2023-06-21');
INSERT INTO `goods` VALUES (40, '三星笔记本', '办公游戏', 1365, 7889.00, '2023-06-16', 'acf1a8d6-d276-4a43-816f-01c882c50ab4-OIP-C.jpg', NULL, 2, '2023-06-21');
INSERT INTO `goods` VALUES (41, '滚筒洗衣机', '滚筒洗衣机', 0, 998.00, '2023-06-22', '4f21f2a7-3335-4670-a4ca-b823d94dbc23-561f0ae3cfd04643.jpg', '', 3, '2023-06-22');
INSERT INTO `goods` VALUES (42, '滚筒洗衣机2', '滚筒洗衣机2', 100, 999.00, '2023-06-22', 'afe02fdc-8f6e-4e8f-8f65-2372105f337c-561f0ae3cfd04643.jpg', NULL, 3, NULL);

-- ----------------------------
-- Triggers structure for table goods
-- ----------------------------
DROP TRIGGER IF EXISTS `goods_update`;
delimiter ;;
CREATE TRIGGER `goods_update` BEFORE UPDATE ON `goods` FOR EACH ROW BEGIN
	set new.update_time=now();
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table goods
-- ----------------------------
DROP TRIGGER IF EXISTS `goods_delete`;
delimiter ;;
CREATE TRIGGER `goods_delete` AFTER DELETE ON `goods` FOR EACH ROW BEGIN
    INSERT INTO goods_backup (gid, name, detail, stock, price, create_time, cover_image, more_image, classify_id, update_time)
    VALUES (OLD.gid, OLD.name, OLD.detail, OLD.stock, OLD.price, OLD.create_time, OLD.cover_image, OLD.more_image, OLD.classify_id, OLD.update_time);
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
