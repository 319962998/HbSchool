package com.colin.service.impl;

import com.colin.bean.*;
import com.colin.mapper.*;
import com.colin.service.NoteService;
import com.colin.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteMapper noteMapper;

    @Autowired
    RelitionMapper relitionMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    PageService pageService;

    @Override
    public boolean insertNote(Note note, MultipartFile file) {
        if(file == null) {
            note.setImgContent(null);
        }
        else {
            try {
                note.setImgContent(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int i = noteMapper.insertNote(note);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Note selectNoteByCidAndTid(int id, int id1, Date date) {
        return noteMapper.selectNoteByCidAndTid(id, id1, date);
    }

    @Override
    public Note selectNoteByCIDTID(int id, int id1) {
        return noteMapper.selectNoteByCidTid(id, id1);
    }

    @Override
    public List<Note> selectNoteByTid(int id,PageBean<Note> pageBean) {
        int totalCount = noteMapper.selectUserCount(id);
        pageBean.setTotalCount(totalCount);

        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);
        }else if(pageBean.getCurrentPage()>pageBean.getTotalPage()){
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
        int currentPage = pageBean.getCurrentPage();
        int offset = (currentPage - 1) * pageBean.getPageCount();
        int limit = pageBean.getPageCount();

        pageBean.setOffset(offset);
        pageBean.setLimit(limit);

        return noteMapper.selectNoteByTid(id,pageBean.getOffset(),pageBean.getLimit());
    }


    @Override
    public Map<Note, Boolean> selectByStudent(User user, int currentPage, int len) {
        Map<Note, Boolean> noteBooleanMap = new LinkedHashMap<>();


        List<Relition> relitions = relitionMapper.selectBySId(user.getId());  //拿到学生全部选课情况

        int noteCount = noteMapper.selectCountByByRelitions(relitions);

        //计算总页码
        int totalPage = pageService.getTotalPage(noteCount, len);

        // 校验页码
        currentPage = currentPage > totalPage ? totalPage : Math.max(currentPage, 1);

        //计算偏移量
        int offset = (currentPage - 1) * len;

        List<Note> notes = noteMapper.selectByRelitions(relitions, offset, len); //得到该学生选课的部分note


        if(notes != null && notes.size() != 0) {    //得到每一个笔记是否被该同学查看
            for(Note note : notes ) {
                //查询当前笔记是否已经被查看
                Integer nId = noteMapper.selectSessionBySIdAndNId(user.getId(), note.getId());

                Teacher teacher = teacherMapper.selectById(note.getTeacher().getId());
                note.setTeacher(teacher);
                Course course = courseMapper.selectById(note.getCourse().getId());
                note.setCourse(course);

                if(nId != null && nId == note.getId()) {
                    noteBooleanMap.put(note, false);  //未被查看
                }
                else {
                    noteBooleanMap.put(note, true);  //已经被查看
                }
            }
        }
        return noteBooleanMap;
    }

    @Override
    public Integer getTotalPage(User user, int len) {

        List<Relition> relitions = relitionMapper.selectBySId(user.getId());  //拿到学生全部选课情况

        int noteCount = noteMapper.selectCountByByRelitions(relitions);

        return  pageService.getTotalPage(noteCount, len);
    }

    @Override
    public Note selectById(Integer id) {
       Note note = noteMapper.selectById(id);

       Teacher teacher = teacherMapper.selectById(note.getTeacher().getId());
       Course course = courseMapper.selectById(note.getCourse().getId());

       note.setCourse(course);
       note.setTeacher(teacher);

       return note;
    }

    @Override
    public void deleteNoteById(Integer noteId) {
        noteMapper.deleteNoteById(noteId);
    }

    @Override
    public void updateNote(Integer id, String title, String content, Date date) {
        noteMapper.updateNote(id, title, content, date);
    }

    @Override
    public void updateNoteAll(Integer id, String title, String content, String name, byte[] bytes, Date date) {
        noteMapper.updatenoteAll(id, title, content, name, bytes, date);
    }

}
