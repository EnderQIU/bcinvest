/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Report;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class ReportRecord extends UpdatableRecordImpl<ReportRecord> implements Record4<String, Integer, LocalDateTime, String> {

    private static final long serialVersionUID = 1408767535;

    /**
     * Setter for <code>bcinvest.Report.AuthName</code>.
     */
    public void setAuthname(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.Report.AuthName</code>.
     */
    public String getAuthname() {
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Integer, LocalDateTime, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Integer, LocalDateTime, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Report.REPORT.AUTHNAME;
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
    public String component1() {
        return getAuthname();
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
    public String value1() {
        return getAuthname();
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
    public ReportRecord value1(String value) {
        setAuthname(value);
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
    public ReportRecord values(String value1, Integer value2, LocalDateTime value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
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
    public ReportRecord(String authname, Integer reportid, LocalDateTime date, String duration) {
        super(Report.REPORT);

        set(0, authname);
        set(1, reportid);
        set(2, date);
        set(3, duration);
    }
}