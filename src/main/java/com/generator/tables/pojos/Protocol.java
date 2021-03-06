/*
 * This file is generated by jOOQ.
*/
package com.generator.tables.pojos;


import java.io.Serializable;
import java.time.LocalDate;

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
public class Protocol implements Serializable {

    private static final long serialVersionUID = 1684402065;

    private Integer   protocolid;
    private Integer   gurantyid;
    private LocalDate startdate;
    private String    duration;
    private LocalDate enddate;
    private String    message;
    private String    condition;

    public Protocol() {}

    public Protocol(Protocol value) {
        this.protocolid = value.protocolid;
        this.gurantyid = value.gurantyid;
        this.startdate = value.startdate;
        this.duration = value.duration;
        this.enddate = value.enddate;
        this.message = value.message;
        this.condition = value.condition;
    }

    public Protocol(
        Integer   protocolid,
        Integer   gurantyid,
        LocalDate startdate,
        String    duration,
        LocalDate enddate,
        String    message,
        String    condition
    ) {
        this.protocolid = protocolid;
        this.gurantyid = gurantyid;
        this.startdate = startdate;
        this.duration = duration;
        this.enddate = enddate;
        this.message = message;
        this.condition = condition;
    }

    public Integer getProtocolid() {
        return this.protocolid;
    }

    public void setProtocolid(Integer protocolid) {
        this.protocolid = protocolid;
    }

    public Integer getGurantyid() {
        return this.gurantyid;
    }

    public void setGurantyid(Integer gurantyid) {
        this.gurantyid = gurantyid;
    }

    public LocalDate getStartdate() {
        return this.startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getEnddate() {
        return this.enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Protocol (");

        sb.append(protocolid);
        sb.append(", ").append(gurantyid);
        sb.append(", ").append(startdate);
        sb.append(", ").append(duration);
        sb.append(", ").append(enddate);
        sb.append(", ").append(message);
        sb.append(", ").append(condition);

        sb.append(")");
        return sb.toString();
    }
}
