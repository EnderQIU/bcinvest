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