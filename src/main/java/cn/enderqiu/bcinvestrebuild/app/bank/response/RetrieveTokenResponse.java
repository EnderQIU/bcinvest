package cn.enderqiu.bcinvestrebuild.app.bank.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RetrieveTokenResponse {

    @ApiModelProperty("消息")
    private String message;

    @ApiModelProperty("口令")
    private String token;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
