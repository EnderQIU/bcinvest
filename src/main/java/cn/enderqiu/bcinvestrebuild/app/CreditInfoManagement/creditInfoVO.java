package cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement;

public class creditInfoVO {
    private String AccountId;
    private String GuarantyId;
    private String ReportId;
    //交易状态：逾期或在期限内归还
    private String GurantyName;
    private String DueTime;

    private String Type;

    public void setAccountId(String accountId)
    {
        AccountId=accountId;
    }
    public void setGuarantyId(String guarantyId)
    {
        GuarantyId=guarantyId;
    }
    public void setReportId(String reportId)
    {
        ReportId=reportId;
    }



    public void setType(String type)
    {
        Type=type;
    }

    public String getAccountId() {
        return AccountId;
    }

    public String getGuarantyId() {
        return GuarantyId;
    }

    public String getReportId() {
        return ReportId;
    }
    public String getDueTime() {
        return DueTime;
    }


    public String getGurantyName() {
        return GurantyName;
    }
    public String getType() {
        return Type;
    }
    public creditInfoVO(String accountId, String guarantyId, String reportId, String type,String duetime,String gurantyName
                        )
    {
        AccountId=accountId;
        GuarantyId=guarantyId;
        ReportId=reportId;
        Type=type;
        DueTime=duetime;
        GurantyName=gurantyName;
    }
}
