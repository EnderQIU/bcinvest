/*
 * This file is generated by jOOQ.
*/
package com.bcgenerator.tables.records;


import com.bcgenerator.tables.Addresslist;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
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
public class AddresslistRecord extends UpdatableRecordImpl<AddresslistRecord> implements Record1<String> {

    private static final long serialVersionUID = -564954021;

    /**
     * Setter for <code>blockchain.addresslist.address</code>.
     */
    public void setAddress(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>blockchain.addresslist.address</code>.
     */
    public String getAddress() {
        return (String) get(0);
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
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Addresslist.ADDRESSLIST.ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddresslistRecord value1(String value) {
        setAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddresslistRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AddresslistRecord
     */
    public AddresslistRecord() {
        super(Addresslist.ADDRESSLIST);
    }

    /**
     * Create a detached, initialised AddresslistRecord
     */
    public AddresslistRecord(String address) {
        super(Addresslist.ADDRESSLIST);

        set(0, address);
    }
}
