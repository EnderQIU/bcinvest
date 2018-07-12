/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.records;


import com.generator.tables.Machine;

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
public class MachineRecord extends UpdatableRecordImpl<MachineRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = -308833796;

    /**
     * Setter for <code>bcinvest.Machine.UsedDays</code>.
     */
    public void setUseddays(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>bcinvest.Machine.UsedDays</code>.
     */
    public Integer getUseddays() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>bcinvest.Machine.Producer</code>.
     */
    public void setProducer(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bcinvest.Machine.Producer</code>.
     */
    public String getProducer() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bcinvest.Machine.Model</code>.
     */
    public void setModel(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>bcinvest.Machine.Model</code>.
     */
    public String getModel() {
        return (String) get(2);
    }

    /**
     * Setter for <code>bcinvest.Machine.GuarantyId</code>.
     */
    public void setGuarantyid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>bcinvest.Machine.GuarantyId</code>.
     */
    public Integer getGuarantyid() {
        return (Integer) get(3);
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
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Machine.MACHINE.USEDDAYS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Machine.MACHINE.PRODUCER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Machine.MACHINE.MODEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Machine.MACHINE.GUARANTYID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getUseddays();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getProducer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getGuarantyid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getUseddays();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getProducer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getModel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getGuarantyid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MachineRecord value1(Integer value) {
        setUseddays(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MachineRecord value2(String value) {
        setProducer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MachineRecord value3(String value) {
        setModel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MachineRecord value4(Integer value) {
        setGuarantyid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MachineRecord values(Integer value1, String value2, String value3, Integer value4) {
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
     * Create a detached MachineRecord
     */
    public MachineRecord() {
        super(Machine.MACHINE);
    }

    /**
     * Create a detached, initialised MachineRecord
     */
    public MachineRecord(Integer useddays, String producer, String model, Integer guarantyid) {
        super(Machine.MACHINE);

        set(0, useddays);
        set(1, producer);
        set(2, model);
        set(3, guarantyid);
    }
}
