package cn.enderqiu.bcinvestrebuild.app.message;

import cn.enderqiu.bcinvestrebuild.app.message.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MessageDataFromSerializer;
import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
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
        Byte status = new Byte("0");
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
                                status)
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
                    .where(Message.MESSAGE.TOUSERNUM.eq(companyUserDTO.getAccountNum()))
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
                    .where(Message.MESSAGE.TOUSERNUM.eq(bankUserDTO.getAccountNum()))
                    .or(Message.MESSAGE.FROMUSERNUM.eq(bankUserDTO.getAccountNum()))
                    .fetch();
            for (MessageRecord record: result){

                MessageResponse response = new MessageResponse();
                response.setMessage("ok");
                response.setContent(record.getContent());
                response.setFromUserNum(record.getFromusernum());
                response.setTousernum(record.getTousernum());
                response.setStatus(record.getStatus());                responses.add(response);
            }
        }
        return responses;
    }
}
