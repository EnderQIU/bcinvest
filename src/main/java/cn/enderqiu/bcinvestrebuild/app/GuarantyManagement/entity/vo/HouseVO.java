package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class HouseVO extends GuarantyVO{
    @ApiModelProperty(value = "地址" ,required = true)
    private String addr;
    @ApiModelProperty(value = "邮编" ,required = true)
    private String zip;
    @ApiModelProperty(value = "房产证编号" ,required = true)
    private String housingCertificatedId;

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHousingCertificatedId() {
        return housingCertificatedId;
    }

    public void setHousingCertificatedId(String housingCertificatedId) {
        this.housingCertificatedId = housingCertificatedId;
    }
}
