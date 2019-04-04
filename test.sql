/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-05-23 10:10:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activityId` int(11) NOT NULL AUTO_INCREMENT,
  `activityName` varchar(255) NOT NULL,
  `activityLocation` varchar(255) NOT NULL,
  `activityPicture` varchar(255) NOT NULL,
  `activityIntroduction` varchar(255) NOT NULL,
  `activityTime` varchar(20) NOT NULL,
  `activityContent` varchar(2047) NOT NULL,
  `activityOrganization` int(11) NOT NULL,
  PRIMARY KEY (`activityId`),
  KEY `FK_activityOrganization` (`activityOrganization`),
  CONSTRAINT `FK_activityOrganization` FOREIGN KEY (`activityOrganization`) REFERENCES `organization` (`organizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('7', '编程之美', '计控楼', 'ACM.png', '微软编程之美挑战赛” 是面向在校学生开展的大型编程比赛，致力于为青年开发者提供国际一流水平的开发与交流机会', '2017-02-25', '微软编程之美挑战赛” 是面向在校学生开展的大型编程比赛，致力于为青年开发者提供国际一流水平的开发与交流机会', '1');
INSERT INTO `activity` VALUES ('8', '编程之美', '计控楼', 'game.jpg', '微软编程之美挑战赛” 是面向在校学生开展的大型编程比赛，致力于为青年开发者提供国际一流水平的开发与交流机会', '2017-02-25', '微软编程之美挑战赛” 是面向在校学生开展的大型编程比赛，致力于为青年开发者提供国际一流水平的开发与交流机会', '1');
INSERT INTO `activity` VALUES ('9', '微信小程序开发大赛', '计控楼', 'qw.jpg', '紧急招人!!!!', '2018-05-09', '好了没啥事了……', '2');
INSERT INTO `activity` VALUES ('11', '微信小程序开发大赛', '计控楼', 'wxxcx.jpg', '试着开发一个厉害的小程序，敢不敢来比比，看谁的作品比较牛逼', '2018-06-01', '非常有趣，非常好玩，快来看快来瞧', '1');

-- ----------------------------
-- Table structure for activitycollection
-- ----------------------------
DROP TABLE IF EXISTS `activitycollection`;
CREATE TABLE `activitycollection` (
  `collectionId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `activityId` int(11) NOT NULL,
  PRIMARY KEY (`collectionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activitycollection
-- ----------------------------

-- ----------------------------
-- Table structure for chatroom
-- ----------------------------
DROP TABLE IF EXISTS `chatroom`;
CREATE TABLE `chatroom` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `messageAuthor` int(11) DEFAULT NULL,
  `messageContent` varchar(255) DEFAULT NULL,
  `messageTime` varchar(255) DEFAULT NULL,
  `messageMail` varchar(255) DEFAULT NULL,
  `tag` int(11) DEFAULT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chatroom
-- ----------------------------
INSERT INTO `chatroom` VALUES ('11', '1510742', '厉害厉害', '2018-05-09 21:12:14', 'mail.nankai.edu.cn', '2');
INSERT INTO `chatroom` VALUES ('16', '1211921', '本人有较强的组织能力、实际动手能力和团体协作精神，能迅速的适应各种环境，并融合其中', '2018-05-09 22:02:20', 'adiah@outlook.com', '1');
INSERT INTO `chatroom` VALUES ('17', '1510321', '给你点赞', '2018-05-13 16:52:56', 'trump@gmail.com', '1');
INSERT INTO `chatroom` VALUES ('23', '1510742', '这个社团很有趣', '2018-05-13 17:38:12', 'taoguanpin@qq.com', '2');
INSERT INTO `chatroom` VALUES ('25', '1232123', '呵呵呵额', '2018-05-13 17:39:43', 'Kingze@qq.com', '1');
INSERT INTO `chatroom` VALUES ('47', '1510742', '上墙', '2018-05-13 21:13:42', 'test@gmail.com', '1');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentId` int(11) NOT NULL,
  `departmentName` varchar(255) NOT NULL,
  `departmentLeader` int(11) NOT NULL,
  `departmentOrganization` int(11) NOT NULL,
  PRIMARY KEY (`departmentId`),
  KEY `FK_departmentOrganization` (`departmentOrganization`),
  KEY `FK328E4352898DB29` (`departmentLeader`),
  CONSTRAINT `FK328E4352898DB29` FOREIGN KEY (`departmentLeader`) REFERENCES `member` (`memberId`),
  CONSTRAINT `FK_departmentOrganization` FOREIGN KEY (`departmentOrganization`) REFERENCES `organization` (`organizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('100', '直隶', '1511205', '1');
INSERT INTO `department` VALUES ('101', '办公部', '1511207', '1');
INSERT INTO `department` VALUES ('102', '活动部', '1511209', '1');
INSERT INTO `department` VALUES ('200', '直隶', '1511206', '2');
INSERT INTO `department` VALUES ('201', '宣传部', '1511208', '2');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `materialId` int(11) NOT NULL AUTO_INCREMENT,
  `materialName` varchar(255) NOT NULL,
  `materialAmount` int(11) NOT NULL,
  `materialOrganization` int(11) NOT NULL,
  `materialRemarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`materialId`),
  KEY `FK_materialOrganization` (`materialOrganization`),
  CONSTRAINT `FK_materialOrganization` FOREIGN KEY (`materialOrganization`) REFERENCES `organization` (`organizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '气球', '3', '1', null);
