package cn.enderqiu.bcinvestrebuild.controller;

import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserStatusVO;
import cn.enderqiu.bcinvestrebuild.entity.vo.CompanyUserVO;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import cn.enderqiu.bcinvestrebuild.service.contract.BankUserService;
import cn.enderqiu.bcinvestrebuild.service.contract.CompanyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api("用户注册登录信息")
public class UserController extends BaseController {


} //end class UserController
