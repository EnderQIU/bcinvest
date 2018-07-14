/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.daos;


import com.generator.tables.Protocol;
import com.generator.tables.records.ProtocolRecord;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class ProtocolDao extends DAOImpl<ProtocolRecord, com.generator.tables.pojos.Protocol, Integer> {

    /**
     * Create a new ProtocolDao without any configuration
     */
    public ProtocolDao() {
        super(Protocol.PROTOCOL, com.generator.tables.pojos.Protocol.class);
    }

    /**
     * Create a new ProtocolDao with an attached configuration
     */
    public ProtocolDao(Configuration configuration) {
        super(Protocol.PROTOCOL, com.generator.tables.pojos.Protocol.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.generator.tables.pojos.Protocol object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchById(Integer... values) {
        return fetch(Protocol.PROTOCOL.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.generator.tables.pojos.Protocol fetchOneById(Integer value) {
        return fetchOne(Protocol.PROTOCOL.ID, value);
    }

    /**
     * Fetch records that have <code>company_id IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByCompanyId(String... values) {
        return fetch(Protocol.PROTOCOL.COMPANY_ID, values);
    }

    /**
     * Fetch records that have <code>guaranty_id IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByGuarantyId(String... values) {
        return fetch(Protocol.PROTOCOL.GUARANTY_ID, values);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByCreateTime(LocalDateTime... values) {
        return fetch(Protocol.PROTOCOL.CREATE_TIME, values);
    }

    /**
     * Fetch records that have <code>duration IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByDuration(String... values) {
        return fetch(Protocol.PROTOCOL.DURATION, values);
    }

    /**
     * Fetch records that have <code>end_time IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByEndTime(String... values) {
        return fetch(Protocol.PROTOCOL.END_TIME, values);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByContent(String... values) {
        return fetch(Protocol.PROTOCOL.CONTENT, values);
    }

    /**
     * Fetch records that have <code>status IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByStatus(String... values) {
        return fetch(Protocol.PROTOCOL.STATUS, values);
    }

    /**
     * Fetch records that have <code>lock IN (values)</code>
     */
    public List<com.generator.tables.pojos.Protocol> fetchByLock(Byte... values) {
        return fetch(Protocol.PROTOCOL.LOCK, values);
    }
}
