package com.colin.mapper;

import com.colin.bean.Problem;

import java.util.List;

public interface ProblemMapper {

    void insertChoose(int tId, String title, String context, String a, String b, String c, String d, String answer);

    void insertWrite(int id, String title, String context, String answer);

    int selectCount(int tId);

    List<Problem> selectLimit(int i,int tId);

    Problem selectById(Integer id);

    List<Problem> selectByTitle(String title,int tId);

    List<Problem> selectLimitByTitle(String title, int i,int tId);

    void updateChoose(Integer id, String title, String context, String a, String b, String c, String d, String choice);

    void updateWrite(Integer id, String title, String context, String answer);

    void deleteById(Integer id);
}
