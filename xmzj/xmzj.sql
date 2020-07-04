/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : xmzj

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-04-13 14:10:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project` bigint(20) DEFAULT NULL COMMENT '项目',
  `content` text COMMENT '内容',
  `user` bigint(20) DEFAULT NULL COMMENT '所属人',
  `pro` bigint(20) DEFAULT NULL COMMENT '所属专家',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='指导信息';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '你好，专家，谢谢你的指导', '1', null, '2020-04-11 11:58:41');
INSERT INTO `comment` VALUES ('2', '1', '你首先这么操作，然后再来这么操作!!', null, '3', '2020-04-11 12:05:04');
INSERT INTO `comment` VALUES ('3', '2', '你这个项目啊，你首先要这么做，然后这么做，做好了之后呢，你再来一起搞。！！', null, '5', '2020-04-11 13:07:08');
INSERT INTO `comment` VALUES ('4', '2', '好的，老师，我知道了，谢谢你，请问一下，这个怎么搞呢？', '6', null, '2020-04-11 13:07:38');
INSERT INTO `comment` VALUES ('5', '2', '你就这么干就OK拉。', null, '5', '2020-04-11 13:08:10');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='通知公告';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '1', '1', '2020-04-11 11:38:11');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `user` bigint(10) DEFAULT NULL COMMENT '所属用户',
  `type` bigint(20) DEFAULT NULL COMMENT '领域',
  `content` text COMMENT '内容',
  `area` varchar(255) DEFAULT NULL COMMENT '地点',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `pro` bigint(20) DEFAULT NULL COMMENT '所选专家',
  `price` double(10,2) DEFAULT NULL COMMENT '费用',
  `pay` varchar(255) DEFAULT NULL COMMENT '支付方式',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='项目';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '321321', '1', '3', '321321', '321', '2020-04-16 11:47:51', '已指导', '3', '561.00', '支付宝支付', '2020-04-11 11:47:56');
INSERT INTO `project` VALUES ('2', '发大水发大厦发', '6', '3', '范德萨范德萨发', '范德萨发', '2020-04-23 13:02:32', '已指导', '5', '850.00', '微信支付', '2020-04-11 13:02:37');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('2', '0', '专家信息', 'sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '0', '角色管理', 'sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '0', '菜单管理', 'sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('28', '0', '代码生成器', 'sys/generator.html', 'sys:generator:list,sys:generator:code', '1', 'fa fa-rocket', '8');
INSERT INTO `sys_menu` VALUES ('76', '0', '通知公告', 'admin/news.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('77', '76', '查看', null, 'news:list,news:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('78', '76', '新增', null, 'news:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('79', '76', '修改', null, 'news:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('80', '76', '删除', null, 'news:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('81', '0', '领域类别', 'admin/type.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('82', '81', '查看', null, 'type:list,type:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('83', '81', '新增', null, 'type:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('84', '81', '修改', null, 'type:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('85', '81', '删除', null, 'type:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('86', '0', '项目信息', 'admin/project.html', null, '1', null, '6');
INSERT INTO `sys_menu` VALUES ('87', '86', '查看', null, 'project:list,project:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('88', '86', '新增', null, 'project:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('89', '86', '修改', null, 'project:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('90', '86', '删除', null, 'project:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('91', '0', '指导信息', 'admin/comment.html', null, '1', null, '8');
INSERT INTO `sys_menu` VALUES ('92', '91', '查看', null, 'comment:list,comment:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('93', '91', '新增', null, 'comment:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('94', '91', '修改', null, 'comment:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('95', '91', '删除', null, 'comment:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('96', '0', '用户信息', 'admin/user.html', null, '1', null, '3');
INSERT INTO `sys_menu` VALUES ('97', '0', '查看专家', 'admin/pro.html', null, '1', null, '4');
INSERT INTO `sys_menu` VALUES ('98', '0', '上传项目', 'admin/add.html', null, '1', null, '7');
INSERT INTO `sys_menu` VALUES ('99', '0', '我的项目', 'admin/my.html', null, '1', null, '7');
INSERT INTO `sys_menu` VALUES ('100', '0', '我指导的项目', 'admin/promy.html', null, '1', null, '7');
INSERT INTO `sys_menu` VALUES ('101', '0', '联系我们', 'admin/us.html', null, '1', null, '8');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '专家', null, '1', '2018-04-17 10:26:34');
INSERT INTO `sys_role` VALUES ('2', '系统管理员', null, '-1', '2018-04-17 15:24:04');
INSERT INTO `sys_role` VALUES ('3', '普通', null, '1', '2020-04-11 12:51:30');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('167', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('168', '2', '15');
INSERT INTO `sys_role_menu` VALUES ('169', '2', '16');
INSERT INTO `sys_role_menu` VALUES ('170', '2', '17');
INSERT INTO `sys_role_menu` VALUES ('171', '2', '18');
INSERT INTO `sys_role_menu` VALUES ('172', '2', '96');
INSERT INTO `sys_role_menu` VALUES ('173', '2', '76');
INSERT INTO `sys_role_menu` VALUES ('174', '2', '77');
INSERT INTO `sys_role_menu` VALUES ('175', '2', '78');
INSERT INTO `sys_role_menu` VALUES ('176', '2', '79');
INSERT INTO `sys_role_menu` VALUES ('177', '2', '80');
INSERT INTO `sys_role_menu` VALUES ('178', '2', '81');
INSERT INTO `sys_role_menu` VALUES ('179', '2', '82');
INSERT INTO `sys_role_menu` VALUES ('180', '2', '83');
INSERT INTO `sys_role_menu` VALUES ('181', '2', '84');
INSERT INTO `sys_role_menu` VALUES ('182', '2', '85');
INSERT INTO `sys_role_menu` VALUES ('183', '2', '86');
INSERT INTO `sys_role_menu` VALUES ('184', '2', '87');
INSERT INTO `sys_role_menu` VALUES ('185', '2', '90');
INSERT INTO `sys_role_menu` VALUES ('186', '2', '91');
INSERT INTO `sys_role_menu` VALUES ('187', '2', '92');
INSERT INTO `sys_role_menu` VALUES ('188', '2', '95');
INSERT INTO `sys_role_menu` VALUES ('189', '2', '101');
INSERT INTO `sys_role_menu` VALUES ('190', '1', '76');
INSERT INTO `sys_role_menu` VALUES ('191', '1', '77');
INSERT INTO `sys_role_menu` VALUES ('192', '1', '100');
INSERT INTO `sys_role_menu` VALUES ('193', '1', '101');
INSERT INTO `sys_role_menu` VALUES ('194', '3', '97');
INSERT INTO `sys_role_menu` VALUES ('195', '3', '76');
INSERT INTO `sys_role_menu` VALUES ('196', '3', '77');
INSERT INTO `sys_role_menu` VALUES ('197', '3', '98');
INSERT INTO `sys_role_menu` VALUES ('198', '3', '99');
INSERT INTO `sys_role_menu` VALUES ('199', '3', '101');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type1` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `type` bigint(20) DEFAULT NULL COMMENT '擅长领域',
  `content` text COMMENT '个人介绍',
  `price` double(10,2) DEFAULT NULL COMMENT '指导价格',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('-1', 'admin', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'root@renren.io', '321321', '1', null, '2018-11-11 11:11:11', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('1', 'admin1', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 'admin@admin.com', '13612345678', '1', null, '2018-11-11 11:11:11', null, null, '男', null, null, null);
INSERT INTO `sys_user` VALUES ('3', '专家1', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, '13223232323', '1', '1', '2020-04-11 11:34:33', '1', '', '男', '3', '321321', '561.00');
INSERT INTO `sys_user` VALUES ('5', '专家2', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, '13223232323', '1', null, '2020-04-11 12:59:41', '1', '/cdn//cdn/007199e3-dcd8-4c45-bfd7-6441ea75a87c.png', '男', '3', '范德萨范德萨发', '850.00');
INSERT INTO `sys_user` VALUES ('6', '123123', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', null, null, '1', null, '2020-04-11 12:59:47', '3', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('6', '8', '1');
INSERT INTO `sys_user_role` VALUES ('7', '-1', '2');
INSERT INTO `sys_user_role` VALUES ('8', '2', '1');
INSERT INTO `sys_user_role` VALUES ('10', '3', '1');
INSERT INTO `sys_user_role` VALUES ('11', '5', '1');
INSERT INTO `sys_user_role` VALUES ('12', '6', '3');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `type` bigint(20) DEFAULT NULL COMMENT '擅长领域',
  `content` text COMMENT '个人介绍',
  `gmtTime` datetime DEFAULT NULL COMMENT '添加时间',
  `price` double(10,2) DEFAULT NULL COMMENT '指导价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='test';

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='擅长领域';

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '水电');
INSERT INTO `type` VALUES ('2', '土木');
INSERT INTO `type` VALUES ('3', '绿化');
