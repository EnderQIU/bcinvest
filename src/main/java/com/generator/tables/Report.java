/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.ReportRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class Report extends TableImpl<ReportRecord> {

    private static final long serialVersionUID = 1363714864;

    /**
     * The reference instance of <code>bcinvest.Report</code>
     */
    public static final Report REPORT = new Report();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReportRecord> getRecordType() {
        return ReportRecord.class;
    }

    /**
     * The column <code>bcinvest.Report.AccountNum</code>.
     */
    public final TableField<ReportRecord, String> ACCOUNTNUM = createField("AccountNum", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Report.ReportId</code>.
     */
    public final TableField<ReportRecord, Integer> REPORTID = createField("ReportId", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>bcinvest.Report.Date</code>.
     */
    public final TableField<ReportRecord, LocalDateTime> DATE = createField("Date", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>bcinvest.Report.Duration</code>.
     */
    public final TableField<ReportRecord, String> DURATION = createField("Duration", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Report.type</code>.
     */
    public final TableField<ReportRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * Create a <code>bcinvest.Report</code> table reference
     */
    public Report() {
        this(DSL.name("Report"), null);
    }

    /**
     * Create an aliased <code>bcinvest.Report</code> table reference
     */
    public Report(String alias) {
        this(DSL.name(alias), REPORT);
    }

    /**
     * Create an aliased <code>bcinvest.Report</code> table reference
     */
    public Report(Name alias) {
        this(alias, REPORT);
    }

    private Report(Name alias, Table<ReportRecord> aliased) {
        this(alias, aliased, null);
    }

    private Report(Name alias, Table<ReportRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.REPORT_ACCOUNTNUM, Indexes.REPORT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ReportRecord, Integer> getIdentity() {
        return Keys.IDENTITY_REPORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ReportRecord> getPrimaryKey() {
        return Keys.KEY_REPORT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ReportRecord>> getKeys() {
        return Arrays.<UniqueKey<ReportRecord>>asList(Keys.KEY_REPORT_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ReportRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ReportRecord, ?>>asList(Keys.REPORT_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Report as(String alias) {
        return new Report(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Report as(Name alias) {
        return new Report(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Report rename(String name) {
        return new Report(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Report rename(Name name) {
        return new Report(name, null);
    }
}
