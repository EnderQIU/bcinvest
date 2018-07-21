package cn.enderqiu.bcinvestrebuild.app.ReviewInfoManagement;

public class ReviewChainInfoVO {
    public String getCredit() {
        return credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    private ReviewCompanyInfoVO reviewCompanyInfoVO;
    private String guarantyId;
    private String reportId;
    private String authorityId;
    private String guarantyName;
    private String evaluateValue;
    private String credit;
    private String type;

    public ReviewChainInfoVO(ReviewCompanyInfoVO reviewCompanyInfoVO, String guarantyId , String guarantyName,String type) {
        this.reviewCompanyInfoVO = reviewCompanyInfoVO;
        this.guarantyId = guarantyId;

        this.type=type;
        this.guarantyName = guarantyName;
        this.credit=credit;
    }

    public ReviewCompanyInfoVO getReviewCompanyInfoVO() {
        return reviewCompanyInfoVO;
    }

    public void setReviewCompanyInfoVO(ReviewCompanyInfoVO reviewCompanyInfoVO) {
        this.reviewCompanyInfoVO = reviewCompanyInfoVO;
    }

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getGuarantyName() {
        return guarantyName;
    }

    public void setGuarantyName(String guarantyName) {
        this.guarantyName = guarantyName;
    }

    public String getEvaluateValue() {
        return evaluateValue;
    }

    public void setEvaluateValue(String evaluateValue) {
        this.evaluateValue = evaluateValue;
    }
}
