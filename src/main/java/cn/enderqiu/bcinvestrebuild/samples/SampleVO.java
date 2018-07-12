package cn.enderqiu.bcinvestrebuild.samples;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//自己写的应该放到app包自己所属的包中
/* 每个人在app包建一个新的属于自己的包
 * 自己负责的包括Controller, Service, VO都放在这个自己的地方中
 * 分离开发，不需要依赖别人的部分
 */
@ApiModel
public class SampleVO {
    @ApiModelProperty("例子用的String类数据")
    private String sampleString;
    @ApiModelProperty("例子用的int类型数据")
    private int sampleInt;

    //记得写上getter和setter
    public String getSampleString() {
        return sampleString;
    }

    public void setSampleString(String sampleString) {
        this.sampleString = sampleString;
    }

    public int getSampleInt() {
        return sampleInt;
    }

    public void setSampleInt(int sampleInt) {
        this.sampleInt = sampleInt;
    }
}
