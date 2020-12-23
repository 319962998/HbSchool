package com.colin.service.impl;

import com.colin.service.PageService;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl implements PageService {
    @Override
    public int getCurrentPage(int currentPage, int totalPage, String op) {
        if("1".equals(op))
        {
            currentPage=1;
        }
        if("2".equals(op))
        {
            currentPage--;
        }
        if("3".equals(op))
        {
            currentPage++;
        }
        if("4".equals(op))
        {
            currentPage=totalPage;
        }
        if(currentPage<=0)
        {
            currentPage=1;
        }
        if(currentPage>totalPage)
        {
            currentPage=totalPage;
        }
        return currentPage;
    }



    @Override
    public int getTotalPage(int size, int rule) {
        if (size==0)
            return 1;
        else if(size%rule==0)
        {
            return size/rule;
        }

        else
            return size/rule+1;
    }
}
