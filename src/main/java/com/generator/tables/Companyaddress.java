/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.CompanyaddressRecord;

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
public class Companyaddress extends TableImpl<CompanyaddressRecord> {

    private static final long serialVersionUID = 94450226;

    /**
     * The reference instance of <code>bcinvest.CompanyAddress</code>
     */
    public static final Companyaddress COMPANYADDRESS = new Companyaddress();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CompanyaddressRecord> getRecordType() {
        return CompanyaddressRecord.class;
    }

    /**
     * The column <code>bcinvest.CompanyAddress.AccountNum</code>.
     */
    public final TableField<CompanyaddressRecord, String> ACCOUNTNUM = createField("AccountNum", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bcinvest.CompanyAddress.Addr</code>.
     */
    public final TableField<CompanyaddressRecord, String> ADDR = createField("Addr", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * Create a <code>bcinvest.CompanyAddress</code> table reference
     */
    public Companyaddress() {
        this(DSL.name("CompanyAddress"), null);
    }

    /**
     * Create an aliased <code>bcinvest.CompanyAddress</code> table reference
     */
    public Companyaddress(String alias) {
        this(DSL.name(alias), COMPANYADDRESS);
    }

    /**
     * Create an aliased <code>bcinvest.CompanyAddress</code> table reference
     */
    public Companyaddress(Name alias) {
        this(alias, COMPANYADDRESS);
    }

    private Companyaddress(Name alias, Table<CompanyaddressRecord> aliased) {
        this(alias, aliased, null);
    }

    private Companyaddress(Name alias, Table<CompanyaddressRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.COMPANYADDRESS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CompanyaddressRecord> getPrimaryKey() {
        return Keys.KEY_COMPANYADDRESS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CompanyaddressRecord>> getKeys() {
        return Arrays.<UniqueKey<CompanyaddressRecord>>asList(Keys.KEY_COMPANYADDRESS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CompanyaddressRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CompanyaddressRecord, ?>>asList(Keys.COMPANYADDRESS_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Companyaddress as(String alias) {
        return new Companyaddress(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Companyaddress as(Name alias) {
        return new Companyaddress(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Companyaddress rename(String name) {
        return new Companyaddress(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Companyaddress rename(Name name) {
        return new Companyaddress(name, null);
    }
}
