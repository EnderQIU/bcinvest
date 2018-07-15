package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.Entity.VO;

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
}
