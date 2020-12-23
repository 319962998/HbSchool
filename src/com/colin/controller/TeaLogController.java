package com.colin.controller;

import com.colin.bean.*;
import com.colin.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tea")
@MultipartConfig
public class TeaLogController {
    @Autowired
    ForumNumberService forumNumberService;

    @Autowired
    ForumService forumService;

    @Autowired
    ReplyService replyService;
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    PageService pageService;
    @Autowired
    HistoryService historyService;
    @Autowired
    RelitionService relitionService;
    @Autowired
    ProblemService problemService;
    @Autowired
    ExamService examService;
    @Autowired
    RelitionExamService relitionExamService;
    @Autowired
    SentExamService sentExamService;
    @Autowired
    StuExamService stuExamService;
    @Autowired
    SubmitExamService submitExamService;
    @Autowired
    TeaViewExamService teaViewExamService;
    @Autowired
    TeaSessionService teaSessionService;
    @Autowired
    TeacherExamSessionService teacherExamSessionService;
    @Autowired
    StudentExamSessionService studentExamSessionService;
//静态方法




    @RequestMapping("opProblem")
    public String opProblem(Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int tId=teacher.getId();
        int count = problemService.selectCount(tId);
        int totalPage = pageService.getTotalPage(count, 5);
        List<Problem> list = problemService.selectLimit(0,tId);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        model.addAttribute("tap",1);
        return "bank";
    }
    @RequestMapping("createProblem")
    public String createProblem(HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        return "createProblem";
    }
    @RequestMapping("doCreateProblem")
    public String doCreateProblem(Integer op,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        if(op==1)
        {
            return "createChoose";
        }
        else
        {
            return "createWrite";
        }
    }
    @RequestMapping("doCreateChoose")
    public String doCreateChoose(String title, String context, String A, String B, String C, String D, String choice, HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        problemService.insertChoose(teacher.getId(),title,context,A,B,C,D,choice);
        return "createProblem";
    }
    @RequestMapping("doCreateWrite")
    public String doCreateWrite(String title,String context,String answer,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        problemService.insertWrite(teacher.getId(),title,context,answer);
        return "createProblem";
    }
    @RequestMapping("searchProblem")
    public String searchProblem(Integer id,String title,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        if(id!=null&&id!=0)
        {
            Problem problem = problemService.selectById(id);
            List<Problem> list=new ArrayList<>();
            list.add(problem);
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",1);
            model.addAttribute("list",list);
            model.addAttribute("tap",2);
            model.addAttribute("id",id);
            return "bank";
        }
        else if(title!=null&&!"".equals(title.trim()))
        {
            Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
            int tId=teacher.getId();
            List<Problem> problems = problemService.selectByTitle(title,tId);
            int totalPage=pageService.getTotalPage(problems.size(),5);
            List<Problem> list = problemService.selectLimitByTitle(title, 0,tId);
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",3);
            model.addAttribute("title",title);
            return "bank";
        }
        else return "forward:/tea/opProblem";
    }
    @RequestMapping("bankPage")
    public String bankPage(Integer currentPage,Integer totalPage,String op,Integer tap,Model model,Integer id,String title,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int tId=teacher.getId();
        if (tap==1)
        {
            int x=pageService.getCurrentPage(currentPage,totalPage,op);
            List<Problem> list = problemService.selectLimit((x - 1) * 5,tId);
            model.addAttribute("currentPage",x);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",1);
            return "bank";
        }
        else if (tap==2)
        {
//            Problem problem = problemService.selectById(id);
            return "forward:/tea/searchProblem";
//            List<Problem> list=new ArrayList<>();
//            list.add(problem);
//            model.addAttribute("currentPage",1);
//            model.addAttribute("totalPage",1);
//            model.addAttribute("list",list);
//            model.addAttribute("tap",2);
//            return "bank";
        }
        else
        {
            int x=pageService.getCurrentPage(currentPage,totalPage,op);
            List<Problem> list = problemService.selectLimitByTitle(title, (x - 1) * 5,tId);
            model.addAttribute("currentPage",x);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",3);
            model.addAttribute("title",title);
            return "bank";
        }


    }
    @RequestMapping("changeProblem")
    public String changeProblem(Integer id,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Problem problem = problemService.selectById(id);
        model.addAttribute("problem",problem);
        String kind=problem.getKind();
        if(kind.equals("选择题"))
        {

            return "changeChoose";
        }
        else
        {

            return "changeWrite";
        }
    }
    @RequestMapping("doChangeChoose")
    public String doChangdeChoose(HttpSession session,Integer id,String title,String context,String A,String B,String C,String D,String choice)
    {
        if (teaSessionService.init(session)==-1) return "login";
        problemService.updateChoose(id,title,context,A,B,C,D,choice);
        return "forward:/tea/opProblem";
    }
    @RequestMapping("doChangeWrite")
    public String doChangdeWrite(HttpSession session,Integer id,String title,String context,String answer)
    {
        if (teaSessionService.init(session)==-1) return "login";
        problemService.updateWrite(id,title,context,answer);
        return "forward:/tea/opProblem";
    }
    @RequestMapping("lookProblem")
    public String lookProblem(Integer id,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Problem problem = problemService.selectById(id);
        model.addAttribute("problem",problem);
        if (problem.getKind().equals("选择题"))
        {

            return "lookChoose";
        }
        else
        {
            return "lookWrite";
        }
    }
    @RequestMapping("deleteProblem")
    public String deleteProblem(Integer id,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        problemService.deleteById(id);
        return "forward:/tea/opProblem";
    }
    @RequestMapping("createExam")
    public String createExam(HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        return "createExam";
    }
    @RequestMapping("doCreateExam")
    public String doCreateExam(String name,String section,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        examService.insertExam(teacher.getId(),name,section);
        return "forward:/tea/exam";
    }

