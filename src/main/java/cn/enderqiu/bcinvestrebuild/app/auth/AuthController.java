package cn.enderqiu.bcinvestrebuild.app.auth;

import cn.enderqiu.bcinvestrebuild.app.auth.response.TokenResponse;
import cn.enderqiu.bcinvestrebuild.app.auth.serializer.BasicAuthSerializer;
import cn.enderqiu.bcinvestrebuild.app.auth.serializer.CodeSerializer;
import cn.enderqiu.bcinvestrebuild.framework.Controller;
import cn.enderqiu.bcinvestrebuild.framework.Response;
import cn.enderqiu.bcinvestrebuild.framework.Serializer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("统一认证接口")
@RequestMapping("/auth")
@RestController
public class AuthController extends Controller {

    @Autowired
    private AuthView authView;

    @ApiOperation(value = "企业认证", notes = "企业通过 code 交换 token")
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "String", required = true, name = "code", value = "从花旗银行登录获取到的 code")
    })
    public TokenResponse retriveTokenByCode(CodeSerializer serializer){
        return authView.retriveToken(serializer);
    }

    @ApiOperation(value = "银行操作员或权威机构认证", notes = "通过交换 username 和 password 交换 token")
    @RequestMapping(value = "/boa", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "String", required = true, name = "username", value = "用户名"),
            @ApiImplicitParam(paramType = "form", dataType = "String", required = true, name = "password", value = "密码"),
    })
    public TokenResponse retriveToken(BasicAuthSerializer serializer){
        return authView.retriveToken(serializer);
    }
}
