/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * VIEW
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GuarantyMainChainView implements Serializable {

    private static final long serialVersionUID = 490535586;

    private String id;
    private String value;
    private String variation;
    private String remarks;

    public GuarantyMainChainView() {}

    public GuarantyMainChainView(GuarantyMainChainView value) {
        this.id = value.id;
        this.value = value.value;
        this.variation = value.variation;
        this.remarks = value.remarks;
    }

    public GuarantyMainChainView(
        String id,
        String value,
        String variation,
        String remarks
    ) {
        this.id = id;
        this.value = value;
        this.variation = variation;
        this.remarks = remarks;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVariation() {
        return this.variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GuarantyMainChainView (");

        sb.append(id);
        sb.append(", ").append(value);
        sb.append(", ").append(variation);
        sb.append(", ").append(remarks);

        sb.append(")");
        return sb.toString();
    }
}