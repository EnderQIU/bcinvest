package cn.enderqiu.bcinvestrebuild.app.message.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MessageResponse {

    @ApiModelProperty("消息Id")
    private Integer messageid;

    @ApiModelProperty("来源用户名")
    private String fromUserName;

    @ApiModelProperty("接受用户Id")
    private String toUserNum;

    @ApiModelProperty("消息内容")
    private String content;

    @ApiModelProperty("消息状态")
    private String status;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToUserNum() {
        return toUserNum;
    }

    public void setToUserNum(String toUserNum) {
        this.toUserNum = toUserNum;
    }
}
