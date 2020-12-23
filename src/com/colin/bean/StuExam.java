package com.colin.bean;

public class StuExam {
    private int eId;
    private int sId;
    private int pId;
    private String send;
    private String name;
    private byte[] address;

    public StuExam() {
    }

    public StuExam(int eId, int sId, int pId, String send, String name, byte[] address) {
        this.eId = eId;
        this.sId = sId;
        this.pId = pId;
        this.send = send;
        this.name = name;
        this.address = address;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getAddress() {
        return address;
    }

    public void setAddress(byte[] address) {
        this.address = address;
    }
}
