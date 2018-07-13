package cn.enderqiu.bcinvestrebuild.app.LoanManagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by EvanChoo on 7/13/18.
 */
@ApiModel
public class LoanDetailVO {
    /*
     *GuarantyId, g.AccountNum AS CompanyAccount, State, ScopeOfRight, OwnerName, g.ReportId AS ReportId, g.Type AS GuarantyType, EvaluateValue, g.Name AS GuarantyName, r.AccountNum AS AuthAccount, Date, Duration, a.Name AS AuthName
     */
    @ApiModelProperty(value = "抵押物ID", required = true)
    private int GuarantyId;
    @ApiModelProperty(value = "公司AccountNum", required = true)
    private String CompanyAccount;
    @ApiModelProperty(value = "抵押物状态", required = true)
    private String State;
    @ApiModelProperty(value = "权利范围", required = true)
    private String ScopeOfRight;
    @ApiModelProperty(value = "所有者名字", required = true)
    private String OwnerName;
    @ApiModelProperty(value = "抵押物鉴定书ID", required = true)
    private int ReportId;
    @ApiModelProperty(value = "抵押物类型", required = true)
    private String GuarantyType;
    @ApiModelProperty(value = "抵押物估值", required = true)
    private int EvaluateValue;
    @ApiModelProperty(value = "抵押物名称", required = true)
    private String GuarantyName;
    @ApiModelProperty(value = "鉴定机构AccountNum", required = true)
    private String AuthAccount;
    @ApiModelProperty(value = "审核通过日期", required = true)
    private String Date;
    @ApiModelProperty(value = "审核有效期", required = true)
    private String Duration;
    @ApiModelProperty(value = "鉴定机构名称", required = true)
    private String AuthName;

    //getters
    public int getGuarantyId()
    {
        return GuarantyId;
    }

    public String getCompanyAccount()
    {
        return CompanyAccount;
    }

    public String getState()
    {
        return State;
    }

    public String getScopeOfRight()
    {
        return ScopeOfRight;
    }

    public String getOwnerName()
    {
        return OwnerName;
    }

    public int getReportId()
    {
        return ReportId;
    }

    public String getGuarantyType()
    {
        return GuarantyType;
    }

    public int getEvaluateValue()
    {
        return EvaluateValue;
    }

    public String getGuarantyName()
    {
        return GuarantyName;
    }

    public String getAuthAccount()
    {
        return AuthAccount;
    }

    public String getDate()
    {
        return Date;
    }

    public String getDuration()
    {
        return Duration;
    }

    public String getAuthName()
    {
        return AuthName;
    }

    //setters
    public void setGuarantyId(int guarantyId)
    {
        GuarantyId = guarantyId;
    }

    public void setCompanyAccount(String companyAccount)
    {
        CompanyAccount = companyAccount;
    }

    public void setState(int state)
    {
        switch (state) {
            case 0:
                this.State = "审核中";
                break;

            case 1:
                this.State = "不合格";
                break;

            case 2:
                this.State = "待确认";
                break;

            case 3:
                this.State = "可抵押";
                break;

            case 4:
                this.State = "已抵押未确认";
                break;

            case 5:
                this.State = "已抵押已确认";
                break;

            case 6:
                this.State = "贷款逾期";
                break;
        }
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

    public void setReportId(int reportId)
    {
        ReportId = reportId;
    }

    public void setGuarantyType(int guarantyType)
    {
        switch (guarantyType) {
            case 0:
                this.GuarantyType = "房产";
                break;

            case 1:
                this.GuarantyType = "土地";
                break;

            case 2:
                this.GuarantyType = "机器";
                break;
        }
    }

    public void setEvaluateValue(int evaluateValue)
    {
        EvaluateValue = evaluateValue;
    }

    public void setGuarantyName(String guarantyName)
    {
        GuarantyName = guarantyName;
    }

    public void setAuthAccount(String authAccount)
    {
        AuthAccount = authAccount;
    }

    public void setDate(String date)
    {
        Date = date;
    }

    public void setDuration(String duration)
    {
        Duration = duration;
    }

    public void setAuthName(String authName)
    {
        AuthName = authName;
    }
}
