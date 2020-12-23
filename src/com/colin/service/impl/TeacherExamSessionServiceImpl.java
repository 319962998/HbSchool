package com.colin.service.impl;

import com.colin.bean.TeacherExamSession;
import com.colin.mapper.TeacherExamSessionMapper;
import com.colin.service.TeacherExamSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherExamSessionServiceImpl implements TeacherExamSessionService {
    @Autowired
    TeacherExamSessionMapper teacherExamSessionMapper;

    @Override
    public TeacherExamSession selectById(int id) {
        return teacherExamSessionMapper.selectById(id);
    }

    @Override
    public void updateValueByTId(int gettId) {
        TeacherExamSession teacherExamSession = teacherExamSessionMapper.selectById(gettId);
        teacherExamSessionMapper.updateValueByTId(gettId,teacherExamSession.getValue()+1);
    }

    @Override
    public void updateEqual(int id) {
        TeacherExamSession teacherExamSession = teacherExamSessionMapper.selectById(id);
        teacherExamSessionMapper.updateEqual(id,teacherExamSession.getValue());
    }

    @Override
    public void insert(int id) {
        teacherExamSessionMapper.insert(id);
    }
}
