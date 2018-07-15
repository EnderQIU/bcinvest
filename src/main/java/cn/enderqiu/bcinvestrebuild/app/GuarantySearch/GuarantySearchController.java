package cn.enderqiu.bcinvestrebuild.app.GuarantySearch;

/**
 * Created by EvanChoo on 7/13/18.
 */

import cn.enderqiu.bcinvestrebuild.app.LoanManagement.LoanService;
import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/guarantySearch")
@Api("抵押物查询")
@RequiredPermissions("company")
public class GuarantySearchController extends BaseController {
    @Autowired
    private GuarantySearchService guarantySearchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyType",
                    required = false,
                    value = "抵押物类型, 如果没有就发送-1给后台;",
                    dataType = "int"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyName",
                    required = false,
                    value = "抵押物名称, 如果没有就返回null给后台",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyState",
                    required = false,
                    value = "抵押物状态，如果选择所有状态的抵押物则向后台发送-1",
                    dataType = "int"
            )
    })
    List<GuarantySearchVO> searchGuaranty(int guarantyType, String guarantyName, int guarantyState) {
        return guarantySearchService.searchGuanranty(getCompanyUserDTO().getToken(), guarantyType, guarantyName, guarantyState);
    }

    @RequestMapping(value = "/getMaxPage", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyType",
                    required = false,
                    value = "抵押物类型, 如果没有就发送null给后台;House，Land，Machine; 由于type在数据库中使用的是varchar，所以前台发送的时候一定要首字母大写",
                    dataType = "int"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyName",
                    required = false,
                    value = "抵押物名称, 如果没有就返回null给后台",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyState",
                    required = false,
                    value = "抵押物状态，如果选择所有状态的抵押物则向后台发送-1",
                    dataType = "int"
            )
    })
    MaxPageVO getMaxPage(int guarantyType, String guarantyName, int guarantyState) {
        return guarantySearchService.getMaxPage(getCompanyUserDTO().getToken(), guarantyType, guarantyName, guarantyState);
    }
}
