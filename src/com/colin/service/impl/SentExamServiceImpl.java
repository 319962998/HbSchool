package com.colin.service.impl;

import com.colin.bean.SentExam;
import com.colin.mapper.SentExamMapper;
import com.colin.service.SentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentExamServiceImpl implements SentExamService {
    @Autowired
    SentExamMapper sentExamMapper;

    @Override
    public void insertExam(int eId, Integer cId, String name, String section, String begin, String last) {
        sentExamMapper.insertExam(eId,cId,name,section,begin,last);
    }

    @Override
    public List<SentExam> selectByCId(int id) {
        return sentExamMapper.selectByCId(id);
    }

    @Override
    public SentExam selectByEId(int geteId) {
        return sentExamMapper.selectByEId(geteId);
    }
}
