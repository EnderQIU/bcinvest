/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Fundamentalcertificate;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class FundamentalcertificateRecord extends UpdatableRecordImpl<FundamentalcertificateRecord> implements Record8<String, LocalDateTime, LocalDateTime, String, Long, String, Integer, String> {

    private static final long serialVersionUID = 279293900;

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.BusinessLicenceNum</code>.
     */
    public void setBusinesslicencenum(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.BusinessLicenceNum</code>.
     */
    public String getBusinesslicencenum() {
        return (String) get(0);
    }

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.StartDate</code>.
     */
    public void setStartdate(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.StartDate</code>.
     */
    public LocalDateTime getStartdate() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.EndDate</code>.
     */
    public void setEnddate(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.EndDate</code>.
     */
    public LocalDateTime getEnddate() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.BusinessRegistrationNo</code>.
     */
    public void setBusinessregistrationno(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.BusinessRegistrationNo</code>.
     */
    public String getBusinessregistrationno() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.RegisteredCapital</code>.
     */
    public void setRegisteredcapital(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.RegisteredCapital</code>.
     */
    public Long getRegisteredcapital() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.MainBusinessScope</code>.
     */
    public void setMainbusinessscope(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.MainBusinessScope</code>.
     */
    public String getMainbusinessscope() {
        return (String) get(5);
    }

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.OperationType</code>.
     */
    public void setOperationtype(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.OperationType</code>.
     */
    public Integer getOperationtype() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>bcinvest.FundamentalCertificate.AccountNum</code>.
     */
    public void setAccountnum(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>bcinvest.FundamentalCertificate.AccountNum</code>.
     */
    public String getAccountnum() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, LocalDateTime, LocalDateTime, String, Long, String, Integer, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, LocalDateTime, LocalDateTime, String, Long, String, Integer, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.BUSINESSLICENCENUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field2() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.STARTDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field3() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.ENDDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.BUSINESSREGISTRATIONNO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.REGISTEREDCAPITAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.MAINBUSINESSSCOPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.OPERATIONTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Fundamentalcertificate.FUNDAMENTALCERTIFICATE.ACCOUNTNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getBusinesslicencenum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component2() {
        return getStartdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component3() {
        return getEnddate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getBusinessregistrationno();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getRegisteredcapital();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getMainbusinessscope();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getOperationtype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getAccountnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getBusinesslicencenum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value2() {
        return getStartdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value3() {
        return getEnddate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getBusinessregistrationno();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getRegisteredcapital();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getMainbusinessscope();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getOperationtype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getAccountnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value1(String value) {
        setBusinesslicencenum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value2(LocalDateTime value) {
        setStartdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value3(LocalDateTime value) {
        setEnddate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value4(String value) {
        setBusinessregistrationno(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value5(Long value) {
        setRegisteredcapital(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value6(String value) {
        setMainbusinessscope(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value7(Integer value) {
        setOperationtype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord value8(String value) {
        setAccountnum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FundamentalcertificateRecord values(String value1, LocalDateTime value2, LocalDateTime value3, String value4, Long value5, String value6, Integer value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FundamentalcertificateRecord
     */
    public FundamentalcertificateRecord() {
        super(Fundamentalcertificate.FUNDAMENTALCERTIFICATE);
    }

    /**
     * Create a detached, initialised FundamentalcertificateRecord
     */
    public FundamentalcertificateRecord(String businesslicencenum, LocalDateTime startdate, LocalDateTime enddate, String businessregistrationno, Long registeredcapital, String mainbusinessscope, Integer operationtype, String accountnum) {
        super(Fundamentalcertificate.FUNDAMENTALCERTIFICATE);

        set(0, businesslicencenum);
        set(1, startdate);
        set(2, enddate);
        set(3, businessregistrationno);
        set(4, registeredcapital);
        set(5, mainbusinessscope);
        set(6, operationtype);
        set(7, accountnum);
    }
}