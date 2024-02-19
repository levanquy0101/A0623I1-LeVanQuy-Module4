package com.example.simpledictionary.model;

public class Convert {
    private String eng;
    private String vn;

    public Convert() {
    }

    public Convert(String eng, String vn) {
        this.eng = eng;
        this.vn = vn;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }
}
