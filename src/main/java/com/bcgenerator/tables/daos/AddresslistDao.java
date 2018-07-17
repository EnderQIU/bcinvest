/*
 * This file is generated by jOOQ.
*/
package com.bcgenerator.tables.daos;


import com.bcgenerator.tables.Addresslist;
import com.bcgenerator.tables.records.AddresslistRecord;

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
public class AddresslistDao extends DAOImpl<AddresslistRecord, com.bcgenerator.tables.pojos.Addresslist, String> {

    /**
     * Create a new AddresslistDao without any configuration
     */
    public AddresslistDao() {
        super(Addresslist.ADDRESSLIST, com.bcgenerator.tables.pojos.Addresslist.class);
    }

    /**
     * Create a new AddresslistDao with an attached configuration
     */
    public AddresslistDao(Configuration configuration) {
        super(Addresslist.ADDRESSLIST, com.bcgenerator.tables.pojos.Addresslist.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getId(com.bcgenerator.tables.pojos.Addresslist object) {
        return object.getAddress();
    }

    /**
     * Fetch records that have <code>address IN (values)</code>
     */
    public List<com.bcgenerator.tables.pojos.Addresslist> fetchByAddress(String... values) {
        return fetch(Addresslist.ADDRESSLIST.ADDRESS, values);
    }

    /**
     * Fetch a unique record that has <code>address = value</code>
     */
    public com.bcgenerator.tables.pojos.Addresslist fetchOneByAddress(String value) {
        return fetchOne(Addresslist.ADDRESSLIST.ADDRESS, value);
    }
}
