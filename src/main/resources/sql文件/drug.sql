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

 Date: 21/04/2022 18:04:57
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
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill_info
-- ----------------------------
INSERT INTO `bill_info` VALUES (3, '山西广誉远中药有限公司', '甘草酸二铵肠溶胶囊(天晴甘平)', 22, 22.00, '2022-04-18 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (4, '马应龙药业', '云南白药气雾剂(云南白药)', 22, 33.00, '2023-04-13 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (5, '山西广誉远中药有限公司', '甘草酸二铵肠溶胶囊(天晴甘平)', 2, 2.00, '2022-04-07 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (8, '正大天晴药业集团股份有限公司', '盐酸安罗替尼胶囊(福可维)', 20, 41280.00, '2022-04-06 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (9, '上海强生制药有限公司', '布洛芬混悬液(美林)', 26, 1750.58, '2022-04-05 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (10, '正大天晴药业集团股份有限公司', '盐酸安罗替尼胶囊(福可维)', 100, 206400.00, '2022-04-13 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (11, '正大天晴药业集团股份有限公司', '甘草酸二铵肠溶胶囊(天晴甘平)', 1, 32.70, '2022-04-02 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (12, '正大天晴药业集团股份有限公司', '甘草酸二铵肠溶胶囊(天晴甘平)', 1, 32.70, '2022-04-16 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (22, '正大天晴药业集团股份有限公司', '盐酸安罗替尼胶囊(福可维)', 20, 41280.00, '2022-04-08 00:00:00', NULL);
INSERT INTO `bill_info` VALUES (23, '正大天晴药业集团股份有限公司', '盐酸安罗替尼胶囊(福可维)', 100, 206400.00, '2022-04-19 00:00:00', '药DIP0420174982');

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
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_in_info
-- ----------------------------
INSERT INTO `drug_in_info` VALUES (1, 'xiew', 'ww', 'ww', 'dawdawdwadaw', 2222.00, 2, '2022-04-05', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (2, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '1', 32.70, 1, '2022-04-18', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (3, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '药DIP22041814321766479', 65.40, 2, '2022-04-18', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (4, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '药DIP22041814355325', 32.70, 1, '2022-04-18', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (5, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP2204181483', 41280.00, 20, '2022-04-06', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (6, '布洛芬混悬液(美林)', '上海强生制药有限公司', '24', '药DIP0418141430', 1750.58, -1, '2022-04-05', '2', '2022-04-20', 134.66);
INSERT INTO `drug_in_info` VALUES (7, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0418153353', 206400.00, 100, '2022-04-13', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (8, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '药DIP0419010221', 32.70, 1, '2022-04-02', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (9, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '药DIP0419025607', 32.70, -1, '2022-04-16', '2', '2022-04-20', 65.40);
INSERT INTO `drug_in_info` VALUES (10, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '药DIP0419024179', 1079.10, 33, '2022-04-19', '1', '2022-04-22', 32.70);
INSERT INTO `drug_in_info` VALUES (11, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '药DIP0419147931', 654.00, -10, '2022-04-15', '10', '2022-04-20', 327.00);
INSERT INTO `drug_in_info` VALUES (12, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0419149926', 41280.00, 20, '2022-04-18', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (13, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0420016911', 2064.00, 1, '2022-04-19', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (14, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0420012964', 2064.00, 1, '2022-04-19', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (15, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0420028913', 2064.00, 1, '2022-04-19', '20', '2022-04-20', 41280.00);
INSERT INTO `drug_in_info` VALUES (16, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0420021949', 2064.00, 1, '2022-04-15', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (17, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0420023911', 2064.00, 1, '2022-04-15', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (18, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '24', '药DIP0420160916', 65.40, 2, '2022-04-16', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (19, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0420175982', 41280.00, 20, '2022-04-08', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (20, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0420174982', 206400.00, 100, '2022-04-19', '0', NULL, 0.00);

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_info
-- ----------------------------
INSERT INTO `drug_info` VALUES (1, '云南白药气雾剂(云南白药)', '云南白药集团股份有限公司', '2021-01-18', '12', '国药准字Z53021103', 48.33, 100);
INSERT INTO `drug_info` VALUES (2, '布洛芬混悬液(美林)', '上海强生制药有限公司', '2021-07-05', '24', '国药准字H19991011', 67.33, 80);
INSERT INTO `drug_info` VALUES (4, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '2022-02-12', '12', '国药准字H20180003', 2064.00, 100);
INSERT INTO `drug_info` VALUES (5, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '2022-04-01', '24', '国药准字H20040628', 32.70, 0);

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '问题药品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_problem_info
-- ----------------------------
INSERT INTO `drug_problem_info` VALUES (1, '云南白药气雾剂(云南白药)', 10, 48.33, '过期', '2022-04-16 17:39:19', NULL);
INSERT INTO `drug_problem_info` VALUES (2, '甘草酸二铵肠溶胶囊(天晴甘平)', 11, 22.00, '1', '2022-04-20 20:23:10', '药DIP0419025607');
INSERT INTO `drug_problem_info` VALUES (3, '盐酸安罗替尼胶囊(福可维)', 12, 2.00, '2', '2022-04-20 20:47:27', '药DIP0420028913');
INSERT INTO `drug_problem_info` VALUES (4, '盐酸安罗替尼胶囊(福可维)', 11, 2064.00, '1', '2022-04-20 20:49:26', '药DIP0420028913');
INSERT INTO `drug_problem_info` VALUES (5, '甘草酸二铵肠溶胶囊(天晴甘平)', 1, 32.70, '我', '2022-04-20 20:56:23', '药DIP0419024179');
INSERT INTO `drug_problem_info` VALUES (6, '甘草酸二铵肠溶胶囊(天晴甘平)', 1, 32.70, '我', '2022-04-20 20:56:32', '药DIP0419024179');
INSERT INTO `drug_problem_info` VALUES (7, '甘草酸二铵肠溶胶囊(天晴甘平)', 1, 32.70, '我', '2022-04-20 20:57:28', '药DIP0419147931');
INSERT INTO `drug_problem_info` VALUES (8, '布洛芬混悬液(美林)', 20, 67.33, '我', '2022-04-21 16:37:08', '药DIP0418141430');
INSERT INTO `drug_problem_info` VALUES (9, '甘草酸二铵肠溶胶囊(天晴甘平)', 1, 32.70, '我', '2022-04-21 16:54:06', '药DIP0419147931');
INSERT INTO `drug_problem_info` VALUES (10, '甘草酸二铵肠溶胶囊(天晴甘平)', 19, 32.70, '我', '2022-04-21 16:54:49', '药DIP0419147931');
INSERT INTO `drug_problem_info` VALUES (11, '布洛芬混悬液(美林)', 26, 67.33, '我', '2022-04-21 17:15:10', '药DIP0418141430');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of out_or_in_info
-- ----------------------------
INSERT INTO `out_or_in_info` VALUES (1, '布洛芬混悬液(美林)', '入库', 100, '谢炜程', '2022-04-16 14:19:38');
INSERT INTO `out_or_in_info` VALUES (3, '云南白药气雾剂(云南白药)', '入库', 200, '谢炜程', '2022-04-16 14:24:51');
INSERT INTO `out_or_in_info` VALUES (4, '布洛芬混悬液(美林)', '出库', 10, '谢炜程', '2022-04-16 14:27:30');
INSERT INTO `out_or_in_info` VALUES (5, '盐酸安罗替尼胶囊(福可维)', '入库', 100, '谢炜程', '2022-04-18 09:41:29');
INSERT INTO `out_or_in_info` VALUES (6, '盐酸安罗替尼胶囊(福可维)', '入库', 20, 'xiew', '2022-04-18 10:33:46');
INSERT INTO `out_or_in_info` VALUES (7, '盐酸安罗替尼胶囊(福可维)', '出库', 20, '谢炜程', '2022-04-18 10:55:13');
INSERT INTO `out_or_in_info` VALUES (8, '云南白药气雾剂(云南白药)', '出库', 99, '谢炜程', '2022-04-18 10:56:34');
INSERT INTO `out_or_in_info` VALUES (9, '云南白药气雾剂(云南白药)', '入库', 100, '谢炜程', '2022-04-18 11:05:55');

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
  `drugInNum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品进货批号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收到退货表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_goods_info
-- ----------------------------
INSERT INTO `return_goods_info` VALUES (1, '布洛芬混悬液(美林)', 1, '发霉', 100.00, '2022-04-06 00:00:00', NULL);
INSERT INTO `return_goods_info` VALUES (4, '布洛芬混悬液(美林)', 11, '111', 111.00, '2022-04-18 00:29:01', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退回给供应商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_supplier_info
-- ----------------------------
INSERT INTO `return_supplier_info` VALUES (3, '盐酸安罗替尼胶囊(福可维)', 1, '我', '11', '2022-04-19 00:00:00', '药DIP22041814321766479');
INSERT INTO `return_supplier_info` VALUES (11, '甘草酸二铵肠溶胶囊(天晴甘平)', 1, '正大天晴药业集团股份有限公司', '22', '2022-04-19 00:00:00', '药DIP0419147931');
INSERT INTO `return_supplier_info` VALUES (12, '盐酸安罗替尼胶囊(福可维)', 1, '正大天晴药业集团股份有限公司', '2', '2022-04-19 00:00:00', '药DIP0420028913');
INSERT INTO `return_supplier_info` VALUES (13, '甘草酸二铵肠溶胶囊(天晴甘平)', 1, '正大天晴药业集团股份有限公司', '2', '2022-04-22 00:00:00', '药DIP0419024179');
INSERT INTO `return_supplier_info` VALUES (14, '甘草酸二铵肠溶胶囊(天晴甘平)', 20, '正大天晴药业集团股份有限公司', '我', '2022-04-20 00:00:00', '药DIP0419147931');
INSERT INTO `return_supplier_info` VALUES (15, '盐酸安罗替尼胶囊(福可维)', 20, '正大天晴药业集团股份有限公司', '我', '2022-04-20 00:00:00', '药DIP0420028913');
INSERT INTO `return_supplier_info` VALUES (16, '布洛芬混悬液(美林)', 1, '上海强生制药有限公司', '0', '2022-04-20 00:00:00', '药DIP0418141430');
INSERT INTO `return_supplier_info` VALUES (17, '甘草酸二铵肠溶胶囊(天晴甘平)', 2, '正大天晴药业集团股份有限公司', '我', '2022-04-20 00:00:00', '药DIP0419025607');
INSERT INTO `return_supplier_info` VALUES (18, '布洛芬混悬液(美林)', 1, '上海强生制药有限公司', '我', '2022-04-20 00:00:00', '药DIP0418141430');
INSERT INTO `return_supplier_info` VALUES (19, '甘草酸二铵肠溶胶囊(天晴甘平)', 10, '正大天晴药业集团股份有限公司', '我', '2022-04-20 00:00:00', '药DIP0419147931');
INSERT INTO `return_supplier_info` VALUES (20, '布洛芬混悬液(美林)', 10, '上海强生制药有限公司', '我', '2022-04-20 00:00:00', '药DIP0418141430');
INSERT INTO `return_supplier_info` VALUES (21, '甘草酸二铵肠溶胶囊(天晴甘平)', 44, '正大天晴药业集团股份有限公司', '我', '2022-04-20 00:00:00', '药DIP0419024179');

-- ----------------------------
-- Table structure for sale_info
-- ----------------------------
DROP TABLE IF EXISTS `sale_info`;
CREATE TABLE `sale_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `dnumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `count` int(0) NULL DEFAULT NULL COMMENT '销售数量',
  `total` float(20, 2) NULL DEFAULT NULL COMMENT '总金额',
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_info
-- ----------------------------
INSERT INTO `sale_info` VALUES (1, '布洛芬混悬液(美林)', '1001', 100, 100.00, '谢炜程', '2022-04-15 00:00:00');
INSERT INTO `sale_info` VALUES (3, '云南白药气雾剂(云南白药)', '11112', 23, 100.00, '谢炜程', '2022-04-08 00:00:00');

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '哈药六厂', '哈尔滨制药第六大厂', '2019-08-13 12:44:14');
INSERT INTO `supplier` VALUES (2, '安耳悠', '耳塞制做大厂', '2022-02-09 17:39:14');
INSERT INTO `supplier` VALUES (4, '云南白药集团股份有限公司', '云南白药是云南著名的中成药，由名贵药材制成，具有化瘀止血、活血止痛、解毒消肿之功效。它由云南民间医生曲焕章于清光绪二十八年（1902年）研制成功，原名“曲焕章百宝丹”。问世百多年来，云南白药以其独特、神奇的功效被誉为“中华瑰宝，伤科圣药”，也由此成名于世、蜚声海外。', '2022-02-25 15:37:42');
INSERT INTO `supplier` VALUES (8, '上海医药（集团）有限公司', '生产经营化学药品原料药，制剂药；畜用化学药品原料药，制剂药；农用杀菌剂，植物生长激素，微生物农药原料药；化工商品、生物制品、包装材料、机械设备及其零部件的销售；货物进出口、技术进出口。', '2022-02-25 16:24:55');
INSERT INTO `supplier` VALUES (10, '马应龙药业', '马应龙是一家经国内贸易部认定的中华老字号企业，创始于公元1582年。经过持续快速健康发展，马应龙已经成为一家涉足于药品制造、药品研发、药品批发零售、连锁医院等多个领域的专业化多功能国际化的医药类上市公司。', '2022-03-01 13:49:49');
INSERT INTO `supplier` VALUES (11, '九芝堂股份有限公司', '九芝堂股份有限公司是国家重点中药企业，国内A股上市公司，湖南省重点高 新技术企业，湖南省百强企业，湖南省质量管理奖企业，长沙市工业十大标志性工程龙头企业，国家博士后科研工作站企业。', '2022-03-01 13:51:06');
INSERT INTO `supplier` VALUES (12, '山西广誉远中药有限公司', '山西广誉远中药有限公司是我国现存历史最悠久的中药企业,其前身广盛号药店始创于明嘉靖二十年，公元1541年。在清代广誉远与广州陈李济（1600年建立），北京同仁堂（1669年建立），杭州胡庆余堂（1874年建立）并称为“清代四大药店”，现为山西省中药企业典范，并在2006年成为首批被中华人民共和国商务部认定的“中华老字号”企业。', '2022-03-01 13:52:20');
INSERT INTO `supplier` VALUES (13, '正大天晴药业集团股份有限公司', '正大天晴药业集团股份有限公司是集科研、生产和销售为一体的医药企业，总部位于江苏省连云港市海州区。', '2022-03-01 13:58:53');
INSERT INTO `supplier` VALUES (14, '石药控股集团有限公司', '石药控股集团有限公司是一家集创新药物研发、生产和销售为一体的国家级创新型企业 。石药集团，秉持“做好药，为中国，善报天下人”的理念，专注制药，坚持创新，实现了传统药企的转型发展。有国内外一体化的研发体系，10余个药品生产基地，  产品销售遍及全球100多个国家和地区。', '2022-03-01 14:37:14');
INSERT INTO `supplier` VALUES (15, '丽珠医药集团股份有限公司', '丽珠医药集团股份有限公司是集医药研发、生产、销售为一体的综合性企业集团，创建于1985年1月，水连香港，地接澳门，距广州深圳皆2小时车程，区位优势明显；公司注册资本为3.06亿元，系民营控股的上市公司。丽珠集团于1993年完成股份制改造，成为全国医药行业首家A、B股上市的公司。集团所属全资子公司12个，控股企业10个，现有员工5000人，大中专以上文化程度的员工占集团总人数的83%，企业技术力量雄厚，装备优良，工艺先进，生产水平和质量水平处于行业领先地位。集团有53条生产线通过了GMP认证验收，营销企业也顺利通过了国家GSP认证，营销力量显著增强，丽珠医药集团已建立了覆盖国内市场的营销网络，与商业主渠道和数千家医院建立了稳定、良好的业务关系；随着质量体系的持续完善和提高，随着销售的快速增长，随着产能的不断扩大，随着新厂建设步伐的加快，丽珠集团将成为国内领先、国际一流的现代化制药龙头企业。', '2022-03-01 14:40:04');
INSERT INTO `supplier` VALUES (16, '江苏康缘药业股份有限公司', '江苏康缘药业股份有限公司是一家集中药研发、生产、贸易为一体的大型中药企业，是国家中药现代化示范企业、国家重点高新技术企业、国内A股上市公司，获国家“质量管理先进企业”，“重合同、守信用企业”等荣誉称号。多年来，康缘药业坚持“体制创新”和“科技创新”，以“创新中药、健康人类”为宗旨，运用现代制药技术的新工艺、新剂型、新辅料不断提升传统中药的技术内涵，先后开发国家级新药47个，其中一类新药1个，二类新药13个，创新中药注射剂2个。', '2022-03-01 14:40:44');

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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456');
INSERT INTO `user` VALUES (2, 'xiewc', 'xwc12345');

SET FOREIGN_KEY_CHECKS = 1;
