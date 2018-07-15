package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

@ApiModel
public class ProtocolVO {
    @ApiModelProperty(value = "电子协议唯一标识符" ,required = true)
    private int protocolId;
    @ApiModelProperty(value = "抵押物唯一标识符" ,required = true)
    private int guarantyId;
    @ApiModelProperty(value = "生成电子协议日期(yyyy-mm-dd)" ,required = true)
    private Date startDate;
    @ApiModelProperty(value = "有效时长（单位：天）" ,required = true)
    private int duration;
    @ApiModelProperty(value = "还款日期" ,required = true)
    private Date endDate;
    @ApiModelProperty(value = "消息" ,required = true)
    private String message;
    @ApiModelProperty(value = "状态" ,required = true)
    private String state;

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setGuarantyId(int guarantyId) {
        this.guarantyId = guarantyId;
    }

    public int getGuarantyId() {
        return guarantyId;
    }

    public int getDuration() {
        return duration;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public String getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
    }
}
