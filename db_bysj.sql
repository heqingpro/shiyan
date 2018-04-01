/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.59 : Database - db_bysj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_bysj` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_bysj`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT '',
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`id`,`name`,`password`) values (1,'root','123456');

/*Table structure for table `tb_lab` */

DROP TABLE IF EXISTS `tb_lab`;

CREATE TABLE `tb_lab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `admin` varchar(30) DEFAULT NULL,
  `outline` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_lab` */

insert  into `tb_lab`(`id`,`name`,`number`,`address`,`major`,`admin`,`outline`) values (1,'单摆实验','1001','**大学**实验室','重力系数测试','张老师',NULL);

/*Table structure for table `tb_labpre` */

DROP TABLE IF EXISTS `tb_labpre`;

CREATE TABLE `tb_labpre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(30) DEFAULT NULL,
  `lab_num` varchar(30) DEFAULT NULL,
  `lab_name` varchar(200) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_labpre` */

insert  into `tb_labpre`(`id`,`stu_num`,`lab_num`,`lab_name`,`date`,`time`) values (1,'2014040203','1001','单摆实验','2017-12-31','16:10:10');

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `roleId` int(11) NOT NULL DEFAULT '0',
  `roleName` varchar(20) DEFAULT NULL,
  `permissions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`roleId`,`roleName`,`permissions`) values (0,'admin',NULL),(1,'teacher',NULL),(2,'student',NULL);

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `school` varchar(30) DEFAULT NULL,
  `stu_class` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

insert  into `tb_student`(`id`,`name`,`password`,`number`,`school`,`stu_class`) values (1,'222','222','222','电子科技大学','20131404'),(2,'44','333','333','333','333'),(3,'333','444','4444','444','444'),(4,'22222','22222','2222','2222','2222'),(6,'555','555','555','555','555');

/*Table structure for table `tb_teacher` */

DROP TABLE IF EXISTS `tb_teacher`;

CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `school` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_teacher` */

/*Table structure for table `tb_userlogin` */

DROP TABLE IF EXISTS `tb_userlogin`;

CREATE TABLE `tb_userlogin` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '2' COMMENT '角色权限',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `tb_userlogin` */

insert  into `tb_userlogin`(`userID`,`userName`,`password`,`role`) values (1,'admin','123',0),(8,'10001','123',2),(9,'222','222',2),(10,'10003','123',2),(11,'10005','123',2),(12,'10004','123',2),(13,'10006','123',2),(14,'1001','123',1),(15,'1002','123',1),(16,'222','222',1),(19,'22222','22222',2),(20,'555','555',2);

/*Table structure for table `user_t` */

DROP TABLE IF EXISTS `user_t`;

CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `user_t`(`id`,`user_name`,`password`,`age`) values (1,'测试','sfasgfaf',24);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
