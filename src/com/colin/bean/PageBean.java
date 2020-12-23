package com.colin.bean;

import java.util.List;

public class PageBean<T> {
    private int currentPage = 1;
    private int pageCount = 6;
    private int totalCount;
    private int totalPage;

    private List<T> list;

    private int offset;
    private int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageBean{" + "currentPage=" + currentPage + ", pageCount=" + pageCount + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", list=" + list + '}';
    }

    public int getCurrentPage() {
        if (currentPage<=0)
            return currentPage=1;
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
       // return totalPage = totalCount % pageCount == 0 ? totalCount / pageCount : totalCount / pageCount + 1;
        if(totalCount<=0)
            return totalPage=1;
        if(totalCount%pageCount==0)
            return totalCount/pageCount;
        else return totalCount/pageCount+1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageBean(int currentPage, int pageCount, int totalCount, int totalPage, List<T> list) {
        this.currentPage = currentPage;
        this.pageCount = pageCount;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
    }

    public PageBean() {
    }
}