INSERT INTO `material` VALUES ('2', '篮球', '50', '2', '院长杯篮球挑战赛');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `memberId` int(11) NOT NULL AUTO_INCREMENT,
  `memberName` varchar(255) NOT NULL,
  `memberMajor` varchar(255) DEFAULT NULL,
  `memberHometown` varchar(255) DEFAULT NULL,
  `memberBirthday` varchar(255) DEFAULT NULL,
  `memberGender` varchar(10) DEFAULT NULL,
  `memberPassword` varchar(20) NOT NULL DEFAULT '1',
  `memberPosition` varchar(20) NOT NULL,
  `memberPhone` varchar(20) NOT NULL,
  `memberDepartment` int(11) NOT NULL,
  `memberPicture` varchar(20) DEFAULT NULL,
  `memberNum` varchar(20) NOT NULL,
  PRIMARY KEY (`memberId`),
  KEY `FK_memberDepartment` (`memberDepartment`),
  CONSTRAINT `FK_memberDepartment` FOREIGN KEY (`memberDepartment`) REFERENCES `department` (`departmentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1511222 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1510234', '陈二狗', '计算机科学与技术', '天津', '1996-06-06', '男', '1', '中层', '18328828123', '101', null, '1510234');
INSERT INTO `member` VALUES ('1511205', '李政道', '物联网', '北京', '1992-02-01', '男', '156', '高层', '18122705690', '100', '', '1511205');
INSERT INTO `member` VALUES ('1511206', '巴赫', '自动化', '山东', '1993-03-01', '男', '1', '高层', '18122707630', '200', '', '1511206');
INSERT INTO `member` VALUES ('1511207', '牛顿', '计算机', '河北', '1994-04-05', '女', '1', '中层', '15123645897', '101', '', '1511207');
INSERT INTO `member` VALUES ('1511208', '高斯', '智能', '海南', '1998-03-04', '男', '1', '中层', '15122332211', '201', '', '1511208');
INSERT INTO `member` VALUES ('1511209', '拉普拉斯', '信息安全', '西藏', '1995-09-08', '男', '1', '中层', '13566998877', '102', '', '1511209');
INSERT INTO `member` VALUES ('1511210', '罗素', '计算机', '天津', '1996-09-09', '女', '1', '干事', '15112336655', '101', '', '1511210');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `organizationId` int(11) NOT NULL AUTO_INCREMENT,
  `organizationName` varchar(255) NOT NULL,
  `organizationLeader` int(11) NOT NULL,
  `organizationIntroduction` varchar(1023) NOT NULL,
  PRIMARY KEY (`organizationId`),
  KEY `FK_organizationLeader` (`organizationLeader`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', ' 科技协会', '1511205', '南开大学计控学院学生科技协会立足科技创新，宣传科学知识，开展技术咨询、技术服务，促进科学技术成果转化。');
INSERT INTO `organization` VALUES ('2', '学生会', '1511206', '学生会作为学生自治组织，昭示着名校的底蕴与气度，锤炼出自身独有的风格：“锻炼能力，提高素质，成长成材。');

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `registerId` int(11) NOT NULL AUTO_INCREMENT,
  `registerName` varchar(255) DEFAULT NULL,
  `registerIntroduction` varchar(1023) DEFAULT NULL,
  `registerMajor` varchar(255) DEFAULT NULL,
  `registerHometown` varchar(255) DEFAULT NULL,
  `registerBirthday` varchar(255) DEFAULT NULL,
  `registerGender` varchar(10) DEFAULT NULL,
  `registerPhone` varchar(20) DEFAULT NULL,
  `registerPicture` varchar(255) DEFAULT NULL,
  `registerIntention1` int(11) DEFAULT NULL,
  `registerIntention2` int(11) DEFAULT NULL,
  `registerStatus` int(11) DEFAULT '0',
  `registerAdjust` varchar(10) DEFAULT NULL,
  `registerDate` varchar(10) DEFAULT NULL,
  `registerPassword` varchar(255) NOT NULL,
  `registerNum` varchar(20) NOT NULL,
  PRIMARY KEY (`registerId`),
  KEY `FK_registerIntention1` (`registerIntention1`),
  KEY `FK_registerIntention2` (`registerIntention2`),
  CONSTRAINT `FK_registerIntention1` FOREIGN KEY (`registerIntention1`) REFERENCES `department` (`departmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_registerIntention2` FOREIGN KEY (`registerIntention2`) REFERENCES `department` (`departmentId`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1314523 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('9', '金正恩', '大家好', '计算机科学与技术', '安徽', '1996-06-11', '男', '18322773806', '', '201', '101', '0', '是', '2018-05-05', '12345', '1231441');
INSERT INTO `register` VALUES ('10', '特朗普', '美国总统', '信息安全', '山东', '1994-02-02', '男', '18266427811', '', '102', '101', '0', '是', '0012-03-03', '1234567', '1234567');
INSERT INTO `register` VALUES ('11', '普金', '棒的要死', '信息安全', '云南', '1999-08-01', '男', '18233213344', '', '101', '201', '0', '是', '2018-05-22', '1510211', '1510211');
INSERT INTO `register` VALUES ('12', '文在寅', '泡菜王子', '计算机科学与技术', '北京', '1995-05-04', '男', '18324321212', null, '201', '101', '0', '是', '2018-05-22', '1511220', '1511220');
INSERT INTO `register` VALUES ('1314522', '曹尼玛', '我是你爸爸', '自动化', '安徽', '1996-06-03', '男', '1887415157', '', '101', '102', '0', '是', '2015-05-05', '1314520', '1314520');
