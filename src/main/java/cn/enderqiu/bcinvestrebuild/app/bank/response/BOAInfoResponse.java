package cn.enderqiu.bcinvestrebuild.app.bank.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("机构信息")
public class BOAInfoResponse {
    @ApiModelProperty("机构名称")
    private String name;

    @ApiModelProperty("机构类型")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
