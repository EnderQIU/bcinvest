package cn.enderqiu.bcinvestrebuild.entity.vo;

import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;


public class CompanyUserVO {
    private String accountNum;
    private String name;
    private String telNum;
    private String emailAddress;
    private String status;

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
