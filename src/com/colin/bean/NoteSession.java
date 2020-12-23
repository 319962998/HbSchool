package com.colin.bean;

public class NoteSession {
    private Integer sId;
    private Integer nId;

    public NoteSession() {
    }

    public NoteSession(Integer sId, Integer nId) {
        this.sId = sId;
        this.nId = nId;
    }

    @Override
    public String toString() {
        return "NoteSession{" + "sId=" + sId + ", nId=" + nId + '}';
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }
}
