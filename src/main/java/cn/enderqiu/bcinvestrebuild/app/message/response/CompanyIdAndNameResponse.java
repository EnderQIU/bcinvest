package cn.enderqiu.bcinvestrebuild.app.message.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CompanyIdAndNameResponse {

    @ApiModelProperty("企业Id")
    private String accountNum;

    @ApiModelProperty("企业名称")
    private String Name;

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
