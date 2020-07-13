/*
SQLyog v10.2 
MySQL - 5.7.23-log : Database - ffuhome
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ffuhome` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ffuhome`;

/*Table structure for table `ffu_application` */

DROP TABLE IF EXISTS `ffu_application`;

CREATE TABLE `ffu_application` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) NOT NULL COMMENT '手机',
  `stadium` varchar(64) DEFAULT NULL COMMENT '场馆',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `league` varchar(64) DEFAULT NULL COMMENT '赛事',
  `realname` varchar(64) DEFAULT NULL COMMENT '负责人',
  `state` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0待审核，1通过，2驳回',
  `remark` varchar(128) DEFAULT NULL COMMENT '驳回原因',
  `channel` varchar(32) DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='泛足联会员注册申请';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
