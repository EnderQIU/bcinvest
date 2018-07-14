package cn.enderqiu.bcinvestrebuild.app.auth.serializer;

import cn.enderqiu.bcinvestrebuild.framework.Serializer;

public class BasicAuthSerializer extends Serializer {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
