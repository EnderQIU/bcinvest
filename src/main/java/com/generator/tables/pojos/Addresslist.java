/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Addresslist implements Serializable {

    private static final long serialVersionUID = 68833386;

    private String address;

    public Addresslist() {}

    public Addresslist(Addresslist value) {
        this.address = value.address;
    }

    public Addresslist(
        String address
    ) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Addresslist (");

        sb.append(address);

        sb.append(")");
        return sb.toString();
    }
}
