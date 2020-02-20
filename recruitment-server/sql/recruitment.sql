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
    `mail` varchar(255) DEFAULT NULL COMMENT 'user mail',
    `name` varchar(255) DEFAULT NULL COMMENT 'user name',
	`phone` varchar(20) DEFAULT NULL COMMENT 'user phone',
	`location` varchar(255) DEFAULT NULL COMMENT 'user location',
	`intention` varchar(255) DEFAULT NULL COMMENT 'user job intention',
	`website` varchar(255) DEFAULT NULL COMMENT 'user website url',
	`statement` text DEFAULT NULL COMMENT 'user personal statement',
	`major` varchar(255) DEFAULT NULL COMMENT 'user major of study',
	`school` varchar(255) DEFAULT NULL COMMENT 'user school',
	`edustart` date DEFAULT NULL COMMENT 'user education start time',
	`eduend` date DEFAULT NULL COMMENT 'user education end time',
	`edudescript` text DEFAULT NULL COMMENT 'user education description',
    PRIMARY KEY (`resumeid`),
    FOREIGN KEY (`userid`) REFERENCES user(`userid`) ON DELETE CASCADE ON UPDATE CASCADE
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
    FOREIGN KEY (`userid`) REFERENCES user(`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`roleid`) REFERENCES role(`roleid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='user_role table';

-- ----------------------------
-- Records of User Role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'USER');

-- ----------------------------
-- Table for User Job Experience
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
	`jobid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'job id',
	`userid` int(11) NOT NULL COMMENT 'user id',
	`companyname` varchar(255) DEFAULT NULL COMMENT 'user companyname',
	`jobtitle` varchar(255) DEFAULT NULL COMMENT 'user job title',
	`jobstart` date DEFAULT NULL COMMENT 'work experience start time',
	`jobend` date DEFAULT NULL COMMENT 'work experience end time',
	`jobdescript` text DEFAULT NULL COMMENT 'work experience description',
	PRIMARY KEY (`jobid`),
	FOREIGN KEY (`userid`) REFERENCES user(`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='job experience table';

-- ----------------------------
-- Records of User Job Experience
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
  `salarytype` varchar(255) DEFAULT NULL COMMENT 'job salary type',
  `description` text DEFAULT NULL COMMENT 'job description',
  `criteria` text DEFAULT NULL COMMENT 'job criteria',
  `due` datetime DEFAULT NULL COMMENT 'application deadline',
  `picknum` int(11) DEFAULT NULL COMMENT 'target picks',
	PRIMARY KEY (`postid`),
	FOREIGN KEY (`authorid`) REFERENCES user(`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='post table';

-- ----------------------------
-- Records of Job Post
-- ----------------------------

-- ----------------------------
-- Table for Evaluator
-- ----------------------------
DROP TABLE IF EXISTS `evaluator`;
CREATE TABLE `evaluator` (
  `evaluatorid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'evaluator id',
  `postid` int(11) NOT NULL COMMENT 'post id',
  `evaluatorname` varchar(255) DEFAULT NULL COMMENT 'evaluator username',
	PRIMARY KEY (`evaluatorid`),
	FOREIGN KEY (`postid`) REFERENCES post(`postid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='evaluator table';

-- ----------------------------
-- Records of Evaluator
-- ----------------------------

-- ----------------------------
-- Table for Application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
	`applicationid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'application id',
	`resumeid` int(11) NOT NULL COMMENT 'user id',
	`postid` int(11) NOT NULL COMMENT 'post id',
    `scoreavg` decimal(5,2) NOT NULL DEFAULT 0.00 COMMENT 'application score average',
	PRIMARY KEY (`applicationid`),
	FOREIGN KEY (`resumeid`) REFERENCES resume(`resumeid`) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (`postid`) REFERENCES post(`postid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='application table';

-- ----------------------------
-- Records of Application
-- ----------------------------

-- ----------------------------
-- Table for Score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
	`scoreid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'score id',
    `markerid` int(11) NOT NULL COMMENT 'marker id',
    `applicationid` int(11) NOT NULL COMMENT 'application id',
    `score` decimal(5,2) DEFAULT NULL COMMENT 'application score',
    PRIMARY KEY (`scoreid`),
    FOREIGN KEY (`markerid`) REFERENCES user(`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`applicationid`) REFERENCES application(`applicationid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='score table';

-- ----------------------------
-- Records of Notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
	`notificationid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'notification id',
    `userid` int(11) NOT NULL COMMENT 'user id',
    `content` varchar(255) DEFAULT NULL COMMENT 'notification conetent',
    PRIMARY KEY (`notificationid`),
    FOREIGN KEY (`userid`) REFERENCES user(`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='notification table';

-- ----------------------------
-- Table for Notification
-- ----------------------------

-- ----------------------------
-- Records of Discussion
-- ----------------------------
DROP TABLE IF EXISTS `discussion`;
CREATE TABLE `discussion` (
	`discussionid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'message id',
    `notificationid` int(11) NOT NULL COMMENT 'notification id',
    `senderid` int(11) NOT NULL COMMENT 'sender id',
    `receiverid` int(11) NOT NULL COMMENT 'receiver id',
    `title` varchar(255) DEFAULT NULL COMMENT 'message title',
    `content` text DEFAULT NULL COMMENT 'message content',
    PRIMARY KEY (`discussionid`),
    FOREIGN KEY (`notificationid`) REFERENCES notification(`notificationid`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`senderid`) REFERENCES user(`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='message table';

-- ----------------------------
-- Table for Dicussion
-- ----------------------------
