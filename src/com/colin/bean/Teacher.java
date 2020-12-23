package com.colin.bean;

public class Teacher {
    private int id;
    private String name;
    private String password;
    private String subject;
    private String phone;
    private String note;
    private int salary;

    public Teacher() {
    }

    public Teacher(String name, String password, String subject, String phone, String note, int salary) {
        this.name = name;
        this.password = password;
        this.subject = subject;
        this.phone = phone;
        this.note = note;
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
