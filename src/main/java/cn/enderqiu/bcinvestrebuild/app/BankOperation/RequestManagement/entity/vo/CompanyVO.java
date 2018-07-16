package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

@ApiModel
public class CompanyVO {
    @ApiModelProperty(value = "用户唯一标识符" ,required = true)
    private String accountNum;
    @ApiModelProperty(value = "公司名称" ,required = true)
    private String name;
    @ApiModelProperty(value = "电话号码" ,required = true)
    private String telNum;
    @ApiModelProperty(value = "电子邮箱" ,required = true)
    private String emailAddress;
    @ApiModelProperty(value = "user_id_token" ,required = true)
    private String token;
    @ApiModelProperty(value = "信用" ,required = true)
    private long credit;
    @ApiModelProperty(value = "状态" ,required = true)
    private String state;

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getToken() {
        return token;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
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
