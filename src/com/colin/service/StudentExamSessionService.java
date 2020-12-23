package com.colin.service;

import com.colin.bean.StudentExamSession;

public interface StudentExamSessionService {
    void updateValueById(int getsId);

    void updateEqual(int id);

    StudentExamSession selectById(int id);

    void insert(int id);
}
