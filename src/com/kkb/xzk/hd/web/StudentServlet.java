package com.kkb.xzk.hd.web;

import com.kkb.xzk.hd.bean.Grade;
import com.kkb.xzk.hd.bean.Student;
import com.kkb.xzk.hd.service.GradeService;
import com.kkb.xzk.hd.service.StudentService;
import com.kkb.xzk.hd.service.impl.GradeServiceImpl;
import com.kkb.xzk.hd.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-28 22:58
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/stuOperation")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("add".equals(method)){
            add(req, resp);
        }else if("delete".equals(method)){
            delete(req, resp);
        }else if("getById".equals(method)){
            getById(req, resp);
        }else if("update".equals(method)){
            update(req, resp);
        }else{
            getAll(req, resp);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuname = req.getParameter("stuname");
        String stuno = req.getParameter("stuno");
        String sexS = req.getParameter("sex");
        int sex = (sexS==null || "".equals(sexS)) ? -1 : Integer.parseInt(sexS);
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String registered = req.getParameter("registered");
        String address = req.getParameter("address");
        String profession = req.getParameter("profession");
        String idnumber = req.getParameter("idnumber");
        String politics = req.getParameter("politics");
        java.util.Date regdate = new java.util.Date();
        int state = 1;
        String introduction = req.getParameter("introduction");
        int gid = Integer.parseInt(req.getParameter("gid"));

        Student student = new Student(0, stuname, stuno, sex, phone, email, registered, address, profession, idnumber, politics, new Date(regdate.getTime()), state, introduction, gid, null);
        StudentService studentService = new StudentServiceImpl();
        int i = studentService.insertStudent(student);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(i > 0){ //添加成功
            pw.println("<script>alert('添加成功！');location.href = '/Educational/student/stuOperation';</script>");
        }else{ //添加失败
            pw.println("<script>alert('添加失败！');location.href = '/Educational/student/showGradeList';</script>");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stuid = Integer.parseInt(req.getParameter("stuid"));
        StudentService studentService = new StudentServiceImpl();
        int i = studentService.delStudentById(stuid);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(i > 0){
            pw.println("<script>alert('删除成功');location.href='/Educational/student/stuOperation'</script>");
        }else{
            pw.println("<script>alert('删除失败');location.href='/Educational/student/stuOperation'</script>");
        }
    }

    protected void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stuid = Integer.parseInt(req.getParameter("stuid"));

        StudentService studentService = new StudentServiceImpl();
        GradeService gradeService = new GradeServiceImpl();
        Student s = studentService.getStudentById(stuid);
        req.setAttribute("stu", s);
        req.setAttribute("stuid", stuid);
        List<Grade> grades = gradeService.getAllGrades();
        req.setAttribute("grades", grades);

        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取参数
        String stuname = req.getParameter("stuname");
        String stuno = req.getParameter("stuno");
        String sexString = req.getParameter("sex");
        int sex = (sexString==null || "".equals(sexString))? -1 : Integer.parseInt(sexString);
        String pageIndex = req.getParameter("pageIndex");
        int index = (pageIndex==null||"".equals(pageIndex)) ? 1 : Integer.parseInt(req.getParameter("pageIndex"));
        //2. 调用service服务

        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.getAllStudents(stuno, stuname, sex, index,5);
        int total = studentService.getNum(stuno, stuname, sex);
        int itemsInEachPage = students.size();
        int totalPages = total%5==0 ? total/5 : total/5+1;

        req.setAttribute("students", students);
        req.setAttribute("stuname", stuname);
        req.setAttribute("stuno", stuno);
        req.setAttribute("sex", sex);
        req.setAttribute("total", total);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("index", index);
        req.setAttribute("itemsInEachPage", itemsInEachPage);

        //3. 页面跳转
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int stuid = Integer.parseInt(req.getParameter("stuid"));
        String stuname = req.getParameter("stuname");
        String stuno = req.getParameter("stuno");
        String sexS = req.getParameter("sex");
        int sex = (sexS==null || "".equals(sexS)) ? -1 : Integer.parseInt(sexS);
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String registered = req.getParameter("registered");
        String address = req.getParameter("address");
        String profession = req.getParameter("profession");
        String idnumber = req.getParameter("idnumber");
        String politics = req.getParameter("politics");
        java.util.Date regdate = new java.util.Date();
        int state = 1;
        String introduction = req.getParameter("introduction");
        int gid = Integer.parseInt(req.getParameter("gid"));

        Student student = new Student(stuid, stuname, stuno, sex, phone, email, registered, address, profession, idnumber, politics, new Date(regdate.getTime()), state, introduction, gid, null);
        StudentService studentService = new StudentServiceImpl();
        int i = studentService.modifyStudent(student);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(i > 0){
            pw.println("<script>alert('修改成功！');location.href = '/Educational/student/stuOperation';</script>");
        }else{
            pw.println("<script>alert('修改失败！');location.href='/Educational/student/stuOperation?method=getById&stuid="+stuid+"';</script>");
        }
    }
}
