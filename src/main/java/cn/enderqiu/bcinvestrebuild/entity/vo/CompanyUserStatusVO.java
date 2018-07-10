package cn.enderqiu.bcinvestrebuild.entity.vo;

public class CompanyUserStatusVO {
    private String status;
    private String user_id_token;

    public CompanyUserStatusVO(String status, String user_id_token){
        setStatus(status);
        setUser_id_token(user_id_token);
    }

    public String getUser_id_token() {
        return user_id_token;
    }

    public void setUser_id_token(String user_id_token) {
        this.user_id_token = user_id_token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
