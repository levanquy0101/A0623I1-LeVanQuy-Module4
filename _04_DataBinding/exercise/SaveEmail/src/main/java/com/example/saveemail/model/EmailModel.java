package com.example.saveemail.model;

public class EmailModel {
    private String language ;
    private Integer pageSize;
    private Boolean spams;
    private String signature;

    public EmailModel() {
    }

    public EmailModel(String language, Integer pageSize, Boolean spams, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpams() {
        return spams;
    }

    public void setSpams(Boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
