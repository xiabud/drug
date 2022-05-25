/*
 Navicat Premium Data Transfer

 Source Server         : mybatis
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : drug

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 23/05/2022 11:56:41
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
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '销售记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill_info
-- ----------------------------
INSERT INTO `bill_info` VALUES (43, '云南白药集团股份有限公司', '天紫红女金胶囊', 1000, 30000.00, '2022-04-01 00:00:00', '药DIP0423107398');
INSERT INTO `bill_info` VALUES (44, '上海医药（集团）有限公司', '苦甘颗粒', 100, 3021.00, '2022-04-02 00:00:00', '药DIP0423147525');
INSERT INTO `bill_info` VALUES (45, '云南白药集团股份有限公司', '板蓝根颗粒', 1000, 12000.00, '2022-04-23 00:00:00', '药DIP0424019877');
INSERT INTO `bill_info` VALUES (46, '湖南九典制药', '四物膏', 1000, 400000.00, '2022-04-08 00:00:00', '药DIP0425006837');
INSERT INTO `bill_info` VALUES (47, '正大天晴药业集团股份有限公司', '盐酸安罗替尼胶囊(福可维)', 1000, 20000.00, '2022-04-15 00:00:00', '药DIP0425002813');
INSERT INTO `bill_info` VALUES (48, '正大天晴药业集团股份有限公司', '盐酸安罗替尼胶囊(福可维)', 55, 1100.00, '2022-04-01 00:00:00', '药DIP0428158843');
INSERT INTO `bill_info` VALUES (49, '上海医药（集团）有限公司', '苦甘颗粒', 1000, 20000.00, '2022-05-03 00:00:00', '药DIP0504001814');
INSERT INTO `bill_info` VALUES (50, '山西广誉远中药有限公司', '牛黄清心丸', 1000, 20000.00, '2022-05-03 00:00:00', '药DIP0504001837');
INSERT INTO `bill_info` VALUES (51, '石药控股集团有限公司', '阿莫西林颗粒', 1000, 100000.00, '2022-05-04 00:00:00', '药DIP0504001821');
INSERT INTO `bill_info` VALUES (52, '山西广誉远中药有限公司', '牛黄清心丸', 500, 20000.00, '2022-05-06 00:00:00', '药DIP0506155818');

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
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_in_info
-- ----------------------------
INSERT INTO `drug_in_info` VALUES (42, '板蓝根颗粒', '云南白药集团股份有限公司', '24', '药DIP0424019877', 12000.00, 400, '2022-04-23', '100', '2022-04-07', 2570.00);
INSERT INTO `drug_in_info` VALUES (43, '四物膏', '湖南九典制药', '36', '药DIP0425006837', 400000.00, 450, '2022-04-08', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (44, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0425002813', 20000.00, 1000, '2022-04-15', '0', NULL, 0.00);
INSERT INTO `drug_in_info` VALUES (45, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '12', '药DIP0428158843', 1100.00, 55, '2022-04-01', '0', NULL, 0.00);

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
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_info
-- ----------------------------
INSERT INTO `drug_info` VALUES (1, '云南白药气雾剂(云南白药)', '云南白药集团股份有限公司', '2021-01-18', '12', '国药准字Z53021103', 48.33, 0);
INSERT INTO `drug_info` VALUES (4, '盐酸安罗替尼胶囊(福可维)', '正大天晴药业集团股份有限公司', '2022-02-12', '12', '国药准字H20180003', 2064.00, 1055);
INSERT INTO `drug_info` VALUES (5, '甘草酸二铵肠溶胶囊(天晴甘平)', '正大天晴药业集团股份有限公司', '2022-04-01', '24', '国药准字H20040628', 32.70, 0);
INSERT INTO `drug_info` VALUES (6, '小儿氨酚黄那敏片', '哈药集团制药六厂', '2022-03-11', '24', '国药准字H23022614', 5.70, 0);
INSERT INTO `drug_info` VALUES (7, '保和丸', '哈药集团制药六厂', NULL, '24', '国药准字Z23020277', 14.10, 0);
INSERT INTO `drug_info` VALUES (8, '菊梅利咽含片', '哈药集团制药六厂', NULL, '24', '国药准字B20020112', 11.10, 0);
INSERT INTO `drug_info` VALUES (9, '阿莫西林片', '哈药集团制药六厂', NULL, '12', '国药准字H23020941', 4.00, 0);
INSERT INTO `drug_info` VALUES (10, '参苓口服液', '湖南九典制药', NULL, '24', '国药准字B20020594', 14.30, 0);
INSERT INTO `drug_info` VALUES (11, '泮托拉唑钠肠溶片', '湖南九典制药', NULL, '24', '国药准字H20093501', 7.80, 0);
INSERT INTO `drug_info` VALUES (12, '左羟丙哌嗪含片', '湖南九典制药', NULL, '12', '国药准字H20052471', 40.00, 0);
INSERT INTO `drug_info` VALUES (13, '四物膏', '湖南九典制药', NULL, '36', '国药准字Z20026272', 83.30, 989);
INSERT INTO `drug_info` VALUES (14, '更年安胶囊', '湖南九典制药', NULL, '24', '国药准字Z20055028', 51.40, 0);
INSERT INTO `drug_info` VALUES (15, '天紫红女金胶囊', '云南白药集团股份有限公司', NULL, '24', '国药准字Z53021629', 80.60, 0);
INSERT INTO `drug_info` VALUES (16, '复方丹参片', '云南白药集团股份有限公司', NULL, '24', '国药准字Z53021243', 22.80, 0);
INSERT INTO `drug_info` VALUES (17, '板蓝根颗粒', '云南白药集团股份有限公司', NULL, '24', '国药准字Z53021572', 25.70, 900);
INSERT INTO `drug_info` VALUES (18, '利胆排石片', '上海医药（集团）有限公司', NULL, '36', '国药准字Z20083443', 17.60, 0);
INSERT INTO `drug_info` VALUES (19, '苦甘颗粒', '上海医药（集团）有限公司', NULL, '24', '国药准字Z37020781', 31.40, 960);
INSERT INTO `drug_info` VALUES (22, '牛黄清心丸', '山西广誉远中药有限公司', NULL, '24', '国药准字Z14021721 ', 128.00, 1330);
INSERT INTO `drug_info` VALUES (23, '阿莫西林颗粒', '石药控股集团有限公司', NULL, '24', '国药准字H13023430', 120.00, 900);

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_is_gone
-- ----------------------------
INSERT INTO `drug_is_gone` VALUES (10, '天紫红女金胶囊', '云南白药集团股份有限公司', '药DIP0423107398', 500, 500, 0.50);
INSERT INTO `drug_is_gone` VALUES (11, '苦甘颗粒', '上海医药（集团）有限公司', '药DIP0423147525', 80, 20, 0.80);
INSERT INTO `drug_is_gone` VALUES (12, '苦甘颗粒', '上海医药（集团）有限公司', '药DIP0504001814', 980, 20, 0.98);
INSERT INTO `drug_is_gone` VALUES (13, '牛黄清心丸', '山西广誉远中药有限公司', '药DIP0504001837', 980, 20, 0.98);
INSERT INTO `drug_is_gone` VALUES (14, '阿莫西林颗粒', '石药控股集团有限公司', '药DIP0504001821', 980, 20, 0.98);
INSERT INTO `drug_is_gone` VALUES (15, '牛黄清心丸', '山西广誉远中药有限公司', '药DIP0506155818', 400, 100, 0.80);

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '问题药品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of drug_problem_info
-- ----------------------------
INSERT INTO `drug_problem_info` VALUES (21, '天紫红女金胶囊', 200, 80.60, '药品临近过期。', '2022-04-23 10:39:57', '药DIP0423107398', '已退货');
INSERT INTO `drug_problem_info` VALUES (22, '苦甘颗粒', 20, 31.40, '药品外包装损坏。', '2022-04-24 02:22:10', '药DIP0423147525', '已退货');
INSERT INTO `drug_problem_info` VALUES (23, '苦甘颗粒', 20, 31.40, '发霉。', '2022-05-04 00:08:51', '药DIP0504001814', '已退货');
INSERT INTO `drug_problem_info` VALUES (24, '牛黄清心丸', 20, 128.00, '发霉。', '2022-05-04 00:31:43', '药DIP0504001837', '已退货');
INSERT INTO `drug_problem_info` VALUES (25, '阿莫西林颗粒', 20, 120.00, '发霉。', '2022-05-04 00:43:53', '药DIP0504001821', '已退货');
INSERT INTO `drug_problem_info` VALUES (26, '牛黄清心丸', 100, 128.00, '外包装损坏。', '2022-05-06 15:40:27', '药DIP0506155818', '已退货');

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of insell_drug_info
-- ----------------------------
INSERT INTO `insell_drug_info` VALUES (6, '板蓝根颗粒', '药DIP0424019877', 500, 24, '2022-04-24 13:12:12', 0, 0, 0.00, 0.00);
INSERT INTO `insell_drug_info` VALUES (7, '四物膏', '药DIP0425006837', 539, 36, '2022-04-25 00:56:21', 11, 0, 916.30, 0.00);
INSERT INTO `insell_drug_info` VALUES (8, '苦甘颗粒', '药DIP0504001814', 960, 24, '2022-05-04 00:09:33', 20, 0, 628.00, 0.00);
INSERT INTO `insell_drug_info` VALUES (9, '牛黄清心丸', '药DIP0504001837', 930, 24, '2022-05-04 00:32:12', 50, 0, 6400.00, 0.00);
INSERT INTO `insell_drug_info` VALUES (10, '阿莫西林颗粒', '药DIP0504001821', 900, 24, '2022-05-04 00:44:33', 80, 0, 9600.00, 0.00);
INSERT INTO `insell_drug_info` VALUES (11, '牛黄清心丸', '药DIP0506155818', 400, 24, '2022-05-06 16:00:08', 0, 0, 0.00, 0.00);

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
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of out_or_in_info
-- ----------------------------
INSERT INTO `out_or_in_info` VALUES (29, '天紫红女金胶囊', '从供应商进货：入库', 1000, '谢炜程', '2022-04-01 00:00:00', '药DIP0423107398');
INSERT INTO `out_or_in_info` VALUES (30, '天紫红女金胶囊', '发出药品销售：出库', 400, '谢炜程', '2022-04-23 10:41:05', '药DIP0423107398');
INSERT INTO `out_or_in_info` VALUES (31, '天紫红女金胶囊', '发出药品销售：出库', 100, '谢炜程', '2022-04-23 10:47:00', '药DIP0423107398');
INSERT INTO `out_or_in_info` VALUES (32, '苦甘颗粒', '从供应商进货：入库', 100, '谢炜程', '2022-04-02 00:00:00', '药DIP0423147525');
INSERT INTO `out_or_in_info` VALUES (33, '板蓝根颗粒', '从供应商进货：入库', 1000, '谢炜程', '2022-04-23 00:00:00', '药DIP0424019877');
INSERT INTO `out_or_in_info` VALUES (34, '苦甘颗粒', '发出药品销售：出库', 80, '谢炜程', '2022-04-24 02:38:39', '药DIP0423147525');
INSERT INTO `out_or_in_info` VALUES (35, '板蓝根颗粒', '发出药品销售：出库', 500, '谢炜程', '2022-04-24 13:12:12', '药DIP0424019877');
INSERT INTO `out_or_in_info` VALUES (36, '四物膏', '从供应商进货：入库', 1000, '谢炜程', '2022-04-08 00:00:00', '药DIP0425006837');
INSERT INTO `out_or_in_info` VALUES (37, '四物膏', '发出药品销售：出库', 500, '谢炜程', '2022-04-25 00:56:21', '药DIP0425006837');
INSERT INTO `out_or_in_info` VALUES (38, '盐酸安罗替尼胶囊(福可维)', '从供应商进货：入库', 1000, '谢炜程', '2022-04-15 00:00:00', '药DIP0425002813');
INSERT INTO `out_or_in_info` VALUES (39, '盐酸安罗替尼胶囊(福可维)', '从供应商进货：入库', 55, '谢炜程', '2022-04-01 00:00:00', '药DIP0428158843');
INSERT INTO `out_or_in_info` VALUES (40, '四物膏', '发出药品销售：出库', 50, '谢炜程', '2022-05-02 02:10:55', '药DIP0425006837');
INSERT INTO `out_or_in_info` VALUES (41, '苦甘颗粒', '从供应商进货：入库', 1000, '谢炜程', '2022-05-03 00:00:00', '药DIP0504001814');
INSERT INTO `out_or_in_info` VALUES (42, '苦甘颗粒', '发出药品销售：出库', 980, '谢炜程', '2022-05-04 00:09:33', '药DIP0504001814');
INSERT INTO `out_or_in_info` VALUES (43, '牛黄清心丸', '从供应商进货：入库', 1000, '谢炜程', '2022-05-03 00:00:00', '药DIP0504001837');
INSERT INTO `out_or_in_info` VALUES (44, '牛黄清心丸', '发出药品销售：出库', 980, '谢炜程', '2022-05-04 00:32:12', '药DIP0504001837');
INSERT INTO `out_or_in_info` VALUES (45, '阿莫西林颗粒', '从供应商进货：入库', 1000, '谢炜程', '2022-05-04 00:00:00', '药DIP0504001821');
INSERT INTO `out_or_in_info` VALUES (46, '阿莫西林颗粒', '发出药品销售：出库', 980, '谢炜程', '2022-05-04 00:44:33', '药DIP0504001821');
INSERT INTO `out_or_in_info` VALUES (47, '牛黄清心丸', '从供应商进货：入库', 500, '谢炜程', '2022-05-06 00:00:00', '药DIP0506155818');
INSERT INTO `out_or_in_info` VALUES (48, '牛黄清心丸', '发出药品销售：出库', 400, '谢炜程', '2022-05-06 16:00:08', '药DIP0506155818');

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收到退货表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_goods_info
-- ----------------------------
INSERT INTO `return_goods_info` VALUES (7, '天紫红女金胶囊', 20, '药品包装损坏。', 1612.00, '2022-04-23 10:43:06', '药DIP0423107398');
INSERT INTO `return_goods_info` VALUES (8, '苦甘颗粒', 1, '药品买错了。', 31.40, '2022-04-24 03:02:00', '药DIP0423147525');

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
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退回给供应商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_supplier_info
-- ----------------------------
INSERT INTO `return_supplier_info` VALUES (31, '天紫红女金胶囊', 300, '云南白药集团股份有限公司', '药品被打湿。', '2022-04-02 00:00:00', '药DIP0423107398');
INSERT INTO `return_supplier_info` VALUES (32, '天紫红女金胶囊', 200, '云南白药集团股份有限公司', '问题药品导入退货：药品临近过期。', '2022-04-23 10:44:45', '药DIP0423107398');
INSERT INTO `return_supplier_info` VALUES (33, '板蓝根颗粒', 100, '云南白药集团股份有限公司', '板蓝根颗粒在运算过程中遭到雨水的淋湿，药盒变形严重。', '2022-04-07 00:00:00', '药DIP0424019877');
INSERT INTO `return_supplier_info` VALUES (34, '苦甘颗粒', 20, '上海医药（集团）有限公司', '问题药品导入退货：药品外包装损坏。', '2022-04-24 02:23:07', '药DIP0423147525');
INSERT INTO `return_supplier_info` VALUES (35, '苦甘颗粒', 20, '上海医药（集团）有限公司', '问题药品导入退货：发霉。', '2022-05-04 00:09:04', '药DIP0504001814');
INSERT INTO `return_supplier_info` VALUES (36, '牛黄清心丸', 20, '山西广誉远中药有限公司', '问题药品导入退货：发霉。', '2022-05-04 00:31:48', '药DIP0504001837');
INSERT INTO `return_supplier_info` VALUES (37, '阿莫西林颗粒', 20, '石药控股集团有限公司', '问题药品导入退货：发霉。', '2022-05-04 00:44:00', '药DIP0504001821');
INSERT INTO `return_supplier_info` VALUES (38, '牛黄清心丸', 100, '山西广誉远中药有限公司', '问题药品导入退货：外包装损坏。', '2022-05-06 15:45:22', '药DIP0506155818');

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
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale_info
-- ----------------------------
INSERT INTO `sale_info` VALUES (9, '天紫红女金胶囊', '药DIP0423107398', 10, 806.00, '谢炜程', '2022-04-23 10:41:52');
INSERT INTO `sale_info` VALUES (10, '天紫红女金胶囊', '药DIP0423107398', 30, 2418.00, '谢炜程', '2022-04-23 10:42:20');
INSERT INTO `sale_info` VALUES (11, '天紫红女金胶囊', '药DIP0423107398', 400, 32240.00, '谢炜程', '2022-04-23 10:48:05');
INSERT INTO `sale_info` VALUES (12, '天紫红女金胶囊', '药DIP0423107398', 60, 4836.00, '谢炜程', '2022-04-23 10:51:39');
INSERT INTO `sale_info` VALUES (13, '苦甘颗粒', '药DIP0423147525', 1, 31.40, '谢炜程', '2022-04-24 02:56:48');
INSERT INTO `sale_info` VALUES (14, '苦甘颗粒', '药DIP0423147525', 79, 2480.60, '谢炜程', '2022-04-24 03:13:54');
INSERT INTO `sale_info` VALUES (15, '四物膏', '药DIP0425006837', 11, 916.30, '谢炜程', '2022-04-25 01:07:36');
INSERT INTO `sale_info` VALUES (16, '苦甘颗粒', '药DIP0504001814', 20, 628.00, '谢炜程', '2022-05-04 00:10:20');
INSERT INTO `sale_info` VALUES (17, '牛黄清心丸', '药DIP0504001837', 50, 6400.00, '谢炜程', '2022-05-04 00:32:43');
INSERT INTO `sale_info` VALUES (18, '阿莫西林颗粒', '药DIP0504001821', 80, 9600.00, '谢炜程', '2022-05-04 00:45:01');

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sell_is_gone
-- ----------------------------
INSERT INTO `sell_is_gone` VALUES (12, '天紫红女金胶囊', '云南白药集团股份有限公司', '药DIP0423107398', 480, 20, 0.96);
INSERT INTO `sell_is_gone` VALUES (13, '苦甘颗粒', '上海医药（集团）有限公司', '药DIP0423147525', 79, 1, 0.99);

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
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '哈药集团制药六厂', '哈药集团制药六厂成立于1994年05月20日，注册地位于哈尔滨市道外区南直路326号、哈尔滨市利民经济技术开发区兴业东路，法定代表人为姚诗涛。经营范围包括药品生产；生产包装材料，生产销售日用化学品、医疗器械；食品生产。', '2019-08-13 12:44:14');
INSERT INTO `supplier` VALUES (2, '湖南九典制药', '以研发为驱动，积极布局化学药、中药、原料药、辅料、植物提取和医药商业等产业版图，打造医药全产链，为患者提供安全有效的好药。', '2022-02-09 17:39:14');
INSERT INTO `supplier` VALUES (4, '云南白药集团股份有限公司', '云南白药是云南著名的中成药，由名贵药材制成，具有化瘀止血、活血止痛、解毒消肿之功效。它由云南民间医生曲焕章于清光绪二十八年（1902年）研制成功，原名“曲焕章百宝丹”。问世百多年来，云南白药以其独特、神奇的功效被誉为“中华瑰宝，伤科圣药”，也由此成名于世、蜚声海外。', '2022-02-25 15:37:42');
INSERT INTO `supplier` VALUES (8, '上海医药（集团）有限公司', '生产经营化学药品原料药，制剂药；畜用化学药品原料药，制剂药；农用杀菌剂，植物生长激素，微生物农药原料药；化工商品、生物制品、包装材料、机械设备及其零部件的销售；货物进出口、技术进出口。', '2022-02-25 16:24:55');
INSERT INTO `supplier` VALUES (10, '马应龙药业', '马应龙是一家经国内贸易部认定的中华老字号企业，创始于公元1582年。经过持续快速健康发展，马应龙已经成为一家涉足于药品制造、药品研发、药品批发零售、连锁医院等多个领域的专业化多功能国际化的医药类上市公司。', '2022-03-01 13:49:49');
INSERT INTO `supplier` VALUES (11, '九芝堂股份有限公司', '九芝堂股份有限公司是国家重点中药企业，国内A股上市公司，湖南省重点高 新技术企业，湖南省百强企业，湖南省质量管理奖企业，长沙市工业十大标志性工程龙头企业，国家博士后科研工作站企业。', '2022-03-01 13:51:06');
INSERT INTO `supplier` VALUES (12, '山西广誉远中药有限公司', '山西广誉远中药有限公司是我国现存历史最悠久的中药企业,其前身广盛号药店始创于明嘉靖二十年，公元1541年。在清代广誉远与广州陈李济（1600年建立），北京同仁堂（1669年建立），杭州胡庆余堂（1874年建立）并称为“清代四大药店”，现为山西省中药企业典范，并在2006年成为首批被中华人民共和国商务部认定的“中华老字号”企业。', '2022-03-01 13:52:20');
INSERT INTO `supplier` VALUES (13, '正大天晴药业集团股份有限公司', '正大天晴药业集团股份有限公司是集科研、生产和销售为一体的医药企业，总部位于江苏省连云港市海州区。', '2022-03-01 13:58:53');
INSERT INTO `supplier` VALUES (14, '石药控股集团有限公司', '石药控股集团有限公司是一家集创新药物研发、生产和销售为一体的国家级创新型企业 。石药集团，秉持“做好药，为中国，善报天下人”的理念，专注制药，坚持创新，实现了传统药企的转型发展。有国内外一体化的研发体系，10余个药品生产基地，  产品销售遍及全球100多个国家和地区。', '2022-03-01 14:37:14');
INSERT INTO `supplier` VALUES (15, '丽珠医药集团股份有限公司', '丽珠医药集团股份有限公司是集医药研发、生产、销售为一体的综合性企业集团，创建于1985年1月，水连香港，地接澳门，距广州深圳皆2小时车程，区位优势明显；公司注册资本为3.06亿元，系民营控股的上市公司。丽珠集团于1993年完成股份制改造，成为全国医药行业首家A、B股上市的公司。集团所属全资子公司12个，控股企业10个，现有员工5000人，大中专以上文化程度的员工占集团总人数的83%，企业技术力量雄厚，装备优良，工艺先进，生产水平和质量水平处于行业领先地位。集团有53条生产线通过了GMP认证验收，营销企业也顺利通过了国家GSP认证，营销力量显著增强，丽珠医药集团已建立了覆盖国内市场的营销网络，与商业主渠道和数千家医院建立了稳定、良好的业务关系；随着质量体系的持续完善和提高，随着销售的快速增长，随着产能的不断扩大，随着新厂建设步伐的加快，丽珠集团将成为国内领先、国际一流的现代化制药龙头企业。', '2022-03-01 14:40:04');
INSERT INTO `supplier` VALUES (16, '江苏康缘药业股份有限公司', '江苏康缘药业股份有限公司是一家集中药研发、生产、贸易为一体的大型中药企业，是国家中药现代化示范企业、国家重点高新技术企业、国内A股上市公司，获国家“质量管理先进企业”，“重合同、守信用企业”等荣誉称号。多年来，康缘药业坚持“体制创新”和“科技创新”，以“创新中药、健康人类”为宗旨，运用现代制药技术的新工艺、新剂型、新辅料不断提升传统中药的技术内涵，先后开发国家级新药47个，其中一类新药1个，二类新药13个，创新中药注射剂2个。', '2022-03-01 14:40:44');
INSERT INTO `supplier` VALUES (17, '上海强生制药有限公司', '生产及研发解热镇痛药、感冒咳嗽类药，布洛芬，肠胃药和医药保健产品，销售自产产品；医疗器械、化妆品、预包装食品（不含熟食卤味、冷冻冷藏）、日用品、化学品（危险化学品除外）的进口及批发、推广；药品的进口及推广；药品、医疗器械、保健食品、食品、化妆品、日用品、化学品的市场营销咨询、销售管理咨询服务；生产设备的经营性租赁。', '2022-04-21 22:11:37');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` int(0) NULL DEFAULT NULL COMMENT '登录状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 1);
INSERT INTO `user` VALUES (2, 'xiewc', 'xwc12345', 0);

SET FOREIGN_KEY_CHECKS = 1;
