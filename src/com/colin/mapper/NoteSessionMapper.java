package com.colin.mapper;

public interface NoteSessionMapper {

    void insert(Integer id, int id1);

    Integer selectCountBySId(int id);

    void deleteBySIdAndNId(int userId, Integer nId);
}
