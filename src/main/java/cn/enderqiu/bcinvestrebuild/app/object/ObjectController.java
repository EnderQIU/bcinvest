package cn.enderqiu.bcinvestrebuild.app.object;

import cn.enderqiu.bcinvestrebuild.app.object.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.object.serializer.ObjectSerializer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api("区块链数据传输")
@RestController
@RequestMapping("/bc")
public class ObjectController {

    @Autowired
    private ObjectView view;

    @ApiOperation("接受序列化对象的字节流文件，传给 dispature 处理")
    @RequestMapping(value = "miner/", method = RequestMethod.POST)
    private MessageResponse receiveObject(ObjectSerializer serializer) throws IOException, ClassNotFoundException {
        return view.receiveObject(serializer);
    }
}
