package com.colin.controller;

import com.colin.bean.*;
import com.colin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin")
@MultipartConfig
public class AdminController {
    @Autowired
    ForumNumberService forumNumberService;
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
    NoteSessionService noteSessionService;
    @Autowired
    StudentExamSessionService studentExamSessionService;
    @Autowired
    TeacherExamSessionService teacherExamSessionService;
    @Autowired
    StuSessionService stuSessionService;
    @Autowired
    TeaSessionService teaSessionService;

    @RequestMapping("login")
    public String login(String name, String password, HttpSession session,Model model) {

        if (name.equals("xz") && password.equals("555")) {


            return "forward:/admin/opCourse";
        }

        else if (name.endsWith("老师")) {
            //查询
            Teacher teacher=teacherService.selectByNameAndPassword(name,password);
            if (teacher==null)
            {
                model.addAttribute("logtap",2);
            }
            session.setAttribute("sessionTeacher" ,teacher);
            teaSessionService.init(session);
            return "forward:/teacher/teacherNotes";
        }
        else
        {
            User user=userService.selectByNameAndPassword(name,password);
            if (user==null)
            {
                List<User> users = userService.selectByName(name);
                if (users.size()==0)
                {
                    model.addAttribute("logtap",1);
                }
                else
                {
                    model.addAttribute("logtap",2);
                }
                return "login";
            }
            session.setAttribute("sessionUser",user);

            stuSessionService.init(session);
            return "forward:/student/studentNotes";//学生端
        }

    }

