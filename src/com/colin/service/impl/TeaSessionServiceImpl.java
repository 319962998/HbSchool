package com.colin.service.impl;

import com.colin.bean.Teacher;
import com.colin.bean.TeacherExamSession;
import com.colin.service.ForumNumberService;
import com.colin.service.TeaSessionService;
import com.colin.service.TeacherExamSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class TeaSessionServiceImpl implements TeaSessionService {
    @Autowired
    ForumNumberService forumNumberService;
    @Autowired
    TeacherExamSessionService teacherExamSessionService;
    @Override
    public int init(HttpSession session)
    {
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (teacher==null)
            return -1;
        int numberId=forumNumberService.selectById();
        int numberTId=forumNumberService.selectByTId(teacher.getId());
        int forumCount=numberId-numberTId;
        session.setAttribute("forumCount",forumCount);
        TeacherExamSession teacherExamSession = teacherExamSessionService.selectById(teacher.getId());
        session.setAttribute("teaExamCount",teacherExamSession.getValue()-teacherExamSession.getAlready());
        return 1;
    }

    @Override
    public void logOut(HttpSession session) {
        session.removeAttribute("sessionTeacher");
        session.removeAttribute("sessionUser");
        session.removeAttribute("forumCount");
        session.removeAttribute("teaExamCount");
    }
}
