package com.colin.service;

public interface PageService {
    int getCurrentPage(int currentPage,int totalPage,String op);
    int getTotalPage(int size,int rule);
}
