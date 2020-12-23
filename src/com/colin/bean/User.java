package com.colin.bean;

public class User {
    private int id;
    private String name;
    private String password;
    private String grade;
    private String school;
    private String phone;
    private String note;
    private int tuition;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public User() {
    }

    public User(String name, String password, String grade, String school, String phone, String note, int tuition) {
        this.name = name;
        this.password = password;
        this.grade = grade;
        this.school = school;
        this.phone = phone;
        this.note = note;
        this.tuition = tuition;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
