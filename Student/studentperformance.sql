/*
SQLyog Ultimate v8.55 
MySQL - 5.1.57-community : Database - studentperformance
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentperformance` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `studentperformance`;

/*Table structure for table `academics` */

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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

/*Data for the table `academics` */

insert  into `academics`(`academicsId`,`loginid`,`semester`,`totalmarks`,`percentage`,`backlogs`,`certificate`,`status`) values (1,6,'Semester 7','1024','78','0','simple-blue-wave.jpg',1),(2,6,'Semester 6','1024','78','0','1883318.jpg',-1),(3,5,'Semester 6','1024','74','0','bk-eco-ga.jpg',1),(4,5,'Semester 7','1024','75','0','eco-angled2.png',1),(5,4,'Semester 6','1024','75','0','lion-hd-wallpaper-22.jpg',-1),(6,4,'Semester 6','1024','73','0','31.jpg',-1),(7,4,'Semester 6','1024','73','0','2.jpg',-1),(8,4,'Semester 6','1024','75','0','2064.jpg',-1),(9,4,'Semester 6','1024','78','0','assassins-creed-revelations-full-hd-wallpapers-1920x1080.jpg',-1),(10,11,'Semester 1','1284','82.83','0','WIN_20151223_193127.JPG',0),(11,11,'Semester 1','1170','75','0','WIN_20151223_193127.JPG',0),(12,1,'Semester 6','1284','82.83','0','WIN_20151223_193127.JPG',0),(13,14,'Semester 6','1284','82.83','0','WIN_20151223_193127.JPG',0),(14,4,'Semester 3','1284','82.83','0','WIN_20151223_193127.JPG',-1),(15,22,'Semester 1','1128','73','0','WIN_20151223_193127.JPG',-1),(16,22,'Semester 3','746','72','0','WIN_20151223_193127.JPG',-1),(17,22,'Semester 4','832','75','0','WIN_20151223_193127.JPG',-1),(18,23,'Semester 1','1127','72','0','WIN_20151223_193127.JPG',-1),(19,23,'Semester 3','872','74','0','WIN_20151223_193127.JPG',-1),(20,23,'Semester 4','856','75','0','WIN_20151223_193127.JPG',-1),(21,4,'Semester 1 & 2','1174','75','0','WIN_20151223_193127.JPG',1),(22,4,'Semester 3','823','74','0','WIN_20151223_193127.JPG',-1),(23,4,'Semester 4','767','73','0','WIN_20151223_193127.JPG',-1),(24,4,'Semester 5','777','74','0','WIN_20151223_193127.JPG',-1),(25,24,'Semester 1 & 2','1196','77','0','DESCRIPTION.docx',1),(26,24,'Semester 3','852','77','0','DESCRIPTION.docx',1),(27,24,'Semester 4','862','78','0','DESCRIPTION.docx',1),(28,24,'Semester 5','872','79','0','DESCRIPTION.docx',1),(29,24,'Semester 1 & 2','1101','71','0','DESCRIPTION.docx.pdf',1),(30,24,'Semester 3','847','77','0','DESCRIPTION.docx',1),(31,24,'Semester 4','864','78','0','DESCRIPTION.docx',1),(32,24,'Semester 5','842','76','0','DESCRIPTION.docx',1),(33,25,'Semester 5','842','76','0','DESCRIPTION.docx',1),(34,25,'Semester 4','864','78','0','DESCRIPTION.docx',1),(35,25,'Semester 1 & 2','1101','71','0','DESCRIPTION.docx',1),(36,25,'Semester 3','847','77','0','DESCRIPTION.docx',1),(37,27,'Semester 1 & 2','1230','79','0','DESCRIPTION.docx',1),(38,27,'Semester 3','836','76','0','DESCRIPTION.docx',1),(39,27,'Semester 4','868','78','0','DESCRIPTION.docx',1),(40,27,'Semester 5','861','78','0','DESCRIPTION.docx',1),(41,24,'Semester 1 & 2','1196','77','0','DESCRIPTION.docx',0),(42,24,'Semester 3','852','77','0','DESCRIPTION.docx',0),(43,24,'Semester 4','862','78','0','DESCRIPTION.docx',0),(44,24,'Semester 5','872','79','0','DESCRIPTION.docx',0),(45,25,'Semester 1 & 2','1101','71','0','DESCRIPTION.docx',0),(46,25,'Semester 3','847','77','0','DESCRIPTION.docx',0),(47,25,'Semester 4','864','78','0','DESCRIPTION.docx',0),(48,25,'Semester 5','842','76','0','DESCRIPTION.docx',0),(49,28,'Semester 1 & 2','1184','76','0','DESCRIPTION.docx',0),(50,28,'Semester 3','911','83','0','datamining-intro-IEP.ppt',0),(51,28,'Semester 4','889','80','0','DESCRIPTION.docx',0),(52,28,'Semester 5','910','82','0','DESCRIPTION.docx',0),(53,29,'Semester 1 & 2','1181','76','0','DESCRIPTION.docx',0),(54,29,'Semester 3','876','79','0','DESCRIPTION.docx',0),(55,29,'Semester 4','868','78','0','DESCRIPTION.docx',0),(56,29,'Semester 5','825','75','0','DESCRIPTION.docx',0);

