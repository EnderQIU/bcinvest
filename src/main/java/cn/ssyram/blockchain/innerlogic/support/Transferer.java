package cn.ssyram.blockchain.innerlogic.support;

import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import com.generator.tables.Addresslist;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;
import org.asynchttpclient.request.body.multipart.ByteArrayPart;
import org.asynchttpclient.request.body.multipart.FilePart;
import org.asynchttpclient.request.body.multipart.Part;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Future;

import static org.asynchttpclient.Dsl.asyncHttpClient;
import static org.asynchttpclient.Dsl.post;

@Component
public class Transferer {

    private static DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        Transferer.dsl = dsl;
    }

    public static void send(Serializable ser){
        String type = "";
        if (ser instanceof Block)
            type = "Block";
        else if (ser instanceof CollectDTO)
            //内容是BlockData
            type = "CollectDTO";
        if (type.equals("")) return;
        Result<Record1<String>> targets = dsl
                .select(Addresslist.ADDRESSLIST.ADDRESS)
                .from(Addresslist.ADDRESSLIST)
                .fetch();
        if (targets ==  null || targets.size() == 0){
            return;
        }

        ByteArrayOutputStream byt = new ByteArrayOutputStream();
        try{
            ObjectOutputStream obj = new ObjectOutputStream(byt);
            obj.writeObject(ser);
        }catch (IOException e){
            e.printStackTrace();
        }

        byte[] data = byt.toByteArray();

        AsyncHttpClient httpClient = null;

        for (String address: targets.getValues(0, String.class)){

            try{
                httpClient = asyncHttpClient();
                ByteArrayPart byteArrayPart = new ByteArrayPart("data", data);
                Request request = post(address).addBodyPart(byteArrayPart).addFormParam("type", type).build();
                Future<Response> whenResponse = httpClient.executeRequest(request);
            }
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (httpClient != null) {
                        httpClient.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
