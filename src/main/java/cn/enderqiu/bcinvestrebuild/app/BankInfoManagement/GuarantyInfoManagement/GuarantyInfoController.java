package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement;

import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.GuarantyInfoManagement.VO.GuarantyInfoVO;
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

/**
 * Created by EvanChoo on 7/15/18.
 */

@RestController
@RequestMapping("bank/infoManagement")
@Api("银行业务－信息管理")
@RequiredPermissions("bank")
public class GuarantyInfoController extends BaseController {
    @Autowired
    private GuarantyInfoService infoService;

    @RequestMapping(value = "/getAllGuarantyInfo", method = RequestMethod.GET)
    List<GuarantyInfoVO> getAllGuarantyInfo() {
        return infoService.getAllGuarantyInfo();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyType",
                    required = false,
                    value = "抵押物类型, 如果没有就发送-1给后台",
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
    List<GuarantyInfoVO> getSearchResult(int guarantyType, String guarantyName, int guarantyState) {
        return infoService.getSearchResult(guarantyType, guarantyName, guarantyState);
    }
}
