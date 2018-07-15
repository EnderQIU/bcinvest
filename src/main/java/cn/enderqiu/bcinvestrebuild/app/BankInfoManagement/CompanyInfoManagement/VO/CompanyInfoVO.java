package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO;

import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by EvanChoo on 7/14/18.
 */

@ApiModel
public class CompanyInfoVO extends BaseResponseVO {
    @ApiModelProperty(value = "公司账号", required = true)
    private String accountNum;
    @ApiModelProperty(value = "公司名称", required = true)
    private String name;
    @ApiModelProperty(value = "电话号码", required = true)
    private String telNum;
    @ApiModelProperty(value = "电子邮件", required = true)
    private String emailAddress;

    //setter
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    //getters

    public String getAccountNum() {
        return accountNum;
    }

    public String getName() {
        return name;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
