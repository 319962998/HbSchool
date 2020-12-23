package com.colin.service.impl;

import com.colin.bean.StudentExamSession;
import com.colin.bean.User;
import com.colin.service.ForumNumberService;
import com.colin.service.NoteSessionService;
import com.colin.service.StuSessionService;
import com.colin.service.StudentExamSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class StuSessionServiceImpl implements StuSessionService {
    @Autowired
    NoteSessionService noteSessionService;
    @Autowired
    ForumNumberService forumNumberService;
    @Autowired
    StudentExamSessionService studentExamSessionService;
    @Override
    public int init(HttpSession session)
    {
        User user= (User) session.getAttribute("sessionUser");
        if(user==null)
        {
            return -1;
        }
        Integer noteCount = noteSessionService.selectCountBySId(user.getId());
        session.setAttribute("noteCount", noteCount);
        int numberId=forumNumberService.selectById();
        int numberSId=forumNumberService.selectBySId(user.getId());
        int forumCount=numberId-numberSId;
        session.setAttribute("forumCount",forumCount);
        StudentExamSession studentExamSession = studentExamSessionService.selectById(user.getId());
        session.setAttribute("stuExamCount",studentExamSession.getValue()-studentExamSession.getAlready());
        return 1;
    }

    @Override
    public void logOut(HttpSession session) {
        session.removeAttribute("sessionUser");
        session.removeAttribute("noteCount");
        session.removeAttribute("forumCount");
        session.removeAttribute("stuExamCount");
    }
}
