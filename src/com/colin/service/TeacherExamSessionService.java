package com.colin.service;

import com.colin.bean.TeacherExamSession;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherExamSessionService {
    TeacherExamSession selectById(int id);

    void updateValueByTId(int gettId);

    void updateEqual(int id);

    void insert(int id);
}
