package com.colin.bean;

public class SubmitExam {
    private int eId;
    private int sId;
    private String submit;
    private String time;

    public SubmitExam(int eId, int sId, String submit, String time) {
        this.eId = eId;
        this.sId = sId;
        this.submit = submit;
        this.time = time;
    }

    public SubmitExam() {
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

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
