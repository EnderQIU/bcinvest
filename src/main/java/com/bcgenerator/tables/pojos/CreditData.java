/*
 * This file is generated by jOOQ.
*/
package com.bcgenerator.tables.pojos;


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
public class CreditData implements Serializable {

    private static final long serialVersionUID = 617192038;

    private String blockHash;
    private String id;
    private String variation;
    private String value;
    private String remarks;

    public CreditData() {}

    public CreditData(CreditData value) {
        this.blockHash = value.blockHash;
        this.id = value.id;
        this.variation = value.variation;
        this.value = value.value;
        this.remarks = value.remarks;
    }

    public CreditData(
        String blockHash,
        String id,
        String variation,
        String value,
        String remarks
    ) {
        this.blockHash = blockHash;
        this.id = id;
        this.variation = variation;
        this.value = value;
        this.remarks = remarks;
    }

    public String getBlockHash() {
        return this.blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariation() {
        return this.variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CreditData (");

        sb.append(blockHash);
        sb.append(", ").append(id);
        sb.append(", ").append(variation);
        sb.append(", ").append(value);
        sb.append(", ").append(remarks);

        sb.append(")");
        return sb.toString();
    }
}
