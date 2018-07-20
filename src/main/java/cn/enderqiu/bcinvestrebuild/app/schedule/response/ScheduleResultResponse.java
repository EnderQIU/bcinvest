package cn.enderqiu.bcinvestrebuild.app.schedule.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ScheduleResultResponse {

    @ApiModelProperty("任务执行结果")
    private String result = "complete";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
