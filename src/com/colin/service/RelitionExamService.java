package com.colin.service;

import com.colin.bean.RelitionExam;

import java.util.List;

public interface RelitionExamService {
    void insert(int eId, Integer id);

    List<RelitionExam> selectByEId(int eId);

    void deleteByEIdAndPId(int eId, int id);
}
