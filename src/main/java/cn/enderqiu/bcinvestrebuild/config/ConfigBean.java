package cn.enderqiu.bcinvestrebuild.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cn.enderqiu.citi")
public class ConfigBean {
    private String appId;

    private String appSecret;

    private String accessToken;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
