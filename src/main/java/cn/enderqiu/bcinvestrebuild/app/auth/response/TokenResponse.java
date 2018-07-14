package cn.enderqiu.bcinvestrebuild.app.auth.response;

import cn.enderqiu.bcinvestrebuild.framework.Response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TokenResponse extends Response {

    @ApiModelProperty("口令")
    private String token;

    @ApiModelProperty("用户类型")
    private String userType;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
