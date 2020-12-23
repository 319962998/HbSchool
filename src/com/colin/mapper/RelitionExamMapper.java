package com.colin.mapper;

import com.colin.bean.RelitionExam;

import java.util.List;

public interface RelitionExamMapper {
    void insert(int eId, Integer id);

    List<RelitionExam> selectByEId(int eId);

    void deleteByEIdAndPId(int eId, int id);
}
