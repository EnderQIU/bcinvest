CREATE DATABASE `bcinvest` /*!40100 DEFAULT CHARACTER SET utf8 */

CREATE TABLE `AccessToken` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(128) DEFAULT NULL,
  `expire_time` varchar(45) DEFAULT NULL,
  `company_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL COMMENT 'Bank or authority',
  `token` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `token` varchar(45) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL COMMENT '"unapplied", "checking", "unpassed", "passed"',
  `address` varchar(45) DEFAULT NULL,
  `business_license_code` varchar(45) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `business_registration_code` varchar(45) DEFAULT NULL,
  `industry` varchar(45) DEFAULT NULL,
  `registed_capital` varchar(45) DEFAULT NULL,
  `operation_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Guaranty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `right_scope` varchar(45) DEFAULT NULL,
  `owner_name` varchar(45) DEFAULT NULL,
  `report_id` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `evaluate_value` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Protocol` (
  `id` int(11) NOT NULL,
  `company_id` varchar(45) DEFAULT NULL,
  `guaranty_id` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `end_time` varchar(45) DEFAULT NULL,
  `message` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `Report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
