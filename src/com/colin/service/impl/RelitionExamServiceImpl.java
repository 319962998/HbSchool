package com.colin.service.impl;

import com.colin.bean.RelitionExam;
import com.colin.mapper.RelitionExamMapper;
import com.colin.service.RelitionExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelitionExamServiceImpl implements RelitionExamService {
    @Autowired
    RelitionExamMapper relitionExamMapper;
    @Override
    public void insert(int eId, Integer id) {
        relitionExamMapper.insert(eId,id);
    }

    @Override
    public List<RelitionExam> selectByEId(int eId) {
        return relitionExamMapper.selectByEId(eId);
    }

    @Override
    public void deleteByEIdAndPId(int eId, int id) {
        relitionExamMapper.deleteByEIdAndPId(eId,id);
    }
}
