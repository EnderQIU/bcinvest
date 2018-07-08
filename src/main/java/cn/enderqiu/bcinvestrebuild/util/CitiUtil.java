package cn.enderqiu.bcinvestrebuild.util;

import java.util.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.*;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;

public class CitiUtil {
    // 得到AccessToken
    @Value("${cn.enderqiu.citi.clientId}")
    private static String clientId;

    @Value("${cn.enderqiu.citi.clientSecret}")
    private static String clientSecret;

    /**
     * @param code
     * @return
     * @throws Exception
     */
    public static String getAccessToken(String code) throws Exception
    {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

        String grant_info= "grant_type=client_credentials";
        String code_info="code="+code;
        String redirect_info="redirect_uri=https://www.baidu.com";
        RequestBody body=RequestBody.create(mediaType,grant_info+"&"+code_info+"&"+redirect_info);

        String s=clientId+":"+clientSecret;
        String auth=Base64.getEncoder().encodeToString(s.getBytes());
        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/token/au/gcb")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Basic "+auth)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build();

        Response response = client.newCall(request).execute();


        JSONObject jsonObject= new JSONObject(response.body().string());
        String access_token=jsonObject.get("access_token").toString();
        return access_token;
    }

    /**
     * @param accessToken
     * @return
     * @throws Exception
     */
    public static JSONObject getCustomerInfo(String accessToken)throws Exception{
        OkHttpClient client = new OkHttpClient();
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        String auth = "Bearer"+" "+accessToken;


        Request request = new Request.Builder()
                .url("https://sandbox.apihub.citi.com/gcb/api/v1/customers/profiles")
                .get()
                .addHeader("authorization", auth)
                .addHeader("uuid", uuid)
                .addHeader("accept", "application/json")
                .addHeader("client_id", clientId)
                .build();

        Response response = client.newCall(request).execute();
        JSONObject jsonObject= new JSONObject(response.body().string());
        return jsonObject;
    }

    /**
     * @param accessToken
     * @return
     * @throws Exception
     */
    public static String getCustomerType(String accessToken)throws Exception{
        String customerType=getCustomerInfo(accessToken).get("customerType").toString();
        return customerType;
    }

    /**
     * @param accessToken
     * @return
     * @throws Exception
     */
    public static List<String> getCustomerEmail(String accessToken)throws Exception{
        JSONArray customerEmail=getCustomerInfo(accessToken).getJSONArray("emails");
        List<String> emails = new ArrayList<String>();
        for(int i = 0;i<customerEmail.length();i++){
            JSONObject obj = (JSONObject)customerEmail.get(i);
            String email = obj.get("emailAddress").toString();
            emails.add(email);
        }
        return emails;
    }

    /**
     * @param accessToken
     * @return
     * @throws Exception
     */
    public static String getCustomerName(String accessToken)throws Exception{

        JSONObject obj=(JSONObject)getCustomerInfo(accessToken).get("customerParticulars");
        JSONArray names = obj.getJSONArray("names");
        String name = null;
        for(int i = 0;i<names.length();i++){
            JSONObject temp = (JSONObject)names.get(i);
            String nameType = temp.get("nameType").toString();
            if(nameType.equals("LOCAL_NAME")){
                name = temp.get("fullName").toString();
            }
        }
        return name;
    }
}
