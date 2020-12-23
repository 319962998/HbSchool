package com.colin.bean;

public class SentExam {
    private int eId;
    private int cId;
    private String name;
    private String section;
    private String begin;
    private String last;
    private String submit;

    public SentExam() {
    }

    public SentExam(int eId, int cId, String name, String section, String begin, String last, String submit) {
        this.eId = eId;
        this.cId = cId;
        this.name = name;
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

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
