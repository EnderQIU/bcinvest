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
public class Guaranty implements Serializable {

    private static final long serialVersionUID = -941590678;

    private Integer guarantyid;
    private String  accountnum;
    private Integer state;
    private Integer scopeofright;
    private String  ownername;
    private Integer reportid;
    private Integer type;
    private Integer evaluatevalue;
    private String  name;
    private Byte    lock;

    public Guaranty() {}

    public Guaranty(Guaranty value) {
        this.guarantyid = value.guarantyid;
        this.accountnum = value.accountnum;
        this.state = value.state;
        this.scopeofright = value.scopeofright;
        this.ownername = value.ownername;
        this.reportid = value.reportid;
        this.type = value.type;
        this.evaluatevalue = value.evaluatevalue;
        this.name = value.name;
        this.lock = value.lock;
    }

    public Guaranty(
        Integer guarantyid,
        String  accountnum,
        Integer state,
        Integer scopeofright,
        String  ownername,
        Integer reportid,
        Integer type,
        Integer evaluatevalue,
        String  name,
        Byte    lock
    ) {
        this.guarantyid = guarantyid;
        this.accountnum = accountnum;
        this.state = state;
        this.scopeofright = scopeofright;
        this.ownername = ownername;
        this.reportid = reportid;
        this.type = type;
        this.evaluatevalue = evaluatevalue;
        this.name = name;
        this.lock = lock;
    }

    public Integer getGuarantyid() {
        return this.guarantyid;
    }

    public void setGuarantyid(Integer guarantyid) {
        this.guarantyid = guarantyid;
    }

    public String getAccountnum() {
        return this.accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getScopeofright() {
        return this.scopeofright;
    }

    public void setScopeofright(Integer scopeofright) {
        this.scopeofright = scopeofright;
    }

    public String getOwnername() {
        return this.ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Integer getReportid() {
        return this.reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEvaluatevalue() {
        return this.evaluatevalue;
    }

    public void setEvaluatevalue(Integer evaluatevalue) {
        this.evaluatevalue = evaluatevalue;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getLock() {
        return this.lock;
    }

    public void setLock(Byte lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Guaranty (");

        sb.append(guarantyid);
        sb.append(", ").append(accountnum);
        sb.append(", ").append(state);
        sb.append(", ").append(scopeofright);
        sb.append(", ").append(ownername);
        sb.append(", ").append(reportid);
        sb.append(", ").append(type);
        sb.append(", ").append(evaluatevalue);
        sb.append(", ").append(name);
        sb.append(", ").append(lock);

        sb.append(")");
        return sb.toString();
    }
}
