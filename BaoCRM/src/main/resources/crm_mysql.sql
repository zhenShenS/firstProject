/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2018-03-14 16:04:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cst_activity
-- ----------------------------
DROP TABLE IF EXISTS `cst_activity`;
CREATE TABLE `cst_activity` (
  `atv_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '交往记录编号',
  `atv_cust_no` char(50) NOT NULL COMMENT '客户号',
  `atv_cust_name` varchar(100) DEFAULT NULL COMMENT '客户姓名',
  `atv_place` varchar(200) DEFAULT NULL COMMENT '交往地点',
  `atv_title` varchar(500) DEFAULT NULL COMMENT '概要',
  `atv_desc` varchar(1000) DEFAULT NULL COMMENT '备注',
  `atv_cust_id` bigint(20) DEFAULT NULL COMMENT '客户编号',
  PRIMARY KEY (`atv_id`),
  KEY `atv_cust_id_for` (`atv_cust_id`),
  CONSTRAINT `atv_cust_id_for` FOREIGN KEY (`atv_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_activity
-- ----------------------------
INSERT INTO `cst_activity` VALUES ('1', '1', 'briup', '陆家嘴银城中路68号', '售后服务', '还没有付钱！', '1');
INSERT INTO `cst_activity` VALUES ('2', '2', 'tom', '马鞍山中路', '售前咨询', '成功', '1');
INSERT INTO `cst_activity` VALUES ('5', '8', null, '昆山', 'kkk', '还没有付钱！!', null);
INSERT INTO `cst_activity` VALUES ('6', '1', 'briup', '怀化学院计算系', '水机', '未付款', null);
INSERT INTO `cst_activity` VALUES ('7', '1', 'briup', '湘南学院计算机系', '手机·', '你好呀', null);
INSERT INTO `cst_activity` VALUES ('8', '1', 'briup', '江西理工', '路晨', '付钱', null);

-- ----------------------------
-- Table structure for cst_customer
-- ----------------------------
DROP TABLE IF EXISTS `cst_customer`;
CREATE TABLE `cst_customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `cust_no` varchar(50) DEFAULT NULL COMMENT '客户号',
  `cust_name` varchar(100) DEFAULT NULL COMMENT '客户姓名',
  `cust_region` varchar(50) DEFAULT NULL COMMENT '客户区域',
  `cust_manager_id` bigint(20) DEFAULT NULL COMMENT '客户经理编号',
  `cust_manager_name` varchar(50) DEFAULT NULL COMMENT '客户经理姓名',
  `cust_level` int(11) DEFAULT NULL COMMENT '客户等级',
  `cust_level_label` varchar(50) DEFAULT NULL COMMENT '客户等级描述',
  `cust_satisfy` int(11) DEFAULT NULL COMMENT '客户满意度',
  `cust_credit` int(11) DEFAULT NULL COMMENT '客户信誉度',
  `cust_addr` varchar(300) DEFAULT NULL COMMENT '客户地址',
  `cust_zip` char(10) DEFAULT NULL COMMENT '客户邮编',
  `cust_tel` varchar(50) DEFAULT NULL COMMENT '客户电话',
  `cust_fax` varchar(50) DEFAULT NULL COMMENT '客户传真',
  `cust_website` varchar(50) DEFAULT NULL COMMENT '网址',
  `cust_licence_no` varchar(100) DEFAULT NULL COMMENT '营业执照注册号',
  `cust_chieftain` varchar(50) DEFAULT NULL COMMENT '法人',
  `cust_bankroll` float(100,0) DEFAULT NULL COMMENT '注册资金',
  `cust_turnover` float(100,0) DEFAULT NULL COMMENT '年营业额',
  `cust_bank` varchar(200) DEFAULT NULL COMMENT '开户行',
  `cust_bank_account` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `cust_local_tax_no` varchar(50) DEFAULT NULL COMMENT '地税登记号',
  `cust_national_tax_no` varchar(100) DEFAULT NULL COMMENT '国税登记号',
  `cust_status` char(2) DEFAULT NULL COMMENT '客户状态',
  PRIMARY KEY (`cust_id`),
  KEY `cust_id` (`cust_id`),
  KEY `cust_name` (`cust_name`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_customer
-- ----------------------------
INSERT INTO `cst_customer` VALUES ('1', '1', 'briup', '北京', '4', 'jingli', '0', '普通客户', '3', '3', '昆山', '226400', '1316038888', '123qwqwq', '129@qq.com', '1234567', 'zhangsan', '20', '30', '工商', '111', '333', '123', '1');
INSERT INTO `cst_customer` VALUES ('2', '2', 'tom', '东北', '5', 'lili', '0', '普通客户', '3', '3', '北京', '226000', '12160388888', '123qwqw', '123@qq.com', '', '', '0', '0', '', '', '', '', '1');
INSERT INTO `cst_customer` VALUES ('3', '3', 'sun', '华北', '5', 'lili', '0', '普通客户', '3', '3', '北京', '226000', '11160388888', '123qwqw', '123@qq.com', '', '', '0', '0', '', '', '', '', '1');
INSERT INTO `cst_customer` VALUES ('4', '4', 'hua', '华北', '4', 'jingli', '0', '大客户', '3', '3', '华北', '226400', '132423432', '56ggsre3', '298@163.com', '3423', 'ls', '30', '20', '农行', '333', '222', '111', '1');
INSERT INTO `cst_customer` VALUES ('5', '5', 'mi', '华北', '4', 'jingli', '1', '重点开发客户', '2', '3', '华北', '229400', '189423432', '56ggsre3', '298@163.com', '3423', 'ls', '30', '20', '农行', '333', '222', '111', '1');
INSERT INTO `cst_customer` VALUES ('6', '6', 'test', '北京', null, 'jingli', '0', '普通客户', '3', '3', '中南', '12845', '12845', '1212qwqa', 'baidu.com', 'fshfja', 'zhangsan', '45', '50', '建设银行', '123456', '789456', '4585', '1');
INSERT INTO `cst_customer` VALUES ('15', '7', 'briup11', '华北', null, 'jingli', '0', '普通客户', '3', '3', '上海某某街道', '222', '777', '222', '123@briup.', '111', 'lisi', '11', '21', '农业', '444', '123', '22', '�');
INSERT INTO `cst_customer` VALUES ('16', '556', '路晨', '中南', null, 'jingli', null, '合作伙伴', '2', '5', '我的天', '11321', '123131313', '123123131', 'www.baidu.com', '', '路晨', null, null, '中国工商银行', '2342142847128947197419', '', '', null);

-- ----------------------------
-- Table structure for cst_linkman
-- ----------------------------
DROP TABLE IF EXISTS `cst_linkman`;
CREATE TABLE `cst_linkman` (
  `lkm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '联系人编号',
  `lkm_cust_id` bigint(20) DEFAULT NULL COMMENT '客户编号',
  `lkm_cust_no` varchar(50) DEFAULT NULL COMMENT '客户号',
  `lkm_cust_name` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `lkm_name` varchar(100) DEFAULT NULL COMMENT '联系人名字',
  `lkm_sex` varchar(10) DEFAULT NULL COMMENT '联系人地点',
  `lkm_postion` varchar(100) DEFAULT NULL COMMENT '地点',
  `lkm_tel` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `lkm_mobile` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `lkm_memo` varchar(600) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`lkm_id`),
  KEY `lkm_cust_id_for` (`lkm_cust_id`),
  CONSTRAINT `lkm_cust_id_for` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_linkman
