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
public class Message implements Serializable {

    private static final long serialVersionUID = 1918101541;

    private Integer id;
    private String  content;
    private String  fromusernum;
    private String  tousernum;
    private Byte    status;

    public Message() {}

    public Message(Message value) {
        this.id = value.id;
        this.content = value.content;
        this.fromusernum = value.fromusernum;
        this.tousernum = value.tousernum;
        this.status = value.status;
    }

    public Message(
        Integer id,
        String  content,
        String  fromusernum,
        String  tousernum,
        Byte    status
    ) {
        this.id = id;
        this.content = content;
        this.fromusernum = fromusernum;
        this.tousernum = tousernum;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromusernum() {
        return this.fromusernum;
    }

    public void setFromusernum(String fromusernum) {
        this.fromusernum = fromusernum;
    }

    public String getTousernum() {
        return this.tousernum;
    }

    public void setTousernum(String tousernum) {
        this.tousernum = tousernum;
    }

    public Byte getStatus() {
        return this.status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Message (");

        sb.append(id);
        sb.append(", ").append(content);
        sb.append(", ").append(fromusernum);
        sb.append(", ").append(tousernum);
        sb.append(", ").append(status);

        sb.append(")");
        return sb.toString();
    }
}