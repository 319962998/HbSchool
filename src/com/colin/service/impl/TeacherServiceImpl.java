package com.colin.service.impl;

import com.colin.bean.Teacher;
import com.colin.mapper.TeacherMapper;
import com.colin.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public List<Teacher> selectAll() {

        return teacherMapper.selectAll();
    }

    @Override
    public Teacher selectById(int tId) {
        return teacherMapper.selectById(tId);
    }

    @Override
    public void updateSalaryById(int tId, int salary) {
        teacherMapper.updateSalaryById(tId,salary);
    }

    @Override
    public Teacher selectByNameAndPassword(String name, String password) {
        return teacherMapper.selectByNameAndPassword(name,password);
    }
    @Override
    public void insertTeacher(String name, String password, String subject, String phone, String note)
    {
        teacherMapper.insertTeacher(name,password,subject,phone,note);
    }


    @Override
    public void updateById(int id, String password, String phone, String note)
    {
        teacherMapper.updateById(id,password,phone,note);
    }


    @Override
    public List<Teacher> selectByName(String name) {
        return teacherMapper.selectByName(name);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> selectLimit(int i) {
        return teacherMapper.selectLimit(i);
    }

    @Override
    public List<Teacher> selectLimitByName(String name, int i) {
        return teacherMapper.selectLimitByName(name,i);
    }

    @Override
    public void updateExceptId(Integer id, String name, String password, String subject, String phone, String note, Integer salary) {
        teacherMapper.updateExceptId(id,name,password,subject,phone,note,salary);
    }
}
