package com.colin.service.impl;

import com.colin.bean.LayExam;
import com.colin.bean.SubmitExam;
import com.colin.mapper.SubmitExamMapper;
import com.colin.service.SubmitExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class SubmitExamServiceImpl implements SubmitExamService {
    @Autowired
    SubmitExamMapper submitExamMapper;

    @Override
    public SubmitExam selectByEIdAndSId(int geteId, int id) {
        return submitExamMapper.selectByEIdAndSId(geteId,id);
    }

    @Override
    public void insertSubmit(int eId, int id, String submit,String time) {
        submitExamMapper.insertSubmit(eId,id,submit,time);
    }

    @Override
    public List<SubmitExam> selectByTid(int id) {
        return submitExamMapper.selectByTId(id);
    }

    @Override
    public void updateSubmit(Integer eId, int id, String submit) {
        submitExamMapper.updateSubmit(eId,id,submit);
    }
}
