/*
 * This file is generated by jOOQ.
*/
package com.bcgenerator.tables;


import com.bcgenerator.Blockchain;
import com.bcgenerator.Indexes;
import com.bcgenerator.Keys;
import com.bcgenerator.tables.records.GuarantyChainRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuarantyChain extends TableImpl<GuarantyChainRecord> {

    private static final long serialVersionUID = -1063918899;

    /**
     * The reference instance of <code>blockchain.guaranty_chain</code>
     */
    public static final GuarantyChain GUARANTY_CHAIN = new GuarantyChain();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuarantyChainRecord> getRecordType() {
        return GuarantyChainRecord.class;
    }

    /**
     * The column <code>blockchain.guaranty_chain.this_hash</code>.
     */
    public final TableField<GuarantyChainRecord, String> THIS_HASH = createField("this_hash", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>blockchain.guaranty_chain.time_stamp</code>.
     */
    public final TableField<GuarantyChainRecord, LocalDateTime> TIME_STAMP = createField("time_stamp", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>blockchain.guaranty_chain.previous_hash</code>.
     */
    public final TableField<GuarantyChainRecord, String> PREVIOUS_HASH = createField("previous_hash", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>blockchain.guaranty_chain.length</code>.
     */
    public final TableField<GuarantyChainRecord, Long> LENGTH = createField("length", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>blockchain.guaranty_chain.is_main</code>.
     */
    public final TableField<GuarantyChainRecord, Byte> IS_MAIN = createField("is_main", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>blockchain.guaranty_chain.nearest_main_hash</code>.
     */
    public final TableField<GuarantyChainRecord, String> NEAREST_MAIN_HASH = createField("nearest_main_hash", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>blockchain.guaranty_chain.address</code>.
     */
    public final TableField<GuarantyChainRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * Create a <code>blockchain.guaranty_chain</code> table reference
     */
    public GuarantyChain() {
        this(DSL.name("guaranty_chain"), null);
    }

    /**
     * Create an aliased <code>blockchain.guaranty_chain</code> table reference
     */
    public GuarantyChain(String alias) {
        this(DSL.name(alias), GUARANTY_CHAIN);
    }

    /**
     * Create an aliased <code>blockchain.guaranty_chain</code> table reference
     */
    public GuarantyChain(Name alias) {
        this(alias, GUARANTY_CHAIN);
    }

    private GuarantyChain(Name alias, Table<GuarantyChainRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuarantyChain(Name alias, Table<GuarantyChainRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Blockchain.BLOCKCHAIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.GUARANTY_CHAIN_GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK, Indexes.GUARANTY_CHAIN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GuarantyChainRecord> getPrimaryKey() {
        return Keys.KEY_GUARANTY_CHAIN_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GuarantyChainRecord>> getKeys() {
        return Arrays.<UniqueKey<GuarantyChainRecord>>asList(Keys.KEY_GUARANTY_CHAIN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<GuarantyChainRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GuarantyChainRecord, ?>>asList(Keys.GUARANTY_CHAIN_ADDRESSLIST_ADDRESS_FK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyChain as(String alias) {
        return new GuarantyChain(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyChain as(Name alias) {
        return new GuarantyChain(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuarantyChain rename(String name) {
        return new GuarantyChain(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuarantyChain rename(Name name) {
        return new GuarantyChain(name, null);
    }
}
