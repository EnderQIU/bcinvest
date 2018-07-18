/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.tables.records.CreditReadyMainChainViewRecord;

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
public class CreditReadyMainChainView extends TableImpl<CreditReadyMainChainViewRecord> {

    private static final long serialVersionUID = 1869094650;

    /**
     * The reference instance of <code>bcinvest.credit_ready_main_chain_view</code>
     */
    public static final CreditReadyMainChainView CREDIT_READY_MAIN_CHAIN_VIEW = new CreditReadyMainChainView();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CreditReadyMainChainViewRecord> getRecordType() {
        return CreditReadyMainChainViewRecord.class;
    }

    /**
     * The column <code>bcinvest.credit_ready_main_chain_view.id</code>.
     */
    public final TableField<CreditReadyMainChainViewRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>bcinvest.credit_ready_main_chain_view.value</code>.
     */
    public final TableField<CreditReadyMainChainViewRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bcinvest.credit_ready_main_chain_view.variation</code>.
     */
    public final TableField<CreditReadyMainChainViewRecord, String> VARIATION = createField("variation", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bcinvest.credit_ready_main_chain_view.remarks</code>.
     */
    public final TableField<CreditReadyMainChainViewRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR(512), this, "");

    /**
     * Create a <code>bcinvest.credit_ready_main_chain_view</code> table reference
     */
    public CreditReadyMainChainView() {
        this(DSL.name("credit_ready_main_chain_view"), null);
    }

    /**
     * Create an aliased <code>bcinvest.credit_ready_main_chain_view</code> table reference
     */
    public CreditReadyMainChainView(String alias) {
        this(DSL.name(alias), CREDIT_READY_MAIN_CHAIN_VIEW);
    }

    /**
     * Create an aliased <code>bcinvest.credit_ready_main_chain_view</code> table reference
     */
    public CreditReadyMainChainView(Name alias) {
        this(alias, CREDIT_READY_MAIN_CHAIN_VIEW);
    }

    private CreditReadyMainChainView(Name alias, Table<CreditReadyMainChainViewRecord> aliased) {
        this(alias, aliased, null);
    }

    private CreditReadyMainChainView(Name alias, Table<CreditReadyMainChainViewRecord> aliased, Field<?>[] parameters) {
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
    public CreditReadyMainChainView as(String alias) {
        return new CreditReadyMainChainView(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreditReadyMainChainView as(Name alias) {
        return new CreditReadyMainChainView(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CreditReadyMainChainView rename(String name) {
        return new CreditReadyMainChainView(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CreditReadyMainChainView rename(Name name) {
        return new CreditReadyMainChainView(name, null);
    }
}