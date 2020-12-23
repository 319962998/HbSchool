package com.colin.service;

import com.colin.bean.Relition;

import java.util.List;

public interface RelitionService {
    List<Relition> selectBycId(Integer leaveCourseid);
    void insert(int id, String name, int id1, String sName);

    void deleteById(int id, int upCourse_id);

    List<Relition> selectBySId(int id);
}
