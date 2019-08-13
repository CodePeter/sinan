package com.sinan.common.data;

public class HelloDTO {
    private String bizId;
    private Integer productId;
    private String lang;
    private String path;
    private String resumeNumber;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResumeNumber() {
        return resumeNumber;
    }

    public void setResumeNumber(String resumeNumber) {
        this.resumeNumber = resumeNumber;
    }
}