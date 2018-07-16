package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO;

import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by EvanChoo on 7/14/18.
 */

@ApiModel
public class CompanyCreditInfoVO {
    @ApiModelProperty(value = "抵押物id", required = true)
    private int guarantyId;
    @ApiModelProperty(value = "抵押物名称", required = true)
    private String guarantyName;
    @ApiModelProperty(value = "抵押物所有者", required = true)
    private String ownerName;
    @ApiModelProperty(value = "失约或者守约", required = true)
    private String type;

    //getters

    public int getGuarantyId() {
        return guarantyId;
    }

    public String getGuarantyName() {
        return guarantyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return type;
    }

    //setters

    public void setGuarantyId(int guarantyId) {
        this.guarantyId = guarantyId;
    }

    public void setGuarantyName(String guarantyName) {
        this.guarantyName = guarantyName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setType(boolean type) {
        if(type)
            this.type = "守约";
        else
            this.type = "失约";
    }
}
