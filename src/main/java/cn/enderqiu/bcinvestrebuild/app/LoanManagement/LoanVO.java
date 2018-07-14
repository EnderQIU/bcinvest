package cn.enderqiu.bcinvestrebuild.app.LoanManagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by EvanChoo on 7/11/18.
 */
@ApiModel
public class LoanVO {
    /*
     * GuarantyId-抵押物ID
     * ScopeOfRight-权利范围
     * OwnerName-所有人姓名
     * EvaluateValue-抵押物估值／抵押值
     * Name-抵押物名称
     */
    @ApiModelProperty(value = "抵押物ID", required = true)
    private int guarantyId = -1;
    @ApiModelProperty(value = "抵押物权力范围", required = true)
    private String scopeOfRight = "null";
    @ApiModelProperty(value = "抵押物所有者姓名", required = true)
    private String ownerName = "null";
    @ApiModelProperty(value = "抵押物估值", required = true)
    private int evaluateValue = -1;
    @ApiModelProperty(value = "抵押物名称", required = true)
    private String name = "null";

    //getters
    public int getGuarantyId()
    {
        return this.guarantyId;
    }

    public String getScopeOfRight()
    {
        return this.scopeOfRight;
    }

    public String getOwnerName()
    {
        return this.ownerName;
    }

    public int getEvaluateValue()
    {
        return this.evaluateValue;
    }

    public String getName()
    {
        return this.name;
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
