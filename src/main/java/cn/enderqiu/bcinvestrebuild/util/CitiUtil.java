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
    private static String clientId = "92c684d7-e3b2-468f-ad34-afeedc941858";

    private static String clientSecret = "S3kL6yG1aS1lI6qC7mQ1cI5xN3dJ7sS5yG2iL2bF2uT7tJ6vW6";

    /**
     * @param code
     * @return
     * @throws Exception
     */
    public static String getAccessToken(String code) throws Exception
    {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

        String grant_info= "grant_type=authorization_code";
        String code_info="code="+code;
        String redirect_info="redirect_uri=http://citi.enderqiu.cn/fillInfo.html";
        RequestBody body=RequestBody.create(mediaType,grant_info+"&"+code_info+"&"+redirect_info);

        String s="92c684d7-e3b2-468f-ad34-afeedc941858:S3kL6yG1aS1lI6qC7mQ1cI5xN3dJ7sS5yG2iL2bF2uT7tJ6vW6";
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
        String uuid = UUID.randomUUID().toString().trim();
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
