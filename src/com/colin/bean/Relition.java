package com.colin.bean;

public class Relition {
    private int cId;
    private int sId;
    private String cName;
    private String sName;

    public Relition() {
    }

    public Relition(int cId, int sId, String cName, String sName) {
        this.cId = cId;
        this.sId = sId;
        this.cName = cName;
        this.sName = sName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
