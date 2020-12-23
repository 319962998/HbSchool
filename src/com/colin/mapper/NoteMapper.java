package com.colin.mapper;

import com.colin.bean.Note;
import com.colin.bean.Relition;
import java.util.Date;
import java.util.List;

public interface NoteMapper {
    Integer insertNote(Note note);

    Note selectNoteByCidAndTid(int id, int id1, Date date);

    Note selectNoteByCidTid(int id, int id1);

    List<Note> selectNoteByTid(int id, int offset, int limit);

    List<Note> selectByRelitions(List<Relition> relitions, int offset, int len);

    Integer selectCountByByRelitions(List<Relition> relitions);

    Integer selectSessionBySIdAndNId(int s_id, int n_id);

    Note selectById(Integer id);

    void deleteNoteById(Integer noteId);

    int selectUserCount(int id);

    void updateNote(Integer id, String title, String content, Date date);

    void updatenoteAll(Integer id, String title, String content, String name, byte[] bytes, Date date);
}
