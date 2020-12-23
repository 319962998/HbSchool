package com.colin.bean;

public class LayExam {
    private int eId;
    private String cName;
    private String eName;
    private String section;
    private String begin;
    private String last;
    private String submit;

    public LayExam() {
    }

    public LayExam(int eId, String cName, String eName, String section, String begin, String last, String submit) {
        this.eId = eId;
        this.cName = cName;
        this.eName = eName;
        this.section = section;
        this.begin = begin;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
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
