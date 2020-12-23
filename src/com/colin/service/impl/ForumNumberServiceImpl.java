package com.colin.service.impl;

import com.colin.bean.ForumNumber;
import com.colin.mapper.ForumNumberMapper;
import com.colin.service.ForumNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumNumberServiceImpl implements ForumNumberService
{
    @Autowired
    ForumNumberMapper forumNumberMapper;
    @Override
    public int selectById()
    {
        return forumNumberMapper.selectById();
    }

    @Override
    public int selectBySId(int id)
    {
        return forumNumberMapper.selectBySId(id);
    }

    @Override
    public void updateBySId(int id, int numberId)
    {
        forumNumberMapper.updateBySId(id,numberId);
    }

    @Override
    public int selectByTId(int id)
    {
        return forumNumberMapper.selectByTId(id);
    }

    @Override
    public void updateByTId(int id, int numberId)
    {
        forumNumberMapper.updateByTId(id,numberId);
    }

    @Override
    public void updateForumNumberId(int i)
    {
        forumNumberMapper.updateForumNumberId(i);
    }

    @Override
    public ForumNumber selectForumNumberSId(int id)
    {
        return forumNumberMapper.selectForumNumberSId(id);
    }

    @Override
    public void insertSId(int id)
    {
        forumNumberMapper.insertSId(id);
    }

    @Override
    public void insertTId(int id)
    {
        forumNumberMapper.insertTId(id);
    }

    @Override
    public void updateForumNumberSId(int id, int i1)
    {
        forumNumberMapper.updateForumNumberSId(id,i1);
    }

    @Override
    public void updateForumNumberTId(int id, int i1)
    {
        forumNumberMapper.updateForumNumberTId(id,i1);
    }
}
