/*
 Navicat Premium Data Transfer

 Source Server         : dc2-user
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : server.natappfree.cc:39965
 Source Schema         : lexian

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 23/07/2020 22:16:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动描述',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动图片',
  `beginTime` datetime(0) NOT NULL COMMENT '活动开始时间',
  `endTime` datetime(0) NOT NULL COMMENT '活动结束时间',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动类型',
  `status` int(0) NOT NULL COMMENT '活动状态',
  `is_delete` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '删除记录',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '活动表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, '618超值活动', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '2020-06-01 15:00:00', '2020-06-27 15:00:00', '秒杀', 1, 1, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (2, '双十一秒杀', '超值活动限时秒杀哦，机不可失失不再来', 'https://s1.ax1x.com/2020/07/16/UDFUWn.jpg', '2020-06-02 15:00:00', '2020-06-28 15:00:00', '团购', 0, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (3, '母亲节', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/aQUfoSNbAMVZW18.jpg', '2020-06-03 15:00:00', '2020-06-29 15:00:00', '节日限定', 1, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (4, '父亲节', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/lHXD89sNYjK47dM.jpg', '2020-06-04 15:00:00', '2020-06-30 15:00:00', '节日限定', 0, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (5, '年货大赏', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/49lZwkjxHPANgDY.jpg', '2020-06-05 15:00:00', '2020-07-01 15:00:00', '秒杀', 0, 0, '2020-07-07 19:10:33');
INSERT INTO `activity` VALUES (6, '618超值活动', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/Jc31uoftbGgZv5H.jpg', '2020-06-06 15:00:00', '2020-07-02 15:00:00', '团购', 0, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (7, '双十一秒杀', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/Jc31uoftbGgZv5H.jpg', '2020-06-07 15:00:00', '2020-07-03 15:00:00', '节日限定', 0, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (8, '母亲节', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/W9Iu736FtUGopqf.jpg', '2020-06-08 15:00:00', '2020-07-04 15:00:00', '节日限定', 1, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (9, '父亲节', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/PW9OmxoM631ghz7.jpg', '2020-06-09 15:00:00', '2020-07-05 15:00:00', '秒杀', 0, 1, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (10, '年货大赏', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/PW9OmxoM631ghz7.jpg', '2020-06-10 15:00:00', '2020-07-06 15:00:00', '团购', 1, 0, '2020-06-30 19:10:45');
INSERT INTO `activity` VALUES (11, '618超值活动', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/kmtiQ6HNdrhJ5w2.jpg', '2020-06-11 15:00:00', '2020-07-07 15:00:00', '节日限定', 0, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (12, '双十一秒杀', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/kmtiQ6HNdrhJ5w2.jpg', '2020-06-12 15:00:00', '2020-07-08 15:00:00', '节日限定', 0, 0, '2020-07-06 19:10:53');
INSERT INTO `activity` VALUES (13, '母亲节', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/ZJYzCxLy2oVmWRG.jpg', '2020-06-13 15:00:00', '2020-07-09 15:00:00', '秒杀', 1, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (14, '父亲节', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/GiufrwNnVmSbzR9.jpg', '2020-06-14 15:00:00', '2020-07-10 15:00:00', '团购', 0, 0, '2020-07-07 19:10:58');
INSERT INTO `activity` VALUES (15, '年货大赏', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/TpuIF4GzL5Qlq6R.jpg', '2020-06-15 15:00:00', '2020-07-11 15:00:00', '节日限定', 1, 0, '2020-07-06 19:10:21');
INSERT INTO `activity` VALUES (16, '618超值活动', '超值活动限时秒杀哦，机不可失失不再来', 'https://i.loli.net/2020/07/16/izHN7hLgwJ6EDVO.jpg', '2020-06-01 15:00:00', '2020-06-27 15:00:00', '秒杀', 1, 1, '2020-07-06 19:10:21');

-- ----------------------------
-- Table structure for activity_commodity
-- ----------------------------
DROP TABLE IF EXISTS `activity_commodity`;
CREATE TABLE `activity_commodity`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `activity_id` int(0) NOT NULL COMMENT '活动id',
  `commodity_id` int(0) NOT NULL COMMENT '商品id',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `activity_id`(`activity_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `activity_commodity_ibfk_1` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `activity_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '活动_商品关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_commodity
-- ----------------------------
INSERT INTO `activity_commodity` VALUES (1, 1, 1, 0);
INSERT INTO `activity_commodity` VALUES (2, 1, 2, 0);
INSERT INTO `activity_commodity` VALUES (3, 1, 3, 0);
INSERT INTO `activity_commodity` VALUES (4, 2, 4, 0);
INSERT INTO `activity_commodity` VALUES (5, 3, 5, 0);
INSERT INTO `activity_commodity` VALUES (6, 4, 6, 0);
INSERT INTO `activity_commodity` VALUES (7, 5, 7, 0);
INSERT INTO `activity_commodity` VALUES (8, 6, 8, 0);
INSERT INTO `activity_commodity` VALUES (9, 7, 9, 0);
INSERT INTO `activity_commodity` VALUES (10, 7, 4, 0);
INSERT INTO `activity_commodity` VALUES (11, 11, 11, 0);
INSERT INTO `activity_commodity` VALUES (12, 12, 12, 0);
INSERT INTO `activity_commodity` VALUES (13, 13, 13, 0);
INSERT INTO `activity_commodity` VALUES (14, 14, 14, 0);
INSERT INTO `activity_commodity` VALUES (15, 15, 15, 0);
INSERT INTO `activity_commodity` VALUES (16, 16, 16, 0);

-- ----------------------------
-- Table structure for activity_shop
-- ----------------------------
DROP TABLE IF EXISTS `activity_shop`;
CREATE TABLE `activity_shop`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `shop_id` int(0) NOT NULL COMMENT '店铺id',
  `activity_id` int(0) NOT NULL COMMENT '活动id',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  INDEX `activity_id`(`activity_id`) USING BTREE,
  CONSTRAINT `activity_shop_ibfk_2` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `activity_shop_ibfk_3` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '活动_店铺关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_shop
-- ----------------------------
INSERT INTO `activity_shop` VALUES (1, 1, 1, 0);
INSERT INTO `activity_shop` VALUES (2, 1, 2, 0);
INSERT INTO `activity_shop` VALUES (3, 1, 3, 0);
INSERT INTO `activity_shop` VALUES (4, 1, 4, 0);
INSERT INTO `activity_shop` VALUES (5, 2, 5, 0);
INSERT INTO `activity_shop` VALUES (6, 2, 6, 0);
INSERT INTO `activity_shop` VALUES (7, 2, 7, 0);

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '省份',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '市',
  `area` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '区',
  `location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '详细地址',
  `postcode` int(0) NULL DEFAULT NULL COMMENT '邮政编码',
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人姓名',
  `phone` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人联系方式‘',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  INDEX `ID_2`(`ID`) USING BTREE,
  INDEX `ID_3`(`ID`) USING BTREE,
  INDEX `ID_4`(`ID`) USING BTREE,
  INDEX `ID_5`(`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客地址信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '湖北省', '武汉市', '武昌区', '安国路耀江花园', 430061, '张木兰', '13978654123', 0);
INSERT INTO `address` VALUES (2, '山东省', '济南市', '历下区', '百花街真新六街坊', 250000, '潘敏智', '13978654124', 0);
INSERT INTO `address` VALUES (3, '辽宁省', '沈阳市', '和平区', '白城路和亭佳苑', 110000, '魏鹤轩', '13978654125', 0);
INSERT INTO `address` VALUES (4, '北京市', '北京市', '朝阳区', '宝昌路协通公寓', 100000, '崔和悦', '13978654126', 0);
INSERT INTO `address` VALUES (5, '河南省', '洛阳市', '涧西区', '天津路(云峰国际)', 110000, '朱奇邃', '13978654127', 0);
INSERT INTO `address` VALUES (6, '浙江省', '杭州市', '西湖区', '宝安路菊园五街坊', 310012, '龚玉泽', '13978654128', 0);
INSERT INTO `address` VALUES (7, '湖南省', '长沙市', '岳麓区', '白城南住友嘉馨名园', 410006, '乔紫丝', '13978654129', 0);
INSERT INTO `address` VALUES (8, '河南省', '郑州市', '中原区', '安澜路阳光翠竹苑', 450000, '邓洁静', '13978654130', 0);
INSERT INTO `address` VALUES (9, '云南省', '昆明市', '盘龙区', '巴林路复华城市花园', 650000, '陆正平', '13978654131', 0);
INSERT INTO `address` VALUES (10, '广东省', '广州市', '越秀区', '宝安公路爱里舍花园', 510030, '刘平绿', '13978654132', 0);
INSERT INTO `address` VALUES (11, '湖北省', '咸宁市', '赤壁市', '八一路博仁天下公寓', 437300, '郑綪纶', '13978654133', 0);
INSERT INTO `address` VALUES (12, '湖北省', '武汉市', '青山区', '澳门路新德凯赛公寓', 430080, '傅和平', '13978654134', 0);
INSERT INTO `address` VALUES (13, '山东省', '济南市', '天桥区', '板泉路龙昂别馆', 250000, '侯弘深', '13978654135', 0);
INSERT INTO `address` VALUES (14, '辽宁省', '沈阳市', '和平区', '安福路东新大厦', 110000, '周勇捷', '13978654136', 0);
INSERT INTO `address` VALUES (15, '北京市', '北京市', '昌平区', '安龙路溢盈河畔别墅', 102200, '赵哲彦', '13978654137', 0);
INSERT INTO `address` VALUES (16, '辽宁省', '沈阳市', '浑南区', '包头南路博耶顿花园', 110000, '赖高歌', '13978654138', 0);
INSERT INTO `address` VALUES (17, '浙江省', '杭州市', '余杭区', '半淞园路百花佳苑', 311100, '钱璇珠', '13978654139', 0);
INSERT INTO `address` VALUES (18, '湖南省', '长沙市', '芙蓉区', '百色路天人新苑', 410000, '贾从蓉', '13978654140', 0);
INSERT INTO `address` VALUES (19, '河南省', '郑州市', '金水区', '包头路爱佳公寓', 450000, '王友琴', '13978654141', 0);
INSERT INTO `address` VALUES (20, '云南省', '昆明市', '五华区', '安汾路金色家园', 650000, '秦君丽', '13978654142', 0);
INSERT INTO `address` VALUES (41, '河南省', '郑州', '市', '金水区黄河南路(金水区中义·阿卡迪亚(黄河南路西))', NULL, '金砖', '13840510891', 0);
INSERT INTO `address` VALUES (42, '湖南省', '长沙市', '岳麓区', '岳麓大道218号(中共长沙市委员会)', NULL, 'x', '13241231231', 0);

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限名称',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, '经营权', 0);
INSERT INTO `authority` VALUES (2, '自由开展活动权', 0);
INSERT INTO `authority` VALUES (3, '参与平台活动权', 0);
INSERT INTO `authority` VALUES (4, '首页申请权', 0);
INSERT INTO `authority` VALUES (5, '分类查看权', 0);
INSERT INTO `authority` VALUES (6, '分类修改权', 0);

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id唯一自增',
  `order_number` char(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账单号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账单商品名称',
  `consume_price` decimal(10, 2) NOT NULL COMMENT '账单消费金额',
  `consume_time` datetime(0) NOT NULL COMMENT '账单消费日期',
  `order_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账单状态',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '账单明细表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, '806945236921591', '罗技无线鼠标', 100.00, '2020-06-17 15:38:01', '已完成', 0);
INSERT INTO `bill` VALUES (2, '806945236921592', '罗技无线键盘', 120.00, '2020-06-06 16:15:05', '待收货', 0);
INSERT INTO `bill` VALUES (3, '806945236921593', '戴尔笔记本', 4999.00, '2020-06-07 13:01:01', '等待退款', 0);
INSERT INTO `bill` VALUES (4, '806945236921594', 'A4纸500张', 20.00, '2020-06-08 14:01:01', '待评价', 0);
INSERT INTO `bill` VALUES (5, '806945236921595', '保温杯', 35.00, '2020-06-09 19:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (6, '806945236921596', '惠普打印机', 500.00, '2020-06-10 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (7, '806945236921597', '台灯', 78.00, '2020-06-11 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (8, '806945236921598', '纸巾', 20.00, '2020-06-12 23:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (9, '806945236921599', '罗技无线鼠标', 100.00, '2020-06-13 13:01:01', '待收货', 0);
INSERT INTO `bill` VALUES (10, '806945236921600', '罗技无线键盘', 120.00, '2020-06-14 13:01:01', '等待退款', 0);
INSERT INTO `bill` VALUES (11, '806945236921601', '戴尔笔记本', 4999.00, '2020-06-15 13:01:01', '待评价', 0);
INSERT INTO `bill` VALUES (12, '806945236921602', 'A4纸500张', 20.00, '2020-06-16 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (13, '806945236921603', '保温杯', 35.00, '2020-06-17 16:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (14, '806945236921604', '惠普打印机', 500.00, '2020-06-18 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (15, '806945236921605', '台灯', 78.00, '2020-06-19 13:01:01', '待收货', 0);
INSERT INTO `bill` VALUES (16, '806945236921606', '纸巾', 20.00, '2020-06-20 13:01:01', '等待退款', 0);
INSERT INTO `bill` VALUES (17, '806945236921607', '罗技无线鼠标', 100.00, '2020-06-21 13:01:01', '待评价', 0);
INSERT INTO `bill` VALUES (18, '806945236921608', '罗技无线键盘', 120.00, '2020-06-22 17:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (19, '806945236921609', '戴尔笔记本', 4999.00, '2020-06-23 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (20, '806945236921610', 'A4纸500张', 20.00, '2020-06-24 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (21, '806945236921611', '保温杯', 35.00, '2020-06-25 13:01:01', '待收货', 0);
INSERT INTO `bill` VALUES (22, '806945236921612', '惠普打印机', 500.00, '2020-06-26 13:01:01', '等待退款', 0);
INSERT INTO `bill` VALUES (23, '806945236921613', '台灯', 78.00, '2020-06-27 18:01:01', '待评价', 0);
INSERT INTO `bill` VALUES (24, '806945236921614', '纸巾', 20.00, '2020-06-28 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (25, '806945236921615', '罗技无线鼠标', 100.00, '2020-06-29 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (26, '806945236921616', '罗技无线键盘', 120.00, '2020-06-30 13:01:01', '已完成', 0);
INSERT INTO `bill` VALUES (27, '806945236921617', '戴尔笔记本', 4999.00, '2020-07-01 13:01:01', '待收货', 0);
INSERT INTO `bill` VALUES (28, '806945236921618', 'A4纸500张', 20.00, '2020-07-02 13:01:01', '等待退款', 0);
INSERT INTO `bill` VALUES (29, '806945236921619', '保温杯', 35.00, '2020-07-03 13:01:01', '待评价', 0);
INSERT INTO `bill` VALUES (46, '772900721021614', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:16:14', '待收货', 0);
INSERT INTO `bill` VALUES (47, '763500721021853', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:18:53', '待收货', 0);
INSERT INTO `bill` VALUES (48, '975200721022011', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:20:12', '待收货', 0);
INSERT INTO `bill` VALUES (49, '940600721022530', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:25:31', '待收货', 0);
INSERT INTO `bill` VALUES (50, '308400721023117', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:31:18', '待收货', 0);
INSERT INTO `bill` VALUES (51, '639800721023442', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:34:43', '待收货', 0);
INSERT INTO `bill` VALUES (52, '663900721023805', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:38:06', '待收货', 0);
INSERT INTO `bill` VALUES (53, '804300721023857', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-20 18:38:58', '待收货', 0);
INSERT INTO `bill` VALUES (54, '386500721115756', '电视柜摆件凤凰轻奢工艺美式家居软装摆设客厅欧式装饰品结婚礼物', 108.58, '2020-07-21 03:57:57', '待收货', 0);
INSERT INTO `bill` VALUES (55, '169700721122037', '皮卡丘联名短袖t恤男士', 342.00, '2020-07-21 04:20:38', '待收货', 0);
INSERT INTO `bill` VALUES (56, '221700722144439', '华为旗下荣耀手机荣耀9X麒麟810芯片4800万超清双摄全面屏智能手机官网旗舰', 1099.98, '2020-07-22 06:44:40', '待收货', 0);
INSERT INTO `bill` VALUES (57, '962200722144451', '华为旗下荣耀手机荣耀9X麒麟810芯片4800万超清双摄全面屏智能手机官网旗舰', 1099.98, '2020-07-22 06:44:52', '待收货', 0);
INSERT INTO `bill` VALUES (58, '852900723210317', 'OPPO Reno Ace骁龙855plus智能游戏手机全面屏65W闪充官方旗舰店renoace3', 2899.58, '2020-07-23 13:03:18', '待收货', 0);
INSERT INTO `bill` VALUES (59, '105500723210359', 'OPPO Reno Ace骁龙855plus智能游戏手机全面屏65W闪充官方旗舰店renoace3', 2899.58, '2020-07-23 13:03:59', '待收货', 0);

-- ----------------------------
-- Table structure for browsing_record
-- ----------------------------
DROP TABLE IF EXISTS `browsing_record`;
CREATE TABLE `browsing_record`  (
  `commodity_id` int(0) NOT NULL COMMENT '连接commodity的ID',
  `customer_id` int(0) NOT NULL COMMENT '连接customer表的ID',
  `browsing_time` datetime(0) NOT NULL COMMENT '浏览时间',
  `isDelete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `date` datetime(6) NOT NULL COMMENT '修改时间',
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `browsing_commodity`(`commodity_id`) USING BTREE,
  INDEX `browsing_customer`(`customer_id`) USING BTREE,
  CONSTRAINT `browsing_commodity` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `browsing_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 295 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '浏览记录（关系表）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of browsing_record
-- ----------------------------
INSERT INTO `browsing_record` VALUES (11, 1, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 1);
INSERT INTO `browsing_record` VALUES (12, 1, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 2);
INSERT INTO `browsing_record` VALUES (13, 1, '2020-12-31 14:40:31', 0, '2020-12-31 14:40:31.000000', 3);
INSERT INTO `browsing_record` VALUES (14, 1, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 4);
INSERT INTO `browsing_record` VALUES (15, 1, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 5);
INSERT INTO `browsing_record` VALUES (16, 1, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 6);
INSERT INTO `browsing_record` VALUES (17, 1, '2020-12-15 18:19:03', 0, '2020-12-15 18:19:03.000000', 7);
INSERT INTO `browsing_record` VALUES (18, 1, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 8);
INSERT INTO `browsing_record` VALUES (19, 2, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 9);
INSERT INTO `browsing_record` VALUES (20, 2, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 10);
INSERT INTO `browsing_record` VALUES (31, 2, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 11);
INSERT INTO `browsing_record` VALUES (32, 2, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 12);
INSERT INTO `browsing_record` VALUES (33, 2, '2020-06-21 14:07:36', 0, '2020-06-21 14:07:36.000000', 13);
INSERT INTO `browsing_record` VALUES (34, 2, '2020-06-21 14:07:02', 0, '2020-06-21 14:07:02.000000', 14);
INSERT INTO `browsing_record` VALUES (35, 2, '2020-06-21 14:07:04', 0, '2020-06-21 14:07:04.000000', 15);
INSERT INTO `browsing_record` VALUES (36, 2, '2020-06-21 14:07:05', 0, '2020-06-21 14:07:05.000000', 16);
INSERT INTO `browsing_record` VALUES (37, 3, '2020-06-21 14:07:06', 0, '2020-06-21 14:07:06.000000', 17);
INSERT INTO `browsing_record` VALUES (38, 3, '2020-06-21 14:07:10', 0, '2020-06-21 14:07:10.000000', 18);
INSERT INTO `browsing_record` VALUES (39, 3, '2020-06-21 14:07:08', 0, '2020-06-21 14:07:08.000000', 19);
INSERT INTO `browsing_record` VALUES (12, 3, '2020-06-21 14:07:12', 0, '2020-06-21 14:07:12.000000', 20);
INSERT INTO `browsing_record` VALUES (41, 3, '2020-06-21 14:07:11', 0, '2020-06-21 14:07:11.000000', 21);
INSERT INTO `browsing_record` VALUES (41, 3, '2020-06-21 14:07:14', 0, '2020-06-21 14:07:14.000000', 22);
INSERT INTO `browsing_record` VALUES (42, 3, '2020-06-21 14:07:25', 0, '2020-06-21 14:07:25.000000', 23);
INSERT INTO `browsing_record` VALUES (43, 3, '2020-06-21 14:07:26', 0, '2020-06-21 14:07:26.000000', 24);
INSERT INTO `browsing_record` VALUES (44, 3, '2020-06-21 14:07:28', 0, '2020-06-21 14:07:28.000000', 25);
INSERT INTO `browsing_record` VALUES (45, 4, '2020-06-21 14:07:29', 0, '2020-06-21 14:07:29.000000', 26);
INSERT INTO `browsing_record` VALUES (46, 4, '2020-06-21 14:07:11', 0, '2020-06-21 14:07:11.000000', 27);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-18 08:23:51', 0, '2020-07-18 08:23:51.389000', 165);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-18 08:24:07', 0, '2020-07-18 08:24:06.693000', 166);
INSERT INTO `browsing_record` VALUES (3, 1, '2020-07-18 08:24:23', 0, '2020-07-18 08:24:22.959000', 167);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-18 08:24:49', 0, '2020-07-18 08:24:49.220000', 168);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-18 08:25:52', 0, '2020-07-18 08:25:51.929000', 169);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-18 08:26:11', 0, '2020-07-18 08:26:11.434000', 170);
INSERT INTO `browsing_record` VALUES (7, 1, '2020-07-18 08:26:47', 0, '2020-07-18 08:26:46.862000', 171);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-18 09:00:15', 0, '2020-07-18 09:00:14.711000', 172);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-18 09:00:43', 0, '2020-07-18 09:00:43.373000', 173);
INSERT INTO `browsing_record` VALUES (7, 1, '2020-07-18 09:00:52', 0, '2020-07-18 09:00:51.914000', 174);
INSERT INTO `browsing_record` VALUES (77, 1, '2020-07-18 09:01:43', 0, '2020-07-18 09:01:42.775000', 175);
INSERT INTO `browsing_record` VALUES (10, 1, '2020-07-18 09:02:00', 0, '2020-07-18 09:02:00.351000', 176);
INSERT INTO `browsing_record` VALUES (10, 1, '2020-07-18 09:02:05', 0, '2020-07-18 09:02:05.131000', 177);
INSERT INTO `browsing_record` VALUES (60, 1, '2020-07-18 09:02:54', 0, '2020-07-18 09:02:54.247000', 178);
INSERT INTO `browsing_record` VALUES (80, 1, '2020-07-18 09:03:10', 0, '2020-07-18 09:03:10.429000', 179);
INSERT INTO `browsing_record` VALUES (81, 1, '2020-07-18 09:03:22', 0, '2020-07-18 09:03:22.206000', 180);
INSERT INTO `browsing_record` VALUES (83, 1, '2020-07-18 09:03:35', 0, '2020-07-18 09:03:35.362000', 181);
INSERT INTO `browsing_record` VALUES (13, 1, '2020-07-18 09:03:51', 0, '2020-07-18 09:03:50.692000', 182);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-18 12:06:24', 0, '2020-07-18 12:06:24.388000', 183);
INSERT INTO `browsing_record` VALUES (3, 1, '2020-07-18 12:06:34', 0, '2020-07-18 12:06:33.561000', 184);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-18 14:57:48', 0, '2020-07-18 14:57:47.991000', 185);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-19 04:28:22', 0, '2020-07-19 04:28:21.511000', 186);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-19 04:28:39', 0, '2020-07-19 04:28:39.071000', 187);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-19 04:29:19', 0, '2020-07-19 04:29:18.979000', 188);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-19 04:33:38', 0, '2020-07-19 04:33:37.812000', 189);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-19 04:34:07', 0, '2020-07-19 04:34:06.975000', 190);
INSERT INTO `browsing_record` VALUES (3, 1, '2020-07-19 04:34:22', 0, '2020-07-19 04:34:21.822000', 191);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-19 04:34:30', 0, '2020-07-19 04:34:30.133000', 192);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-19 04:34:51', 0, '2020-07-19 04:34:50.936000', 193);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-19 04:35:13', 0, '2020-07-19 04:35:12.897000', 194);
INSERT INTO `browsing_record` VALUES (70, 1, '2020-07-19 04:41:53', 0, '2020-07-19 04:41:53.335000', 195);
INSERT INTO `browsing_record` VALUES (70, 1, '2020-07-19 04:45:57', 0, '2020-07-19 04:45:56.940000', 196);
INSERT INTO `browsing_record` VALUES (70, 1, '2020-07-19 04:47:14', 0, '2020-07-19 04:47:13.507000', 197);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-19 04:47:47', 0, '2020-07-19 04:47:46.860000', 198);
INSERT INTO `browsing_record` VALUES (70, 1, '2020-07-19 04:50:00', 0, '2020-07-19 04:49:59.803000', 199);
INSERT INTO `browsing_record` VALUES (60, 1, '2020-07-19 04:51:28', 0, '2020-07-19 04:51:27.633000', 200);
INSERT INTO `browsing_record` VALUES (68, 1, '2020-07-19 04:53:41', 0, '2020-07-19 04:53:41.158000', 201);
INSERT INTO `browsing_record` VALUES (65, 1, '2020-07-19 04:53:58', 0, '2020-07-19 04:53:58.352000', 202);
INSERT INTO `browsing_record` VALUES (84, 1, '2020-07-19 04:54:06', 0, '2020-07-19 04:54:06.161000', 203);
INSERT INTO `browsing_record` VALUES (68, 1, '2020-07-19 05:06:44', 0, '2020-07-19 05:06:43.823000', 204);
INSERT INTO `browsing_record` VALUES (68, 1, '2020-07-19 05:09:02', 0, '2020-07-19 05:09:01.578000', 205);
INSERT INTO `browsing_record` VALUES (78, 1, '2020-07-19 07:59:33', 0, '2020-07-19 07:59:33.251000', 206);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-20 06:53:40', 0, '2020-07-20 06:53:39.922000', 207);
INSERT INTO `browsing_record` VALUES (12, 1, '2020-07-20 06:54:15', 0, '2020-07-20 06:54:14.854000', 208);
INSERT INTO `browsing_record` VALUES (12, 1, '2020-07-20 07:19:11', 0, '2020-07-20 07:19:10.866000', 209);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-20 08:33:41', 0, '2020-07-20 08:33:40.868000', 210);
INSERT INTO `browsing_record` VALUES (4, 1, '2020-07-20 08:59:03', 0, '2020-07-20 08:59:02.600000', 211);
INSERT INTO `browsing_record` VALUES (12, 1, '2020-07-20 09:00:03', 0, '2020-07-20 09:00:02.679000', 212);
INSERT INTO `browsing_record` VALUES (6, 1, '2020-07-20 09:00:08', 0, '2020-07-20 09:00:08.163000', 213);
INSERT INTO `browsing_record` VALUES (68, 1, '2020-07-20 09:00:57', 0, '2020-07-20 09:00:57.408000', 214);
INSERT INTO `browsing_record` VALUES (5, 1, '2020-07-20 09:02:01', 0, '2020-07-20 09:02:00.970000', 215);
INSERT INTO `browsing_record` VALUES (3, 1, '2020-07-20 09:37:03', 0, '2020-07-20 09:37:03.259000', 216);
INSERT INTO `browsing_record` VALUES (35, 1, '2020-07-20 12:56:59', 0, '2020-07-20 12:56:59.185000', 217);
INSERT INTO `browsing_record` VALUES (36, 1, '2020-07-20 12:57:06', 0, '2020-07-20 12:57:06.441000', 218);
INSERT INTO `browsing_record` VALUES (79, 1, '2020-07-20 12:57:14', 0, '2020-07-20 12:57:13.608000', 219);
INSERT INTO `browsing_record` VALUES (79, 1, '2020-07-20 12:57:22', 0, '2020-07-20 12:57:22.374000', 220);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-20 12:58:17', 0, '2020-07-20 12:58:17.212000', 221);
INSERT INTO `browsing_record` VALUES (61, 1, '2020-07-20 12:59:42', 0, '2020-07-20 12:59:42.496000', 222);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-20 13:01:16', 0, '2020-07-20 13:01:16.131000', 223);
INSERT INTO `browsing_record` VALUES (8, 1, '2020-07-20 13:01:18', 0, '2020-07-20 13:01:17.994000', 224);
INSERT INTO `browsing_record` VALUES (55, 1, '2020-07-20 13:01:35', 0, '2020-07-20 13:01:35.363000', 225);
INSERT INTO `browsing_record` VALUES (57, 1, '2020-07-20 13:02:04', 0, '2020-07-20 13:02:04.484000', 226);
INSERT INTO `browsing_record` VALUES (73, 1, '2020-07-20 13:02:21', 0, '2020-07-20 13:02:21.457000', 227);
INSERT INTO `browsing_record` VALUES (13, 1, '2020-07-20 15:18:29', 0, '2020-07-20 15:18:28.518000', 228);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-20 15:26:09', 0, '2020-07-20 15:26:09.095000', 229);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-20 15:26:35', 0, '2020-07-20 15:26:34.623000', 230);
INSERT INTO `browsing_record` VALUES (81, 1, '2020-07-20 15:26:53', 0, '2020-07-20 15:26:52.864000', 231);
INSERT INTO `browsing_record` VALUES (73, 1, '2020-07-20 16:54:43', 0, '2020-07-20 16:54:42.938000', 232);
INSERT INTO `browsing_record` VALUES (51, 1, '2020-07-20 16:56:59', 0, '2020-07-20 16:56:59.225000', 233);
INSERT INTO `browsing_record` VALUES (57, 1, '2020-07-20 16:59:57', 0, '2020-07-20 16:59:56.698000', 234);
INSERT INTO `browsing_record` VALUES (80, 1, '2020-07-20 17:00:03', 0, '2020-07-20 17:00:02.627000', 235);
INSERT INTO `browsing_record` VALUES (74, 1, '2020-07-20 17:06:05', 0, '2020-07-20 17:06:05.443000', 236);
INSERT INTO `browsing_record` VALUES (80, 1, '2020-07-20 17:11:42', 0, '2020-07-20 17:11:42.077000', 237);
INSERT INTO `browsing_record` VALUES (80, 1, '2020-07-20 17:26:13', 0, '2020-07-20 17:26:12.994000', 238);
INSERT INTO `browsing_record` VALUES (17, 1, '2020-07-20 17:32:12', 0, '2020-07-20 17:32:12.122000', 239);
INSERT INTO `browsing_record` VALUES (67, 1, '2020-07-20 18:03:10', 0, '2020-07-20 18:03:09.917000', 240);
INSERT INTO `browsing_record` VALUES (13, 1, '2020-07-21 01:43:00', 0, '2020-07-21 01:43:00.445000', 241);
INSERT INTO `browsing_record` VALUES (63, 1, '2020-07-21 01:43:18', 0, '2020-07-21 01:43:17.556000', 242);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 01:43:22', 0, '2020-07-21 01:43:22.257000', 243);
INSERT INTO `browsing_record` VALUES (55, 1, '2020-07-21 01:44:30', 0, '2020-07-21 01:44:29.715000', 244);
INSERT INTO `browsing_record` VALUES (13, 1, '2020-07-21 01:51:43', 0, '2020-07-21 01:51:42.701000', 245);
INSERT INTO `browsing_record` VALUES (51, 1, '2020-07-21 02:08:19', 0, '2020-07-21 02:08:18.522000', 246);
INSERT INTO `browsing_record` VALUES (11, 1, '2020-07-21 02:10:30', 0, '2020-07-21 02:10:29.559000', 247);
INSERT INTO `browsing_record` VALUES (12, 1, '2020-07-21 02:10:39', 0, '2020-07-21 02:10:39.264000', 248);
INSERT INTO `browsing_record` VALUES (51, 1, '2020-07-21 02:11:08', 0, '2020-07-21 02:11:08.137000', 249);
INSERT INTO `browsing_record` VALUES (7, 1, '2020-07-21 02:11:21', 0, '2020-07-21 02:11:21.057000', 250);
INSERT INTO `browsing_record` VALUES (6, 1, '2020-07-21 02:11:41', 0, '2020-07-21 02:11:40.811000', 251);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 02:12:26', 0, '2020-07-21 02:12:25.670000', 252);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 02:21:35', 0, '2020-07-21 02:21:34.605000', 253);
INSERT INTO `browsing_record` VALUES (63, 1, '2020-07-21 02:21:57', 0, '2020-07-21 02:21:56.969000', 254);
INSERT INTO `browsing_record` VALUES (73, 1, '2020-07-21 02:27:20', 0, '2020-07-21 02:27:19.718000', 255);
INSERT INTO `browsing_record` VALUES (38, 1, '2020-07-21 02:42:31', 0, '2020-07-21 02:42:30.692000', 256);
INSERT INTO `browsing_record` VALUES (3, 1, '2020-07-21 02:45:54', 0, '2020-07-21 02:45:53.642000', 257);
INSERT INTO `browsing_record` VALUES (84, 1, '2020-07-21 03:02:53', 0, '2020-07-21 03:02:52.576000', 258);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 03:03:10', 0, '2020-07-21 03:03:09.946000', 259);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 03:03:34', 0, '2020-07-21 03:03:34.307000', 260);
INSERT INTO `browsing_record` VALUES (56, 1, '2020-07-21 03:05:08', 0, '2020-07-21 03:05:07.971000', 261);
INSERT INTO `browsing_record` VALUES (13, 1, '2020-07-21 03:15:21', 0, '2020-07-21 03:15:20.734000', 262);
INSERT INTO `browsing_record` VALUES (84, 1, '2020-07-21 03:15:27', 0, '2020-07-21 03:15:26.882000', 263);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 03:15:31', 0, '2020-07-21 03:15:30.640000', 264);
INSERT INTO `browsing_record` VALUES (8, 1, '2020-07-21 03:15:41', 0, '2020-07-21 03:15:41.419000', 265);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 03:15:58', 0, '2020-07-21 03:15:57.773000', 266);
INSERT INTO `browsing_record` VALUES (13, 1, '2020-07-21 03:17:43', 0, '2020-07-21 03:17:43.364000', 267);
INSERT INTO `browsing_record` VALUES (4, 1, '2020-07-21 03:33:57', 0, '2020-07-21 03:33:57.094000', 268);
INSERT INTO `browsing_record` VALUES (10, 1, '2020-07-21 03:34:31', 0, '2020-07-21 03:34:30.760000', 269);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 03:35:16', 0, '2020-07-21 03:35:15.589000', 270);
INSERT INTO `browsing_record` VALUES (55, 1, '2020-07-21 03:45:00', 0, '2020-07-21 03:44:59.561000', 271);
INSERT INTO `browsing_record` VALUES (67, 1, '2020-07-21 04:20:19', 0, '2020-07-21 04:20:19.368000', 272);
INSERT INTO `browsing_record` VALUES (12, 1, '2020-07-21 05:30:42', 0, '2020-07-21 05:30:41.774000', 273);
INSERT INTO `browsing_record` VALUES (17, 1, '2020-07-21 05:54:17', 0, '2020-07-21 05:54:16.519000', 274);
INSERT INTO `browsing_record` VALUES (57, 1, '2020-07-21 05:54:23', 0, '2020-07-21 05:54:22.975000', 275);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 06:02:29', 0, '2020-07-21 06:02:28.503000', 276);
INSERT INTO `browsing_record` VALUES (5, 1, '2020-07-21 06:09:23', 0, '2020-07-21 06:09:23.074000', 277);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-21 06:13:33', 0, '2020-07-21 06:13:33.442000', 278);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-21 06:13:40', 0, '2020-07-21 06:13:39.958000', 279);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 06:20:35', 0, '2020-07-21 06:20:34.641000', 280);
INSERT INTO `browsing_record` VALUES (38, 1, '2020-07-21 06:21:17', 0, '2020-07-21 06:21:17.104000', 281);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-21 06:21:24', 0, '2020-07-21 06:21:23.868000', 282);
INSERT INTO `browsing_record` VALUES (39, 1, '2020-07-21 06:22:21', 0, '2020-07-21 06:22:21.396000', 283);
INSERT INTO `browsing_record` VALUES (39, 1, '2020-07-21 06:22:31', 0, '2020-07-21 06:22:31.247000', 284);
INSERT INTO `browsing_record` VALUES (5, 1, '2020-07-21 06:24:28', 0, '2020-07-21 06:24:27.954000', 285);
INSERT INTO `browsing_record` VALUES (1, 4, '2020-07-22 06:43:27', 0, '2020-07-22 06:43:26.695000', 286);
INSERT INTO `browsing_record` VALUES (1, 4, '2020-07-22 06:44:28', 0, '2020-07-22 06:44:28.301000', 287);
INSERT INTO `browsing_record` VALUES (1, 4, '2020-07-22 06:47:48', 0, '2020-07-22 06:47:47.760000', 288);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-23 11:53:11', 0, '2020-07-23 11:53:11.192000', 289);
INSERT INTO `browsing_record` VALUES (11, 1, '2020-07-23 11:56:20', 0, '2020-07-23 11:56:20.097000', 290);
INSERT INTO `browsing_record` VALUES (14, 1, '2020-07-23 11:57:03', 0, '2020-07-23 11:57:02.806000', 291);
INSERT INTO `browsing_record` VALUES (11, 1, '2020-07-23 11:59:07', 0, '2020-07-23 11:59:07.017000', 292);
INSERT INTO `browsing_record` VALUES (11, 1, '2020-07-23 13:01:38', 0, '2020-07-23 13:01:37.561000', 293);
INSERT INTO `browsing_record` VALUES (14, 1, '2020-07-23 13:02:17', 0, '2020-07-23 13:02:17.154000', 294);
INSERT INTO `browsing_record` VALUES (1, 1, '2020-07-23 13:44:46', 0, '2020-07-23 13:44:46.114000', 295);
INSERT INTO `browsing_record` VALUES (6, 1, '2020-07-23 13:50:37', 0, '2020-07-23 13:50:37.278000', 296);
INSERT INTO `browsing_record` VALUES (1, 3, '2020-07-23 13:55:45', 0, '2020-07-23 13:55:45.093000', 297);
INSERT INTO `browsing_record` VALUES (2, 1, '2020-07-23 14:02:48', 0, '2020-07-23 14:02:47.851000', 298);
INSERT INTO `browsing_record` VALUES (3, 1, '2020-07-23 14:02:54', 0, '2020-07-23 14:02:53.568000', 299);
INSERT INTO `browsing_record` VALUES (4, 1, '2020-07-23 14:03:00', 0, '2020-07-23 14:02:59.670000', 300);
INSERT INTO `browsing_record` VALUES (10, 1, '2020-07-23 14:03:06', 0, '2020-07-23 14:03:06.019000', 301);
INSERT INTO `browsing_record` VALUES (30, 3, '2020-07-23 14:12:33', 0, '2020-07-23 14:12:32.810000', 302);
INSERT INTO `browsing_record` VALUES (27, 3, '2020-07-23 14:12:39', 0, '2020-07-23 14:12:38.865000', 303);
INSERT INTO `browsing_record` VALUES (53, 3, '2020-07-23 14:15:48', 0, '2020-07-23 14:15:48.016000', 304);
INSERT INTO `browsing_record` VALUES (72, 3, '2020-07-23 14:15:59', 0, '2020-07-23 14:15:59.012000', 305);
INSERT INTO `browsing_record` VALUES (72, 3, '2020-07-23 14:16:08', 0, '2020-07-23 14:16:07.844000', 306);

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'cart自增的ID',
  `customer_id` int(0) NOT NULL COMMENT '连接customer表的ID',
  `commodity_id` int(0) NOT NULL COMMENT '连接commodity表的ID',
  `commodity_quantity` int(0) NOT NULL COMMENT '同一商品ID的商品数量',
  `isDelete` int(0) NOT NULL DEFAULT 0 COMMENT '该条记录是否删除',
  `specs` int(0) NULL DEFAULT NULL COMMENT '商品规格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cart_commodity`(`commodity_id`) USING BTREE,
  INDEX `cart_customer`(`customer_id`) USING BTREE,
  CONSTRAINT `cart_commodity` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 260 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '连接customer和commodity的关系表，实质为购物车集合' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 1, 1, 4, 1, 1);
INSERT INTO `cart` VALUES (2, 1, 2, 6, 1, 1);
INSERT INTO `cart` VALUES (3, 1, 3, 6, 1, 1);
INSERT INTO `cart` VALUES (4, 1, 4, 5, 1, 1);
INSERT INTO `cart` VALUES (5, 1, 5, 2, 0, 1);
INSERT INTO `cart` VALUES (6, 1, 6, 2, 0, 1);
INSERT INTO `cart` VALUES (7, 2, 1, 5, 0, 1);
INSERT INTO `cart` VALUES (8, 2, 2, 5, 0, 1);
INSERT INTO `cart` VALUES (9, 2, 3, 5, 0, 1);
INSERT INTO `cart` VALUES (10, 2, 4, 5, 0, 1);
INSERT INTO `cart` VALUES (11, 2, 5, 5, 0, 1);
INSERT INTO `cart` VALUES (12, 3, 1, 5, 0, 1);
INSERT INTO `cart` VALUES (13, 3, 2, 5, 0, 1);
INSERT INTO `cart` VALUES (14, 3, 3, 5, 0, 1);
INSERT INTO `cart` VALUES (15, 3, 4, 5, 0, 1);
INSERT INTO `cart` VALUES (16, 3, 5, 5, 0, 1);
INSERT INTO `cart` VALUES (17, 4, 1, 5, 0, 1);
INSERT INTO `cart` VALUES (18, 4, 2, 5, 0, 1);
INSERT INTO `cart` VALUES (19, 4, 3, 5, 0, 1);
INSERT INTO `cart` VALUES (20, 1, 68, 1, 1, 0);
INSERT INTO `cart` VALUES (21, 1, 12, 1, 0, 0);
INSERT INTO `cart` VALUES (254, 1, 8, 1, 0, 0);
INSERT INTO `cart` VALUES (255, 1, 55, 1, 0, 0);
INSERT INTO `cart` VALUES (256, 1, 57, 1, 0, 0);
INSERT INTO `cart` VALUES (257, 1, 73, 1, 0, 0);
INSERT INTO `cart` VALUES (258, 1, 1, 1, 0, 0);
INSERT INTO `cart` VALUES (259, 1, 11, 3, 0, 0);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品类别名',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品类别描述',
  `level` int(0) NOT NULL COMMENT '目录深度，表示第几层分类',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '手机数码', '', 0, 0);
INSERT INTO `category` VALUES (2, '礼品鲜花', '', 0, 0);
INSERT INTO `category` VALUES (3, '男装女装', '', 0, 0);
INSERT INTO `category` VALUES (4, '母婴用品', '', 0, 0);
INSERT INTO `category` VALUES (5, '手机通讯', '', 1, 0);
INSERT INTO `category` VALUES (6, '电脑', '', 1, 0);
INSERT INTO `category` VALUES (8, '全面屏手机', '/static/temp/cate2.jpg', 5, 0);
INSERT INTO `category` VALUES (9, '游戏手机', '/static/temp/cate3.jpg', 5, 0);
INSERT INTO `category` VALUES (10, '老人机', '/static/temp/cate1.jpg', 5, 0);
INSERT INTO `category` VALUES (11, '学生手机', '/static/temp/cate4.jpg', 5, 0);
INSERT INTO `category` VALUES (12, '女性手机', '/static/temp/cate5.jpg', 5, 0);
INSERT INTO `category` VALUES (14, '笔记本电脑', '/static/temp/cate1.jpg', 6, 0);
INSERT INTO `category` VALUES (15, '平板电脑', '/static/temp/cate4.jpg', 6, 0);
INSERT INTO `category` VALUES (16, '一体机电脑', '/static/temp/cate5.jpg', 6, 0);
INSERT INTO `category` VALUES (17, '礼品', '', 2, 0);
INSERT INTO `category` VALUES (18, '鲜花', '', 2, 0);
INSERT INTO `category` VALUES (19, '工艺摆件', '/static/temp/cate7.jpg', 17, 0);
INSERT INTO `category` VALUES (20, '创意礼品', '/static/temp/cate8.jpg', 17, 0);
INSERT INTO `category` VALUES (21, '鲜花', '/static/temp/cate9.jpg', 18, 0);
INSERT INTO `category` VALUES (22, '每周一花', '/static/temp/cate10.jpg', 18, 0);
INSERT INTO `category` VALUES (23, '卡通花束', '/static/temp/cate11.jpg', 18, 0);
INSERT INTO `category` VALUES (24, '永生花', '/static/temp/cate12.jpg', 18, 0);
INSERT INTO `category` VALUES (25, '男装', '', 3, 0);
INSERT INTO `category` VALUES (26, '女装', '', 3, 0);
INSERT INTO `category` VALUES (27, '男士T恤', '/static/temp/cate13.jpg', 25, 0);
INSERT INTO `category` VALUES (28, '男士外套', '/static/temp/cate14.jpg', 25, 0);
INSERT INTO `category` VALUES (29, '裙装', '/static/temp/cate15.jpg', 26, 0);
INSERT INTO `category` VALUES (30, 'T恤', '/static/temp/cate16.jpg', 26, 0);
INSERT INTO `category` VALUES (31, '上装', '/static/temp/cate15.jpg', 26, 0);
INSERT INTO `category` VALUES (32, '下装', '/static/temp/cate16.jpg', 26, 0);
INSERT INTO `category` VALUES (33, '奶粉', '', 4, 0);
INSERT INTO `category` VALUES (34, '营养辅食', '', 4, 0);
INSERT INTO `category` VALUES (35, '童装', '', 4, 0);
INSERT INTO `category` VALUES (36, '有机奶粉', '/static/temp/cate17.jpg', 33, 0);
INSERT INTO `category` VALUES (37, '果泥/果汁', '/static/temp/cate18.jpg', 34, 0);
INSERT INTO `category` VALUES (39, '喂养用品', '', 4, 0);
INSERT INTO `category` VALUES (42, '婴童衣橱', '/static/temp/cate19.jpg', 35, 0);
INSERT INTO `category` VALUES (43, '吸奶器', '/static/temp/cate21.jpg', 39, 0);
INSERT INTO `category` VALUES (44, '儿童餐具', '/static/temp/cate22.jpg', 39, 0);
INSERT INTO `category` VALUES (45, '牙胶安抚', '/static/temp/cate23.jpg', 39, 0);
INSERT INTO `category` VALUES (46, '围兜', '/static/temp/cate24.jpg', 39, 0);

-- ----------------------------
-- Table structure for category_commodity
-- ----------------------------
DROP TABLE IF EXISTS `category_commodity`;
CREATE TABLE `category_commodity`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` int(0) NOT NULL COMMENT '类别ID',
  `commodity_id` int(0) NOT NULL COMMENT '商品ID',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `categoryid`(`category_id`) USING BTREE,
  INDEX `commodityid`(`commodity_id`) USING BTREE,
  CONSTRAINT `categoryid` FOREIGN KEY (`category_id`) REFERENCES `category` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `commodityid` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category_commodity
-- ----------------------------
INSERT INTO `category_commodity` VALUES (1, 8, 1, 0);
INSERT INTO `category_commodity` VALUES (2, 8, 2, 0);
INSERT INTO `category_commodity` VALUES (3, 8, 3, 0);
INSERT INTO `category_commodity` VALUES (4, 8, 4, 0);
INSERT INTO `category_commodity` VALUES (5, 8, 5, 0);
INSERT INTO `category_commodity` VALUES (6, 8, 6, 0);
INSERT INTO `category_commodity` VALUES (7, 8, 7, 0);
INSERT INTO `category_commodity` VALUES (8, 8, 8, 0);
INSERT INTO `category_commodity` VALUES (9, 8, 9, 0);
INSERT INTO `category_commodity` VALUES (10, 8, 10, 0);
INSERT INTO `category_commodity` VALUES (11, 9, 11, 0);
INSERT INTO `category_commodity` VALUES (12, 9, 12, 0);
INSERT INTO `category_commodity` VALUES (13, 9, 13, 0);
INSERT INTO `category_commodity` VALUES (14, 9, 14, 0);
INSERT INTO `category_commodity` VALUES (15, 9, 15, 0);
INSERT INTO `category_commodity` VALUES (16, 10, 16, 0);
INSERT INTO `category_commodity` VALUES (17, 10, 17, 0);
INSERT INTO `category_commodity` VALUES (18, 10, 18, 0);
INSERT INTO `category_commodity` VALUES (19, 10, 19, 0);
INSERT INTO `category_commodity` VALUES (20, 10, 20, 0);
INSERT INTO `category_commodity` VALUES (21, 10, 21, 0);
INSERT INTO `category_commodity` VALUES (22, 10, 22, 0);
INSERT INTO `category_commodity` VALUES (23, 10, 23, 0);
INSERT INTO `category_commodity` VALUES (24, 10, 24, 0);
INSERT INTO `category_commodity` VALUES (25, 11, 25, 0);
INSERT INTO `category_commodity` VALUES (26, 11, 26, 0);
INSERT INTO `category_commodity` VALUES (27, 11, 27, 0);
INSERT INTO `category_commodity` VALUES (28, 11, 28, 0);
INSERT INTO `category_commodity` VALUES (29, 11, 29, 0);
INSERT INTO `category_commodity` VALUES (30, 11, 30, 0);
INSERT INTO `category_commodity` VALUES (31, 12, 31, 0);
INSERT INTO `category_commodity` VALUES (32, 12, 32, 0);
INSERT INTO `category_commodity` VALUES (33, 12, 33, 0);
INSERT INTO `category_commodity` VALUES (34, 12, 34, 0);
INSERT INTO `category_commodity` VALUES (35, 12, 35, 0);
INSERT INTO `category_commodity` VALUES (36, 12, 36, 0);
INSERT INTO `category_commodity` VALUES (37, 12, 37, 0);
INSERT INTO `category_commodity` VALUES (38, 14, 38, 0);
INSERT INTO `category_commodity` VALUES (39, 14, 39, 0);
INSERT INTO `category_commodity` VALUES (40, 14, 40, 0);
INSERT INTO `category_commodity` VALUES (41, 14, 41, 0);
INSERT INTO `category_commodity` VALUES (42, 14, 42, 0);
INSERT INTO `category_commodity` VALUES (43, 15, 43, 0);
INSERT INTO `category_commodity` VALUES (44, 15, 44, 0);
INSERT INTO `category_commodity` VALUES (45, 15, 45, 0);
INSERT INTO `category_commodity` VALUES (46, 15, 46, 0);
INSERT INTO `category_commodity` VALUES (47, 15, 47, 0);
INSERT INTO `category_commodity` VALUES (48, 15, 48, 0);
INSERT INTO `category_commodity` VALUES (49, 15, 49, 0);
INSERT INTO `category_commodity` VALUES (50, 15, 50, 0);
INSERT INTO `category_commodity` VALUES (51, 16, 51, 0);
INSERT INTO `category_commodity` VALUES (52, 16, 52, 0);
INSERT INTO `category_commodity` VALUES (53, 16, 53, 0);
INSERT INTO `category_commodity` VALUES (54, 16, 54, 0);
INSERT INTO `category_commodity` VALUES (55, 19, 55, 0);
INSERT INTO `category_commodity` VALUES (56, 19, 56, 0);
INSERT INTO `category_commodity` VALUES (57, 20, 57, 0);
INSERT INTO `category_commodity` VALUES (58, 21, 58, 0);
INSERT INTO `category_commodity` VALUES (59, 21, 59, 0);
INSERT INTO `category_commodity` VALUES (60, 21, 60, 0);
INSERT INTO `category_commodity` VALUES (61, 22, 61, 0);
INSERT INTO `category_commodity` VALUES (62, 22, 62, 0);
INSERT INTO `category_commodity` VALUES (63, 23, 63, 0);
INSERT INTO `category_commodity` VALUES (64, 23, 64, 0);
INSERT INTO `category_commodity` VALUES (65, 24, 65, 0);
INSERT INTO `category_commodity` VALUES (66, 24, 66, 0);
INSERT INTO `category_commodity` VALUES (67, 27, 67, 0);
INSERT INTO `category_commodity` VALUES (68, 27, 68, 0);
INSERT INTO `category_commodity` VALUES (69, 27, 69, 0);
INSERT INTO `category_commodity` VALUES (70, 28, 70, 0);
INSERT INTO `category_commodity` VALUES (71, 28, 71, 0);
INSERT INTO `category_commodity` VALUES (72, 29, 72, 0);
INSERT INTO `category_commodity` VALUES (73, 30, 73, 0);
INSERT INTO `category_commodity` VALUES (74, 30, 74, 0);
INSERT INTO `category_commodity` VALUES (75, 31, 75, 0);
INSERT INTO `category_commodity` VALUES (76, 31, 76, 0);
INSERT INTO `category_commodity` VALUES (77, 32, 77, 0);
INSERT INTO `category_commodity` VALUES (78, 32, 78, 0);
INSERT INTO `category_commodity` VALUES (79, 36, 79, 0);
INSERT INTO `category_commodity` VALUES (80, 36, 80, 0);
INSERT INTO `category_commodity` VALUES (81, 37, 81, 0);
INSERT INTO `category_commodity` VALUES (82, 37, 82, 0);
INSERT INTO `category_commodity` VALUES (83, 42, 83, 0);
INSERT INTO `category_commodity` VALUES (84, 42, 84, 0);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论的ID',
  `customer_id` int(0) NOT NULL COMMENT '连接customer表的ID',
  `commodity_id` int(0) NOT NULL COMMENT '连接commodity的ID',
  `comment_level` int(0) NOT NULL COMMENT '商品综合评价等级',
  `comment_time` datetime(0) NOT NULL COMMENT '评论时间',
  `comment_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容，如果为空，前端应显示“用户没有填写评价，系统默认好评”',
  `comment_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评价图片',
  `additional_comment_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '追评内容，可以为空，为空不显示在前端',
  `additional_comment_time` datetime(0) NULL DEFAULT NULL COMMENT '追评时间，如果追评为空，即为空',
  `additional_comment_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '追评图片，如果追评为空，即为空',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `comment_commodity`(`commodity_id`) USING BTREE,
  INDEX `commnet_customer`(`customer_id`) USING BTREE,
  CONSTRAINT `comment_commodity` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commnet_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品评价表，评价ID是唯一的主键，为了节省数据库空间，评论内容可为空，如果为空，前端应显示“用户没有填写评价，系统默认好评”' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, 8, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoU4f.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', '2020-06-22 15:50:36', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (2, 1, 2, 8, '2020-06-21 14:07:36', '收到货，第一时间拆包装，感觉质量还是比较好的，与卖家描述的还是一致的，非常满意，发货速度比较快，物流公司服务态度很好，运送速度很快，总的来说这次是很满意的一次购物，感谢卖家。', 'https://s1.ax1x.com/2020/07/18/Ucow8S.jpg', '收到货，第一时间拆包装，感觉质量还是比较好的，与卖家描述的还是一致的，非常满意，发货速度比较快，物流公司服务态度很好，运送速度很快，总的来说这次是很满意的一次购物，感谢卖家。', '2020-06-22 15:53:06', NULL, 0);
INSERT INTO `comment` VALUES (3, 1, 3, 8, '2020-06-21 14:07:36', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次;看得出来商家很用心。宝贝真心不错，与图片相符，没有任何差异，真的是物超所值。', 'https://s1.ax1x.com/2020/07/18/Uco0gg.jpg', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次;看得出来商家很用心。宝贝真心不错，与图片相符，没有任何差异，真的是物超所值。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (4, 1, 4, 8, '2020-12-31 14:40:31', '我觉得挺好的，买的时候看见评论里都说好就买了，看到发货的时候挺激动的，到了之后，满怀期待一激动得从快递员那里拿回了寝室，试一下，结果挺不错啊！而且客服小姐姐也特别的好，很有礼貌，客服小姐姐也是秒回我的疑问呢，嘻嘻，下次还会回购哒。', 'https://s1.ax1x.com/2020/07/18/UcodC8.jpg', '我觉得挺好的，买的时候看见评论里都说好就买了，看到发货的时候挺激动的，到了之后，满怀期待一激动得从快递员那里拿回了寝室，试一下，结果挺不错啊！而且客服小姐姐也特别的好，很有礼貌，客服小姐姐也是秒回我的疑问呢，嘻嘻，下次还会回购哒。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (5, 1, 5, 8, '2020-06-21 14:07:36', '掌柜的bai服务态度真好，发货很快。商品质量也相du当不错。太喜欢了，zhi谢谢！', 'https://s1.ax1x.com/2020/07/18/UcoNUP.jpg', '掌柜的bai服务态度真好，发货很快。商品质量也相du当不错。太喜欢了，zhi谢谢！', NULL, NULL, 0);
INSERT INTO `comment` VALUES (6, 1, 6, 8, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcosDs.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (7, 1, 7, 8, '2020-06-21 14:07:36', '掌柜太善良了，真是干一行懂一行呀。在掌柜的指导下我都快变内行人士了！', 'https://s1.ax1x.com/2020/07/18/UcoBvQ.jpg', '掌柜太善良了，真是干一行懂一行呀。在掌柜的指导下我都快变内行人士了！', '2020-06-20 15:52:17', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (8, 1, 8, 8, '2020-12-15 18:19:03', '卖家服务真周到。以后带同事一起来。', 'https://s1.ax1x.com/2020/07/18/Ucoruj.jpg', '卖家服务真周到。以后带同事一起来。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (9, 2, 9, 8, '2020-06-22 15:52:47', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcocEq.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', '2020-06-22 15:52:22', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (10, 2, 10, 8, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/Ucoybn.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (11, 2, 11, 8, '2020-06-21 14:07:36', '宝贝质量不错，很喜欢了。谢谢掌柜。', 'https://s1.ax1x.com/2020/07/18/UcogU0.jpg', '宝贝质量不错，很喜欢了。谢谢掌柜。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (12, 2, 12, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoWCT.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (13, 2, 13, 9, '2020-06-21 14:07:36', '真的超级喜欢，非常支bai持，质量非常好，与卖家描述的完全一致，非常满意,真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoIKJ.jpg', '真的超级喜欢，非常支bai持，质量非常好，与卖家描述的完全一致，非常满意,真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (14, 2, 14, 9, '2020-06-21 14:07:36', '终于收到我需要的宝贝了，东西很好，价美物廉，谢谢掌柜的！说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。', 'https://s1.ax1x.com/2020/07/18/Ucoh2F.jpg', '终于收到我需要的宝贝了，东西很好，价美物廉，谢谢掌柜的！说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (15, 2, 15, 9, '2020-06-21 14:07:36', '\"掌柜态度很专业热情，有问必答，回复也很快，我问了不少问题，他都不觉得烦，都会认真回答我，这点我向掌柜表示由衷的敬意，这样的好掌柜可不多。', 'https://s1.ax1x.com/2020/07/18/Uco4v4.jpg', '\"掌柜态度很专业热情，有问必答，回复也很快，我问了不少问题，他都不觉得烦，都会认真回答我，这点我向掌柜表示由衷的敬意，这样的好掌柜可不多。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (16, 2, 16, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcIx7q.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (17, 3, 17, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoSA0.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (18, 3, 18, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoP9U.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (19, 3, 19, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcopNV.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (20, 3, 20, 9, '2020-06-21 14:07:36', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次；看得出来商家很用心。', 'https://s1.ax1x.com/2020/07/18/UcIvBn.jpg', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次；看得出来商家很用心。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (21, 3, 21, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/Uco9hT.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (22, 3, 22, 9, '2020-12-30 14:09:13', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/Ucoi3F.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (23, 3, 23, 9, '2020-12-30 14:15:23', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoFc4.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (24, 3, 24, 9, '2020-12-30 14:28:37', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcokjJ.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (25, 3, 25, 7, '2020-12-30 15:31:17', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoEu9.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (26, 4, 26, 7, '2016-03-31 10:29:09', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoVBR.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (27, 4, 27, 7, '2020-12-15 17:44:44', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/Ucou4K.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (28, 4, 28, 8, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UconN6.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (29, 1, 29, 8, '2020-07-20 12:23:32', '售后态度好 : 真的很快，早上买下午到！', NULL, NULL, NULL, NULL, 0);
INSERT INTO `comment` VALUES (30, 1, 30, 10, '2020-07-21 12:33:10', '售后态度好 : 有些不懂的地方，商家解决很好', NULL, NULL, NULL, NULL, 0);
INSERT INTO `comment` VALUES (31, 3, 31, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoU4f.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', '2020-06-22 15:50:36', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (32, 3, 32, 9, '2020-06-21 14:07:36', '收到货，第一时间拆包装，感觉质量还是比较好的，与卖家描述的还是一致的，非常满意，发货速度比较快，物流公司服务态度很好，运送速度很快，总的来说这次是很满意的一次购物，感谢卖家。', 'https://s1.ax1x.com/2020/07/18/Ucow8S.jpg', '收到货，第一时间拆包装，感觉质量还是比较好的，与卖家描述的还是一致的，非常满意，发货速度比较快，物流公司服务态度很好，运送速度很快，总的来说这次是很满意的一次购物，感谢卖家。', '2020-06-22 15:53:06', NULL, 0);
INSERT INTO `comment` VALUES (33, 3, 33, 9, '2020-06-21 14:07:36', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次;看得出来商家很用心。宝贝真心不错，与图片相符，没有任何差异，真的是物超所值。', 'https://s1.ax1x.com/2020/07/18/Uco0gg.jpg', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次;看得出来商家很用心。宝贝真心不错，与图片相符，没有任何差异，真的是物超所值。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (34, 3, 34, 9, '2020-12-31 14:40:31', '我觉得挺好的，买的时候看见评论里都说好就买了，看到发货的时候挺激动的，到了之后，满怀期待一激动得从快递员那里拿回了寝室，试一下，结果挺不错啊！而且客服小姐姐也特别的好，很有礼貌，客服小姐姐也是秒回我的疑问呢，嘻嘻，下次还会回购哒。', 'https://s1.ax1x.com/2020/07/18/UcodC8.jpg', '我觉得挺好的，买的时候看见评论里都说好就买了，看到发货的时候挺激动的，到了之后，满怀期待一激动得从快递员那里拿回了寝室，试一下，结果挺不错啊！而且客服小姐姐也特别的好，很有礼貌，客服小姐姐也是秒回我的疑问呢，嘻嘻，下次还会回购哒。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (35, 3, 35, 9, '2020-06-21 14:07:36', '掌柜的bai服务态度真好，发货很快。商品质量也相du当不错。太喜欢了，zhi谢谢！', 'https://s1.ax1x.com/2020/07/18/UcoNUP.jpg', '掌柜的bai服务态度真好，发货很快。商品质量也相du当不错。太喜欢了，zhi谢谢！', NULL, NULL, 0);
INSERT INTO `comment` VALUES (36, 3, 36, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcosDs.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (37, 3, 37, 9, '2020-06-21 14:07:36', '掌柜太善良了，真是干一行懂一行呀。在掌柜的指导下我都快变内行人士了！', 'https://s1.ax1x.com/2020/07/18/UcoBvQ.jpg', '掌柜太善良了，真是干一行懂一行呀。在掌柜的指导下我都快变内行人士了！', '2020-06-20 15:52:17', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (38, 4, 38, 9, '2020-12-15 18:19:03', '卖家服务真周到。以后带同事一起来。', 'https://s1.ax1x.com/2020/07/18/Ucoruj.jpg', '卖家服务真周到。以后带同事一起来。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (39, 4, 39, 9, '2020-06-22 15:52:47', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcocEq.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', '2020-06-22 15:52:22', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (40, 4, 40, 7, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/Ucoybn.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (41, 1, 41, 7, '2020-06-21 14:07:36', '宝贝质量不错，很喜欢了。谢谢掌柜。', 'https://s1.ax1x.com/2020/07/18/UcogU0.jpg', '宝贝质量不错，很喜欢了。谢谢掌柜。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (42, 1, 42, 7, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoWCT.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (43, 3, 43, 8, '2020-06-21 14:07:36', '真的超级喜欢，非常支bai持，质量非常好，与卖家描述的完全一致，非常满意,真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoIKJ.jpg', '真的超级喜欢，非常支bai持，质量非常好，与卖家描述的完全一致，非常满意,真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (44, 3, 44, 8, '2020-06-21 14:07:36', '终于收到我需要的宝贝了，东西很好，价美物廉，谢谢掌柜的！说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。', 'https://s1.ax1x.com/2020/07/18/Ucoh2F.jpg', '终于收到我需要的宝贝了，东西很好，价美物廉，谢谢掌柜的！说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (45, 3, 45, 10, '2020-06-21 14:07:36', '\"掌柜态度很专业热情，有问必答，回复也很快，我问了不少问题，他都不觉得烦，都会认真回答我，这点我向掌柜表示由衷的敬意，这样的好掌柜可不多。', 'https://s1.ax1x.com/2020/07/18/Uco4v4.jpg', '\"掌柜态度很专业热情，有问必答，回复也很快，我问了不少问题，他都不觉得烦，都会认真回答我，这点我向掌柜表示由衷的敬意，这样的好掌柜可不多。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (46, 3, 46, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcIx7q.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (47, 3, 47, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoSA0.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (48, 3, 48, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoP9U.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (49, 3, 49, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcopNV.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (50, 4, 50, 9, '2020-06-21 14:07:36', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次；看得出来商家很用心。', 'https://s1.ax1x.com/2020/07/18/UcIvBn.jpg', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次；看得出来商家很用心。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (51, 4, 51, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/Uco9hT.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (52, 4, 52, 9, '2020-12-30 14:09:13', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/Ucoi3F.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (53, 1, 53, 9, '2020-12-30 14:15:23', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoFc4.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (54, 1, 54, 9, '2020-12-30 14:28:37', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcokjJ.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (55, 2, 55, 7, '2020-12-30 15:31:17', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoEu9.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (56, 2, 56, 7, '2016-03-31 10:29:09', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoVBR.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (57, 2, 57, 7, '2020-12-15 17:44:44', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/Ucou4K.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (58, 3, 58, 8, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UconN6.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (59, 3, 59, 8, '2020-07-20 12:23:32', '售后态度好 : 真的很快，早上买下午到！', NULL, NULL, NULL, NULL, 0);
INSERT INTO `comment` VALUES (60, 3, 60, 10, '2020-07-21 12:33:10', '售后态度好 : 有些不懂的地方，商家解决很好', NULL, NULL, NULL, NULL, 0);
INSERT INTO `comment` VALUES (61, 3, 61, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoU4f.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', '2020-06-22 15:50:36', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (62, 2, 62, 9, '2020-06-21 14:07:36', '收到货，第一时间拆包装，感觉质量还是比较好的，与卖家描述的还是一致的，非常满意，发货速度比较快，物流公司服务态度很好，运送速度很快，总的来说这次是很满意的一次购物，感谢卖家。', 'https://s1.ax1x.com/2020/07/18/Ucow8S.jpg', '收到货，第一时间拆包装，感觉质量还是比较好的，与卖家描述的还是一致的，非常满意，发货速度比较快，物流公司服务态度很好，运送速度很快，总的来说这次是很满意的一次购物，感谢卖家。', '2020-06-22 15:53:06', NULL, 0);
INSERT INTO `comment` VALUES (63, 2, 63, 9, '2020-06-21 14:07:36', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次;看得出来商家很用心。宝贝真心不错，与图片相符，没有任何差异，真的是物超所值。', 'https://s1.ax1x.com/2020/07/18/Uco0gg.jpg', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次;看得出来商家很用心。宝贝真心不错，与图片相符，没有任何差异，真的是物超所值。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (64, 2, 64, 9, '2020-12-31 14:40:31', '我觉得挺好的，买的时候看见评论里都说好就买了，看到发货的时候挺激动的，到了之后，满怀期待一激动得从快递员那里拿回了寝室，试一下，结果挺不错啊！而且客服小姐姐也特别的好，很有礼貌，客服小姐姐也是秒回我的疑问呢，嘻嘻，下次还会回购哒。', 'https://s1.ax1x.com/2020/07/18/UcodC8.jpg', '我觉得挺好的，买的时候看见评论里都说好就买了，看到发货的时候挺激动的，到了之后，满怀期待一激动得从快递员那里拿回了寝室，试一下，结果挺不错啊！而且客服小姐姐也特别的好，很有礼貌，客服小姐姐也是秒回我的疑问呢，嘻嘻，下次还会回购哒。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (65, 3, 65, 9, '2020-06-21 14:07:36', '掌柜的bai服务态度真好，发货很快。商品质量也相du当不错。太喜欢了，zhi谢谢！', 'https://s1.ax1x.com/2020/07/18/UcoNUP.jpg', '掌柜的bai服务态度真好，发货很快。商品质量也相du当不错。太喜欢了，zhi谢谢！', NULL, NULL, 0);
INSERT INTO `comment` VALUES (66, 3, 66, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcosDs.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (67, 3, 67, 9, '2020-06-21 14:07:36', '掌柜太善良了，真是干一行懂一行呀。在掌柜的指导下我都快变内行人士了！', 'https://s1.ax1x.com/2020/07/18/UcoBvQ.jpg', '掌柜太善良了，真是干一行懂一行呀。在掌柜的指导下我都快变内行人士了！', '2020-06-20 15:52:17', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (68, 3, 68, 9, '2020-12-15 18:19:03', '卖家服务真周到。以后带同事一起来。', 'https://s1.ax1x.com/2020/07/18/Ucoruj.jpg', '卖家服务真周到。以后带同事一起来。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (69, 4, 69, 9, '2020-06-22 15:52:47', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcocEq.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', '2020-06-22 15:52:22', '<p><img alt=\"\" src=\"https://t9.baidu.com/it/u=1307125826,3433407105&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg\" style=\"width:100%\" /></p>', 0);
INSERT INTO `comment` VALUES (70, 4, 70, 7, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/Ucoybn.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (71, 4, 71, 7, '2020-06-21 14:07:36', '宝贝质量不错，很喜欢了。谢谢掌柜。', 'https://s1.ax1x.com/2020/07/18/UcogU0.jpg', '宝贝质量不错，很喜欢了。谢谢掌柜。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (72, 1, 72, 7, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoWCT.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (73, 1, 73, 8, '2020-06-21 14:07:36', '真的超级喜欢，非常支bai持，质量非常好，与卖家描述的完全一致，非常满意,真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoIKJ.jpg', '真的超级喜欢，非常支bai持，质量非常好，与卖家描述的完全一致，非常满意,真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (74, 3, 74, 8, '2020-06-21 14:07:36', '终于收到我需要的宝贝了，东西很好，价美物廉，谢谢掌柜的！说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。', 'https://s1.ax1x.com/2020/07/18/Ucoh2F.jpg', '终于收到我需要的宝贝了，东西很好，价美物廉，谢谢掌柜的！说实在，这是我淘宝购物来让我最满意的一次购物。无论是掌柜的态度还是对物品，我都非常满意的。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (75, 3, 75, 10, '2020-06-21 14:07:36', '\"掌柜态度很专业热情，有问必答，回复也很快，我问了不少问题，他都不觉得烦，都会认真回答我，这点我向掌柜表示由衷的敬意，这样的好掌柜可不多。', 'https://s1.ax1x.com/2020/07/18/Uco4v4.jpg', '\"掌柜态度很专业热情，有问必答，回复也很快，我问了不少问题，他都不觉得烦，都会认真回答我，这点我向掌柜表示由衷的敬意，这样的好掌柜可不多。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (76, 3, 76, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcIx7q.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (77, 3, 77, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoSA0.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (78, 3, 78, 9, '2020-06-21 14:07:36', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcoP9U.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (79, 3, 79, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcopNV.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (80, 1, 80, 9, '2020-06-21 14:07:36', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次；看得出来商家很用心。', 'https://s1.ax1x.com/2020/07/18/UcIvBn.jpg', '宝贝收到了，卖家发货很快，物流也非常给力,客服服务态度极好，很有耐心、给人一种亲切感，好喜欢。还有包装精美，高端大气上档次；看得出来商家很用心。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (81, 2, 81, 9, '2020-06-21 14:07:36', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/Uco9hT.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (82, 3, 82, 9, '2020-12-30 14:09:13', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/Ucoi3F.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (83, 1, 83, 9, '2020-12-30 14:15:23', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', 'https://s1.ax1x.com/2020/07/18/UcoFc4.jpg', '好卖家，真有耐心，我终于买到想要的东西了。谢谢卖家。', NULL, NULL, 0);
INSERT INTO `comment` VALUES (84, 2, 84, 9, '2020-12-30 14:28:37', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', 'https://s1.ax1x.com/2020/07/18/UcokjJ.jpg', '质量非常好，与卖家描述的完全一致，非常满意，真的很喜欢，完全超出期望值，发货速度非常快，包装非常仔细、严实，物流公司服务态度很好，运送速度很快，很满意的一次购物。', NULL, NULL, 0);

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id自增唯一',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品图片',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品介绍',
  `storage` int(0) NOT NULL COMMENT '商品库存',
  `specification` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品规格',
  `modify_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `status` int(0) NOT NULL COMMENT '商品状态信息',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `index` int(0) NULL DEFAULT 0 COMMENT '首页推广商品分类',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  INDEX `ID_2`(`ID`) USING BTREE,
  INDEX `ID_3`(`ID`) USING BTREE,
  INDEX `ID_4`(`ID`) USING BTREE,
  INDEX `ID_5`(`ID`) USING BTREE,
  INDEX `ID_6`(`ID`) USING BTREE,
  INDEX `ID_7`(`ID`) USING BTREE,
  INDEX `ID_8`(`ID`) USING BTREE,
  INDEX `ID_9`(`ID`) USING BTREE,
  INDEX `ID_10`(`ID`) USING BTREE,
  INDEX `ID_11`(`ID`) USING BTREE,
  INDEX `ID_12`(`ID`) USING BTREE,
  INDEX `ID_13`(`ID`) USING BTREE,
  INDEX `ID_14`(`ID`) USING BTREE,
  INDEX `specification`(`specification`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 316 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, '华为旗下荣耀手机荣耀9X麒麟810芯片4800万超清双摄全面屏智能手机官网旗舰', 1099.98, 'https://s1.ax1x.com/2020/07/18/UcoU4f.jpg', '络模式: 双卡双待单通\nCPU型号: 麒麟810\nCPU型号: 麒麟810', 450, '件', '2020-07-18 16:06:43', 1, 0, 1);
INSERT INTO `commodity` VALUES (2, '红米K30i 双模5G新品手机4800万旗舰拍照学生老年智能机30pro全面屏xiaomi', 1499.99, 'https://s1.ax1x.com/2020/07/18/Ucow8S.jpg', '网络模式: 双卡双待CPU型号: 骁龙765GCPU型号: 高通骁龙765G', 500, '件', '2020-07-18 16:06:44', 0, 0, 0);
INSERT INTO `commodity` VALUES (3, 'vjvj X21S正品学生价水滴全面屏安卓指纹游戏电信全网通智能手机', 748.58, 'https://s1.ax1x.com/2020/07/18/Uco0gg.jpg', '网络类型	4G+全网通\n网络模式	双卡双待\nCPU信息CPU信息\nCPU品牌	联发科\nCPU型号	MTK6763\nCPU核心数	八核', 100, '件', '2020-07-18 16:06:44', 1, 0, 0);
INSERT INTO `commodity` VALUES (4, 'OPPO A11官方正品超清AI四摄大内存长续航全面屏学生老人手机官方旗舰正品a5', 899.99, 'https://s1.ax1x.com/2020/07/18/UcodC8.jpg', '3C规格型号：PCGM00 （电源适配器：VC54JBCH，VC54GBCH，VC54HBCH；输出：5.0VDC...产品名称：OPPO A11OPPO型号: A11', 500, '件', '2020-07-18 16:06:44', 1, 0, 0);
INSERT INTO `commodity` VALUES (5, 'Redmi 10X天玑820双卡5g新品手机4800万拍照游戏全面屏智能学生店红米10x', 1599.89, 'https://s1.ax1x.com/2020/07/18/UcoNUP.jpg', 'C规格型号：M2004J7AC(电源适配器：MDY-11-EM 输出：5.0VDC 3.0A / 9.0VDC ...产品名称：Xiaomi/小米 Redmi 10X型号: REDMI 10X', 499, '件', '2020-07-18 16:06:45', 0, 0, 0);
INSERT INTO `commodity` VALUES (6, 'DOOV/朵唯X11 Pro学生价游戏智能手机水滴全面屏手机', 799.85, 'https://s1.ax1x.com/2020/07/18/UcosDs.jpg', '3C规格型号：DOOV V31c（电源适配器：ES007-U050050XOC 输出:5Vdc,500mA）产品名称：DOOV/朵唯 X11 Pro型号: X11 Pro', 488, '件', '2020-07-19 22:28:39', 1, 0, 6);
INSERT INTO `commodity` VALUES (7, '华为旗下荣耀X10手机5G麒麟820全面屏官方旗舰店新品正品10X学生拍照游戏智能游戏机', 2399.99, 'https://s1.ax1x.com/2020/07/18/UcoBvQ.jpg', '3C规格型号：TEL-TN00（开关电源适配器：HW-100225C00 输出：输出: 5VDC, 2A 或 9V...产品名称：honor/荣耀 荣耀X10型号: 荣耀X10', 477, '件', '2020-07-18 16:06:45', 0, 0, 6);
INSERT INTO `commodity` VALUES (8, 'Samsung/三星Galaxy S10 SM-G9730骁龙855 4G游戏官方全面屏智能手机', 3699.88, 'https://s1.ax1x.com/2020/07/18/Ucoruj.jpg', '3C规格型号：SM-G9730（旅行充电器：EP-TA200 输出： 9.0VDC 1.67A 或 5.0VDC ...产品名称：Samsung/三星 Galaxy S10...三星型号: Galaxy S10 SM-G9730', 588, '件', '2020-07-18 16:06:45', 1, 0, 6);
INSERT INTO `commodity` VALUES (9, '12+256G全网通5G网络新手机P40水滴屏学生价智能游戏', 1599.88, 'https://s1.ax1x.com/2020/07/18/UcocEq.jpg', '摄像头类型: 四摄像头（前一后三）\n电信设备进网许可证编号: 02-C757-180418\n附加功能: CT011007 OTG Touch ID、气压计', 680, '件', '2020-07-18 16:06:46', 1, 0, 0);
INSERT INTO `commodity` VALUES (10, 'Samsung/三星Galaxy Note10+SM-N9760 5G骁龙855防水游戏智能', 5899.00, 'https://s1.ax1x.com/2020/07/18/Ucoybn.jpg', '3C规格型号：SM-N9760（旅行充电器：EP-TA800 输出 :(PD0) 5.0Vdc 3.0A 或9.0...产品名称：Samsung/三星 Galaxy Not...三星型号: Galaxy Note10+ SM-N9760 5G', 680, '件', '2020-07-18 16:06:46', 1, 0, 0);
INSERT INTO `commodity` VALUES (11, '新款朵唯M30八核8+128GB快充大屏水滴屏移动联通电信全网通超长待机4G学生价游戏智能手机正品', 589.88, 'https://s1.ax1x.com/2020/07/18/UcogU0.jpg', '3C规格型号：202018 输入：5VDC 2A (不带电源适配器销售)产品名称：DOOV/朵唯 M30型号: M30', 580, '件', '2020-07-18 16:06:46', 0, 0, 0);
INSERT INTO `commodity` VALUES (12, 'koobee/酷比 G60pro新品原装正品水滴全面屏安卓4G全网通八核智能手机学生价手机', 698.98, 'https://s1.ax1x.com/2020/07/18/UcoWCT.jpg', '3C规格型号：koobee K10（电源适配器：TPA-23A050100CU01 输出：5VDC 1000mA）\n产品名称：koobee/酷比 K10.\n型号: K10.', 578, '件', '2020-07-18 16:06:46', 0, 0, 0);
INSERT INTO `commodity` VALUES (13, 'Xiaomi/小米 腾讯黑鲨游戏手机3PRO现货官网黑鲨4三代红魔5G旗舰', 3359.68, 'https://s1.ax1x.com/2020/07/18/UcoIKJ.jpg', '附加功能	OTG 光线感应 距离感应 重力感应 WIFI上网 手电筒', 587, '件', '2020-07-18 16:06:47', 1, 0, 1);
INSERT INTO `commodity` VALUES (14, 'OPPO Reno Ace骁龙855plus智能游戏手机全面屏65W闪充官方旗舰店renoace3', 2899.58, 'https://s1.ax1x.com/2020/07/18/Ucoh2F.jpg', '运行内存RAM: 8GB 12GB存储容量: 8+128GB 8+256GB 12+256GB网络模式: 双卡多模', 982, '件', '2020-07-18 16:06:47', 1, 0, 0);
INSERT INTO `commodity` VALUES (15, 'OPPO Ace2双模5G全网通骁龙865全面屏闪充游戏智能手机oppoace2', 3689.68, 'https://s1.ax1x.com/2020/07/18/Uco4v4.jpg', '90Hz电竞屏|65W超级闪充|40W无线闪充', 582, '件', '2020-07-18 16:06:47', 0, 0, 0);
INSERT INTO `commodity` VALUES (16, 'nokia诺基亚新款老人机', 198.00, 'https://s1.ax1x.com/2020/07/18/UcIx7q.jpg', '新款老人机老年手机2g)移动联通ta-1010(105)nokia诺基亚，超级耐用，老人的可靠伴侣', 500, '件', '2020-07-18 16:06:48', 1, 0, 0);
INSERT INTO `commodity` VALUES (17, '贝尔丰老人手机', 208.00, 'https://s1.ax1x.com/2020/07/18/UcoSA0.jpg', '贝尔丰老人手机，价格便宜，质量过关', 50, '件', '2020-07-18 16:06:49', 1, 0, 2);
INSERT INTO `commodity` VALUES (18, '联想a589老人手机', 398.00, 'https://s1.ax1x.com/2020/07/18/UcoP9U.jpg', '联想a589老人手机，充电一小时，使用三天', 188, '件', '2020-07-18 16:06:49', 1, 0, 0);
INSERT INTO `commodity` VALUES (19, 'lovme老人机', 198.00, 'https://s1.ax1x.com/2020/07/18/UcopNV.jpg', 'lovme老人机，值得信赖', 250, '件', '2020-07-18 16:06:49', 1, 0, 0);
INSERT INTO `commodity` VALUES (20, '康佳(konka) 老年人手机', 258.00, 'https://s1.ax1x.com/2020/07/18/UcIvBn.jpg', '康佳(konka) u1 移动/联通2g老人手机 双卡双待 老年人手机 学生备用', 258, '件', '2020-07-18 16:06:50', 1, 0, 0);
INSERT INTO `commodity` VALUES (21, '海尔m320 老人手机', 299.00, 'https://s1.ax1x.com/2020/07/18/Uco9hT.jpg', '海尔m320 老人手机 移动联通2g 双卡双待 博雅黑', 166, '件', '2020-07-18 16:06:50', 1, 0, 0);
INSERT INTO `commodity` VALUES (22, '三星f299天翼cdma按键滑盖老人手机', 399.00, 'https://s1.ax1x.com/2020/07/18/Ucoi3F.jpg', '三星f299天翼cdma按键滑盖老人手机电信版老人机超长待机学生手机', 250, '件', '2020-07-18 16:06:50', 1, 0, 0);
INSERT INTO `commodity` VALUES (23, '酷派(coolpad) 酷派手机', 199.00, 'https://s1.ax1x.com/2020/07/18/UcoFc4.jpg', '酷派(coolpad) 酷派 s588 移动/联通手机 双卡双待 老年机 铂光', 400, '件', '2020-07-18 16:06:51', 1, 0, 0);
INSERT INTO `commodity` VALUES (24, '金国威h80000小福星移动老人手机', 259.00, 'https://s1.ax1x.com/2020/07/18/UcokjJ.jpg', '金国威h80000小福星移动老人手机侧键锁', 350, '件', '2020-07-18 16:06:51', 1, 0, 0);
INSERT INTO `commodity` VALUES (25, '三防军工电霸超薄电信老人机', 308.00, 'https://s1.ax1x.com/2020/07/18/UcoEu9.jpg', '三防军工电霸超薄电信老人机', 360, '件', '2020-07-18 16:06:51', 1, 0, 2);
INSERT INTO `commodity` VALUES (26, '纽曼f516 (黑色)电信老人手机', 360.00, 'https://s1.ax1x.com/2020/07/18/UcoVBR.jpg', '纽曼f516 (黑色)电信老人手机电信老人机翻盖老人机老年人手机 大屏大', 800, '件', '2020-07-18 16:06:51', 0, 0, 0);
INSERT INTO `commodity` VALUES (27, '纽曼(newman)老年手机', 158.00, 'https://s1.ax1x.com/2020/07/18/Ucou4K.jpg', '纽曼(newman) c5 天翼电信2g 男 女老年老人手机 学生 儿童机 黑色', 620, '件', '2020-07-18 16:06:51', 0, 0, 0);
INSERT INTO `commodity` VALUES (28, '守护宝l550双卡双待老人手机', 568.00, 'https://s1.ax1x.com/2020/07/18/UconN6.jpg', '守护宝l550 金色 直板按键 超长待机 移动联通2g 双卡双待老人手机', 150, '件', '2020-07-18 16:06:52', 0, 0, 0);
INSERT INTO `commodity` VALUES (29, '长虹 m558m小悍马手机', 188.00, 'https://s1.ax1x.com/2020/07/18/UcoZH1.jpg', 'changhong/长虹 m558m小悍马手机 超长待机', 200, '件', '2020-07-18 16:06:52', 0, 0, 0);
INSERT INTO `commodity` VALUES (30, '路虎三防手机', 588.00, 'https://s1.ax1x.com/2020/07/18/UcomAx.jpg', '路虎三防手机军工户外防水充电宝超长待机王直板老年手机正品', 300, '件', '2020-07-18 16:06:52', 0, 0, 0);
INSERT INTO `commodity` VALUES (31, '美图 MP1801 V7', 3000.00, 'https://i.loli.net/2020/07/18/7xTByPcDmul3np4.jpg', 'Meitu/美图 MP1801 V7 V6 T9美图手机V7美图自拍神器直播美颜神器', 500, '件', '2020-07-18 16:06:53', 0, 0, 0);
INSERT INTO `commodity` VALUES (32, '美图T9', 1129.00, 'https://i.loli.net/2020/07/18/t6wZSnqrLaWoQMi.jpg', ' 【咨询立减80】Meitu/美图 T9美颜自拍全网通美图手机旗舰店官方T8s正品m8 m8s t8 m6s V6 V7', 500, '件', '2020-07-18 16:06:53', 1, 0, 0);
INSERT INTO `commodity` VALUES (33, 'vivo X50 Pro', 4998.00, 'https://i.loli.net/2020/07/18/6c5jUwLBzS38ouP.jpg', ' 【新品首发 享24期免息】vivo X50 Pro+双模5G智能手机官方旗舰店官网正品全新限量版vivox50 x30 s6 pro', 380, '件', '2020-07-18 16:06:53', 0, 0, 0);
INSERT INTO `commodity` VALUES (34, 'vivo NEX 3S 高通骁龙865全网通', 5298.00, 'https://i.loli.net/2020/07/18/aTBY6DecmC1LdXV.jpg', ' 【24期免息】vivo NEX 3S 高通骁龙865全网通游戏5G智能手机官方旗舰店官网正品全新限量版vivonex3', 420, '件', '2020-07-18 16:06:53', 1, 0, 0);
INSERT INTO `commodity` VALUES (35, 'vivo iQOO Z1新品双模', 2198.00, 'https://i.loli.net/2020/07/18/6c5jUwLBzS38ouP.jpg', ' 【12期免息 至高省30】vivo iQOO Z1新品双模5g旗舰游戏144Hz手机官网旗舰店正品vivoiqoo neo3 vivoz5xz6', 380, '件', '2020-07-20 20:56:47', 1, 0, 4);
INSERT INTO `commodity` VALUES (36, 'vivo X30双模5G新品手机', 4698.00, 'https://i.loli.net/2020/07/18/OowZXaI2yUE83Mq.jpg', ' 【立减300元 12期免息】vivo X30双模5G新品手机官方旗舰店官网新款正品学生vivox30限量版x27pro x23 s6 S5', 570, '件', '2020-07-20 20:55:12', 0, 0, 4);
INSERT INTO `commodity` VALUES (37, 'OPPO Find X2 骁龙865双模5G', 4999.00, 'https://i.loli.net/2020/07/18/BJm5y6h7UPb9KfV.jpg', ' 【限时减300 6期免息】OPPO Find X2 骁龙865双模5G旗舰拍照手机120Hz超感屏官方旗舰店正品oppofindx2', 580, '件', '2020-07-20 20:55:41', 0, 0, 4);
INSERT INTO `commodity` VALUES (38, 'Dell/戴尔成就5000十代', 5799.00, 'https://i.loli.net/2020/07/18/iH5lEXItMZhFSwV.jpg', ' 【三边窄边框金属本】Dell/戴尔成就5000十代4核i7独显512G/1TPcleSSD2年服务轻薄便携笔记本电脑Vostro5391', 600, '件', '2020-07-20 20:55:20', 1, 0, 4);
INSERT INTO `commodity` VALUES (39, 'Dell戴尔成就5590笔记本电脑', 6599.00, 'https://i.loli.net/2020/07/18/OowZXaI2yUE83Mq.jpg', ' Dell戴尔成就5590笔记本电脑十代酷睿i7超薄轻薄便携学生商务办公游戏独显设计手提电脑2020款戴尔旗舰店官网', 470, '件', '2020-07-18 16:06:55', 0, 0, 4);
INSERT INTO `commodity` VALUES (40, 'Dell/戴尔 新G3 3500', 6499.00, 'https://i.loli.net/2020/07/18/2cZSwO6dPWAx9K1.jpg', ' 【吃鸡性能】Dell/戴尔 新G3 3500十代酷睿i7/1660ti笔记本电脑游匣G7游戏本吃鸡外星人1868官方旗舰店官网', 900, '件', '2020-07-20 20:55:47', 1, 0, 4);
INSERT INTO `commodity` VALUES (41, 'ALIENWARE外星人全新m15 2020版R3', 14999.00, 'https://i.loli.net/2020/07/18/WesuXYvtP7L5KS9.jpg', ' 【12期免息 现货】ALIENWARE外星人全新m15 2020版R3十代酷睿i7游戏轻薄1660ti笔记本电脑15.6英寸电竞本5725', 980, '件', '2020-07-18 16:06:55', 0, 0, 4);
INSERT INTO `commodity` VALUES (42, 'HP/惠普光影精灵6 十代酷睿暗夜暗影精灵6', 7899.00, 'https://i.loli.net/2020/07/18/7YT3ncL1BXFb8Ay.jpg', ' 【2020新品】HP/惠普光影精灵6 十代酷睿暗夜暗影精灵6电竞游戏本学生吃鸡手提笔记本电脑惠普官方旗舰店官网', 177, '件', '2020-07-18 16:06:55', 1, 0, 0);
INSERT INTO `commodity` VALUES (43, 'Lenovo/联想12寸平板电脑', 1199.00, 'https://i.loli.net/2020/07/18/ht7ZDm3V6AlnoBw.jpg', 'Lenovo/联想12寸平板电脑学习机中小学英语点读机十核王者吃鸡', 567, '件', '2020-07-18 16:06:56', 0, 0, 6);
INSERT INTO `commodity` VALUES (44, '清华同方至尊12寸学习机平板电脑', 3309.00, 'https://i.loli.net/2020/07/18/B7Vvk2cjz9LHQ6d.jpg', '清华同方至尊12寸学习机平板电脑十核中小学英语点读机王者吃鸡', 643, '件', '2020-07-18 16:06:56', 1, 0, 6);
INSERT INTO `commodity` VALUES (45, '10寸/14寸平板电脑新款ipad12寸5G', 4500.00, 'https://i.loli.net/2020/07/18/hDWoSIT4uQfaM71.jpg', '10寸/14寸平板电脑新款ipad12寸5G全网通超薄安卓手机网课学习机', 464, '件', '2020-07-18 16:06:56', 0, 0, 6);
INSERT INTO `commodity` VALUES (46, '华为/HUAWEI MatePad Pro 5G 麒麟990', 3402.00, 'https://i.loli.net/2020/07/18/uYsaTC3Fv2RKBnP.jpg', '华为/HUAWEI MatePad Pro 5G 麒麟990 绚丽全面屏平板电脑智能学习游戏一体机', 567, '件', '2020-07-18 16:06:56', 1, 0, 0);
INSERT INTO `commodity` VALUES (47, '摆渡者 2020新款平板电脑12英寸', 6750.00, 'https://i.loli.net/2020/07/18/ILF1RWEyf3PoUKa.jpg', '摆渡者 2020新款平板电脑12英寸安卓手机二合一5G全网通学习专用学生三星屏小米岛华为ipad pro2019air3 mini', 58, '件', '2020-07-18 16:06:57', 1, 0, 0);
INSERT INTO `commodity` VALUES (48, '智能护眼学习机128G学生电脑12英寸', 3453.00, 'https://i.loli.net/2020/07/18/e5CufSVYyqP6gGm.jpg', '智能护眼学习机128G学生电脑12英寸学生平板儿童小学初高中家教机', 545, '件', '2020-07-18 16:06:57', 1, 0, 2);
INSERT INTO `commodity` VALUES (49, 'Microsoft/微软 Surface Laptop i5 8G 256G', 6700.00, 'https://i.loli.net/2020/07/18/goyAD8TuRcvnhMG.jpg', 'Microsoft/微软 Surface Laptop i5 8G 256G二合一平板book笔记本', 423, '件', '2020-07-18 16:06:57', 0, 0, 0);
INSERT INTO `commodity` VALUES (50, '华为平板电脑Matepad10.4寸2020新款', 4500.00, 'https://i.loli.net/2020/07/18/zgdsR7WVqXu4wU3.jpg', '华为平板电脑Matepad10.4寸2020新款m6学生用全面大屏m7全网通话10寸手机二合一iPad安卓pad爱派pro', 346, '件', '2020-07-18 16:06:57', 1, 0, 2);
INSERT INTO `commodity` VALUES (51, '窄边一体机电脑', 7600.00, 'https://i.loli.net/2020/07/18/Xi8q6WGaOSV34ID.jpg', '窄边一体机电脑IPS屏19-24寸i3i5i7英特办公游戏教学家用整机全套', 56, '件', '2020-07-18 16:06:59', 0, 0, 6);
INSERT INTO `commodity` VALUES (52, '一体机电脑台式27英寸24曲面全套', 2300.00, 'https://i.loli.net/2020/07/18/pQbUDn17seBLF5k.jpg', 'i5 9400F酷睿九代i3 9100F一体机电脑台式27英寸24曲面全套家用办公直播LOL魔兽多开吃鸡游戏型高配触摸主机', 454, '件', '2020-07-18 16:06:59', 1, 0, 6);
INSERT INTO `commodity` VALUES (53, '超薄一体机电脑', 3450.00, 'https://i.loli.net/2020/07/18/5LEOHzfVdigCaux.jpg', '超薄一体机电脑IPS屏游戏型酷睿i3i5i7办公家用独显高配台式整机全套', 35, '件', '2020-07-18 16:07:00', 0, 0, 6);
INSERT INTO `commodity` VALUES (54, '七彩虹曲面一体机电脑家用办公设计', 2350.00, 'https://i.loli.net/2020/07/18/9nJvbWsKyD1jd3O.jpg', '七彩虹/onebot S500曲面一体机电脑家用办公设计23.8英寸i5 9400六核绘图网课学习AIO电脑全套一体式电脑', 45, '件', '2020-07-18 16:07:00', 0, 0, 0);
INSERT INTO `commodity` VALUES (55, '电视柜摆件凤凰轻奢工艺美式家居软装摆设客厅欧式装饰品结婚礼物', 108.58, 'https://s1.ax1x.com/2020/07/18/UcH94P.jpg', '工艺: 半手工货号: CS-218外观造型: 动物', 571, '件', '2020-07-18 16:07:00', 1, 0, 0);
INSERT INTO `commodity` VALUES (56, '创意悬壶流水摆件灯圈倒流香炉风水招财客厅店铺桌面摆设开业礼品', 328.68, 'https://s1.ax1x.com/2020/07/18/UcHpNt.jpg', '品牌: 聚帙功能: 招财材质: 陶瓷', 68, '件', '2020-07-18 16:07:00', 1, 0, 0);
INSERT INTO `commodity` VALUES (57, '七夕情人节礼物送女友女朋友送女生生日特别创意精致高档浪漫爱情', 388.88, 'https://s1.ax1x.com/2020/07/18/Uc7xHA.jpg', '包装方式: 礼盒装货号: ZS-001适用对象: 女朋友', 76, '件', '2020-07-18 16:07:01', 1, 0, 0);
INSERT INTO `commodity` VALUES (58, '鲜花速递同城配送生日玫瑰花束礼盒花店送花北京上海深圳杭州广州', 148.87, 'https://s1.ax1x.com/2020/07/18/UcHSAI.jpg', '品牌: lovetime\n鲜花主花材: 红玫瑰\n鲜花规格(直径X高): 60*20*12', 57, '件', '2020-07-18 16:07:01', 1, 0, 0);
INSERT INTO `commodity` VALUES (59, '生日鲜花速递同城配送鲜花玫瑰花百合花向日葵毕业花束', 108.57, 'https://s1.ax1x.com/2020/07/18/Uc7vBd.jpg', '品牌: 北京爱情故事鲜花鲜花主花材: 混搭花束鲜花规格(直径X高): 大小规格可定制', 147, '件', '2020-07-18 16:07:01', 1, 0, 0);
INSERT INTO `commodity` VALUES (60, '向日葵毕业花束鲜花速递同城朝阳武汉天津上海深圳生日送花店', 201.99, 'https://s1.ax1x.com/2020/07/18/UcHP9f.jpg', '品牌: 花姿上品鲜花主花材: 向日葵鲜花规格(直径X高): 30×45cm鲜花朵数: 6朵', 354, '件', '2020-07-18 16:07:01', 0, 0, 3);
INSERT INTO `commodity` VALUES (61, '梦馨 鲜花 鲜花速递', 58.00, 'https://s1.ax1x.com/2020/07/18/UcHsDH.jpg', '梦馨 鲜花 鲜花速递 鲜花增进距离', 100, '件', '2020-07-18 16:07:02', 0, 0, 3);
INSERT INTO `commodity` VALUES (62, '联洋七夕鲜花速递', 68.00, 'https://s1.ax1x.com/2020/07/18/UcHdC6.jpg', '联洋七夕鲜花速递,提前预订不加价,8月7日全上海可送达!', 200, '件', '2020-07-18 16:07:02', 1, 0, 3);
INSERT INTO `commodity` VALUES (63, '卡通花束-11只泰迪熊小熊花束', 78.00, 'https://s1.ax1x.com/2020/07/18/UcHw8K.jpg', '卡通花束-11只泰迪熊小熊花束', 250, '件', '2020-07-18 16:07:03', 0, 0, 1);
INSERT INTO `commodity` VALUES (64, '叮当猫kt猫哆啦a梦花束', 88.00, 'https://s1.ax1x.com/2020/07/18/UcHBvD.jpg', '叮当猫kt猫哆啦a梦花束', 180, '件', '2020-07-18 16:07:03', 1, 0, 3);
INSERT INTO `commodity` VALUES (65, '玫瑰永生花', 58.00, 'https://s1.ax1x.com/2020/07/18/UcHU4x.jpg', '玫瑰永生花玻璃罩成品定制', 360, '件', '2020-07-18 16:07:03', 0, 0, 3);
INSERT INTO `commodity` VALUES (66, '永生花燕窝礼盒', 69.00, 'https://s1.ax1x.com/2020/07/18/UcH0gO.jpg', '永生花燕窝礼盒图片', 480, '件', '2020-07-18 16:07:03', 1, 0, 3);
INSERT INTO `commodity` VALUES (67, '皮卡丘联名短袖t恤男士', 342.00, 'https://s1.ax1x.com/2020/07/18/UcHIKg.jpg', '皮卡丘联名短袖t恤男士夏季宽松情侣装ins超火潮牌潮流体恤半袖潮', 342, '件', '2020-07-18 16:07:04', 1, 0, 1);
INSERT INTO `commodity` VALUES (68, '薛之谦手绘字母LIFEISPARTY潮流圆领短袖T恤', 45.00, 'https://s1.ax1x.com/2020/07/18/UcHOP0.jpg', 'Dangerouspeople 薛之谦dsp手绘字母LIFEISPARTY潮流圆领短袖T恤', 453, '件', '2020-07-18 16:07:04', 0, 0, 0);
INSERT INTO `commodity` VALUES (69, 'SELECTED思莱德夏季新款纯棉V领黑白色潮流短袖T恤男', 445.00, 'https://s1.ax1x.com/2020/07/18/UcHq5q.jpg', 'SELECTED思莱德夏季新款纯棉V领黑白色潮流短袖T恤男S|420201550', 232, '件', '2020-07-18 16:07:04', 1, 0, 0);
INSERT INTO `commodity` VALUES (70, '牛仔外套男潮流欧美复古水洗夹克', 154.00, 'https://s1.ax1x.com/2020/07/18/UcHTbj.jpg', '2020秋季新品 牛仔外套男 潮流 欧美复古水洗夹克 牛仔衣外套上装', 113, '件', '2020-07-18 16:07:04', 0, 0, 6);
INSERT INTO `commodity` VALUES (71, '冠军贵宾男士外套', 654.00, 'https://s1.ax1x.com/2020/07/18/UcHorQ.jpg', '冠军贵宾男士外套大码2020春秋季韩版潮流帅气男装休闲秋装薄夹克', 432, '件', '2020-07-18 16:07:05', 1, 0, 6);
INSERT INTO `commodity` VALUES (72, '格子连衣裙夏假两件女', 464.00, 'https://s1.ax1x.com/2020/07/18/UcHban.jpg', '格子连衣裙夏假两件女2020新款棉麻短袖法式拼接中长款大码大摆裙', 545, '件', '2020-07-18 16:07:05', 0, 0, 6);
INSERT INTO `commodity` VALUES (73, '唐狮2020新款情侣装夏装', 69.00, 'https://i.loli.net/2020/07/18/K4ltWwS5ZI6mqcu.jpg', '[咱们裸熊联名]唐狮2020新款情侣装夏装短袖T恤男女圆领宽松ins潮', 500, '件', '2020-07-18 16:07:05', 0, 0, 1);
INSERT INTO `commodity` VALUES (74, '夏季短袖t恤男士潮流韩版宽松', 23.00, 'https://i.loli.net/2020/07/18/AfDHRTxCSi1wnJO.jpg', '夏季短袖t恤男士潮流韩版宽松五分袖上衣服男潮牌学生半截袖体恤', 486, '件', '2020-07-18 16:07:05', 1, 0, 0);
INSERT INTO `commodity` VALUES (75, '春夏季薄款男士韩版宽松短袖衬衫', 119.00, 'https://i.loli.net/2020/07/18/3JqpfnmkCRbyaDH.jpg', '春夏季薄款男士韩版宽松短袖衬衫潮流百搭休闲外套帅气七分袖衬衣', 862, '件', '2020-07-18 16:07:05', 0, 0, 0);
INSERT INTO `commodity` VALUES (76, '唐狮情侣防晒衣2020夏新款', 119.00, 'https://i.loli.net/2020/07/18/LF5gDGaRyhIS6oX.jpg', '唐狮情侣防晒衣2020夏新款男女外套连帽薄款防晒服潮流休闲薄外套', 456, '件', '2020-07-18 16:07:06', 1, 0, 0);
INSERT INTO `commodity` VALUES (77, 'TeenieWeenie小熊夏女装甜美中长款裙装', 296.00, 'https://i.loli.net/2020/07/18/sTeEJ9rXn8Nl54K.jpg', 'TeenieWeenie小熊夏女装甜美中长款裙装波点无袖吊带百褶连', 472, '件', '2020-07-18 16:07:06', 1, 0, 0);
INSERT INTO `commodity` VALUES (78, '伊芙丽秋装年新款女裙子', 299.00, 'https://i.loli.net/2020/07/18/rsa8hGezZvS2gCE.jpg', '伊芙丽秋装年新款女裙子高腰气质格子雪纺中长款A字裙连衣裙', 963, '件', '2020-07-18 16:07:06', 1, 0, 0);
INSERT INTO `commodity` VALUES (79, '飞鹤有机奶粉', 308.00, 'https://s1.ax1x.com/2020/07/18/UcHMCV.jpg', '3段智纯婴幼儿臻稚三段700g克罐装12-36个月', 500, '件', '2020-07-18 16:07:07', 1, 0, 5);
INSERT INTO `commodity` VALUES (80, '惠氏启赋有机高端婴幼儿奶粉', 1023.00, 'https://s1.ax1x.com/2020/07/18/UcHGDJ.jpg', '3段1-3岁宝宝900g*3', 954, '件', '2020-07-18 16:07:07', 0, 0, 5);
INSERT INTO `commodity` VALUES (81, 'probiJo骄宝欧洲进口水果泥', 234.00, 'https://s1.ax1x.com/2020/07/18/UcH4xS.jpg', '婴幼儿宝宝辅食泥 吸吸袋果汁泥100g*6', 143, '件', '2020-07-18 16:07:07', 1, 0, 5);
INSERT INTO `commodity` VALUES (82, '虹宝欧洲原装进口梨西梅泥婴儿果泥', 452.00, 'https://s1.ax1x.com/2020/07/18/UcH4xS.jpg', '防便秘膳食纤维宝宝辅食吸吸袋', 140, '件', '2020-07-18 16:07:07', 1, 0, 5);
INSERT INTO `commodity` VALUES (83, '小蓝象hinos儿童睡衣短袖长裤四季款', 123.00, 'https://s1.ax1x.com/2020/07/18/UcbnqH.jpg', ' 宝宝连体内衣婴儿爬爬服', 133, '件', '2020-07-18 16:07:08', 0, 0, 5);
INSERT INTO `commodity` VALUES (84, '新生婴儿儿衣服长袖连体衣睡衣纯棉', 89.00, 'https://s1.ax1x.com/2020/07/18/Ucb3JP.jpg', '纱布宝宝空调服春秋季夏装薄款', 78, '件', '2020-07-18 16:07:08', 1, 0, 5);

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id自增唯一',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '优惠卷名字',
  `discounted_price` decimal(10, 2) NOT NULL COMMENT '优惠卷金额',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '优惠卷类型',
  `cousume_min` decimal(10, 2) NULL DEFAULT NULL COMMENT '满多少可用',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '优惠卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES (1, '限时满减卷', 50.00, '全场通用', 300.00, 0);
INSERT INTO `coupon` VALUES (2, '限时满减卷', 15.00, '全场通用', 99.00, 0);
INSERT INTO `coupon` VALUES (3, '新用户优惠卷', 10.00, '全场通用', 20.00, 0);
INSERT INTO `coupon` VALUES (4, '纸巾兑换卷', 0.00, '仅限兑换纸巾', 0.00, 0);
INSERT INTO `coupon` VALUES (5, '充值优惠卷', 2.00, '仅限话费充值', 90.00, 0);
INSERT INTO `coupon` VALUES (6, '美妆满减卷', 20.00, '仅可购买美妆部分商品', 99.00, 0);
INSERT INTO `coupon` VALUES (7, '数码优惠卷', 1000.00, '金科购买电脑及数码部分商品', 4999.00, 0);
INSERT INTO `coupon` VALUES (8, '空调优惠卷', 300.00, '仅可购买部分空调商品', 999.00, 0);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id自增唯一',
  `name` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '顾客姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客电话',
  `age` int(0) NULL DEFAULT NULL COMMENT '顾客年龄',
  `sex` int(0) NULL DEFAULT NULL COMMENT '顾客性别',
  `pwd` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录密码',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '顾客昵称',
  `user_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '顾客头像',
  `birthday` date NULL DEFAULT NULL COMMENT '顾客生日',
  `login_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录用户名',
  `certification_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `is_delete` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除标记',
  `register_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  INDEX `ID_2`(`ID`) USING BTREE,
  INDEX `ID_3`(`ID`) USING BTREE,
  INDEX `ID_4`(`ID`) USING BTREE,
  INDEX `ID_5`(`ID`) USING BTREE,
  INDEX `ID_6`(`ID`) USING BTREE,
  INDEX `ID_7`(`ID`) USING BTREE,
  INDEX `ID_8`(`ID`) USING BTREE,
  INDEX `ID_9`(`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '辛毅', '18624065210', 20, 1, 'xinyipwd', 'XinYibaobao', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595088688219&di=8b2816726f0436f92edf12ba33fb38fc&imgtype=0&src=http%3A%2F%2Fp2.so.qhimgs1.com%2Ft01dfcbc38578dac4c2.jpg', '1999-09-19', 'xinyi', '321102199902264916', 0, '2020-07-18 21:24:36', 'xiny0919@163.com');
INSERT INTO `customer` VALUES (2, '鞠桥丹', '18624065255', 21, 0, 'juqiaodan', '用户sdsads', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1732264759,4009793510&fm=26&gp=0.jpg', '1999-09-20', 'juqiaodan', NULL, 0, '2020-07-18 19:59:15', NULL);
INSERT INTO `customer` VALUES (3, '曾德歆', '18611112222', 20, 0, 'zengdexin', '用户asdsad', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2803690759,2446328855&fm=26&gp=0.jpg', '1999-09-21', 'zengdexin', NULL, 0, '2020-07-18 19:59:32', NULL);
INSERT INTO `customer` VALUES (4, '金卓然', '17654268562', 22, 0, 'jinzhuoran', '用户asddgfhgfh', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3496844071,1524827572&fm=26&gp=0.jpg', '1999-09-22', 'jinzhuoran', NULL, 0, '2020-07-18 19:59:43', NULL);
INSERT INTO `customer` VALUES (5, '易忱', '17654255663', 21, 0, 'yichen', '用户uitcvbcvn', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3346392905,3474712278&fm=26&gp=0.jpg', '1999-09-23', 'yichen', NULL, 0, '2020-07-18 19:59:54', NULL);
INSERT INTO `customer` VALUES (6, '杨佳玉', '18611121342', 20, 1, 'yangjiayu', '用户bvnsfsd', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1091405991,859863778&fm=26&gp=0.jpg', '1999-09-24', 'yangjiayu', NULL, 0, '2020-07-18 19:59:58', NULL);
INSERT INTO `customer` VALUES (7, NULL, '18540171008', NULL, NULL, 'taiyanggege', '阿丹宝宝', NULL, NULL, 'adandan', NULL, 0, '2020-07-20 22:43:26', NULL);

-- ----------------------------
-- Table structure for customer_address
-- ----------------------------
DROP TABLE IF EXISTS `customer_address`;
CREATE TABLE `customer_address`  (
  `address_id` int(0) NOT NULL COMMENT 'address表内ID',
  `customer_id` int(0) NOT NULL COMMENT 'customer表内ID',
  `status` int(0) NOT NULL COMMENT '地址状态 是否为默认地址',
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `customer_address_ibfk_1`(`address_id`) USING BTREE,
  INDEX `customer_address_ibfk_2`(`customer_id`) USING BTREE,
  CONSTRAINT `customer_address_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `customer_address_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客收货地址关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_address
-- ----------------------------
INSERT INTO `customer_address` VALUES (1, 1, 1, 1, 0);
INSERT INTO `customer_address` VALUES (2, 1, 1, 2, 0);
INSERT INTO `customer_address` VALUES (3, 1, 1, 3, 0);
INSERT INTO `customer_address` VALUES (4, 1, 1, 4, 0);
INSERT INTO `customer_address` VALUES (5, 1, 0, 5, 0);
INSERT INTO `customer_address` VALUES (6, 1, 1, 6, 0);
INSERT INTO `customer_address` VALUES (7, 1, 1, 7, 0);
INSERT INTO `customer_address` VALUES (8, 1, 1, 8, 0);
INSERT INTO `customer_address` VALUES (9, 2, 1, 9, 0);
INSERT INTO `customer_address` VALUES (10, 2, 0, 10, 0);
INSERT INTO `customer_address` VALUES (11, 2, 1, 11, 0);
INSERT INTO `customer_address` VALUES (12, 2, 1, 12, 0);
INSERT INTO `customer_address` VALUES (13, 2, 1, 13, 0);
INSERT INTO `customer_address` VALUES (14, 2, 1, 14, 0);
INSERT INTO `customer_address` VALUES (15, 2, 1, 15, 0);
INSERT INTO `customer_address` VALUES (16, 2, 1, 16, 0);
INSERT INTO `customer_address` VALUES (17, 3, 1, 17, 0);
INSERT INTO `customer_address` VALUES (18, 3, 1, 18, 0);
INSERT INTO `customer_address` VALUES (19, 3, 1, 19, 0);
INSERT INTO `customer_address` VALUES (20, 3, 0, 20, 0);
INSERT INTO `customer_address` VALUES (41, 1, 1, 23, 0);
INSERT INTO `customer_address` VALUES (42, 4, 0, 24, 0);

-- ----------------------------
-- Table structure for customer_order
-- ----------------------------
DROP TABLE IF EXISTS `customer_order`;
CREATE TABLE `customer_order`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_id` int(0) NOT NULL COMMENT 'customer表内顾客ID',
  `order_id` int(0) NOT NULL COMMENT 'order表内订单ID',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `customer_order_ibfk_1`(`customer_id`) USING BTREE,
  INDEX `customer_order_ibfk_2`(`order_id`) USING BTREE,
  CONSTRAINT `customer_order_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `customer_order_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客订单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_order
-- ----------------------------
INSERT INTO `customer_order` VALUES (1, 1, 20, 0);
INSERT INTO `customer_order` VALUES (2, 17, 13, 0);
INSERT INTO `customer_order` VALUES (3, 2, 17, 0);
INSERT INTO `customer_order` VALUES (4, 3, 1, 0);
INSERT INTO `customer_order` VALUES (5, 8, 19, 0);
INSERT INTO `customer_order` VALUES (6, 6, 5, 0);
INSERT INTO `customer_order` VALUES (7, 16, 18, 0);
INSERT INTO `customer_order` VALUES (8, 4, 9, 0);
INSERT INTO `customer_order` VALUES (9, 5, 12, 0);
INSERT INTO `customer_order` VALUES (10, 18, 10, 0);
INSERT INTO `customer_order` VALUES (11, 7, 11, 0);
INSERT INTO `customer_order` VALUES (12, 19, 6, 0);
INSERT INTO `customer_order` VALUES (13, 15, 15, 0);
INSERT INTO `customer_order` VALUES (14, 20, 4, 0);
INSERT INTO `customer_order` VALUES (15, 15, 14, 0);
INSERT INTO `customer_order` VALUES (16, 13, 8, 0);
INSERT INTO `customer_order` VALUES (17, 12, 16, 0);
INSERT INTO `customer_order` VALUES (18, 9, 3, 0);
INSERT INTO `customer_order` VALUES (19, 11, 2, 0);
INSERT INTO `customer_order` VALUES (20, 14, 7, 0);
INSERT INTO `customer_order` VALUES (21, 10, 12, 0);
INSERT INTO `customer_order` VALUES (22, 1, 24, 0);
INSERT INTO `customer_order` VALUES (23, 22, 26, 0);
INSERT INTO `customer_order` VALUES (24, 1, 27, 0);
INSERT INTO `customer_order` VALUES (25, 1, 29, 0);
INSERT INTO `customer_order` VALUES (26, 1, 31, 0);
INSERT INTO `customer_order` VALUES (27, 1, 32, 0);
INSERT INTO `customer_order` VALUES (28, 1, 33, 0);
INSERT INTO `customer_order` VALUES (29, 1, 34, 0);
INSERT INTO `customer_order` VALUES (30, 1, 35, 0);
INSERT INTO `customer_order` VALUES (31, 1, 36, 0);
INSERT INTO `customer_order` VALUES (32, 1, 37, 0);
INSERT INTO `customer_order` VALUES (33, 1, 38, 0);
INSERT INTO `customer_order` VALUES (34, 1, 39, 0);
INSERT INTO `customer_order` VALUES (35, 1, 40, 0);
INSERT INTO `customer_order` VALUES (36, 1, 41, 0);
INSERT INTO `customer_order` VALUES (37, 1, 42, 0);
INSERT INTO `customer_order` VALUES (38, 1, 43, 0);
INSERT INTO `customer_order` VALUES (39, 1, 44, 0);
INSERT INTO `customer_order` VALUES (40, 1, 45, 0);
INSERT INTO `customer_order` VALUES (41, 1, 46, 0);
INSERT INTO `customer_order` VALUES (42, 1, 47, 0);
INSERT INTO `customer_order` VALUES (43, 1, 48, 0);
INSERT INTO `customer_order` VALUES (44, 1, 49, 0);
INSERT INTO `customer_order` VALUES (45, 1, 50, 0);
INSERT INTO `customer_order` VALUES (46, 1, 51, 0);
INSERT INTO `customer_order` VALUES (47, 1, 52, 0);
INSERT INTO `customer_order` VALUES (48, 1, 53, 0);
INSERT INTO `customer_order` VALUES (49, 1, 54, 0);
INSERT INTO `customer_order` VALUES (50, 1, 55, 0);
INSERT INTO `customer_order` VALUES (51, 1, 56, 0);
INSERT INTO `customer_order` VALUES (52, 1, 57, 0);
INSERT INTO `customer_order` VALUES (53, 1, 58, 0);
INSERT INTO `customer_order` VALUES (54, 1, 59, 0);
INSERT INTO `customer_order` VALUES (55, 1, 60, 0);
INSERT INTO `customer_order` VALUES (56, 1, 61, 0);
INSERT INTO `customer_order` VALUES (57, 1, 62, 0);
INSERT INTO `customer_order` VALUES (58, 1, 63, 0);
INSERT INTO `customer_order` VALUES (59, 1, 64, 0);
INSERT INTO `customer_order` VALUES (60, 1, 65, 0);
INSERT INTO `customer_order` VALUES (61, 4, 66, 0);
INSERT INTO `customer_order` VALUES (62, 1, 67, 0);

-- ----------------------------
-- Table structure for customer_settings
-- ----------------------------
DROP TABLE IF EXISTS `customer_settings`;
CREATE TABLE `customer_settings`  (
  `customer_id` int(0) NOT NULL COMMENT '顾客id',
  `settings_id` int(0) NOT NULL COMMENT '系统设置id\r\n',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  INDEX `customer_id`(`customer_id`) USING BTREE,
  INDEX `settings_id`(`settings_id`) USING BTREE,
  CONSTRAINT `customer_settings_ibfk_2` FOREIGN KEY (`settings_id`) REFERENCES `settings` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `customer_settings_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客_系统设置对照表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_settings
-- ----------------------------
INSERT INTO `customer_settings` VALUES (1, 1, 0);
INSERT INTO `customer_settings` VALUES (2, 1, 0);
INSERT INTO `customer_settings` VALUES (3, 2, 0);
INSERT INTO `customer_settings` VALUES (4, 3, 0);
INSERT INTO `customer_settings` VALUES (5, 4, 0);
INSERT INTO `customer_settings` VALUES (6, 4, 0);
INSERT INTO `customer_settings` VALUES (7, 3, 0);
INSERT INTO `customer_settings` VALUES (8, 2, 0);
INSERT INTO `customer_settings` VALUES (9, 5, 0);
INSERT INTO `customer_settings` VALUES (10, 7, 0);
INSERT INTO `customer_settings` VALUES (11, 1, 0);
INSERT INTO `customer_settings` VALUES (12, 1, 0);
INSERT INTO `customer_settings` VALUES (13, 2, 0);
INSERT INTO `customer_settings` VALUES (14, 3, 0);
INSERT INTO `customer_settings` VALUES (15, 4, 0);
INSERT INTO `customer_settings` VALUES (16, 4, 0);
INSERT INTO `customer_settings` VALUES (17, 3, 0);
INSERT INTO `customer_settings` VALUES (18, 2, 0);
INSERT INTO `customer_settings` VALUES (19, 5, 0);
INSERT INTO `customer_settings` VALUES (20, 7, 0);

-- ----------------------------
-- Table structure for cutomer_coupon
-- ----------------------------
DROP TABLE IF EXISTS `cutomer_coupon`;
CREATE TABLE `cutomer_coupon`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id自增唯一',
  `customer_id` int(0) NOT NULL COMMENT '顾客id',
  `coupon_id` int(0) NOT NULL COMMENT '优惠卷id',
  `expire_date` datetime(0) NOT NULL COMMENT '优惠卷到期时间',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customer_id`(`customer_id`) USING BTREE,
  INDEX `coupin_id`(`coupon_id`) USING BTREE,
  CONSTRAINT `cutomer_coupon_ibfk_2` FOREIGN KEY (`coupon_id`) REFERENCES `coupon` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cutomer_coupon_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客_优惠卷对照表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cutomer_coupon
-- ----------------------------
INSERT INTO `cutomer_coupon` VALUES (1, 1, 1, '2020-07-15 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (2, 1, 2, '2020-07-15 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (3, 1, 3, '2020-07-15 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (4, 2, 4, '2020-07-15 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (5, 2, 5, '2020-07-15 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (6, 2, 6, '2020-07-16 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (7, 3, 3, '2020-07-17 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (8, 3, 2, '2020-07-18 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (9, 4, 4, '2020-07-19 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (10, 4, 2, '2020-07-20 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (11, 5, 1, '2020-07-21 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (12, 5, 4, '2020-07-21 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (13, 6, 4, '2020-07-21 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (14, 7, 6, '2020-07-22 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (15, 8, 7, '2020-07-23 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (16, 9, 8, '2020-07-24 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (17, 10, 1, '2020-07-25 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (18, 11, 2, '2020-07-26 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (19, 12, 4, '2020-07-27 00:00:00', 0);
INSERT INTO `cutomer_coupon` VALUES (20, 13, 4, '2020-07-28 00:00:00', 0);

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites`  (
  `commodity_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '杩炴帴commodity鐨処D',
  `customer_id` int(0) NOT NULL COMMENT '连接customer表的ID',
  `addtime` datetime(0) NOT NULL COMMENT '收藏时间',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  INDEX `favorite_commodity`(`commodity_id`) USING BTREE,
  INDEX `favorite_customer`(`customer_id`) USING BTREE,
  CONSTRAINT `favorite_commodity` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favorite_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品收藏（关系表）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorites
-- ----------------------------
INSERT INTO `favorites` VALUES (12, 1, '2020-06-08 10:25:05', 0);
INSERT INTO `favorites` VALUES (13, 1, '2020-06-08 10:25:05', 0);
INSERT INTO `favorites` VALUES (14, 4, '2020-06-08 10:25:05', 0);
INSERT INTO `favorites` VALUES (15, 5, '2020-06-08 10:25:05', 0);
INSERT INTO `favorites` VALUES (16, 6, '2020-06-08 10:25:05', 0);
INSERT INTO `favorites` VALUES (17, 6, '2020-06-08 10:25:05', 0);
INSERT INTO `favorites` VALUES (18, 4, '2020-06-21 14:06:52', 0);
INSERT INTO `favorites` VALUES (19, 4, '2020-06-21 14:06:53', 0);
INSERT INTO `favorites` VALUES (20, 1, '2020-06-21 14:06:55', 0);
INSERT INTO `favorites` VALUES (31, 2, '2020-06-21 14:06:57', 0);
INSERT INTO `favorites` VALUES (32, 3, '2020-06-21 14:06:58', 0);
INSERT INTO `favorites` VALUES (33, 1, '2020-06-21 14:07:01', 0);
INSERT INTO `favorites` VALUES (34, 1, '2020-06-21 14:07:02', 0);
INSERT INTO `favorites` VALUES (35, 5, '2020-06-21 14:07:04', 0);
INSERT INTO `favorites` VALUES (36, 2, '2020-06-21 14:07:05', 0);
INSERT INTO `favorites` VALUES (37, 4, '2020-06-21 14:07:06', 0);
INSERT INTO `favorites` VALUES (38, 3, '2020-06-21 14:07:10', 0);
INSERT INTO `favorites` VALUES (39, 6, '2020-06-21 14:07:08', 0);
INSERT INTO `favorites` VALUES (41, 1, '2020-06-21 14:07:11', 0);
INSERT INTO `favorites` VALUES (42, 2, '2020-06-21 14:07:25', 0);
INSERT INTO `favorites` VALUES (43, 3, '2020-06-21 14:07:26', 0);
INSERT INTO `favorites` VALUES (44, 4, '2020-06-21 14:07:28', 0);
INSERT INTO `favorites` VALUES (45, 5, '2020-06-21 14:07:29', 0);
INSERT INTO `favorites` VALUES (46, 6, '2020-06-21 14:07:11', 0);
INSERT INTO `favorites` VALUES (11, 2, '2020-06-08 10:25:05', 0);
INSERT INTO `favorites` VALUES (1, 2, '2020-07-14 04:00:41', 0);
INSERT INTO `favorites` VALUES (11, 1, '2020-07-23 13:01:48', 0);
INSERT INTO `favorites` VALUES (14, 1, '2020-07-23 13:02:22', 0);
INSERT INTO `favorites` VALUES (1, 1, '2020-07-23 13:47:06', 0);

-- ----------------------------
-- Table structure for graphic_commodity
-- ----------------------------
DROP TABLE IF EXISTS `graphic_commodity`;
CREATE TABLE `graphic_commodity`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `image1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片1',
  `image2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片2',
  `image3` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片3',
  `image4` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片4',
  `image5` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片5',
  `image6` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片6',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of graphic_commodity
-- ----------------------------
INSERT INTO `graphic_commodity` VALUES (1, 1, 'https://s1.ax1x.com/2020/07/18/UcoU4f.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01eRQChy1WoTRp24Jwy_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN014o0QwL1WoTSJ4rLMo_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01mMYZPS1WoTSHRX5gz_!!2201702082835.jpg', NULL, NULL, '络模式: 双卡双待单通\nCPU型号: 麒麟810\nCPU型号: 麒麟810');
INSERT INTO `graphic_commodity` VALUES (2, 2, 'https://s1.ax1x.com/2020/07/18/Ucow8S.jpg', 'https://img.alicdn.com/imgextra/i1/2201702082835/O1CN01muS14T1WoTSM8WQ1a_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN014o0QwL1WoTSJ4rLMo_!!2201702082835.jpg', NULL, NULL, NULL, '网络模式: 双卡双待CPU型号: 骁龙765GCPU型号: 高通骁龙765G');
INSERT INTO `graphic_commodity` VALUES (3, 3, 'https://s1.ax1x.com/2020/07/18/Uco0gg.jpg', 'https://img.alicdn.com/imgextra/i1/2201702082835/O1CN01muS14T1WoTSM8WQ1a_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', NULL, NULL, NULL, '网络类型	4G+全网通\n网络模式	双卡双待\nCPU信息CPU信息\nCPU品牌	联发科\nCPU型号	MTK6763\nCPU核心数	八核');
INSERT INTO `graphic_commodity` VALUES (4, 4, 'https://s1.ax1x.com/2020/07/18/UcodC8.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01Xxkx7v1WoTSM8Xxc5_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN014o0QwL1WoTSJ4rLMo_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01mMYZPS1WoTSHRX5gz_!!2201702082835.jpg', NULL, NULL, '3C规格型号：PCGM00 （电源适配器：VC54JBCH，VC54GBCH，VC54HBCH；输出：5.0VDC...产品名称：OPPO A11OPPO型号: A11');
INSERT INTO `graphic_commodity` VALUES (5, 5, 'https://s1.ax1x.com/2020/07/18/UcoNUP.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01eRQChy1WoTRp24Jwy_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN01wETJKg1Uzo0h4uEh3_!!2215302589.jpg', NULL, NULL, NULL, 'C规格型号：M2004J7AC(电源适配器：MDY-11-EM 输出：5.0VDC 3.0A / 9.0VDC ...产品名称：Xiaomi/小米 Redmi 10X型号: REDMI 10X');
INSERT INTO `graphic_commodity` VALUES (6, 6, 'https://s1.ax1x.com/2020/07/18/UcosDs.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01Xxkx7v1WoTSM8Xxc5_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2201702082835/O1CN01ZnokNs1WoTSFQoLcv_!!2201702082835.jpg', NULL, NULL, NULL, '3C规格型号：DOOV V31c（电源适配器：ES007-U050050XOC 输出:5Vdc,500mA）产品名称：DOOV/朵唯 X11 Pro型号: X11 Pro');
INSERT INTO `graphic_commodity` VALUES (7, 7, 'https://s1.ax1x.com/2020/07/18/UcoBvQ.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01eRQChy1WoTRp24Jwy_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2201702082835/O1CN01ZnokNs1WoTSFQoLcv_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01mMYZPS1WoTSHRX5gz_!!2201702082835.jpg', NULL, NULL, '3C规格型号：TEL-TN00（开关电源适配器：HW-100225C00 输出：输出: 5VDC, 2A 或 9V...产品名称：honor/荣耀 荣耀X10型号: 荣耀X10');
INSERT INTO `graphic_commodity` VALUES (8, 8, 'https://s1.ax1x.com/2020/07/18/Ucoruj.jpg', 'https://img.alicdn.com/imgextra/i1/2201702082835/O1CN01muS14T1WoTSM8WQ1a_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', NULL, NULL, NULL, '3C规格型号：SM-G9730（旅行充电器：EP-TA200 输出： 9.0VDC 1.67A 或 5.0VDC ...产品名称：Samsung/三星 Galaxy S10...三星型号: Galaxy S10 SM-G9730');
INSERT INTO `graphic_commodity` VALUES (9, 9, 'https://s1.ax1x.com/2020/07/18/UcocEq.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN014o0QwL1WoTSJ4rLMo_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN01wETJKg1Uzo0h4uEh3_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, '摄像头类型: 四摄像头（前一后三）\n电信设备进网许可证编号: 02-C757-180418\n附加功能: CT011007 OTG Touch ID、气压计');
INSERT INTO `graphic_commodity` VALUES (10, 10, 'https://s1.ax1x.com/2020/07/18/Ucoybn.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01XqxIRl1WoTSJd26p4_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, NULL, '3C规格型号：SM-N9760（旅行充电器：EP-TA800 输出 :(PD0) 5.0Vdc 3.0A 或9.0...产品名称：Samsung/三星 Galaxy Not...三星型号: Galaxy Note10+ SM-N9760 5G');
INSERT INTO `graphic_commodity` VALUES (11, 11, 'https://s1.ax1x.com/2020/07/18/UcogU0.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', NULL, NULL, NULL, '3C规格型号：202018 输入：5VDC 2A (不带电源适配器销售)产品名称：DOOV/朵唯 M30型号: M30');
INSERT INTO `graphic_commodity` VALUES (12, 12, 'https://s1.ax1x.com/2020/07/18/UcoWCT.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2201702082835/O1CN01ZnokNs1WoTSFQoLcv_!!2201702082835.jpg', NULL, NULL, NULL, '3C规格型号：koobee K10（电源适配器：TPA-23A050100CU01 输出：5VDC 1000mA）\n产品名称：koobee/酷比 K10.\n型号: K10.');
INSERT INTO `graphic_commodity` VALUES (13, 13, 'https://s1.ax1x.com/2020/07/18/UcoIKJ.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN01wETJKg1Uzo0h4uEh3_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i2/2215302589/O1CN01SeUlhf1Uzo0h4uddV_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, '附加功能	OTG 光线感应 距离感应 重力感应 WIFI上网 手电筒');
INSERT INTO `graphic_commodity` VALUES (14, 14, 'https://s1.ax1x.com/2020/07/18/Ucoh2F.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN01wETJKg1Uzo0h4uEh3_!!2215302589.jpg', NULL, NULL, NULL, '运行内存RAM: 8GB 12GB存储容量: 8+128GB 8+256GB 12+256GB网络模式: 双卡多模');
INSERT INTO `graphic_commodity` VALUES (15, 15, 'https://s1.ax1x.com/2020/07/18/Uco4v4.jpg', 'https://img.alicdn.com/imgextra/i3/2201702082835/O1CN01ZnokNs1WoTSFQoLcv_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01XqxIRl1WoTSJd26p4_!!2201702082835.jpg', NULL, NULL, NULL, '90Hz电竞屏|65W超级闪充|40W无线闪充');
INSERT INTO `graphic_commodity` VALUES (16, 16, 'https://s1.ax1x.com/2020/07/18/UcIx7q.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01XqxIRl1WoTSJd26p4_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, '新款老人机老年手机2g)移动联通ta-1010(105)nokia诺基亚，超级耐用，老人的可靠伴侣');
INSERT INTO `graphic_commodity` VALUES (17, 17, 'https://s1.ax1x.com/2020/07/18/UcoSA0.jpg', 'https://img.alicdn.com/imgextra/i2/2215302589/O1CN01SeUlhf1Uzo0h4uddV_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i4/2215302589/O1CN01t7JgbL1Uzo0aStYP8_!!2215302589.jpg', NULL, NULL, NULL, '贝尔丰老人手机，价格便宜，质量过关');
INSERT INTO `graphic_commodity` VALUES (18, 18, 'https://s1.ax1x.com/2020/07/18/UcoP9U.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', NULL, NULL, NULL, NULL, '联想a589老人手机，充电一小时，使用三天');
INSERT INTO `graphic_commodity` VALUES (19, 19, 'https://s1.ax1x.com/2020/07/18/UcopNV.jpg', 'https://img.alicdn.com/imgextra/i3/2201702082835/O1CN01ZnokNs1WoTSFQoLcv_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i4/2215302589/O1CN01t7JgbL1Uzo0aStYP8_!!2215302589.jpg', NULL, NULL, NULL, 'lovme老人机，值得信赖');
INSERT INTO `graphic_commodity` VALUES (20, 20, 'https://s1.ax1x.com/2020/07/18/UcIvBn.jpg', 'https://img.alicdn.com/imgextra/i2/2215302589/O1CN01SeUlhf1Uzo0h4uddV_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, NULL, '康佳(konka) u1 移动/联通2g老人手机 双卡双待 老年人手机 学生备用');
INSERT INTO `graphic_commodity` VALUES (21, 21, 'https://s1.ax1x.com/2020/07/18/Uco9hT.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2201702082835/O1CN01ZnokNs1WoTSFQoLcv_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i1/3173963343/O1CN01bedMs41aZ8esg2Nfj_!!3173963343.jpg', NULL, NULL, '海尔m320 老人手机 移动联通2g 双卡双待 博雅黑');
INSERT INTO `graphic_commodity` VALUES (22, 22, 'https://s1.ax1x.com/2020/07/18/Ucoi3F.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, NULL, NULL, '三星f299天翼cdma按键滑盖老人手机电信版老人机超长待机学生手机');
INSERT INTO `graphic_commodity` VALUES (23, 23, 'https://s1.ax1x.com/2020/07/18/UcoFc4.jpg', 'https://img.alicdn.com/imgextra/i4/2215302589/O1CN01t7JgbL1Uzo0aStYP8_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, NULL, '酷派(coolpad) 酷派 s588 移动/联通手机 双卡双待 老年机 铂光');
INSERT INTO `graphic_commodity` VALUES (24, 24, 'https://s1.ax1x.com/2020/07/18/UcokjJ.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01XqxIRl1WoTSJd26p4_!!2201702082835.jpg', NULL, NULL, NULL, NULL, '金国威h80000小福星移动老人手机侧键锁');
INSERT INTO `graphic_commodity` VALUES (25, 25, 'https://s1.ax1x.com/2020/07/18/UcoEu9.jpg', 'https://img.alicdn.com/imgextra/i4/2215302589/O1CN01t7JgbL1Uzo0aStYP8_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, '三防军工电霸超薄电信老人机');
INSERT INTO `graphic_commodity` VALUES (26, 26, 'https://s1.ax1x.com/2020/07/18/UcoVBR.jpg', 'https://img.alicdn.com/imgextra/i4/2215302589/O1CN01u6XySL1Uzo0cJkEvT_!!2215302589.jpg', NULL, NULL, NULL, NULL, '纽曼f516 (黑色)电信老人手机电信老人机翻盖老人机老年人手机 大屏大');
INSERT INTO `graphic_commodity` VALUES (27, 27, 'https://s1.ax1x.com/2020/07/18/Ucou4K.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01XqxIRl1WoTSJd26p4_!!2201702082835.jpg', NULL, NULL, NULL, NULL, '纽曼(newman) c5 天翼电信2g 男 女老年老人手机 学生 儿童机 黑色');
INSERT INTO `graphic_commodity` VALUES (28, 28, 'https://s1.ax1x.com/2020/07/18/UconN6.jpg', 'https://img.alicdn.com/imgextra/i1/3173963343/O1CN01glFiHH1aZ8enFH0zJ_!!3173963343.jpg', NULL, NULL, NULL, NULL, '守护宝l550 金色 直板按键 超长待机 移动联通2g 双卡双待老人手机');
INSERT INTO `graphic_commodity` VALUES (29, 29, 'https://s1.ax1x.com/2020/07/18/UcoZH1.jpg', 'https://img.alicdn.com/imgextra/i4/2201702082835/O1CN01mEaxCp1WoTSJ4qjvq_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i3/2201702082835/O1CN01ZnokNs1WoTSFQoLcv_!!2201702082835.jpg', NULL, NULL, NULL, 'changhong/长虹 m558m小悍马手机 超长待机');
INSERT INTO `graphic_commodity` VALUES (30, 30, 'https://s1.ax1x.com/2020/07/18/UcomAx.jpg', 'https://img.alicdn.com/imgextra/i1/3173963343/O1CN01glFiHH1aZ8enFH0zJ_!!3173963343.jpg', NULL, NULL, NULL, NULL, '路虎三防手机军工户外防水充电宝超长待机王直板老年手机正品');
INSERT INTO `graphic_commodity` VALUES (31, 31, 'https://i.loli.net/2020/07/18/7xTByPcDmul3np4.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01fjVRQX1WoTSLOyCtV_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01fjVRQX1WoTSLOyCtV_!!2201702082835.jpg', NULL, NULL, NULL, 'Meitu/美图 MP1801 V7 V6 T9美图手机V7美图自拍神器直播美颜神器');
INSERT INTO `graphic_commodity` VALUES (32, 32, 'https://i.loli.net/2020/07/18/t6wZSnqrLaWoQMi.jpg', 'https://img.alicdn.com/imgextra/i4/2215302589/O1CN01u6XySL1Uzo0cJkEvT_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i1/3173963343/O1CN01bedMs41aZ8esg2Nfj_!!3173963343.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, ' 【咨询立减80】Meitu/美图 T9美颜自拍全网通美图手机旗舰店官方T8s正品m8 m8s t8 m6s V6 V7');
INSERT INTO `graphic_commodity` VALUES (33, 33, 'https://i.loli.net/2020/07/18/6c5jUwLBzS38ouP.jpg', 'https://img.alicdn.com/imgextra/i1/3173963343/O1CN01glFiHH1aZ8enFH0zJ_!!3173963343.jpg', NULL, NULL, NULL, NULL, ' 【新品首发 享24期免息】vivo X50 Pro+双模5G智能手机官方旗舰店官网正品全新限量版vivox50 x30 s6 pro');
INSERT INTO `graphic_commodity` VALUES (34, 34, 'https://i.loli.net/2020/07/18/aTBY6DecmC1LdXV.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01fjVRQX1WoTSLOyCtV_!!2201702082835.jpg', 'https://img.alicdn.com/imgextra/i4/2215302589/O1CN01u6XySL1Uzo0cJkEvT_!!2215302589.jpg', 'https://img.alicdn.com/imgextra/i3/2215302589/O1CN014kHDqz1Uzo0bUVqGo_!!2215302589.jpg', NULL, NULL, ' 【24期免息】vivo NEX 3S 高通骁龙865全网通游戏5G智能手机官方旗舰店官网正品全新限量版vivonex3');
INSERT INTO `graphic_commodity` VALUES (35, 35, 'https://i.loli.net/2020/07/18/ERWLOtGH2Qo5ube.jpg', 'https://img.alicdn.com/imgextra/i1/3173963343/O1CN01glFiHH1aZ8enFH0zJ_!!3173963343.jpg', NULL, NULL, NULL, NULL, ' 【12期免息 至高省30】vivo iQOO Z1新品双模5g旗舰游戏144Hz手机官网旗舰店正品vivoiqoo neo3 vivoz5xz6');
INSERT INTO `graphic_commodity` VALUES (36, 36, 'https://i.loli.net/2020/07/18/iH5lEXItMZhFSwV.jpg', 'https://img.alicdn.com/imgextra/i1/3173963343/O1CN01glFiHH1aZ8enFH0zJ_!!3173963343.jpg', 'https://img.alicdn.com/imgextra/i2/2201702082835/O1CN01fjVRQX1WoTSLOyCtV_!!2201702082835.jpg', NULL, NULL, NULL, ' 【立减300元 12期免息】vivo X30双模5G新品手机官方旗舰店官网新款正品学生vivox30限量版x27pro x23 s6 S5');
INSERT INTO `graphic_commodity` VALUES (37, 37, 'https://i.loli.net/2020/07/18/2cZSwO6dPWAx9K1.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, ' 【限时减300 6期免息】OPPO Find X2 骁龙865双模5G旗舰拍照手机120Hz超感屏官方旗舰店正品oppofindx2');
INSERT INTO `graphic_commodity` VALUES (38, 38, 'https://i.loli.net/2020/07/18/6P9OXEMo4hHnryZ.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, ' 【三边窄边框金属本】Dell/戴尔成就5000十代4核i7独显512G/1TPcleSSD2年服务轻薄便携笔记本电脑Vostro5391');
INSERT INTO `graphic_commodity` VALUES (39, 39, 'https://i.loli.net/2020/07/18/OowZXaI2yUE83Mq.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, ' Dell戴尔成就5590笔记本电脑十代酷睿i7超薄轻薄便携学生商务办公游戏独显设计手提电脑2020款戴尔旗舰店官网');
INSERT INTO `graphic_commodity` VALUES (40, 40, 'https://i.loli.net/2020/07/18/BJm5y6h7UPb9KfV.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, ' 【吃鸡性能】Dell/戴尔 新G3 3500十代酷睿i7/1660ti笔记本电脑游匣G7游戏本吃鸡外星人1868官方旗舰店官网');
INSERT INTO `graphic_commodity` VALUES (41, 41, 'https://i.loli.net/2020/07/18/WesuXYvtP7L5KS9.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, ' 【12期免息 现货】ALIENWARE外星人全新m15 2020版R3十代酷睿i7游戏轻薄1660ti笔记本电脑15.6英寸电竞本5725');
INSERT INTO `graphic_commodity` VALUES (42, 42, 'https://i.loli.net/2020/07/18/7YT3ncL1BXFb8Ay.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, ' 【2020新品】HP/惠普光影精灵6 十代酷睿暗夜暗影精灵6电竞游戏本学生吃鸡手提笔记本电脑惠普官方旗舰店官网');
INSERT INTO `graphic_commodity` VALUES (43, 43, 'https://i.loli.net/2020/07/18/ht7ZDm3V6AlnoBw.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, 'Lenovo/联想12寸平板电脑学习机中小学英语点读机十核王者吃鸡');
INSERT INTO `graphic_commodity` VALUES (44, 44, 'https://i.loli.net/2020/07/18/B7Vvk2cjz9LHQ6d.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '清华同方至尊12寸学习机平板电脑十核中小学英语点读机王者吃鸡');
INSERT INTO `graphic_commodity` VALUES (45, 45, 'https://i.loli.net/2020/07/18/hDWoSIT4uQfaM71.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '10寸/14寸平板电脑新款ipad12寸5G全网通超薄安卓手机网课学习机');
INSERT INTO `graphic_commodity` VALUES (46, 46, 'https://i.loli.net/2020/07/18/uYsaTC3Fv2RKBnP.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '华为/HUAWEI MatePad Pro 5G 麒麟990 绚丽全面屏平板电脑智能学习游戏一体机');
INSERT INTO `graphic_commodity` VALUES (47, 47, 'https://i.loli.net/2020/07/18/ILF1RWEyf3PoUKa.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '摆渡者 2020新款平板电脑12英寸安卓手机二合一5G全网通学习专用学生三星屏小米岛华为ipad pro2019air3 mini');
INSERT INTO `graphic_commodity` VALUES (48, 48, 'https://i.loli.net/2020/07/18/e5CufSVYyqP6gGm.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '智能护眼学习机128G学生电脑12英寸学生平板儿童小学初高中家教机');
INSERT INTO `graphic_commodity` VALUES (49, 49, 'https://i.loli.net/2020/07/18/goyAD8TuRcvnhMG.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, 'Microsoft/微软 Surface Laptop i5 8G 256G二合一平板book笔记本');
INSERT INTO `graphic_commodity` VALUES (50, 50, 'https://i.loli.net/2020/07/18/zgdsR7WVqXu4wU3.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '华为平板电脑Matepad10.4寸2020新款m6学生用全面大屏m7全网通话10寸手机二合一iPad安卓pad爱派pro');
INSERT INTO `graphic_commodity` VALUES (51, 51, 'https://i.loli.net/2020/07/18/Xi8q6WGaOSV34ID.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '窄边一体机电脑IPS屏19-24寸i3i5i7英特办公游戏教学家用整机全套');
INSERT INTO `graphic_commodity` VALUES (52, 52, 'https://i.loli.net/2020/07/18/pQbUDn17seBLF5k.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, 'i5 9400F酷睿九代i3 9100F一体机电脑台式27英寸24曲面全套家用办公直播LOL魔兽多开吃鸡游戏型高配触摸主机');
INSERT INTO `graphic_commodity` VALUES (53, 53, 'https://i.loli.net/2020/07/18/5LEOHzfVdigCaux.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '超薄一体机电脑IPS屏游戏型酷睿i3i5i7办公家用独显高配台式整机全套');
INSERT INTO `graphic_commodity` VALUES (54, 54, 'https://i.loli.net/2020/07/18/9nJvbWsKyD1jd3O.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '七彩虹/onebot S500曲面一体机电脑家用办公设计23.8英寸i5 9400六核绘图网课学习AIO电脑全套一体式电脑');
INSERT INTO `graphic_commodity` VALUES (55, 55, 'https://s1.ax1x.com/2020/07/18/UcH94P.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '工艺: 半手工货号: CS-218外观造型: 动物');
INSERT INTO `graphic_commodity` VALUES (56, 56, 'https://s1.ax1x.com/2020/07/18/UcHpNt.jpg', 'https://s1.ax1x.com/2020/07/18/UgcWrV.png', 'https://s1.ax1x.com/2020/07/18/Ugc4VU.png', 'https://s1.ax1x.com/2020/07/18/UgcTPJ.png', NULL, NULL, '品牌: 聚帙功能: 招财材质: 陶瓷');
INSERT INTO `graphic_commodity` VALUES (57, 57, 'https://s1.ax1x.com/2020/07/18/Uc7xHA.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '包装方式: 礼盒装货号: ZS-001适用对象: 女朋友');
INSERT INTO `graphic_commodity` VALUES (58, 58, 'https://s1.ax1x.com/2020/07/18/UcHSAI.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '品牌: lovetime\n鲜花主花材: 红玫瑰\n鲜花规格(直径X高): 60*20*12');
INSERT INTO `graphic_commodity` VALUES (59, 59, 'https://s1.ax1x.com/2020/07/18/Uc7vBd.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '品牌: 北京爱情故事鲜花鲜花主花材: 混搭花束鲜花规格(直径X高): 大小规格可定制');
INSERT INTO `graphic_commodity` VALUES (60, 60, 'https://s1.ax1x.com/2020/07/18/UcHP9f.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '品牌: 花姿上品鲜花主花材: 向日葵鲜花规格(直径X高): 30×45cm鲜花朵数: 6朵');
INSERT INTO `graphic_commodity` VALUES (61, 61, 'https://s1.ax1x.com/2020/07/18/UcHsDH.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '梦馨 鲜花 鲜花速递 鲜花增进距离');
INSERT INTO `graphic_commodity` VALUES (62, 62, 'https://s1.ax1x.com/2020/07/18/UcHdC6.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '联洋七夕鲜花速递,提前预订不加价,8月7日全上海可送达!');
INSERT INTO `graphic_commodity` VALUES (63, 63, 'https://s1.ax1x.com/2020/07/18/UcHw8K.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '卡通花束-11只泰迪熊小熊花束');
INSERT INTO `graphic_commodity` VALUES (64, 64, 'https://s1.ax1x.com/2020/07/18/UcHBvD.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '叮当猫kt猫哆啦a梦花束');
INSERT INTO `graphic_commodity` VALUES (65, 65, 'https://s1.ax1x.com/2020/07/18/UcHU4x.jpg', 'https://s1.ax1x.com/2020/07/18/UgcI54.png', 'https://s1.ax1x.com/2020/07/18/UgcfbT.png', NULL, NULL, NULL, '玫瑰永生花玻璃罩成品定制');
INSERT INTO `graphic_commodity` VALUES (66, 66, 'https://s1.ax1x.com/2020/07/18/UcH0gO.jpg', 'https://i.loli.net/2020/07/18/y9lMfPrhCUaIkwL.jpg', 'https://i.loli.net/2020/07/18/eiFlAOYVSaUyIj8.jpg', NULL, NULL, NULL, '永生花燕窝礼盒图片');
INSERT INTO `graphic_commodity` VALUES (67, 67, 'https://s1.ax1x.com/2020/07/18/UcHIKg.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', 'https://i.loli.net/2020/07/18/y9lMfPrhCUaIkwL.jpg', 'https://i.loli.net/2020/07/18/4KlRT3BbVIDQmvE.jpg', NULL, NULL, '皮卡丘联名短袖t恤男士夏季宽松情侣装ins超火潮牌潮流体恤半袖潮');
INSERT INTO `graphic_commodity` VALUES (68, 68, 'https://s1.ax1x.com/2020/07/18/UcHOP0.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', 'https://i.loli.net/2020/07/18/eiFlAOYVSaUyIj8.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', NULL, NULL, 'Dangerouspeople 薛之谦dsp手绘字母LIFEISPARTY潮流圆领短袖T恤');
INSERT INTO `graphic_commodity` VALUES (69, 69, 'https://s1.ax1x.com/2020/07/18/UcHq5q.jpg', 'https://i.loli.net/2020/07/18/y9lMfPrhCUaIkwL.jpg', 'https://i.loli.net/2020/07/18/MU3vh5tc7T41foy.jpg', 'https://i.loli.net/2020/07/18/eiFlAOYVSaUyIj8.jpg', NULL, NULL, 'SELECTED思莱德夏季新款纯棉V领黑白色潮流短袖T恤男S|420201550');
INSERT INTO `graphic_commodity` VALUES (70, 70, 'https://s1.ax1x.com/2020/07/18/UcHTbj.jpg', 'https://i.loli.net/2020/07/18/eiFlAOYVSaUyIj8.jpg', 'https://i.loli.net/2020/07/18/4KlRT3BbVIDQmvE.jpg', 'https://i.loli.net/2020/07/18/4KlRT3BbVIDQmvE.jpg', NULL, NULL, '2020秋季新品 牛仔外套男 潮流 欧美复古水洗夹克 牛仔衣外套上装');
INSERT INTO `graphic_commodity` VALUES (71, 71, 'https://s1.ax1x.com/2020/07/18/UcHorQ.jpg', 'https://i.loli.net/2020/07/18/BSEFC3DXx7AyY4e.jpg', 'https://i.loli.net/2020/07/18/eiFlAOYVSaUyIj8.jpg', 'https://i.loli.net/2020/07/18/eiFlAOYVSaUyIj8.jpg', NULL, NULL, '冠军贵宾男士外套大码2020春秋季韩版潮流帅气男装休闲秋装薄夹克');
INSERT INTO `graphic_commodity` VALUES (72, 72, 'https://s1.ax1x.com/2020/07/18/UcHban.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', 'https://i.loli.net/2020/07/18/BSEFC3DXx7AyY4e.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', NULL, NULL, '格子连衣裙夏假两件女2020新款棉麻短袖法式拼接中长款大码大摆裙');
INSERT INTO `graphic_commodity` VALUES (73, 73, 'https://i.loli.net/2020/07/18/K4ltWwS5ZI6mqcu.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', 'https://i.loli.net/2020/07/18/y9lMfPrhCUaIkwL.jpg', 'https://i.loli.net/2020/07/18/4KlRT3BbVIDQmvE.jpg', NULL, NULL, '[咱们裸熊联名]唐狮2020新款情侣装夏装短袖T恤男女圆领宽松ins潮');
INSERT INTO `graphic_commodity` VALUES (74, 74, 'https://i.loli.net/2020/07/18/AfDHRTxCSi1wnJO.jpg', 'https://i.loli.net/2020/07/18/BSEFC3DXx7AyY4e.jpg', 'https://i.loli.net/2020/07/18/eiFlAOYVSaUyIj8.jpg', 'https://i.loli.net/2020/07/18/MU3vh5tc7T41foy.jpg', NULL, NULL, '夏季短袖t恤男士潮流韩版宽松五分袖上衣服男潮牌学生半截袖体恤');
INSERT INTO `graphic_commodity` VALUES (75, 75, 'https://i.loli.net/2020/07/18/3JqpfnmkCRbyaDH.jpg', 'https://i.loli.net/2020/07/18/y9lMfPrhCUaIkwL.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', 'https://i.loli.net/2020/07/18/BSEFC3DXx7AyY4e.jpg', NULL, NULL, '春夏季薄款男士韩版宽松短袖衬衫潮流百搭休闲外套帅气七分袖衬衣');
INSERT INTO `graphic_commodity` VALUES (76, 76, 'https://i.loli.net/2020/07/18/LF5gDGaRyhIS6oX.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', 'https://i.loli.net/2020/07/18/BSEFC3DXx7AyY4e.jpg', 'https://i.loli.net/2020/07/18/MU3vh5tc7T41foy.jpg', NULL, NULL, '唐狮情侣防晒衣2020夏新款男女外套连帽薄款防晒服潮流休闲薄外套');
INSERT INTO `graphic_commodity` VALUES (77, 77, 'https://i.loli.net/2020/07/18/sTeEJ9rXn8Nl54K.jpg', 'https://i.loli.net/2020/07/18/MU3vh5tc7T41foy.jpg', 'https://i.loli.net/2020/07/18/4KlRT3BbVIDQmvE.jpg', 'https://i.loli.net/2020/07/18/IKgGxe4SRt2HDaC.jpg', NULL, NULL, 'TeenieWeenie小熊夏女装甜美中长款裙装波点无袖吊带百褶连');
INSERT INTO `graphic_commodity` VALUES (78, 78, 'https://i.loli.net/2020/07/18/rsa8hGezZvS2gCE.jpg', 'https://i.loli.net/2020/07/18/MU3vh5tc7T41foy.jpg', 'https://i.loli.net/2020/07/18/MU3vh5tc7T41foy.jpg', NULL, NULL, NULL, '伊芙丽秋装年新款女裙子高腰气质格子雪纺中长款A字裙连衣裙');
INSERT INTO `graphic_commodity` VALUES (79, 79, 'https://s1.ax1x.com/2020/07/18/UcHMCV.jpg', 'https://s1.ax1x.com/2020/07/18/Ug6QYj.jpg', 'https://s1.ax1x.com/2020/07/18/Ug6WAe.jpg', 'https://s1.ax1x.com/2020/07/18/UgcCuV.jpg', NULL, NULL, '3段智纯婴幼儿臻稚三段700g克罐装12-36个月');
INSERT INTO `graphic_commodity` VALUES (80, 80, 'https://s1.ax1x.com/2020/07/18/UcHGDJ.jpg', 'https://s1.ax1x.com/2020/07/18/Ug6QYj.jpg', 'https://s1.ax1x.com/2020/07/18/Ug6WAe.jpg', 'https://s1.ax1x.com/2020/07/18/UgcCuV.jpg', NULL, NULL, '3段1-3岁宝宝900g*3');
INSERT INTO `graphic_commodity` VALUES (81, 81, 'https://s1.ax1x.com/2020/07/18/UcH4xS.jpg', 'https://s1.ax1x.com/2020/07/18/Ugcc2n.jpg', 'https://s1.ax1x.com/2020/07/18/Ugc7G9.jpg', 'https://s1.ax1x.com/2020/07/18/UggCRA.jpg', NULL, NULL, '婴幼儿宝宝辅食泥 吸吸袋果汁泥100g*6');
INSERT INTO `graphic_commodity` VALUES (82, 82, 'https://s1.ax1x.com/2020/07/18/UcH4xS.jpg', 'https://s1.ax1x.com/2020/07/18/Ugcc2n.jpg', 'https://s1.ax1x.com/2020/07/18/Ugc7G9.jpg', 'https://s1.ax1x.com/2020/07/18/UggCRA.jpg', NULL, NULL, '防便秘膳食纤维宝宝辅食吸吸袋');
INSERT INTO `graphic_commodity` VALUES (83, 83, 'https://s1.ax1x.com/2020/07/18/UcbnqH.jpg', 'https://s1.ax1x.com/2020/07/18/Ugg2JH.png', 'https://s1.ax1x.com/2020/07/18/UgggFe.png', 'https://s1.ax1x.com/2020/07/18/Ugg6oD.png', NULL, NULL, ' 宝宝连体内衣婴儿爬爬服');
INSERT INTO `graphic_commodity` VALUES (84, 84, 'https://s1.ax1x.com/2020/07/18/Ucb3JP.jpg', 'https://s1.ax1x.com/2020/07/18/Ugg2JH.png', 'https://s1.ax1x.com/2020/07/18/UgggFe.png', 'https://s1.ax1x.com/2020/07/18/Ugg6oD.png', NULL, NULL, '纱布宝宝空调服春秋季夏装薄款');

-- ----------------------------
-- Table structure for index
-- ----------------------------
DROP TABLE IF EXISTS `index`;
CREATE TABLE `index`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '首页名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '首页描述信息',
  `image` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '首页图片路径',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(0) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '主页表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index
-- ----------------------------
INSERT INTO `index` VALUES (1, '促销活动1', '促销活动1', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2020-06-22 15:46:44', 0);
INSERT INTO `index` VALUES (2, '促销活动2', '促销活动2', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2020-06-22 15:47:03', 0);
INSERT INTO `index` VALUES (3, '促销活动3', '促销活动3', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2020-06-22 15:47:21', 0);
INSERT INTO `index` VALUES (4, '首页广告1', '首页广告1', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2020-06-22 15:47:48', 0);
INSERT INTO `index` VALUES (5, '首页广告2', '首页广告2', NULL, NULL, 1);
INSERT INTO `index` VALUES (6, '首页广告3', '首页广告3', NULL, NULL, 1);

-- ----------------------------
-- Table structure for index_commodity
-- ----------------------------
DROP TABLE IF EXISTS `index_commodity`;
CREATE TABLE `index_commodity`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `index_id` int(0) NULL DEFAULT NULL,
  `commodity_id` int(0) NULL DEFAULT NULL,
  `type` int(0) NULL DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `index_id`(`index_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `index_commodity_ibfk_1` FOREIGN KEY (`index_id`) REFERENCES `index` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `index_commodity_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '主页与商品的关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of index_commodity
-- ----------------------------
INSERT INTO `index_commodity` VALUES (1, 1, 1, 1, '无', 0);
INSERT INTO `index_commodity` VALUES (2, 1, 2, 2, '无', 0);
INSERT INTO `index_commodity` VALUES (3, 1, 3, 2, '无', 0);
INSERT INTO `index_commodity` VALUES (4, 1, 4, 2, '无', 0);
INSERT INTO `index_commodity` VALUES (5, 1, 5, 4, '无', 0);
INSERT INTO `index_commodity` VALUES (6, 1, 6, 3, '无', 0);
INSERT INTO `index_commodity` VALUES (7, 1, 7, 2, '无', 0);
INSERT INTO `index_commodity` VALUES (8, 1, 8, 1, '无', 0);
INSERT INTO `index_commodity` VALUES (9, 1, 9, 4, '无', 0);
INSERT INTO `index_commodity` VALUES (10, 1, 10, 3, '无', 0);

-- ----------------------------
-- Table structure for jiufen
-- ----------------------------
DROP TABLE IF EXISTS `jiufen`;
CREATE TABLE `jiufen`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `customer_id` int(0) NOT NULL,
  `order_id` int(0) NOT NULL,
  `shop_id` int(0) NOT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `handTime` datetime(0) NULL DEFAULT NULL,
  `applyTime` datetime(0) NOT NULL,
  `is_delete` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jiufen
-- ----------------------------
INSERT INTO `jiufen` VALUES (1, 3, 1, 1, '质量问题', '同意退货退款', '1', '2020-07-21 09:53:08', '2020-06-24 12:12:32', 0);
INSERT INTO `jiufen` VALUES (2, 2, 9, 15, '尺码不合适', '', '0', '2020-07-11 21:13:50', '2020-06-24 12:15:33', 0);
INSERT INTO `jiufen` VALUES (3, 1, 10, 10, '不喜欢', '', '0', '2020-07-11 21:14:54', '2020-06-24 12:15:33', 0);
INSERT INTO `jiufen` VALUES (4, 3, 4, 5, '质量问题', '', '0', '2020-07-11 21:12:11', '2020-06-24 12:15:33', 0);
INSERT INTO `jiufen` VALUES (5, 8, 8, 8, '尺码不合适', '驳回买家请求', '1', '2020-07-23 22:01:04', '2020-06-24 12:15:33', 0);
INSERT INTO `jiufen` VALUES (6, 15, 20, 15, '七天无理由', '同意退货退款', '1', '2020-07-21 09:52:17', '2020-07-07 20:01:25', 1);
INSERT INTO `jiufen` VALUES (7, 16, 19, 15, '七天无理由', '同意退货退款', '1', '2020-07-10 20:03:01', '2020-07-07 20:01:25', 0);
INSERT INTO `jiufen` VALUES (8, 17, 21, 15, '质量问题', '同意退货退款', '1', '2020-07-10 20:03:01', '2020-07-07 20:01:25', 0);
INSERT INTO `jiufen` VALUES (9, 18, 23, 15, '质量问题', '同意退货退款', '1', '2020-07-10 20:03:01', '2020-07-07 20:01:25', 0);
INSERT INTO `jiufen` VALUES (10, 19, 24, 15, '质量问题', '同意退货退款', '1', '2020-07-10 20:03:01', '2020-07-07 20:01:25', 0);
INSERT INTO `jiufen` VALUES (11, 8, 12, 8, '尺码不合适', '驳回买家请求', '1', '2020-07-11 21:15:09', '2020-06-24 12:15:33', 0);
INSERT INTO `jiufen` VALUES (12, 7, 13, 8, '尺码不合适', '同意退货退款', '1', '2020-07-11 21:15:14', '2020-06-24 12:15:33', 0);
INSERT INTO `jiufen` VALUES (13, 1, 20, 1, '质量问题 : 手感不喜欢呢', NULL, '0', NULL, '2020-07-20 01:55:56', 0);
INSERT INTO `jiufen` VALUES (15, 1, 20, 1, '商品信息描述不符 : 不太喜欢这个手感', NULL, '0', NULL, '2020-07-20 10:10:33', 0);
INSERT INTO `jiufen` VALUES (16, 1, 34, 2, '未按约定时间发货 : 有一点不会用，求指导', NULL, '0', NULL, '2020-07-20 10:19:28', 0);
INSERT INTO `jiufen` VALUES (17, 1, 20, 1, '少件含缺少配件 : 少给我个耳机，很烦', '驳回买家请求', '1', '2020-07-23 21:58:23', '2020-07-20 10:48:54', 0);
INSERT INTO `jiufen` VALUES (18, 1, 35, 5, '少件含缺少配件 : ', '同意退货退款', '1', '2020-07-23 21:58:56', '2020-07-21 00:55:23', 0);
INSERT INTO `jiufen` VALUES (19, 1, 59, 5, '质量问题 : 有点不喜欢，太薄了，想退了', NULL, '0', NULL, '2020-07-21 12:10:14', 0);
INSERT INTO `jiufen` VALUES (20, 1, 62, 5, '包装/商品损坏/污渍 : 有点脏不好', NULL, '0', NULL, '2020-07-21 12:20:58', 0);
INSERT INTO `jiufen` VALUES (22, 1, 61, 3, '卖家发错货 : ', NULL, '0', NULL, '2020-07-21 13:15:21', 0);
INSERT INTO `jiufen` VALUES (23, 1, 36, 1, '未按约定时间发货 : ', NULL, '0', NULL, '2020-07-21 13:55:45', 0);

-- ----------------------------
-- Table structure for order_address
-- ----------------------------
DROP TABLE IF EXISTS `order_address`;
CREATE TABLE `order_address`  (
  `order_id` int(0) NOT NULL,
  `address_id` int(0) NOT NULL,
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  INDEX `order_address_ibfk_1`(`order_id`) USING BTREE,
  INDEX `order_address_ibfk_2`(`address_id`) USING BTREE,
  CONSTRAINT `order_address_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_address_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'order与address的关系表，关联订单与地址数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_address
-- ----------------------------
INSERT INTO `order_address` VALUES (1, 1, 0);
INSERT INTO `order_address` VALUES (2, 13, 0);
INSERT INTO `order_address` VALUES (3, 17, 0);
INSERT INTO `order_address` VALUES (4, 1, 0);
INSERT INTO `order_address` VALUES (8, 19, 0);
INSERT INTO `order_address` VALUES (6, 5, 0);
INSERT INTO `order_address` VALUES (16, 18, 0);
INSERT INTO `order_address` VALUES (4, 9, 0);
INSERT INTO `order_address` VALUES (5, 12, 0);
INSERT INTO `order_address` VALUES (18, 10, 0);
INSERT INTO `order_address` VALUES (7, 11, 0);
INSERT INTO `order_address` VALUES (19, 6, 0);
INSERT INTO `order_address` VALUES (15, 15, 0);
INSERT INTO `order_address` VALUES (20, 4, 0);
INSERT INTO `order_address` VALUES (15, 14, 0);
INSERT INTO `order_address` VALUES (13, 8, 0);
INSERT INTO `order_address` VALUES (12, 16, 0);
INSERT INTO `order_address` VALUES (9, 3, 0);
INSERT INTO `order_address` VALUES (11, 2, 0);
INSERT INTO `order_address` VALUES (14, 7, 0);
INSERT INTO `order_address` VALUES (21, 1, 0);
INSERT INTO `order_address` VALUES (24, 1, 0);
INSERT INTO `order_address` VALUES (26, 2, 0);
INSERT INTO `order_address` VALUES (27, 2, 0);
INSERT INTO `order_address` VALUES (29, 4, 0);
INSERT INTO `order_address` VALUES (31, 3, 0);
INSERT INTO `order_address` VALUES (32, 4, 0);
INSERT INTO `order_address` VALUES (33, 5, 0);
INSERT INTO `order_address` VALUES (34, 2, 0);
INSERT INTO `order_address` VALUES (35, 1, 0);
INSERT INTO `order_address` VALUES (36, 1, 0);
INSERT INTO `order_address` VALUES (37, 1, 0);
INSERT INTO `order_address` VALUES (38, 1, 0);
INSERT INTO `order_address` VALUES (39, 1, 0);
INSERT INTO `order_address` VALUES (40, 1, 0);
INSERT INTO `order_address` VALUES (41, 1, 0);
INSERT INTO `order_address` VALUES (42, 1, 0);
INSERT INTO `order_address` VALUES (43, 1, 0);
INSERT INTO `order_address` VALUES (44, 1, 0);
INSERT INTO `order_address` VALUES (45, 1, 0);
INSERT INTO `order_address` VALUES (46, 1, 0);
INSERT INTO `order_address` VALUES (47, 1, 0);
INSERT INTO `order_address` VALUES (48, 1, 0);
INSERT INTO `order_address` VALUES (49, 1, 0);
INSERT INTO `order_address` VALUES (50, 1, 0);
INSERT INTO `order_address` VALUES (51, 1, 0);
INSERT INTO `order_address` VALUES (52, 1, 0);
INSERT INTO `order_address` VALUES (53, 1, 0);
INSERT INTO `order_address` VALUES (54, 1, 0);
INSERT INTO `order_address` VALUES (55, 1, 0);
INSERT INTO `order_address` VALUES (56, 1, 0);
INSERT INTO `order_address` VALUES (57, 1, 0);
INSERT INTO `order_address` VALUES (58, 1, 0);
INSERT INTO `order_address` VALUES (59, 1, 0);
INSERT INTO `order_address` VALUES (60, 1, 0);
INSERT INTO `order_address` VALUES (61, 41, 0);
INSERT INTO `order_address` VALUES (62, 41, 0);
INSERT INTO `order_address` VALUES (63, 41, 0);
INSERT INTO `order_address` VALUES (64, 41, 0);
INSERT INTO `order_address` VALUES (65, 41, 0);
INSERT INTO `order_address` VALUES (66, 42, 0);
INSERT INTO `order_address` VALUES (67, 5, 0);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `order_id` int(0) NOT NULL COMMENT 'order表内的订单ID',
  `commodity_id` int(0) NOT NULL COMMENT 'commodity表内的商品ID',
  `commodity_quantity` int(0) NOT NULL DEFAULT 0 COMMENT '商品数量',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `status` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `order_item_ibfk_1`(`order_id`) USING BTREE,
  INDEX `order_item_ibfk_2`(`commodity_id`) USING BTREE,
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单与商品的关系表，存储订单细节' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (1, 1, 20, 4, 0, 1);
INSERT INTO `order_item` VALUES (2, 2, 13, 2, 0, 2);
INSERT INTO `order_item` VALUES (3, 2, 17, 2, 0, 4);
INSERT INTO `order_item` VALUES (4, 3, 1, 10, 0, 4);
INSERT INTO `order_item` VALUES (5, 4, 19, 3, 0, 2);
INSERT INTO `order_item` VALUES (6, 5, 5, 1, 0, 2);
INSERT INTO `order_item` VALUES (7, 6, 18, 4, 0, 4);
INSERT INTO `order_item` VALUES (8, 7, 9, 5, 0, 1);
INSERT INTO `order_item` VALUES (9, 8, 12, 2, 0, 2);
INSERT INTO `order_item` VALUES (10, 8, 10, 2, 0, 2);
INSERT INTO `order_item` VALUES (11, 9, 11, 4, 0, 3);
INSERT INTO `order_item` VALUES (12, 9, 6, 2, 0, 1);
INSERT INTO `order_item` VALUES (13, 10, 15, 2, 0, 2);
INSERT INTO `order_item` VALUES (14, 15, 4, 3, 0, 2);
INSERT INTO `order_item` VALUES (15, 11, 14, 4, 0, 3);
INSERT INTO `order_item` VALUES (16, 12, 8, 5, 0, 1);
INSERT INTO `order_item` VALUES (17, 13, 16, 5, 0, 3);
INSERT INTO `order_item` VALUES (18, 14, 3, 1, 0, 4);
INSERT INTO `order_item` VALUES (19, 16, 54, 8, 0, 2);
INSERT INTO `order_item` VALUES (20, 17, 43, 6, 0, 4);
INSERT INTO `order_item` VALUES (22, 18, 4, 5, 0, 2);
INSERT INTO `order_item` VALUES (23, 19, 54, 4, 0, 2);
INSERT INTO `order_item` VALUES (24, 19, 32, 1, 0, 4);
INSERT INTO `order_item` VALUES (25, 19, 11, 9, 0, 2);
INSERT INTO `order_item` VALUES (26, 20, 1, 5, 0, 1);
INSERT INTO `order_item` VALUES (27, 21, 42, 1, 0, 3);
INSERT INTO `order_item` VALUES (28, 22, 35, 1, 0, 2);
INSERT INTO `order_item` VALUES (29, 23, 21, 2, 0, 4);
INSERT INTO `order_item` VALUES (30, 24, 37, 3, 0, 2);
INSERT INTO `order_item` VALUES (31, 34, 2, 1, 0, 4);
INSERT INTO `order_item` VALUES (32, 35, 78, 1, 0, 2);
INSERT INTO `order_item` VALUES (33, 33, 54, 2, 0, 3);
INSERT INTO `order_item` VALUES (34, 34, 14, 3, 0, 1);
INSERT INTO `order_item` VALUES (35, 32, 51, 2, 0, 2);
INSERT INTO `order_item` VALUES (36, 31, 65, 5, 0, 4);
INSERT INTO `order_item` VALUES (37, 30, 59, 6, 0, 4);
INSERT INTO `order_item` VALUES (38, 29, 33, 2, 0, 0);
INSERT INTO `order_item` VALUES (39, 28, 76, 6, 0, 4);
INSERT INTO `order_item` VALUES (40, 27, 16, 10, 0, 8);
INSERT INTO `order_item` VALUES (41, 26, 15, 2, 0, 2);
INSERT INTO `order_item` VALUES (42, 25, 60, 6, 0, 4);
INSERT INTO `order_item` VALUES (43, 36, 1, 2, 0, 7);
INSERT INTO `order_item` VALUES (44, 37, 1, 2, 0, 7);
INSERT INTO `order_item` VALUES (45, 38, 6, 2, 0, 8);
INSERT INTO `order_item` VALUES (46, 38, 12, 1, 0, 4);
INSERT INTO `order_item` VALUES (47, 38, 8, 1, 0, 9);
INSERT INTO `order_item` VALUES (48, 38, 5, 5, 0, 2);
INSERT INTO `order_item` VALUES (49, 38, 55, 1, 0, 3);
INSERT INTO `order_item` VALUES (50, 38, 57, 1, 0, 5);
INSERT INTO `order_item` VALUES (51, 38, 73, 1, 0, 7);
INSERT INTO `order_item` VALUES (52, 39, 6, 2, 0, 5);
INSERT INTO `order_item` VALUES (53, 39, 12, 1, 0, 5);
INSERT INTO `order_item` VALUES (54, 39, 8, 1, 0, 5);
INSERT INTO `order_item` VALUES (55, 39, 5, 5, 0, 5);
INSERT INTO `order_item` VALUES (56, 39, 55, 1, 0, 5);
INSERT INTO `order_item` VALUES (57, 39, 57, 1, 0, 5);
INSERT INTO `order_item` VALUES (58, 39, 73, 1, 0, 5);
INSERT INTO `order_item` VALUES (59, 40, 6, 2, 0, 5);
INSERT INTO `order_item` VALUES (60, 40, 12, 1, 0, 5);
INSERT INTO `order_item` VALUES (61, 40, 8, 1, 0, 5);
INSERT INTO `order_item` VALUES (62, 40, 5, 5, 0, 5);
INSERT INTO `order_item` VALUES (63, 40, 55, 1, 0, 5);
INSERT INTO `order_item` VALUES (64, 40, 57, 1, 0, 5);
INSERT INTO `order_item` VALUES (65, 40, 73, 1, 0, 5);
INSERT INTO `order_item` VALUES (66, 41, 57, 1, 0, 5);
INSERT INTO `order_item` VALUES (67, 42, 73, 1, 0, 5);
INSERT INTO `order_item` VALUES (68, 43, 51, 1, 0, 5);
INSERT INTO `order_item` VALUES (69, 44, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (70, 45, 74, 1, 0, 5);
INSERT INTO `order_item` VALUES (71, 46, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (72, 47, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (73, 48, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (74, 49, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (75, 50, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (76, 51, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (77, 52, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (78, 53, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (79, 54, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (80, 55, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (81, 56, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (82, 57, 80, 1, 0, 5);
INSERT INTO `order_item` VALUES (83, 58, 17, 1, 0, 5);
INSERT INTO `order_item` VALUES (84, 59, 67, 1, 0, 5);
INSERT INTO `order_item` VALUES (85, 60, 56, 1, 0, 0);
INSERT INTO `order_item` VALUES (86, 61, 55, 1, 0, 5);
INSERT INTO `order_item` VALUES (87, 61, 57, 1, 0, 5);
INSERT INTO `order_item` VALUES (88, 61, 73, 1, 0, 5);
INSERT INTO `order_item` VALUES (89, 62, 67, 1, 0, 5);
INSERT INTO `order_item` VALUES (90, 63, 12, 1, 1, 0);
INSERT INTO `order_item` VALUES (91, 63, 8, 1, 1, 0);
INSERT INTO `order_item` VALUES (92, 63, 55, 1, 1, 0);
INSERT INTO `order_item` VALUES (93, 64, 12, 1, 1, 0);
INSERT INTO `order_item` VALUES (94, 64, 8, 1, 1, 0);
INSERT INTO `order_item` VALUES (95, 64, 55, 1, 1, 0);
INSERT INTO `order_item` VALUES (96, 65, 12, 1, 0, 1);
INSERT INTO `order_item` VALUES (97, 65, 8, 1, 0, 1);
INSERT INTO `order_item` VALUES (98, 65, 55, 1, 1, 1);
INSERT INTO `order_item` VALUES (99, 66, 1, 1, 0, 1);
INSERT INTO `order_item` VALUES (100, 67, 14, 1, 0, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `date` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '订单日期',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单描述',
  `comment` int(0) NULL DEFAULT NULL COMMENT '订单评价',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '订单状态',
  `isDelete` int(0) NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  INDEX `ID_2`(`ID`) USING BTREE,
  INDEX `ID_3`(`ID`) USING BTREE,
  INDEX `ID_4`(`ID`) USING BTREE,
  INDEX `ID_5`(`ID`) USING BTREE,
  INDEX `ID_6`(`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, '2020-07-18 22:51:00', '麻烦尽快发货，急用！', 1, '1', 0);
INSERT INTO `orders` VALUES (2, '2020-07-18 14:50:56', '请发顺丰快递', 1, '2', 0);
INSERT INTO `orders` VALUES (3, '2020-07-18 14:50:19', '麻烦尽快发货，急用！', 1, '3', 0);
INSERT INTO `orders` VALUES (4, '2020-07-18 14:50:57', '请发顺丰快递', 1, '2', 0);
INSERT INTO `orders` VALUES (5, '2020-07-18 14:50:28', '生鲜订单，当日送达', 2, '1', 0);
INSERT INTO `orders` VALUES (6, '2020-07-18 14:50:16', '麻烦尽快发货，急用！', 3, '4', 0);
INSERT INTO `orders` VALUES (7, '2020-07-18 14:46:44', '生鲜订单，当日送达', 3, '1', 0);
INSERT INTO `orders` VALUES (8, '2020-07-18 14:47:32', '请发顺丰快递', 3, '2', 0);
INSERT INTO `orders` VALUES (9, '2020-07-18 14:47:57', '麻烦尽快发货，急用！', 1, '1', 0);
INSERT INTO `orders` VALUES (10, '2020-07-18 20:11:10', '生鲜订单，当日送达', 1, '1', 0);
INSERT INTO `orders` VALUES (11, '2020-07-18 14:48:28', '商品不符合描述，差评！', 1, '4', 0);
INSERT INTO `orders` VALUES (12, '2020-07-18 14:49:14', '麻烦尽快发货，急用！', 2, '1', 0);
INSERT INTO `orders` VALUES (13, '2020-07-18 14:49:18', '生鲜订单，当日送达', 2, '1', 0);
INSERT INTO `orders` VALUES (14, '2020-07-18 14:49:53', '麻烦尽快发货，急用！', 2, '2', 0);
INSERT INTO `orders` VALUES (15, '2020-07-18 14:46:59', '用起来很好，实力推荐', 1, '3', 0);
INSERT INTO `orders` VALUES (16, '2020-07-18 14:49:20', '生鲜订单，当日送达', 1, '4', 0);
INSERT INTO `orders` VALUES (17, '2020-07-19 14:20:06', '麻烦尽快发货，急用！', 1, '2', 0);
INSERT INTO `orders` VALUES (18, '2020-07-19 20:48:04', '下次还会购买的！', 1, '2', 0);
INSERT INTO `orders` VALUES (19, '2020-07-18 14:50:46', '生鲜订单，当日送达', 3, '1', 0);
INSERT INTO `orders` VALUES (20, '2020-07-21 00:30:06', '麻烦尽快发货，急用！', 2, '8', 1);
INSERT INTO `orders` VALUES (21, '2020-07-18 14:50:47', '生鲜订单，当日送达', 2, '1', 0);
INSERT INTO `orders` VALUES (22, '2020-07-19 20:48:05', '生鲜订单，当日送达', 2, '2', 0);
INSERT INTO `orders` VALUES (24, '2020-07-21 12:30:26', '麻烦尽快发货，急用！', 1, '0', 0);
INSERT INTO `orders` VALUES (25, '2020-07-20 09:30:06', '发货', 2, '2', 0);
INSERT INTO `orders` VALUES (26, '2020-07-20 09:30:06', '快发货', 2, '1', 0);
INSERT INTO `orders` VALUES (27, '2020-07-20 12:11:45', '发货', 1, '0', 0);
INSERT INTO `orders` VALUES (28, '2020-07-20 09:30:06', '推荐', 4, '2', 0);
INSERT INTO `orders` VALUES (29, '2020-07-21 00:40:53', '好用的', 2, '8', 0);
INSERT INTO `orders` VALUES (30, '2020-07-20 12:17:16', '期待', 1, '3', 0);
INSERT INTO `orders` VALUES (31, '2020-07-21 00:53:20', '麻烦了', 2, '4', 1);
INSERT INTO `orders` VALUES (32, '2020-07-21 01:49:45', '急用', 1, '4', 1);
INSERT INTO `orders` VALUES (33, '2020-07-21 01:49:36', '朋友推荐', 1, '2', 0);
INSERT INTO `orders` VALUES (34, '2020-07-21 01:49:47', '试用', 2, '4', 1);
INSERT INTO `orders` VALUES (35, '2020-07-21 10:32:12', '试试看', 3, '0', 0);
INSERT INTO `orders` VALUES (36, '2020-07-21 00:32:43', NULL, 0, '8', 0);
INSERT INTO `orders` VALUES (37, '2020-07-21 00:53:57', NULL, 0, '8', 1);
INSERT INTO `orders` VALUES (57, '2020-07-21 01:49:51', NULL, 0, '4', 0);
INSERT INTO `orders` VALUES (58, '2020-07-21 01:49:40', NULL, 0, '2', 0);
INSERT INTO `orders` VALUES (59, '2020-07-21 12:20:10', NULL, 0, '0', 1);
INSERT INTO `orders` VALUES (60, '2020-07-21 11:59:44', NULL, 0, '8', 0);
INSERT INTO `orders` VALUES (61, '2020-07-21 13:15:22', NULL, 0, '6', 0);
INSERT INTO `orders` VALUES (62, '2020-07-21 12:21:00', NULL, 0, '5', 0);
INSERT INTO `orders` VALUES (63, '2020-07-21 05:30:51', NULL, 0, '0', 0);
INSERT INTO `orders` VALUES (64, '2020-07-21 05:40:34', NULL, 0, '0', 0);
INSERT INTO `orders` VALUES (65, '2020-07-21 05:54:32', NULL, 0, '0', 0);
INSERT INTO `orders` VALUES (66, '2020-07-22 06:44:37', NULL, 0, '0', 0);
INSERT INTO `orders` VALUES (67, '2020-07-23 13:03:13', NULL, 0, '0', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理者');
INSERT INTO `role` VALUES (2, '编辑者');
INSERT INTO `role` VALUES (3, '访问者');

-- ----------------------------
-- Table structure for settings
-- ----------------------------
DROP TABLE IF EXISTS `settings`;
CREATE TABLE `settings`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '系统设置id\r\n',
  `background_color` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '背景颜色设置',
  `message_remind` int(0) NOT NULL COMMENT '消息提示设置',
  `music_remind` int(0) NOT NULL COMMENT '背景音乐设置',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of settings
-- ----------------------------
INSERT INTO `settings` VALUES (1, 'black', 1, 1, 0);
INSERT INTO `settings` VALUES (2, 'black', 1, 0, 0);
INSERT INTO `settings` VALUES (3, 'black', 0, 1, 0);
INSERT INTO `settings` VALUES (4, 'black', 0, 0, 0);
INSERT INTO `settings` VALUES (5, 'orange', 1, 1, 0);
INSERT INTO `settings` VALUES (6, 'orange', 1, 0, 0);
INSERT INTO `settings` VALUES (7, 'orange', 0, 1, 0);
INSERT INTO `settings` VALUES (8, 'orange', 0, 0, 0);
INSERT INTO `settings` VALUES (9, 'pink', 1, 1, 0);
INSERT INTO `settings` VALUES (10, 'pink', 1, 0, 0);
INSERT INTO `settings` VALUES (11, 'pink', 0, 1, 0);
INSERT INTO `settings` VALUES (12, 'pink', 0, 0, 0);
INSERT INTO `settings` VALUES (13, 'blue', 1, 1, 0);
INSERT INTO `settings` VALUES (14, 'blue', 1, 0, 0);
INSERT INTO `settings` VALUES (15, 'blue', 0, 1, 0);
INSERT INTO `settings` VALUES (16, 'blue', 0, 0, 0);
INSERT INTO `settings` VALUES (17, 'purple', 1, 1, 0);
INSERT INTO `settings` VALUES (18, 'purple', 1, 0, 0);
INSERT INTO `settings` VALUES (19, 'purple', 0, 1, 0);
INSERT INTO `settings` VALUES (20, 'purple', 0, 0, 0);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id自增唯一',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺名字',
  `establishTime` timestamp(0) NOT NULL COMMENT '店铺创建时间',
  `kind` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺类型',
  `status` int(0) NOT NULL COMMENT '店铺状态',
  `isDelete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '店铺照片',
  `tag` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '店铺标签',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '门店描述',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ID`(`ID`) USING BTREE,
  INDEX `ID_2`(`ID`) USING BTREE,
  INDEX `ID_3`(`ID`) USING BTREE,
  INDEX `ID_4`(`ID`) USING BTREE,
  INDEX `ID_5`(`ID`) USING BTREE,
  INDEX `ID_6`(`ID`) USING BTREE,
  INDEX `ID_7`(`ID`) USING BTREE,
  INDEX `ID_8`(`ID`) USING BTREE,
  INDEX `ID_9`(`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '店铺信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, '纵横数码', '2012-05-20 14:35:21', '旗舰店', 0, 0, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595063140186&di=5652502248fc3b0e17de234d162e07a4&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg', '电子数码', '8年老店，值得信赖，欢迎选购');
INSERT INTO `shop` VALUES (2, '雅玛浩瀚电子数码', '2020-06-10 14:34:52', '自营店', 0, 0, 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3922290090,3177876335&fm=26&gp=0.jpg', '电子数码', '店内电子产品三年质保，无忧售后');
INSERT INTO `shop` VALUES (3, '创意礼品店', '2020-05-06 14:34:58', '旗舰店', 0, 0, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595063158829&di=e514af8ff0d51cfbd93969d1083f8486&imgtype=0&src=http%3A%2F%2Fstatic-xiaoguotu.17house.com%2Fxgt%2Fm%2F14%2F1462687500175.jpg', '日用', '本店提供各式各样的创意礼品，走过路过不要错过');
INSERT INTO `shop` VALUES (4, '鲜花专卖店', '2020-04-29 14:35:03', '自营店', 0, 0, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595063388626&di=35068cfb904f696b9e86e365c0f807f6&imgtype=0&src=http%3A%2F%2Fwww.xiujukoo.com%2Fupimg%2Fallimg%2F160301%2F0918390.jpg', '日用', '本店提供鲜花配送，同城当日送达哦');
INSERT INTO `shop` VALUES (5, 'R1SE服饰小店', '2020-06-03 14:35:08', '旗舰店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (6, '婴幼儿商店', '2020-06-03 14:35:09', '旗舰店', 0, 0, 'https://i.loli.net/2020/07/18/2SxgOQdFZJ5BU7D.jpg', '日用', '本店提供婴幼儿产品');
INSERT INTO `shop` VALUES (7, '鞋子小店4', '2020-06-03 14:35:18', '进口店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (8, '鞋子小店5', '2020-05-20 14:35:21', '旗舰店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (9, '鞋子小店6', '2020-06-17 14:35:25', '旗舰店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (10, '鞋子小店7', '2020-05-27 14:35:30', '旗舰店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (11, '鞋子小店9', '2020-06-03 14:35:34', '旗舰店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (12, '化妆品小店', '2020-06-04 14:35:38', '普通店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (13, '笔记本电脑小店', '2020-06-04 14:35:41', '普通店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (14, '手表小店', '2020-06-06 14:35:45', '旗舰店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (15, '帽子小店', '2020-06-07 14:35:49', '普通店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');
INSERT INTO `shop` VALUES (16, '这是一个小店', '2020-06-02 14:33:22', '进口店', 0, 0, 'https://i.loli.net/2020/07/07/nsQIYyDPUWxBdNZ.jpg', '服装', '这是一个服装小店，其中包括男装，女装等等');

-- ----------------------------
-- Table structure for shop_commodity
-- ----------------------------
DROP TABLE IF EXISTS `shop_commodity`;
CREATE TABLE `shop_commodity`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `shop_id` int(0) NOT NULL COMMENT '店铺id',
  `commodity_id` int(0) NOT NULL COMMENT '商品id',
  `isDelete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  INDEX `commodity_id`(`commodity_id`) USING BTREE,
  CONSTRAINT `shop_commodity_ibfk_2` FOREIGN KEY (`commodity_id`) REFERENCES `commodity` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shop_commodity_ibfk_3` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '店铺_商品关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_commodity
-- ----------------------------
INSERT INTO `shop_commodity` VALUES (1, 1, 1, 0);
INSERT INTO `shop_commodity` VALUES (2, 2, 2, 0);
INSERT INTO `shop_commodity` VALUES (3, 1, 3, 0);
INSERT INTO `shop_commodity` VALUES (4, 2, 4, 0);
INSERT INTO `shop_commodity` VALUES (5, 2, 5, 0);
INSERT INTO `shop_commodity` VALUES (6, 1, 6, 0);
INSERT INTO `shop_commodity` VALUES (7, 1, 7, 0);
INSERT INTO `shop_commodity` VALUES (8, 1, 8, 0);
INSERT INTO `shop_commodity` VALUES (9, 1, 9, 0);
INSERT INTO `shop_commodity` VALUES (10, 1, 10, 0);
INSERT INTO `shop_commodity` VALUES (11, 1, 11, 0);
INSERT INTO `shop_commodity` VALUES (12, 1, 12, 0);
INSERT INTO `shop_commodity` VALUES (13, 1, 13, 0);
INSERT INTO `shop_commodity` VALUES (14, 1, 14, 0);
INSERT INTO `shop_commodity` VALUES (15, 1, 15, 0);
INSERT INTO `shop_commodity` VALUES (16, 2, 16, 0);
INSERT INTO `shop_commodity` VALUES (17, 2, 17, 0);
INSERT INTO `shop_commodity` VALUES (18, 2, 18, 0);
INSERT INTO `shop_commodity` VALUES (19, 2, 19, 0);
INSERT INTO `shop_commodity` VALUES (20, 2, 20, 0);
INSERT INTO `shop_commodity` VALUES (21, 2, 21, 0);
INSERT INTO `shop_commodity` VALUES (22, 2, 22, 0);
INSERT INTO `shop_commodity` VALUES (23, 2, 23, 0);
INSERT INTO `shop_commodity` VALUES (24, 2, 24, 0);
INSERT INTO `shop_commodity` VALUES (25, 1, 25, 0);
INSERT INTO `shop_commodity` VALUES (26, 1, 26, 0);
INSERT INTO `shop_commodity` VALUES (27, 1, 27, 0);
INSERT INTO `shop_commodity` VALUES (28, 1, 28, 0);
INSERT INTO `shop_commodity` VALUES (29, 2, 29, 0);
INSERT INTO `shop_commodity` VALUES (30, 2, 30, 0);
INSERT INTO `shop_commodity` VALUES (31, 2, 31, 0);
INSERT INTO `shop_commodity` VALUES (32, 2, 32, 0);
INSERT INTO `shop_commodity` VALUES (33, 2, 33, 0);
INSERT INTO `shop_commodity` VALUES (34, 2, 34, 0);
INSERT INTO `shop_commodity` VALUES (35, 2, 35, 0);
INSERT INTO `shop_commodity` VALUES (36, 1, 36, 0);
INSERT INTO `shop_commodity` VALUES (37, 2, 37, 0);
INSERT INTO `shop_commodity` VALUES (38, 1, 38, 0);
INSERT INTO `shop_commodity` VALUES (39, 1, 39, 0);
INSERT INTO `shop_commodity` VALUES (40, 2, 40, 0);
INSERT INTO `shop_commodity` VALUES (41, 1, 41, 0);
INSERT INTO `shop_commodity` VALUES (42, 1, 42, 0);
INSERT INTO `shop_commodity` VALUES (43, 1, 43, 0);
INSERT INTO `shop_commodity` VALUES (44, 1, 44, 0);
INSERT INTO `shop_commodity` VALUES (45, 1, 45, 0);
INSERT INTO `shop_commodity` VALUES (46, 1, 46, 0);
INSERT INTO `shop_commodity` VALUES (47, 1, 47, 0);
INSERT INTO `shop_commodity` VALUES (48, 1, 48, 0);
INSERT INTO `shop_commodity` VALUES (49, 1, 49, 0);
INSERT INTO `shop_commodity` VALUES (50, 2, 50, 0);
INSERT INTO `shop_commodity` VALUES (51, 1, 51, 0);
INSERT INTO `shop_commodity` VALUES (52, 2, 52, 0);
INSERT INTO `shop_commodity` VALUES (53, 1, 53, 0);
INSERT INTO `shop_commodity` VALUES (54, 4, 54, 0);
INSERT INTO `shop_commodity` VALUES (55, 3, 55, 0);
INSERT INTO `shop_commodity` VALUES (56, 3, 56, 0);
INSERT INTO `shop_commodity` VALUES (57, 3, 57, 0);
INSERT INTO `shop_commodity` VALUES (58, 4, 58, 0);
INSERT INTO `shop_commodity` VALUES (59, 4, 59, 0);
INSERT INTO `shop_commodity` VALUES (60, 4, 60, 0);
INSERT INTO `shop_commodity` VALUES (61, 4, 61, 0);
INSERT INTO `shop_commodity` VALUES (62, 4, 62, 0);
INSERT INTO `shop_commodity` VALUES (63, 4, 63, 0);
INSERT INTO `shop_commodity` VALUES (64, 4, 64, 0);
INSERT INTO `shop_commodity` VALUES (65, 4, 65, 0);
INSERT INTO `shop_commodity` VALUES (66, 4, 66, 0);
INSERT INTO `shop_commodity` VALUES (67, 5, 67, 0);
INSERT INTO `shop_commodity` VALUES (68, 5, 68, 0);
INSERT INTO `shop_commodity` VALUES (69, 5, 69, 0);
INSERT INTO `shop_commodity` VALUES (70, 5, 70, 0);
INSERT INTO `shop_commodity` VALUES (71, 5, 71, 0);
INSERT INTO `shop_commodity` VALUES (72, 5, 72, 0);
INSERT INTO `shop_commodity` VALUES (73, 5, 73, 0);
INSERT INTO `shop_commodity` VALUES (74, 5, 74, 0);
INSERT INTO `shop_commodity` VALUES (75, 5, 75, 0);
INSERT INTO `shop_commodity` VALUES (76, 5, 76, 0);
INSERT INTO `shop_commodity` VALUES (77, 5, 77, 0);
INSERT INTO `shop_commodity` VALUES (78, 5, 78, 0);
INSERT INTO `shop_commodity` VALUES (79, 6, 79, 0);
INSERT INTO `shop_commodity` VALUES (80, 6, 80, 0);
INSERT INTO `shop_commodity` VALUES (81, 6, 81, 0);
INSERT INTO `shop_commodity` VALUES (82, 6, 82, 0);
INSERT INTO `shop_commodity` VALUES (83, 6, 83, 0);
INSERT INTO `shop_commodity` VALUES (84, 6, 84, 0);

-- ----------------------------
-- Table structure for shop_manager
-- ----------------------------
DROP TABLE IF EXISTS `shop_manager`;
CREATE TABLE `shop_manager`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '店铺管理员',
  `name` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '店铺管理员姓名',
  `age` int(0) NULL DEFAULT NULL COMMENT '店铺管理员年龄',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '店铺管理员性别',
  `pwd` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123' COMMENT '店铺管理员密码',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123' COMMENT '店铺管理员昵称',
  `user_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '店铺管理员头像图片链接',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `login_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123' COMMENT '店铺管理员登录账号',
  `phone` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_delete` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '店铺管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_manager
-- ----------------------------
INSERT INTO `shop_manager` VALUES (1, '黄道明', 20, '男', '123', 'fastman', 'https://s1.ax1x.com/2020/07/19/URUirQ.jpg', '2000-01-04', 'user1234567', '18940409778', 0);
INSERT INTO `shop_manager` VALUES (2, '张美琳', 21, '男', '123', '小红', 'https://s1.ax1x.com/2020/07/19/URUPKg.jpg', '2000-01-05', 'user1234568', '18940409779', 0);
INSERT INTO `shop_manager` VALUES (3, '秦欢馨', 22, '女', '123', '饿啊', 'https://s1.ax1x.com/2020/07/19/URU9xS.jpg', '2000-01-06', 'user1234569', '18940409780', 0);
INSERT INTO `shop_manager` VALUES (4, '王龙', 23, '男', '123', '龙哥哥', 'https://s1.ax1x.com/2020/07/19/URUFbj.jpg', '2000-01-07', 'user1234570', '18940409781', 0);
INSERT INTO `shop_manager` VALUES (5, '张浩', 18, '女', '123', '张浩', 'https://s1.ax1x.com/2020/07/19/URUp28.jpg', '2000-01-08', 'user1234571', '18940409782', 0);
INSERT INTO `shop_manager` VALUES (6, '李昊佳', 19, '男', '123', '李昊佳', 'https://s1.ax1x.com/2020/07/19/URUAVs.jpg', '2000-01-09', 'user1234572', '18940409783', 0);
INSERT INTO `shop_manager` VALUES (7, '王低都', 20, '男', '123', '王低都', 'https://s1.ax1x.com/2020/07/19/URUV5q.jpg', '2000-01-10', 'user1234573', '18940409784', 0);
INSERT INTO `shop_manager` VALUES (8, '邱君', 21, '女', '123', '邱君', 'https://s1.ax1x.com/2020/07/19/URUEan.jpg', '2000-01-11', 'user1234574', '18940409785', 0);
INSERT INTO `shop_manager` VALUES (9, '夏之光', 22, '男', 'xzg', '瞎逛', 'https://s1.ax1x.com/2020/07/19/URUeP0.jpg', '2000-01-12', 'user1234575', '18940409786', 0);
INSERT INTO `shop_manager` VALUES (10, '赵磊', 18, '女', 'leige', '磊哥', 'https://s1.ax1x.com/2020/07/19/URUmGV.jpg', '2000-01-13', 'user1234576', '18940409787', 0);
INSERT INTO `shop_manager` VALUES (11, '焉诩嘉', 19, '女', 'jiajia', '旺仔', 'https://s1.ax1x.com/2020/07/19/URUn2T.jpg', '2000-01-14', 'user1234577', '18940409788', 0);
INSERT INTO `shop_manager` VALUES (12, '任豪', 20, '男', 'renhao', '郝总', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-15', 'user1234578', '18940409789', 0);
INSERT INTO `shop_manager` VALUES (13, '王境泽', 21, '男', '123', '王敬则', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-16', 'user1234579', '18940409790', 0);
INSERT INTO `shop_manager` VALUES (14, '亦匡新', 22, '女', '123', '公孙新', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-17', 'user1234580', '18940409791', 0);
INSERT INTO `shop_manager` VALUES (15, '刘爆发', 23, '男', '123', '爆爆', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-18', 'user1234581', '18940409792', 0);
INSERT INTO `shop_manager` VALUES (16, '朱朝阳', 24, '男', '123', '还行', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-19', 'user1234582', '18940409793', 0);

-- ----------------------------
-- Table structure for shop_manager_authority
-- ----------------------------
DROP TABLE IF EXISTS `shop_manager_authority`;
CREATE TABLE `shop_manager_authority`  (
  `shop_manager_id` int(0) NOT NULL COMMENT '店铺管理员ID',
  `authority_id` int(0) NOT NULL COMMENT '权限ID',
  `isDelete` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`shop_manager_id`, `authority_id`) USING BTREE,
  INDEX `authority_id`(`authority_id`) USING BTREE,
  CONSTRAINT `shop_manager_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shop_manager_authority_ibfk_3` FOREIGN KEY (`shop_manager_id`) REFERENCES `shop_manager` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '店铺管理员和他的权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_manager_authority
-- ----------------------------
INSERT INTO `shop_manager_authority` VALUES (1, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (1, 3, 1);
INSERT INTO `shop_manager_authority` VALUES (1, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (2, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (2, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (2, 3, 1);
INSERT INTO `shop_manager_authority` VALUES (2, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (3, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (3, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (3, 3, 0);
INSERT INTO `shop_manager_authority` VALUES (3, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (4, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (4, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (4, 3, 0);
INSERT INTO `shop_manager_authority` VALUES (4, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (5, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (5, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (5, 3, 0);
INSERT INTO `shop_manager_authority` VALUES (5, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (6, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (6, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (6, 3, 0);
INSERT INTO `shop_manager_authority` VALUES (6, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (7, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (7, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (7, 3, 0);
INSERT INTO `shop_manager_authority` VALUES (7, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (8, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (8, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (8, 3, 0);
INSERT INTO `shop_manager_authority` VALUES (8, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (9, 1, 0);
INSERT INTO `shop_manager_authority` VALUES (9, 2, 0);
INSERT INTO `shop_manager_authority` VALUES (9, 3, 0);
INSERT INTO `shop_manager_authority` VALUES (9, 4, 0);
INSERT INTO `shop_manager_authority` VALUES (10, 1, 0);

-- ----------------------------
-- Table structure for shop_manager_shop
-- ----------------------------
DROP TABLE IF EXISTS `shop_manager_shop`;
CREATE TABLE `shop_manager_shop`  (
  `shop_id` int(0) NOT NULL COMMENT '店铺ID',
  `shop_manager_id` int(0) NOT NULL COMMENT '店铺管理员ID',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`shop_id`, `shop_manager_id`) USING BTREE,
  INDEX `shop_manager_id`(`shop_manager_id`) USING BTREE,
  CONSTRAINT `shop_manager_shop_ibfk_3` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shop_manager_shop_ibfk_4` FOREIGN KEY (`shop_manager_id`) REFERENCES `shop_manager` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '店铺管理员和他的店铺' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_manager_shop
-- ----------------------------
INSERT INTO `shop_manager_shop` VALUES (1, 1, 0);
INSERT INTO `shop_manager_shop` VALUES (2, 2, 0);
INSERT INTO `shop_manager_shop` VALUES (3, 3, 0);
INSERT INTO `shop_manager_shop` VALUES (4, 4, 0);
INSERT INTO `shop_manager_shop` VALUES (5, 5, 0);
INSERT INTO `shop_manager_shop` VALUES (6, 6, 0);
INSERT INTO `shop_manager_shop` VALUES (7, 7, 0);
INSERT INTO `shop_manager_shop` VALUES (8, 8, 0);
INSERT INTO `shop_manager_shop` VALUES (9, 9, 0);
INSERT INTO `shop_manager_shop` VALUES (10, 10, 0);
INSERT INTO `shop_manager_shop` VALUES (11, 11, 0);
INSERT INTO `shop_manager_shop` VALUES (12, 12, 0);
INSERT INTO `shop_manager_shop` VALUES (13, 13, 0);
INSERT INTO `shop_manager_shop` VALUES (14, 14, 0);
INSERT INTO `shop_manager_shop` VALUES (15, 15, 0);
INSERT INTO `shop_manager_shop` VALUES (16, 16, 0);

-- ----------------------------
-- Table structure for shop_order
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `shop_id` int(0) NOT NULL COMMENT '店铺id',
  `order_id` int(0) NOT NULL COMMENT '订单id',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shop_id`(`shop_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `shop_order_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shop_order_ibfk_3` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 344 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '店铺_订单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_order
-- ----------------------------
INSERT INTO `shop_order` VALUES (1, 1, 1, 0);
INSERT INTO `shop_order` VALUES (2, 1, 2, 0);
INSERT INTO `shop_order` VALUES (3, 1, 3, 0);
INSERT INTO `shop_order` VALUES (4, 2, 4, 0);
INSERT INTO `shop_order` VALUES (5, 2, 5, 0);
INSERT INTO `shop_order` VALUES (6, 2, 6, 0);
INSERT INTO `shop_order` VALUES (7, 2, 7, 0);
INSERT INTO `shop_order` VALUES (8, 3, 8, 0);
INSERT INTO `shop_order` VALUES (9, 3, 9, 0);
INSERT INTO `shop_order` VALUES (10, 3, 10, 0);
INSERT INTO `shop_order` VALUES (11, 4, 11, 0);
INSERT INTO `shop_order` VALUES (12, 4, 12, 0);
INSERT INTO `shop_order` VALUES (13, 4, 13, 0);
INSERT INTO `shop_order` VALUES (14, 4, 14, 0);
INSERT INTO `shop_order` VALUES (15, 4, 15, 0);
INSERT INTO `shop_order` VALUES (16, 4, 16, 0);
INSERT INTO `shop_order` VALUES (17, 5, 17, 0);
INSERT INTO `shop_order` VALUES (18, 5, 18, 0);
INSERT INTO `shop_order` VALUES (19, 5, 19, 0);
INSERT INTO `shop_order` VALUES (20, 5, 20, 0);
INSERT INTO `shop_order` VALUES (21, 6, 21, 0);
INSERT INTO `shop_order` VALUES (22, 6, 22, 0);
INSERT INTO `shop_order` VALUES (23, 6, 23, 0);
INSERT INTO `shop_order` VALUES (24, 6, 24, 0);
INSERT INTO `shop_order` VALUES (298, 5, 35, 0);
INSERT INTO `shop_order` VALUES (299, 1, 36, 0);
INSERT INTO `shop_order` VALUES (300, 1, 37, 0);
INSERT INTO `shop_order` VALUES (301, 1, 38, 0);
INSERT INTO `shop_order` VALUES (302, 2, 38, 0);
INSERT INTO `shop_order` VALUES (303, 3, 38, 0);
INSERT INTO `shop_order` VALUES (304, 5, 38, 0);
INSERT INTO `shop_order` VALUES (305, 1, 39, 0);
INSERT INTO `shop_order` VALUES (306, 2, 39, 0);
INSERT INTO `shop_order` VALUES (307, 3, 39, 0);
INSERT INTO `shop_order` VALUES (308, 5, 39, 0);
INSERT INTO `shop_order` VALUES (309, 1, 40, 0);
INSERT INTO `shop_order` VALUES (310, 2, 40, 0);
INSERT INTO `shop_order` VALUES (311, 3, 40, 0);
INSERT INTO `shop_order` VALUES (312, 5, 40, 0);
INSERT INTO `shop_order` VALUES (313, 3, 41, 0);
INSERT INTO `shop_order` VALUES (314, 5, 42, 0);
INSERT INTO `shop_order` VALUES (315, 1, 43, 0);
INSERT INTO `shop_order` VALUES (316, 6, 44, 0);
INSERT INTO `shop_order` VALUES (317, 5, 45, 0);
INSERT INTO `shop_order` VALUES (318, 6, 46, 0);
INSERT INTO `shop_order` VALUES (319, 6, 47, 0);
INSERT INTO `shop_order` VALUES (320, 6, 48, 0);
INSERT INTO `shop_order` VALUES (321, 6, 49, 0);
INSERT INTO `shop_order` VALUES (322, 6, 50, 0);
INSERT INTO `shop_order` VALUES (323, 6, 51, 0);
INSERT INTO `shop_order` VALUES (324, 6, 52, 0);
INSERT INTO `shop_order` VALUES (325, 6, 53, 0);
INSERT INTO `shop_order` VALUES (326, 6, 54, 0);
INSERT INTO `shop_order` VALUES (327, 6, 55, 0);
INSERT INTO `shop_order` VALUES (328, 6, 56, 0);
INSERT INTO `shop_order` VALUES (329, 6, 57, 0);
INSERT INTO `shop_order` VALUES (330, 2, 58, 0);
INSERT INTO `shop_order` VALUES (331, 5, 59, 0);
INSERT INTO `shop_order` VALUES (332, 3, 60, 0);
INSERT INTO `shop_order` VALUES (333, 3, 61, 0);
INSERT INTO `shop_order` VALUES (334, 5, 61, 0);
INSERT INTO `shop_order` VALUES (335, 5, 62, 0);
INSERT INTO `shop_order` VALUES (336, 1, 63, 0);
INSERT INTO `shop_order` VALUES (337, 3, 63, 0);
INSERT INTO `shop_order` VALUES (338, 1, 64, 0);
INSERT INTO `shop_order` VALUES (339, 3, 64, 0);
INSERT INTO `shop_order` VALUES (340, 1, 65, 0);
INSERT INTO `shop_order` VALUES (341, 3, 65, 0);
INSERT INTO `shop_order` VALUES (342, 1, 66, 0);
INSERT INTO `shop_order` VALUES (343, 1, 67, 0);

-- ----------------------------
-- Table structure for specs
-- ----------------------------
DROP TABLE IF EXISTS `specs`;
CREATE TABLE `specs`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `specs_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格名称',
  `pid` int(0) NULL DEFAULT NULL COMMENT '父id',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 177 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of specs
-- ----------------------------
INSERT INTO `specs` VALUES (1, '机型', 0, 1);
INSERT INTO `specs` VALUES (2, '4+32 GB', 1, 1);
INSERT INTO `specs` VALUES (3, '6+64 GB', 1, 2);
INSERT INTO `specs` VALUES (4, '8+128 GB', 1, 3);
INSERT INTO `specs` VALUES (5, '8+256 GB', 1, 4);
INSERT INTO `specs` VALUES (6, '配置', 0, 2);
INSERT INTO `specs` VALUES (7, 'i5+8G+512G', 6, 1);
INSERT INTO `specs` VALUES (8, 'i7+4G+512G', 6, 2);
INSERT INTO `specs` VALUES (9, 'i7+8G+1T', 6, 3);
INSERT INTO `specs` VALUES (10, '尺寸', 0, 3);
INSERT INTO `specs` VALUES (11, '150*150cm', 10, 1);
INSERT INTO `specs` VALUES (12, '200*200cm', 10, 2);
INSERT INTO `specs` VALUES (13, '数量', 0, 4);
INSERT INTO `specs` VALUES (14, '33朵', 13, 1);
INSERT INTO `specs` VALUES (15, '66朵', 13, 2);
INSERT INTO `specs` VALUES (16, '999朵', 13, 3);
INSERT INTO `specs` VALUES (17, '尺码', 0, 5);
INSERT INTO `specs` VALUES (18, 'm', 17, 1);
INSERT INTO `specs` VALUES (19, 'l', 17, 2);
INSERT INTO `specs` VALUES (20, 'xl', 17, 3);
INSERT INTO `specs` VALUES (21, 'xxl', 17, 4);
INSERT INTO `specs` VALUES (22, '种类', 0, 6);
INSERT INTO `specs` VALUES (23, '全脂奶粉', 22, 1);
INSERT INTO `specs` VALUES (24, '高钙奶粉', 22, 2);
INSERT INTO `specs` VALUES (25, '容量', 0, 7);
INSERT INTO `specs` VALUES (26, '800ml', 25, 1);
INSERT INTO `specs` VALUES (27, '1000ml', 25, 2);

-- ----------------------------
-- Table structure for specs_commodity
-- ----------------------------
DROP TABLE IF EXISTS `specs_commodity`;
CREATE TABLE `specs_commodity`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `commodity_id` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `specs_id` int(0) NULL DEFAULT NULL COMMENT '规格id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of specs_commodity
-- ----------------------------
INSERT INTO `specs_commodity` VALUES (1, 1, 1);
INSERT INTO `specs_commodity` VALUES (2, 2, 1);
INSERT INTO `specs_commodity` VALUES (3, 3, 1);
INSERT INTO `specs_commodity` VALUES (4, 4, 1);
INSERT INTO `specs_commodity` VALUES (5, 5, 1);
INSERT INTO `specs_commodity` VALUES (6, 6, 1);
INSERT INTO `specs_commodity` VALUES (7, 7, 1);
INSERT INTO `specs_commodity` VALUES (8, 8, 1);
INSERT INTO `specs_commodity` VALUES (9, 9, 1);
INSERT INTO `specs_commodity` VALUES (10, 10, 1);
INSERT INTO `specs_commodity` VALUES (11, 11, 1);
INSERT INTO `specs_commodity` VALUES (12, 12, 1);
INSERT INTO `specs_commodity` VALUES (13, 13, 1);
INSERT INTO `specs_commodity` VALUES (14, 14, 1);
INSERT INTO `specs_commodity` VALUES (15, 15, 1);
INSERT INTO `specs_commodity` VALUES (16, 16, 1);
INSERT INTO `specs_commodity` VALUES (17, 17, 1);
INSERT INTO `specs_commodity` VALUES (18, 18, 1);
INSERT INTO `specs_commodity` VALUES (19, 19, 1);
INSERT INTO `specs_commodity` VALUES (20, 20, 1);
INSERT INTO `specs_commodity` VALUES (21, 21, 1);
INSERT INTO `specs_commodity` VALUES (22, 22, 1);
INSERT INTO `specs_commodity` VALUES (23, 23, 1);
INSERT INTO `specs_commodity` VALUES (24, 24, 1);
INSERT INTO `specs_commodity` VALUES (25, 25, 1);
INSERT INTO `specs_commodity` VALUES (26, 26, 1);
INSERT INTO `specs_commodity` VALUES (27, 27, 1);
INSERT INTO `specs_commodity` VALUES (28, 28, 1);
INSERT INTO `specs_commodity` VALUES (29, 29, 1);
INSERT INTO `specs_commodity` VALUES (30, 30, 1);
INSERT INTO `specs_commodity` VALUES (31, 31, 1);
INSERT INTO `specs_commodity` VALUES (32, 32, 1);
INSERT INTO `specs_commodity` VALUES (33, 33, 1);
INSERT INTO `specs_commodity` VALUES (34, 34, 1);
INSERT INTO `specs_commodity` VALUES (35, 35, 1);
INSERT INTO `specs_commodity` VALUES (36, 36, 1);
INSERT INTO `specs_commodity` VALUES (37, 37, 1);
INSERT INTO `specs_commodity` VALUES (38, 38, 6);
INSERT INTO `specs_commodity` VALUES (39, 39, 6);
INSERT INTO `specs_commodity` VALUES (40, 40, 6);
INSERT INTO `specs_commodity` VALUES (41, 41, 6);
INSERT INTO `specs_commodity` VALUES (42, 42, 6);
INSERT INTO `specs_commodity` VALUES (43, 43, 6);
INSERT INTO `specs_commodity` VALUES (44, 44, 6);
INSERT INTO `specs_commodity` VALUES (45, 45, 6);
INSERT INTO `specs_commodity` VALUES (46, 46, 6);
INSERT INTO `specs_commodity` VALUES (47, 47, 6);
INSERT INTO `specs_commodity` VALUES (48, 48, 6);
INSERT INTO `specs_commodity` VALUES (49, 49, 6);
INSERT INTO `specs_commodity` VALUES (50, 50, 6);
INSERT INTO `specs_commodity` VALUES (51, 51, 6);
INSERT INTO `specs_commodity` VALUES (52, 52, 6);
INSERT INTO `specs_commodity` VALUES (53, 53, 6);
INSERT INTO `specs_commodity` VALUES (54, 54, 6);
INSERT INTO `specs_commodity` VALUES (55, 55, 10);
INSERT INTO `specs_commodity` VALUES (56, 56, 10);
INSERT INTO `specs_commodity` VALUES (57, 57, 10);
INSERT INTO `specs_commodity` VALUES (58, 58, 13);
INSERT INTO `specs_commodity` VALUES (59, 59, 13);
INSERT INTO `specs_commodity` VALUES (60, 60, 13);
INSERT INTO `specs_commodity` VALUES (61, 61, 13);
INSERT INTO `specs_commodity` VALUES (62, 62, 13);
INSERT INTO `specs_commodity` VALUES (63, 63, 13);
INSERT INTO `specs_commodity` VALUES (64, 64, 13);
INSERT INTO `specs_commodity` VALUES (65, 65, 13);
INSERT INTO `specs_commodity` VALUES (66, 66, 13);
INSERT INTO `specs_commodity` VALUES (67, 67, 17);
INSERT INTO `specs_commodity` VALUES (68, 68, 17);
INSERT INTO `specs_commodity` VALUES (69, 69, 17);
INSERT INTO `specs_commodity` VALUES (70, 70, 17);
INSERT INTO `specs_commodity` VALUES (71, 71, 17);
INSERT INTO `specs_commodity` VALUES (72, 72, 17);
INSERT INTO `specs_commodity` VALUES (73, 73, 17);
INSERT INTO `specs_commodity` VALUES (74, 74, 17);
INSERT INTO `specs_commodity` VALUES (75, 75, 17);
INSERT INTO `specs_commodity` VALUES (76, 76, 17);
INSERT INTO `specs_commodity` VALUES (77, 77, 17);
INSERT INTO `specs_commodity` VALUES (78, 78, 17);
INSERT INTO `specs_commodity` VALUES (79, 79, 22);
INSERT INTO `specs_commodity` VALUES (80, 80, 22);
INSERT INTO `specs_commodity` VALUES (81, 81, 25);
INSERT INTO `specs_commodity` VALUES (82, 82, 25);
INSERT INTO `specs_commodity` VALUES (83, 83, 17);
INSERT INTO `specs_commodity` VALUES (84, 84, 17);

-- ----------------------------
-- Table structure for system_manager
-- ----------------------------
DROP TABLE IF EXISTS `system_manager`;
CREATE TABLE `system_manager`  (
  `ID` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户真实姓名',
  `phone` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户手机号码',
  `age` int(0) NULL DEFAULT 18 COMMENT '用户年龄',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别',
  `pwd` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123' COMMENT '用户密码',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123' COMMENT '用户昵称',
  `user_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `birthday` date NULL DEFAULT NULL COMMENT '用户生日',
  `login_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123' COMMENT '登录账号',
  `role` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_manager
-- ----------------------------
INSERT INTO `system_manager` VALUES (1, '黄道明', '20190608001', 18, '男', '123', 'fastmanse', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-04', 'user1234567', '1', 0);
INSERT INTO `system_manager` VALUES (2, '张美琳', '18940409779', 21, '男', '123', '小红', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-05', 'user1234568', '1', 1);
INSERT INTO `system_manager` VALUES (3, '秦欢馨', '18940409780', 22, '女', '123', '小黄', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-06', 'user1234569', '1', 0);
INSERT INTO `system_manager` VALUES (4, '小绿', '18940409781', 23, '男', '123', '小绿', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-07', 'user1234570', '3', 0);
INSERT INTO `system_manager` VALUES (5, '张浩', '18940409782', 18, '女', '123', '张浩', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-19', 'user1234571', '2', 0);
INSERT INTO `system_manager` VALUES (6, '李昊佳', '18940409783', 19, '男', '123', '李昊佳', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-12', 'user1234572', '1', 0);
INSERT INTO `system_manager` VALUES (7, '王低都', '18940409784', 20, '男', '123', '王低都', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-18', 'user1234573', '2', 0);
INSERT INTO `system_manager` VALUES (8, '邱君', '18940409785', 21, '女', '123', '邱君', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-11', 'user1234574', '3', 0);
INSERT INTO `system_manager` VALUES (9, '夏之光', '18940409786', 22, '男', '123', '瞎逛', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-12', 'user1234575', '3', 0);
INSERT INTO `system_manager` VALUES (10, '赵磊', '18940409787', 18, '女', '123', '磊哥', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-13', 'user1234576', '2', 0);
INSERT INTO `system_manager` VALUES (11, '焉诩嘉', '18940409788', 19, '女', '123', '旺仔', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-14', 'user1234577', '1', 0);
INSERT INTO `system_manager` VALUES (12, '任豪', '18940409789', 20, '男', '123', '郝总', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-15', 'user1234578', '1', 0);
INSERT INTO `system_manager` VALUES (13, '王境泽', '18940409790', 21, '男', '123', '王敬则', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-16', 'user1234579', '1', 0);
INSERT INTO `system_manager` VALUES (14, '亦匡新', '18940409791', 22, '女', '123', '公孙新', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-17', 'user1234580', '2', 0);
INSERT INTO `system_manager` VALUES (15, '刘爆发', '18940409792', 23, '男', '123', '爆爆', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-18', 'user1234581', '2', 0);
INSERT INTO `system_manager` VALUES (16, '朱朝阳', '18940409793', 24, '男', '123', '还行', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-19', 'user1234582', '1', 0);
INSERT INTO `system_manager` VALUES (17, '大徐', '18940409794', 24, '男', '123', '徐总', 'http://image.yy.com/yywebalbumbs2bucket/144152f8680f421599233c6ffcfcef49_1476265267104.jpeg', '2000-01-19', 'user1234582', '1', 0);

-- ----------------------------
-- Table structure for system_manager_authority
-- ----------------------------
DROP TABLE IF EXISTS `system_manager_authority`;
CREATE TABLE `system_manager_authority`  (
  `systm_manager` int(0) NOT NULL COMMENT '系统管理员ID',
  `authority` int(0) NOT NULL COMMENT '权限ID',
  `shop_manager` int(11) UNSIGNED ZEROFILL NOT NULL COMMENT '店铺管理员ID',
  `time` datetime(0) NOT NULL COMMENT '修改时间',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`systm_manager`, `authority`, `shop_manager`, `time`) USING BTREE,
  INDEX `authority`(`authority`) USING BTREE,
  CONSTRAINT `system_manager_authority_ibfk_2` FOREIGN KEY (`authority`) REFERENCES `authority` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `system_manager_authority_ibfk_3` FOREIGN KEY (`systm_manager`) REFERENCES `system_manager` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统管理员权限修改记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_manager_authority
-- ----------------------------
INSERT INTO `system_manager_authority` VALUES (1, 2, 00000000002, '2020-06-23 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 2, 00000000003, '2020-06-23 15:53:08', 0);
INSERT INTO `system_manager_authority` VALUES (1, 2, 00000000004, '2020-06-25 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 2, 00000000005, '2020-06-26 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 2, 00000000006, '2020-06-27 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 2, 00000000007, '2020-06-28 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 3, 00000000003, '2020-06-24 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 4, 00000000001, '2020-06-29 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 4, 00000000002, '2020-06-30 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 4, 00000000003, '2020-07-01 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 4, 00000000004, '2020-07-02 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (1, 4, 00000000005, '2020-07-03 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (2, 4, 00000000005, '2020-07-08 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (2, 4, 00000000006, '2020-07-09 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (2, 4, 00000000007, '2020-07-05 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (2, 4, 00000000008, '2020-07-06 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (2, 4, 00000000009, '2020-07-07 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (2, 5, 00000000006, '2020-07-04 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (2, 5, 00000000007, '2020-07-10 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (3, 3, 00000000001, '2020-06-29 15:53:09', 0);
INSERT INTO `system_manager_authority` VALUES (3, 4, 00000000001, '2020-07-12 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (3, 4, 00000000003, '2020-07-14 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (3, 4, 00000000008, '2020-07-11 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (3, 5, 00000000001, '2020-06-29 15:53:08', 0);
INSERT INTO `system_manager_authority` VALUES (3, 5, 00000000002, '2020-07-13 15:53:07', 0);
INSERT INTO `system_manager_authority` VALUES (3, 5, 00000000004, '2020-07-15 15:53:07', 0);

-- ----------------------------
-- Table structure for taobao
-- ----------------------------
DROP TABLE IF EXISTS `taobao`;
CREATE TABLE `taobao`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `peopleNum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 377 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of taobao
-- ----------------------------
INSERT INTO `taobao` VALUES (330, 'K-Touch/天语X11S升降摄像头迷你智能机卡片小手机全网通4G袖珍学生男女超小全面屏小屏备用正品抖音网红款', '699.00', '48人付款');
INSERT INTO `taobao` VALUES (331, '至高减50元当天发货3期免息】红米10X 4G版Xiaomi/小米Redmi 10X手机新品官方旗舰店9红米10pro小米10xpr', '999.00', '2021人付款');
INSERT INTO `taobao` VALUES (332, '全新Apple/苹果 iPhone7 Plus国行正品4G全网通苹果7plus 7p手机', '1810.00', '1087人付款');
INSERT INTO `taobao` VALUES (333, 'Apple/苹果 iPhone 8 Plus全新苹果8正品8x国行三网苹果8plus手机', '1850.00', '649人付款');
INSERT INTO `taobao` VALUES (334, 'Apple/苹果 iPhone X 苹果x 苹果8手机 iphone8plus 苹果Xr xsmax', '1850.00', '3662人付款');
INSERT INTO `taobao` VALUES (335, 'Apple/苹果 iPhone 7 Plus 国行正品苹果7plus全新7P全网通4G手机', '1230.00', '1135人付款');
INSERT INTO `taobao` VALUES (336, '【分期免息】Apple/苹果 iPhone 7 Plus 全新7代国行全网通4G手机', '1270.00', '1346人付款');
INSERT INTO `taobao` VALUES (337, '分期免息Apple/苹果 iPhone 7 Plus国行7代全新4G全网通5.5寸手机', '1200.00', '1075人付款');
INSERT INTO `taobao` VALUES (338, '【分期免息】Apple/苹果 iPhone XR 苹果X 全新苹果XS Max手机8x', '1850.00', '233人付款');
INSERT INTO `taobao` VALUES (339, '分期免息Apple/苹果 iPhone XR 苹果XS Max iPhoneXR国行8x手机', '2000.00', '719人付款');
INSERT INTO `taobao` VALUES (340, 'Apple/苹果 iPhone 8 Plus全新苹果8正品8x国行三网苹果8plus手机', '1850.00', '634人付款');
INSERT INTO `taobao` VALUES (341, 'Apple/苹果 iPhone 8 Plus全新苹果8正品X国行5.5寸苹果8plus手机', '2250.00', '485人付款');
INSERT INTO `taobao` VALUES (342, '分期免息 Apple/苹果 iPhone 8 Plus 国行正品全网通苹果8代手机', '1850.00', '571人付款');
INSERT INTO `taobao` VALUES (343, 'Apple/苹果 iPhone 7 Plus国行5.5寸全新正品苹果7代全网通4G手机', '1250.00', '376人付款');
INSERT INTO `taobao` VALUES (344, '分期免息Apple/苹果 iPhone XR 全网通4G国行苹果xr xs max手机8x', '3150.00', '985人付款');
INSERT INTO `taobao` VALUES (345, '【0首付分期】Apple/苹果 iPhone 8 Plus 4G正品8代苹果8p手机', '2100.00', '870人付款');
INSERT INTO `taobao` VALUES (346, 'Apple/苹果 iPhone 8 Plus全新苹果8正品8x国行三网苹果8plus手机', '1800.00', '929人付款');
INSERT INTO `taobao` VALUES (347, '分期免息Apple/苹果 iPhone XR 国行双卡xs max全网通4G手机8x', '2970.00', '519人付款');
INSERT INTO `taobao` VALUES (348, 'Apple/苹果 iPhone 8 Plus全新苹果8正品国行三网苹果8plus手机8x', '1900.00', '1030人付款');
INSERT INTO `taobao` VALUES (349, '分期Apple/苹果 iPhone XS Max国行xs苹果xr双卡全网通8x手机', '2970.00', '819人付款');
INSERT INTO `taobao` VALUES (350, '分期Apple/苹果 iPhone 8 Plus全新苹果8正品三网通国行4.7寸手机', '1780.00', '1367人付款');
INSERT INTO `taobao` VALUES (351, 'Apple/苹果 iPhone 8 Plus苹果8全新正品国行苹果8plus全网通手机', '1820.00', '249人付款');
INSERT INTO `taobao` VALUES (352, '【12期免息 至高省700】红米k30pro 骁龙865索尼6400万智能游戏学生5g手机redmi小米官方旗舰店正品xiaomi', '2699.00', '3.0万+人付款');
INSERT INTO `taobao` VALUES (353, 'DOOV/朵唯 M30千元手机水滴全面屏安卓智能电信全网通学生价游戏', '789.00', '2326人付款');
INSERT INTO `taobao` VALUES (354, '【千玺粉丝日享6期免息+50优惠券】Huawei/华为nova7 SE5G超级快充40W 5g智能华为华为官方旗舰店', '2399.00', '5.5万+人付款');
INSERT INTO `taobao` VALUES (355, '【官网价直降900】Apple/苹果 iPhone 11 4G全网通智能手机正品苏宁易购官方旗舰店苹果11', '4999.00', '5.0万+人付款');
INSERT INTO `taobao` VALUES (356, '【12期分期/领300元券】华为荣耀30S 5G手机全网通华为手机正品官方旗舰华为x10荣耀30pro直降4tptro青春版', '2399.00', '2875人付款');
INSERT INTO `taobao` VALUES (357, '分期免息Apple/苹果 iPhone 8 Plus 8代国行三网通4G正品8x手机', '1850.00', '423人付款');
INSERT INTO `taobao` VALUES (358, '百亿补贴Xiaomi/小米红米note8手机redmi note8官方旗舰正品手机', '999.00', '4337人付款');
INSERT INTO `taobao` VALUES (359, '分期免息Apple/苹果 iPhone 11国行手机 苹果11 promax 苹果11pro', '4400.00', '177人付款');
INSERT INTO `taobao` VALUES (360, 'Apple/苹果 iPhone XS Max苹果xs全新全网通国行iphone xr手机8x', '1750.00', '1738人付款');
INSERT INTO `taobao` VALUES (361, '【限量疯抢】HUAWEI/华为Mate30 8+128GB 全网通4G智能手机麒麟990徕卡拍照旗舰官方正品', '3599.00', '4870人付款');
INSERT INTO `taobao` VALUES (362, '全新Apple/苹果 iPhone7 Plus国行正品苹果7plus全网通4G手机', '1250.00', '196人付款');
INSERT INTO `taobao` VALUES (363, '【千玺粉丝日享6期免息+50优惠券】Huawei/华为nova7 5G全面屏6400万麒麟985华为5g华为官方旗舰店', '2999.00', '4.0万+人付款');
INSERT INTO `taobao` VALUES (364, '全新Aplple/iphone特别版苹果7手机7plus国行iphone8 plus全新8p', '1150.00', '3563人付款');
INSERT INTO `taobao` VALUES (365, 'vjvj K3学生价水滴全面屏游戏安卓全网通4G电信大屏智能手机正品', '368.00', '1233人付款');
INSERT INTO `taobao` VALUES (366, 'Apple/苹果 iPhone 7 Plus全新国行正品4G全网通苹果7plus 7P手机', '1250.00', '1167人付款');
INSERT INTO `taobao` VALUES (367, 'Apple/苹果 iPhone 7 Plus 苹果7plus国行全网通7代5.5英寸手机7p', '1250.00', '310人付款');
INSERT INTO `taobao` VALUES (368, '【至高省110享6期免息】vivo iQOO Neo3高通骁龙865处理器5g游戏学生手机vivoiqooneo3 vivo新iqoo限量版', '2698.00', '1.0万+人付款');
INSERT INTO `taobao` VALUES (369, 'Apple/苹果 iPhone 8 Plus全新苹果8代国行正品8plus全网通4G手机', '1750.00', '1884人付款');
INSERT INTO `taobao` VALUES (370, '【新版热卖】 红米K30i 双模5G新品手机4800万旗舰拍照学生老年智能机30pro全面屏xiaomi小米官方旗舰店10', '1499.00', '2.5万+人付款');
INSERT INTO `taobao` VALUES (371, 'Apple/苹果 iPhone XR 国行苹果x 苹果xs max全新iphonexr手机8x', '1660.00', '1326人付款');
INSERT INTO `taobao` VALUES (372, 'Apple/苹果X国行8plus苹果手机iphone X全新iphone8 plus美版8p', '1750.00', '2293人付款');
INSERT INTO `taobao` VALUES (373, '【分期免息】Apple/苹果 iPhone X 原装正品国行 苹果x手机 256G', '2899.00', '1197人付款');
INSERT INTO `taobao` VALUES (374, '分期免息 Apple/苹果 iPhone X 苹果x全新国行 苹果xr xs max手机', '2990.00', '1073人付款');
INSERT INTO `taobao` VALUES (375, '【分期免息】Apple/苹果 iPhone XS Max全新X国行XR全网通xs手机', '1800.00', '6000+人付款');
INSERT INTO `taobao` VALUES (376, '【百亿补贴】Huawei/华为nova 6 5G麒麟990芯片广角双摄学生机正品手机nova7prose', '3499.00', '1048人付款');

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '钱包的自增id唯一',
  `customer_id` int(0) NOT NULL COMMENT '钱包对应的顾客id',
  `money_amount` double(20, 2) NOT NULL COMMENT '钱包余额',
  `wallet_pwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '钱包的二级保护密码',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '字段有效标志，0表示有效，1表示已经删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cutomer_id`(`customer_id`) USING BTREE,
  CONSTRAINT `wallet_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '顾客的钱包，其中关联顾客id；账单id->查看账单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet
-- ----------------------------
INSERT INTO `wallet` VALUES (1, 1, 9991014.26, NULL, 0);
INSERT INTO `wallet` VALUES (2, 2, 100000000000.00, 'password2', 0);
INSERT INTO `wallet` VALUES (3, 3, 10100000000.00, NULL, 0);
INSERT INTO `wallet` VALUES (4, 4, 9999997800.04, NULL, 0);
INSERT INTO `wallet` VALUES (5, 5, 10000000000000000.00, NULL, 0);
INSERT INTO `wallet` VALUES (6, 6, 2010000000.00, NULL, 0);
INSERT INTO `wallet` VALUES (7, 7, 20000000000.00, NULL, 0);
INSERT INTO `wallet` VALUES (8, 8, 25.00, NULL, 0);
INSERT INTO `wallet` VALUES (9, 9, 784.00, NULL, 0);
INSERT INTO `wallet` VALUES (10, 10, 201.00, NULL, 0);
INSERT INTO `wallet` VALUES (11, 11, 39.00, NULL, 0);
INSERT INTO `wallet` VALUES (12, 12, 44.00, NULL, 0);
INSERT INTO `wallet` VALUES (13, 13, 2.00, NULL, 0);
INSERT INTO `wallet` VALUES (14, 14, 4.00, NULL, 0);
INSERT INTO `wallet` VALUES (15, 15, 7.00, NULL, 0);
INSERT INTO `wallet` VALUES (16, 16, 8.00, NULL, 0);
INSERT INTO `wallet` VALUES (17, 17, 14.00, NULL, 0);
INSERT INTO `wallet` VALUES (18, 18, 128.00, NULL, 0);
INSERT INTO `wallet` VALUES (19, 19, 1.00, NULL, 0);
INSERT INTO `wallet` VALUES (20, 20, 16.00, NULL, 0);

-- ----------------------------
-- Table structure for wallet_bill
-- ----------------------------
DROP TABLE IF EXISTS `wallet_bill`;
CREATE TABLE `wallet_bill`  (
  `wallet_id` int(0) NOT NULL COMMENT '钱包id',
  `bill_id` int(0) NOT NULL COMMENT '账单id',
  `is_delete` int(0) NOT NULL DEFAULT 0 COMMENT '删除标记',
  INDEX `wallet_id`(`wallet_id`) USING BTREE,
  INDEX `bill_id`(`bill_id`) USING BTREE,
  CONSTRAINT `wallet_bill_ibfk_1` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `wallet_bill_ibfk_2` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '钱包账单对照表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wallet_bill
-- ----------------------------
INSERT INTO `wallet_bill` VALUES (1, 1, 0);
INSERT INTO `wallet_bill` VALUES (1, 2, 0);
INSERT INTO `wallet_bill` VALUES (1, 3, 0);
INSERT INTO `wallet_bill` VALUES (2, 4, 0);
INSERT INTO `wallet_bill` VALUES (3, 5, 0);
INSERT INTO `wallet_bill` VALUES (3, 6, 0);
INSERT INTO `wallet_bill` VALUES (4, 7, 0);
INSERT INTO `wallet_bill` VALUES (5, 8, 0);
INSERT INTO `wallet_bill` VALUES (5, 9, 0);
INSERT INTO `wallet_bill` VALUES (6, 10, 0);
INSERT INTO `wallet_bill` VALUES (7, 11, 0);
INSERT INTO `wallet_bill` VALUES (8, 12, 0);
INSERT INTO `wallet_bill` VALUES (8, 13, 0);
INSERT INTO `wallet_bill` VALUES (8, 14, 0);
INSERT INTO `wallet_bill` VALUES (9, 15, 0);
INSERT INTO `wallet_bill` VALUES (10, 16, 0);
INSERT INTO `wallet_bill` VALUES (11, 17, 0);
INSERT INTO `wallet_bill` VALUES (12, 18, 0);
INSERT INTO `wallet_bill` VALUES (12, 19, 0);
INSERT INTO `wallet_bill` VALUES (13, 20, 0);
INSERT INTO `wallet_bill` VALUES (14, 21, 0);
INSERT INTO `wallet_bill` VALUES (15, 22, 0);
INSERT INTO `wallet_bill` VALUES (15, 23, 0);
INSERT INTO `wallet_bill` VALUES (15, 24, 0);
INSERT INTO `wallet_bill` VALUES (16, 25, 0);
INSERT INTO `wallet_bill` VALUES (16, 26, 0);
INSERT INTO `wallet_bill` VALUES (17, 27, 0);
INSERT INTO `wallet_bill` VALUES (18, 28, 0);
INSERT INTO `wallet_bill` VALUES (19, 29, 0);
INSERT INTO `wallet_bill` VALUES (1, 46, 0);
INSERT INTO `wallet_bill` VALUES (0, 47, 0);
INSERT INTO `wallet_bill` VALUES (0, 48, 0);
INSERT INTO `wallet_bill` VALUES (0, 49, 0);
INSERT INTO `wallet_bill` VALUES (0, 50, 0);
INSERT INTO `wallet_bill` VALUES (1, 51, 0);
INSERT INTO `wallet_bill` VALUES (1, 52, 0);
INSERT INTO `wallet_bill` VALUES (1, 53, 0);
INSERT INTO `wallet_bill` VALUES (1, 54, 0);
INSERT INTO `wallet_bill` VALUES (1, 55, 0);
INSERT INTO `wallet_bill` VALUES (4, 56, 0);
INSERT INTO `wallet_bill` VALUES (0, 57, 0);
INSERT INTO `wallet_bill` VALUES (1, 58, 0);
INSERT INTO `wallet_bill` VALUES (1, 59, 0);

SET FOREIGN_KEY_CHECKS = 1;
