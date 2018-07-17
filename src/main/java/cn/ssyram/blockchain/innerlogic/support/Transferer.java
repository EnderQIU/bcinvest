package cn.ssyram.blockchain.innerlogic.support;

import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import com.bcgenerator.tables.Addresslist;
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
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Transferer {

    @Autowired
    private static DSLContext dsl;

    public static void send(Serializable ser){
        String type = "";
        if (ser instanceof Block)
            type = "Block";
        else if (ser instanceof ArrayList)
            //内容是BlockData
            type = "BlockData";
        if (type.equals("")) return;
        Result<Record1<String>> targets = dsl
                .select(Addresslist.ADDRESSLIST.ADDRESS)
                .from(Addresslist.ADDRESSLIST)
                .fetch();
        if (targets ==  null){
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

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        for (String address: targets.getValues(0, String.class)){

            try{
                httpClient = HttpClients.createDefault();
                // 把一个普通参数和文件上传给下面这个地址 是一个servlet
                HttpPost httpPost = new HttpPost(address);
                StringBody _type = new StringBody(type, ContentType.create(
                        "text/plain", Consts.UTF_8));
                HttpEntity reqEntity = MultipartEntityBuilder.create()
                        .addPart("type", _type)
                        .addBinaryBody("data", data)
                        .build();
                httpPost.setEntity(reqEntity);
                response = httpClient.execute(httpPost);
            }
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (response != null) {
                        response.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

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
