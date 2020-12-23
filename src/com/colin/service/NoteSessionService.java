package com.colin.service;

public interface NoteSessionService {

    void insert(Integer id, int id1);

    Integer selectCountBySId(int id);

    void deleteBySIdAndNId(int userId, Integer nId);
}
