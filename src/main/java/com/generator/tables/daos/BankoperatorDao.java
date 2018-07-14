/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.daos;


import com.generator.tables.Bankoperator;
import com.generator.tables.records.BankoperatorRecord;

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
public class BankoperatorDao extends DAOImpl<BankoperatorRecord, com.generator.tables.pojos.Bankoperator, Integer> {

    /**
     * Create a new BankoperatorDao without any configuration
     */
    public BankoperatorDao() {
        super(Bankoperator.BANKOPERATOR, com.generator.tables.pojos.Bankoperator.class);
    }

    /**
     * Create a new BankoperatorDao with an attached configuration
     */
    public BankoperatorDao(Configuration configuration) {
        super(Bankoperator.BANKOPERATOR, com.generator.tables.pojos.Bankoperator.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.generator.tables.pojos.Bankoperator object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.generator.tables.pojos.Bankoperator> fetchById(Integer... values) {
        return fetch(Bankoperator.BANKOPERATOR.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.generator.tables.pojos.Bankoperator fetchOneById(Integer value) {
        return fetchOne(Bankoperator.BANKOPERATOR.ID, value);
    }

    /**
     * Fetch records that have <code>username IN (values)</code>
     */
    public List<com.generator.tables.pojos.Bankoperator> fetchByUsername(String... values) {
        return fetch(Bankoperator.BANKOPERATOR.USERNAME, values);
    }

    /**
     * Fetch records that have <code>password IN (values)</code>
     */
    public List<com.generator.tables.pojos.Bankoperator> fetchByPassword(String... values) {
        return fetch(Bankoperator.BANKOPERATOR.PASSWORD, values);
    }

    /**
     * Fetch records that have <code>token IN (values)</code>
     */
    public List<com.generator.tables.pojos.Bankoperator> fetchByToken(String... values) {
        return fetch(Bankoperator.BANKOPERATOR.TOKEN, values);
    }
}