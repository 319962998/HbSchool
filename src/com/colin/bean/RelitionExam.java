package com.colin.bean;

public class RelitionExam {
    private int eId;
    private int pId;

    public RelitionExam() {
    }

    public RelitionExam(int eId, int pId) {
        this.eId = eId;
        this.pId = pId;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
}
