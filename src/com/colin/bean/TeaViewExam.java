package com.colin.bean;

public class TeaViewExam {
    private int eId;
    private String cName;
    private String eName;
    private String sName;
    private String time;
    private String last;
    private String submit;

    public TeaViewExam() {
    }

    public TeaViewExam(int eId, String cName, String eName, String sName, String time, String last, String submit) {
        this.eId = eId;
        this.cName = cName;
        this.eName = eName;
        this.sName = sName;
        this.time = time;
        this.last = last;
        this.submit = submit;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }
}
