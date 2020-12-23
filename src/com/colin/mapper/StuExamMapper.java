package com.colin.mapper;

import com.colin.bean.StuExam;

public interface StuExamMapper {
    void insert(int eId, int id, int pId, String answer,String name,byte[] bytes);

    StuExam selectByEIdAndPId(int eId, int pId);

    void updateAnswerByEIdAndPId(int eId, int pId, String answer,String name,byte[] bytes);

    void updateAnswerByEIdAndPIdWithoutAddress(int eId, int pId, String answer);

    StuExam selectByEIdAndPIdAndSId(int eId, int pId, int id);
}
