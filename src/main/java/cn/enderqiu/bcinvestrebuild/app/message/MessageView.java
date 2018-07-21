package cn.enderqiu.bcinvestrebuild.app.message;

import cn.enderqiu.bcinvestrebuild.app.message.response.CompanyIdAndNameResponse;
import cn.enderqiu.bcinvestrebuild.app.message.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MarkMessageSerializer;
import cn.enderqiu.bcinvestrebuild.app.message.serializer.MessageDataFromSerializer;
import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.dto.CompanyUserDTO;
import cn.enderqiu.bcinvestrebuild.entity.vo.BaseResponseVO;
import com.generator.tables.Authorization;
import com.generator.tables.Company;
import com.generator.tables.Message;
import com.generator.tables.records.CompanyRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageView {

    @Autowired
    private DSLContext dsl;


    public MessageResponse postMessage(BankUserDTO bankUserDTO, MessageDataFromSerializer serializer) {
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
        return response;
    }

    public List<MessageResponse> retrieveMessage(BankUserDTO bankUserDTO, CompanyUserDTO companyUserDTO) {
        ArrayList<MessageResponse> responses = new ArrayList<>();
        Result result;
        if (companyUserDTO != null && companyUserDTO.getAccountNum() != null){
            // 公司查看收到的消息
            result = dsl
                    .select().from(Message.MESSAGE).join(Authorization.AUTHORIZATION).on(Message.MESSAGE.FROMUSERNUM.eq(Authorization.AUTHORIZATION.ACCOUNTNUM).and(Message.MESSAGE.STATUS.ne("deleted")))
                    .where(Message.MESSAGE.TOUSERNUM.eq(companyUserDTO.getAccountNum()))
                    .fetch();
        }else if (bankUserDTO != null && bankUserDTO.getAccountNum() != null){
            if (bankUserDTO.getUserType() > 0){
                // 机构查看收到的消息
                result = dsl.select().from(Message.MESSAGE).join(Authorization.AUTHORIZATION).on(Message.MESSAGE.TOUSERNUM.eq(Authorization.AUTHORIZATION.ACCOUNTNUM)).where(Authorization.AUTHORIZATION.ACCOUNTNUM.eq(bankUserDTO.getAccountNum())).fetch();
            }
            else {
                return responses;
            }
//            // 银行和机构查看发出的消息和机构查看收到的消息
//            result = dsl
//                    .select().from(Message.MESSAGE).join(Authorization.AUTHORIZATION).on(Message.MESSAGE.FROMUSERNUM.eq(Authorization.AUTHORIZATION.ACCOUNTNUM))
//                    .where(Message.MESSAGE.TOUSERNUM.eq(bankUserDTO.getAccountNum()).or(Message.MESSAGE.FROMUSERNUM.eq(bankUserDTO.getAccountNum())).and(Message.MESSAGE.STATUS.ne("deleted")))
//                    .fetch();
        }else {
            return responses;
        }
        for (Object o: result){
            Record record = (Record) o;
            MessageResponse response = new MessageResponse();
            response.setMessageid(record.getValue("id", Integer.class));
            response.setContent(record.getValue("content", String.class));
            response.setStatus(record.getValue("status", String.class));
            response.setFromUserName(record.getValue("Name", String.class));
            response.setToUserNum(record.getValue("toUserNum", String.class));
            responses.add(response);
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

    public List<CompanyIdAndNameResponse> retrieveCompanyIdAndName() {
        Result result = dsl.select().from(Company.COMPANY).fetch();
        ArrayList<CompanyIdAndNameResponse> responses = new ArrayList<>();
        for (Object o: result){
            Record record = (Record) o;
            CompanyIdAndNameResponse response = new CompanyIdAndNameResponse();
            response.setAccountNum(record.getValue("AccountNum", String.class));
            response.setName(record.getValue("Name", String.class));
            responses.add(response);
        }
        return responses;
    }
}
