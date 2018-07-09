create table BankUser
(
  BankUserId    int auto_increment
    primary key,
  UserType      varchar(128) default 'bank' null
  comment 'Possible choices are: ["bank", "authority"]',
  UserName      varchar(128) default ''     null,
  Password      varchar(128) default ''     null,
  AuthorityName varchar(128) default ''     null,
  constraint BankUser_BankUserId_uindex
  unique (BankUserId)
);

create table CompanyUser
(
  CompanyUserId   int auto_increment
    primary key,
  LocalName       varchar(128) default '' null,
  TelephoneNumber varchar(128) default '' null,
  EmailAddress    varchar(128) default '' null,
  Credit          int default '0'         null
  comment '信用度',
  constraint Company_CompanyUserId_uindex
  unique (CompanyUserId)
)
  comment '企业用户';

create table Token
(
  TokenId       int auto_increment
    primary key,
  Token         varchar(128) default ''                    null,
  ExpireTime    varchar(128) default '0000-00-00 00:00:00' null,
  CompanyUserId int                                        null,
  constraint Token_Token_uindex
  unique (Token),
  constraint Token_TokenId_unidex
  unique (TokenId)
);

DELIMITER ;;
CREATE TRIGGER `Generate_bankUserToken_before_insert`
BEFORE INSERT ON `BankUser` FOR EACH ROW
BEGIN
  IF new.Token IS NULL THEN
    SET new.Token = uuid();
  END IF;
END;;

CREATE TRIGGER `Generate_companyUserToken_before_insert`
BEFORE INSERT ON `CompanyUser` FOR EACH ROW
BEGIN
  IF new.Token IS NULL THEN
    SET new.Token = uuid();
  END IF;
END;;
DELIMITER ;
