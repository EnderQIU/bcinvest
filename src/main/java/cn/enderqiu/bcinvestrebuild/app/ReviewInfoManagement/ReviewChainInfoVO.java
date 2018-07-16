package cn.enderqiu.bcinvestrebuild.app.ReviewInfoManagement;

public class ReviewChainInfoVO {
    private ReviewCompanyInfoVO reviewCompanyInfoVO;
    private String guarantyId;
    private String reportId;
    private String authorityId;
    private String guarantyName;
    private String evaluateValue;

    public ReviewChainInfoVO(ReviewCompanyInfoVO reviewCompanyInfoVO, String guarantyId, String reportId, String authorityId, String guarantyName, String evaluateValue) {
        this.reviewCompanyInfoVO = reviewCompanyInfoVO;
        this.guarantyId = guarantyId;
        this.reportId = reportId;
        this.authorityId = authorityId;
        this.guarantyName = guarantyName;
        this.evaluateValue = evaluateValue;
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
