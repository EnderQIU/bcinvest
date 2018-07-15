package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.controller;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.CompanyVO;
import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service.AuthorityRequestService;
import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service.CompanyRequestService;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserVO;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/bank/authorityRequest")
@Api("银行处理机构请求")
@RequiredPermissions("bank")

public class AuthorityRequestController extends BaseController{
    @Autowired
    private AuthorityRequestService service;
    @RequestMapping(value = "/guaranties", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "请求页面数",
                    required = true,  dataType = "int"),
    })
    List<CompanyVO> getCompanies(int page, int[] states) {
        List<CompanyVO> all = new ArrayList<>();
        for(int state:states){
            List<CompanyVO> companies = service.findCompaniesByState(state,page);
            all.addAll(companies);
        }
        return all; }
    @RequestMapping(value = "/maxPage", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
    })
    MaxPageVO getMaxPage(int[] states) {
        return service.findMaxPage(states); }

    @RequestMapping(value = "/repay", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    int repay(int guarantyId) {
        return service.repay(guarantyId);
    }
    @RequestMapping(value = "/mortgage", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "duration", value = "过期期限（单位：天）",
                    required = true,  dataType = "int"),
    })
    int mortgage(int guarantyId,int duration) {
        return service.mortgage(guarantyId,duration);
    }

    @RequestMapping(value = "/houseDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    HouseVO getHouseDetail(int guarantyId) {
        return service.findHouse(guarantyId);
    }

    @RequestMapping(value = "/landDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    LandVO getLandDetail(int guarantyId) {
        return service.findLand(guarantyId);
    }

    @RequestMapping(value = "/machineDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    MachineVO getMachineDetail(int guarantyId) {
        return service.findMachine(guarantyId);
    }

}
