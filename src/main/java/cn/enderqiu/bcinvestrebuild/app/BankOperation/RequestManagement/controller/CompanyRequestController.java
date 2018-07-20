package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.controller;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service.CompanyRequestService;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service.GuarantyManagementService;
import cn.enderqiu.bcinvestrebuild.controller.BaseController;
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
@RequestMapping("/api/user/bank/companyRequest")
@Api("银行处理公司请求")
@RequiredPermissions("bank")

public class CompanyRequestController extends BaseController{
    @Autowired
    private CompanyRequestService service;
    @RequestMapping(value = "/guaranties", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "请求页面数",
                    required = true,  dataType = "int"),
    })
    List<GuarantyVO> getGuaranties(int page,int[] states) {
        return service.findGuarantiesByStates(states,page);

        }

    @RequestMapping(value = "/maxPage", method = RequestMethod.GET)
    @ApiImplicitParams({
    })
    MaxPageVO getMaxPage(int[] states) {
        return service.findMaxPage(states); }

    @RequestMapping(value = "/repay", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    ReturnVO repay(int guarantyId) {
        return service.repay(guarantyId);
    }
    @RequestMapping(value = "/mortgage", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    ReturnVO mortgage(int guarantyId) {
        return service.mortgage(guarantyId);
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
