﻿-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: bcinvest
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `Accesstoken`
--

DROP TABLE IF EXISTS `Accesstoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Accesstoken` (
  `AccessToken` varchar(512) DEFAULT NULL,
  `ExpiryTime` datetime DEFAULT NULL,
  `AccountNum` varchar(128) DEFAULT '',
  KEY `AccountNum` (`AccountNum`),
  CONSTRAINT `accesstoken_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Accesstoken`
--

LOCK TABLES `Accesstoken` WRITE;
/*!40000 ALTER TABLE `Accesstoken` DISABLE KEYS */;
/*!40000 ALTER TABLE `Accesstoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Authorization`
--

DROP TABLE IF EXISTS `Authorization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Authorization` (
  `Name` varchar(128) DEFAULT NULL,
  `Type` int(11) DEFAULT NULL,
  `AccountNum` varchar(128) NOT NULL,
  `Token` varchar(128) DEFAULT NULL,
  `Password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`),
  UNIQUE KEY `Token` (`Token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Authorization`
--

LOCK TABLES `Authorization` WRITE;
/*!40000 ALTER TABLE `Authorization` DISABLE KEYS */;
INSERT INTO `Authorization` VALUES ('citibank',0,'1','123','123');
/*!40000 ALTER TABLE `Authorization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Company`
--

DROP TABLE IF EXISTS `Company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Company` (
  `AccountNum` varchar(128) NOT NULL,
  `Name` varchar(128) DEFAULT NULL,
  `TelNum` varchar(128) DEFAULT NULL,
  `EmailAddress` varchar(128) DEFAULT NULL,
  `Token` varchar(128) DEFAULT NULL,
  `Credit` bigint(20) DEFAULT NULL,
  `Status` varchar(128) DEFAULT 'unapplied',
  PRIMARY KEY (`AccountNum`),
  UNIQUE KEY `EmailAddress` (`EmailAddress`),
  UNIQUE KEY `Token` (`Token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Company`
--

LOCK TABLES `Company` WRITE;
/*!40000 ALTER TABLE `Company` DISABLE KEYS */;
INSERT INTO `Company` VALUES ('456','',NULL,'a@a.com','456',NULL,'unapplied');
/*!40000 ALTER TABLE `Company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CompanyAddress`
--

DROP TABLE IF EXISTS `CompanyAddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CompanyAddress` (
  `AccountNum` varchar(128) NOT NULL,
  `Addr` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`),
  CONSTRAINT `companyaddress_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CompanyAddress`
--

LOCK TABLES `CompanyAddress` WRITE;
/*!40000 ALTER TABLE `CompanyAddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `CompanyAddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Credit`
--

DROP TABLE IF EXISTS `Credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Credit` (
  `AccountNum` varchar(128) NOT NULL,
  `GuarantyId` int(11) NOT NULL,
  `ReportId` int(11) NOT NULL,
  `Type` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`,`GuarantyId`,`ReportId`),
  KEY `credit_fk_guaranty` (`GuarantyId`),
  KEY `credit_fk_report` (`ReportId`),
  CONSTRAINT `credit_fk_company` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`),
  CONSTRAINT `credit_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`),
  CONSTRAINT `credit_fk_report` FOREIGN KEY (`ReportId`) REFERENCES `report` (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Credit`
--

LOCK TABLES `Credit` WRITE;
/*!40000 ALTER TABLE `Credit` DISABLE KEYS */;
/*!40000 ALTER TABLE `Credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FundamentalCertificate`
--

DROP TABLE IF EXISTS `FundamentalCertificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FundamentalCertificate` (
  `BusinessLicenceNum` varchar(128) DEFAULT NULL,
  `StartDate` datetime DEFAULT NULL,
  `EndDate` datetime DEFAULT NULL,
  `BusinessRegistrationNo` varchar(128) DEFAULT NULL,
  `RegisteredCapital` bigint(20) DEFAULT NULL,
  `MainBusinessScope` varchar(128) DEFAULT NULL,
  `OperationType` int(11) DEFAULT NULL,
  `AccountNum` varchar(128) NOT NULL,
  PRIMARY KEY (`AccountNum`),
  CONSTRAINT `fundamentalcertificate_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FundamentalCertificate`
--

LOCK TABLES `FundamentalCertificate` WRITE;
/*!40000 ALTER TABLE `FundamentalCertificate` DISABLE KEYS */;
/*!40000 ALTER TABLE `FundamentalCertificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Guaranty`
--

DROP TABLE IF EXISTS `Guaranty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Guaranty` (
  `GuarantyId` int(11) NOT NULL AUTO_INCREMENT,
  `AccountNum` varchar(128) DEFAULT NULL,
  `State` int(11) DEFAULT NULL,
  `ScopeOfRight` int(11) DEFAULT NULL,
  `OwnerName` varchar(128) DEFAULT NULL,
  `ReportId` int(11) DEFAULT NULL,
  `Type` int(11) DEFAULT '0',
  `EvaluateValue` int(11) DEFAULT NULL,
  `Name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`GuarantyId`),
  KEY `guaranty_fk_company` (`AccountNum`),
  KEY `guaranty_fk_report` (`ReportId`),
  CONSTRAINT `guaranty_fk_company` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`),
  CONSTRAINT `guaranty_fk_report` FOREIGN KEY (`ReportId`) REFERENCES `report` (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Guaranty`
--

LOCK TABLES `Guaranty` WRITE;
/*!40000 ALTER TABLE `Guaranty` DISABLE KEYS */;
/*!40000 ALTER TABLE `Guaranty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `House`
--

DROP TABLE IF EXISTS `House`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `House` (
  `Addr` varchar(128) DEFAULT NULL,
  `Zip` varchar(128) DEFAULT NULL,
  `HousingCertificatedId` varchar(128) DEFAULT NULL,
  `GuarantyId` int(11) NOT NULL,
  PRIMARY KEY (`GuarantyId`),
  CONSTRAINT `house_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `House`
--

LOCK TABLES `House` WRITE;
/*!40000 ALTER TABLE `House` DISABLE KEYS */;
/*!40000 ALTER TABLE `House` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Land`
--

DROP TABLE IF EXISTS `Land`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Land` (
  `Addr` varchar(128) DEFAULT NULL,
  `Area` bigint(20) DEFAULT NULL,
  `GuarantyId` int(11) NOT NULL,
  PRIMARY KEY (`GuarantyId`),
  CONSTRAINT `land_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Land`
--

LOCK TABLES `Land` WRITE;
/*!40000 ALTER TABLE `Land` DISABLE KEYS */;
/*!40000 ALTER TABLE `Land` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Machine`
--

DROP TABLE IF EXISTS `Machine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Machine` (
  `UsedDays` int(11) DEFAULT NULL,
  `Producer` varchar(128) DEFAULT NULL,
  `Model` varchar(128) DEFAULT NULL,
  `GuarantyId` int(11) NOT NULL,
  PRIMARY KEY (`GuarantyId`),
  CONSTRAINT `machine_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Machine`
--

LOCK TABLES `Machine` WRITE;
/*!40000 ALTER TABLE `Machine` DISABLE KEYS */;
/*!40000 ALTER TABLE `Machine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Message`
--

DROP TABLE IF EXISTS `Message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(45) DEFAULT NULL,
  `fromUserNum` varchar(128) DEFAULT NULL,
  `toUserNum` varchar(128) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Message`
--

LOCK TABLES `Message` WRITE;
/*!40000 ALTER TABLE `Message` DISABLE KEYS */;
/*!40000 ALTER TABLE `Message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Protocol`
--

DROP TABLE IF EXISTS `Protocol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Protocol` (
  `ProtocolId` int(11) NOT NULL AUTO_INCREMENT,
  `GurantyId` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `Duration` varchar(128) NOT NULL,
  `EndDate` date NOT NULL,
  `Message` mediumtext,
  `Condition` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ProtocolId`),
  KEY `fk_protocol_to_guranty` (`GurantyId`),
  CONSTRAINT `fk_protocol_to_guranty` FOREIGN KEY (`GurantyId`) REFERENCES `guaranty` (`guarantyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Protocol`
--

LOCK TABLES `Protocol` WRITE;
/*!40000 ALTER TABLE `Protocol` DISABLE KEYS */;
/*!40000 ALTER TABLE `Protocol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Report`
--

DROP TABLE IF EXISTS `Report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Report` (
  `AccountNum` varchar(128) DEFAULT NULL,
  `ReportId` int(11) NOT NULL AUTO_INCREMENT,
  `Date` datetime DEFAULT NULL,
  `Duration` varchar(128) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ReportId`),
  KEY `AccountNum` (`AccountNum`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `authorization` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Report`
--

LOCK TABLES `Report` WRITE;
/*!40000 ALTER TABLE `Report` DISABLE KEYS */;
/*!40000 ALTER TABLE `Report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Securitiesinformation`
--

DROP TABLE IF EXISTS `Securitiesinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Securitiesinformation` (
  `AccountNum` varchar(128) NOT NULL,
  `StockCode` varchar(128) DEFAULT NULL,
  `ListedApproval` varchar(128) DEFAULT NULL,
  `StockAbbr` varchar(128) DEFAULT NULL,
  `IssuePrice` bigint(20) DEFAULT NULL,
  `StockType` int(11) DEFAULT NULL,
  `LaunchDate` datetime DEFAULT NULL,
  `Circulation` bigint(20) DEFAULT NULL,
  `IsValid` tinyint(4) DEFAULT NULL,
  `Remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`),
  CONSTRAINT `securitiesinformation_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Securitiesinformation`
--

LOCK TABLES `Securitiesinformation` WRITE;
/*!40000 ALTER TABLE `Securitiesinformation` DISABLE KEYS */;
/*!40000 ALTER TABLE `Securitiesinformation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-14 19:49:27
