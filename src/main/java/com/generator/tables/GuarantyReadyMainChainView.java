/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.tables.records.GuarantyReadyMainChainViewRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuarantyReadyMainChainView extends TableImpl<GuarantyReadyMainChainViewRecord> {

    private static final long serialVersionUID = 2114734186;

    /**
     * The reference instance of <code>bcinvest.guaranty_ready_main_chain_view</code>
     */
    public static final GuarantyReadyMainChainView GUARANTY_READY_MAIN_CHAIN_VIEW = new GuarantyReadyMainChainView();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuarantyReadyMainChainViewRecord> getRecordType() {
        return GuarantyReadyMainChainViewRecord.class;
    }

    /**
     * The column <code>bcinvest.guaranty_ready_main_chain_view.id</code>.
     */
    public final TableField<GuarantyReadyMainChainViewRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>bcinvest.guaranty_ready_main_chain_view.value</code>.
     */
    public final TableField<GuarantyReadyMainChainViewRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bcinvest.guaranty_ready_main_chain_view.variation</code>.
     */
    public final TableField<GuarantyReadyMainChainViewRecord, String> VARIATION = createField("variation", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bcinvest.guaranty_ready_main_chain_view.remarks</code>.
     */
    public final TableField<GuarantyReadyMainChainViewRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR(512), this, "");

    /**
     * Create a <code>bcinvest.guaranty_ready_main_chain_view</code> table reference
     */
    public GuarantyReadyMainChainView() {
        this(DSL.name("guaranty_ready_main_chain_view"), null);
    }

    /**
     * Create an aliased <code>bcinvest.guaranty_ready_main_chain_view</code> table reference
     */
    public GuarantyReadyMainChainView(String alias) {
        this(DSL.name(alias), GUARANTY_READY_MAIN_CHAIN_VIEW);
    }

    /**
     * Create an aliased <code>bcinvest.guaranty_ready_main_chain_view</code> table reference
     */
    public GuarantyReadyMainChainView(Name alias) {
        this(alias, GUARANTY_READY_MAIN_CHAIN_VIEW);
    }

    private GuarantyReadyMainChainView(Name alias, Table<GuarantyReadyMainChainViewRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuarantyReadyMainChainView(Name alias, Table<GuarantyReadyMainChainViewRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "VIEW");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Bcinvest.BCINVEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyReadyMainChainView as(String alias) {
        return new GuarantyReadyMainChainView(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyReadyMainChainView as(Name alias) {
        return new GuarantyReadyMainChainView(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuarantyReadyMainChainView rename(String name) {
        return new GuarantyReadyMainChainView(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuarantyReadyMainChainView rename(Name name) {
        return new GuarantyReadyMainChainView(name, null);
    }
}
