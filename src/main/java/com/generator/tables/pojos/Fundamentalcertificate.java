/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

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
public class Fundamentalcertificate implements Serializable {

    private static final long serialVersionUID = -35509340;

    private String        businesslicencenum;
    private LocalDateTime startdate;
    private LocalDateTime enddate;
    private String        businessregistrationno;
    private Long          registeredcapital;
    private String        mainbusinessscope;
    private Integer       operationtype;
    private String        accountnum;

    public Fundamentalcertificate() {}

    public Fundamentalcertificate(Fundamentalcertificate value) {
        this.businesslicencenum = value.businesslicencenum;
        this.startdate = value.startdate;
        this.enddate = value.enddate;
        this.businessregistrationno = value.businessregistrationno;
        this.registeredcapital = value.registeredcapital;
        this.mainbusinessscope = value.mainbusinessscope;
        this.operationtype = value.operationtype;
        this.accountnum = value.accountnum;
    }

    public Fundamentalcertificate(
        String        businesslicencenum,
        LocalDateTime startdate,
        LocalDateTime enddate,
        String        businessregistrationno,
        Long          registeredcapital,
        String        mainbusinessscope,
        Integer       operationtype,
        String        accountnum
    ) {
        this.businesslicencenum = businesslicencenum;
        this.startdate = startdate;
        this.enddate = enddate;
        this.businessregistrationno = businessregistrationno;
        this.registeredcapital = registeredcapital;
        this.mainbusinessscope = mainbusinessscope;
        this.operationtype = operationtype;
        this.accountnum = accountnum;
    }

    public String getBusinesslicencenum() {
        return this.businesslicencenum;
    }

    public void setBusinesslicencenum(String businesslicencenum) {
        this.businesslicencenum = businesslicencenum;
    }

    public LocalDateTime getStartdate() {
        return this.startdate;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public LocalDateTime getEnddate() {
        return this.enddate;
    }

    public void setEnddate(LocalDateTime enddate) {
        this.enddate = enddate;
    }

    public String getBusinessregistrationno() {
        return this.businessregistrationno;
    }

    public void setBusinessregistrationno(String businessregistrationno) {
        this.businessregistrationno = businessregistrationno;
    }

    public Long getRegisteredcapital() {
        return this.registeredcapital;
    }

    public void setRegisteredcapital(Long registeredcapital) {
        this.registeredcapital = registeredcapital;
    }

    public String getMainbusinessscope() {
        return this.mainbusinessscope;
    }

    public void setMainbusinessscope(String mainbusinessscope) {
        this.mainbusinessscope = mainbusinessscope;
    }

    public Integer getOperationtype() {
        return this.operationtype;
    }

    public void setOperationtype(Integer operationtype) {
        this.operationtype = operationtype;
    }

    public String getAccountnum() {
        return this.accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Fundamentalcertificate (");

        sb.append(businesslicencenum);
        sb.append(", ").append(startdate);
        sb.append(", ").append(enddate);
        sb.append(", ").append(businessregistrationno);
        sb.append(", ").append(registeredcapital);
        sb.append(", ").append(mainbusinessscope);
        sb.append(", ").append(operationtype);
        sb.append(", ").append(accountnum);

        sb.append(")");
        return sb.toString();
    }
}