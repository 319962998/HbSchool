package com.colin.controller;

import com.colin.bean.*;
import com.colin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/teacher")
@MultipartConfig
public class TeacherController {
    @Autowired
    CourseService courseService;

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @Autowired
    NoteSessionService noteSessionService;

    @Autowired
    TeaSessionService teaSessionService;
    @RequestMapping("/teacherNotes")
    public String teacherNotes(HttpSession session,Model model,PageBean<Note> pageBean, Integer currentPage) {
        if (teaSessionService.init(session)==-1) return "login";
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        pageBean.setCurrentPage(currentPage);
        Teacher LoginTeacher = (Teacher) session.getAttribute("sessionTeacher");
        List<Note> notes=noteService.selectNoteByTid(LoginTeacher.getId(),pageBean);
        List<Course> courses=courseService.selectCourseNameByNoteCId(LoginTeacher.getId());

        pageBean.setList(notes);

        model.addAttribute("courses", courses);
        model.addAttribute("notes", notes);
        model.addAttribute("teacher", LoginTeacher);
        return "teacherNotes";
    }

    @RequestMapping("/updateNotes")
    public String updateNotes(Integer noteId, String courseName,Model model,HttpSession session) {
        if (teaSessionService.init(session)==-1) return "login";
        model.addAttribute("courseName", courseName);
        Note note = noteService.selectById(noteId);
        model.addAttribute("note", note);
        session.setAttribute("courseId", note.getCourse().getId());

        String realPath = session.getServletContext().getRealPath("download");

        byte[] img = note.getImgContent();  //图片信息
        String name = note.getImgName(); // 图片名
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
        return "updateNotes";
    }

    @RequestMapping("/doUpdateNotes")
    public String doUpdateNotes(Integer id,String title, String courseName, String content, MultipartFile file,HttpSession session)
            throws IOException {
        Integer courseId = (Integer) session.getAttribute("courseId");
        Course course = courseService.selectById(courseId);
        Teacher LoginTeacher = (Teacher) session.getAttribute("sessionTeacher");
        byte[] bytes = file.getBytes();
        if (bytes == null || bytes.length == 0) {
            noteService.updateNote(id, title, content, new Date());
        } else {
            String name = file.getOriginalFilename();
            noteService.updateNoteAll(id, title, content, name, bytes, new Date());
        }
        return "forward:/teacher/teacherNotes";
    }


    @RequestMapping("/writeNotes")
    public String writeNotes(HttpSession session, Model model) {
        if (teaSessionService.init(session)==-1) return "login";
        Teacher LoginTeacher = (Teacher) session.getAttribute("sessionTeacher");


        List<Course> list = courseService.selectByTId(LoginTeacher.getId());
        model.addAttribute("courseList", list);
        //        request.setAttribute("courseList", list);
        return "writeNotes";
    }

    @RequestMapping("/doWriteNote")
    public String doWriteNote(String title, Integer course, String content, MultipartFile file, HttpSession session)
            throws IOException {
        if (teaSessionService.init(session)==-1) return "login";
        Course course1 = courseService.selectById(course);
        Teacher LoginTeacher = (Teacher) session.getAttribute("sessionTeacher");
        byte[] bytes = file.getBytes();
        String name = file.getOriginalFilename();
        Note note = new Note(0, title, course1, LoginTeacher, content, name, bytes, new Date());
        noteService.insertNote(note, file);
        List<Integer> users=userService.selectByCidAndTid(note.getCourse().getId());
        Note note1=noteService.selectNoteByCIDTID(course1.getId(), LoginTeacher.getId());
        for (Integer user : users) {
            noteSessionService.insert(user, note1.getId());
        }
        return "forward:/teacher/teacherNotes";
    }

    @RequestMapping("/viewNotes")
    public String viewNotes(Integer id, Model model,HttpSession session) {
        if (teaSessionService.init(session)==-1) return "login";
        Note note = noteService.selectById(id);
        model.addAttribute("note", note);

        String realPath = session.getServletContext().getRealPath("download");

        byte[] img = note.getImgContent();  //图片信息

        String name = note.getImgName(); // 图片名
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
        return "TeacherViewNotes";
    }

    @RequestMapping("/deleteOne")
    public String deleteOne(Integer noteId,HttpSession session){
        if (teaSessionService.init(session)==-1) return "login";
        noteService.deleteNoteById(noteId);

        return "forward:/teacher/teacherNotes";
    }

    @RequestMapping("/deleteSelect")
    public String deleteSelect(Integer[] checkbox,HttpSession session){
        if (teaSessionService.init(session)==-1) return "login";
        if (checkbox != null) {
            for (int i = 0; i <checkbox.length ; i++) {
                noteService.deleteNoteById(checkbox[i]);
            }
        }
        return "forward:/teacher/teacherNotes";
    }


}
