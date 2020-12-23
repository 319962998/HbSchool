package com.colin.service.impl;

import com.colin.bean.StudentExamSession;
import com.colin.mapper.StudentExamSessionMapper;
import com.colin.service.StudentExamSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentExamSessionServiceImpl implements StudentExamSessionService {
    @Autowired
    StudentExamSessionMapper studentExamSessionMapper;

    @Override
    public void updateValueById(int getsId) {
        StudentExamSession studentExamSession = studentExamSessionMapper.selectById(getsId);
        studentExamSessionMapper.updateValueById(getsId,studentExamSession.getValue()+1);
    }

    @Override
    public void updateEqual(int id) {
        StudentExamSession studentExamSession = studentExamSessionMapper.selectById(id);
        studentExamSessionMapper.updateEqual(id,studentExamSession.getValue());
    }

    @Override
    public StudentExamSession selectById(int id) {
        return studentExamSessionMapper.selectById(id);
    }

    @Override
    public void insert(int id) {
        studentExamSessionMapper.insert(id);
    }
}
