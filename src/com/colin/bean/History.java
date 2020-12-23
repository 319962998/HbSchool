package com.colin.bean;

public class History {
    private int cId;
    private String history;
    private int sId;
    private String sName;
    private int tPay;
    private int sPay;
    public History() {
    }

    public History(int cId, String history, int sId, String sName, int tPay, int sPay) {
        this.cId = cId;
        this.history = history;
        this.sId = sId;
        this.sName = sName;
        this.tPay = tPay;
        this.sPay = sPay;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int gettPay() {
        return tPay;
    }

    public void settPay(int tPay) {
        this.tPay = tPay;
    }

    public int getsPay() {
        return sPay;
    }

    public void setsPay(int sPay) {
        this.sPay = sPay;
    }
}
