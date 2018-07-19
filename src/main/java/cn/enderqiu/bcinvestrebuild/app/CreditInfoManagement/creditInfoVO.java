package cn.enderqiu.bcinvestrebuild.app.CreditInfoManagement;

public class creditInfoVO {
    private String AccountId;
    private String GuarantyId;
    private String ReportId;
    //交易状态：逾期或在期限内归还
    private String GurantyName;
    private String DueTime;

    private String Type;
    private String Credit;
    private String Variation;

    public creditInfoVO(String accountId, String guarantyId, String reportId, String gurantyName, String dueTime, String type, String credit, String variation) {
        AccountId = accountId;
        GuarantyId = guarantyId;
        ReportId = reportId;
        GurantyName = gurantyName;
        DueTime = dueTime;
        Type = type;
        this.Credit = credit;
        this.Variation = variation;
    }

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


    public void setGurantyName(String gurantyName) {
        GurantyName = gurantyName;
    }

    public void setDueTime(String dueTime) {
        DueTime = dueTime;
    }

    public String getCredit() {
        return Credit;
    }

    public void setCredit(String credit) {
        this.Credit = credit;
    }

    public String getVariation() {
        return Variation;
    }

    public void setVariation(String variation) {
        this.Variation = variation;
    }
}
