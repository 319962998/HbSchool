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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/stu")
@MultipartConfig
public class StuLogController {
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
    SubmitExamService submitExamService;
    @Autowired
    StuExamService stuExamService;
    @Autowired
    TeaViewExamService teaViewExamService;

    @Autowired
    TeacherExamSessionService teacherExamSessionService;
    @Autowired
    StudentExamSessionService studentExamSessionService;
    @Autowired
    StuSessionService stuSessionService;
    //静态方法

    @RequestMapping("stuExam")
    public String stuExam(HttpSession session, Model model,Integer currentPage,Integer totalPage,String op)
    {

        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        studentExamSessionService.updateEqual(user.getId());
        session.setAttribute("stuExamCount",0);
        int x=0;
        if (currentPage!=null&&currentPage!=0)
        {
            x=pageService.getCurrentPage(currentPage,totalPage,op);
        }

        List<Relition> relitions = relitionService.selectBySId(user.getId());
        List<Course> courses=new ArrayList<>();
        for (int i = 0; i < relitions.size(); i++) {
            courses.add(courseService.selectById(relitions.get(i).getcId()));
        }
        List<LayExam> list=new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            List<SentExam> sentExams = sentExamService.selectByCId(courses.get(i).getId());
            for (int j = 0; j < sentExams.size(); j++) {
                SubmitExam submitExam = submitExamService.selectByEIdAndSId(sentExams.get(j).geteId(), user.getId());
                String submit;
                if (submitExam==null)
                    submit="未提交";
                else
                    submit=submitExam.getSubmit();
                list.add(new LayExam(sentExams.get(j).geteId(),courses.get(i).getName(),sentExams.get(j).getName(),sentExams.get(j).getSection(),sentExams.get(j).getBegin(),sentExams.get(j).getLast(),submit));
            }
        }
        Collections.sort(list, new Comparator<LayExam>(){

            @Override
            public int compare(LayExam l1, LayExam l2) {

                    return l2.getBegin().compareTo(l1.getBegin());
            }});
//        list = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(LayExam :: geteId))), ArrayList::new));
        totalPage = pageService.getTotalPage(list.size(), 5);
        List<LayExam> stuList=new ArrayList<>();
        if(x==0)
        {
            if(totalPage==1)
            {
                for (int i = 0; i < list.size(); i++) {
                    stuList.add(list.get(i));
                }
            }
            else
            {
                for (int i = 0; i < 5; i++) {
                    stuList.add(list.get(i));
                }
            }
            model.addAttribute("currentPage",1);
        }
        else if (x==totalPage)
        {
            for (int i = (x-1)*5; i < list.size(); i++) {
                stuList.add(list.get(i));
            }
            model.addAttribute("currentPage",x);
        }
        else
        {
            for (int i = (x-1)*5; i < x*5; i++) {
                stuList.add(list.get(i));
            }
            model.addAttribute("currentPage",x);
        }
        model.addAttribute("list",stuList);

