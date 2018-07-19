/*
 * This file is generated by jOOQ.
*/
package com.generator.tables;


import com.generator.Bcinvest;
import com.generator.Indexes;
import com.generator.Keys;
import com.generator.tables.records.MessageRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Message extends TableImpl<MessageRecord> {

    private static final long serialVersionUID = 2049253917;

    /**
     * The reference instance of <code>bcinvest.Message</code>
     */
    public static final Message MESSAGE = new Message();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MessageRecord> getRecordType() {
        return MessageRecord.class;
    }

    /**
     * The column <code>bcinvest.Message.id</code>.
     */
    public final TableField<MessageRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>bcinvest.Message.content</code>.
     */
    public final TableField<MessageRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>bcinvest.Message.fromUserNum</code>.
     */
    public final TableField<MessageRecord, String> FROMUSERNUM = createField("fromUserNum", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Message.toUserNum</code>.
     */
    public final TableField<MessageRecord, String> TOUSERNUM = createField("toUserNum", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>bcinvest.Message.status</code>.
     */
    public final TableField<MessageRecord, Byte> STATUS = createField("status", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * Create a <code>bcinvest.Message</code> table reference
     */
    public Message() {
        this(DSL.name("Message"), null);
    }

    /**
     * Create an aliased <code>bcinvest.Message</code> table reference
     */
    public Message(String alias) {
        this(DSL.name(alias), MESSAGE);
    }

    /**
     * Create an aliased <code>bcinvest.Message</code> table reference
     */
    public Message(Name alias) {
        this(alias, MESSAGE);
    }

    private Message(Name alias, Table<MessageRecord> aliased) {
        this(alias, aliased, null);
    }

    private Message(Name alias, Table<MessageRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.MESSAGE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<MessageRecord, Integer> getIdentity() {
        return Keys.IDENTITY_MESSAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<MessageRecord> getPrimaryKey() {
        return Keys.KEY_MESSAGE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MessageRecord>> getKeys() {
        return Arrays.<UniqueKey<MessageRecord>>asList(Keys.KEY_MESSAGE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message as(String alias) {
        return new Message(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message as(Name alias) {
        return new Message(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Message rename(String name) {
        return new Message(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Message rename(Name name) {
        return new Message(name, null);
    }
}
