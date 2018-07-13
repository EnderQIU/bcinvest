/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Credit;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record3;
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
public class CreditRecord extends UpdatableRecordImpl<CreditRecord> implements Record4<String, Integer, Integer, Byte> {

    private static final long serialVersionUID = -497032947;

    /**
     * Setter for <code>bcinvest.Credit.AccountNum</code>.
     */
    public void setAccountnum(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.Credit.AccountNum</code>.
     */
    public String getAccountnum() {
        return (String) get(0);
    }

    /**
     * Setter for <code>bcinvest.Credit.GuarantyId</code>.
     */
    public void setGuarantyid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>bcinvest.Credit.GuarantyId</code>.
     */
    public Integer getGuarantyid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>bcinvest.Credit.ReportId</code>.
     */
    public void setReportid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>bcinvest.Credit.ReportId</code>.
     */
    public Integer getReportid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>bcinvest.Credit.Type</code>.
     */
    public void setType(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>bcinvest.Credit.Type</code>.
     */
    public Byte getType() {
        return (Byte) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record3<String, Integer, Integer> key() {
        return (Record3) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Integer, Integer, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Integer, Integer, Byte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Credit.CREDIT.ACCOUNTNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Credit.CREDIT.GUARANTYID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Credit.CREDIT.REPORTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Credit.CREDIT.TYPE;
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
        return getGuarantyid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getReportid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component4() {
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
        return getGuarantyid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getReportid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreditRecord value1(String value) {
        setAccountnum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreditRecord value2(Integer value) {
        setGuarantyid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreditRecord value3(Integer value) {
        setReportid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreditRecord value4(Byte value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CreditRecord values(String value1, Integer value2, Integer value3, Byte value4) {
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
     * Create a detached CreditRecord
     */
    public CreditRecord() {
        super(Credit.CREDIT);
    }

    /**
     * Create a detached, initialised CreditRecord
     */
    public CreditRecord(String accountnum, Integer guarantyid, Integer reportid, Byte type) {
        super(Credit.CREDIT);

        set(0, accountnum);
        set(1, guarantyid);
        set(2, reportid);
        set(3, type);
    }
}