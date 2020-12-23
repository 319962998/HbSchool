package com.colin.service.impl;

import com.colin.bean.Reply;
import com.colin.mapper.ReplyMapper;
import com.colin.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService
{
    @Autowired
    ReplyMapper replyMapper;

    @Override
    public List<Reply> selectByFId(int id)
    {
        return replyMapper.selectByFId(id);
    }

    @Override
    public void insertReplyUser(Integer fId, int id, String message)
    {
        replyMapper.insertReplyUser(fId,id,message);
    }

    @Override
    public void insertReplyTeacher(Integer fId, int id, String message)
    {
        replyMapper.insertReplyTeacher(fId,id,message);
    }
}
