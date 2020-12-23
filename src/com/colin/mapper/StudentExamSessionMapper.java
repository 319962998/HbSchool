package com.colin.mapper;

import com.colin.bean.StudentExamSession;

public interface StudentExamSessionMapper {
    StudentExamSession selectById(int getsId);

    void updateValueById(int getsId, int i);

    void updateEqual(int id, int value);

    void insert(int id);
}
