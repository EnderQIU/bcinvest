package cn.enderqiu.bcinvestrebuild.controller;


import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserStatusVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserVO;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import cn.enderqiu.bcinvestrebuild.service.contract.CompanyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/company")
@Api("企业注册登录信息")
@RequiredPermissions("company")
public class CompanyController extends BaseController {
    @Autowired //自动装载Impl对象
    private CompanyUserService service;

    //public 列表

    @RequestMapping(value = "status", method = RequestMethod.POST)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "form",
            name = "code", required = true, value = "从花旗请求到的原始code",
            dataType = "String")})
    CompanyUserStatusVO codeToStatusAndToken(String code) {
        return service.code2InnerToken(code);
    }

    @RequestMapping(value = "status", method = RequestMethod.GET)
    CompanyUserStatusVO getUserStatus(){
        return service.getUserStatus(getCompanyUserDTO().getToken());
    }

    @RequestMapping(value = "authorize", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "LocalName", required = true,
                    value = "公司名",
                    dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "TelephoneNumber", required = true,
                    value = "公司联系人手机",
                    dataType = "String")
    })
    CompanyUserStatusVO saveCompanyData(String LocalName, String TelephoneNumber) {
        CompanyUserDTO dto = getCompanyUserDTO();
        dto.setUserName(LocalName);
        dto.setTelephoneNumber(TelephoneNumber);
        return service.saveCompanyData(getCompanyUserDTO().getToken(), dto);
    }

    @RequestMapping(value = "info", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "LocalName", required = false,
                    value = "公司名",
                    dataType = "String"),
            @ApiImplicitParam(paramType = "form", name = "TelephoneNumber", required = false,
                    value = "公司联系人手机",
                    dataType = "String")
    })
    CompanyUserStatusVO changeCompanyData(String LocalName, String
            TelephoneNumber) {
        CompanyUserDTO dto = getCompanyUserDTO();
        dto.setUserName(LocalName);
        dto.setTelephoneNumber(TelephoneNumber);
        return service.saveCompanyData(getCompanyUserDTO().getToken(), dto);
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    CompanyUserVO getUserData() {
        return service.getUserData(getCompanyUserDTO().getToken());
    }

} //end inner class CompanyController
