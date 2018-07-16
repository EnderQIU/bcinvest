package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement.VO;

import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by EvanChoo on 7/15/18.
 */

@ApiModel
public class GuarantyInfoDetailVO extends BaseResponseVO {
    @ApiModelProperty(value = "抵押物ID", required = true)
    private int guarantyId;
    @ApiModelProperty(value = "抵押物状态", required = true)
    private String propertyState;
    @ApiModelProperty(value = "抵押物权力范围", required = true)
    private String scopeOfRight;
    @ApiModelProperty(value = "抵押物所有者姓名", required = true)
    private String ownerName;
    @ApiModelProperty(value = "抵押物估值", required = true)
    private int evaluateValue;
    @ApiModelProperty(value = "抵押物名称", required = true)
    private String name;
    @ApiModelProperty(value = "所属公司名", required = true)
    private String companyName;
    @ApiModelProperty(value = "公司编号", required = true)
    private String companyId;
    @ApiModelProperty(value = "公司电话号码", required = true)
    private String companyTelNum;
    @ApiModelProperty(value = "公司电子邮箱", required = true)
    private String companyEmailAddress;

    //getters
    public int getGuarantyId() {
        return guarantyId;
    }

    public String getPropertyState() {
        return propertyState;
    }

    public String getScopeOfRight() {
        return scopeOfRight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getEvaluateValue() {
        return evaluateValue;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyTelNum() {
        return companyTelNum;
    }

    public String getCompanyEmailAddress() {
        return companyEmailAddress;
    }

    //setters
    public void setGuarantyId(int guarantyId) {
        this.guarantyId = guarantyId;
    }

    public void setPropertyState(int propertyState) {
        switch (propertyState) {
            case 0:
                this.propertyState = "审核中";
                break;

            case 1:
                this.propertyState = "不合格";
                break;

            case 2:
                this.propertyState = "合格";
                break;

            case 3:
                this.propertyState = "待确认";
                break;

            case 4:
                this.propertyState = "可抵押";
                break;

            case 5:
                this.propertyState = "申请贷款中";
                break;

            case 6:
                this.propertyState = "申请已通过";
                break;

            case 8:
                this.propertyState = "逾期";
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

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setEvaluateValue(int evaluateValue) {
        this.evaluateValue = evaluateValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompanyTelNum(String companyTelNum) {
        this.companyTelNum = companyTelNum;
    }

    public void setCompanyEmailAddress(String companyEmailAddress) {
        this.companyEmailAddress = companyEmailAddress;
    }
}
