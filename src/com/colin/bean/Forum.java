package com.colin.bean;

public class Forum
{
    private int id;
    private int sId;
    private int tId;
    private User user;
    private Teacher teacher;
    private String title;
    private String problem;
    private String updateTime;
    private String imgName;
    private byte[] imgContent;

    public Forum()
    {
    }

    public Forum(int id, int sId, int tId, User user, Teacher teacher, String title, String problem, String updateTime, String imgName, byte[] imgContent)
    {
        this.id = id;
        this.sId = sId;
        this.tId = tId;
        this.user = user;
        this.teacher = teacher;
        this.title = title;
        this.problem = problem;
        this.updateTime = updateTime;
        this.imgName = imgName;
        this.imgContent = imgContent;
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getProblem()
    {
        return problem;
    }

    public void setProblem(String problem)
    {
        this.problem = problem;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getImgName()
    {
        return imgName;
    }

    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }

    public byte[] getImgContent()
    {
        return imgContent;
    }

    public void setImgContent(byte[] imgContent)
    {
        this.imgContent = imgContent;
    }
}
