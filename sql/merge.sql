-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
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
  KEY `AccountNum` (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `addresslist`
--

DROP TABLE IF EXISTS `addresslist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresslist` (
  `address` varchar(512) NOT NULL,
  PRIMARY KEY (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `Lock` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`),
  UNIQUE KEY `EmailAddress` (`EmailAddress`),
  UNIQUE KEY `Token` (`Token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `Lock` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`AccountNum`,`GuarantyId`,`ReportId`),
  KEY `credit_fk_guaranty` (`GuarantyId`),
  KEY `credit_fk_report` (`ReportId`),
  CONSTRAINT `credit_fk_report` FOREIGN KEY (`ReportId`) REFERENCES `report` (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `credit_chain`
--

DROP TABLE IF EXISTS `credit_chain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_chain` (
  `this_hash` varchar(64) NOT NULL,
  `time_stamp` timestamp NOT NULL,
  `previous_hash` varchar(64) NOT NULL,
  `length` bigint(20) NOT NULL,
  `is_main` tinyint(1) NOT NULL,
  `address` varchar(512) NOT NULL,
  PRIMARY KEY (`this_hash`),
  KEY `credit_chain_addresslist_address_fk` (`address`),
  CONSTRAINT `credit_chain_addresslist_address_fk` FOREIGN KEY (`address`) REFERENCES `addresslist` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `credit_data`
--

DROP TABLE IF EXISTS `credit_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_data` (
  `block_hash` varchar(64) NOT NULL,
  `id` varchar(256) NOT NULL,
  `variation` varchar(128) NOT NULL,
  `value` varchar(128) NOT NULL,
  `remarks` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`block_hash`,`id`),
  CONSTRAINT `credit_data_chain_this_hash_fk` FOREIGN KEY (`block_hash`) REFERENCES `credit_chain` (`this_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `credit_main_chain_view`
--

DROP TABLE IF EXISTS `credit_main_chain_view`;
/*!50001 DROP VIEW IF EXISTS `credit_main_chain_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `credit_main_chain_view` AS SELECT
 1 AS `id`,
 1 AS `value`,
 1 AS `variation`,
 1 AS `remarks`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `credit_most_front_block_info`
--

DROP TABLE IF EXISTS `credit_most_front_block_info`;
/*!50001 DROP VIEW IF EXISTS `credit_most_front_block_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `credit_most_front_block_info` AS SELECT
 1 AS `this_hash`,
 1 AS `time_stamp`,
 1 AS `previous_hash`,
 1 AS `length`,
 1 AS `is_main`,
 1 AS `address`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `credit_ready_main_chain_view`
--

DROP TABLE IF EXISTS `credit_ready_main_chain_view`;
/*!50001 DROP VIEW IF EXISTS `credit_ready_main_chain_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `credit_ready_main_chain_view` AS SELECT
 1 AS `id`,
 1 AS `value`,
 1 AS `variation`,
 1 AS `remarks`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `CreditUpdateTask`
--

DROP TABLE IF EXISTS `CreditUpdateTask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CreditUpdateTask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `AccountNum` varchar(128) DEFAULT NULL,
  `previousCredit` int(11) DEFAULT NULL,
  `delta` int(11) DEFAULT NULL,
  `state` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `Lock` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`GuarantyId`),
  KEY `guaranty_fk_company` (`AccountNum`),
  KEY `guaranty_fk_report` (`ReportId`),
  CONSTRAINT `guaranty_fk_report` FOREIGN KEY (`ReportId`) REFERENCES `report` (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `guaranty_chain`
--

DROP TABLE IF EXISTS `guaranty_chain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guaranty_chain` (
  `this_hash` varchar(64) NOT NULL,
  `time_stamp` timestamp NOT NULL,
  `previous_hash` varchar(64) NOT NULL,
  `length` bigint(20) NOT NULL,
  `is_main` tinyint(1) NOT NULL,
  `address` varchar(512) NOT NULL,
  PRIMARY KEY (`this_hash`),
  KEY `guaranty_chain_addresslist_address_fk` (`address`),
  CONSTRAINT `guaranty_chain_addresslist_address_fk` FOREIGN KEY (`address`) REFERENCES `addresslist` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `guaranty_data`
--

DROP TABLE IF EXISTS `guaranty_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guaranty_data` (
  `block_hash` varchar(64) NOT NULL,
  `id` varchar(256) NOT NULL,
  `variation` varchar(128) NOT NULL,
  `value` varchar(128) NOT NULL,
  `remarks` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`block_hash`,`id`),
  CONSTRAINT `guaranty_data_chain_this_hash_fk` FOREIGN KEY (`block_hash`) REFERENCES `guaranty_chain` (`this_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `guaranty_main_chain_view`
--

DROP TABLE IF EXISTS `guaranty_main_chain_view`;
/*!50001 DROP VIEW IF EXISTS `guaranty_main_chain_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `guaranty_main_chain_view` AS SELECT
 1 AS `id`,
 1 AS `value`,
 1 AS `variation`,
 1 AS `remarks`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `guaranty_most_front_block_info`
--

DROP TABLE IF EXISTS `guaranty_most_front_block_info`;
/*!50001 DROP VIEW IF EXISTS `guaranty_most_front_block_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `guaranty_most_front_block_info` AS SELECT
 1 AS `this_hash`,
 1 AS `time_stamp`,
 1 AS `previous_hash`,
 1 AS `length`,
 1 AS `is_main`,
 1 AS `address`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `guaranty_ready_main_chain_view`
--

DROP TABLE IF EXISTS `guaranty_ready_main_chain_view`;
/*!50001 DROP VIEW IF EXISTS `guaranty_ready_main_chain_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `guaranty_ready_main_chain_view` AS SELECT
 1 AS `id`,
 1 AS `value`,
 1 AS `variation`,
 1 AS `remarks`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `GuarantyStateUpdateTask`
--

DROP TABLE IF EXISTS `GuarantyStateUpdateTask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GuarantyStateUpdateTask` (
  `taskId` int(11) NOT NULL AUTO_INCREMENT,
  `guarantyId` int(11) DEFAULT NULL,
  `previousState` int(11) DEFAULT NULL,
  `stateWillUpdateTo` int(11) DEFAULT NULL,
  `taskState` varchar(128) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  PRIMARY KEY (`taskId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Protocol`
--

DROP TABLE IF EXISTS `Protocol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Protocol` (
  `ProtocolId` int(11) NOT NULL AUTO_INCREMENT,
  `GuarantyId` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `Duration` varchar(128) NOT NULL,
  `EndDate` date,
  `Message` mediumtext,
  `State` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ProtocolId`),
  KEY `fk_protocol_to_guranty` (`GurantyId`),
  CONSTRAINT `fk_protocol_to_guranty` FOREIGN KEY (`GurantyId`) REFERENCES `guaranty` (`guarantyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Final view structure for view `credit_main_chain_view`
--

/*!50001 DROP VIEW IF EXISTS `credit_main_chain_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `credit_main_chain_view` AS select `One`.`id` AS `id`,`One`.`value` AS `value`,`One`.`variation` AS `variation`,`One`.`remarks` AS `remarks` from (`credit_chain` join `credit_data` `One` on((`credit_chain`.`this_hash` = `One`.`block_hash`))) where ((`credit_chain`.`is_main` = 1) and `credit_chain`.`length` >= all (select max(`credit_chain`.`length`) from (`credit_chain` join `credit_data` `Two` on((`credit_chain`.`this_hash` = `Two`.`block_hash`))) where ((`credit_chain`.`is_main` = 1) and (`One`.`id` = `Two`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `credit_most_front_block_info`
--

/*!50001 DROP VIEW IF EXISTS `credit_most_front_block_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `credit_most_front_block_info` AS select `credit_chain`.`this_hash` AS `this_hash`,`credit_chain`.`time_stamp` AS `time_stamp`,`credit_chain`.`previous_hash` AS `previous_hash`,`credit_chain`.`length` AS `length`,`credit_chain`.`is_main` AS `is_main`,`credit_chain`.`address` AS `address` from `credit_chain` where ((`credit_chain`.`is_main` = 1) and `credit_chain`.`length` >= all (select max(`credit_chain`.`length`) from `credit_chain` where (`credit_chain`.`is_main` = 1))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `credit_ready_main_chain_view`
--

/*!50001 DROP VIEW IF EXISTS `credit_ready_main_chain_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `credit_ready_main_chain_view` AS select `One`.`id` AS `id`,`One`.`value` AS `value`,`One`.`variation` AS `variation`,`One`.`remarks` AS `remarks` from (`credit_chain` join `credit_data` `One` on((`credit_chain`.`this_hash` = `One`.`block_hash`))) where ((`credit_chain`.`is_main` = 1) and `credit_chain`.`length` >= all (select max(`credit_chain`.`length`) from (`credit_chain` join `credit_data` `Two` on((`credit_chain`.`this_hash` = `Two`.`block_hash`))) where ((`credit_chain`.`is_main` = 1) and (`One`.`id` = `Two`.`id`) and (`credit_chain`.`length` + 6) <= all (select `guaranty_most_front_block_info`.`length` from `guaranty_most_front_block_info`))) and (`credit_chain`.`length` + 6) <= all (select `guaranty_most_front_block_info`.`length` from `guaranty_most_front_block_info`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `guaranty_main_chain_view`
--

/*!50001 DROP VIEW IF EXISTS `guaranty_main_chain_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `guaranty_main_chain_view` AS select `One`.`id` AS `id`,`One`.`value` AS `value`,`One`.`variation` AS `variation`,`One`.`remarks` AS `remarks` from (`guaranty_chain` join `guaranty_data` `One` on((`guaranty_chain`.`this_hash` = `One`.`block_hash`))) where ((`guaranty_chain`.`is_main` = 1) and `guaranty_chain`.`length` >= all (select max(`guaranty_chain`.`length`) from (`guaranty_chain` join `guaranty_data` `Two` on((`guaranty_chain`.`this_hash` = `Two`.`block_hash`))) where ((`guaranty_chain`.`is_main` = 1) and (`One`.`id` = `Two`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `guaranty_most_front_block_info`
--

/*!50001 DROP VIEW IF EXISTS `guaranty_most_front_block_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `guaranty_most_front_block_info` AS select `guaranty_chain`.`this_hash` AS `this_hash`,`guaranty_chain`.`time_stamp` AS `time_stamp`,`guaranty_chain`.`previous_hash` AS `previous_hash`,`guaranty_chain`.`length` AS `length`,`guaranty_chain`.`is_main` AS `is_main`,`guaranty_chain`.`address` AS `address` from `guaranty_chain` where ((`guaranty_chain`.`is_main` = 1) and `guaranty_chain`.`length` >= all (select max(`guaranty_chain`.`length`) from `guaranty_chain` where (`guaranty_chain`.`is_main` = 1))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `guaranty_ready_main_chain_view`
--

/*!50001 DROP VIEW IF EXISTS `guaranty_ready_main_chain_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `guaranty_ready_main_chain_view` AS select `One`.`id` AS `id`,`One`.`value` AS `value`,`One`.`variation` AS `variation`,`One`.`remarks` AS `remarks` from (`guaranty_chain` join `guaranty_data` `One` on((`guaranty_chain`.`this_hash` = `One`.`block_hash`))) where ((`guaranty_chain`.`is_main` = 1) and `guaranty_chain`.`length` >= all (select max(`guaranty_chain`.`length`) from (`guaranty_chain` join `guaranty_data` `Two` on((`guaranty_chain`.`this_hash` = `Two`.`block_hash`))) where ((`guaranty_chain`.`is_main` = 1) and (`One`.`id` = `Two`.`id`) and (`guaranty_chain`.`length` + 6) <= all (select `guaranty_most_front_block_info`.`length` from `guaranty_most_front_block_info`))) and (`guaranty_chain`.`length` + 6) <= all (select `guaranty_most_front_block_info`.`length` from `guaranty_most_front_block_info`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-18 15:35:06
