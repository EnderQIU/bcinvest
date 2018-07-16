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
    private int guarantyId;
    @ApiModelProperty(value = "公司AccountNum", required = true)
    private String companyAccount;
    @ApiModelProperty(value = "抵押物状态", required = true)
    private String state;
    @ApiModelProperty(value = "权利范围", required = true)
    private String scopeOfRight;
    @ApiModelProperty(value = "所有者名字", required = true)
    private String ownerName;
    @ApiModelProperty(value = "抵押物鉴定书ID", required = true)
    private int reportId;
    @ApiModelProperty(value = "抵押物类型", required = true)
    private String guarantyType;
    @ApiModelProperty(value = "抵押物估值", required = true)
    private int evaluateValue;
    @ApiModelProperty(value = "抵押物名称", required = true)
    private String guarantyName;
    @ApiModelProperty(value = "鉴定机构AccountNum", required = true)
    private String authAccount;
    @ApiModelProperty(value = "审核通过日期", required = true)
    private String date;
    @ApiModelProperty(value = "审核有效期", required = true)
    private String duration;
    @ApiModelProperty(value = "鉴定机构名称", required = true)
    private String authName;

    //getters
    public int getGuarantyId()
    {
        return this.guarantyId;
    }

    public String getCompanyAccount()
    {
        return this.companyAccount;
    }

    public String getState()
    {
        return this.state;
    }

    public String getScopeOfRight()
    {
        return this.scopeOfRight;
    }

    public String getOwnerName()
    {
        return this.ownerName;
    }

    public int getReportId()
    {
        return this.reportId;
    }

    public String getGuarantyType()
    {
        return this.guarantyType;
    }

    public int getEvaluateValue()
    {
        return this.evaluateValue;
    }

    public String getGuarantyName()
    {
        return this.guarantyName;
    }

    public String getAuthAccount()
    {
        return this.authAccount;
    }

    public String getDate()
    {
        return date;
    }

    public String getDuration()
    {
        return this.duration;
    }

    public String getAuthName()
    {
        return this.authName;
    }

    //setters
    public void setGuarantyId(int guarantyId)
    {
        this.guarantyId = guarantyId;
    }

    public void setCompanyAccount(String companyAccount)
    {
        this.companyAccount = companyAccount;
    }

    public void setState(int state)
    {
        switch (state) {
            case 0:
                this.state = "审核中";
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

            case 8:
                this.state = "逾期";
                break;
        }
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

    public void setReportId(int reportId)
    {
        this.reportId = reportId;
    }

    public void setGuarantyType(int guarantyType)
    {
        switch (guarantyType) {
            case 0:
                this.guarantyType = "房产";
                break;

            case 1:
                this.guarantyType = "土地";
                break;

            case 2:
                this.guarantyType = "机器";
                break;
        }
    }

    public void setEvaluateValue(int evaluateValue)
    {
        this.evaluateValue = evaluateValue;
    }

    public void setGuarantyName(String guarantyName)
    {
        this.guarantyName = guarantyName;
    }

    public void setAuthAccount(String authAccount)
    {
        this.authAccount = authAccount;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public void setAuthName(String authName)
    {
        this.authName = authName;
    }
}
