package cn.enderqiu.bcinvestrebuild.app.ReviewInfoManagement;

public class UpdateGuarantyValueVO {
    public UpdateGuarantyValueVO(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
