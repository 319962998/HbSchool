package com.colin.service;

import com.colin.bean.Reply;

import java.util.List;

public interface ReplyService
{
    List<Reply> selectByFId(int id);

    void insertReplyUser(Integer fId, int id, String message);

    void insertReplyTeacher(Integer fId, int id, String message);
}
