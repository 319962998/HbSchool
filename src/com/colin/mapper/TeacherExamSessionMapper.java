package com.colin.mapper;

import com.colin.bean.TeacherExamSession;

import java.util.List;

public interface TeacherExamSessionMapper {
    TeacherExamSession selectById(int id);

    void updateValueByTId(int gettId, int i);

    void updateEqual(int id, int value);

    void insert(int id);
}
