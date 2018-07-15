package cn.enderqiu.bcinvestrebuild.app.message;

import cn.enderqiu.bcinvestrebuild.app.message.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MessageDataFromSerializer;
import cn.enderqiu.bcinvestrebuild.controller.BaseController;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Api("消息服务")
@RequestMapping("/message")
@RestController
public class MessageController extends BaseController {

    @Autowired
    private MessageView view;

    @ApiOperation(value = "发起消息", notes = "银行可以给机构和企业发起消息，机构可以给企业发起消息")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @RequiredPermissions("bank, authority")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "String", required = true, name = "content", value = "消息内容"),
            @ApiImplicitParam(paramType = "form", dataType = "String", required = true, name = "toUserId", value = "消息内容"),
            })
    public MessageResponse postMessage(MessageDataFromSerializer serializer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return view.postMessage(getBankUserDTO(), serializer);
    }

    @ApiOperation(value = "查看消息", notes = "机构能够收到来自银行的消息，企业能够收到来自机构和银行的消息")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<MessageResponse> retrieveMessage() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return view.retrieveMessage(getBankUserDTO(), getCompanyUserDTO());
    }
}
