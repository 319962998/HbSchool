package com.colin.service;

import com.colin.bean.TeaViewExam;

import java.util.List;

public interface TeaViewExamService {
    void insert(int eId, String cName, String eName, String sName, String time, String last, String s);

    List<TeaViewExam> selectByTId(int id);

    List<TeaViewExam> selectByTIdLimit(int id, int i);

    List<TeaViewExam> selectByEIdAndSName(Integer eId, String sName);

    List<TeaViewExam> selectByEIdAndSNameLimit(Integer eId, String sName, int i);

    List<TeaViewExam> selectByEIdAndCId(Integer eId, Integer cId);

    List<TeaViewExam> selectByEIdAndCIdLimit(Integer eId, Integer cId, int i);

    List<TeaViewExam> selectByEId(Integer eId);

    List<TeaViewExam> selectByEIdLimit(Integer eId, int i);

    List<TeaViewExam> selectBySName(String sName);

    List<TeaViewExam> selectBySNameAndTId(String sName, int id);

    List<TeaViewExam> selectBySNameAndTIdLimit(String sName, int id, int i);

    List<TeaViewExam> selectByCName(String cName);

    List<TeaViewExam> selectByCNameLimit(String cName, int i);

    void updateSubmit(Integer eId, String sName, String score);
}
