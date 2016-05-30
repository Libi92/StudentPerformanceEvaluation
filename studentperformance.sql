/*
 Navicat Premium Data Transfer

 Source Server         : connection
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : localhost
 Source Database       : studentperformance

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : utf-8

 Date: 01/18/2016 18:41:10 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `academics`
-- ----------------------------
DROP TABLE IF EXISTS `academics`;
CREATE TABLE `academics` (
  `academicsId` int(200) NOT NULL AUTO_INCREMENT,
  `loginid` int(200) NOT NULL,
  `semester` varchar(256) NOT NULL,
  `totalmarks` varchar(256) NOT NULL,
  `percentage` varchar(256) NOT NULL,
  `backlogs` varchar(256) NOT NULL,
  `certificate` varchar(256) NOT NULL,
  `status` int(200) NOT NULL,
  PRIMARY KEY (`academicsId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `academics`
-- ----------------------------
BEGIN;
INSERT INTO `academics` VALUES ('1', '6', 'Semester 7', '1024', '78', '0', 'simple-blue-wave.jpg', '1'), ('2', '6', 'Semester 6', '1024', '78', '0', '1883318.jpg', '-1'), ('3', '5', 'Semester 6', '1024', '74', '0', 'bk-eco-ga.jpg', '1'), ('4', '5', 'Semester 7', '1024', '75', '0', 'eco-angled2.png', '1'), ('5', '4', 'Semester 6', '1024', '75', '0', 'lion-hd-wallpaper-22.jpg', '0'), ('6', '4', 'Semester 6', '1024', '73', '0', '31.jpg', '0'), ('7', '4', 'Semester 6', '1024', '73', '0', '2.jpg', '0'), ('8', '4', 'Semester 6', '1024', '75', '0', '2064.jpg', '0'), ('9', '4', 'Semester 6', '1024', '78', '0', 'assassins-creed-revelations-full-hd-wallpapers-1920x1080.jpg', '0');
COMMIT;

-- ----------------------------
--  Table structure for `companies`
-- ----------------------------
DROP TABLE IF EXISTS `companies`;
CREATE TABLE `companies` (
  `companyid` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `location` varchar(256) DEFAULT NULL,
  `platforms` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `companies`
-- ----------------------------
BEGIN;
INSERT INTO `companies` VALUES ('1', 'TCS', 'Cochin', 'Java, Android, Hadoop, Matlab'), ('3', 'Infosys', 'Bangalore', 'Java, Hadoop, Matlab');
COMMIT;

-- ----------------------------
--  Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `loginid` int(200) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `type` varchar(256) NOT NULL,
  `status` int(200) NOT NULL,
  PRIMARY KEY (`loginid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `login`
-- ----------------------------
BEGIN;
INSERT INTO `login` VALUES ('1', 'admin', 'admin', 'Admin', '1'), ('4', 'libin_33', 'libin33', 'Student', '1'), ('5', 'fazna_46', 'student', 'Student', '1'), ('6', 'libin_34', 'student', 'Student', '1'), ('7', 'libin_45', 'student', 'Student', '1'), ('8', 'arun_5', 'student', 'Student', '1'), ('9', 'libin_S123', 'libin', 'PlacementOfficer', '1');
COMMIT;

-- ----------------------------
--  Table structure for `placement`
-- ----------------------------
DROP TABLE IF EXISTS `placement`;
CREATE TABLE `placement` (
  `placementid` int(200) NOT NULL AUTO_INCREMENT,
  `driveid` int(200) DEFAULT NULL,
  `companyid` int(200) DEFAULT NULL,
  `studentid` int(200) DEFAULT NULL,
  `status` int(200) DEFAULT NULL,
  PRIMARY KEY (`placementid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `placement`
-- ----------------------------
BEGIN;
INSERT INTO `placement` VALUES ('1', '1', '1', '6', '1'), ('2', '1', '1', '5', '1');
COMMIT;

-- ----------------------------
--  Table structure for `placementdrive`
-- ----------------------------
DROP TABLE IF EXISTS `placementdrive`;
CREATE TABLE `placementdrive` (
  `placementid` int(200) NOT NULL AUTO_INCREMENT,
  `companyid` int(200) DEFAULT NULL,
  `venue` varchar(256) DEFAULT NULL,
  `date` varchar(256) DEFAULT NULL,
  `time` varchar(256) DEFAULT NULL,
  `post` varchar(256) DEFAULT NULL,
  `minpercentage` varchar(256) DEFAULT NULL,
  `maxbacklogs` varchar(256) DEFAULT NULL,
  `status` int(200) DEFAULT NULL,
  PRIMARY KEY (`placementid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `placementdrive`
-- ----------------------------
BEGIN;
INSERT INTO `placementdrive` VALUES ('1', '1', 'CUSAT', '12/19/2015', '10:30 am', 'Junior Software Engineer', '68', '1', '1'), ('2', '3', 'CUSAT', '12/25/2015', '10:00 AM', 'Software Engineer', '70', '0', '0');
COMMIT;

-- ----------------------------
--  Table structure for `placementofficers`
-- ----------------------------
DROP TABLE IF EXISTS `placementofficers`;
CREATE TABLE `placementofficers` (
  `Id` int(200) NOT NULL AUTO_INCREMENT,
  `staffId` varchar(256) NOT NULL,
  `name` varchar(256) NOT NULL,
  `address` varchar(1024) NOT NULL,
  `contact` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `loginid` int(200) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `placementofficers`
-- ----------------------------
BEGIN;
INSERT INTO `placementofficers` VALUES ('1', 'S123', 'Libin', 'xfdsfdssd', '9567842009', 'libi@yahoo.com', '9');
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `rollno` varchar(256) NOT NULL,
  `department` varchar(256) NOT NULL,
  `semester` varchar(256) NOT NULL,
  `dob` varchar(256) NOT NULL,
  `address` varchar(1024) NOT NULL,
  `contact` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `yearofadmission` varchar(256) NOT NULL,
  `loginid` varchar(256) NOT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'Libin', '33', 'CSE', 'Semester 6', '03/27/1992', 'vcxvcxcgcx', '9567842009', 'libi@yahoo.com', '2012', '4'), ('2', 'Fazna', '46', 'CSE', 'Semester 6', '09/16/1992', 'sdfdsfdsf', '9567842009', 'fazna@gmail.com', '2012', '5'), ('3', 'Libin', '34', 'CSE', 'Semester 6', '12/09/2015', 'edfdfrdsfr', '9567842009', 'libi@yahoo.com', '2012', '6'), ('4', 'Libin', '45', 'CSE', 'Semester 6', '12/07/2015', 'asdasdas', '9567842009', 'libi@yahoo.com', '2012', '7'), ('5', 'arun', '5', 'CSE', 'Semester 6', '12/23/2015', 'dcgdfsg', '9567842009', 'libi@yahoo.com', '2012', '8');
COMMIT;

-- ----------------------------
--  Table structure for `subjectmarks`
-- ----------------------------
DROP TABLE IF EXISTS `subjectmarks`;
CREATE TABLE `subjectmarks` (
  `markid` int(200) NOT NULL AUTO_INCREMENT,
  `loginid` int(200) NOT NULL,
  `academicid` int(200) NOT NULL,
  `subjectid` int(200) NOT NULL,
  `mark` varchar(256) NOT NULL,
  PRIMARY KEY (`markid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `subjectmarks`
-- ----------------------------
BEGIN;
INSERT INTO `subjectmarks` VALUES ('1', '4', '-1', '1', '101'), ('2', '4', '-1', '2', '89'), ('3', '4', '-1', '1', '101'), ('4', '4', '-1', '2', '89'), ('5', '4', '9', '1', '101'), ('6', '4', '9', '2', '89');
COMMIT;

-- ----------------------------
--  Table structure for `subjects`
-- ----------------------------
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `subjectid` int(200) NOT NULL AUTO_INCREMENT,
  `subject` varchar(256) NOT NULL,
  `semester` varchar(256) NOT NULL,
  `department` varchar(256) NOT NULL,
  `type` varchar(256) NOT NULL,
  PRIMARY KEY (`subjectid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `subjects`
-- ----------------------------
BEGIN;
INSERT INTO `subjects` VALUES ('1', 'Maths 5', 'Semester 6', 'CSE', 'Technical'), ('2', 'DSP', 'Semester 6', 'CSE', 'Normal'), ('3', 'Computer Networks', 'Semester 6', 'CSE', 'Technical');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
