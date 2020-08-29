-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: module
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `checkexaminationdto`
--

DROP TABLE IF EXISTS `checkexaminationdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `checkexaminationdto` (
  `StudentID` int(10) unsigned NOT NULL,
  `UserName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ClassID` int(10) unsigned NOT NULL,
  `SubjectID` int(10) unsigned NOT NULL,
  `ScoresType` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `ScoresWish` float(4,2) NOT NULL DEFAULT '0.00',
  `ScoresCheck` float(4,2) NOT NULL DEFAULT '0.00',
  `Reason` text COLLATE utf8mb4_unicode_ci,
  `StatusCheck` char(1) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`StudentID`,`UserName`,`ClassID`,`SubjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkexaminationdto`
--

LOCK TABLES `checkexaminationdto` WRITE;
/*!40000 ALTER TABLE `checkexaminationdto` DISABLE KEYS */;
INSERT INTO `checkexaminationdto` VALUES (1,'giaovu',4,1,'O',10.00,10.00,'Điểm cộng có nhầm lẫn. Thầy kiểm tra lại','C','2019-08-25 22:32:58','2019-08-25 22:37:19',1);
/*!40000 ALTER TABLE `checkexaminationdto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkexaminationscheduledto`
--

DROP TABLE IF EXISTS `checkexaminationscheduledto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `checkexaminationscheduledto` (
  `UserName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ClassID` int(10) unsigned NOT NULL,
  `SubjectID` int(10) unsigned NOT NULL,
  `FormDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `ToDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`UserName`,`ClassID`,`SubjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkexaminationscheduledto`
--

LOCK TABLES `checkexaminationscheduledto` WRITE;
/*!40000 ALTER TABLE `checkexaminationscheduledto` DISABLE KEYS */;
INSERT INTO `checkexaminationscheduledto` VALUES ('giaovu',4,1,'2019-08-25 22:30:41','2019-09-30 22:30:44','2019-08-25 22:30:56','2019-08-25 22:30:56',1);
/*!40000 ALTER TABLE `checkexaminationscheduledto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classdto`
--

DROP TABLE IF EXISTS `classdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classdto` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ClassCode` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classdto`
--

LOCK TABLES `classdto` WRITE;
/*!40000 ALTER TABLE `classdto` DISABLE KEYS */;
INSERT INTO `classdto` VALUES (1,'15HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(2,'16HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(3,'17HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(4,'18HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(5,'19HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1),(6,'20HCB','2019-08-23 23:30:45','2019-08-23 23:30:45',1);
/*!40000 ALTER TABLE `classdto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheduledto`
--

DROP TABLE IF EXISTS `scheduledto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `scheduledto` (
  `ClassID` int(10) unsigned NOT NULL,
  `SubjectID` int(10) unsigned NOT NULL,
  `ClassRoom` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ClassID`,`SubjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduledto`
--

LOCK TABLES `scheduledto` WRITE;
/*!40000 ALTER TABLE `scheduledto` DISABLE KEYS */;
INSERT INTO `scheduledto` VALUES (3,3,'C32','2019-08-25 22:01:32','2019-08-25 22:01:32',1),(3,4,'C32','2019-08-25 22:01:32','2019-08-25 22:01:32',1),(4,1,'C31','2019-08-25 22:01:45','2019-08-25 22:01:45',1),(4,2,'C31','2019-08-25 22:01:45','2019-08-25 22:01:45',1);
/*!40000 ALTER TABLE `scheduledto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentdto`
--

DROP TABLE IF EXISTS `studentdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `studentdto` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `StudentCode` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `StudentName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '',
  `Gender` int(1) unsigned DEFAULT NULL,
  `IdentityNumber` char(15) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `ClassID` int(10) unsigned NOT NULL,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdto`
--

LOCK TABLES `studentdto` WRITE;
/*!40000 ALTER TABLE `studentdto` DISABLE KEYS */;
INSERT INTO `studentdto` VALUES (1,'1742001','Nguyễn Văn A',1,'123456789',3,'2019-08-25 21:53:30','2019-08-25 21:53:30',1),(2,'1742002','Trần Văn B',1,'234567891',3,'2019-08-25 21:53:30','2019-08-25 21:53:30',1),(3,'1742003','Huỳnh Thị C',0,'345678912',3,'2019-08-25 21:53:30','2019-08-25 21:53:30',1),(4,'1742004','Mai Văn D',1,'456789123',3,'2019-08-25 21:53:30','2019-08-25 21:53:30',1),(5,'1742005','Hồ Thị E',0,'567891234',3,'2019-08-25 21:53:30','2019-08-25 21:53:30',1),(6,'1842001','Lý Văn F',1,'678912345',4,'2019-08-25 21:54:02','2019-08-25 21:54:02',1),(7,'1842002','Chiêu Văn G',1,'789123456',4,'2019-08-25 21:54:02','2019-08-25 21:54:02',1),(8,'1842003','Trần Thị H',0,'891234567',4,'2019-08-25 21:54:02','2019-08-25 21:54:02',1),(9,'1842004','Mạc Văn I',1,'912345678',4,'2019-08-25 21:54:02','2019-08-25 21:54:02',1),(10,'1842005','Văn Thị J',0,'987654321',4,'2019-08-25 21:54:02','2019-08-25 21:54:02',1),(11,'1942001','Võ Văn A',1,'253698236',5,'2019-08-25 21:58:55','2019-08-25 21:58:55',1);
/*!40000 ALTER TABLE `studentdto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectdto`
--

DROP TABLE IF EXISTS `subjectdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subjectdto` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `SubjectCode` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SubjectName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectdto`
--

LOCK TABLES `subjectdto` WRITE;
/*!40000 ALTER TABLE `subjectdto` DISABLE KEYS */;
INSERT INTO `subjectdto` VALUES (1,'CTT001','Lập trình ứng dụng Java','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(2,'CTT002','Mạng máy tính','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(3,'CTT011','Thiết kế giao diện','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(4,'CTT012','Kiểm chứng phần mềm','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(5,'CTT021','Nhập môn lập trình','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(6,'CTT022','Tin học cơ sở','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(7,'CTT034','Khai thác dữ liệu','2019-08-23 23:24:37','2019-08-23 23:24:37',1),(8,'CTT035','Hệ quản trị cơ sở dữ liệu','2019-08-23 23:24:37','2019-08-23 23:24:37',1);
/*!40000 ALTER TABLE `subjectdto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transcriptdto`
--

DROP TABLE IF EXISTS `transcriptdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transcriptdto` (
  `StudentID` int(10) unsigned NOT NULL,
  `ClassID` int(10) unsigned NOT NULL,
  `SubjectID` int(10) unsigned NOT NULL,
  `ScoresMid` float(4,2) NOT NULL DEFAULT '0.00',
  `ScoresEnd` float(4,2) NOT NULL DEFAULT '0.00',
  `ScoresOther` float(4,2) NOT NULL DEFAULT '0.00',
  `ScoresSum` float(4,2) NOT NULL DEFAULT '0.00',
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`StudentID`,`ClassID`,`SubjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcriptdto`
--

LOCK TABLES `transcriptdto` WRITE;
/*!40000 ALTER TABLE `transcriptdto` DISABLE KEYS */;
INSERT INTO `transcriptdto` VALUES (1,4,1,9.00,9.00,10.00,9.00,'2019-08-25 22:15:28','2019-08-25 22:37:19',1),(5,4,1,1.00,2.00,3.00,2.00,'2019-08-25 22:22:41','2019-08-25 22:22:41',1),(6,4,1,0.00,0.00,0.00,0.00,'2019-08-25 22:01:46','2019-08-25 22:01:46',1),(6,4,2,0.00,0.00,0.00,0.00,'2019-08-25 22:01:47','2019-08-25 22:01:47',1),(7,4,1,4.00,5.00,6.00,5.00,'2019-08-25 22:01:46','2019-08-25 22:22:41',1),(7,4,2,0.00,0.00,0.00,0.00,'2019-08-25 22:01:47','2019-08-25 22:01:47',1),(8,4,1,7.00,8.00,9.00,8.50,'2019-08-25 22:01:46','2019-08-25 22:22:41',1),(8,4,2,0.00,0.00,0.00,0.00,'2019-08-25 22:01:47','2019-08-25 22:01:47',1),(9,4,1,2.00,4.00,6.00,4.50,'2019-08-25 22:01:46','2019-08-25 22:22:41',1),(9,4,2,0.00,0.00,0.00,0.00,'2019-08-25 22:01:47','2019-08-25 22:13:13',0),(10,4,1,8.00,10.00,2.00,9.50,'2019-08-25 22:01:46','2019-08-25 22:22:41',1),(10,4,2,0.00,0.00,0.00,0.00,'2019-08-25 22:01:47','2019-08-25 22:01:47',1);
/*!40000 ALTER TABLE `transcriptdto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdto`
--

DROP TABLE IF EXISTS `userdto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userdto` (
  `UserName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `IsAdmin` tinyint(1) DEFAULT '1',
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `UpdatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `IsActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdto`
--

LOCK TABLES `userdto` WRITE;
/*!40000 ALTER TABLE `userdto` DISABLE KEYS */;
INSERT INTO `userdto` VALUES ('1','U/Cqtosk2xat5slgQ5ZWyw==',1,'2019-08-23 23:34:58','2019-08-23 23:34:58',1),('1742001','oi9cS54z0NWVBSmeBeH2zw==',0,'2019-08-25 21:53:31','2019-08-25 21:53:31',1),('1742002','T2jk5Frnoy4RLW0/qzYvyA==',0,'2019-08-25 21:53:34','2019-08-25 21:53:34',1),('1742003','4kVcq64ng3rSJT81cahUgQ==',0,'2019-08-25 21:53:36','2019-08-25 21:53:36',1),('1742004','eD5LwkVHFd9vRQ9qD/QhXw==',0,'2019-08-25 21:53:39','2019-08-25 21:53:39',1),('1742005','z3BCj/XwVgvHY7aVfRjvmg==',0,'2019-08-25 21:53:42','2019-08-25 21:53:42',1),('1842001','FQtXJTMryRp6N0ogXTNRNg==',0,'2019-08-25 21:54:02','2019-08-25 21:54:02',1),('1842002','HOIMWvZDpAPWv6uQDNjuzA==',0,'2019-08-25 21:54:02','2019-08-25 21:54:02',1),('1842003','44Q/XGGiLlsk5AF+b5srgQ==',0,'2019-08-25 21:54:04','2019-08-25 21:54:04',1),('1842004','gM8t74R/IzqXxLT1XTnK3A==',0,'2019-08-25 21:54:05','2019-08-25 21:54:05',1),('1842005','cAERiMcDogzxINdCgzprFw==',0,'2019-08-25 21:54:09','2019-08-25 21:54:09',1),('giaovu','O/m3jr7GqjOANy2mD9meww==',1,'2019-08-23 23:39:10','2019-08-23 23:39:10',1);
/*!40000 ALTER TABLE `userdto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-25 22:44:45
