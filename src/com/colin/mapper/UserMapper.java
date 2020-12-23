package com.colin.mapper;

import com.colin.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();

    void deleteUser(int i);

    User selectById(int id);

    void updateTuitionById(int id,int tuition);

    List<User> selectByName(String pname);

    User selectByNameAndPassword(String name, String password);

    List<Integer> selectByCidAndTid(int id);

    void insert(String name, String password, String grade, String school, String phone, String note);
    void updateById(int id, String password, String phone, String note);

    List<User> selectLimit(int i);

    List<User> selectLimitByName(String name, int i);

    void updateExceptId(Integer id, String name, String password, String grade, String school, String phone, String note, Integer tuition);
}
