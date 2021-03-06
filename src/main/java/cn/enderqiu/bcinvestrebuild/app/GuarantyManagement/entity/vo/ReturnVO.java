package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReturnVO {
    @ApiModelProperty(value = "操作的数据量（行）" ,required = true)
    private int influence = 0;
    @ApiModelProperty(value = "返回的消息" ,required = true)
    private String message;
    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
