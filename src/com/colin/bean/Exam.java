package com.colin.bean;

public class Exam {
    private int id;
    private int tId;
    private String name;
    private String section;

    public Exam() {
    }

    public Exam(int id, int tId, String name, String section) {
        this.id = id;
        this.tId = tId;
        this.name = name;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
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
}
