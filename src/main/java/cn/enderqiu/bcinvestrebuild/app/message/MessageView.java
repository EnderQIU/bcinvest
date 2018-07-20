package cn.enderqiu.bcinvestrebuild.app.message;

import cn.enderqiu.bcinvestrebuild.app.message.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MarkMessageSerializer;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MessageDataFromSerializer;
import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import cn.enderqiu.bcinvestrebuild.util.MyBeanUtils;
import com.generator.tables.Message;
import com.generator.tables.records.MessageRecord;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageView {

    @Autowired
    private DSLContext dsl;


    public MessageResponse postMessage(BankUserDTO bankUserDTO, MessageDataFromSerializer serializer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String unreadStatus = "unread";
        MessageResponse response = new MessageResponse();
        Message m = Message.MESSAGE;
        Record record =
                dsl.insertInto(
                        m,
                        m.FROMUSERNUM,
                        m.TOUSERNUM,
                        m.CONTENT,
                        m.STATUS)
                        .values(
                                bankUserDTO.getAccountNum(),
                                serializer.getToUserId(),
                                serializer.getContent(),
                                unreadStatus)
                        .returning(
                                m.FROMUSERNUM,
                                m.TOUSERNUM,
                                m.CONTENT,
                                m.STATUS)
                        .fetchOne();
        response.setMessage("ok");
        return response;
    }

    public List<MessageResponse> retrieveMessage(BankUserDTO bankUserDTO, CompanyUserDTO companyUserDTO) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ArrayList<MessageResponse> responses = new ArrayList<>();
        if (companyUserDTO != null){
            // 公司查看收到的消息
            Result<MessageRecord> result = dsl
                    .selectFrom(Message.MESSAGE)
                    .where(Message.MESSAGE.TOUSERNUM.eq(companyUserDTO.getAccountNum()).and(Message.MESSAGE.STATUS.ne("deleted")))
                    .fetch();
            for (MessageRecord record: result){
                MessageResponse response = new MessageResponse();
                response.setMessage("ok");
                response.setContent(record.getContent());
                response.setFromUserNum(record.getFromusernum());
                response.setTousernum(record.getTousernum());
                response.setStatus(record.getStatus());
                responses.add(response);
            }
        }else {
            // 银行和机构查看发出的消息和机构查看收到的消息
            Result<MessageRecord> result = dsl
                    .selectFrom(Message.MESSAGE)
                    .where(Message.MESSAGE.TOUSERNUM.eq(bankUserDTO.getAccountNum()).and(Message.MESSAGE.STATUS.ne("deleted")))
                    .or(Message.MESSAGE.FROMUSERNUM.eq(bankUserDTO.getAccountNum()).and(Message.MESSAGE.STATUS.ne("deleted")))
                    .fetch();
            for (MessageRecord record: result){

                MessageResponse response = new MessageResponse();
                response.setMessage("ok");
                response.setContent(record.getContent());
                response.setFromUserNum(record.getFromusernum());
                response.setTousernum(record.getTousernum());
                response.setStatus(record.getStatus());
                responses.add(response);
            }
        }
        return responses;
    }

    public BaseResponseVO markMessage(MarkMessageSerializer serializer) {
        BaseResponseVO responseVO = new BaseResponseVO();
        Integer messageId = serializer.getMessageId();
        String status = serializer.getStatus();
        if (!status.equals("read") && !status.equals("deleted")){
            responseVO.setMessage("invalid status");
            return responseVO;
        }
        Message T = Message.MESSAGE;
        int result = dsl.update(T).set(T.STATUS, status).where(T.ID.eq(messageId)).execute();
        responseVO.setMessage(String.valueOf(result));
        return responseVO;
    }
}
