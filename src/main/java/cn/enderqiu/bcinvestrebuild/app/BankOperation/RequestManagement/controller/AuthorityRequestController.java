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
@RequestMapping("/user/bank/authorityRequest")
@Api("银行处理机构请求")
@RequiredPermissions("bank")

public class AuthorityRequestController extends BaseController{
    @Autowired
    private AuthorityRequestService service;
    private GuarantyManagementService guarantyManagementService;
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
    @RequestMapping(value = "/maxPage", method = RequestMethod.GET)
    @ApiImplicitParams({
    })
    MaxPageVO getMaxPage(String[] states) {
        return service.findMaxPage(states); }

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
            @ApiImplicitParam(paramType = "query", name = "accounNum", value = "企业唯一标识符",
                    required = true,  dataType = "int"),
    })
    CompanyVO getCompanyDetail(String accounNum) {
        return service.findCompany(accounNum);
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
