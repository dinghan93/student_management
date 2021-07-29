package com.kkb.xzk.hd.web;

import com.kkb.xzk.hd.bean.Grade;
import com.kkb.xzk.hd.service.GradeService;
import com.kkb.xzk.hd.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-28 17:18
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/showGradeList")
public class ShowGradeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GradeService gradeService = new GradeServiceImpl();
        List<Grade> grades = gradeService.getAllGrades();
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
}
