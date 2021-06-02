/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2020-12-31 15:25:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- 打开test数据库
use test;

-- ----------------------------
-- Table structure for t_content
-- ----------------------------
DROP TABLE IF EXISTS `t_content`;
CREATE TABLE `t_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_content
-- ----------------------------
INSERT INTO `t_content` VALUES ('1', '<p>斯蒂芬斯蒂芬</p>\r\n');
INSERT INTO `t_content` VALUES ('2', '<p style=\"text-align: center;\"><strong>地方</strong></p>\r\n\r\n<p>发郭德纲的双方各三等功分公司的分公司电饭锅对方水电费水电费骄傲肯德基付款垃圾袋风口浪尖奥斯卡砥砺奋进卡拉三等奖弗兰克。</p>\r\n\r\n<p><img alt=\"smiley\" src=\"http://localhost:8088/richTextEditor/ckeditor/plugins/smiley/images/regular_smile.png\" style=\"height:23px; width:23px\" title=\"smiley\" /></p>\r\n\r\n<ol>\r\n	<li>防守打法</li>\r\n	<li>dfsdf</li>\r\n	<li>佛挡杀佛</li>\r\n	<li>佛挡杀佛</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n');
INSERT INTO `t_content` VALUES ('8', '<p>胜多负少</p>\r\n\r\n<p><img alt=\"\" src=\"/richTextEditor/img/uploadImg/25a31d67-36f7-45aa-a3b4-30cea52c378b_Penguins.jpg\" style=\"height:188px; width:250px\" /><input type=\"text\" /></p>\r\n');
INSERT INTO `t_content` VALUES ('9', '<p style=\"text-align:center\"><span style=\"font-size:16px\"><strong>法国华商戴安友：对中国制造业未来发展非常期待</strong></span></p>\r\n\r\n<p style=\"text-align:center\"><span style=\"background-color:rgb(248, 248, 249); color:rgb(153, 153, 153); font-family:arial; font-size:12px\">发布时间：12-31</span><span style=\"background-color:rgb(248, 248, 249); color:rgb(153, 153, 153); font-family:arial; font-size:12px\">14:36</span><span style=\"background-color:rgb(248, 248, 249); color:rgb(153, 153, 153); font-family:arial; font-size:12px\">中国新闻社旗下财经媒体</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:justify\">中新经纬客户端12月31日电 (赵佳然)回顾即将过去的2020年，法国法华工商联合会会长戴安友在接受中新经纬客户端专访时表示，虽然进出口、餐饮等行业受影响十分明显，但自己并未丧失信心，还计划着寻找新的商业机遇。与此同时，他在中国的工厂已全面复工，年度销售额甚至同比增长了三成。</p>\r\n\r\n<p style=\"text-align:justify\">谈及对2021年的预测与期许，戴安友称，对中国制造业的未来比较看好，相信在有效的疫情防控下，制造业也将迎来良好的发展机遇，将做到&ldquo;危中有机&rdquo;。</p>\r\n\r\n<p style=\"text-align:justify\"><img alt=\"\" src=\"/richTextEditor/img/uploadImg/f2c95cac-5d24-4137-8126-5e2b142e6b13_1.jpeg\" style=\"height:415px; width:640px\" /></p>\r\n\r\n<p style=\"text-align:justify\"><span style=\"font-family:arial; font-size:16px\">法国法华工商联合会向中国捐赠的防疫物资，左一为戴安友。受访者供图</span></p>\r\n\r\n<p style=\"text-align:justify\">&nbsp;</p>\r\n\r\n<p style=\"text-align:justify\"><strong>进出口、餐饮与旅游受影响明显</strong></p>\r\n\r\n<p style=\"text-align:justify\">戴安友介绍道，华人在法国从事的行业多为进出口贸易、餐饮与旅游，而这三个领域在疫情期间受影响均较大。</p>\r\n\r\n<p style=\"text-align:justify\">&ldquo;小餐馆还可以靠外卖业务平衡一下，但较大的餐馆平时主要收入来源为婚庆、公司聚餐等集体项目。我在巴黎开的一家餐馆，从1月到现在都还在停业。中餐馆接待的客人大多为中国人，就算营业，顾客也非常少。不过，企业可以帮员工申请到法国政府补贴，员工的生活还有保障。&rdquo;戴安友表示，自己开的餐馆平时最多可容纳600-700人左右，在这段停业的日子，他每个月还需支付超过3万欧元的房租，一年花费合30多万欧元的支出。&ldquo;我们大多有积攒资金的习惯，尽管没有开工，但生活还是不成问题的。&rdquo;戴安友说。</p>\r\n\r\n<p style=\"text-align:justify\">然而，也有一些行业在疫情中寻得了机会。&ldquo;我儿子在法国开了家香烟店，今年香烟的销售额反而比之前更高，也许是人们居家时间变长的缘故。&rdquo;戴安友说。</p>\r\n\r\n<p style=\"text-align:justify\">除却在法国的生意之外，戴安友在中国从事制造业，公司主要业务为生产平压机、切纸机等器械。2020年2月底，戴安友回到中国工厂所在的浙江丽水，准备企业复工复产。&ldquo;部分员工身处湖北，到岗较晚，我们在4月左右基本恢复生产和中国国内的销售。出口东南亚的贸易受到了物流影响，但总体来讲影响不大。&rdquo;戴安友说。</p>\r\n\r\n<p style=\"text-align:justify\">戴安友介绍道，由于中国疫情防控效果好，加之政府给予了一定的优惠政策，他在中国国内工厂的运营情况比2019年还要好，年销售额同比提升约30%。</p>\r\n\r\n<p style=\"text-align:justify\"><strong>&ldquo;疫情期间也危中有机&rdquo;</strong></p>\r\n\r\n<p style=\"text-align:justify\">2020年下半年，戴安友大部分的时间都在中国处理工厂业务。他在法国的华商朋友有些留在当地等待时机复工，也有些选择回到中国开展事业。</p>\r\n\r\n<p style=\"text-align:justify\">&ldquo;我的一位朋友便是在今年选择放弃在法国的生意，携家人回中国定居。现在已经回中国几个月了，安顿好孩子的学校等事宜后，如何开展新的工作还在筹划当中。&rdquo;戴安友表示，虽然许多华商与中国关联密切，但也有不少&ldquo;华二代&rdquo;&ldquo;华三代&rdquo;的交际圈几乎全部在国外，若想回到中国定居还需时间上的过渡。</p>\r\n\r\n<p style=\"text-align:justify\">戴安友称，自己会在2021年春节后与留在法国的家人重聚，同时也计划寻求新的投资机会。&ldquo;以餐厅为例，除了中餐馆外，许多其他餐馆也面临长久不能开工的境况，甚至濒临破产。在持有一定资金的前提下，我们可以考虑以低价购买别家餐厅的经营权，等到恢复运营时，这便是扩大经营、提高利润的好机会。&rdquo;</p>\r\n\r\n<p style=\"text-align:justify\">提及2021年中国制造业的未来发展前景，戴安友表示，相信自己工厂的效益还会继续提升，从行业来讲也较为看好。</p>\r\n\r\n<p style=\"text-align:justify\">&ldquo;由于我们的工厂在缴税及购买设备时均能够享受相关优惠政策，我们便在拓展运营的同时更新设备，将生产自动化、智能化进一步提高，从而提升生产力，提高企业竞争力。&rdquo;戴安友表示，在优惠政策的帮助下，能感受到中国制造业目前处于良性循环。</p>\r\n\r\n<p style=\"text-align:justify\">&ldquo;现在来看，中国国内疫情防控得当，一定程度上国内制造业也相对得到了很大的发展机会。虽然疫情还在继续，但危中有机，我对未来制造业的发展非常期待。&rdquo;他笑着说。(中新经纬APP)</p>\r\n\r\n<p style=\"text-align:justify\"><strong>　中新经纬版权所有，未经书面授权，任何单位及个人不得转载、摘编或以其它方式使用。</strong></p>\r\n\r\n<p>&nbsp;</p>\r\n');
