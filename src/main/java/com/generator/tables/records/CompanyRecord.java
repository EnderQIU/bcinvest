/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Company;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class CompanyRecord extends UpdatableRecordImpl<CompanyRecord> implements Record7<String, String, String, String, String, Long, String> {

    private static final long serialVersionUID = -663565041;

    /**
     * Setter for <code>bcinvest.Company.AccountNum</code>.
     */
    public void setAccountnum(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.Company.AccountNum</code>.
     */
    public String getAccountnum() {
        return (String) get(0);
    }

    /**
     * Setter for <code>bcinvest.Company.Name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bcinvest.Company.Name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bcinvest.Company.TelNum</code>.
     */
    public void setTelnum(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>bcinvest.Company.TelNum</code>.
     */
    public String getTelnum() {
        return (String) get(2);
    }

    /**
     * Setter for <code>bcinvest.Company.EmailAddress</code>.
     */
    public void setEmailaddress(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>bcinvest.Company.EmailAddress</code>.
     */
    public String getEmailaddress() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bcinvest.Company.Token</code>.
     */
    public void setToken(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>bcinvest.Company.Token</code>.
     */
    public String getToken() {
        return (String) get(4);
    }

    /**
     * Setter for <code>bcinvest.Company.Credit</code>.
     */
    public void setCredit(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>bcinvest.Company.Credit</code>.
     */
    public Long getCredit() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>bcinvest.Company.Status</code>.
     */
    public void setStatus(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>bcinvest.Company.Status</code>.
     */
    public String getStatus() {
        return (String) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, String, String, String, String, Long, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, String, String, String, String, Long, String> valuesRow() {
        return (Row7) super.valuesRow();
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
    public CompanyRecord values(String value1, String value2, String value3, String value4, String value5, Long value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
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
    public CompanyRecord(String accountnum, String name, String telnum, String emailaddress, String token, Long credit, String status) {
        super(Company.COMPANY);

        set(0, accountnum);
        set(1, name);
        set(2, telnum);
        set(3, emailaddress);
        set(4, token);
        set(5, credit);
        set(6, status);
    }
}
