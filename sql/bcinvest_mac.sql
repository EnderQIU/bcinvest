CREATE TABLE `Accesstoken` (
  `AccessToken` varchar(512) DEFAULT NULL,
  `ExpiryTime` datetime DEFAULT NULL,
  `AccountNum` varchar(128) DEFAULT '',
  KEY `AccountNum` (`AccountNum`),
  CONSTRAINT `accesstoken_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Authorization` (
  `Name` varchar(128) DEFAULT NULL,
  `Type` int(11) DEFAULT NULL,
  `AccountNum` varchar(128) NOT NULL,
  `Password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Company` (
  `AccountNum` varchar(128) NOT NULL,
  `Name` varchar(128) DEFAULT NULL,
  `TelNum` varchar(128) DEFAULT NULL,
  `EmailAddress` varchar(128) DEFAULT NULL,
  `Token` varchar(128) DEFAULT NULL,
  `Credit` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`),
  UNIQUE KEY `EmailAddress` (`EmailAddress`),
  UNIQUE KEY `Token` (`Token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `CompanyAddress` (
  `AccountNum` varchar(128) NOT NULL,
  `Addr` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`),
  CONSTRAINT `companyaddress_ibfk_1` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Credit` (
  `AccountNum` varchar(128) NOT NULL,
  `GuarantyId` int(11) NOT NULL,
  `ReportId` int(11) NOT NULL,
  `Type` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`AccountNum`,`GuarantyId`,`ReportId`),
  KEY `credit_fk_guaranty` (`GuarantyId`),
  CONSTRAINT `credit_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Guaranty` (
  `GuarantyId` int(11) NOT NULL,
  `AccountNum` varchar(128) DEFAULT NULL,
  `State` int(11) DEFAULT NULL,
  `ScopeOfRight` int(11) DEFAULT NULL,
  `OwnerName` varchar(128) DEFAULT NULL,
  `ReportId` int(11) DEFAULT NULL,
  `EvaluateValue` int(11) DEFAULT NULL,
  `Name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`GuarantyId`),
  KEY `guaranty_fk_company` (`AccountNum`),
  KEY `guaranty_fk_report` (`ReportId`),
  CONSTRAINT `guaranty_fk_company` FOREIGN KEY (`AccountNum`) REFERENCES `company` (`accountnum`),
  CONSTRAINT `guaranty_fk_report` FOREIGN KEY (`ReportId`) REFERENCES `report` (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `House` (
  `Addr` varchar(128) DEFAULT NULL,
  `Zip` varchar(128) DEFAULT NULL,
  `HousingCertificatedId` varchar(128) DEFAULT NULL,
  `GuarantyId` int(11) NOT NULL,
  PRIMARY KEY (`GuarantyId`),
  CONSTRAINT `house_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Land` (
  `Addr` varchar(128) DEFAULT NULL,
  `Area` bigint(20) DEFAULT NULL,
  `GuarantyId` int(11) NOT NULL,
  PRIMARY KEY (`GuarantyId`),
  CONSTRAINT `land_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Machine` (
  `UsedDays` int(11) DEFAULT NULL,
  `Producer` varchar(128) DEFAULT NULL,
  `Model` varchar(128) DEFAULT NULL,
  `GuarantyId` int(11) NOT NULL,
  PRIMARY KEY (`GuarantyId`),
  CONSTRAINT `machine_fk_guaranty` FOREIGN KEY (`GuarantyId`) REFERENCES `guaranty` (`guarantyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Protocol` (
  `ProtocolId` int(11) NOT NULL,
  `GurantyId` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `Message` mediumtext,
  `Condition` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ProtocolId`),
  KEY `fk_protocol_to_guranty` (`GurantyId`),
  CONSTRAINT `fk_protocol_to_guranty` FOREIGN KEY (`GurantyId`) REFERENCES `guaranty` (`guarantyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Report` (
  `AuthName` varchar(128) DEFAULT NULL,
  `ReportId` int(11) NOT NULL,
  `Date` datetime DEFAULT NULL,
  `Duration` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ReportId`),
  KEY `AuthName` (`AuthName`),
  CONSTRAINT `report_ibfk_1` FOREIGN KEY (`AuthName`) REFERENCES `authorization` (`accountnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8
