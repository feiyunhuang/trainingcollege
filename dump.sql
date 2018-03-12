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
/*!40000 ALTER TABLE `changeapproval` ENABLE KEYS */;
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
INSERT INTO `hibernate_sequence` VALUES (4);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,0,1,0),(2,0,1,0),(3,0,1,0);
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
INSERT INTO `registerapproval` VALUES ('M4ZJHRU','学而思','123456','1140617436@qq.com','2018-03-12 16:30:35','上海'),('W151HTE','新希望','123456','1140617436@qq.com','2018-03-12 16:30:17','南京栖霞');
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
INSERT INTO `school` VALUES ('XVQDFKN','新东方','123456','1140617436@qq.com','2018-03-12 16:36:08','南京鼓楼');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
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
INSERT INTO `user` VALUES (1,'1140617436@qq.com','a3caed36f0fe5a01e5f144db8927235e'),(2,'151250066@smail.nju.edu.cn','a3caed36f0fe5a01e5f144db8927235e'),(3,'151250065@smail.nju.edu.cn','a3caed36f0fe5a01e5f144db8927235e');
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
INSERT INTO `userinfo` VALUES (1,'黄韵斐','VALID','男','18994360017','2018-03-12 16:28:15'),(2,'黄泽鹏','VALID','男','1234567890','2018-03-12 16:28:41'),(3,'黄某某','VALID','男','123456','2018-03-12 16:29:01');
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

-- Dump completed on 2018-03-13  0:37:11
