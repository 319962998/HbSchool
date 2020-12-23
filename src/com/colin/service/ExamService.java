package com.colin.service;

import com.colin.bean.Exam;

import java.util.List;

public interface ExamService {
    void insertExam(int id, String name, String section);

    int selectCount(int tId);

    List<Exam> selectLimit(int i,int tId);

    Exam selectById(Integer id);

    List<Exam> selectByName(String name, int tId);

    List<Exam> selectLimitByName(String name, int i, int tId);

    void deleteById(Integer id);
}
