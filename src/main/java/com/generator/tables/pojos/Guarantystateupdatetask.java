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
public class Guarantystateupdatetask implements Serializable {

    private static final long serialVersionUID = -292197282;

    private Integer taskid;
    private Integer guarantyid;
    private Integer previousstate;
    private Integer statewillupdateto;
    private String  taskstate;
    private Integer count;

    public Guarantystateupdatetask() {}

    public Guarantystateupdatetask(Guarantystateupdatetask value) {
        this.taskid = value.taskid;
        this.guarantyid = value.guarantyid;
        this.previousstate = value.previousstate;
        this.statewillupdateto = value.statewillupdateto;
        this.taskstate = value.taskstate;
        this.count = value.count;
    }

    public Guarantystateupdatetask(
        Integer taskid,
        Integer guarantyid,
        Integer previousstate,
        Integer statewillupdateto,
        String  taskstate,
        Integer count
    ) {
        this.taskid = taskid;
        this.guarantyid = guarantyid;
        this.previousstate = previousstate;
        this.statewillupdateto = statewillupdateto;
        this.taskstate = taskstate;
        this.count = count;
    }

    public Integer getTaskid() {
        return this.taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getGuarantyid() {
        return this.guarantyid;
    }

    public void setGuarantyid(Integer guarantyid) {
        this.guarantyid = guarantyid;
    }

    public Integer getPreviousstate() {
        return this.previousstate;
    }

    public void setPreviousstate(Integer previousstate) {
        this.previousstate = previousstate;
    }

    public Integer getStatewillupdateto() {
        return this.statewillupdateto;
    }

    public void setStatewillupdateto(Integer statewillupdateto) {
        this.statewillupdateto = statewillupdateto;
    }

    public String getTaskstate() {
        return this.taskstate;
    }

    public void setTaskstate(String taskstate) {
        this.taskstate = taskstate;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Guarantystateupdatetask (");

        sb.append(taskid);
        sb.append(", ").append(guarantyid);
        sb.append(", ").append(previousstate);
        sb.append(", ").append(statewillupdateto);
        sb.append(", ").append(taskstate);
        sb.append(", ").append(count);

        sb.append(")");
        return sb.toString();
    }
}