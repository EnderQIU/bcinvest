package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LandVO extends GuarantyVO{
    @ApiModelProperty(value = "地址" ,required = true)
    private String addr;
    @ApiModelProperty(value = "面积" ,required = true)
    private long area;

    public void setArea(long area) {
        this.area = area;
    }

    public long getArea() {
        return area;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
