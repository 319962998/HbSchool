package com.colin.mapper;

import com.colin.bean.LayExam;
import com.colin.bean.SubmitExam;

import java.util.List;

public interface SubmitExamMapper {
    SubmitExam selectByEIdAndSId(int geteId, int id);

    void insertSubmit(int eId, int id, String submit,String time);

    List<SubmitExam> selectByTId(int id);

    void updateSubmit(Integer eId, int id, String submit);

}
