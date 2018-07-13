package cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement;

import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("user/credit")
@Api("查看企业用户信用记录 ")
@RequiredPermissions("企业，银行")

public class creditInfoController extends BaseController {
    @Autowired
    private cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement.creditInfoService creditInfoService;
    @RequestMapping(value = "/credit", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "<header>",
                    /* 来源分为form, header, query
                     * 分别对应 表单，请求头， 请求体
                     */
                    name = "companyID", //和参数列表的参数名对应
                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
                    value = "企业的ID",
                    dataType = "String"
            )
    })

    List<creditInfoVO> creditInfoPost(String companyID)
    {
    return creditInfoService.getCompanyCredit(companyID);
    }
    @RequestMapping(value = "/dividePages", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "companyID",
                    required = true,
                    value = "企业的ID",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    name = "page",
                    required = true,
                    value = "第几页，一页包含<n>条数据",
                    dataType = "int"
            )
    })
    List<creditInfoVO> creditInfoToPages(String companyID, int page) {
        return creditInfoService.getCompanyCredit2Pages(companyID, page);
    }


}
