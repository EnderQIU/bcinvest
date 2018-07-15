package cn.enderqiu.bcinvestrebuild.app.message.response;

import io.swagger.annotations.ApiModel;

@ApiModel
public class MessageResponse {
    private String message;

    private Integer messageid;

    private String fromUserNum;

    private String tousernum;

    private String content;

    private Byte status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getFromUserNum() {
        return fromUserNum;
    }

    public void setFromUserNum(String fromUserNum) {
        this.fromUserNum = fromUserNum;
    }

    public String getTousernum() {
        return tousernum;
    }

    public void setTousernum(String tousernum) {
        this.tousernum = tousernum;
    }
}