/*Table structure for table `companies` */

DROP TABLE IF EXISTS `companies`;

CREATE TABLE `companies` (
  `companyid` int(200) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `location` varchar(256) DEFAULT NULL,
  `platforms` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `companies` */

insert  into `companies`(`companyid`,`name`,`location`,`platforms`) values (1,'TCS','Cochin','Java, Android, Hadoop, Matlab'),(3,'Infosys','Bangalore','Java, Hadoop, Matlab');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `loginid` int(200) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `type` varchar(256) NOT NULL,
  `status` int(200) NOT NULL,
  PRIMARY KEY (`loginid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`loginid`,`username`,`password`,`type`,`status`) values (1,'admin','admin','Admin',1),(4,'libin_33','libin','Student',1),(5,'fazna_46','student','Student',1),(6,'libin_34','student','Student',1),(7,'libin_45','student','Student',1),(8,'arun_5','student','Student',1),(9,'libin_S123','1','PlacementOfficer',1),(10,'ranjeet kumar patel_1','student','Student',1),(11,'neethu sunny_2','student','Student',1),(12,'renjith kumar patel_65','student','Student',1),(13,'renu_s3456','officer','PlacementOfficer',1),(14,'alsab_23','student','Student',1),(15,'mariya_101','student','Student',1),(18,'renu_11','student','Student',1),(19,'renu_11','student','Student',1),(20,'renu_11','student','Student',1),(21,'renu_1','student','Student',1),(22,'sreeram_77','student','Student',1),(23,'aakash sinha_200','aakash sinha_200','Student',1),(24,'sandra mariya peter_14120066','student','Student',1),(25,'nayana v kumari_14120043','student','Student',1),(27,'remya_14120057','student','Student',1),(28,'fasna_14120024','student','Student',1),(29,'arya_14120015','student','Student',1);

/*Table structure for table `placement` */

DROP TABLE IF EXISTS `placement`;

CREATE TABLE `placement` (
  `placementid` int(200) NOT NULL AUTO_INCREMENT,
  `driveid` int(200) DEFAULT NULL,
  `companyid` int(200) DEFAULT NULL,
  `studentid` int(200) DEFAULT NULL,
  `status` int(200) DEFAULT NULL,
  PRIMARY KEY (`placementid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `placement` */

insert  into `placement`(`placementid`,`driveid`,`companyid`,`studentid`,`status`) values (1,1,1,6,1),(2,1,1,5,1),(3,2,3,4,1),(5,3,1,25,1),(6,3,1,24,1);

/*Table structure for table `placementdrive` */

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `placementdrive` */

insert  into `placementdrive`(`placementid`,`companyid`,`venue`,`date`,`time`,`post`,`minpercentage`,`maxbacklogs`,`status`) values (1,1,'CUSAT','12/19/2015','10:30 am','Junior Software Engineer','68','1',1),(2,3,'CUSAT','12/25/2015','10:00 AM','Software Engineer','70','0',1),(3,1,'cusat','12/05/2016','12pm','software engineer','60','0',0);

/*Table structure for table `placementofficers` */

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `placementofficers` */

insert  into `placementofficers`(`Id`,`staffId`,`name`,`address`,`contact`,`email`,`loginid`) values (1,'S123','Libin','xfdsfdssd','9567842009','libi@yahoo.com',9),(2,'s3456','Renu','renu\r\nernakulam','9283748398','renu@gmail.com',13),(3,'ghh','jk','','','',26);

/*Table structure for table `student` */

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`studentid`,`name`,`rollno`,`department`,`semester`,`dob`,`address`,`contact`,`email`,`yearofadmission`,`loginid`) values (1,'Libin','33','CSE','Semester 6','03/27/1992','vcxvcxcgcx','9567842009','libi@yahoo.com','2012','4'),(2,'Fazna','46','CSE','Semester 6','09/16/1992','sdfdsfdsf','9567842009','fazna@gmail.com','2012','5'),(3,'Libin','34','CSE','Semester 6','12/09/2015','edfdfrdsfr','9567842009','libi@yahoo.com','2012','6'),(4,'Libin','45','CSE','Semester 6','12/07/2015','asdasdas','9567842009','libi@yahoo.com','2012','7'),(5,'arun','5','CSE','Semester 6','12/23/2015','dcgdfsg','9567842009','libi@yahoo.com','2012','8'),(6,'mariya','15','CSE','Semester 4','12/09/1991','dji','9878965456','d@gmail.com','2012','15'),(7,'Renu','1','CSE','Semester 4','01/19/1990','jhuhijkj','9876543454','ranjeet@gmail.com','2012','21'),(8,'sreeram','77','CSE','Semester 1','01/19/1990','sreram','9876543454','sreeram@gmail.com','2012','22'),(9,'aakash sinha','200','CSE','Semester 1','12/04/1991','aakash','9876543454','aakaash@gmail.com','2012','23'),(10,'Sandra Mariya Peter','14120066','CSE','Semester 1 & 2','04/01/1992','Sandra Mariya Peter\r\ntrivandrum','9267498378','sandra@gmail.com','2011','24'),(11,'Nayana V Kumari','14120043','CSE','Semester 1 & 2','01/04/1993','Nayana\r\neranakulam','9246785436','nayana@gmail.com','2011','25'),(12,'Remya','14120057','CSE','Semester 1 & 2','2/01/1991','remya \r\nkollam','9345324589','remya@gmail.com','2011','27'),(13,'Fasna','14120024','CSE','Semester 1 & 2','04/2/1990','fasna\r\nkozhikode','9232148952','fasna@gmail.com','2011','28'),(14,'Arya','14120015','CSE','Semester 1 & 2','2/02/1991','Arya\r\nkollam','9735490127','arya@gmail.com','2011','29');

/*Table structure for table `subjectmarks` */

DROP TABLE IF EXISTS `subjectmarks`;

CREATE TABLE `subjectmarks` (
  `markid` int(200) NOT NULL AUTO_INCREMENT,
  `loginid` int(200) NOT NULL,
  `academicid` int(200) NOT NULL,
  `subjectid` int(200) NOT NULL,
  `mark` varchar(256) NOT NULL,
  PRIMARY KEY (`markid`)
) ENGINE=InnoDB AUTO_INCREMENT=394 DEFAULT CHARSET=latin1;

/*Data for the table `subjectmarks` */

insert  into `subjectmarks`(`markid`,`loginid`,`academicid`,`subjectid`,`mark`) values (18,4,14,23,'76'),(19,4,14,16,'123'),(20,4,14,17,'77'),(21,4,14,18,'76'),(22,4,14,19,'98'),(23,4,14,20,'100'),(24,4,14,21,'134'),(25,22,15,11,'101'),(26,22,15,12,'85'),(27,22,15,13,'77'),(28,22,15,14,'82'),(29,22,15,4,'117'),(30,22,15,5,'98'),(31,22,15,6,'82'),(32,22,15,7,'91'),(33,22,15,8,'116'),(34,22,15,9,'112'),(35,22,15,10,'91'),(36,22,16,22,'94'),(37,22,16,23,'98'),(38,22,16,16,'116'),(39,22,16,17,'98'),(40,22,16,18,'105'),(41,22,16,19,'95'),(42,22,16,20,'93'),(43,22,16,21,'89'),(44,22,17,24,'111'),(45,22,17,25,'82'),(46,22,17,26,'86'),(47,22,17,27,'85'),(48,22,17,28,'110'),(49,22,17,29,'85'),(50,22,17,30,'90'),(51,22,17,31,'94'),(52,23,18,11,'96'),(53,23,18,12,'99'),(54,23,18,13,'78'),(55,23,18,14,'77'),(56,23,18,4,'110'),(57,23,18,5,'106'),(58,23,18,6,'94'),(59,23,18,7,'98'),(60,23,18,8,'75'),(61,23,18,9,'111'),(62,23,18,10,'108'),(63,23,19,22,'76'),(64,23,19,23,'86'),(65,23,19,16,'117'),(66,23,19,17,'127'),(67,23,19,18,'129'),(68,23,19,19,'123'),(69,23,19,20,'121'),(70,23,19,21,'93'),(71,23,20,24,'128'),(72,23,20,25,'99'),(73,23,20,26,'104'),(74,23,20,27,'118'),(75,23,20,28,'128'),(76,23,20,29,'100'),(77,23,20,30,'85'),(78,23,20,31,'94'),(79,4,21,1,'124'),(80,4,21,34,'99'),(81,4,21,46,'85'),(82,4,21,47,'109'),(83,4,21,48,'89'),(84,4,21,59,'102'),(85,4,21,38,'78'),(86,4,21,49,'115'),(87,4,21,60,'111'),(88,4,21,50,'79'),(89,4,21,61,'96'),(90,4,22,35,'121'),(91,4,22,39,'77'),(92,4,22,40,'123'),(93,4,22,51,'102'),(94,4,22,52,'97'),(95,4,22,63,'105'),(96,4,22,53,'91'),(97,4,22,54,'70'),(98,4,23,55,'131'),(99,4,23,56,'109'),(100,4,23,36,'117'),(101,4,23,37,'88'),(102,4,23,41,'108'),(103,4,23,42,'84'),(104,4,23,64,'123'),(105,4,23,43,'65'),(106,4,24,44,'90'),(107,4,24,66,'114'),(108,4,24,45,'75'),(109,4,24,67,'110'),(110,4,24,57,'105'),(111,4,24,58,'106'),(112,4,24,62,'115'),(113,4,24,65,'134'),(219,27,37,1,'131'),(220,27,37,34,'103'),(221,27,37,46,'124'),(222,27,37,47,'125'),(223,27,37,48,'130'),(224,27,37,59,'122'),(225,27,37,38,'94'),(226,27,37,49,'108'),(227,27,37,60,'121'),(228,27,37,50,'79'),(229,27,37,61,'93'),(230,27,38,35,'128'),(231,27,38,39,'94'),(232,27,38,40,'111'),(233,27,38,51,'110'),(234,27,38,52,'110'),(235,27,38,63,'107'),(236,27,38,53,'111'),(237,27,38,54,'65'),(238,27,39,55,'105'),(239,27,39,56,'115'),(240,27,39,36,'137'),(241,27,39,37,'104'),(242,27,39,41,'112'),(243,27,39,42,'98'),(244,27,39,64,'106'),(245,27,39,43,'91'),(246,27,40,44,'93'),(247,27,40,66,'105'),(248,27,40,45,'89'),(249,27,40,67,'119'),(250,27,40,57,'123'),(251,27,40,58,'98'),(252,27,40,62,'111'),(253,27,40,65,'123'),(254,24,41,1,'132'),(255,24,41,34,'102'),(256,24,41,46,'120'),(257,24,41,47,'125'),(258,24,41,48,'121'),(259,24,41,59,'134'),(260,24,41,38,'80'),(261,24,41,49,'99'),(262,24,41,60,'92'),(263,24,41,50,'82'),(264,24,41,61,'109'),(265,24,42,35,'140'),(266,24,42,39,'87'),(267,24,42,40,'108'),(268,24,42,51,'103'),(269,24,42,52,'104'),(270,24,42,63,'119'),(271,24,42,53,'113'),(272,24,42,54,'78'),(273,24,43,55,'115'),(274,24,43,56,'116'),(275,24,43,36,'123'),(276,24,43,37,'108'),(277,24,43,41,'111'),(278,24,43,42,'96'),(279,24,43,64,'108'),(280,24,43,43,'85'),(281,24,44,44,'93'),(282,24,44,66,'110'),(283,24,44,45,'89'),(284,24,44,67,'115'),(285,24,44,57,'127'),(286,24,44,58,'105'),(287,24,44,62,'105'),(288,24,44,65,'128'),(289,25,45,1,'82'),(290,25,45,34,'87'),(291,25,45,46,'85'),(292,25,45,47,'122'),(293,25,45,48,'112'),(294,25,45,59,'134'),(295,25,45,38,'83'),(296,25,45,49,'103'),(297,25,45,60,'125'),(298,25,45,50,'69'),(299,25,45,61,'99'),(300,25,46,35,'117'),(301,25,46,39,'74'),(302,25,46,40,'112'),(303,25,46,51,'125'),(304,25,46,52,'107'),(305,25,46,63,'119'),(306,25,46,53,'109'),(307,25,46,54,'84'),(308,25,47,55,'118'),(309,25,47,56,'111'),(310,25,47,36,'131'),(311,25,47,37,'104'),(312,25,47,41,'120'),(313,25,47,42,'88'),(314,25,47,64,'110'),(315,25,47,43,'82'),(316,25,48,44,'70'),(317,25,48,66,'104'),(318,25,48,45,'77'),(319,25,48,67,'122'),(320,25,48,57,'122'),(321,25,48,58,'115'),(322,25,48,62,'113'),(323,25,48,65,'119'),(324,28,49,1,'126'),(325,28,49,34,'95'),(326,28,49,46,'139'),(327,28,49,47,'123'),(328,28,49,48,'108'),(329,28,49,59,'120'),(330,28,49,38,'85'),(331,28,49,49,'122'),(332,28,49,60,'99'),(333,28,49,50,'78'),(334,28,49,61,'89'),(335,28,50,35,'126'),(336,28,50,39,'95'),(337,28,50,40,'121'),(338,28,50,51,'129'),(339,28,50,52,'122'),(340,28,50,63,'123'),(341,28,50,53,'113'),(342,28,50,54,'82'),(343,28,51,55,'111'),(344,28,51,56,'102'),(345,28,51,36,'134'),(346,28,51,37,'124'),(347,28,51,41,'120'),(348,28,51,42,'97'),(349,28,51,64,'109'),(350,28,51,43,'92'),(351,28,52,44,'85'),(352,28,52,66,'113'),(353,28,52,45,'93'),(354,28,52,67,'119'),(355,28,52,57,'129'),(356,28,52,58,'109'),(357,28,52,62,'122'),(358,28,52,65,'140'),(359,29,53,1,'124'),(360,29,53,34,'80'),(361,29,53,46,'124'),(362,29,53,47,'132'),(363,29,53,48,'117'),(364,29,53,59,'134'),(365,29,53,38,'87'),(366,29,53,49,'104'),(367,29,53,60,'102'),(368,29,53,50,'83'),(369,29,53,61,'94'),(370,29,54,35,'137'),(371,29,54,39,'88'),(372,29,54,40,'117'),(373,29,54,51,'113'),(374,29,54,52,'102'),(375,29,54,63,'108'),(376,29,54,53,'119'),(377,29,54,54,'92'),(378,29,55,55,'116'),(379,29,55,56,'101'),(380,29,55,36,'130'),(381,29,55,37,'114'),(382,29,55,41,'105'),(383,29,55,42,'93'),(384,29,55,64,'123'),(385,29,55,43,'86'),(386,29,56,44,'82'),(387,29,56,66,'102'),(388,29,56,45,'81'),(389,29,56,67,'108'),(390,29,56,57,'104'),(391,29,56,58,'95'),(392,29,56,62,'105'),(393,29,56,65,'141');

/*Table structure for table `subjects` */

DROP TABLE IF EXISTS `subjects`;

CREATE TABLE `subjects` (
  `subjectid` int(200) NOT NULL AUTO_INCREMENT,
  `subject` varchar(256) NOT NULL,
  `semester` varchar(256) NOT NULL,
  `department` varchar(256) NOT NULL,
  `type` varchar(256) NOT NULL,
  PRIMARY KEY (`subjectid`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;

/*Data for the table `subjects` */

insert  into `subjects`(`subjectid`,`subject`,`semester`,`department`,`type`) values (1,'maths','Semester 1 & 2','CSE','Logical'),(34,'mechanics','Semester 1 & 2','CSE','Logical'),(35,'Discrete computational structures','Semester 3','CSE','Logical'),(36,'Operational research','Semester 4','CSE','Logical'),(37,'autometa','Semester 4','CSE','Logical'),(38,'Computer programming lab','Semester 1 & 2','CSE','Programming'),(39,'Object oriented programming lab','Semester 3','CSE','Programming'),(40,'Object oriented programming','Semester 3','CSE','Programming'),(41,'Microprocessor','Semester 4','CSE','Programming'),(42,'Data structure lab','Semester 4','CSE','Programming'),(43,'Pc hardware and microprocessor lab','Semester 4','CSE','Programming'),(44,'Mini project','Semester 5','CSE','Programming'),(45,'System programming LAB','Semester 5','CSE','Programming'),(46,'graphics','Semester 1 & 2','CSE','Technical'),(47,'civil and mechanical','Semester 1 & 2','CSE','Technical'),(48,'Electrical engineering and electronics','Semester 1 & 2','CSE','Technical'),(49,'computer programming','Semester 1 & 2','CSE','Technical'),(50,'Electrical and mechanical workshop','Semester 1 & 2','CSE','Technical'),(51,'Electrical technology','Semester 3','CSE','Technical'),(52,'Electronic circuit and logic design','Semester 3','CSE','Technical'),(53,'Computer organisation','Semester 3','CSE','Technical'),(54,'Logic design lab','Semester 3','CSE','Technical'),(55,'Data structure','Semester 4','CSE','Technical'),(56,'Data communication','Semester 4','CSE','Technical'),(57,'Computer graphics and animation','Semester 5','CSE','Technical'),(58,'Software engineering','Semester 5','CSE','Technical'),(59,'physics','Semester 1 & 2','CSE','Theoretical'),(60,'chemistry','Semester 1 & 2','CSE','Theoretical'),(61,'Technical communication and social science','Semester 1 & 2','CSE','Theoretical'),(62,'SYSTEM PROGRAMMING','Semester 5','CSE','Theoretical'),(63,'MATHS','Semester 3','CSE','Logical'),(64,'MATHS','Semester 4','CSE','Logical'),(65,'MATHS','Semester 5','CSE','Logical'),(66,'Knowledge engineering','Semester 5','CSE','Technical'),(67,'dbms','Semester 5','CSE','Technical');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
