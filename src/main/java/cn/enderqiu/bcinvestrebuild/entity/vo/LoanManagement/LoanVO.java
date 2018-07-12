package cn.enderqiu.bcinvestrebuild.entity.vo.LoanManagement;

/**
 * Created by EvanChoo on 7/11/18.
 */

public class LoanVO {
    /*
     * GuarantyId-抵押物ID
     * ScopeOfRight-权利范围
     * OwnerName-所有人姓名
     * EvaluateValue-抵押物估值／抵押值
     * Name-抵押物名称
     */
    private int GuarantyId = -1;
    private String ScopeOfRight = "null";
    private String OwnerName = "null";
    private int EvaluateValue = -1;
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
                this.ScopeOfRight = "Part";
                break;

            case 1:
                this.ScopeOfRight = "Whole";
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
