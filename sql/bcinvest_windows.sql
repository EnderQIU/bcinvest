# Host: localhost  (Version 5.7.16-log)
# Date: 2018-07-08 10:25:39
# Generator: MySQL-Front 6.0  (Build 2.20)

USE bcinvest;

#
# Structure for table "authorization"
#

DROP TABLE IF EXISTS `Authorization`;
CREATE TABLE `Authorization` (
  `Name` varchar(128),
  `Type` int(11),
  `AccountNum` varchar(128),
  `Password` varchar(128),
  `Token` varchar(128) UNIQUE,
  PRIMARY KEY (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "authorization"
#


#
# Structure for table "company"
#

DROP TABLE IF EXISTS `Company`;
CREATE TABLE `Company` (
  `AccountNum` varchar(128),
  `Name` varchar(128),
  `TelNum` varchar(128) DEFAULT NULL,
  `EmailAddress` varchar(128) UNIQUE,
  `Token` varchar(128) UNIQUE,
  `Credit` bigint(20),
  `Status` VARCHAR(128) NULL DEFAULT "unapplied" CHECK (VALUE IN ("unapplied", "checking", "unpassed", "passed")),
 #`company` varchar(128) Default null,
  PRIMARY KEY (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "company"
#



#
# Structure for table "accesstoken"
#

DROP TABLE IF EXISTS `Accesstoken`;
CREATE TABLE `Accesstoken` (
  `AccessToken` varchar(512),
  `ExpiryTime` datetime,
  `AccountNum` varchar(128) DEFAULT '',
  KEY `AccountNum` (`AccountNum`),
  CONSTRAINT `accesstoken_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `Company` (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "accesstoken"
#


#
# Structure for table "companyaddress"
#

DROP TABLE IF EXISTS `CompanyAddress`;
CREATE TABLE `CompanyAddress` (
  `AccountNum` varchar(128),
  `Addr` varchar(128),
  PRIMARY KEY (`AccountNum`),
  CONSTRAINT `companyaddress_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `Company` (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "companyaddress"
#


#
# Structure for table "fundamentalcertificate"
#

DROP TABLE IF EXISTS `FundamentalCertificate`;
CREATE TABLE `FundamentalCertificate` (
  `BusinessLicenceNum` varchar(128),
  `StartDate` datetime,
  `EndDate` datetime,
  `BusinessRegistrationNo` varchar(128),
  `RegisteredCapital` bigint(20),
  `MainBusinessScope` varchar(128),
  `OperationType` int(11),
  `AccountNum` varchar(128),
  PRIMARY KEY (`AccountNum`),
  CONSTRAINT `fundamentalcertificate_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `Company` (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "fundamentalcertificate"
#


#
# Structure for table "report"
#

DROP TABLE IF EXISTS `Report`;
CREATE TABLE `Report` (
  `AccountNum` varchar(128),
  `ReportId` int(11) AUTO_INCREMENT,
  `Date` datetime,
  `Duration` varchar(128),
  PRIMARY KEY (`ReportId`),
  KEY `AuthName` (`AccountNum`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `Authorization` (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "report"
#




DROP table if EXISTS `Guaranty`;
CREATE TABLE `Guaranty`(
  `GuarantyId` int(11) AUTO_INCREMENT,
  `AccountNum` varchar(128),
  `State` int(11),
  `ScopeOfRight` int(11),
  `OwnerName` varchar(128),
  `ReportId` int(11),
  `Type` int(11) DEFAULT '0',
  `EvaluateValue` int(11),
  `Name` varchar(128),
  CONSTRAINT `guaranty_fk_company` FOREIGN KEY (`AccountNum`) REFERENCES `Company` (`AccountNum`),
  CONSTRAINT `guaranty_fk_report` FOREIGN KEY (`ReportId`) REFERENCES `Report` (`ReportId`),
  PRIMARY KEY(`GuarantyId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



#
# Structure for table "machine"
#

DROP TABLE IF EXISTS `Machine`;
CREATE TABLE `Machine` (
  `UsedDays` int(11),
  `Producer` varchar(128),
  `Model` varchar(128),
  `GuarantyId` int(11),
  PRIMARY KEY (`GuarantyId`),
  #KEY `reportId` (`reportId`),
  #CONSTRAINT `machine_ibfk_1` FOREIGN KEY (`reportId`) REFERENCES `report` (`reportId`),
  CONSTRAINT `machine_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `Guaranty` (`GuarantyId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "machine"
#


#
# Structure for table "land"
#

DROP TABLE IF EXISTS `Land`;
CREATE TABLE `Land` (
  `Addr` varchar(128),
  `Area` bigint(20),
  `GuarantyId` int(11),
  PRIMARY KEY (`GuarantyId`),
  #KEY `reportId` (`reportId`),
  #CONSTRAINT `land_ibfk_1` FOREIGN KEY (`reportId`) REFERENCES `report` (`reportId`),
  CONSTRAINT `land_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `Guaranty` (`GuarantyId`) ON DELETE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "land"
#


#
# Structure for table "house"
#

DROP TABLE IF EXISTS `House`;
CREATE TABLE `House` (
  `Addr` varchar(128),
  `Zip` varchar(128) DEFAULT NULL,
  `HousingCertificatedId` varchar(128),
  `GuarantyId` int(11),
  PRIMARY KEY (`GuarantyId`),
  #KEY `reportId` (`reportId`),
  #CONSTRAINT `house_ibfk_1` FOREIGN KEY (`reportId`) REFERENCES `report` (`reportId`),
  CONSTRAINT `house_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `Guaranty` (`GuarantyId`) ON DELETE CASCADE

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "house"
#


#
# Structure for table "securitiesinformation"
#

DROP TABLE IF EXISTS `Securitiesinformation`;
CREATE TABLE `Securitiesinformation` (
  `AccountNum` varchar(128),
  `StockCode` varchar(128),
  `ListedApproval` varchar(128),
  `StockAbbr` varchar(128),
  `IssuePrice` bigint(20) DEFAULT NULL,
  `StockType` int(11),
  `LaunchDate` datetime,
  `Circulation` bigint(20),
  `IsValid` tinyint(4),
  `Remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`),
  CONSTRAINT `securitiesinformation_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `Company` (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "securitiesinformation"
#







DROP TABLE IF EXISTS `Credit`;
CREATE TABLE `Credit`(
  `AccountNum` varchar(128),
  `GuarantyId` int(11),
  `ReportId` int(11),
  `Type` tinyint(1),
  PRIMARY KEY(`AccountNum`,`GuarantyId`,`ReportId`),
  CONSTRAINT `credit_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `Guaranty` (`GuarantyId`),
  CONSTRAINT `credit_fk_company` FOREIGN KEY (`AccountNum`) REFERENCES `Company` (`AccountNum`),
  CONSTRAINT `credit_fk_report` FOREIGN KEY (`ReportId`) REFERENCES `Report` (`ReportId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Protocol`;
CREATE TABLE IF NOT EXISTS `Protocol` (
  `ProtocolId` INT(11) NOT NULL AUTO_INCREMENT,
  `GurantyId` INT(11) NOT NULL,
  `StartDate` DATE NOT NULL,
  `Duration` VARCHAR(128) NOT NULL,
  `EndDate` DATE NOT NULL,
  `Message` MEDIUMTEXT NULL,
  `Condition` VARCHAR(45) NULL,
  PRIMARY KEY (`ProtocolId`),
  CONSTRAINT `fk_protocol_to_guranty`
  FOREIGN KEY (`GurantyId`)
  REFERENCES `Guaranty` (`GuarantyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;