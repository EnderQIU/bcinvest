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
public class Credit implements Serializable {

    private static final long serialVersionUID = -437716897;

    private String  accountnum;
    private Integer guarantyid;
    private Integer reportid;
    private Byte    type;
    private Byte    lock;

    public Credit() {}

    public Credit(Credit value) {
        this.accountnum = value.accountnum;
        this.guarantyid = value.guarantyid;
        this.reportid = value.reportid;
        this.type = value.type;
        this.lock = value.lock;
    }

    public Credit(
        String  accountnum,
        Integer guarantyid,
        Integer reportid,
        Byte    type,
        Byte    lock
    ) {
        this.accountnum = accountnum;
        this.guarantyid = guarantyid;
        this.reportid = reportid;
        this.type = type;
        this.lock = lock;
    }

    public String getAccountnum() {
        return this.accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    public Integer getGuarantyid() {
        return this.guarantyid;
    }

    public void setGuarantyid(Integer guarantyid) {
        this.guarantyid = guarantyid;
    }

    public Integer getReportid() {
        return this.reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public Byte getType() {
        return this.type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getLock() {
        return this.lock;
    }

    public void setLock(Byte lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Credit (");

        sb.append(accountnum);
        sb.append(", ").append(guarantyid);
        sb.append(", ").append(reportid);
        sb.append(", ").append(type);
        sb.append(", ").append(lock);

        sb.append(")");
        return sb.toString();
    }
}
