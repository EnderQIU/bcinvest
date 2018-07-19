package cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.controller;

import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.entity.vo.CompanyVO;
import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service.AuthorityRequestService;
import cn.enderqiu.bcinvestrebuild.app.BankOperation.RequestManagement.service.CompanyRequestService;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.*;
import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.service.GuarantyManagementService;
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
@RequestMapping("/api/user/bank/authorityRequest")
@Api("银行处理机构请求")
@RequiredPermissions("bank")

public class AuthorityRequestController extends BaseController{
    @Autowired
    private AuthorityRequestService service;
    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "请求页面数",
                    required = true,  dataType = "int"),
    })
    List<CompanyVO> getCompanies(int page, String[] states) {
        List<CompanyVO> all = new ArrayList<>();
        for(String state:states){
            List<CompanyVO> companies = service.findCompaniesByState(state,page);
            all.addAll(companies);
        }
        return all; }
    @RequestMapping(value = "/companyMaxPage", method = RequestMethod.GET)
    @ApiImplicitParams({
    })
    MaxPageVO getCompanyMaxPage(String[] states) {
        return service.findCompanyMaxPage(states); }
    @RequestMapping(value = "/guaranties", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "请求页面数",
                    required = true,  dataType = "int"),
    })
    List<GuarantyVO> getGuaranties(int page,int[] states) {
        List<GuarantyVO> all = new ArrayList<>();
        for(int state:states){
            List<GuarantyVO> guaranties = service.findGuarantiesByState(state,page);
            all.addAll(guaranties);
        }
        return all; }
    @RequestMapping(value = "/guarantyMaxPage", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "user_id_token", value = "用户唯一标识符",
                    required = true,  dataType = "String"),
    })
    MaxPageVO getGuarantyMaxPage(int[] states) {
        return service.findGuarantyMaxPage(states); }

    @RequestMapping(value = "/approve", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "accountNum", value = "企业唯一标识符",
                    required = true,  dataType = "int"),
    })
    ReturnVO approveApplication(String accountNum) {
        return service.changeCompanyState(accountNum,"passed");
    }
    @RequestMapping(value = "/reject", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "accountNum", value = "企业唯一标识符",
                    required = true,  dataType = "int"),
    })
    ReturnVO rejectApplication(String accountNum) {
        return service.changeCompanyState(accountNum,"unpassed");
    }

    @RequestMapping(value = "/companyDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "accountNum", value = "企业唯一标识符",
                    required = true,  dataType = "int"),
    })
    CompanyVO getCompanyDetail(String accountNum) {
        return service.findCompany(accountNum);
    }

    @RequestMapping(value = "/toTBCList", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    ReturnVO toTBCList(int guarantyId) {
        return service.changeGuarantyState(guarantyId,3);
    }

}
