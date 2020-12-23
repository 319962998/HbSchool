package com.colin.mapper;

import com.colin.bean.Reply;

import java.util.List;

public interface ReplyMapper
{
    List<Reply> selectByFId(int id);

    void insertReplyUser(Integer fId, int id, String message);

    void insertReplyTeacher(Integer fId, int id, String message);
}
