package com.colin.service;

import com.colin.bean.Teacher;

import java.util.List;

public interface TeacherService {
    void updateById(int id, String password, String phone, String note);
    List<Teacher> selectAll();

    Teacher selectById(int tId);

    void updateSalaryById(int tId, int salary);

    Teacher selectByNameAndPassword(String name, String password);

    void insertTeacher(String name, String password, String subject, String phone, String note);






    List<Teacher> selectByName(String name);

    void updateTeacher(Teacher teacher);

    List<Teacher> selectLimit(int i);

    List<Teacher> selectLimitByName(String name, int i);

    void updateExceptId(Integer id, String name, String password, String subject, String phone, String note, Integer salary);

}
