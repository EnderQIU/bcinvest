/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Guaranty;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
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
public class GuarantyRecord extends UpdatableRecordImpl<GuarantyRecord> implements Record10<Integer, String, Integer, Integer, String, Integer, Integer, Integer, String, Byte> {

    private static final long serialVersionUID = -1343840381;

    /**
     * Setter for <code>bcinvest.Guaranty.GuarantyId</code>.
     */
    public void setGuarantyid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.GuarantyId</code>.
     */
    public Integer getGuarantyid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.AccountNum</code>.
     */
    public void setAccountnum(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.AccountNum</code>.
     */
    public String getAccountnum() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.State</code>.
     */
    public void setState(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.State</code>.
     */
    public Integer getState() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.ScopeOfRight</code>.
     */
    public void setScopeofright(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.ScopeOfRight</code>.
     */
    public Integer getScopeofright() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.OwnerName</code>.
     */
    public void setOwnername(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.OwnerName</code>.
     */
    public String getOwnername() {
        return (String) get(4);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.ReportId</code>.
     */
    public void setReportid(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.ReportId</code>.
     */
    public Integer getReportid() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.Type</code>.
     */
    public void setType(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.Type</code>.
     */
    public Integer getType() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.EvaluateValue</code>.
     */
    public void setEvaluatevalue(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.EvaluateValue</code>.
     */
    public Integer getEvaluatevalue() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.Name</code>.
     */
    public void setName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.Name</code>.
     */
    public String getName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>bcinvest.Guaranty.Lock</code>.
     */
    public void setLock(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>bcinvest.Guaranty.Lock</code>.
     */
    public Byte getLock() {
        return (Byte) get(9);
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
    // Record10 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, Integer, Integer, String, Integer, Integer, Integer, String, Byte> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row10<Integer, String, Integer, Integer, String, Integer, Integer, Integer, String, Byte> valuesRow() {
        return (Row10) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Guaranty.GUARANTY.GUARANTYID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Guaranty.GUARANTY.ACCOUNTNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Guaranty.GUARANTY.STATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Guaranty.GUARANTY.SCOPEOFRIGHT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Guaranty.GUARANTY.OWNERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Guaranty.GUARANTY.REPORTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Guaranty.GUARANTY.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Guaranty.GUARANTY.EVALUATEVALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Guaranty.GUARANTY.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field10() {
        return Guaranty.GUARANTY.LOCK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getGuarantyid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAccountnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getScopeofright();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getOwnername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getReportid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getEvaluatevalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component10() {
        return getLock();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getGuarantyid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAccountnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getScopeofright();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getOwnername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getReportid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getEvaluatevalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value10() {
        return getLock();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value1(Integer value) {
        setGuarantyid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value2(String value) {
        setAccountnum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value3(Integer value) {
        setState(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value4(Integer value) {
        setScopeofright(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value5(String value) {
        setOwnername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value6(Integer value) {
        setReportid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value7(Integer value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value8(Integer value) {
        setEvaluatevalue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value9(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord value10(Byte value) {
        setLock(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GuarantyRecord values(Integer value1, String value2, Integer value3, Integer value4, String value5, Integer value6, Integer value7, Integer value8, String value9, Byte value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GuarantyRecord
     */
    public GuarantyRecord() {
        super(Guaranty.GUARANTY);
    }

    /**
     * Create a detached, initialised GuarantyRecord
     */
    public GuarantyRecord(Integer guarantyid, String accountnum, Integer state, Integer scopeofright, String ownername, Integer reportid, Integer type, Integer evaluatevalue, String name, Byte lock) {
        super(Guaranty.GUARANTY);

        set(0, guarantyid);
        set(1, accountnum);
        set(2, state);
        set(3, scopeofright);
        set(4, ownername);
        set(5, reportid);
        set(6, type);
        set(7, evaluatevalue);
        set(8, name);
        set(9, lock);
    }
}
