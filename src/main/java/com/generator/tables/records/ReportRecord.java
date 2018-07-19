/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Report;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ReportRecord extends UpdatableRecordImpl<ReportRecord> implements Record5<String, Integer, LocalDateTime, String, String> {

    private static final long serialVersionUID = -2061821084;

    /**
     * Setter for <code>bcinvest.Report.AccountNum</code>.
     */
    public void setAccountnum(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.Report.AccountNum</code>.
     */
    public String getAccountnum() {
        return (String) get(0);
    }

    /**
     * Setter for <code>bcinvest.Report.ReportId</code>.
     */
    public void setReportid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>bcinvest.Report.ReportId</code>.
     */
    public Integer getReportid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>bcinvest.Report.Date</code>.
     */
    public void setDate(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>bcinvest.Report.Date</code>.
     */
    public LocalDateTime getDate() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>bcinvest.Report.Duration</code>.
     */
    public void setDuration(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>bcinvest.Report.Duration</code>.
     */
    public String getDuration() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bcinvest.Report.type</code>.
     */
    public void setType(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>bcinvest.Report.type</code>.
     */
    public String getType() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, Integer, LocalDateTime, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, Integer, LocalDateTime, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Report.REPORT.ACCOUNTNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Report.REPORT.REPORTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field3() {
        return Report.REPORT.DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Report.REPORT.DURATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Report.REPORT.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getAccountnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getReportid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component3() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getAccountnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getReportid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value3() {
        return getDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportRecord value1(String value) {
        setAccountnum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportRecord value2(Integer value) {
        setReportid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportRecord value3(LocalDateTime value) {
        setDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportRecord value4(String value) {
        setDuration(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportRecord value5(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportRecord values(String value1, Integer value2, LocalDateTime value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ReportRecord
     */
    public ReportRecord() {
        super(Report.REPORT);
    }

    /**
     * Create a detached, initialised ReportRecord
     */
    public ReportRecord(String accountnum, Integer reportid, LocalDateTime date, String duration, String type) {
        super(Report.REPORT);

        set(0, accountnum);
        set(1, reportid);
        set(2, date);
        set(3, duration);
        set(4, type);
    }
}
