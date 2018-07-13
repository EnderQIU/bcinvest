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
    private int GuarantyId = -1;
    @ApiModelProperty(value = "抵押物权力范围", required = true)
    private String ScopeOfRight = "null";
    @ApiModelProperty(value = "抵押物所有者姓名", required = true)
    private String OwnerName = "null";
    @ApiModelProperty(value = "抵押物估值", required = true)
    private int EvaluateValue = -1;
    @ApiModelProperty(value = "抵押物名称", required = true)
    private String Name = "null";

    //getters
    public int getGuarantyId()
    {
        return GuarantyId;
    }

    public String getScopeOfRight()
    {
        return ScopeOfRight;
    }

    public String getOwnerName()
    {
        return OwnerName;
    }

    public int getEvaluateValue()
    {
        return EvaluateValue;
    }

    public String getName()
    {
        return Name;
    }

    //setters

    public void setGuarantyId(int guarantyId)
    {
        GuarantyId = guarantyId;
    }

    public void setScopeOfRight(int scopeOfRight)
    {
        switch (scopeOfRight)
        {
            case 0:
                this.ScopeOfRight = "部分";
                break;

            case 1:
                this.ScopeOfRight = "整体";
                break;
        }
    }

    public void setOwnerName(String ownerName)
    {
        OwnerName = ownerName;
    }

    public void setEvaluateValue(int evaluateValue)
    {
        EvaluateValue = evaluateValue;
    }

    public void setName(String name)
    {
        Name = name;
    }
}
