/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.daos;


import com.generator.tables.Credit;
import com.generator.tables.records.CreditRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Record3;
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
public class CreditDao extends DAOImpl<CreditRecord, com.generator.tables.pojos.Credit, Record3<String, Integer, Integer>> {

    /**
     * Create a new CreditDao without any configuration
     */
    public CreditDao() {
        super(Credit.CREDIT, com.generator.tables.pojos.Credit.class);
    }

    /**
     * Create a new CreditDao with an attached configuration
     */
    public CreditDao(Configuration configuration) {
        super(Credit.CREDIT, com.generator.tables.pojos.Credit.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Record3<String, Integer, Integer> getId(com.generator.tables.pojos.Credit object) {
        return compositeKeyRecord(object.getAccountnum(), object.getGuarantyid(), object.getReportid());
    }

    /**
     * Fetch records that have <code>AccountNum IN (values)</code>
     */
    public List<com.generator.tables.pojos.Credit> fetchByAccountnum(String... values) {
        return fetch(Credit.CREDIT.ACCOUNTNUM, values);
    }

    /**
     * Fetch records that have <code>GuarantyId IN (values)</code>
     */
    public List<com.generator.tables.pojos.Credit> fetchByGuarantyid(Integer... values) {
        return fetch(Credit.CREDIT.GUARANTYID, values);
    }

    /**
     * Fetch records that have <code>ReportId IN (values)</code>
     */
    public List<com.generator.tables.pojos.Credit> fetchByReportid(Integer... values) {
        return fetch(Credit.CREDIT.REPORTID, values);
    }

    /**
     * Fetch records that have <code>Type IN (values)</code>
     */
    public List<com.generator.tables.pojos.Credit> fetchByType(Byte... values) {
        return fetch(Credit.CREDIT.TYPE, values);
    }
}
