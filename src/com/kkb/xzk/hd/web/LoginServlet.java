package com.kkb.xzk.hd.web;

import com.kkb.xzk.hd.bean.Users;
import com.kkb.xzk.hd.service.UsersService;
import com.kkb.xzk.hd.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 12:10
 * @Modified By:
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UsersService usersService = new UsersServiceImpl();
        Users u = usersService.getUsers(username, password);
        if(u != null){
            req.getSession().setAttribute("u1",u);
            resp.sendRedirect("index.jsp");
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.println("<script>location.href='login.jsp';alert('用户名或密码输入错误');</script>");
        }
    }
}
