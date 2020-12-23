package com.colin.service;

import com.colin.bean.User;

import java.util.List;


public interface UserService {
    List<User> selectAll();

    void deleteUser(int i);

    User selectById(int sId);

    void updateTuitionById(int id,int tuition);

    List<User> selectByName(String pname);

    User selectByNameAndPassword(String name, String password);

    void insertUser(String name, String password, String grade, String school, String phone, String note);


    List<Integer> selectByCidAndTid(int id);

    void updateById(int id, String password, String phone, String note);

    List<User> selectLimit(int i);

    List<User> selectLimitByName(String name, int i);

    void updateExceptId(Integer id, String name, String password, String grade, String school, String phone, String note, Integer tuition);
}
