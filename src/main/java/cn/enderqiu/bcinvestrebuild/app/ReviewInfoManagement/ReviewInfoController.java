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
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",
                    /* 来源分为form, header, query
                      * 分别对应 表单，请求头， 请求体
                      */
                    name = "pages", //和参数列表的参数名对应
                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
                    value = "页面",
                    dataType = "int"
            )
    })


    List<ReviewCompanyInfoVO> getCompanyInfo(int pages)
    {
        return ReviewInfoService.getCompanyStateUnapplied2pages(pages);
    }
    @RequestMapping(value = "/getComoanyInfo/maxpage", method = RequestMethod.GET)

    MaxPageVO getCOmpanyInfoMaxpage()
    {
        int size=ReviewInfoService.getCompanyStateUnapplied().size();
        return new MaxPageVO(size/21+1);
    }


    @RequestMapping(value = "/getChainInfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",
                    /* 来源分为form, header, query
                      * 分别对应 表单，请求头， 请求体
                      */
                    name = "pages", //和参数列表的参数名对应
                    required = true, //如果不可或缺填写true，否则可以不写这一栏或者写false
                    value = "页面",
                    dataType = "int"
            )
    })
    List<ReviewChainInfoVO> getGuarantyTBCInfo(int pages)
    {
        return ReviewInfoService.getGuarantyTBCInfo2pages(getBankUserDTO().getToken(),pages);
    }

    @RequestMapping(value = "/getChainInfo/maxpages", method = RequestMethod.GET)
    MaxPageVO getGuarantyTBCInfoMaxpages()
    {
        int size=ReviewInfoService.getGuarantyTBCInfo(getBankUserDTO().getToken()).size();
        return new MaxPageVO(size/21+1);
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



}
