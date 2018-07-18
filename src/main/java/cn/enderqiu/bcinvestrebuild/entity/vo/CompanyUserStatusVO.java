package cn.enderqiu.bcinvestrebuild.entity.vo;

public class CompanyUserStatusVO {
    private String status;
    private String token;

    public CompanyUserStatusVO(String status, String user_id_token){
        setStatus(status);
        setToken(user_id_token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
