package cn.enderqiu.bcinvestrebuild.app.LoanManagement;

/**
 * Created by EvanChoo on 7/11/18.
 */

import cn.enderqiu.bcinvestrebuild.app.GuarantyManagement.entity.vo.ReturnVO;
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
@RequestMapping("/api/user/loanManagement")
@Api("贷款管理")
@RequiredPermissions("company")
public class LoanController extends BaseController {
    @Autowired
    private LoanService loanService;

    @RequestMapping(value="/loanRequestedButNotPassed", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                paramType = "query",
                name = "pageIndex",
                required = true,
                value = "页面的页数，一页有20行；如果查找失败会返回null",
                dataType = "int"
            )
    })
    List<LoanVO> getLoanRequestedButNotPassed(int pageIndex) {
        return loanService.getLoanRequestedButNotPassed(getCompanyUserDTO().getToken(), pageIndex);
    }

    @RequestMapping(value = "/getMaxPage", method = RequestMethod.GET)
    MaxPageVO getMaxPage() {
        return loanService.getMaxPage(getCompanyUserDTO().getToken());
    }

    @RequestMapping(value="/mortgageDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "guarantyId",
                    required = true,
                    value = "抵押物的id，如果查找失败会返回null",
                    dataType = "int"
            )
    })
    LoanDetailVO getMortgageDetail(int guarantyId) {
        return loanService.getMortgageDetail(guarantyId);
    }

    @RequestMapping(value="/cancleLoanRequest", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(
                paramType = "query",
                    name = "guarantyId",
                    required = true,
                    value = "抵押物的id，返回的是BaseResponseVO，成功的消息是OK，失败的消息是Error",
                    dataType = "int"
            )
    })
    BaseResponseVO cancleLoanRequest(int guarantyId) {
        return loanService.cancleLoanRequest(getCompanyUserDTO().getToken(), guarantyId);
    }
    @RequestMapping(value = "/applyMortgage", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "guarantyId", value = "抵押物唯一标识符",
                    required = true,  dataType = "int"),
    })
    ReturnVO mortgage(int guarantyId) {
        return loanService.applyMortgage(guarantyId);
    }
}
