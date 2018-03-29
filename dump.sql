-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: trainingcollege
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allocateclass`
--

DROP TABLE IF EXISTS `allocateclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allocateclass` (
  `id` int(11) NOT NULL,
  `classid` int(11) NOT NULL,
  `classname` varchar(50) COLLATE utf8_bin NOT NULL,
  `userid` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_bin NOT NULL,
  `classnum` int(11) NOT NULL,
  `classbegintime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `week` int(11) NOT NULL,
  `classstate` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allocateclass`
--

LOCK TABLES `allocateclass` WRITE;
/*!40000 ALTER TABLE `allocateclass` DISABLE KEYS */;
INSERT INTO `allocateclass` VALUES (1,1,'大学数学',1,'小黄',1,'2018-04-04 16:59:16',10,1,0);
/*!40000 ALTER TABLE `allocateclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `account` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES ('18994360017','123456',984.2),('XVQDFKN','123456',0);
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `changeapproval`
--

DROP TABLE IF EXISTS `changeapproval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `changeapproval` (
  `id` varchar(10) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin NOT NULL,
  `registdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changeapproval`
--

LOCK TABLES `changeapproval` WRITE;
/*!40000 ALTER TABLE `changeapproval` DISABLE KEYS */;
INSERT INTO `changeapproval` VALUES ('I8AX8NN','111','123456','1140617436@qq.com','2018-03-23 09:46:16','南京鼓楼');
/*!40000 ALTER TABLE `changeapproval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `schoolid` varchar(10) COLLATE utf8_bin NOT NULL,
  `timeaweek` varchar(10) COLLATE utf8_bin NOT NULL,
  `week` int(11) NOT NULL,
  `classnum` int(11) NOT NULL,
  `studentaclass` int(11) NOT NULL,
  `price` double NOT NULL,
  `teacherid` int(11) NOT NULL,
  `daytime` varchar(50) COLLATE utf8_bin NOT NULL,
  `registdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `begindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'大学数学','XVQDFKN','0000011',10,3,10,1000,1,'10:00-12:00','2018-03-14 16:59:16','2018-04-14 16:59:16','黄老师授课'),(2,'德育课程','XVQDFKN','0000001',20,1,20,1500,2,'12:00-14:00','2018-03-14 16:59:16','2018-04-14 16:59:16','惠老师授课'),(4,'高等数学','XVQDFKN','0100001',10,2,5,1500,1,'10:00-12:00','2018-03-15 03:33:04','2018-04-13 16:00:00','泰州黄老师的课'),(5,'高中生物','XVQDFKN','0000011',10,3,40,500,1,'16:00-18:00','2018-03-15 03:37:03','2018-04-19 16:00:00','生物课'),(6,'大学数学','XVQDFKN','0000011',10,3,10,1000,1,'10:00-12:00','2018-03-14 16:59:16','2018-04-14 16:59:16','黄老师授课'),(7,'德育课程','XVQDFKN','0000001',20,1,20,1500,2,'12:00-14:00','2018-03-14 16:59:16','2018-04-14 16:59:16','惠老师授课'),(8,'高等数学','XVQDFKN','0100001',10,2,5,1500,1,'10:00-12:00','2018-03-15 03:33:04','2018-04-13 16:00:00','泰州黄老师的课'),(9,'高中生物','XVQDFKN','0000011',10,3,40,500,1,'16:00-18:00','2018-03-15 03:37:03','2018-04-19 16:00:00','生物课'),(10,'大学数学','XVQDFKN','0000011',10,3,10,1000,1,'10:00-12:00','2018-03-14 16:59:16','2018-04-14 16:59:16','黄老师授课'),(11,'德育课程','XVQDFKN','0000001',20,1,20,1500,2,'12:00-14:00','2018-03-14 16:59:16','2018-04-14 16:59:16','惠老师授课'),(12,'高等数学','XVQDFKN','0100001',10,2,5,1500,1,'10:00-12:00','2018-03-15 03:33:04','2018-04-13 16:00:00','泰州黄老师的课'),(13,'高中生物','XVQDFKN','0000011',10,3,40,500,1,'16:00-18:00','2018-03-15 03:37:03','2018-04-19 16:00:00','生物课'),(46,'高考数学','XVQDFKN','1100000',10,1,10,3000,3,'10:00-12:00','2018-03-19 11:09:46','2018-04-18 16:00:00','好课'),(59,'测试课程','I8AX8NN','1000000',10,2,10,1000,58,'11:00-12:00','2018-03-23 09:47:31','2018-04-04 16:00:00','ok');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (61);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('admin','admin');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `classid` int(11) NOT NULL,
  `classname` varchar(50) COLLATE utf8_bin NOT NULL,
  `registdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark`
--

