package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

@ApiModel
public class CompanyVO {
    @ApiModelProperty(value = "用户唯一标识符" ,required = true)
    private int accountNum;
    @ApiModelProperty(value = "公司名称" ,required = true)
    private int name;
    @ApiModelProperty(value = "电话号码" ,required = true)
    private Date telNum;
    @ApiModelProperty(value = "电子邮箱" ,required = true)
    private int emailAddress;
    @ApiModelProperty(value = "user_id_token" ,required = true)
    private Date token;
    @ApiModelProperty(value = "信用" ,required = true)
    private long credit;
    @ApiModelProperty(value = "状态" ,required = true)
    private String state;

    public void setName(int name) {
        this.name = name;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setTelNum(Date telNum) {
        this.telNum = telNum;
    }

    public void setEmailAddress(int emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public void setToken(Date token) {
        this.token = token;
    }

    public Date getTelNum() {
        return telNum;
    }

    public Date getToken() {
        return token;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getEmailAddress() {
        return emailAddress;
    }

    public int getName() {
        return name;
    }

    public long getCredit() {
        return credit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
