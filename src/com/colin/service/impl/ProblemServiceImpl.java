package com.colin.service.impl;

import com.colin.bean.Problem;
import com.colin.mapper.ProblemMapper;
import com.colin.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService{
    @Autowired
    ProblemMapper problemMapper;

    @Override
    public void insertChoose(int tId, String title, String context, String a, String b, String c, String d, String answer) {
        problemMapper.insertChoose(tId,title,context,a,b,c,d,answer);
    }

    @Override
    public void insertWrite(int id, String title, String context, String answer) {
        problemMapper.insertWrite(id,title,context,answer);
    }

    @Override
    public int selectCount(int tId) {
        return problemMapper.selectCount(tId);
    }

    @Override
    public List<Problem> selectLimit(int i,int tId) {
        return problemMapper.selectLimit(i,tId);
    }

    @Override
    public Problem selectById(Integer id) {
        return problemMapper.selectById(id);
    }

    @Override
    public List<Problem> selectByTitle(String title,int tId) {
        return problemMapper.selectByTitle(title,tId);
    }

    @Override
    public List<Problem> selectLimitByTitle(String title, int i,int tId) {
        return problemMapper.selectLimitByTitle(title,i,tId);
    }

    @Override
    public void updateChoose(Integer id, String title, String context, String a, String b, String c, String d, String choice) {
        problemMapper.updateChoose(id,title,context,a,b,c,d,choice);
    }

    @Override
    public void updateWrite(Integer id, String title, String context, String answer) {
        problemMapper.updateWrite(id,title,context,answer);
    }

    @Override
    public void deleteById(Integer id) {
        problemMapper.deleteById(id);
    }
}
