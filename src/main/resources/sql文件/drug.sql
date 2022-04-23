/*
 Navicat Premium Data Transfer

 Source Server         : Mysql本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : drug

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/04/2022 11:01:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill_info
-- ----------------------------
DROP TABLE IF EXISTS `bill_info`;
CREATE TABLE `bill_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `count` int(0) NULL DEFAULT NULL COMMENT '药品数量',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '总金额',
  `buy_time` datetime(0) NULL DEFAULT NULL COMMENT '进货时间',
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品进货编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for drug_in_info
-- ----------------------------
DROP TABLE IF EXISTS `drug_in_info`;
CREATE TABLE `drug_in_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品供应商',
  `warranty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品保质期（月）',
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品进货批号',
  `drugInPrice` float(10, 2) NULL DEFAULT NULL COMMENT '药品进货金额',
  `drugCount` int(0) NULL DEFAULT NULL COMMENT '药品进货数量',
  `inTime` date NULL DEFAULT NULL COMMENT '药品进货时间',
  `drugRetuen` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品退货数量',
  `outTime` date NULL DEFAULT NULL COMMENT '药品退货时间',
  `drugOutPrice` float(10, 2) NULL DEFAULT NULL COMMENT '药品退货金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for drug_info
-- ----------------------------
DROP TABLE IF EXISTS `drug_info`;
CREATE TABLE `drug_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `product_time` date NULL DEFAULT NULL COMMENT '生产时间',
  `warrenty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保质期（月）',
  `dnumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `price` float(20, 2) NULL DEFAULT NULL COMMENT '药品价格',
  `stock` int(0) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for drug_is_gone
-- ----------------------------
DROP TABLE IF EXISTS `drug_is_gone`;
CREATE TABLE `drug_is_gone`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进货批号',
  `sellNnum` int(0) NULL DEFAULT NULL COMMENT '销售数量',
  `returnNum` int(0) NULL DEFAULT NULL COMMENT '退货数量',
  `sellRate` float(10, 2) NULL DEFAULT NULL COMMENT '销售率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for drug_problem_info
-- ----------------------------
DROP TABLE IF EXISTS `drug_problem_info`;
CREATE TABLE `drug_problem_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dcount` int(0) NULL DEFAULT NULL COMMENT '问题药品数量',
  `dprice` float(20, 2) NULL DEFAULT NULL COMMENT '药品单价',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出问题的原因',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作的时间',
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品批号',
  `isreturn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否退货',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '问题药品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for insell_drug_info
-- ----------------------------
DROP TABLE IF EXISTS `insell_drug_info`;
CREATE TABLE `insell_drug_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `InNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库编号',
  `sellcount` int(0) NULL DEFAULT NULL COMMENT '药品在售数量',
  `warranty` int(0) NULL DEFAULT NULL COMMENT '药品保质期',
  `pTime` datetime(0) NULL DEFAULT NULL COMMENT '生产日期',
  `sellNum` int(0) NULL DEFAULT NULL COMMENT '已销售数量',
  `returnNum` int(0) NULL DEFAULT NULL COMMENT '退货数量',
  `outprice` float(10, 2) NULL DEFAULT NULL COMMENT '销售金额',
  `inprice` float(255, 2) NULL DEFAULT NULL COMMENT '退货金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for out_or_in_info
-- ----------------------------
DROP TABLE IF EXISTS `out_or_in_info`;
CREATE TABLE `out_or_in_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库？入库？类型',
  `count` int(0) NULL DEFAULT NULL COMMENT '出入库数量',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for return_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `return_goods_info`;
CREATE TABLE `return_goods_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `count` int(0) NULL DEFAULT NULL COMMENT '数量',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '总金额',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '退货时间',
  `innum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品进货批号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收到退货表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for return_supplier_info
-- ----------------------------
DROP TABLE IF EXISTS `return_supplier_info`;
CREATE TABLE `return_supplier_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dcount` int(0) NULL DEFAULT NULL COMMENT '数量',
  `supplier_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `reason` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '退货时间',
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品批号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退回给供应商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sale_info
-- ----------------------------
DROP TABLE IF EXISTS `sale_info`;
CREATE TABLE `sale_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `innum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `count` int(0) NULL DEFAULT NULL COMMENT '销售数量',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '总金额',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sell_is_gone
-- ----------------------------
DROP TABLE IF EXISTS `sell_is_gone`;
CREATE TABLE `sell_is_gone`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进货批号',
  `sellNnum` int(0) NULL DEFAULT NULL COMMENT '销售数量',
  `returnNum` int(0) NULL DEFAULT NULL COMMENT '退货数量',
  `sellRate` float(10, 2) NULL DEFAULT NULL COMMENT '销售率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