        model.addAttribute("totalPage",totalPage);
        return "studentExam";
    }
    @RequestMapping("doStuExam")
    public String doStuExam(Integer eId,HttpSession session,Model model)
    {
        if (stuSessionService.init(session)==-1) return "login";
        session.setAttribute("eId",eId);
        User user= (User) session.getAttribute("sessionUser");
        String last = sentExamService.selectByEId(eId).getLast();
        session.setAttribute("sessionLast",last);
        List<RelitionExam> relitionExams = relitionExamService.selectByEId(eId);
        int totalExam=relitionExams.size();
        int pId = relitionExams.get(0).getpId();
        StuExam stuExam = stuExamService.selectByEIdAndPIdAndSId(eId, pId,user.getId());
        Problem problem=problemService.selectById(pId);
        if(stuExam!=null)
        {
            String realPath = session.getServletContext().getRealPath("download");

            byte[] img = stuExam.getAddress();  //图片信息

            String name = stuExam.getName(); // 图片名
            model.addAttribute("fileName", name);
            String pathName = realPath + File.separator + name;


            FileOutputStream fos = null;
            File file = new File(pathName);
            BufferedOutputStream bop = null;
            try {
                fos = new FileOutputStream(file);
                bop = new BufferedOutputStream(fos);
                bop.write(img, 0, img.length);
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
            model.addAttribute("stuAnswer",stuExam.getSend());
        }

        model.addAttribute("problem",problem);
        model.addAttribute("currentExam",1);
        model.addAttribute("totalExam",totalExam);
        if (totalExam==1)
        {
            model.addAttribute("tap",1);
        }
        if(submitExamService.selectByEIdAndSId(eId,user.getId())!=null)
        {
            model.addAttribute("tap",2);
        }
        if (problem.getKind().equals("选择题"))
        {
            return "stuChooseExam";
        }
        else
        {
            return "stuWriteExam";
        }
    }
    @RequestMapping("StuExamPage")
    public String doStuExamPage(HttpSession session,Model model,String answer,Integer currentExam,Integer totalExam,String op,String okSubmit,MultipartFile file) throws IOException {
        if (stuSessionService.init(session)==-1) return "login";
        int eId= (int) session.getAttribute("eId");
        User user= (User) session.getAttribute("sessionUser");
        int x=pageService.getCurrentPage(currentExam,totalExam,op);

        List<RelitionExam> relitionExams = relitionExamService.selectByEId(eId);

        int pId = relitionExams.get(currentExam-1).getpId();

        StuExam stuExam = stuExamService.selectByEIdAndPIdAndSId(eId, pId,user.getId());


        //文件操作

            byte[] bytes = file.getBytes();

            String filename = file.getOriginalFilename();




        if(stuExam==null)
        stuExamService.insert(eId,user.getId(),pId,answer,filename,bytes);
        else
        {
            if (!file.isEmpty())
            stuExamService.updateAnswerByEIdAndPId(eId,pId,answer,filename,bytes);
            else
                stuExamService.updateAnswerByEIdAndPIdWithoutAddress(eId,pId,answer);

        }
        if ("确认提交".equals(okSubmit)) {
            if (submitExamService.selectByEIdAndSId(eId, user.getId()) == null) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                // new Date()为获取当前系统时间
                String time = df.format(new Date());
                submitExamService.insertSubmit(eId, user.getId(), "已提交", time);
                SentExam sentExam = sentExamService.selectByEId(eId);
                String cName = courseService.selectById(sentExam.getcId()).getName();
                String eName = sentExam.getName();
                String sName = user.getName();
                String last = sentExam.getLast();
                teaViewExamService.insert(eId, cName, eName, sName, time, last, "未批阅");
                teacherExamSessionService.updateValueByTId(examService.selectById(eId).gettId());
                return "forward:/stu/stuExam";
            }
        }
        //下一题操作
        int pIdNext = relitionExams.get(x-1).getpId();

        Problem problem=problemService.selectById(pIdNext);
        StuExam stuExamNext = stuExamService.selectByEIdAndPIdAndSId(eId, pIdNext,user.getId());

        if(stuExamNext!=null)
        {
            if (stuExamNext.getSend()!=null)
            {
                model.addAttribute("stuAnswer",stuExamNext.getSend());
            }

            if(stuExamNext.getAddress()!=null)
            {
                String realPath = session.getServletContext().getRealPath("download");

                byte[] img= stuExamNext.getAddress();  //图片信息
                String name =stuExamNext.getName(); // 图片名
                model.addAttribute("fileName", name);
                String pathName = realPath + File.separator + name;


                FileOutputStream fos = null;
                File fileNext = new File(pathName);
                BufferedOutputStream bop = null;

                try {
                    fos = new FileOutputStream(fileNext);
                    bop = new BufferedOutputStream(fos);
                    bop.write(img, 0, img.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(fos != null) {
                            fos.flush();
                            fos.close();
                        }
                        if(bop != null) {
                            bop.flush();
                            bop.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        System.out.println("每有图片");  //todo 可以用个提示无图片的图片代替
                    }
                }
                fileNext.deleteOnExit();
            }
        }


        model.addAttribute("problem",problem);
        model.addAttribute("currentExam",x);
        model.addAttribute("totalExam",totalExam);
        if(x==totalExam)
        {
            model.addAttribute("tap",1);
        }
        if(submitExamService.selectByEIdAndSId(eId,user.getId())!=null)
        {
            model.addAttribute("tap",2);
        }
        if (problem.getKind().equals("选择题"))
        {
            return "stuChooseExam";
        }
        else
        {
            return "stuWriteExam";
        }
    }





    //何建功部分
    @RequestMapping("/studentInformation")
    public String studentInformation(Model model,HttpSession session)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        int numberId = forumNumberService.selectById();
        int numberSId = forumNumberService.selectBySId(user.getId());
        if (numberId==numberSId)
        {
            model.addAttribute("tap",1);
        }
        else
        {
            model.addAttribute("tap", 2);
        }
        model.addAttribute("stuInformation",user);
        return "stuInformation";
    }

    @RequestMapping("/updateInformation")
    public String updateInformation(String password,String phone,String note,Model model,HttpSession session)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User)session.getAttribute("sessionUser");
        int numberId = forumNumberService.selectById();
        int numberSId = forumNumberService.selectBySId(user.getId());
        if (numberId==numberSId)
        {
            model.addAttribute("tap",1);
        }
        else
        {
            model.addAttribute("tap", 2);
        }
        if (password==null||"".equals(password.trim()))
        {
            password=user.getPassword();
        }
        if (phone==null||"".equals(phone.trim()))
        {
            phone=user.getPhone();
        }
        if (note==null||"".equals(note.trim()))
        {
            note=user.getNote();
        }
        userService.updateById(user.getId(),password,phone,note);
        User user1 = userService.selectById(user.getId());
        session.setAttribute("sessionUser",user1);
        return "forward:/stu/studentInformation";
    }
    @RequestMapping("/studentTuition")
    public String studentTuition(Model model,HttpSession session)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User)session.getAttribute("sessionUser");
        int numberId = forumNumberService.selectById();
        int numberSId = forumNumberService.selectBySId(user.getId());
        if (numberId==numberSId)
        {
            model.addAttribute("tap",1);
        }
        else
        {
            model.addAttribute("tap", 2);
        }
        model.addAttribute("user",user);
        return "studentTuition";
    }

    @RequestMapping("/forumHome")
    public String ForumHome(Integer currentPage,HttpSession session)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        int numberId=forumNumberService.selectById();
        forumNumberService.updateBySId(user.getId(),numberId);
        if (currentPage==null||currentPage==0)
        {
            return "forward:/stu/selectForumByPage";
        }
        else
        {
            return "forward:/stu/selectForumByPage?currentPage=" + currentPage;
        }
    }
    @RequestMapping("/selectForumByPage")
    public String selectForumByPage(PageBean<Forum> pageBean, Integer currentPage, Model model,HttpSession session)
    {
        if (stuSessionService.init(session)==-1) return "login";
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
        return "stuForum";
    }

    @RequestMapping("/postForum")
    public String postForum(HttpSession session,Model model)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (user!=null)
        {
            int numberId=forumNumberService.selectById();
            int numberSId=forumNumberService.selectBySId(user.getId());
            if (numberId==numberSId)
            {
                model.addAttribute("tap", 1);
                return "stuPostForum";
            }
            else
            {
                model.addAttribute("tap", 2);
                return "stuPostForum";
            }
        }
        else
        {
            int numberId=forumNumberService.selectById();
            int numberTId=forumNumberService.selectByTId(teacher.getId());
            if (numberId==numberTId)
            {
                model.addAttribute("tap", 1);
                return "stuPostForum";
            }
            else
            {
                model.addAttribute("tap", 2);
                return "stuPostForum";
            }
        }
    }

    @RequestMapping("/doPostForum")
    public String doPostForum(String title, String problem, MultipartFile file, HttpSession session, HttpServletRequest request) throws IOException
    {
        if (stuSessionService.init(session)==-1) return "login";
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
            return "forward:/stu/forumHome";
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
            return "forward:/stu/forumHome";
        }
    }

    @RequestMapping("/viewContent")
    public String viewContent(int id,HttpSession session,Model model)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (user!=null)
        {
            int numberId=forumNumberService.selectById();
            int numberSId=forumNumberService.selectBySId(user.getId());
            if (numberId==numberSId)
            {
                model.addAttribute("tap", 1);
                return "forward:/stu/doViewContent?id="+id;
            }
            else
            {
                model.addAttribute("tap", 2);
                return "forward:/stu/doViewContent?id="+id;
            }
        }
        else
        {
            int numberId=forumNumberService.selectById();
            int numberTId=forumNumberService.selectByTId(teacher.getId());
            if (numberId==numberTId)
            {
                model.addAttribute("tap", 1);
                return "forward:/stu/doViewContent?id="+id;
            }
            else
            {
                model.addAttribute("tap", 2);
                return "forward:/stu/doViewContent?id="+id;
            }
        }
    }

    @RequestMapping("/doViewContent")
    public String doViewContent(int id,Model model,HttpSession session)
    {
        if (stuSessionService.init(session)==-1) return "login";
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
                if(fos != null) {
                    fos.flush();
                    fos.close();
                }
                if(bop != null) {
                    bop.flush();
                    bop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("每有图片");  //todo 可以用个提示无图片的图片代替
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
        return "stuViewContent";
    }

    @RequestMapping("/insertReplyViewContent")
    public String insertReplyViewContent(HttpSession session,Integer fId,String message)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        Teacher teacher= (Teacher) session.getAttribute("sessionTeacher");
        if (user!=null)
        {
            replyService.insertReplyUser(fId,user.getId(),message);
            return "forward:/stu/viewContent?id="+fId;
        }
        else
        {
            replyService.insertReplyTeacher(fId,teacher.getId(),message);
            return "forward:/stu/viewContent?id="+fId;
        }
    }






    //王超慧部分
    @RequestMapping("stuLogOut")
    public String stuLogOut(HttpSession session)
    {
        session.invalidate();
        return "login";
    }
    @RequestMapping("stuViewCourse")
    public String stuViewCourse(Model model,HttpSession session)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        List<Course> courses = courseService.selectBySId(user.getId());
        int totalPage = pageService.getTotalPage(courses.size(), 5);
        List<Course> list = courseService.selectBySIdLimit(user.getId(), 0);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "stuViewCourse";
    }
    @RequestMapping("stuViewCoursePage")
    public String stuViewCoursePage(Model model,HttpSession session,Integer currentPage,Integer totalPage,String op)
    {
        if (stuSessionService.init(session)==-1) return "login";
        User user= (User) session.getAttribute("sessionUser");
        int x = pageService.getCurrentPage(currentPage, totalPage, op);
        List<Course> list = courseService.selectBySIdLimit(user.getId(), (x-1)*5);
        model.addAttribute("currentPage",x);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "stuViewCourse";
    }
    @RequestMapping("stuViewHistory")
    public String stuViewHistory(HttpSession session,Model model,Integer cId)
    {
        if (stuSessionService.init(session)==-1) return "login";
        session.setAttribute("sessionCId",cId);
        User user= (User) session.getAttribute("sessionUser");
        List<History> histories = historyService.selectByCIdAndSId(cId, user.getId());
        int totalPage = pageService.getTotalPage(histories.size(), 5);
        List<History> list = historyService.selectByCIdAndSIdLimit(cId, user.getId(), 0);
        model.addAttribute("currentPage",1);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "stuViewHistory";
    }
    @RequestMapping("stuViewHistoryPage")
    public String stuViewHistoryPage(HttpSession session,Model model,Integer currentPage,Integer totalPage,String op)
    {
        if (stuSessionService.init(session)==-1) return "login";
        int cId= (int) session.getAttribute("sessionCId");
        User user= (User) session.getAttribute("sessionUser");
        int x=pageService.getCurrentPage(currentPage,totalPage,op);
        List<History> list = historyService.selectByCIdAndSIdLimit(cId, user.getId(), (x-1)*5);
        model.addAttribute("currentPage",x);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("list",list);
        return "stuViewHistory";
    }
}
