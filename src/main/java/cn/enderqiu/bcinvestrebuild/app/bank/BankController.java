package cn.enderqiu.bcinvestrebuild.app.bank;

import cn.enderqiu.bcinvestrebuild.app.bank.response.BOAInfoResponse;
import cn.enderqiu.bcinvestrebuild.app.bank.response.RetrieveTokenResponse;
import cn.enderqiu.bcinvestrebuild.app.bank.serializer.BasicAuthSerializer;
import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("银行及权威机构操作人员账号相关接口")
@RequestMapping(value = "/user/bankOrAuthority")
public class BankController  extends BaseController {

    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/token", method = RequestMethod.PUT)
    public RetrieveTokenResponse retrieveToken(BasicAuthSerializer basicAuthSerializer){
        return bankService.retrieveToken(basicAuthSerializer);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public BOAInfoResponse getBOAInfo(){
        return bankService.getBOAInfo(getBankUserDTO());
    }
}
