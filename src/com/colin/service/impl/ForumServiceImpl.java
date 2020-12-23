package com.colin.service.impl;

import com.colin.bean.Forum;
import com.colin.bean.PageBean;
import com.colin.mapper.ForumMapper;
import com.colin.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService
{
    @Autowired
    ForumMapper forumMapper;

    @Override
    public List<Forum> selectForumByPage(PageBean<Forum> pageBean)
    {
        int totalCount = forumMapper.selectForumCount();
        pageBean.setTotalCount(totalCount);

        if (pageBean.getCurrentPage() <= 0)
        {
            pageBean.setCurrentPage(1);
        }
        else if (pageBean.getCurrentPage() > pageBean.getTotalPage())
        {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        int currentPage = pageBean.getCurrentPage();
        int offset = (currentPage - 1) * pageBean.getPageCount();
        int limit = pageBean.getPageCount();

        pageBean.setOffset(offset);
        pageBean.setLimit(limit);
        return forumMapper.selectForumByPage(pageBean);
    }


    @Override
    public Forum selectForumById(int id)
    {
        return forumMapper.selectForumById(id);
    }

    @Override
    public List<Forum> selectForumByPageAndSId(PageBean<Forum> pageBean, int id)
    {
        int totalCount = forumMapper.selectForumCount();
        pageBean.setTotalCount(totalCount);

        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        int currentPage = pageBean.getCurrentPage();
        int offset = (currentPage - 1) * pageBean.getPageCount();
        int limit = pageBean.getPageCount();

        return forumMapper.selectForumByPageAndSId(pageBean,id,offset,limit);
    }

    @Override
    public List<Forum> selectForumByPageAndTId(PageBean<Forum> pageBean, int id)
    {
        int totalCount = forumMapper.selectForumCount();
        pageBean.setTotalCount(totalCount);

        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        } else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }

        int currentPage = pageBean.getCurrentPage();
        int offset = (currentPage - 1) * pageBean.getPageCount();
        int limit = pageBean.getPageCount();

        return forumMapper.selectForumByPageAndTId(pageBean,id,offset,limit);
    }

    @Override
    public void insertUserForum(int id, String title, String problem, String name, byte[] bytes, MultipartFile file)
    {
        if (file==null)
        {
            bytes=null;
        }
        else
        {
            try
            {
                bytes=file.getBytes();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        forumMapper.insertUserForum(id,title,problem,name,bytes);
    }

    @Override
    public void insertTeacherForum(int id, String title, String problem, String name, byte[] bytes, MultipartFile file)
    {
        if (file==null)
        {
            bytes=null;
        }
        else
        {
            try
            {
                bytes=file.getBytes();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        forumMapper.insertTeacherForum(id,title,problem,name,bytes);
    }
}
