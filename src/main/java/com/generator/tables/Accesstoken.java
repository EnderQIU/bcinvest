/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.tables.records.AccesstokenRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
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
public class Accesstoken extends TableImpl<AccesstokenRecord> {

    private static final long serialVersionUID = -140327504;

    /**
     * The reference instance of <code>bcinvest.accesstoken</code>
     */
    public static final Accesstoken ACCESSTOKEN = new Accesstoken();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccesstokenRecord> getRecordType() {
        return AccesstokenRecord.class;
    }

    /**
     * The column <code>bcinvest.accesstoken.AccessToken</code>.
     */
    public final TableField<AccesstokenRecord, String> ACCESSTOKEN_ = createField("AccessToken", org.jooq.impl.SQLDataType.VARCHAR(512), this, "");

    /**
     * The column <code>bcinvest.accesstoken.ExpiryTime</code>.
     */
    public final TableField<AccesstokenRecord, LocalDateTime> EXPIRYTIME = createField("ExpiryTime", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>bcinvest.accesstoken.AccountNum</code>.
     */
    public final TableField<AccesstokenRecord, String> ACCOUNTNUM = createField("AccountNum", org.jooq.impl.SQLDataType.VARCHAR(128).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>bcinvest.accesstoken</code> table reference
     */
    public Accesstoken() {
        this(DSL.name("accesstoken"), null);
    }

    /**
     * Create an aliased <code>bcinvest.accesstoken</code> table reference
     */
    public Accesstoken(String alias) {
        this(DSL.name(alias), ACCESSTOKEN);
    }

    /**
     * Create an aliased <code>bcinvest.accesstoken</code> table reference
     */
    public Accesstoken(Name alias) {
        this(alias, ACCESSTOKEN);
    }

    private Accesstoken(Name alias, Table<AccesstokenRecord> aliased) {
        this(alias, aliased, null);
    }

    private Accesstoken(Name alias, Table<AccesstokenRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.ACCESSTOKEN_ACCOUNTNUM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Accesstoken as(String alias) {
        return new Accesstoken(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Accesstoken as(Name alias) {
        return new Accesstoken(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Accesstoken rename(String name) {
        return new Accesstoken(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Accesstoken rename(Name name) {
        return new Accesstoken(name, null);
    }
}
