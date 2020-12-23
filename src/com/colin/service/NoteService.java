package com.colin.service;

import com.colin.bean.Note;
import com.colin.bean.PageBean;

import com.colin.bean.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NoteService {
    boolean insertNote(Note note, MultipartFile file);

    Note selectNoteByCidAndTid(int id, int id1, Date date);

    Note selectNoteByCIDTID(int id, int id1);

    List<Note> selectNoteByTid(int id, PageBean<Note> pageBean);


    /**
     * @param user 当前登录学生
     * @param currentPage 当前页
     * @param len 长度
     * @return boolean数据代表当前用户是否已查看这条数据 true代表已查看， false代表未查看
     *          拿到这个学生关联的学科所有的笔记，以及是否已经查看
     */
    Map<Note, Boolean> selectByStudent(User user, int currentPage, int len);

    Integer getTotalPage(User user, int len);

    Note selectById(Integer id);

    void deleteNoteById(Integer noteId);

    void updateNote(Integer id, String title, String content, Date date);

    void updateNoteAll(Integer id, String title, String content, String name, byte[] bytes, Date date);
}
