package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MaxPageVO
{
    @ApiModelProperty(value = "最大页面数" ,required = true)
    private int maxPage;

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
}
