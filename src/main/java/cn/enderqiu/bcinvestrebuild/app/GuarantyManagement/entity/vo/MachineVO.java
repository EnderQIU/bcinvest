package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MachineVO extends GuarantyVO{
    @ApiModelProperty(value = "使用天数" ,required = true)
    private int usedDays;
    @ApiModelProperty(value = "生产商" ,required = true)
    private String producer;
    @ApiModelProperty(value = "型号" ,required = true)
    private String model;

    public String getModel() {
        return model;
    }

    public int getUsedDays() {
        return usedDays;
    }

    public String getProducer() {
        return producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setUsedDays(int usedDays) {
        this.usedDays = usedDays;
    }
}
