package cn.enderqiu.bcinvestrebuild.entity.vo;

import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BaseResponseVO {
    @ApiModelProperty("信息")
    private String message = "ok";

    public BaseResponseVO(String message){
        setMessage(message);
    }

    public BaseResponseVO() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
