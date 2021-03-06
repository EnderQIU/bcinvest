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
public class Land implements Serializable {

    private static final long serialVersionUID = 1701725972;

    private String  addr;
    private Long    area;
    private Integer guarantyid;

    public Land() {}

    public Land(Land value) {
        this.addr = value.addr;
        this.area = value.area;
        this.guarantyid = value.guarantyid;
    }

    public Land(
        String  addr,
        Long    area,
        Integer guarantyid
    ) {
        this.addr = addr;
        this.area = area;
        this.guarantyid = guarantyid;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Long getArea() {
        return this.area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Integer getGuarantyid() {
        return this.guarantyid;
    }

    public void setGuarantyid(Integer guarantyid) {
        this.guarantyid = guarantyid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Land (");

        sb.append(addr);
        sb.append(", ").append(area);
        sb.append(", ").append(guarantyid);

        sb.append(")");
        return sb.toString();
    }
}
