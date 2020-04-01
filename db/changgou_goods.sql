/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25 : Database - changgou_goods
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`changgou_goods` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `changgou_goods`;

/*Table structure for table `tb_brand` */

DROP TABLE IF EXISTS `tb_brand`;

CREATE TABLE `tb_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '品牌名称',
  `image` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片地址',
  `letter` varchar(5) CHARACTER SET utf8 DEFAULT NULL COMMENT '品牌首字母',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_brand` */

insert  into `tb_brand`(`id`,`name`,`image`,`letter`,`seq`) values (1,'品牌一','https://apps.xiangxueyw.com/back//upload/file/images/1531704860768.png','A',1),(2,'品牌二','https://apps.xiangxueyw.com/back//upload/file/images/1531704860768.png','B',1);

/*Table structure for table `tb_sku` */

DROP TABLE IF EXISTS `tb_sku`;

CREATE TABLE `tb_sku` (
  `id` varchar(25) COLLATE utf8_bin NOT NULL COMMENT '商品sku主键id',
  `spu_id` varchar(25) COLLATE utf8_bin NOT NULL COMMENT 'SPU id',
  `sn` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '商品条码',
  `name` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT 'SKU名称',
  `price` int(11) DEFAULT NULL COMMENT '价格（分）',
  `num` int(11) DEFAULT '1' COMMENT '库存数量',
  `alert_num` int(11) DEFAULT NULL COMMENT '库存预警数量',
  `image` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `images` text COLLATE utf8_bin COMMENT '图片列表',
  `weight` int(11) DEFAULT NULL COMMENT '重量（克）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `category_id` bigint(20) DEFAULT NULL COMMENT '类目id',
  `category_name` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '类目名称',
  `spec` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '规格',
  `brand_name` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌名称',
  `sale_num` int(11) DEFAULT '0' COMMENT '销量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论数',
  `state` int(2) DEFAULT '0' COMMENT '状态：0下架 1上架 2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_sku` */

insert  into `tb_sku`(`id`,`spu_id`,`sn`,`name`,`price`,`num`,`alert_num`,`image`,`images`,`weight`,`create_time`,`update_time`,`category_id`,`category_name`,`spec`,`brand_name`,`sale_num`,`comment_num`,`state`) values ('1243458937320112128','1243458936409948160','202003271608100','HM智能手机 蓝色',90000,1000,80,'https://apps.xiangxueyw.com/back//upload/file/images/1531704860768.png','https://apps.xiangxueyw.com/back//upload/file/images/1531704860768.png,https://apps.xiangxueyw.com/back//upload/file/images/1531704860769.png',20,'2020-03-27 08:44:57','2020-03-27 08:44:57',560,'','{\"颜色\": \"蓝色\"}','品牌一',0,0,0),('1243458938104446976','1243458936409948160','202003271608101','HM智能手机 黑色',80000,1000,70,'https://apps.xiangxueyw.com/back//upload/file/images/1531704860768.png','https://apps.xiangxueyw.com/back//upload/file/images/1531704860770.png,https://apps.xiangxueyw.com/back//upload/file/images/1531704860771.png',25,'2020-03-27 08:44:57','2020-03-27 08:44:57',560,'','{\"颜色\": \"黑色\"}','品牌一',0,0,0);

/*Table structure for table `tb_spu` */

DROP TABLE IF EXISTS `tb_spu`;

CREATE TABLE `tb_spu` (
  `id` varchar(25) COLLATE utf8_bin NOT NULL COMMENT '商品主键id',
  `sn` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '货号',
  `name` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT 'SPU名称',
  `caption` varchar(25) COLLATE utf8_bin DEFAULT NULL COMMENT '副标题',
  `brand_id` bigint(20) DEFAULT NULL COMMENT '品牌id',
  `category1_id` bigint(20) DEFAULT NULL COMMENT '一级分类id',
  `category2_id` bigint(20) DEFAULT NULL COMMENT '二级分类id',
  `category3_id` bigint(20) DEFAULT NULL COMMENT '三级分类id',
  `template_id` bigint(20) DEFAULT NULL COMMENT '模板id',
  `freight_id` bigint(20) DEFAULT NULL COMMENT '运费模板id',
  `image` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `images` text COLLATE utf8_bin COMMENT '图片列表',
  `sale_service` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '售后服务',
  `introduction` text COLLATE utf8_bin COMMENT '介绍',
  `spec_items` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '规格列表',
  `param_items` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '参数列表',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论数',
  `is_enable_spec` int(1) DEFAULT '1' COMMENT '是否启用规格:1是 0否',
  `state` int(2) DEFAULT '0' COMMENT '状态：0下架 1上架 2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_spu` */

insert  into `tb_spu`(`id`,`sn`,`name`,`caption`,`brand_id`,`category1_id`,`category2_id`,`category3_id`,`template_id`,`freight_id`,`image`,`images`,`sale_service`,`introduction`,`spec_items`,`param_items`,`comment_num`,`is_enable_spec`,`state`) values ('1243458936409948160','20200327160810','HM智能手机','豪华版',1,558,559,560,42,1,'','[{\"color\":\"银白色\",\"url\":\"https://apps.xiangxueyw.com/back//upload/file/images/1531704860768.png\"}]','','这是测试手机数据','{\"颜色\":[\"金色\",\"黑色\",\"蓝色\"],\"版本\":[\"6GB+64GB\"]}',NULL,0,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
