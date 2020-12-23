package com.colin.mapper;

import com.colin.bean.Forum;
import com.colin.bean.PageBean;

import java.util.List;

public interface ForumMapper
{
    int selectForumCount();

    List<Forum> selectForumByPage(PageBean<Forum> pageBean);

    void insertUserForum(int id, String title, String problem, String name, byte[] bytes);

    void insertTeacherForum(int id, String title, String problem, String name, byte[] bytes);

    Forum selectForumById(int id);

    List<Forum> selectForumByPageAndSId(PageBean<Forum> pageBean, int id, int offset, int limit);

    List<Forum> selectForumByPageAndTId(PageBean<Forum> pageBean, int id, int offset, int limit);
}
