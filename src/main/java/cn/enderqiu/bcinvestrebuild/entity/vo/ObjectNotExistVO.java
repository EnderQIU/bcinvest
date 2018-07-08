package cn.enderqiu.bcinvestrebuild.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ObjectNotExistVO extends BaseResponseVO{
    @ApiModelProperty("信息")
    private String message = "request object not found";

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
