package com.colin.service.impl;

import com.colin.bean.User;
import com.colin.mapper.UserMapper;
import com.colin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public void deleteUser(int i) {
        userMapper.deleteUser(i);
    }

    @Override
    public User selectById(int sId) {
        return userMapper.selectById(sId);
    }

    @Override
    public void updateTuitionById(int id,int tuition) {
        userMapper.updateTuitionById(id,tuition);
    }

    @Override
    public List<User> selectByName(String pname) {
        return userMapper.selectByName(pname);
    }

    @Override
    public User selectByNameAndPassword(String name, String password) {
        return userMapper.selectByNameAndPassword(name,password);
    }

    @Override
    public void insertUser(String name, String password, String grade, String school, String phone, String note)
    {
        userMapper.insert(name,password,grade,school,phone,note);
    }


    @Override
    public List<User> selectLimit(int i) {
        return userMapper.selectLimit(i);
    }

    @Override
    public List<User> selectLimitByName(String name, int i) {
        return userMapper.selectLimitByName(name,i);
    }

    @Override
    public void updateExceptId(Integer id, String name, String password, String grade, String school, String phone, String note, Integer tuition) {
        userMapper.updateExceptId(id,name,password,grade,school,phone,note,tuition);
    }

    @Override
    public List<Integer> selectByCidAndTid(int id) {
        return userMapper.selectByCidAndTid(id);
    }

    @Override
    public void updateById(int id, String password, String phone, String note)
    {
        userMapper.updateById(id,password,phone,note);
    }

}
