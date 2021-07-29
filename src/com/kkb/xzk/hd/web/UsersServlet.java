package com.kkb.xzk.hd.web;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.bean.Users;
import com.kkb.xzk.hd.service.UsersService;
import com.kkb.xzk.hd.service.impl.UsersServiceImpl;
import com.kkb.xzk.hd.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-29 21:29
 * @Modified By:
 */
@WebServlet(urlPatterns = {"/power/user/usersOperation"})
public class UsersServlet extends HttpServlet {
    UsersService usersService = new UsersServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("getAll".equals(method)){
            showAllUsers(req, resp);
        }else if("showRoleList".equals(method)){
            showRoleList(req, resp);
        }else if("add".equals(method)){
            add(req, resp);
        }

    }

    protected void showAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收参数
        String index = req.getParameter("index");
        int pageIndex = (index==null||"".equals(index)) ? 1 : Integer.parseInt(index);

        // 2.调用service方法
        PageUtil pageUtil = new PageUtil();
        List<Users> usersList = usersService.getAllUsers(pageIndex, pageUtil.getPageSize());
        int total = usersService.getAllUsersCount();
        pageUtil.setTotal(total);
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setDataList(usersList);

        // 3.保存参数并跳转页面
        req.setAttribute("p2", pageUtil);
        //req.setAttribute("usersList", usersList);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    protected void showRoleList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2. 调用service方法
        List<Role> roleList = usersService.getRoleList();

        req.setAttribute("roleList", roleList);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users u  = new Users();
        u.setLoginname(req.getParameter("loginname"));
        u.setPassword(req.getParameter("password"));
        u.setRealname(req.getParameter("realname"));
        u.setSex(Integer.parseInt(req.getParameter("sex")));
        u.setEmail(req.getParameter("email"));
        u.setAddress(req.getParameter("address"));
        u.setPhone(req.getParameter("phone"));
        u.setCardid(req.getParameter("cardid"));
        u.setDesc(req.getParameter("desc"));
        u.setRoleid(Integer.parseInt(req.getParameter("roleid")));

        int i = usersService.addUsers(u);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(i > 0){
            pw.println("<script>alert('添加成功！');location.href='/power/user/usersOperation?method=getAll'</script>");
        }else{
            pw.println("<script>alert('添加失败！');location.href='/power/user/usersOperation?method=showRoleList'</script>");
        }
    }
}
