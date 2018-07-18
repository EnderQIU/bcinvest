/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.GuarantystateupdatetaskRecord;

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
public class Guarantystateupdatetask extends TableImpl<GuarantystateupdatetaskRecord> {

    private static final long serialVersionUID = -687974819;

    /**
     * The reference instance of <code>bcinvest.guarantystateupdatetask</code>
     */
    public static final Guarantystateupdatetask GUARANTYSTATEUPDATETASK = new Guarantystateupdatetask();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuarantystateupdatetaskRecord> getRecordType() {
        return GuarantystateupdatetaskRecord.class;
    }

    /**
     * The column <code>bcinvest.guarantystateupdatetask.taskId</code>.
     */
    public final TableField<GuarantystateupdatetaskRecord, Integer> TASKID = createField("taskId", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>bcinvest.guarantystateupdatetask.guarantyId</code>.
     */
    public final TableField<GuarantystateupdatetaskRecord, Integer> GUARANTYID = createField("guarantyId", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.guarantystateupdatetask.previousState</code>.
     */
    public final TableField<GuarantystateupdatetaskRecord, Integer> PREVIOUSSTATE = createField("previousState", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.guarantystateupdatetask.stateWillUpdateTo</code>.
     */
    public final TableField<GuarantystateupdatetaskRecord, Integer> STATEWILLUPDATETO = createField("stateWillUpdateTo", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>bcinvest.guarantystateupdatetask.taskState</code>.
     */
    public final TableField<GuarantystateupdatetaskRecord, String> TASKSTATE = createField("taskState", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.guarantystateupdatetask.count</code>.
     */
    public final TableField<GuarantystateupdatetaskRecord, Integer> COUNT = createField("count", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>bcinvest.guarantystateupdatetask</code> table reference
     */
    public Guarantystateupdatetask() {
        this(DSL.name("guarantystateupdatetask"), null);
    }

    /**
     * Create an aliased <code>bcinvest.guarantystateupdatetask</code> table reference
     */
    public Guarantystateupdatetask(String alias) {
        this(DSL.name(alias), GUARANTYSTATEUPDATETASK);
    }

    /**
     * Create an aliased <code>bcinvest.guarantystateupdatetask</code> table reference
     */
    public Guarantystateupdatetask(Name alias) {
        this(alias, GUARANTYSTATEUPDATETASK);
    }

    private Guarantystateupdatetask(Name alias, Table<GuarantystateupdatetaskRecord> aliased) {
        this(alias, aliased, null);
    }

    private Guarantystateupdatetask(Name alias, Table<GuarantystateupdatetaskRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.GUARANTYSTATEUPDATETASK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<GuarantystateupdatetaskRecord, Integer> getIdentity() {
        return Keys.IDENTITY_GUARANTYSTATEUPDATETASK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<GuarantystateupdatetaskRecord> getPrimaryKey() {
        return Keys.KEY_GUARANTYSTATEUPDATETASK_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<GuarantystateupdatetaskRecord>> getKeys() {
        return Arrays.<UniqueKey<GuarantystateupdatetaskRecord>>asList(Keys.KEY_GUARANTYSTATEUPDATETASK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Guarantystateupdatetask as(String alias) {
        return new Guarantystateupdatetask(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Guarantystateupdatetask as(Name alias) {
        return new Guarantystateupdatetask(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Guarantystateupdatetask rename(String name) {
        return new Guarantystateupdatetask(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Guarantystateupdatetask rename(Name name) {
        return new Guarantystateupdatetask(name, null);
    }
}
