package cn.enderqiu.bcinvestrebuild.app.object.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MessageResponse {

    @ApiModelProperty("信息")
    private String message = "ok";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
