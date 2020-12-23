package com.colin.service;

import com.colin.bean.Forum;
import com.colin.bean.PageBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ForumService
{
    List<Forum> selectForumByPage(PageBean<Forum> pageBean);

    

    Forum selectForumById(int id);

    List<Forum> selectForumByPageAndSId(PageBean<Forum> pageBean, int id);

    List<Forum> selectForumByPageAndTId(PageBean<Forum> pageBean, int id);

    void insertUserForum(int id, String title, String problem, String name, byte[] bytes, MultipartFile file);

    void insertTeacherForum(int id, String title, String problem, String name, byte[] bytes, MultipartFile file);
}
