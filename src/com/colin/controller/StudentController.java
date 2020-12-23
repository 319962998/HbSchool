package com.colin.controller;

import com.colin.bean.Note;
import com.colin.bean.NoteSession;

import com.colin.bean.User;
import com.colin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping("/student")
@MultipartConfig
public class StudentController {

    @Autowired
    NoteService noteService;

    @Autowired
    NoteSessionService noteSessionService ;

    @Autowired
    PageService pageService;
    @Autowired
    ForumNumberService forumNumberService;
    @Autowired
    StuSessionService stuSessionService;
    @RequestMapping("/studentNotes")
    public String studentNotes(Integer currentPage, HttpSession session, Model model){
        if (stuSessionService.init(session)==-1) return "login";
        if (currentPage == null || currentPage < 1) {
            currentPage = 1;
        }

        User user =  (User) session.getAttribute("sessionUser");
        final int len = 8;   //每页几条数据

        int totalPage = noteService.getTotalPage(user, len);
        model.addAttribute("totalPage", totalPage);
        //笔记相关信息
        Map<Note, Boolean> notes = noteService.selectByStudent(user, currentPage, len);
        model.addAttribute("notesMap", notes);

        currentPage = currentPage > totalPage ? totalPage : Math.max(currentPage, 1);
        model.addAttribute("currentPage", currentPage);

        // 获取未查看笔记数目
        Integer noteCount = noteSessionService.selectCountBySId(user.getId());
        model.addAttribute("noteCount", noteCount);

        return "studentNotes";
    }

    /**
     * 查看页面，并将note_session中对应数据删除，代表已经查看过
     * @param id note的id
     */
    @RequestMapping("/viewNotes")
    public String viewNotes(Integer id, Model model,HttpSession session) {
        if (stuSessionService.init(session)==-1) return "login";
        User user =  (User) session.getAttribute("sessionUser");

        //当前note已经查看，从note_session表中删除
        noteSessionService.deleteBySIdAndNId(user.getId(), id);

        // 获取未查看笔记数目
        Integer noteCount = noteSessionService.selectCountBySId(user.getId());
        model.addAttribute("noteCount", noteCount);

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
                fos.flush();
                bop.flush();
                bop.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("每有图片");  //todo 可以用个提升无图片的图片代替
            }
        }
        file.deleteOnExit();
        return "viewNotes";
    }



}
