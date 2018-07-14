package cn.enderqiu.bcinvestrebuild.app.message;

import cn.enderqiu.bcinvestrebuild.app.message.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MessageDataFromSerializer;
import cn.enderqiu.bcinvestrebuild.permission.RequiredPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("消息服务")
@RequestMapping("/message")
@RestController
public class MessageController {

    @Autowired
    private MessageView view;

    @ApiOperation(value = "发起消息", notes = "银行和机构才能发起消息")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @RequiredPermissions("bank, authority")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", dataType = "String", required = true, name = "content", value = "消息内容"),
            @ApiImplicitParam(paramType = "form", dataType = "String", required = true, name = "toUserId", value = "消息内容"),
            })
    public MessageResponse postMessage(MessageDataFromSerializer serializer){
        return view.postMessage(serializer);
    }

}
