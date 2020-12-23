package com.colin.bean;

public class Course {
    private int id;
    private String name;
    private String time;
    private String tName;
    private int tId;
    private int tPay;
    private int sPay;
    private int totalClass;
    private int payClass;

    public Course(int id, String name, String time, String tName, int tId, int tPay, int sPay, int totalClass, int payClass) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.tName = tName;
        this.tId = tId;
        this.tPay = tPay;
        this.sPay = sPay;
        this.totalClass = totalClass;
        this.payClass = payClass;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
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

    public int getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int totalClass) {
        this.totalClass = totalClass;
    }

    public int getPayClass() {
        return payClass;
    }

    public void setPayClass(int payClass) {
        this.payClass = payClass;
    }
}
