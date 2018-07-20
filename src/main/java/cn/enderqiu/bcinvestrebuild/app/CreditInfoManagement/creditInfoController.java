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
@RequestMapping("/api/credit")
@Api("查看企业用户信用记录 ")
@RequiredPermissions("company，bank,authority")

public class creditInfoController extends BaseController {
    @Autowired
    private cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement.creditInfoService creditInfoService;


//    @RequestMapping(value = "/company/creditList", method = RequestMethod.GET)
//    List<creditInfoVO> creditInfoPost()
//    {
//    return creditInfoService.getCompanyCredit(getCompanyUserDTO().getToken());
//    }



    @RequestMapping(value = "/company/creditList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "page",
                    required = true,
                    value = "第几页，一页包含20条数据",
                    dataType = "int"
            )
    })
    List<creditInfoVO> creditInfoToPages(int page) {
        return creditInfoService.getCompanyCredit2Pages(getCompanyUserDTO().getToken(), page);
    }

    MaxPageVO creditInfoMaxPage()
    {
        int size=creditInfoService.getCompanyCredit(getCompanyUserDTO().getToken()).size();
        return new MaxPageVO(size/21+1);
    }


//    @RequestMapping(value = "/bank/companyCreditList", method = RequestMethod.GET)
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",
//                    /* 来源分为form, header, query
//                     * 分别对应 表单，请求头， 请求体
//                     */
//                    name = "accountNum", //和参数列表的参数名对应
//                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
//                    value = "公司的Id，用于银行查询某个企业的信用记录",
//                    dataType = "String"
//            )
//    })
//
//    List<creditInfoVO>  getCompanyCreditList(String accountNum)
//    {
//        return creditInfoService.getCompanyCreditList(accountNum);
//    }


    @RequestMapping(value = "/bank/companyCreditList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",
                    /* 来源分为form, header, query
                     * 分别对应 表单，请求头， 请求体
                     */
                    name = "accountNum", //和参数列表的参数名对应
                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
                    value = "公司的Id，用于银行查询某个企业的信用记录",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "page",
                    required = true,
                    value = "第几页，一页包含20条数据",
                    dataType = "int"
            )
    })
    List<creditInfoVO> companyCreditInfoToPages(String accountNum,int page) {
        return creditInfoService.getComapanyCreditList2Pages(accountNum, page);
    }

    MaxPageVO companyCreditInfoMaxPages(String accountNum)
    {
        int size=creditInfoService.getCompanyCreditList(accountNum).size();
        return new MaxPageVO(size);
    }



}
