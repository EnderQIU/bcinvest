/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.CompanyRecord;

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
public class Company extends TableImpl<CompanyRecord> {

    private static final long serialVersionUID = -398346944;

    /**
     * The reference instance of <code>bcinvest.Company</code>
     */
    public static final Company COMPANY = new Company();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CompanyRecord> getRecordType() {
        return CompanyRecord.class;
    }

    /**
     * The column <code>bcinvest.Company.AccountNum</code>.
     */
    public final TableField<CompanyRecord, String> ACCOUNTNUM = createField("AccountNum", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>bcinvest.Company.Name</code>.
     */
    public final TableField<CompanyRecord, String> NAME = createField("Name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Company.TelNum</code>.
     */
    public final TableField<CompanyRecord, String> TELNUM = createField("TelNum", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Company.EmailAddress</code>.
     */
    public final TableField<CompanyRecord, String> EMAILADDRESS = createField("EmailAddress", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Company.Token</code>.
     */
    public final TableField<CompanyRecord, String> TOKEN = createField("Token", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Company.Credit</code>.
     */
    public final TableField<CompanyRecord, Long> CREDIT = createField("Credit", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>bcinvest.Company.Status</code>.
     */
    public final TableField<CompanyRecord, String> STATUS = createField("Status", org.jooq.impl.SQLDataType.VARCHAR(128).defaultValue(org.jooq.impl.DSL.inline("unapplied", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>bcinvest.Company.Lock</code>.
     */
    public final TableField<CompanyRecord, Byte> LOCK = createField("Lock", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * Create a <code>bcinvest.Company</code> table reference
     */
    public Company() {
        this(DSL.name("Company"), null);
    }

    /**
     * Create an aliased <code>bcinvest.Company</code> table reference
     */
    public Company(String alias) {
        this(DSL.name(alias), COMPANY);
    }

    /**
     * Create an aliased <code>bcinvest.Company</code> table reference
     */
    public Company(Name alias) {
        this(alias, COMPANY);
    }

    private Company(Name alias, Table<CompanyRecord> aliased) {
        this(alias, aliased, null);
    }

    private Company(Name alias, Table<CompanyRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.COMPANY_EMAILADDRESS, Indexes.COMPANY_PRIMARY, Indexes.COMPANY_TOKEN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CompanyRecord> getPrimaryKey() {
        return Keys.KEY_COMPANY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CompanyRecord>> getKeys() {
        return Arrays.<UniqueKey<CompanyRecord>>asList(Keys.KEY_COMPANY_PRIMARY, Keys.KEY_COMPANY_EMAILADDRESS, Keys.KEY_COMPANY_TOKEN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Company as(String alias) {
        return new Company(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Company as(Name alias) {
        return new Company(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Company rename(String name) {
        return new Company(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Company rename(Name name) {
        return new Company(name, null);
    }
}
