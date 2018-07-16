package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by EvanChoo on 7/13/18.
 */

@ApiModel
public class GuarantyInfoVO {
    @ApiModelProperty(value = "抵押物ID", required = true)
    private int guarantyId;
    @ApiModelProperty(value = "抵押物权力范围", required = true)
    private String scopeOfRight;
    @ApiModelProperty(value = "抵押物所有者姓名", required = true)
    private String ownerName;
    @ApiModelProperty(value = "抵押物估值", required = true)
    private int evaluateValue;
    @ApiModelProperty(value = "抵押物名称", required = true)
    private String name;
    /*
        鉴定中：evaluating（0）
        不合格：unqualified（1）
        合格：qualified（2）
        待确认（待确认上链）：TBC（3）
        可抵押（已上链）：onBC（4）
        申请抵押中（审核中）：applying（5）
        申请已通过（抵押中）：mortgaging（6）
        申请还款中：repaying（7）
        逾期：overdue（8）
     */
    @ApiModelProperty(value = "抵押物状态", required = true)
    private String state;

    //getters
    public int getGuarantyId()
    {
        return guarantyId;
    }

    public String getScopeOfRight()
    {
        return scopeOfRight;
    }

    public String getOwnerName()
    {
        return ownerName;
    }

    public int getEvaluateValue()
    {
        return evaluateValue;
    }

    public String getName()
    {
        return name;
    }

    public String getState() {
        return this.state;
    }

    //setters

    public void setGuarantyId(int guarantyId)
    {
        this.guarantyId = guarantyId;
    }

    public void setScopeOfRight(int scopeOfRight)
    {
        switch (scopeOfRight)
        {
            case 0:
                this.scopeOfRight = "部分";
                break;

            case 1:
                this.scopeOfRight = "整体";
                break;
        }
    }

    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public void setEvaluateValue(int evaluateValue)
    {
        this.evaluateValue = evaluateValue;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setState(int state) {
        switch (state) {
            case 0:
                this.state = "鉴定中";
                break;

            case 1:
                this.state = "不合格";
                break;

            case 2:
                this.state = "合格";
                break;

            case 3:
                this.state = "待确认";
                break;

            case 4:
                this.state = "可抵押";
                break;

            case 5:
                this.state = "申请抵押中";
                break;

            case 6:
                this.state = "申请已通过";
                break;

            case 7:
                this.state = "申请还款中";
                break;

            case 8:
                this.state = "逾期";
                break;
        }
    }
}
