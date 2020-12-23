package com.colin.service.impl;

import com.colin.bean.Course;
import com.colin.mapper.CourseMapper;
import com.colin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public List<Course> selectLimit(int i) {
        return courseMapper.selectLimit(i);
    }

    @Override
    public int selectCount() {
        return courseMapper.selectCount();
    }

    @Override
    public Course selectById(Integer cId) {
        return courseMapper.selectById(cId);
    }

    @Override
    public List<Course> selectByName(String cName) {
        return courseMapper.selectByName(cName);
    }

    @Override
    public List<Course> selectByTname(String tName) {
        return courseMapper.selectByTname(tName);
    }

    @Override
    public int selectByTnameCount(String tName) {
        return courseMapper.selectByTnameCount(tName);
    }

    @Override
    public List<Course> selectByTnameLimit(String tName,int i) {
        return courseMapper.selectByTnameLimit(tName,i);
    }

    @Override
    public void updateTotalClassById(int id,int totalClass) {
        courseMapper.updateTotalClass(id,totalClass);
    }

    @Override
    public void updatePayClass(Integer leaveCourseid, int payClass) {
        courseMapper.updatePayClass(leaveCourseid,payClass);
    }

    @Override
    public void deleteById(Integer id) {
        courseMapper.deleteById(id);
    }
    @Override
    public void insertCourse(String name, String tName, String tId, String sPay, String tPay, String time)
    {
        courseMapper.insertCourse(name,tName,tId,sPay,tPay,time);
    }
    @Override
    public void updateWithoutPayAndTotalById(int upCourse_id, String upCourseName, String upCourseT_name, int upCourseS_pay, int upCourseT_pay, String upCourseTime)
    {
        courseMapper.updateWithoutPayAndTotalById(upCourse_id,upCourseName,upCourseT_name,upCourseS_pay,upCourseT_pay,upCourseTime);
    }



    @Override
    public List<Course> selectCourseNameByNoteCId(int id) {
        return courseMapper.selectCourseNameByNoteCId(id);
    }

    @Override
    public List<Course> selectByTId(int id) {
        return courseMapper.selectByTId(id);
    }

    @Override
    public List<Course> selectBySId(int id) {
        return courseMapper.selectBySId(id);
    }

    @Override
    public List<Course> selectBySIdLimit(int id, int i) {
        return courseMapper.selectBySIdLimit(id,i);
    }

    @Override
    public List<Course> selectByTIdLimit(int id, int i) {
        return courseMapper.selectByTIdLimit(id,i);
    }
}
