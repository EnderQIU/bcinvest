/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.daos;


import com.generator.tables.Companyaddress;
import com.generator.tables.records.CompanyaddressRecord;

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
public class CompanyaddressDao extends DAOImpl<CompanyaddressRecord, com.generator.tables.pojos.Companyaddress, String> {

    /**
     * Create a new CompanyaddressDao without any configuration
     */
    public CompanyaddressDao() {
        super(Companyaddress.COMPANYADDRESS, com.generator.tables.pojos.Companyaddress.class);
    }

    /**
     * Create a new CompanyaddressDao with an attached configuration
     */
    public CompanyaddressDao(Configuration configuration) {
        super(Companyaddress.COMPANYADDRESS, com.generator.tables.pojos.Companyaddress.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(com.generator.tables.pojos.Companyaddress object) {
        return object.getAccountnum();
    }

    /**
     * Fetch records that have <code>AccountNum IN (values)</code>
     */
    public List<com.generator.tables.pojos.Companyaddress> fetchByAccountnum(String... values) {
        return fetch(Companyaddress.COMPANYADDRESS.ACCOUNTNUM, values);
    }

    /**
     * Fetch a unique record that has <code>AccountNum = value</code>
     */
    public com.generator.tables.pojos.Companyaddress fetchOneByAccountnum(String value) {
        return fetchOne(Companyaddress.COMPANYADDRESS.ACCOUNTNUM, value);
    }

    /**
     * Fetch records that have <code>Addr IN (values)</code>
     */
    public List<com.generator.tables.pojos.Companyaddress> fetchByAddr(String... values) {
        return fetch(Companyaddress.COMPANYADDRESS.ADDR, values);
    }
}