package com.colin.bean;

public class Reply
{
    private int fId;
    private int sId;
    private int tId;
    private User user;
    private Teacher teacher;
    private String message;

    public Reply()
    {
    }

    public Reply(int fId, int sId, int tId, User user, Teacher teacher, String message)
    {
        this.fId = fId;
        this.sId = sId;
        this.tId = tId;
        this.user = user;
        this.teacher = teacher;
        this.message = message;
    }

    public int getsId()
    {
        return sId;
    }

    public void setsId(int sId)
    {
        this.sId = sId;
    }

    public int gettId()
    {
        return tId;
    }

    public void settId(int tId)
    {
        this.tId = tId;
    }

    public int getfId()
    {
        return fId;
    }

    public void setfId(int fId)
    {
        this.fId = fId;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "Reply{" +
                "fId=" + fId +
                ", user=" + user +
                ", teacher=" + teacher +
                ", message='" + message + '\'' +
                '}';
    }
}
