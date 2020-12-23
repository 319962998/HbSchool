package com.colin.service.impl;

import com.colin.bean.Relition;
import com.colin.mapper.RelitionMapper;
import com.colin.service.RelitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelitionServiceImpl implements RelitionService {
    @Autowired
    RelitionMapper relitionMapper;
    @Override
    public void insert(int id, String name, int id1, String sName)
    {
        relitionMapper.insert(id,name,id1,sName);
    }



    @Override
    public void deleteById(int id, int upCourse_id)
    {
        relitionMapper.deleteById(id,upCourse_id);
    }

    @Override
    public List<Relition> selectBySId(int id) {
        return relitionMapper.selectBySId(id);
    }

    @Override
    public List<Relition> selectBycId(Integer leaveCourseid) {
        return relitionMapper.selectBycId(leaveCourseid);
    }
}
