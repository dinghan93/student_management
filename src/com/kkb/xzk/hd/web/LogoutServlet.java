package com.kkb.xzk.hd.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 16:33
 * @Modified By:
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("<script>alert('退出成功');top.location.href='login.jsp';</script>");
    }
}
