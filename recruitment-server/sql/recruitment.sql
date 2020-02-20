CREATE DATABASE IF NOT EXISTS `recruitment` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `recruitment`;

-- ----------------------------
-- Table for User
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`userid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user id',
	`mail` varchar(255) DEFAULT NULL COMMENT 'user mail',
	`password` varchar(255) DEFAULT NULL COMMENT 'user password',
	`username` varchar(255) DEFAULT NULL COMMENT 'user username',
 	PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='user table';

-- ----------------------------
-- Records of User
-- ----------------------------

-- ----------------------------
-- Table for Resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
	`resumeid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'resume id',
    `userid` int(11) NOT NULL COMMENT 'user id',
    `name` varchar(255) DEFAULT NULL COMMENT 'user name',
	`age` int(11) DEFAULT NULL COMMENT 'user age',
	`phone` varchar(20) DEFAULT NULL COMMENT 'user phone',
	`location` varchar(255) DEFAULT NULL COMMENT 'user location',
	`intention` varchar(255) DEFAULT NULL COMMENT 'user job intention',
	`website` varchar(255) DEFAULT NULL COMMENT 'user website url',
	`statement` text DEFAULT NULL COMMENT 'user personal statement',
	`degree` varchar(255) DEFAULT NULL COMMENT 'user education degree',
	`major` varchar(255) DEFAULT NULL COMMENT 'user major of study',
	`school` varchar(255) DEFAULT NULL COMMENT 'user school',
	`edustart` date DEFAULT NULL COMMENT 'user education start time',
	`eduend` date DEFAULT NULL COMMENT 'user education end time',
	`edudescript` text DEFAULT NULL COMMENT 'user education description',
	`score` varchar(20) DEFAULT NULL COMMENT 'user score',
    PRIMARY KEY (`resumeid`),
    FOREIGN KEY (`userid`) REFERENCES user(`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='resume table';

-- ----------------------------
-- Table for Role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
	`roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'role id',
    `rolename` varchar(50) DEFAULT NULL COMMENT 'role name',
    PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='role table';

-- ----------------------------
-- Records of Role
-- ----------------------------

-- ----------------------------
-- Table for User Role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
	`userroleid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userrole id',
	`userid` int(11) NOT NULL COMMENT 'user id',
	`roleid` int(11) NOT NULL COMMENT 'role id',
    PRIMARY KEY (`userroleid`),
    FOREIGN KEY (`userid`) REFERENCES user(`userid`),
    FOREIGN KEY (`roleid`) REFERENCES role(`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='user_role table';

-- ----------------------------
-- Records of User Role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'USER');

-- ----------------------------
-- Table for User Work Experience
-- ----------------------------
DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience` (
	`expid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'work experience id',
	`userid` int(11) NOT NULL COMMENT 'user id',
	`companyname` varchar(255) DEFAULT NULL COMMENT 'user companyname',
	`jobtitle` varchar(255) DEFAULT NULL COMMENT 'user job title',
	`jobstart` date DEFAULT NULL COMMENT 'work experience start time',
	`jobend` date DEFAULT NULL COMMENT 'work experience end time',
	`jobdescript` text DEFAULT NULL COMMENT 'work experience description',
	`curjob` boolean NOT NULL DEFAULT 0 COMMENT 'current work',
	PRIMARY KEY (`expid`),
	FOREIGN KEY (`userid`) REFERENCES user(`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='work experience table';

-- ----------------------------
-- Records of User Work Experience
-- ----------------------------

-- ----------------------------
-- Table for User Skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
	`skillid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'skill id',
	`userid` int(11) NOT NULL COMMENT 'user id',
	`skillname` varchar(255) DEFAULT NULL COMMENT 'skill name',
	`skillprof` int(11) DEFAULT NULL COMMENT 'skill proficiency',
	PRIMARY KEY (`skillid`),
	FOREIGN KEY (`userid`) REFERENCES user(`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='skill table';

-- ----------------------------
-- Records of User Skill
-- ----------------------------

-- ----------------------------
-- Table for Company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
	`companyid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'company id',
	`companyname` varchar(255) DEFAULT NULL COMMENT 'company name',
	PRIMARY KEY (`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='company table';

-- ----------------------------
-- Records of Company
-- ----------------------------

-- ----------------------------
-- Table for Job Post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `postid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'post id',
  `authorid` int(11) NOT NULL COMMENT 'author (user) id',
  `companyname` varchar(255) DEFAULT NULL COMMENT 'companyname',
  `jobname` varchar(255) DEFAULT NULL COMMENT 'job name',
  `location` varchar(255) DEFAULT NULL COMMENT 'job location',
  `category` varchar(255) DEFAULT NULL COMMENT 'job category',
  `salary` int(11) DEFAULT NULL COMMENT 'job salary',
  `salarytype` int(10) DEFAULT NULL COMMENT 'job salary type',
  `description` text DEFAULT NULL COMMENT 'job description',
  `criteria` text DEFAULT NULL COMMENT 'job criteria',
  `due` date DEFAULT NULL COMMENT 'application deadline',
  `picknum` int(11) DEFAULT NULL COMMENT 'target picks',
	PRIMARY KEY (`postid`),
	FOREIGN KEY (`authorid`) REFERENCES user(`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='post table';

-- ----------------------------
-- Records of Job
-- ----------------------------

-- ----------------------------
-- Table for Application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
	`applicationid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'application id',
	`userid` int(11) NOT NULL COMMENT 'user id',
	`postid` int(11) NOT NULL COMMENT 'post id',
	`status` tinyint(1) NOT NULL DEFAULT 0 COMMENT 'status - 0: processed 1: accept 2: reject',
	PRIMARY KEY (`applicationid`),
	FOREIGN KEY (`userid`) REFERENCES user(`userid`),
	FOREIGN KEY (`postid`) REFERENCES post(`postid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='application table';

-- ----------------------------
-- Records of Application
-- ----------------------------
