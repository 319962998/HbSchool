package com.colin.service.impl;

import com.colin.bean.Exam;
import com.colin.mapper.ExamMapper;
import com.colin.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamMapper examMapper;

    @Override
    public void insertExam(int id, String name, String section) {
        examMapper.insertExam(id,name,section);
    }

    @Override
    public int selectCount(int tId) {
        return examMapper.selectCount(tId);
    }

    @Override
    public List<Exam> selectLimit(int i,int tId) {
        return examMapper.selectLimit(i,tId);
    }

    @Override
    public Exam selectById(Integer id) {
        return examMapper.selectById(id);
    }

    @Override
    public List<Exam> selectByName(String name, int tId) {
        return examMapper.selectByName(name,tId);
    }

    @Override
    public List<Exam> selectLimitByName(String name, int i, int tId) {
        return examMapper.selectLimitByName(name,i,tId);
    }

    @Override
    public void deleteById(Integer id) {
        examMapper.deleteById(id);
    }
}
