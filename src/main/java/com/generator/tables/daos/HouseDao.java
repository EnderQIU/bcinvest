/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.daos;


import com.generator.tables.House;
import com.generator.tables.records.HouseRecord;

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
public class HouseDao extends DAOImpl<HouseRecord, com.generator.tables.pojos.House, Integer> {

    /**
     * Create a new HouseDao without any configuration
     */
    public HouseDao() {
        super(House.HOUSE, com.generator.tables.pojos.House.class);
    }

    /**
     * Create a new HouseDao with an attached configuration
     */
    public HouseDao(Configuration configuration) {
        super(House.HOUSE, com.generator.tables.pojos.House.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.generator.tables.pojos.House object) {
        return object.getGuarantyid();
    }

    /**
     * Fetch records that have <code>Addr IN (values)</code>
     */
    public List<com.generator.tables.pojos.House> fetchByAddr(String... values) {
        return fetch(House.HOUSE.ADDR, values);
    }

    /**
     * Fetch records that have <code>Zip IN (values)</code>
     */
    public List<com.generator.tables.pojos.House> fetchByZip(String... values) {
        return fetch(House.HOUSE.ZIP, values);
    }

    /**
     * Fetch records that have <code>HousingCertificatedId IN (values)</code>
     */
    public List<com.generator.tables.pojos.House> fetchByHousingcertificatedid(String... values) {
        return fetch(House.HOUSE.HOUSINGCERTIFICATEDID, values);
    }

    /**
     * Fetch records that have <code>GuarantyId IN (values)</code>
     */
    public List<com.generator.tables.pojos.House> fetchByGuarantyid(Integer... values) {
        return fetch(House.HOUSE.GUARANTYID, values);
    }

    /**
     * Fetch a unique record that has <code>GuarantyId = value</code>
     */
    public com.generator.tables.pojos.House fetchOneByGuarantyid(Integer value) {
        return fetchOne(House.HOUSE.GUARANTYID, value);
    }
}