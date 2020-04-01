/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25 : Database - changgou_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`changgou_system` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `changgou_system`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `login_name` varchar(25) COLLATE utf8_bin NOT NULL COMMENT '登录名',
  `password` varchar(80) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `state` int(1) NOT NULL DEFAULT '1' COMMENT '状态：0冻结 1正常 2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`id`,`login_name`,`password`,`state`) values (1,'admin','$2a$10$xswfl4j4zGaNNL3eS9atxuOR0Qa8CRr3u6fvN38wsBW0QWgfJIMYe',1),(2,'test','$2a$10$xswfl4j4zGaNNL3eS9atxuOR0Qa8CRr3u6fvN38wsBW0QWgfJIMYe',0),(3,'Flouis','$2a$10$ldW7k9PoNtVDaTycnpSR9OVHgVJUJE4sLWPkjfn8Yb4skgK5irqj2',1),(4,'operator','$2a$10$WpNn1u/GOY1y0ij/xorteORkm7.2sSlD1M2NFQBrvYUk2hcRIx1G6',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
