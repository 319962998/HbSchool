package com.colin.service.impl;

import com.colin.mapper.NoteSessionMapper;
import com.colin.service.NoteSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteSessionServiceImpl implements NoteSessionService {

    @Autowired
    NoteSessionMapper noteSessionMapper;

    @Override
    public void insert(Integer id, int id1) {
        noteSessionMapper.insert(id, id1);
    }

    @Override
    public Integer selectCountBySId(int id) {
        return noteSessionMapper.selectCountBySId(id);
    }

    @Override
    public void deleteBySIdAndNId(int userId, Integer nId) {
        noteSessionMapper.deleteBySIdAndNId(userId, nId);
    }
}