    @RequestMapping("exam")
    public String exam(Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int tId = teacher.getId();
        int count = examService.selectCount(tId);
        int totalPage = pageService.getTotalPage(count, 5);
        List<Exam> list = examService.selectLimit(0,tId);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        model.addAttribute("tap",1);

        return "exam";
    }
    @RequestMapping("searchExam")
    public String searchExam(Integer id,String name,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int tId=teacher.getId();
        if(id!=null&&id!=0)
        {
            List<Exam> list=new ArrayList<>();
            list.add(examService.selectById(id));
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",1);
            model.addAttribute("list",list);
            model.addAttribute("tap",2);
            model.addAttribute("id",id);
            return "exam";
        }
        else if(name!=null&&!"".equals(name.trim()))
        {
            List<Exam> list = examService.selectByName(name, tId);
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",1);
            model.addAttribute("list",list);
            model.addAttribute("tap",3);
            model.addAttribute("name",name);
            return "exam";
        }
        else
        {
            return "forward:/tea/exam";
        }
    }
    @RequestMapping("examPage")
    public String examPage(Integer currentPage,Integer totalPage,String op,Integer tap,Model model,Integer id,String name,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int tId=teacher.getId();
        if(tap==1)
        {
            int x=pageService.getCurrentPage(currentPage,totalPage,op);
            List<Exam> list = examService.selectLimit((x - 1) * 5, tId);
            model.addAttribute("currentPage",x);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",1);
            return "exam";
        }
        else if (tap==2)
        {
            return "forward:/tea/searchExam";
        }
        else
        {
            int x=pageService.getCurrentPage(currentPage,totalPage,op);
            //List<Problem> list = problemService.selectLimitByTitle(title, (x - 1) * 5,tId);
            List<Exam> list = examService.selectLimitByName(name, (x - 1) * 5, tId);
            model.addAttribute("currentPage",x);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",3);
            model.addAttribute("name",name);
            return "exam";
        }
    }
    @RequestMapping("insertExam")
    public String insertExam(Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int tId=teacher.getId();
        int count = problemService.selectCount(tId);
        int totalPage = pageService.getTotalPage(count, 5);
        List<Problem> list = problemService.selectLimit(0,tId);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        model.addAttribute("tap",1);
        return "insertExam";
    }
    @RequestMapping("searchInsertProblem")
    public String searchInsertProblem(Integer id,String title,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        if(id!=null&&id!=0)
        {
            Problem problem = problemService.selectById(id);
            List<Problem> list=new ArrayList<>();
            list.add(problem);
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",1);
            model.addAttribute("list",list);
            model.addAttribute("tap",2);
            model.addAttribute("id",id);
            return "insertExam";
        }
        else if(title!=null&&!"".equals(title.trim()))
        {
            Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
            int tId=teacher.getId();
            List<Problem> problems = problemService.selectByTitle(title,tId);
            int totalPage=pageService.getTotalPage(problems.size(),5);
            List<Problem> list = problemService.selectLimitByTitle(title, 0,tId);
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",3);
            model.addAttribute("title",title);
            return "insertExam";
        }
        else return "forward:/tea/insertExam";
    }
    @RequestMapping("insertExamPage")
    public String insertExamPage(Integer currentPage,Integer totalPage,String op,Integer tap,Model model,Integer id,String title,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int tId=teacher.getId();
        if (tap==1)
        {
            int x=pageService.getCurrentPage(currentPage,totalPage,op);
            List<Problem> list = problemService.selectLimit((x - 1) * 5,tId);
            model.addAttribute("currentPage",x);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",1);
            return "insertExam";
        }
        else if (tap==2)
        {

            return "forward:/tea/insertExam";

        }
        else
        {
            int x=pageService.getCurrentPage(currentPage,totalPage,op);
            List<Problem> list = problemService.selectLimitByTitle(title, (x - 1) * 5,tId);
            model.addAttribute("currentPage",x);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("list",list);
            model.addAttribute("tap",3);
            model.addAttribute("title",title);
            return "insertExam";
        }

    }
    @RequestMapping("doInsertExam")
    public String doIsertExam(Integer id,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        int eId= (int) session.getAttribute("eId");
        relitionExamService.insert(eId,id);
        return "forward:/tea/insertExam";
    }
    @RequestMapping("toInsertExam")
    public String toIsertExam(Integer id,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        session.setAttribute("eId",id);
        return "forward:/tea/insertExam";
    }
    @RequestMapping("toLookExam")
    public String toLookExam(Integer id,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        session.setAttribute("eId",id);
        return "forward:/tea/lookExam";
    }
   @RequestMapping("lookExam")
    public String lookExam(HttpSession session,Model  model)
   {
       if (teaSessionService.init(session)==-1) return "login";
       int eId= (int) session.getAttribute("eId");
       List<RelitionExam> relitionExams = relitionExamService.selectByEId(eId);
       List<Problem> list=new ArrayList<>();
       for (int i = 0; i < relitionExams.size(); i++) {
           Problem problem = problemService.selectById(relitionExams.get(i).getpId());
           list.add(problem);
       }
       model.addAttribute("list",list);
       return "lookExam";
   }
   @RequestMapping("deleteRelition")
    public String deleteRelition(int id,HttpSession session)
   {
       if (teaSessionService.init(session)==-1) return "login";
       int eId= (int) session.getAttribute("eId");
       relitionExamService.deleteByEIdAndPId(eId,id);
       return "forward:/tea/lookExam";
   }
    @RequestMapping("toSentExam")
    public String toSentExam(Integer id,HttpSession session)
    {

        if (teaSessionService.init(session)==-1) return "login";
        session.setAttribute("eId",id);
        return "publish";
    }
    @RequestMapping("sentExam")
    public String sentExam(HttpSession session,Integer cId,String begin,String last)
    {
        if (teaSessionService.init(session)==-1) return "login";
        int eId= (int) session.getAttribute("eId");
        Exam exam = examService.selectById(eId);
        sentExamService.insertExam(eId,cId,exam.getName(),exam.getSection(),begin,last);
        List<Relition> relitions = relitionService.selectBycId(cId);
        for (int i = 0; i < relitions.size(); i++) {
            studentExamSessionService.updateValueById(relitions.get(i).getsId());
        }
        return "forward:/tea/exam";
    }
    @RequestMapping("lookStuExam")
    public String lookStuExam(HttpSession session,Model model)
    {
        if (teaSessionService.init(session)==-1) return "login";
        session.removeAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        teacherExamSessionService.updateEqual(teacher.getId());
        session.setAttribute("teaExamCount",0);

        List<TeaViewExam> teaViewExams = teaViewExamService.selectByTId(teacher.getId());
        int totalPage = pageService.getTotalPage(teaViewExams.size(), 5);
        List<TeaViewExam> list = teaViewExamService.selectByTIdLimit(teacher.getId(), 0);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("tap",1);
        return "teaReadExam";
    }
    @RequestMapping("searchViewExam")
    public String searchViewExam(Model model, Integer eId1, String sName, Integer cId, HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if(eId1!=null&&eId1!=0)
        {
            if(sName!=null&&!"".equals(sName.trim()))
            {
                List<TeaViewExam> teaViewExams = teaViewExamService.selectByEIdAndSName(eId1, sName);
                int totalPage = pageService.getTotalPage(teaViewExams.size(), 5);
                List<TeaViewExam> list = teaViewExamService.selectByEIdAndSNameLimit(eId1, sName, 0);
                model.addAttribute("tap",2);
                model.addAttribute("list",list);
                model.addAttribute("currentPage",1);
                model.addAttribute("totalPage",totalPage);
                model.addAttribute("eId1",eId1);
                model.addAttribute("sName",sName);
                return "teaReadExam";
            }
            else if (cId!=null&&cId!=0)
            {
                List<TeaViewExam> teaViewExams = teaViewExamService.selectByEIdAndCId(eId1, cId);
                int totalPage = pageService.getTotalPage(teaViewExams.size(), 5);
                List<TeaViewExam> list = teaViewExamService.selectByEIdAndCIdLimit(eId1, cId, 0);
                model.addAttribute("tap",3);
                model.addAttribute("list",list);
                model.addAttribute("currentPage",1);
                model.addAttribute("totalPage",totalPage);
                model.addAttribute("eId1",eId1);
                model.addAttribute("cId",cId);
                return "teaReadExam";
            }
            else
            {
                List<TeaViewExam> teaViewExams = teaViewExamService.selectByEId(eId1);
                int totalPage = pageService.getTotalPage(teaViewExams.size(), 5);
                List<TeaViewExam> list = teaViewExamService.selectByEIdLimit(eId1, 0);
                model.addAttribute("tap",4);
                model.addAttribute("list",list);
                model.addAttribute("currentPage",1);
                model.addAttribute("totalPage",totalPage);
                model.addAttribute("eId1",eId1);
                return "teaReadExam";
            }
        }
        else if (sName!=null&&!"".equals(sName.trim()))
        {
            List<TeaViewExam> teaViewExams = teaViewExamService.selectBySNameAndTId(sName, teacher.getId());
            int totalPage = pageService.getTotalPage(teaViewExams.size(), 5);
            List<TeaViewExam> list = teaViewExamService.selectBySNameAndTIdLimit(sName, teacher.getId(), 0);
            model.addAttribute("tap",5);
            model.addAttribute("list",list);
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("sName",sName);
            return "teaReadExam";
        }
        else if(cId!=null&&cId!=0)
        {
            String cName = courseService.selectById(cId).getName();
            List<TeaViewExam> teaViewExams = teaViewExamService.selectByCName(cName);
            int totalPage = pageService.getTotalPage(teaViewExams.size(), 5);
            List<TeaViewExam> list = teaViewExamService.selectByCNameLimit(cName, 0);
            model.addAttribute("tap",6);
            model.addAttribute("list",list);
            model.addAttribute("currentPage",1);
            model.addAttribute("totalPage",totalPage);
            model.addAttribute("cId",cId);
            return "teaReadExam";
        }
        else
        {
            return "forward:/tea/lookStuExam";
        }
    }
    @RequestMapping("deleteExam")
    public String deleteExam(Integer id,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        examService.deleteById(id);
        return "forward:/tea/exam";
    }

