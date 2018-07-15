package cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement;

import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO.CompanyCreditInfoVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO.CompanyInfoDetailVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO.CompanyInfoVO;
import cn.enderqiu.bcinvestrebuild.app.BankInfoManagement.CompanyInfoManagement.VO.GuarantyInfoVO;
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

/**
 * Created by EvanChoo on 7/14/18.
 */

@RestController
@RequestMapping("/bank/infoManagement")
@Api("银行业务－信息管理")
@RequiredPermissions("bank")
public class CompanyInfoController extends BaseController {
    @Autowired
    private CompanyInfoService infoService;

    @RequestMapping(value = "/allCompanyInfo", method = RequestMethod.GET)
    List<CompanyInfoVO> getAllCompanyInfo() {
        return infoService.getAllCompanyInfo();
    }

    @RequestMapping(value = "/allCompanyInfo/search", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "accountNum",
                    required = false,
                    value = "模糊搜索的AccountNum字段，如果用户没有填，应该发送null，不是\"null\"",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "name",
                    required = false,
                    value = "模糊搜索的Name字段，如果用户没有填写，应该发送null，不是\"null\"",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "telNum",
                    required = false,
                    value = "模糊搜索的TelNul字段，如果用户没有填写应该发送null，不是\"null\"",
                    dataType = "String"
            ),
            @ApiImplicitParam(
                    paramType = "query",
                    name = "email",
                    required = false,
                    value = "模糊搜索的EmailAddress字段，如果用户没有填写应该发送null，不是\"null\"",
                    dataType = "String"
            )
    })
    List<CompanyInfoVO> getSearchCompanyResult(String accountNum, String name, String telNum, String email) {
        return infoService.getSearchCompanyResult(accountNum, name, telNum, email);
    }

    @RequestMapping(value = "/allCompanyInfo/companyDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "accountNum",
                    required = true,
                    value = "每次后台返回的用来填充所有公司列表的信息中包含了公司的AccountNum，需要存下来，在用户点击某一项来查看详细信息时传给后台",
                    dataType = "String"
            )
    })
    CompanyInfoDetailVO getCompanyDetail(String accountNum) {
        return infoService.getCompanyDetail(accountNum);
    }

    @RequestMapping(value = "/allCompanyInfo/creditDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "accountNum",
                    required = true,
                    value = "每次后台返回的用来填充所有公司列表的信息中包含了公司的AccountNum，需要存下来，在用户点击某一项来查看信用信息时传给后台",
                    dataType = "String"
            )
    })
    CompanyCreditInfoVO getCreditInfo(String accountNum) {
        return infoService.getCreditInfo(accountNum);
    }

    @RequestMapping(value = "/allCompanyInfo/allGuaranty", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "accountNum",
                    required = true,
                    value = "每次后台返回的用来填充所有公司列表的信息中包含了公司的AccountNum，需要存下来，在用户点击某一项来查看所有抵押物时传给后台",
                    dataType = "String"

            )
    })
    List<GuarantyInfoVO> getAllGuaranty(String accountNum) {
        return infoService.getAllGuaranty(accountNum);
    }

    @RequestMapping(value = "/allCompanyInfo/cancleCompanyAccount", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    paramType = "query",
                    name = "accountNum",
                    required = true,
                    value = "每次后台返回的用来填充所有公司列表的信息中包含了公司的AccountNum，需要存下来，在用户点击某一项来注销帐户传给后台",
                    dataType = "String"
            )
    })
    BaseResponseVO cancleCompanyAccount(String accountNum) {
        return infoService.cancleCompanyAccount(accountNum);
    }
}
