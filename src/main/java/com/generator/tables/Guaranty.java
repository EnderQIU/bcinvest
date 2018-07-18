/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.GuarantyRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Guaranty extends TableImpl<GuarantyRecord> {

    private static final long serialVersionUID = 1917199917;

    /**
     * The reference instance of <code>bcinvest.guaranty</code>
     */
    public static final Guaranty GUARANTY = new Guaranty();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuarantyRecord> getRecordType() {
        return GuarantyRecord.class;
    }

    /**
     * The column <code>bcinvest.guaranty.GuarantyId</code>.
     */
    public final TableField<GuarantyRecord, Integer> GUARANTYID = createField("GuarantyId", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>bcinvest.guaranty.AccountNum</code>.
     */
    public final TableField<GuarantyRecord, String> ACCOUNTNUM = createField("AccountNum", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.guaranty.State</code>.
     */
    public final TableField<GuarantyRecord, Integer> STATE = createField("State", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.guaranty.ScopeOfRight</code>.
     */
    public final TableField<GuarantyRecord, Integer> SCOPEOFRIGHT = createField("ScopeOfRight", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.guaranty.OwnerName</code>.
     */
    public final TableField<GuarantyRecord, String> OWNERNAME = createField("OwnerName", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.guaranty.ReportId</code>.
     */
    public final TableField<GuarantyRecord, Integer> REPORTID = createField("ReportId", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.guaranty.EvaluateValue</code>.
     */
    public final TableField<GuarantyRecord, Integer> EVALUATEVALUE = createField("EvaluateValue", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.guaranty.Name</code>.
     */
    public final TableField<GuarantyRecord, String> NAME = createField("Name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.guaranty.Type</code>.
     */
    public final TableField<GuarantyRecord, String> TYPE = createField("Type", org.jooq.impl.SQLDataType.VARCHAR(32).defaultValue(org.jooq.impl.DSL.inline("House", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>bcinvest.guaranty.Lock</code>.
     */
    public final TableField<GuarantyRecord, Byte> LOCK = createField("Lock", org.jooq.impl.SQLDataType.TINYINT.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * Create a <code>bcinvest.guaranty</code> table reference
     */
    public Guaranty() {
        this(DSL.name("guaranty"), null);
    }

    /**
     * Create an aliased <code>bcinvest.guaranty</code> table reference
     */
    public Guaranty(String alias) {
        this(DSL.name(alias), GUARANTY);
    }

    /**
     * Create an aliased <code>bcinvest.guaranty</code> table reference
     */
    public Guaranty(Name alias) {
        this(alias, GUARANTY);
    }

    private Guaranty(Name alias, Table<GuarantyRecord> aliased) {
        this(alias, aliased, null);
    }

    private Guaranty(Name alias, Table<GuarantyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.GUARANTY_GUARANTY_FK_COMPANY, Indexes.GUARANTY_GUARANTY_FK_REPORT, Indexes.GUARANTY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GuarantyRecord> getPrimaryKey() {
        return Keys.KEY_GUARANTY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GuarantyRecord>> getKeys() {
        return Arrays.<UniqueKey<GuarantyRecord>>asList(Keys.KEY_GUARANTY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Guaranty as(String alias) {
        return new Guaranty(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Guaranty as(Name alias) {
        return new Guaranty(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Guaranty rename(String name) {
        return new Guaranty(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Guaranty rename(Name name) {
        return new Guaranty(name, null);
    }
}
