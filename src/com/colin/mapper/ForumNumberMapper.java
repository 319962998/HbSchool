package com.colin.mapper;

import com.colin.bean.ForumNumber;

public interface ForumNumberMapper
{
    int selectById();

    int selectBySId(int id);

    void updateBySId(int id, int numberId);

    int selectByTId(int id);

    void updateByTId(int id, int numberId);

    void updateForumNumberId(int i);

    ForumNumber selectForumNumberSId(int id);

    void insertSId(int id);

    void insertTId(int id);

    void updateForumNumberSId(int id, int i1);

    void updateForumNumberTId(int id, int i1);
}