    @RequestMapping("opCourse")
    public String opCourse(Model model,HttpSession session) {
        int totalCourse = courseService.selectCount();
        session.setAttribute("totalCourse",totalCourse);
        int totalPage = pageService.getTotalPage(totalCourse, 5);
        List<Course> list = courseService.selectLimit(0);
        model.addAttribute("list", list);
        model.addAttribute("tap", 1);
        model.addAttribute("currentPage", 1);
        model.addAttribute("totalPage", totalPage);
        int totalpeople=0;

        List<User> users= userService.selectAll();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getTuition()<0)
            {
                totalpeople++;
            }
        }

        List<Teacher> teachers= teacherService.selectAll();
        int totalPay=0;
        for (int i = 0; i < teachers.size(); i++) {
            totalPay+=teachers.get(i).getSalary();
        }

        session.setAttribute("totalPeople",totalpeople);
        session.setAttribute("totalPay",totalPay);
        session.setAttribute("totalUser",users.size());
        return "Administrator";
    }

    @RequestMapping("opCoursePage")
    public String opCoursePage(int currentPage, String op, Model model) {
        int totalCourse = courseService.selectCount();

        int totalPage = pageService.getTotalPage(totalCourse, 5);
        int current = pageService.getCurrentPage(currentPage, totalPage, op);
        List<Course> list = courseService.selectLimit((current - 1) * 5);
        model.addAttribute("list", list);
        model.addAttribute("tap", 1);
        model.addAttribute(("totalPage"), totalPage);
        model.addAttribute("currentPage", current);


        return "Administrator";
    }

    @RequestMapping("serchCourse")
    public String SerchCourse(Integer cId, String cName, String tName, Model model) {

        if (cId != null && cId != 0) {
            List<Course> list = new ArrayList<>();
            list.add(courseService.selectById(cId));
            model.addAttribute("list", list);
            model.addAttribute("tap", 2);
            model.addAttribute("totalPage", 1);
            model.addAttribute("currentPage", 1);
            model.addAttribute("cId", cId);
            return "Administrator";
        } else if (cName != null && !"".equals(cName.trim())) {
            System.out.println(cName);
            List<Course> list = courseService.selectByName(cName);
            model.addAttribute("list", list);
            model.addAttribute("tap", 2);
            model.addAttribute("totalPage", 1);
            model.addAttribute("currentPage", 1);
            model.addAttribute("cName", cName);
            return "Administrator";
        } else if (tName != null && !"".equals(tName.trim())) {

            int totalCourse = courseService.selectByTnameCount(tName);
            int totalPage = pageService.getTotalPage(totalCourse, 5);
            List<Course> list = courseService.selectByTnameLimit(tName, 0);
            model.addAttribute("list", list);
            model.addAttribute("tap", 2);
            model.addAttribute("totalPage", totalPage);
            model.addAttribute("currentPage", 1);
            model.addAttribute("tName", tName);

            return "Administrator";
        } else {
            return "forward:/admin/opCourse";
        }
    }

    @RequestMapping("serchCoursePage")
    public String SerchCoursePage(int currentPage, String op, Integer cId, String cName, String tName, Model model) {
        if (cId != null && cId != 0) {
            return "forward:/admin/serchCourse";
        } else if (cName != null && !"".equals(cName.trim())) {

            return "forward:/admin/serchCourse";
        } else if (tName != null && !"".equals(tName.trim())) {
            int totalCourse = courseService.selectByTnameCount(tName);
            int totalPage = pageService.getTotalPage(totalCourse, 5);
            int current = pageService.getCurrentPage(currentPage, totalPage, op);
            List<Course> list = courseService.selectByTnameLimit(tName, (current - 1) * 5);
            model.addAttribute("list", list);
            model.addAttribute("tap", 2);
            model.addAttribute("totalPage", totalPage);
            model.addAttribute("currentPage", current);
            model.addAttribute("tName", tName);
            return "Administrator";
        } else return "forward:/admin/serchCourse";

    }

    @RequestMapping("increaseCourse")
    public String increaseCourse(Integer totalLeave, Integer leaveCourseid, String time, Model model) {
        if (totalLeave != null && totalLeave != 0) {
            model.addAttribute("opLeave", 1);
            model.addAttribute("totalLeave", totalLeave);
            model.addAttribute("time", time);
            model.addAttribute("leaveCourseid", leaveCourseid);
            return "Administrator";
        } else {
           // List<Course> courselist = courseService.selectById(leaveCourseid);
            Course course = courseService.selectById(leaveCourseid);

            int tPay = course.gettPay();
            int sPay = course.getsPay();
            int tId = course.gettId();
            List<Relition> relitions = relitionService.selectBycId(leaveCourseid);
            for (int i = 0; i < relitions.size(); i++) {
                int sId = relitions.get(i).getsId();
                String sName = relitions.get(i).getsName();
                historyService.insertHistory(leaveCourseid, time, sId, sName, tPay, sPay);
               // List<User> users = userService.selectById(sId);
                User user = userService.selectById(sId);
                int tuition = user.getTuition();
                tuition -= sPay;
                userService.updateTuitionById(sId, tuition);
            }
            //List<Teacher> teachers = teacherService.selectById(tId);
            Teacher teacher = teacherService.selectById(tId);
            int salary = teacher.getSalary();
            salary += tPay;
            teacherService.updateSalaryById(tId, salary);
            int totalClass = course.getTotalClass();
            totalClass++;
            int payClass = course.getPayClass();
            payClass++;
            courseService.updateTotalClassById(leaveCourseid, totalClass);
            courseService.updatePayClass(leaveCourseid, payClass);
            return "forward:/admin/opCourse";
        }

    }

    @RequestMapping("leavePeople")
    public String leavePeople(HttpServletRequest request, String history, Integer totalLeave, Integer cId, Model model) {

       // List<Course> courselist = courseService.selectById(cId);
        Course course = courseService.selectById(cId);
        int tPay = course.gettPay();
        int sPay = course.getsPay();
        int tId = course.gettId();
        List<Relition> relitions = relitionService.selectBycId(cId);
        System.out.println(totalLeave);
        for (int i = 1; i <= totalLeave; i++) {
            String pid = request.getParameter("id" + i);
            if (pid != null && !"".equals(pid.trim())) {
                int id = Integer.parseInt(pid);

                for (int j = 0; j < relitions.size(); j++) {
                    if (relitions.get(j).getsId() == id)
                        relitions.remove(j);

                }
            } else {
                String pname = request.getParameter("name" + i);

                for (int j = 0; j < relitions.size(); j++) {
                    if (relitions.get(j).getsName().equals(pname))
                        relitions.remove(j);

                }
            }
        }


        for (int i = 0; i < relitions.size(); i++) {
            int sId = relitions.get(i).getsId();
            String sName = relitions.get(i).getsName();
            historyService.insertHistory(cId, history, sId, sName, tPay, sPay);
           // List<User> users = userService.selectById(sId);
            User user = userService.selectById(sId);
            int tuition = user.getTuition();
            tuition -= sPay;
            userService.updateTuitionById(sId, tuition);
        }
        //List<Teacher> teachers = teacherService.selectById(tId);
        Teacher teacher = teacherService.selectById(tId);
        int salary = teacher.getSalary();
        salary += tPay;
        teacherService.updateSalaryById(tId, salary);
        int totalClass = course.getTotalClass();
        totalClass++;
        int payClass = course.getPayClass();
        payClass++;
        courseService.updateTotalClassById(cId, totalClass);
        courseService.updatePayClass(cId, payClass);
        return "forward:/admin/opCourse";
    }


    @RequestMapping("lookHistory")
    public String lookHistory(Integer currentP1, Integer courseid, Model model, String lookHistory, String opreduce, String deleteop, String oplook, String optap) {
        model.addAttribute("courseid", courseid);
        List<History> histories = historyService.selectByCId(courseid);
        int totalPage = pageService.getTotalPage(histories.size(), 5);
        model.addAttribute("totalP1", totalPage);
        if (currentP1 == null || currentP1 == 0) {

            if (opreduce == null) {

                model.addAttribute("currentP1", 1);

                List<History> list = historyService.selectLimitByCId(courseid, 0);

                model.addAttribute("historyList", list);

                model.addAttribute("oplook", 1);

                return "look";
            } else {

                model.addAttribute("currentP1", 1);

                List<History> list = historyService.selectLimitByCId(courseid, 0);

                model.addAttribute("historyList", list);

                model.addAttribute("oplook", 2);

                return "look";
            }

        } else if (lookHistory == null || "".equals(lookHistory.trim())) {


            int x = pageService.getCurrentPage(currentP1, totalPage, optap);

            List<History> histories1 = historyService.selectLimitByCId(courseid, (x - 1) * 5);

            model.addAttribute("historyList", histories1);

            model.addAttribute("currentP1", x);

            model.addAttribute("oplook", 1);
            if (opreduce != null) {

                model.addAttribute("oplook", 2);
            }
            if ("2".equals(oplook)) {

                model.addAttribute("oplook", 2);
            }

            return "look";
        } else if (deleteop != null) {

            List<History> histories1= historyService.selectByCIdHistory(courseid, lookHistory);
            for (int i = 0; i < histories1.size(); i++) {

                //List<User> users = userService.selectById(histories1.get(i).getsId());
                User user = userService.selectById(histories1.get(i).getsId());

                int tuition = user.getTuition();
                int s_pay = histories1.get(i).getsPay();
                tuition += s_pay;

                userService.updateTuitionById(user.getId(),tuition);
            }

           // List<Course> courses = courseService.selectById(courseid);
            Course course = courseService.selectById(courseid);
           // List<Teacher> teachers = teacherService.selectById(course.gettId());
            Teacher teacher = teacherService.selectById(course.gettId());

            int salary = teacher.getSalary();
            salary -= histories1.get(0).gettPay();

            teacherService.updateSalaryById(course.gettId(),salary);

            historyService.deleteByCIdHistory(courseid,lookHistory);

            int x1=course.getPayClass();
            x1--;
            int x2=course.getTotalClass();
            x2--;
            courseService.updatePayClass(courseid,x1);
            courseService.updateTotalClassById(courseid,x2);


            List<History> histories2 = historyService.selectLimitByCId(courseid, 0);

            model.addAttribute("historyList",histories2);

            model.addAttribute("currentP1",currentP1);

            model.addAttribute("oplook",2);
            return "look";
        } else {


            List<History> histories1 = historyService.selectByCIdHistory(courseid, lookHistory);
            int x=currentP1;

            List<History> histories2 = historyService.selectLimitByCId(courseid, (x - 1) * 5);

            model.addAttribute("historyList",histories2);

            model.addAttribute("SrelitionList",histories1);

            model.addAttribute("currentP1",currentP1);

            model.addAttribute("oplook",1);
            if ("2".equals(oplook)) {

                model.addAttribute("oplook",2);
            }
            return "look";
        }
    }
   @RequestMapping("fresh")
    public String fresh(Integer id)
   {



       courseService.updatePayClass(id,0);

       return "forward:/admin/opCourse";
   }
   @RequestMapping("deleteCourse")
    public String deleteCourse(Integer id)
   {


       courseService.deleteById(id);
      return "forward:/admin/opCourse";
   }

    //何建功部分

    @RequestMapping("/sign")
    public String sign()
    {
        return "sign";
    }

    @RequestMapping("/doSign")
    public String doSign(String name,String password,Model model)
    {
        if(name.endsWith("老师"))
        {
            model.addAttribute("name",name);
            model.addAttribute("password",password);
            return "teacherSign";
        }
        else
        {
            model.addAttribute("name", name);
            model.addAttribute("password", password);
            return "studentSign";
        }
    }

    @RequestMapping("/insertTeacher")
    public String insertTeacher(String name,String password,String subject,String phone,String note)
    {
        teacherService.insertTeacher(name,password,subject,phone,note);
        Teacher teacher = teacherService.selectByNameAndPassword(name,password);
        forumNumberService.insertTId(teacher.getId());
        teacherExamSessionService.insert(teacher.getId());
        return "login";
    }

    @RequestMapping("/insertUser")
    public String insertUser(String name,String password,String grade,String school,String phone,String note)
    {
        userService.insertUser(name,password,grade,school,phone,note);
        User user = userService.selectByNameAndPassword(name, password);
        forumNumberService.insertSId(user.getId());
        studentExamSessionService.insert(user.getId());
        return "login";
    }

    @RequestMapping("/createCourse")
    public String createCourse()
    {
        return "createCourse";
    }

    @RequestMapping("/doCreateCourse")
    public String doCreateCourse(String name,String tName,String tId,String sPay,String tPay,String number,String time,Model model)
    {
        courseService.insertCourse(name,tName,tId,sPay,tPay,time);
        model.addAttribute("number",number);
        model.addAttribute("name",name);
        model.addAttribute("tap","");
        return "selectStudent";
    }

    @RequestMapping("/insertRelition")
    public String insertRelition(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String number1 = request.getParameter("number");
        Integer number=Integer.parseInt(number1);
        Course course=courseService.selectByName(name).get(0);
        List<String> list=new ArrayList();
        if (course.getId()!=-1)
        {
            for (int i = 1; i <=number ; i++)
            {
                String id = request.getParameter("id" + i);
                if (id==null||"".equals(id.trim()))
                {
                    String sName= request.getParameter("name" + i);
                    List<User> userByName=userService.selectByName(sName.trim());
                    if (userByName.size()<=1)
                    {
                        relitionService.insert(course.getId(),name,userByName.get(0).getId(),sName);
                    }
                    else
                    {
                        list.add(userByName.get(0).getName());
                    }
                }
                else
                {
                    User userById=userService.selectById(Integer.parseInt(id));
                    if (userById.getId()!=-1)
                    {
                        relitionService.insert(course.getId(),name,userById.getId(),userById.getName());
                    }
                }
            }
            for (int i = 1; i <=number ; i++)
            {
                String sName= request.getParameter("name" + i);
                List<User> userByName=userService.selectByName(sName.trim());
                if (userByName.size()>1)
                {
                    request.setAttribute("nameList",list);
                    request.setAttribute("nameListNumber",list.size());
                    request.setAttribute("name",name);
                    request.setAttribute("tap","1");
                    return "selectStudent";
                }
            }
        }
        return "createCourse";
    }

    @RequestMapping("/reName")
    public String reName(HttpServletRequest request)
    {
        int nameListNumber = Integer.parseInt(request.getParameter("nameListNumber"));
        String name = request.getParameter("name");
        Course course = courseService.selectByName(name).get(0);
        for (int i = 1; i <=nameListNumber ; i++)
        {
            int idOnly = Integer.parseInt(request.getParameter("idOnly" + i));
            User user = userService.selectById(idOnly);
            relitionService.insert(course.getId(),name,user.getId(),user.getName());
        }
        return "createCourse";
    }
    @RequestMapping("/upCourse")
    public String upCourse()
    {
        return "upCourse";
    }

    @RequestMapping("/doUpCourse")
    public String doUpCourse(int c_id,String tap,String s_id1,String s_name1,String s_id2,String s_name2,Model model)
    {
        List<Course> list=new ArrayList<>();
        Course course = courseService.selectById(c_id);
        list.add(course);
        model.addAttribute("upList",list);
        List<Relition> relitions=relitionService.selectBycId(c_id);
        model.addAttribute("c_sList",relitions);
        model.addAttribute("upCourse",1);
        if(tap==null||"".equals(tap.trim()))
        {
            model.addAttribute("upCourse",1);
        }
        else
        {
            if (tap.equals("1"))
            {
                List<User> list1=new ArrayList<>();
                if (s_id1==null||"".equals(s_id1.trim()))
                {
                    list1=userService.selectByName(s_name1);
                    model.addAttribute("s_name1",s_name1);
                }
                else
                {
                    int sId=Integer.parseInt(s_id1);
                    list1.add(userService.selectById(sId));
                    model.addAttribute("s_id1",sId);
                }
                model.addAttribute("serchList1",list1);
                model.addAttribute("upCourse",2);
            }
            if (tap.equals("2"))
            {
                List<User> list1=new ArrayList<>();
                if (s_id2==null||"".equals(s_id2.trim()))
                {
                    list1=userService.selectByName(s_name2);
                    model.addAttribute("s_name2",s_name2);
                }
                else
                {
                    int sId=Integer.parseInt(s_id2);
                    list1.add(userService.selectById(sId));
                    model.addAttribute("s_id2",sId);
                }
                model.addAttribute("serchList2",list1);
                model.addAttribute("upCourse",3);
            }
        }
        return "upCourse";
    }

    @RequestMapping("/upCourseMain")
    public String upCourseMain(String tap,Integer id,Integer upCourse_id,String upCourseName,String upCourseT_name,Integer upCourseS_pay,String upCourseTime,Integer upCourseT_pay)
    {
        if (tap.equals("1"))
        {
            User user = userService.selectById(id);
            //List<Course> list = courseService.selectById(upCourse_id);
            Course list = courseService.selectById(upCourse_id);
            relitionService.insert(upCourse_id,list.getName(),id,user.getName());
        }
        else if (tap.equals("2"))
        {
            relitionService.deleteById(id,upCourse_id);
        }
        else if(tap.equals("3"))
        {
            courseService.updateWithoutPayAndTotalById(upCourse_id,upCourseName,upCourseT_name,upCourseS_pay,upCourseT_pay,upCourseTime);
        }
        return "forward:/admin/doUpCourse?c_id="+upCourse_id+"&tap=";
    }


    //黎浩部分
    @RequestMapping("/register")
    public String register() {
        return "sign";
    }

    @RequestMapping("/doRegister")
    public String doRegister() {
//        return "forward:/teacher/selectAllByPage";
        return "upTeacher";
    }
    
    
    @RequestMapping("stuTable")
    public String stutable(Model model)
    {

        List<User> list = userService.selectAll();

        model.addAttribute("currentP2",1);
        int totalPageS=pageService.getTotalPage(list.size(),5);

        model.addAttribute("totalP2",totalPageS);

        List<User> list1 = userService.selectLimit(0);
        model.addAttribute("stuList",list1);
        model.addAttribute("tap",1);
        return "studentTable";

    }
    @RequestMapping("stuTablePage")
    public String stutablepage(Integer currentP2,String op,Integer totalP2,Model model,String tap,String name,Integer id)
    {


        int x=pageService.getCurrentPage(currentP2,totalP2,op);

        List<User> list=new ArrayList<>();
        model.addAttribute("currentP2",x);
        model.addAttribute("totalP2",totalP2);
        if(tap.equals("1"))
        {

            list = userService.selectLimit((x - 1) * 5);
            model.addAttribute("tap",1);
        }
        if(tap.equals("2"))
        {

            if(x==0)
                x=1;
            list = userService.selectLimitByName(name, (x - 1) * 5);
            model.addAttribute("tap",2);
            model.addAttribute("name",name);
        }
        if(tap.equals("3"))
        {


            User user = userService.selectById(id);
            list.add(user);
            model.addAttribute("tap",3);
            model.addAttribute("id",id);
        }
        model.addAttribute("stuList",list);

        return "studentTable";
    }
    @RequestMapping("teaTable")
    public String teatable(Model model)
    {

        List<Teacher> list = teacherService.selectAll();
        model.addAttribute("currentP2",1);
        int totalPageS=pageService.getTotalPage(list.size(),5);

        model.addAttribute("totalP2",totalPageS);


        List<Teacher> list1 = teacherService.selectLimit(0);
        model.addAttribute("stuList",list1);
        model.addAttribute("tap",1);
        return "teacherTable";
    }
    @RequestMapping("teaTablePage")
    public String teatablepage(Integer currentP2,String op,Integer totalP2,Model model,String tap,String name,Integer id)
    {
        int x=pageService.getCurrentPage(currentP2,totalP2,op);

        List<Teacher> list=new ArrayList<>();
        model.addAttribute("currentP2",x);
        model.addAttribute("totalP2",totalP2);
        if(tap.equals("1"))
        {

            list = teacherService.selectLimit((x - 1) * 5);
            model.addAttribute("tap",1);
        }
        if(tap.equals("2"))
        {
            if (x==0)
                x=1;
            list=teacherService.selectLimitByName(name,(x-1)*5);
            model.addAttribute("tap",2);
            model.addAttribute("name",name);
        }
        if(tap.equals("3"))
        {

            Teacher teacher = teacherService.selectById(id);
            list.add(teacher);
            model.addAttribute("tap",3);
            model.addAttribute("id",id);
        }
        model.addAttribute("stuList",list);
        return "teacherTable";
    }
    @RequestMapping("updateStuSerch")
    public String updateStuSerch(Integer id,Model model)
    {


        User user = userService.selectById(id);
        model.addAttribute("user",user);
        model.addAttribute("op",1);
        return "upStudent";
    }
    @RequestMapping("updateTeaSerch")
    public String updateTeaSerch(Integer id,Model model)
    {

        Teacher teacher = teacherService.selectById(id);
        model.addAttribute("user",teacher);
        model.addAttribute("op",1);
        return "upTeacher";

    }
    @RequestMapping("changeStu")
    public String changeStu(String name,String password,String grade,String school,String note,Integer tuition,String phone,Integer id,Model model)
    {

        userService.updateExceptId(id,name,password,grade,school,phone,note,tuition);

        return "upStudent";

    }
    @RequestMapping("changeTea")
    public String changeTea(String name,String password,String subject,String note,Integer salary,String phone,Integer id)
    {


        teacherService.updateExceptId(id,name,password,subject,phone,note,salary);



        return "upTeacher";

    }
    @RequestMapping("stuSerch")
    public String stuSerch(String name,Integer id)
    {

        if(id==null||id==0)
        {
            if(name==null||"".equals(name.trim()))
            {

                return "forward:/admin/stuTable";
            }
            else
            {

                List<User> list = userService.selectByName(name);
                int totalP2=pageService.getTotalPage(list.size(),5);


                return "forward:/admin/stuTablePage?currentP2=1&totalP2="+totalP2+"&op=1&tap=2";
            }

        }
        else
        {

            return "forward:/admin/stuTablePage?currentP2=1&totalP2=1&op=1&tap=3&id="+id;
        }
    }
    @RequestMapping("teaSerch")
    public String teaSerch(String name,Integer id)
    {

        if(id==null||id==0)
        {
            if(name==null||"".equals(name.trim()))
            {

                return "forward:/admin/stuTable";
            }
            else
            {


                List<Teacher> list = teacherService.selectByName(name);
                int totalP2=pageService.getTotalPage(list.size(),5);
                return "forward:/admin/teaTablePage?currentP2=1&totalP2="+totalP2+"&op=1&tap=2";

            }

        }
        else
        {
            return "forward:/admin/teaTablePage?currentP2=1&totalP2=1&op=1&tap=3&id="+id;

        }
    }
    @RequestMapping("goStuUpdate")
    public String goStuUpdate()
    {
        return "upStudent";
    }
    @RequestMapping("goTeaUpdate")
    public String goTeaUpdate()
    {
        return "upTeacher";
    }
    @RequestMapping("test")
    public String test()
    {
        return "test";
    }
    @RequestMapping("dotest")
    public String dotest(String name,Model model)
    {
        System.out.println(name);
        model.addAttribute("name",name);
        return "test";
    }
    @RequestMapping("logOut")
    public String logOut()
    {
        return "login";
    }

    /**
     * 个人信息上传
     * @return {Result}
     */
    @RequestMapping(value = "/upload/headImg", method = {RequestMethod.POST})
    @ResponseBody
    public Object headImg(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String prefix="";
        String dateStr="";
        System.out.println("1111111111111111111111111");
        String originalName="";
        String uploadDir="uploadDir";//这个文件夹是创建在:helloworld/target/helloworld/statics/uploadDir,以及helloworld/statics/uploadDir处
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                // 文件名：头像.jpg
                originalName = file.getOriginalFilename();
                System.out.println(originalName);
                //获取格式：jpg
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                // 时间戳
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                dateStr = format.format(new Date());
                // 文件全url:D:/myworkspace/IdeaProjects/helloworld/target/helloworld/statics/uploadDir/20190804140905.jpg
                //String filepath = request.getServletContext().getRealPath("/statics/"+ uploadDir+"/" + dateStr + "." + prefix) ;
                //D:/myworkspace/IdeaProjects/helloworld/target/helloworld/statics/uploadDir/20190804140905头像.jpg
                String filepath = request.getServletContext().getRealPath("/statics/"+ uploadDir+"/" + dateStr + originalName) ;
                filepath = filepath.replace("/", "\\");
                System.out.println(filepath);
                //保存图片
                File files=new File(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
            }
        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        //前端回调js中：
        Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",map2);
        //map2.put("src","../../../statics/"+uploadDir +"/"+ dateStr + "." + prefix);
        map2.put("src","../../../statics/"+uploadDir +"/"+ dateStr + originalName);
        return map;
    }

}
