package com.colin.service.impl;

import com.colin.bean.StuExam;
import com.colin.mapper.StuExamMapper;
import com.colin.service.StuExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuExamServiceImpl implements StuExamService {
    @Autowired
    StuExamMapper stuExamMapper;

    @Override
    public void insert(int eId, int id, int pId, String answer,String name,byte[] bytes) {
        stuExamMapper.insert(eId,id,pId,answer,name,bytes);
    }

    @Override
    public StuExam selectByEIdAndPId(int eId, int pId) {
        return stuExamMapper.selectByEIdAndPId(eId,pId);
    }

    @Override
    public void updateAnswerByEIdAndPId(int eId, int pId, String answer,String name,byte[] bytes) {
        stuExamMapper.updateAnswerByEIdAndPId(eId,pId,answer,name,bytes);
    }

    @Override
    public void updateAnswerByEIdAndPIdWithoutAddress(int eId, int pId, String answer) {
        stuExamMapper.updateAnswerByEIdAndPIdWithoutAddress(eId,pId,answer);
    }

    @Override
    public StuExam selectByEIdAndPIdAndSId(int eId, int pId, int id) {
        return stuExamMapper.selectByEIdAndPIdAndSId(eId,pId,id);
    }
}