    @RequestMapping("viewExamPage")
    public String viewExamPage(Model model,HttpSession session,Integer currentPage,Integer totalPage,String op,Integer eId1,Integer cId,String sName,Integer tap)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int x = pageService.getCurrentPage(currentPage, totalPage, op);
        List<TeaViewExam> list=new ArrayList<>();
        if(tap==1)
        {
            list = teaViewExamService.selectByTIdLimit(teacher.getId(),(x-1)*5);
        }
        if (tap==2)
        {
            list = teaViewExamService.selectByEIdAndSNameLimit(eId1, sName, (x - 1) * 5);
        }
        if (tap==3)
        {
            list = teaViewExamService.selectByEIdAndCIdLimit(eId1, cId, (x - 1) * 5);
        }
        if (tap==4)
        {
            list = teaViewExamService.selectByEIdLimit(eId1,(x-1)*5);
        }
        if (tap==5)
        {
            list = teaViewExamService.selectBySNameAndTIdLimit(sName, teacher.getId(), (x - 1) * 5);
        }
        if (tap==6)
        {
            String name = courseService.selectById(cId).getName();
            list = teaViewExamService.selectByCNameLimit(name, (x - 1) * 5);
        }
        model.addAttribute("tap",tap);
        model.addAttribute("list",list);
        model.addAttribute("currentPage",x);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("cId",cId);
        model.addAttribute("eId1",eId1);
        model.addAttribute("sName",sName);
        return "teaReadExam";
    }
    @RequestMapping("goStuExam")
    public String  goStuExam(Integer eId,String sName,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        List<User> users = userService.selectByName(sName);
        for (int i = 0; i < users.size(); i++) {
            if (submitExamService.selectByEIdAndSId(eId,users.get(i).getId())!=null)
            {
                session.setAttribute("sessionUser",users.get(i));
            }
        }

        return "forward:/stu/doStuExam";
    }
    @RequestMapping("updateScore")
    public String updateScore(Integer eId,String sName,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        List<TeaViewExam> teaViewExams = teaViewExamService.selectByEIdAndSName(eId, sName);
        TeaViewExam exam=teaViewExams.get(0);
        model.addAttribute("exam",exam);
        return "teaScore";
    }
    @RequestMapping("doUpdateScore")
    public String doUpdateScore(Integer eId,String sName,String score,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        teaViewExamService.updateSubmit(eId,sName,score);
        List<User> users = userService.selectByName(sName);
        for (int i = 0; i < users.size(); i++) {
            if (submitExamService.selectByEIdAndSId(eId,users.get(i).getId())!=null)
            {
                submitExamService.updateSubmit(eId,users.get(i).getId(),score);
            }
        }

        return "forward:/tea/lookStuExam";
    }










    //何健功部分
    @RequestMapping("/teacherInformation")
    public String teacherInformation(HttpSession session, Model model)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int numberId = forumNumberService.selectById();
        int numberTId = forumNumberService.selectByTId(teacher.getId());
        if (numberId==numberTId)
        {
            model.addAttribute("tap",1);
        }
        else
        {
            model.addAttribute("tap", 2);
        }
        model.addAttribute("teaInformation",teacher);
        return "teaInformation";
    }

    @RequestMapping("/updateInformation")
    public String updateInformation(String password,String phone,String note,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int numberId = forumNumberService.selectById();
        int numberTId = forumNumberService.selectByTId(teacher.getId());
        if (numberId==numberTId)
        {
            model.addAttribute("tap",1);
        }
        else
        {
            model.addAttribute("tap", 2);
        }
        if (password==null||"".equals(password.trim()))
        {
            password=teacher.getPassword();
        }
        if (phone==null||"".equals(phone.trim()))
        {
            phone=teacher.getPhone();
        }
        if (note==null||"".equals(note.trim()))
        {
            note=teacher.getNote();
        }

        teacherService.updateById(teacher.getId(),password,phone,note);


        Teacher teacher1 = teacherService.selectById(teacher.getId());
        session.setAttribute("sessionTeacher",teacher1);
        return "forward:/tea/teacherInformation";
    }

    @RequestMapping("/forumHome")
    public String ForumHome(Integer currentPage,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int numberId=forumNumberService.selectById();
        forumNumberService.updateByTId(teacher.getId(),numberId);
        if (currentPage==null||currentPage==0)
        {
            return "forward:/tea/selectForumByPage";
        }
        else
        {
            return "forward:/tea/selectForumByPage?currentPage="+currentPage;
        }
    }
    @RequestMapping("/selectForumByPage")
    public String selectForumByPage(PageBean<Forum> pageBean, Integer currentPage, Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        if (currentPage==null||currentPage==0)
        {
            currentPage=1;
        }
        pageBean.setCurrentPage(currentPage);
        List<Forum> forumList=forumService.selectForumByPage(pageBean);
        for (int i = 0; i <forumList.size() ; i++)
        {
            if (forumList.get(i).getsId()!=0)
            {
                User user = userService.selectById(forumList.get(i).getsId());
                forumList.get(i).setUser(user);
            }
            else
            {
                Teacher teacher=teacherService.selectById(forumList.get(i).gettId());
                forumList.get(i).setTeacher(teacher);
            }
        }
        pageBean.setList(forumList);
        model.addAttribute("forumList",pageBean);
        return "teaForum";
    }

    @RequestMapping("/postForum")
    public String postForum(HttpSession session,Model model)
    {
        if (teaSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (user!=null)
        {
            int numberId=forumNumberService.selectById();
            int numberSId=forumNumberService.selectBySId(user.getId());
            if (numberId==numberSId)
            {
                model.addAttribute("tap", 1);
                return "teaPostForum";
            }
            else
            {
                model.addAttribute("tap", 2);
                return "teaPostForum";
            }
        }
        else
        {
            int numberId=forumNumberService.selectById();
            int numberTId=forumNumberService.selectByTId(teacher.getId());
            if (numberId==numberTId)
            {
                model.addAttribute("tap", 1);
                return "teaPostForum";
            }
            else
            {
                model.addAttribute("tap", 2);
                return "teaPostForum";
            }
        }
    }

    @RequestMapping("/doPostForum")
    public String doPostForum(String title, String problem, MultipartFile file, HttpSession session, HttpServletRequest request) throws IOException
    {
        if (teaSessionService.init(session)==-1) return "login";
//        String dirPath="D:\\upload";
//        File filePath =new File(dirPath);
//        if (!filePath.exists())
//        {
//            filePath.mkdirs();
//        }
//        String originalFilename = file.getOriginalFilename();
//        String newFileName= UUID.randomUUID()+originalFilename;
//        File targetFile=new File(filePath,newFileName);
//        file.transferTo(targetFile);
//        String address=newFileName;

        byte[] bytes=file.getBytes();
        String name=file.getOriginalFilename();
        User user= (User) session.getAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (user!=null)
        {
            forumService.insertUserForum(user.getId(),title,problem,name,bytes,file);
            int a = forumNumberService.selectById();
            int i=a+1;
            forumNumberService.updateForumNumberId(i);
            int a1 = forumNumberService.selectBySId(user.getId());
            int i1=a1+1;
            forumNumberService.updateForumNumberSId(user.getId(),i1);
            return "forward:/tea/forumHome";
        }
        else
        {
            forumService.insertTeacherForum(teacher.getId(),title,problem,name,bytes,file);
            int a = forumNumberService.selectById();
            int i=a+1;
            forumNumberService.updateForumNumberId(i);
            int a1 = forumNumberService.selectByTId(teacher.getId());
            int i1=a1+1;
            forumNumberService.updateForumNumberTId(teacher.getId(),i1);
            return "forward:/tea/forumHome";
        }
    }

    @RequestMapping("/viewContent")
    public String viewContent(int id,HttpSession session,Model model)
    {
        if (teaSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (user!=null)
        {
            int numberId=forumNumberService.selectById();
            int numberSId=forumNumberService.selectBySId(user.getId());
            if (numberId==numberSId)
            {
                model.addAttribute("tap", 1);
                return "forward:/tea/doViewContent?id="+id;
            }
            else
            {
                model.addAttribute("tap", 2);
                return "forward:/tea/doViewContent?id="+id;
            }
        }
        else
        {
            int numberId=forumNumberService.selectById();
            int numberTId=forumNumberService.selectByTId(teacher.getId());
            if (numberId==numberTId)
            {
                model.addAttribute("tap", 1);
                return "forward:/tea/doViewContent?id="+id;
            }
            else
            {
                model.addAttribute("tap", 2);
                return "forward:/tea/doViewContent?id="+id;
            }
        }
    }

    @RequestMapping("/doViewContent")
    public String doViewContent(int id,Model model,HttpSession session)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Forum forum=forumService.selectForumById(id);

        String filePath=session.getServletContext().getRealPath("download");
        String pathName=filePath+File.separator+forum.getImgName();

        FileOutputStream fos = null;
        File file = new File(pathName);
        BufferedOutputStream bop = null;
        try {
            fos = new FileOutputStream(file);
            bop = new BufferedOutputStream(fos);
            bop.write(forum.getImgContent(), 0,forum.getImgContent().length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.flush();
                bop.flush();
                bop.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("每有图片");
            }
        }
        file.deleteOnExit();
        if (forum.getsId()!=0)
        {
            User user = userService.selectById(forum.getsId());
            forum.setUser(user);
        }
        else
        {
            Teacher teacher = teacherService.selectById(forum.gettId());
            forum.setTeacher(teacher);
        }
        model.addAttribute("forumContent",forum);
        List<Reply> replyList=replyService.selectByFId(id);
        for (int i = 0; i <replyList.size() ; i++)
        {
            if (replyList.get(i).getsId()!=0)
            {
                User user = userService.selectById(replyList.get(i).getsId());
                replyList.get(i).setUser(user);
            }
            else
            {
                Teacher teacher = teacherService.selectById(replyList.get(i).gettId());
                replyList.get(i).setTeacher(teacher);
            }
        }
        model.addAttribute("replyList", replyList);
        return "teaViewContent";
    }

    @RequestMapping("/insertReplyViewContent")
    public String insertReplyViewContent(HttpSession session,Integer fId,String message)
    {
        if (teaSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (user!=null)
        {
            replyService.insertReplyUser(fId,user.getId(),message);
            return "forward:/tea/viewContent?id="+fId;
        }
        else
        {
            replyService.insertReplyTeacher(fId,teacher.getId(),message);
            return "forward:/tea/viewContent?id="+fId;
        }
    }




    //王超慧部分
    @RequestMapping("teaLogOut")
    public String teaLogOut(HttpSession session)
    {
        session.invalidate();
        return "login";
    }
    @RequestMapping("teaViewCourse")
    public String teaViewCourse(HttpSession session,Model model)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        List<Course> courses = courseService.selectByTId(teacher.getId());
        int totalPage = pageService.getTotalPage(courses.size(), 5);
        List<Course> list = courseService.selectByTIdLimit(teacher.getId(), 0);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "teaViewCourse";
    }
    @RequestMapping("teaViewCoursePage")
    public String teaViewCoursePage(HttpSession session,Model model,Integer currentPage,Integer totalPage,String op)
    {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        int x=pageService.getCurrentPage(currentPage,totalPage,op);
        List<Course> list = courseService.selectByTIdLimit(teacher.getId(), (x-1)*5);
        model.addAttribute("currentPage",x);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "teaViewCourse";
    }
    @RequestMapping("teaViewHistory")
    public String teaViewHistory(HttpSession session,Model model,Integer cId)
    {
        if (teaSessionService.init(session)==-1) return "login";
        session.setAttribute("sessionCId",cId);
        List<History> histories = historyService.selectByCIdGroup(cId);
        int totalPage = pageService.getTotalPage(histories.size(), 5);
        List<History> list = historyService.selectByCIdGroupLimit(cId, 0);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "teaViewHistory";
    }
    @RequestMapping("teaViewHistoryPage")
    public String teaViewHistory(HttpSession session,Model model,Integer currentPage,Integer totalPage,String op)
    {
        if (teaSessionService.init(session)==-1) return "login";
        int cId= (int) session.getAttribute("sessionCId");
        int x=pageService.getCurrentPage(currentPage,totalPage,op);
        List<History> list = historyService.selectByCIdGroupLimit(cId, (x-1)*5);
        model.addAttribute("currentPage",x);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "teaViewHistory";
    }
}
