package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GuarantyVO {
    @ApiModelProperty(value = "抵押物唯一标识符" ,required = true)
    private int guarantyId;
    @ApiModelProperty(value = "对应用户的唯一标识符",required = true)
    private String accountNum;
    @ApiModelProperty(value = "名称",required = true)
    private String name;
    @ApiModelProperty(value = "评估价值",required = true)
    private int evaluateValue;
    @ApiModelProperty(value = "状态",required = true)
    private int state;
    @ApiModelProperty(value = "权利范围",required = true)
    private int scopeOfRight;
    @ApiModelProperty(value = "拥有者名称",required = true)
    private String ownerName;
    @ApiModelProperty(value = "鉴定报告的唯一标识符",required = true)
    private int reportId;
    @ApiModelProperty(value = "类型",required = true)
    private int type;

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public int getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(int guarantyId) {
        this.guarantyId = guarantyId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getType() { return type; }

    public int getScopeOfRight() {
        return scopeOfRight;
    }

    public int getState() {
        return state;
    }

    public int getEvaluateValue() { return evaluateValue; }

    public void setState(int state) {
        this.state = state;
    }

    public void setType(int type) { this.type = type; }

    public void setEvaluateValue(int evaluateValue) { this.evaluateValue = evaluateValue; }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setScopeOfRight(int scopeOfRight) {
        this.scopeOfRight = scopeOfRight;
    }
}