LOCK TABLES `mark` WRITE;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
INSERT INTO `mark` VALUES (52,1,1,'大学数学','2018-03-22 15:48:19',90),(60,1,1,'大学数学','2018-03-23 09:53:01',100);
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `point` int(11) NOT NULL DEFAULT '0',
  `level` int(11) NOT NULL DEFAULT '1',
  `accumulate` int(11) DEFAULT '0',
  `coupon` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,600,1,0,6),(2,0,1,0,0),(57,0,1,0,0);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registerapproval`
--

DROP TABLE IF EXISTS `registerapproval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registerapproval` (
  `id` varchar(10) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin NOT NULL,
  `registdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registerapproval`
--

LOCK TABLES `registerapproval` WRITE;
/*!40000 ALTER TABLE `registerapproval` DISABLE KEYS */;
/*!40000 ALTER TABLE `registerapproval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `id` varchar(10) COLLATE utf8_bin NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin NOT NULL,
  `registdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES ('I8AX8NN','检查','123456','1140617436@qq.com','2018-03-23 09:45:23','南京鼓楼'),('M4ZJHRU','学而思','123456','1140617436@qq.com','2018-03-13 02:31:48','上海'),('W151HTE','新希望','123456','1140617436@qq.com','2018-03-13 02:28:19','南京栖霞'),('XVQDFKN','新东方','123456','1140617436@qq.com','2018-03-12 16:36:08','南京鼓楼');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `schoolid` varchar(10) COLLATE utf8_bin NOT NULL,
  `description` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'黄泽鹏','XVQDFKN','数学满分老师！'),(2,'惠晗涛','XVQDFKN','德语老师！'),(3,'王后雄','XVQDFKN','出了很多的辅导书！'),(47,'123','XVQDFKN','123'),(48,'1234','XVQDFKN','123'),(49,'14','XVQDFKN','23234'),(54,'老师','UF1EQJM','ok'),(58,'黄老师','I8AX8NN','ok');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainingorder`
--

DROP TABLE IF EXISTS `trainingorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainingorder` (
  `id` varchar(10) COLLATE utf8_bin NOT NULL,
  `userid` int(11) NOT NULL,
  `schoolid` varchar(10) COLLATE utf8_bin NOT NULL,
  `teacherid` int(11) NOT NULL,
  `classid` int(11) NOT NULL,
  `price` double NOT NULL,
  `peoplenum` int(11) NOT NULL,
  `totalprice` double NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `topaytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `classbegintime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bankaccount` varchar(20) COLLATE utf8_bin NOT NULL,
  `usecoupon` int(11) NOT NULL,
  `orderstate` varchar(10) COLLATE utf8_bin NOT NULL,
  `chooseclass` int(11) NOT NULL,
  `firstclass` int(11) NOT NULL,
  `secondclass` int(11) NOT NULL,
  `thirdclass` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainingorder`
--

LOCK TABLES `trainingorder` WRITE;
/*!40000 ALTER TABLE `trainingorder` DISABLE KEYS */;
INSERT INTO `trainingorder` VALUES ('H75CWANI6N',1,'I8AX8NN',58,59,1000,1,979,'2018-03-23 09:50:17','2018-03-23 10:05:17','2018-04-04 16:00:00','18994360017',1,'CANCEL',1,1,0,0),('LPVBX4O6IX',1,'XVQDFKN',1,4,1500,1,1470,'2018-03-21 12:19:42','2018-03-21 12:34:41','2018-04-09 16:00:00','18994360017',0,'DRAWBACK',1,1,0,0),('NI1O56V52O',1,'XVQDFKN',1,50,1200,1,1166,'2018-03-21 06:10:15','2018-03-21 06:25:14','2018-03-31 16:00:00','18994360017',10,'DRAWBACK',0,0,0,0),('PWHUX6A3RC',1,'I8AX8NN',58,59,1000,1,979,'2018-03-23 09:48:28','2018-03-23 10:03:28','2018-03-31 16:00:00','18994360017',1,'DRAWBACK',1,1,0,0),('Q5W4BH7616',1,'XVQDFKN',2,2,1500,3,4400,'2018-03-21 02:44:55','2018-03-21 02:59:54','2018-04-14 16:59:16','18994360017',10,'CANCEL',1,0,0,1),('ZZZQOEFLD5',1,'I8AX8NN',58,59,1000,9,8820,'2018-03-23 09:49:02','2018-03-23 10:04:02','2018-04-04 16:00:00','18994360017',0,'PAYED',0,0,0,0);
/*!40000 ALTER TABLE `trainingorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `mail` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'1140617436@qq.com','a3caed36f0fe5a01e5f144db8927235e'),(2,'151250066@smail.nju.edu.cn','a3caed36f0fe5a01e5f144db8927235e'),(57,'151250065@smail.nju.edu.cn','a3caed36f0fe5a01e5f144db8927235e');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `memberState` varchar(10) COLLATE utf8_bin NOT NULL,
  `sex` varchar(10) COLLATE utf8_bin NOT NULL,
  `phonenum` varchar(20) COLLATE utf8_bin NOT NULL,
  `registdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'小黄','VALID','男','18994360017','2018-03-12 16:28:15'),(2,'黄泽鹏','VALID','男','1234567890','2018-03-12 16:28:41'),(57,'检查','VALID','男','1234567890','2018-03-23 09:43:40');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-29 11:37:49
