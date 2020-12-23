package com.colin.bean;


public class ForumNumber
{
    private int id;
    private int sId;
    private int tId;
    private int number;

    public ForumNumber()
    {
    }

    public ForumNumber(int id, int sId, int tId, int number)
    {
        this.id = id;
        this.sId = sId;
        this.tId = tId;
        this.number = number;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "ForumNumber{" +
                "id=" + id +
                ", sId=" + sId +
                ", tId=" + tId +
                ", number=" + number +
                '}';
    }
}
