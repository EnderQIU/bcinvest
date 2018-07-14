package cn.enderqiu.bcinvestrebuild.app.message;

import cn.enderqiu.bcinvestrebuild.app.message.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MessageDataFromSerializer;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageView {

    @Autowired
    private DSLContext dsl;


    public MessageResponse postMessage(MessageDataFromSerializer serializer) {
        return null;
    }
}
