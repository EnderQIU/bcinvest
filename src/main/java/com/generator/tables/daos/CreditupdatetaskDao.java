/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.daos;


import com.generator.tables.Creditupdatetask;
import com.generator.tables.records.CreditupdatetaskRecord;

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
public class CreditupdatetaskDao extends DAOImpl<CreditupdatetaskRecord, com.generator.tables.pojos.Creditupdatetask, Integer> {

    /**
     * Create a new CreditupdatetaskDao without any configuration
     */
    public CreditupdatetaskDao() {
        super(Creditupdatetask.CREDITUPDATETASK, com.generator.tables.pojos.Creditupdatetask.class);
    }

    /**
     * Create a new CreditupdatetaskDao with an attached configuration
     */
    public CreditupdatetaskDao(Configuration configuration) {
        super(Creditupdatetask.CREDITUPDATETASK, com.generator.tables.pojos.Creditupdatetask.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.generator.tables.pojos.Creditupdatetask object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.generator.tables.pojos.Creditupdatetask> fetchById(Integer... values) {
        return fetch(Creditupdatetask.CREDITUPDATETASK.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.generator.tables.pojos.Creditupdatetask fetchOneById(Integer value) {
        return fetchOne(Creditupdatetask.CREDITUPDATETASK.ID, value);
    }

    /**
     * Fetch records that have <code>AccountNum IN (values)</code>
     */
    public List<com.generator.tables.pojos.Creditupdatetask> fetchByAccountnum(String... values) {
        return fetch(Creditupdatetask.CREDITUPDATETASK.ACCOUNTNUM, values);
    }

    /**
     * Fetch records that have <code>previousCredit IN (values)</code>
     */
    public List<com.generator.tables.pojos.Creditupdatetask> fetchByPreviouscredit(Integer... values) {
        return fetch(Creditupdatetask.CREDITUPDATETASK.PREVIOUSCREDIT, values);
    }

    /**
     * Fetch records that have <code>delta IN (values)</code>
     */
    public List<com.generator.tables.pojos.Creditupdatetask> fetchByDelta(Integer... values) {
        return fetch(Creditupdatetask.CREDITUPDATETASK.DELTA, values);
    }

    /**
     * Fetch records that have <code>state IN (values)</code>
     */
    public List<com.generator.tables.pojos.Creditupdatetask> fetchByState(String... values) {
        return fetch(Creditupdatetask.CREDITUPDATETASK.STATE, values);
    }

    /**
     * Fetch records that have <code>timestamp IN (values)</code>
     */
    public List<com.generator.tables.pojos.Creditupdatetask> fetchByTimestamp(String... values) {
        return fetch(Creditupdatetask.CREDITUPDATETASK.TIMESTAMP, values);
    }

    /**
     * Fetch records that have <code>reason IN (values)</code>
     */
    public List<com.generator.tables.pojos.Creditupdatetask> fetchByReason(String... values) {
        return fetch(Creditupdatetask.CREDITUPDATETASK.REASON, values);
    }
}
