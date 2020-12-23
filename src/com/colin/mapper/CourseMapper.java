package com.colin.mapper;

import com.colin.bean.Course;

import java.util.List;

public interface CourseMapper {

   List<Course> selectAll();

   List<Course> selectLimit(int i);

   int selectCount();

   Course selectById(Integer cId);

   List<Course> selectByName(String cName);

   List<Course> selectByTname(String tName);

   int selectByTnameCount(String tName);

   List<Course> selectByTnameLimit(String tName,int i);

   void updateTotalClass(int id,int totalClass);

   void updatePayClass(Integer leaveCourseid, int payClass);

   void deleteById(Integer id);

   void insertCourse(String name, String tName, String tId, String sPay, String tPay, String time);

   void updateWithoutPayAndTotalById(int upCourse_id, String upCourseName, String upCourseT_name, int upCourseS_pay, int upCourseT_pay, String upCourseTime);



   List<Course> selectCourseNameByNoteCId(int id);

   List<Course> selectByTId(int id);

    List<Course> selectBySId(int id);

   List<Course> selectBySIdLimit(int id, int i);

   List<Course> selectByTIdLimit(int id, int i);
}
