create table blockchain.addresslist
(
	address varchar(512) not null
		primary key
)
;

create table blockchain.credit_chain
(
	this_hash varchar(64) not null
		primary key,
	time_stamp timestamp not null,
	previous_hash varchar(64) not null,
	length bigint not null,
	is_main tinyint(1) not null,
	address varchar(512) not null,
	constraint credit_chain_addresslist_address_fk
		foreign key (address) references blockchain.addresslist (address)
)
;

create index credit_chain_addresslist_address_fk
	on blockchain.credit_chain (address)
;

create table blockchain.credit_data
(
	block_hash varchar(64) not null,
	id varchar(256) not null,
	variation varchar(128) not null,
	value varchar(128) not null,
	remarks varchar(512) null,
	primary key (block_hash, id),
	constraint credit_data_chain_this_hash_fk
		foreign key (block_hash) references blockchain.credit_chain (this_hash)
)
;

create table blockchain.guaranty_chain
(
	this_hash varchar(64) not null
		primary key,
	time_stamp timestamp not null,
	previous_hash varchar(64) not null,
	length bigint not null,
	is_main tinyint(1) not null,
	address varchar(512) not null,
	constraint guaranty_chain_addresslist_address_fk
		foreign key (address) references blockchain.addresslist (address)
)
;

create index guaranty_chain_addresslist_address_fk
	on blockchain.guaranty_chain (address)
;

create table blockchain.guaranty_data
(
	block_hash varchar(64) not null,
	id varchar(256) not null,
	variation varchar(128) not null,
	value varchar(128) not null,
	remarks varchar(512) null,
	primary key (block_hash, id),
	constraint guaranty_data_chain_this_hash_fk
		foreign key (block_hash) references blockchain.guaranty_chain (this_hash)
)
;

CREATE OR REPLACE VIEW credit_ready_main_chain_view AS
	SELECT id, value, variation, remarks
    FROM credit_chain JOIN credit_data AS One ON this_hash = block_hash
    WHERE is_main = 1 AND length >= ALL (
		SELECT MAX(length)
        FROM credit_chain JOIN credit_data AS Two ON this_hash = block_hash
        WHERE is_main = 1 AND One.id = Two.id AND length + 6 <= ALL (
			SELECT length
			FROM guaranty_most_front_block_info
		)
	) AND length + 6 <= ALL (
		SELECT length
        FROM guaranty_most_front_block_info
	);

CREATE OR REPLACE VIEW guaranty_ready_main_chain_view AS
	SELECT id, value, variation, remarks
    FROM guaranty_chain JOIN guaranty_data AS One ON this_hash = block_hash
    WHERE is_main = 1 AND length >= ALL (
		SELECT MAX(length)
        FROM guaranty_chain JOIN guaranty_data AS Two ON this_hash = block_hash
        WHERE is_main = 1 AND One.id = Two.id AND length + 6 <= ALL(
			SELECT length
            FROM guaranty_most_front_block_info
		)
	) AND length + 6 <= ALL (
		SELECT length
        FROM guaranty_most_front_block_info
	);

CREATE OR REPLACE VIEW credit_most_front_block_info AS
	SELECT *
    FROM credit_chain
    WHERE is_main = 1 AND length >= ALL (
		SELECT MAX(length)
        FROM credit_chain
        WHERE is_main = 1
	);

CREATE OR REPLACE VIEW guaranty_most_front_block_info AS
	SELECT *
    FROM guaranty_chain
    WHERE is_main = 1 AND length >= ALL (
		SELECT MAX(length)
        FROM guaranty_chain
        WHERE is_main = 1
	);

CREATE OR REPLACE VIEW credit_main_chain_view AS
	SELECT id, value, variation, remarks
    FROM credit_chain JOIN credit_data AS One ON this_hash = block_hash
    WHERE is_main = 1 AND length >= ALL (
		SELECT MAX(length)
        FROM credit_chain JOIN credit_data AS Two ON this_hash = block_hash
        WHERE is_main = 1 AND One.id = Two.id
	);

CREATE OR REPLACE VIEW guaranty_main_chain_view AS
	SELECT id, value, variation, remarks
    FROM guaranty_chain JOIN guaranty_data AS One ON this_hash = block_hash
    WHERE is_main = 1 AND length >= ALL (
		SELECT MAX(length)
        FROM guaranty_chain JOIN guaranty_data AS Two ON this_hash = block_hash
        WHERE is_main = 1 AND One.id = Two.id
	);