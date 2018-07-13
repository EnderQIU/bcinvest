package cn.enderqiu.bcinvestrebuild.app.LoanManagement;

/**
 * Created by EvanChoo on 7/11/18.
 */

import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
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
@RequestMapping("user/loanManagement")
@Api("贷款管理")
@RequiredPermissions("company")
public class LoanController extends BaseController
{
    @Autowired
    private LoanService loanService;

    @RequestMapping(value="/loanRequestedButNotPassed", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                paramType = "query",
                name = "user_id_token",
                required = true,
                value = "用户的标识符",
                dataType = "String"
            ),
            @ApiImplicitParam(
                paramType = "query",
                name = "pageIndex",
                required = true,
                value = "页面的页数，一页有20行；如果查找失败会返回null",
                dataType = "int"
            )
    })
    List<LoanVO> getLoanRequestedButNotPassed(String user_id_token, int pageIndex) {
        return loanService.getLoanRequestedButNotPassed(user_id_token, pageIndex);
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
                    paramType = "form",
                    name = "user_id_token",
                    required = true,
                    value = "用户的标识符",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                paramType = "form",
                    name = "guarantyId",
                    required = true,
                    value = "抵押物的id，如果执行失败会返回false",
                    dataType = "int"
            )
    })
    BaseResponseVO cancleLoanRequest(String user_id_token, int guarantyId) {
        return loanService.cancleLoanRequest(user_id_token, guarantyId);
    }
}
