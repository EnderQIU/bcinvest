package cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.controller;

import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.HouseVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.LandVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.MachineVO;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service.GuarantyManagementService;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.GuarantyVO;
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
@RequestMapping("/user/guaranty")
@Api("抵押物相关操作")
@RequiredPermissions("company,bank,authority")

public class GuarantyController extends BaseController{
    @Autowired
    private GuarantyManagementService service;

    @RequestMapping(value = "/TBCGuaranty", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页面数",
                    required = true,  dataType = "int"),
    })
    List<GuarantyVO> getTBCGuaranty(String user_id_token,int page) { return service.findGuarantiesByState(user_id_token,2,page); }
    @RequestMapping(value = "/unqualifiedGuaranty", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页面数",
                    required = true,  dataType = "int"),
    })
    List<GuarantyVO> getUnqualifiedGuaranty(String user_id_token,int page) { return service.findGuarantiesByState(user_id_token,1,page); }

    @RequestMapping(value = "/toBC", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    int putGuarantyToBC(int guarantyId) {
        return service.putGuarantyToBC(guarantyId);
    }

    @RequestMapping(value = "/downBC", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    int downBC(int guarantyId) {
        return service.deleteGuaranty(guarantyId);
    }

    @RequestMapping(value = "/abandon", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    int abandonGuaranty(int guarantyId) {
        return service.deleteGuaranty(guarantyId);
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

    @RequestMapping(value = "/reappraise", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    int reappraiseGuaranty(int guarantyId) {
        return service.deleteGuaranty(guarantyId);
    }

    @RequestMapping(value = "/evaluationState", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页面数",
                    required = true,  dataType = "int"),
    })
    List<GuarantyVO> getEvaluationState(String user_id_token,int page) {
        List<GuarantyVO> evaluatingGuaranty = service.findGuarantiesByState(user_id_token,0,page);
        List<GuarantyVO> unqualifiedGuaranty = service.findGuarantiesByState(user_id_token,1,page);
        List<GuarantyVO> TBCGuaranty = service.findGuarantiesByState(user_id_token,2,page);
        List<GuarantyVO> all = new ArrayList<>();
        all.addAll(evaluatingGuaranty);
        all.addAll(unqualifiedGuaranty);
        all.addAll(TBCGuaranty);
        return all;
    }

    @RequestMapping(value = "/applyHouseEvaluation", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "addr", value = "地址",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "housingCertificatedId", value = "房产证编号",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "zip", value = "邮编",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "name", value = "名称",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "evaluateValue", value = "评估价值",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "scopeOfRight", value = "权利范围",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "ownerName", value = "所有者名称",
                    required = true,  dataType = "String"),
    })
    int applyEvaluationForHouse(String user_id_token,String addr,String housingCertificatedId,String zip,String name,int evaluateValue,int scopeOfRight,String ownerName) {
        HouseVO houseVO = new HouseVO();
        houseVO.setAddr(addr);
        houseVO.setHousingCertificatedId(housingCertificatedId);
        houseVO.setZip(zip);
        houseVO.setName(name);
        houseVO.setEvaluateValue(evaluateValue);
        houseVO.setOwnerName(ownerName);
        houseVO.setScopeOfRight(scopeOfRight);
        service.createHouse(getCompanyUserDTO().getToken(),houseVO);
        return 0;
    }
    @RequestMapping(value = "/applyMachineEvaluation", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "usedDays", value = "使用天数",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "model", value = "型号",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "producer", value = "生产商",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "name", value = "名称",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "evaluateValue", value = "评估价值",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "scopeOfRight", value = "权利范围",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "ownerName", value = "所有者名称",
                    required = true,  dataType = "String"),
    })
    int applyEvaluationForMachine(String user_id_token,int usedDays,String model,String producer,String name,int evaluateValue,int scopeOfRight,String ownerName) {
        MachineVO machineVO = new MachineVO();
        machineVO.setUsedDays(usedDays);
        machineVO.setModel(model);
        machineVO.setProducer(producer);
        machineVO.setName(name);
        machineVO.setEvaluateValue(evaluateValue);
        machineVO.setOwnerName(ownerName);
        machineVO.setScopeOfRight(scopeOfRight);
        service.createMachine(user_id_token,machineVO);
        return 0;
    }
    @RequestMapping(value = "/applyLandEvaluation", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "addr", value = "地址",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "area", value = "面积",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "name", value = "名称",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "evaluateValue", value = "评估价值",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "scopeOfRight", value = "权利范围",
                    required = true,  dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "ownerName", value = "所有者名称",
                    required = true,  dataType = "String"),
    })
    int applyEvaluationForLand(String user_id_token,int area,String addr,String name,int evaluateValue,int scopeOfRight,String ownerName) {
        LandVO landVO = new LandVO();
        landVO.setAddr(addr);
        landVO.setArea(area);
        landVO.setName(name);
        landVO.setEvaluateValue(evaluateValue);
        landVO.setOwnerName(ownerName);
        landVO.setScopeOfRight(scopeOfRight);
        service.createLand(user_id_token,landVO);
        return 0;
    }
}
