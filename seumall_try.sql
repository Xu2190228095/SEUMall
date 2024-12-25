/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : seumall

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 05/12/2024 16:32:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
                            `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `detailedaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `cid` int(0) NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, 'xbh', '15100000000', '中国', '江苏', '南京', '江宁区东南大学九龙湖校区', 1);

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint`  (
                              `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                              `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                              `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                              `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                              `oid` int(0) NULL DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES (1, '不符合预期', '待处理', NULL, 1);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
                             `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                             `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             `account` int(0) NULL DEFAULT NULL,
                             `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '上帝', '123456', 100, '213212520@seu.edu.cn');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
                          `id` int(0) NOT NULL AUTO_INCREMENT,
                          `create_time` datetime(0) NULL DEFAULT NULL,
                          `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `score` int(0) NULL DEFAULT NULL,
                          `cid` int(0) NOT NULL,
                          `uid` int(0) NOT NULL,
                          `number` int(0) NULL DEFAULT NULL,
                          `order_id` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                          `pid` int(0) NOT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '2024-12-12 19:21:51', '待发货', NULL, 1, 1, 2, '2024121201', 1);
INSERT INTO `order` VALUES (2, '2024-12-20 23:16:46', '已发货', NULL, 2, 1, 3, '2024121202', 1);
INSERT INTO `order` VALUES (3, '2024-12-20 23:20:16', '待发货', NULL, 1, 39, 4, '2024121203', 1);
INSERT INTO `order` VALUES (4, '2024-12-21 00:07:11', '已收货', NULL, 1, 1, 5, '2024121204', 1);
INSERT INTO `order` VALUES (5, '2024-12-21 00:09:16', '已完成', 5, 1, 1, 1, '2024121205', 1);



-- ----------------------------
-- Table structure for orderrecord
-- ----------------------------
DROP TABLE IF EXISTS `orderrecord`;
CREATE TABLE `orderrecord`  (
                                `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                                `oid` int(0) NULL DEFAULT NULL,
                                `updatetime` datetime(0) NULL DEFAULT NULL,
                                `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderrecord
-- ----------------------------

-- ----------------------------
-- Table structure for platform
-- ----------------------------
DROP TABLE IF EXISTS `platform`;
CREATE TABLE `platform`  (
                             `id` int(0) NOT NULL,
                             `account` int(0) NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of platform
-- ----------------------------
INSERT INTO `platform` VALUES (1, 0);



-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
                            `id` int(0) NOT NULL,
                            `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `price` int(0) NULL DEFAULT NULL,
                            `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `number` int(0) NULL DEFAULT NULL,
                            `pclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `cid` int(0) NULL DEFAULT NULL,
                            `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '娃哈哈矿泉水', 2, '...', 1000, '食品', 1, '我们不生产水，我们这是大自然的搬运工');
INSERT INTO `product` VALUES (2, '可口可乐', 3, '...', 1500, '饮料', 1, '清爽解渴，经典之选');
INSERT INTO `product` VALUES (3, '康师傅红烧牛肉面', 5, '...', 800, '食品', 2, '经典味道，速食必备');
INSERT INTO `product` VALUES (4, '蒙牛纯牛奶', 10, '...', 600, '食品', 3, '富含营养，健康之选');
INSERT INTO `product` VALUES (5, '苹果iPhone 13', 6999, '...', 200, '电子产品', 4, '最新款智能手机，高性能体验');
INSERT INTO `product` VALUES (6, '联想小新Pro14', 5999, '...', 100, '电子产品', 4, '轻薄便携，高效办公');
INSERT INTO `product` VALUES (7, '海尔滚筒洗衣机', 2999, '...', 50, '家电', 5, '智能控制，节能环保');
INSERT INTO `product` VALUES (8, '美的智能冰箱', 3999, '...', 80, '家电', 5, '大容量，智能保鲜');
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `uid` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                         `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `lastlogintime` datetime(0) NULL DEFAULT NULL,
                         `character` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `isActive` int(0) NULL DEFAULT NULL,
                         `account` int(0) NULL DEFAULT NULL,
                         `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `createtime` datetime(0) NULL DEFAULT NULL,
                         PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'seller1', '123456', NULL, '2024-12-21 01:04:13', 'ROLE_user', 1, 1000, NULL, '2024-12-20 23:19:18');
INSERT INTO `user` VALUES (2, 'admin1', '123456', NULL, '2024-12-20 00:13:26', 'ROLE_admin', 0, NULL, NULL, '2024-12-20 23:19:21');
INSERT INTO `user` VALUES (10, 'admin', '123456', 'token', '2024-12-21 01:04:37', 'ROLE_admin', 1, 100, 'email12', '2024-12-20 23:19:22');
INSERT INTO `user` VALUES (28, 'admin2', '123456', NULL, NULL, 'ROLE_admin', 0, 0, '', '2024-12-20 23:19:23');
INSERT INTO `user` VALUES (30, 'admin5', '123456', NULL, '2024-12-19 15:22:22', 'ROLE_admin', 0, 0, '', '2024-12-20 23:19:24');
INSERT INTO `user` VALUES (37, 'admin6', NULL, NULL, NULL, NULL, 1, NULL, '12345', '2024-12-20 02:11:32');
INSERT INTO `user` VALUES (38, 'admin7', '123456', NULL, NULL, NULL, 1, NULL, '123', '2024-12-20 02:11:53');
INSERT INTO `user` VALUES (39, 'seller2', '123456', NULL, '2024-12-20 23:21:44', 'ROLE_user', 1, 1000, NULL, '2024-12-20 23:19:15');

SET FOREIGN_KEY_CHECKS = 1;
