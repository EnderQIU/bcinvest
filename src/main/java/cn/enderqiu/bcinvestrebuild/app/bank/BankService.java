package cn.enderqiu.bcinvestrebuild.app.bank;

import cn.enderqiu.bcinvestrebuild.app.bank.response.BOAInfoResponse;
import cn.enderqiu.bcinvestrebuild.app.bank.response.RetrieveTokenResponse;
import cn.enderqiu.bcinvestrebuild.app.bank.serializer.BasicAuthSerializer;
import cn.enderqiu.bcinvestrebuild.entity.dto.BankUserDTO;
import com.generator.tables.Authorization;
import com.generator.tables.records.AuthorizationRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private DSLContext dsl;

    public RetrieveTokenResponse retrieveToken(BasicAuthSerializer basicAuthSerializer) {
        String userName = basicAuthSerializer.getUserName();
        String password = basicAuthSerializer.getPassword();

        Record record = dsl
                .select()
                .from(Authorization.AUTHORIZATION)
                .where(Authorization.AUTHORIZATION.NAME.eq(userName)
                        .and(Authorization.AUTHORIZATION.PASSWORD.eq(password))).fetchOne();
        RetrieveTokenResponse response = new RetrieveTokenResponse();
        if (record != null){
            response.setToken(record.getValue("Token", String.class));
            response.setMessage("ok");
        }else{
            response.setMessage("username or password not match");
        }
        return response;
    }

    public BOAInfoResponse getBOAInfo(BankUserDTO bankUserDTO) {
        AuthorizationRecord record = dsl
                .fetchOne(Authorization.AUTHORIZATION,
                        Authorization.AUTHORIZATION.TOKEN
                                .eq(bankUserDTO.getToken()));
        BOAInfoResponse response = new BOAInfoResponse();

        if (record != null){
            response.setName(record.getName());
            int type = record.getType();
            if (type == 0){
                response.setType("bank");
            }else if (type == 1){
                response.setType("authority");
            }
        }
        return response;
    }
}