-- ----------------------------
INSERT INTO `cst_linkman` VALUES ('1', '1', '1', 'briup', 'san', '女', '客服经理', '123456', '123465', '干什么');
INSERT INTO `cst_linkman` VALUES ('2', '1', '1', 'briup', 'san', '男', '客服经理', '123456', '234567', '干啥');
INSERT INTO `cst_linkman` VALUES ('3', '2', '2', 'tom', 'jack', '女', '主管', '0123', '13356845952', '好美丽');
INSERT INTO `cst_linkman` VALUES ('4', '2', '2', 'tom', 'san', '男', '主任', '045678', '183647895', '张三张三');
INSERT INTO `cst_linkman` VALUES ('5', '1', '1', null, '二狗子', '女', '吸纳灌木UI那个俐', '13241243124', '123414', '');
INSERT INTO `cst_linkman` VALUES ('6', '4', '4', null, 'hr', '男', 'hr', '111', '111', '111');

-- ----------------------------
-- Table structure for cst_log
-- ----------------------------
DROP TABLE IF EXISTS `cst_log`;
CREATE TABLE `cst_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `log_op` varchar(20) DEFAULT NULL COMMENT '操作人',
  `log_event` varchar(200) DEFAULT NULL COMMENT '操作事件',
  `log_date` datetime DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_log
-- ----------------------------
INSERT INTO `cst_log` VALUES ('258', 'guanliyuan', '删除了角色\'guanliyuan\'', '2018-03-05 17:24:27');
INSERT INTO `cst_log` VALUES ('259', 'guanliyuan', '新增了角色,角色名称为\'特尔\'', '2018-03-05 17:24:42');
INSERT INTO `cst_log` VALUES ('260', 'guanliyuan', '修改了编号为：\'564\' 的信息', '2018-03-06 09:47:33');

-- ----------------------------
-- Table structure for cst_service
-- ----------------------------
DROP TABLE IF EXISTS `cst_service`;
CREATE TABLE `cst_service` (
  `svr_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '服务编号',
  `svr_type` varchar(20) NOT NULL COMMENT '服务类型',
  `svr_title` varchar(500) DEFAULT NULL COMMENT '概要',
  `svr_cust_name` varchar(17) DEFAULT NULL COMMENT '客户名称',
  `svr_status` varchar(10) DEFAULT NULL COMMENT '服务状态',
  `svr_request` varchar(500) DEFAULT NULL COMMENT '服务内容',
  `svr_create_by` varchar(50) DEFAULT NULL COMMENT '服务创建人',
  `svr_due_to` varchar(50) DEFAULT NULL COMMENT '服务分配人',
  `svr_deal` varchar(500) DEFAULT NULL COMMENT '服务处理人',
  `svr_result` varchar(500) DEFAULT NULL COMMENT '处理结果',
  `svr_satisfy` bigint(11) DEFAULT NULL COMMENT '满意度',
  PRIMARY KEY (`svr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cst_service
-- ----------------------------
INSERT INTO `cst_service` VALUES ('1', '咨询', '测试', 'tom', '已分配', '测试', 'lili', 'lili', '', '不通过', '0');
INSERT INTO `cst_service` VALUES ('2', '投诉', '售后', 'tom', '已处理', '新买手机一星期就坏了，不要修了，退钱！！！！', 'jingli', 'jingli', '请问出现了什么问题呢？', '不通过', '0');
INSERT INTO `cst_service` VALUES ('3', '咨询', '测试2', 'briup', '已分配', '测试', 'jingli', 'jingli', '', '通过', '0');
INSERT INTO `cst_service` VALUES ('4', '建议', '电子产品便宜点', 'tom', '已处理', '太贵了，买不起', 'lili', 'jingli', '', '通过', '0');
INSERT INTO `cst_service` VALUES ('5', '咨询', '咨询咨询', 'briup', '已归档', '咨询咨询咨询', 'jingli', 'jingli', '问题解决', '已经解决好了', '4');
INSERT INTO `cst_service` VALUES ('6', '咨询', '咨询问题', 'tom', '已归档', '请问有什么问题吗？？？', 'jingli', 'jingli', '有什么问题？', '服务已经的到解决', '5');
INSERT INTO `cst_service` VALUES ('7', '咨询', '咨询很多问题', 'hua', '新创建', '手机多少钱', 'jingli', null, null, null, null);
INSERT INTO `cst_service` VALUES ('8', '投诉', '苹果电池太坑', 'briup', '新创建', '苹果电池耗电量太大', 'jingli', null, null, null, null);
INSERT INTO `cst_service` VALUES ('9', '咨询', '咨询问题问题', 'sun', '新创建', '我要咨询问题', 'jingli', null, null, null, null);
INSERT INTO `cst_service` VALUES ('10', '咨询', '咨询相关问题', 'briup', '已归档', '苹果多少钱？', 'jingli', 'jingli', '8888', '很好！！', '5');
INSERT INTO `cst_service` VALUES ('11', '咨询', '我要咨询问题', 'tom', '已归档', '请问苹果电池怎么样？', 'jingli', 'jingli', '电池不耐用', '客户满意了！', '5');
INSERT INTO `cst_service` VALUES ('12', '咨询', '你们公司的服务怎么样？', 'briup', '已处理', 'jdalsdjlsda', 'jingli', 'jingli', 'dhsajdakds', null, null);
INSERT INTO `cst_service` VALUES ('13', '投诉', 'dasdas', 'briup', '已分配', 'dasdasdas', 'jingli', 'jingli', null, null, null);
INSERT INTO `cst_service` VALUES ('15', '咨询', 'sss', 'briup', '已分配', 'asdsadas', 'jingli', 'jingli', null, null, null);
INSERT INTO `cst_service` VALUES ('16', '咨询', '咨询咨询', 'briup', '已归档', 'dfsadfasd', 'jingli', 'jingli', 'fsadfsfsaf', 'fsdfsdfasf', '5');
INSERT INTO `cst_service` VALUES ('17', '咨询', 'dsadasda', 'briup', '已归档', 'dsadasdasdsa', 'jingli', 'jingli', 'dadssadad', 'fdafadf', '5');
INSERT INTO `cst_service` VALUES ('18', '咨询', '咨询水泥价格多少', 'mi', '已分配', '你们这水泥多少钱一斤', 'jingli', 'lili', null, null, null);
INSERT INTO `cst_service` VALUES ('19', '投诉', '水泥质量', 'briup', '新创建', '卧槽，你们这水泥质量太差了吧', 'jingli', null, null, null, null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `odr_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `odr_customer` varchar(200) DEFAULT NULL COMMENT '客户名称',
  `odr_addr` varchar(400) DEFAULT NULL COMMENT '送货地址',
  `odr_status` char(1) DEFAULT NULL COMMENT '订单状态',
  `odr_cust_id` bigint(20) DEFAULT NULL COMMENT '客户编号',
  PRIMARY KEY (`odr_id`),
  KEY `odr_cust_id_for` (`odr_cust_id`),
  CONSTRAINT `odr_cust_id_for` FOREIGN KEY (`odr_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'briup', '北京', '1', '1');

-- ----------------------------
-- Table structure for orders_line
-- ----------------------------
DROP TABLE IF EXISTS `orders_line`;
CREATE TABLE `orders_line` (
  `odd_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `odd_order_id` bigint(20) DEFAULT NULL COMMENT '订单编号',
  `odd_count` int(11) DEFAULT NULL COMMENT '总数量',
  `odd_unit` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `odd_price` double DEFAULT NULL COMMENT '价格',
  `prod_id` bigint(20) DEFAULT NULL COMMENT '产品编号',
  PRIMARY KEY (`odd_id`),
  KEY `FK96A10D0EC60A9F52` (`odd_order_id`),
  KEY `prod_id_for` (`prod_id`),
  CONSTRAINT `FK96A10D0EC60A9F52` FOREIGN KEY (`odd_order_id`) REFERENCES `orders` (`odr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prod_id_for` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders_line
-- ----------------------------
INSERT INTO `orders_line` VALUES ('1', '1', '100', '台', '500000', '1');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `prod_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `prod_name` varchar(400) DEFAULT NULL COMMENT '产品名字',
  `prod_type` varchar(200) DEFAULT NULL COMMENT '型号',
  `prod_batch` varchar(200) DEFAULT NULL COMMENT '批次',
  `prod_unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `prod_price` double DEFAULT NULL COMMENT '单价',
  `prod_memo` varchar(400) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`prod_id`),
  KEY `prod_name` (`prod_name`(255))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'compu', '通信', '二级/三批次', '台', '5000', '1');
INSERT INTO `product` VALUES ('2', 'briup', '水果', '一级/一批', '斤', '5', '1');

-- ----------------------------
-- Table structure for sal_chance
-- ----------------------------
DROP TABLE IF EXISTS `sal_chance`;
CREATE TABLE `sal_chance` (
  `chc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `chc_source` varchar(100) DEFAULT NULL COMMENT '来源',
  `chc_cust_name` varchar(200) DEFAULT NULL COMMENT '顾客名称',
  `chc_title` varchar(400) DEFAULT NULL COMMENT '概要',
  `chc_rate` int(11) DEFAULT NULL COMMENT '成功概率',
  `chc_linkman` varchar(100) DEFAULT NULL COMMENT '联系人姓名',
  `chc_tel` varchar(100) DEFAULT NULL COMMENT '联系人电话',
  `chc_addr` varchar(50) DEFAULT NULL COMMENT '联系人地址',
  `chc_desc` varchar(4000) DEFAULT NULL COMMENT '详细描述',
  `chc_create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `chc_due_to` varchar(100) DEFAULT NULL COMMENT '分配人',
  `chc_status` char(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`chc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sal_chance
-- ----------------------------
INSERT INTO `sal_chance` VALUES ('1', 'zhangsan', 'zhang', '客户', '45', 'chao', '18988888888', '北京', '很好', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('2', 'tv', 'zu', '泡脚', '0', 'chao', '19833333333', '北京', '很好', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('3', 'sal', 'jin', '自然人客户', '66', 'jing', '17688888888', '北京', '很好', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('4', 'lu', 'chao', '是不是傻', '100', 'wait', '188999999999', '北京', '活的像一个高仿', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('5', 'wet', 'sun', '泡脚', '100', 'chao', '18988888888', '北京', '没事就泡脚', 'zhuguan', 'lili', 'success');
INSERT INTO `sal_chance` VALUES ('6', 'sh', 'la', '哈哈哈', '67', 'zhangsan', '7894654654', '中南', '很嗨很哈', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('7', 'tv', 'zu', '矮', '80', 'chao', '18988888888', '北京', '增高鞋很适合他', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('9', 'ch', 'zz', '很好', '45', 'good', '7894646513', '中南', '很好', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('10', '等哈说', 'zhzh', '很好', '34', 'zz', '456465446', '华北', '对话框撒娇啊快点哈斯卡打算', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('11', '上海', 'zhangsan ', 'jijij', '58', 'lisi', '13456', '北京', '好机会', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('12', '介绍', 'test', 'test', '80', 'linkman', '123789', '北京', '很好的销售机会', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('13', '上海', '张思', 'jijij', '80', 'linkman', '123789', '北京', 'sfsdfs', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('14', '介绍', 'apple', 'apple', '80', '刘思', '13456', '北京', 'apple企业需要引进手机屏幕，我们的销售机会很大！！努力将这个客户争取到手。。', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('15', '内部消息', 'tom', '这个企业需要大量手机原件', '58', 'linkman', '13456', '华北', '我们可以销售出去大量手机原件！！', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('16', '内部消息', 'apple', 'apple公司需要大量手机电池', '78', '刘思', '123789', '东北', 'apple公司需要大量手机电池，我们有机会拿下这个客户！', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('17', '上海', 'apple1', '苹果公司需要大量手机零件', '78', '刘思', '123789', '华北', '这次需要的苹果零件需求量大，我们的机会很大！！', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('19', '内部消息', 'apple1', '手机屏幕招标', '80', 'chao', '13456', '中南', '仿佛打法放飞的风', 'zhuguan', 'jingli', 'develop');
INSERT INTO `sal_chance` VALUES ('20', '上海', 'zhang', '手机屏幕招标', '80', 'lisi', '123789', '北京', '大手大脚阿拉斯加大赛拉开大家啊来的', 'zhuguan', 'jingli', 'success');
INSERT INTO `sal_chance` VALUES ('21', '内部消息', 'zhang', 'apple公司需要大量手机电池', '80', '刘思', '456789', '华北', '需要大量电池原价', 'zhuguan', 'jingli', 'success');

-- ----------------------------
-- Table structure for sal_plan
-- ----------------------------
DROP TABLE IF EXISTS `sal_plan`;
CREATE TABLE `sal_plan` (
  `pla_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pla_chc_id` bigint(20) NOT NULL COMMENT '销售机会编号',
  `pla_todo` varchar(1000) DEFAULT NULL COMMENT '计划项',
  `pla_result` varchar(1000) DEFAULT NULL COMMENT '执行结果',
  PRIMARY KEY (`pla_id`),
  KEY `FK731E42EACA264737` (`pla_chc_id`),
  CONSTRAINT `FK731E42EACA264737` FOREIGN KEY (`pla_chc_id`) REFERENCES `sal_chance` (`chc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sal_plan
-- ----------------------------
INSERT INTO `sal_plan` VALUES ('1', '1', '请蒸桑拿', '成功');
INSERT INTO `sal_plan` VALUES ('9', '9', '12月3号请客吃饭！！！', '成功');
INSERT INTO `sal_plan` VALUES ('14', '14', '12月3号联系apple企业的客户吃饭，争取拿下机会！', '成功');
INSERT INTO `sal_plan` VALUES ('15', '15', '我们准备12月4号去他们公司拜访！', '成功');
INSERT INTO `sal_plan` VALUES ('16', '16', '12月3号我们要去约这个客户！!', '成功');
INSERT INTO `sal_plan` VALUES ('17', '17', '请客吃饭！争取拿下客户！', '成功');
INSERT INTO `sal_plan` VALUES ('19', '21', '12月3号请客吃饭', '成功');
INSERT INTO `sal_plan` VALUES ('20', '21', '12月3号请客吃饭', '成功');
INSERT INTO `sal_plan` VALUES ('27', '20', 'asdfasfa', 'success');

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `stk_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stk_warehourse` varchar(100) DEFAULT NULL COMMENT '仓库名',
  `stk_count` int(11) DEFAULT NULL COMMENT '总数量',
  `stk_memo` varchar(400) DEFAULT NULL COMMENT '计量单位',
  `stk_ware` varchar(100) DEFAULT NULL COMMENT '货位',
  `stk_name` varchar(400) DEFAULT NULL COMMENT '库存货物名字',
  PRIMARY KEY (`stk_id`),
  KEY `skt_product_id_for` (`stk_name`(255)),
  CONSTRAINT `FKBA7BCE5BD622FAAE` FOREIGN KEY (`stk_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storage
-- ----------------------------
INSERT INTO `storage` VALUES ('1', '1号仓库', '500', '台', 'B13货位', 'compu');
INSERT INTO `storage` VALUES ('2', '3号仓库', '300', '斤', 'A7货位', 'briup');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL COMMENT '编号',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名字',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `role_flag` int(11) DEFAULT NULL COMMENT '角色状态',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '超管', '1');
INSERT INTO `sys_role` VALUES ('2', '高管', '管理员', '1');
INSERT INTO `sys_role` VALUES ('3', '销售主管', '服务分配', '1');
INSERT INTO `sys_role` VALUES ('4', '客户经理', '服务创建', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `usr_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `usr_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `usr_password` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `usr_flag` int(11) DEFAULT NULL COMMENT '用户状态',
  `usr_role_id` bigint(20) DEFAULT NULL COMMENT '角色等级',
  PRIMARY KEY (`usr_id`),
  KEY `role_id_for` (`usr_role_id`),
  KEY `usr_name` (`usr_name`),
  CONSTRAINT `role_id_for` FOREIGN KEY (`usr_role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'guanliyuan', '123456', '1', '1');
INSERT INTO `sys_user` VALUES ('2', 'gaoguan', '123456', '1', '2');
INSERT INTO `sys_user` VALUES ('3', 'zhuguan', '123456', '1', '3');
INSERT INTO `sys_user` VALUES ('4', 'jingli', '123456', '1', '4');
INSERT INTO `sys_user` VALUES ('5', 'lili', '1234567', '1', '4');
