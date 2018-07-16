package cn.enderqiu.bcinvestrebuild.app.ReviewInfoManagement;

public class ReviewCompanyInfoVO {

    private String AccountId;
    private String Credit;
    private String Name;
    private String TelNum;
    private String EmailAddress;

    public String getAccountId() {
        return AccountId;
    }

    public String getCredit() {
        return Credit;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getName() {
        return Name;
    }

    public String getTelNum() {
        return TelNum;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public void setCredit(String credit) {
        Credit = credit;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTelNum(String telNum) {
        TelNum = telNum;
    }
    public ReviewCompanyInfoVO(String accountId, String credit, String name, String telnum, String emailaddress )
    {
        AccountId=accountId;
        Credit=credit;
        Name=name;
        TelNum=telnum;
        EmailAddress=emailaddress;
    }
}
