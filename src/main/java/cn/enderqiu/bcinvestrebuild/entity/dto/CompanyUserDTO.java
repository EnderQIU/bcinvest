package cn.enderqiu.bcinvestrebuild.entity.dto;

public class CompanyUserDTO {
    private int companyUserId;

    private String userName;

    private String userAvatarUrl;

    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(int companyUserId) {
        this.companyUserId = companyUserId;
    }
}
