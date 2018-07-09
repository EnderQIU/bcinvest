-- we don't know how to generate schema bcinvest (class Schema) :(
create table BankUser
(
	BankUserId int auto_increment
		primary key,
	UserType varchar(128) default 'bank' null comment 'Possible choices are: ["bank", "authority"]',
	UserName varchar(128) default '' null,
	Password varchar(128) default '' null,
	AuthorityName varchar(128) default '' null,
	Token varchar(128) null
)
;

create table CompanyUser
(
	CompanyUserId int auto_increment
		primary key,
	LocalName varchar(128) default '' null,
	TelephoneNumber varchar(128) default '' null,
	EmailAddress varchar(128) default '' null,
	Credit int default '0' null comment '信用度',
	Token varchar(128) null,
	Status int null
)
comment '企业用户'
;

