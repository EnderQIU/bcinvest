/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.CompanyRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
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

    private static final long serialVersionUID = 1162827729;

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
     * The column <code>bcinvest.Company.id</code>.
     */
    public final TableField<CompanyRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>bcinvest.Company.name</code>.
     */
    public final TableField<CompanyRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.phone_number</code>.
     */
    public final TableField<CompanyRecord, String> PHONE_NUMBER = createField("phone_number", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.email</code>.
     */
    public final TableField<CompanyRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.token</code>.
     */
    public final TableField<CompanyRecord, String> TOKEN = createField("token", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.credit</code>.
     */
    public final TableField<CompanyRecord, Integer> CREDIT = createField("credit", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.Company.status</code>. "unapplied", "checking", "unpassed", "passed"
     */
    public final TableField<CompanyRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR(45), this, "\"unapplied\", \"checking\", \"unpassed\", \"passed\"");

    /**
     * The column <code>bcinvest.Company.address</code>.
     */
    public final TableField<CompanyRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.business_license_code</code>.
     */
    public final TableField<CompanyRecord, String> BUSINESS_LICENSE_CODE = createField("business_license_code", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.start_date</code>.
     */
    public final TableField<CompanyRecord, LocalDateTime> START_DATE = createField("start_date", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>bcinvest.Company.end_date</code>.
     */
    public final TableField<CompanyRecord, LocalDateTime> END_DATE = createField("end_date", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>bcinvest.Company.business_registration_code</code>.
     */
    public final TableField<CompanyRecord, String> BUSINESS_REGISTRATION_CODE = createField("business_registration_code", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.industry</code>.
     */
    public final TableField<CompanyRecord, String> INDUSTRY = createField("industry", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.registed_capital</code>.
     */
    public final TableField<CompanyRecord, String> REGISTED_CAPITAL = createField("registed_capital", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Company.operation_type</code>.
     */
    public final TableField<CompanyRecord, String> OPERATION_TYPE = createField("operation_type", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

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
        return Arrays.<Index>asList(Indexes.COMPANY_EMAIL_UNIQUE, Indexes.COMPANY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CompanyRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COMPANY;
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
        return Arrays.<UniqueKey<CompanyRecord>>asList(Keys.KEY_COMPANY_PRIMARY, Keys.KEY_COMPANY_EMAIL_UNIQUE);
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
