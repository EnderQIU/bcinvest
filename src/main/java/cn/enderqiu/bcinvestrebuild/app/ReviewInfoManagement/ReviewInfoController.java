package cn.enderqiu.bcinvestrebuild.app.ReviewInfoManagement;

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
@RequestMapping("/api/Authorization/reviewInfo")
@Api("权威机构查看企业信息和信用 ")
@RequiredPermissions("authority")

public class ReviewInfoController extends BaseController {
    @Autowired
    private ReviewInfoService ReviewInfoService;

    @RequestMapping(value = "/getComoanyInfo", method = RequestMethod.GET)

    List<ReviewCompanyInfoVO> getCompanyInfo()
    {
        return ReviewInfoService.getCompanyStateUnapplied();
    }
    @RequestMapping(value = "/getChainInfo", method = RequestMethod.GET)
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query",
//                    /* 来源分为form, header, query
//                      * 分别对应 表单，请求头， 请求体
//                      */
//                    name = "company_id", //和参数列表的参数名对应
//                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
//                    value = "公司唯一标识符",
//                    dataType = "String"
//            )
//    })
    List<ReviewChainInfoVO> getGuarantyTBCInfo()
    {
        return ReviewInfoService.getGuarantyTBCInfo(getBankUserDTO().getToken());
    }


    @RequestMapping(value = "/updateGuarantyValue", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",
                    /* 来源分为form, header, query
                      * 分别对应 表单，请求头， 请求体
                      */
                    name = "guaranty_id", //和参数列表的参数名对应
                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
                    value = "抵押物唯一标识符",
                    dataType = "String"
            ),
            @ApiImplicitParam(paramType = "query",
                    /* 来源分为form, header, query
                      * 分别对应 表单，请求头， 请求体
                      */
                    name = "value", //和参数列表的参数名对应
                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
                    value = "修改的估值",
                    dataType = "String"
            )
    })
    UpdateGuarantyValueVO updateValue(String guaranty_id,String value)
    {
        return ReviewInfoService.updateGuarantyValueVO(guaranty_id,value);
    }


    @RequestMapping(value = "/getComoanyInfo/Maxpage", method = RequestMethod.GET)
    @ApiImplicitParam(paramType = "query",
            /* 来源分为form, header, query
              * 分别对应 表单，请求头， 请求体
              */
            name = "pages", //和参数列表的参数名对应
            required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
            value = "页面",
            dataType = "String"
    )
    List<ReviewCompanyInfoVO> getCompanyInfoMaxPage(int pages)
    {
        return ReviewInfoService.getCompanyStateUnapplied2pages(pages);
    }
}
