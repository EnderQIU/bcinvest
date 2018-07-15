package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO;

import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by EvanChoo on 7/14/18.
 */

@ApiModel
public class CompanyInfoDetailVO extends BaseResponseVO {
    @ApiModelProperty(value = "公司账号", required = true)
    private String companyAccountNum;
    @ApiModelProperty(value = "公司名", required = true)
    private String companyName;
    @ApiModelProperty(value = "公司电话号码", required = true)
    private String companyTelNum;
    @ApiModelProperty(value = "公司电子邮件", required = true)
    private String companyEmailAddress;
    @ApiModelProperty(value = "公司信用值", required = true)
    private String companyCredit;

    //getters
    public String getCompanyAccountNum() {
        return companyAccountNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyTelNum() {
        return companyTelNum;
    }

    public String getCompanyEmailAddress() {
        return companyEmailAddress;
    }

    public String getCompanyCredit() {
        return companyCredit;
    }

    //setters
    public void setCompanyAccountNum(String companyAccountNum) {
        this.companyAccountNum = companyAccountNum;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyTelNum(String companyTelNum) {
        this.companyTelNum = companyTelNum;
    }

    public void setCompanyEmailAddress(String companyEmailAddress) {
        this.companyEmailAddress = companyEmailAddress;
    }

    public void setCompanyCredit(String companyCredit) {
        this.companyCredit = companyCredit;
    }
}
