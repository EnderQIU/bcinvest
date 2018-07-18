/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Company;

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
public class CompanyRecord extends UpdatableRecordImpl<CompanyRecord> implements Record8<String, String, String, String, String, Long, String, Byte> {

    private static final long serialVersionUID = 1354285933;

    /**
     * Setter for <code>bcinvest.company.AccountNum</code>.
     */
    public void setAccountnum(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.company.AccountNum</code>.
     */
    public String getAccountnum() {
        return (String) get(0);
    }

    /**
     * Setter for <code>bcinvest.company.Name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bcinvest.company.Name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bcinvest.company.TelNum</code>.
     */
    public void setTelnum(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>bcinvest.company.TelNum</code>.
     */
    public String getTelnum() {
        return (String) get(2);
    }

    /**
     * Setter for <code>bcinvest.company.EmailAddress</code>.
     */
    public void setEmailaddress(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>bcinvest.company.EmailAddress</code>.
     */
    public String getEmailaddress() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bcinvest.company.Token</code>.
     */
    public void setToken(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>bcinvest.company.Token</code>.
     */
    public String getToken() {
        return (String) get(4);
    }

    /**
     * Setter for <code>bcinvest.company.Credit</code>.
     */
    public void setCredit(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>bcinvest.company.Credit</code>.
     */
    public Long getCredit() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>bcinvest.company.Status</code>.
     */
    public void setStatus(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>bcinvest.company.Status</code>.
     */
    public String getStatus() {
        return (String) get(6);
    }

    /**
     * Setter for <code>bcinvest.company.Lock</code>.
     */
    public void setLock(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>bcinvest.company.Lock</code>.
     */
    public Byte getLock() {
        return (Byte) get(7);
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
    public Row8<String, String, String, String, String, Long, String, Byte> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, String, String, String, Long, String, Byte> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Company.COMPANY.ACCOUNTNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Company.COMPANY.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Company.COMPANY.TELNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Company.COMPANY.EMAILADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Company.COMPANY.TOKEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return Company.COMPANY.CREDIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Company.COMPANY.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Company.COMPANY.LOCK;
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
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getTelnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEmailaddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component6() {
        return getCredit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component8() {
        return getLock();
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTelnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEmailaddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getCredit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getLock();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value1(String value) {
        setAccountnum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value3(String value) {
        setTelnum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value4(String value) {
        setEmailaddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value5(String value) {
        setToken(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value6(Long value) {
        setCredit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value7(String value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord value8(Byte value) {
        setLock(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyRecord values(String value1, String value2, String value3, String value4, String value5, Long value6, String value7, Byte value8) {
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
     * Create a detached CompanyRecord
     */
    public CompanyRecord() {
        super(Company.COMPANY);
    }

    /**
     * Create a detached, initialised CompanyRecord
     */
    public CompanyRecord(String accountnum, String name, String telnum, String emailaddress, String token, Long credit, String status, Byte lock) {
        super(Company.COMPANY);

        set(0, accountnum);
        set(1, name);
        set(2, telnum);
        set(3, emailaddress);
        set(4, token);
        set(5, credit);
        set(6, status);
        set(7, lock);
    }
}
