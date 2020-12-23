package com.colin.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Note {
    private int id;
    private String title;
    private Course course;
    private Teacher teacher;
    private String textContent;
    private String imgName;
    private byte[] imgContent;
    private Date date;      //上传时间


    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", course=" + course +
                ", teacher=" + teacher +
                ", textContent='" + textContent + '\'' +
                ", imgName='" + imgName + '\'' +
                ", imgContent=" + imgContent.getClass() +
                ", date=" + date +
                '}';
    }

    public Note(int id, String title, Course course, Teacher teacher, String textContent, String imgName, byte[] imgContent, Date date) {
        this.id = id;
        this.title = title;
        this.course = course;
        this.teacher = teacher;
        this.textContent = textContent;
        this.imgName = imgName;
        this.imgContent = imgContent;
        this.date = date;
    }

    public Note(int id, String title, String textContent) {
        this.id = id;
        this.title = title;
        this.textContent = textContent;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public byte[] getImgContent() {
        return imgContent;
    }

    public void setImgContent(byte[] imgContent) {
        this.imgContent = imgContent;
    }

    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

//    public Date getDate() {
//        return date;
//    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            this.date = format.parse(date);
        } catch (ParseException e) {
            this.date = null;
        }
    }
}
