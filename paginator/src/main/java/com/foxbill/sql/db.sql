/*
Navicat MySQL Data Transfer
Date: 2019-12-24 15:21:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` varchar(200) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` double DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1001', 'java编程思想', '98', '100', '计算机');
INSERT INTO `books` VALUES ('1002', '西游记', '10', '50', '文学');
INSERT INTO `books` VALUES ('1003', '九阴真经', '20', '30', '武侠');
INSERT INTO `books` VALUES ('1004', '365夜睡前好故事', '19.8', '50', '少儿');
INSERT INTO `books` VALUES ('1006', '三只小猪', '9.8', '50', '少儿');
INSERT INTO `books` VALUES ('1007', '中华上下五千年', '28', '100', '少儿');
INSERT INTO `books` VALUES ('1008', '三国演义', '9.8', '50', '文学');
