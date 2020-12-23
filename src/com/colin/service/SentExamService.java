package com.colin.service;

import com.colin.bean.SentExam;

import java.util.List;

public interface SentExamService {
    void insertExam(int eId, Integer cId, String name, String section, String begin, String last);

    List<SentExam> selectByCId(int id);

    SentExam selectByEId(int geteId);
}
