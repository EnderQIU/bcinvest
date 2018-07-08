package cn.enderqiu.bcinvestrebuild.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BaseResponseVO {
    @ApiModelProperty("信息")
    private String message = "ok";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
