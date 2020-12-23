package com.colin.service.impl;

import com.colin.bean.TeaViewExam;
import com.colin.mapper.CourseMapper;
import com.colin.mapper.TeaViewExamMapper;
import com.colin.service.TeaViewExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaViewExamServiceImpl implements TeaViewExamService {
    @Autowired
    TeaViewExamMapper teaViewExamMapper;
    @Autowired
    CourseMapper courseMapper;
    @Override
    public void insert(int eId, String cName, String eName, String sName, String time, String last, String s) {
        teaViewExamMapper.insert(eId,cName,eName,sName,time,last,s);
    }

    @Override
    public List<TeaViewExam> selectByTId(int id) {
        return teaViewExamMapper.selectByTId(id);
    }

    @Override
    public List<TeaViewExam> selectByTIdLimit(int id, int i) {
        return teaViewExamMapper.selectByTIdLimit(id,i);
    }

    @Override
    public List<TeaViewExam> selectByEIdAndSName(Integer eId, String sName) {
        return teaViewExamMapper.selectByEIdAndSName(eId,sName);
    }

    @Override
    public List<TeaViewExam> selectByEIdAndSNameLimit(Integer eId, String sName, int i) {
        return teaViewExamMapper.selectByEIdAndSNameLimit(eId,sName,i);
    }

    @Override
    public List<TeaViewExam> selectByEIdAndCId(Integer eId, Integer cId) {
        String name = courseMapper.selectById(cId).getName();
        return teaViewExamMapper.selectByEIdAndCName(eId,name);
    }

    @Override
    public List<TeaViewExam> selectByEIdAndCIdLimit(Integer eId, Integer cId, int i) {
        String name = courseMapper.selectById(cId).getName();
        return teaViewExamMapper.selectByEIdAndCNameLimit(eId,name,i);
    }

    @Override
    public List<TeaViewExam> selectByEId(Integer eId) {
        return teaViewExamMapper.selectByEId(eId);
    }

    @Override
    public List<TeaViewExam> selectByEIdLimit(Integer eId, int i) {
        return teaViewExamMapper.selectByEIdLimit(eId,i);
    }

    @Override
    public List<TeaViewExam> selectBySName(String sName) {
        return teaViewExamMapper.selectBySName(sName);
    }

    @Override
    public List<TeaViewExam> selectBySNameAndTId(String sName, int id) {
        return teaViewExamMapper.selectBySNameAndTId(sName,id);
    }

    @Override
    public List<TeaViewExam> selectBySNameAndTIdLimit(String sName, int id, int i) {
        return teaViewExamMapper.selectBySNameAndTIdLimit(sName,id,i);
    }

    @Override
    public List<TeaViewExam> selectByCName(String cName) {
        return teaViewExamMapper.selectByCName(cName);
    }

    @Override
    public List<TeaViewExam> selectByCNameLimit(String cName, int i) {
        return teaViewExamMapper.selectByCNameLimit(cName,i);
    }

    @Override
    public void updateSubmit(Integer eId, String sName, String score) {
        teaViewExamMapper.updateSubmit(eId,sName,score);
    }
}
