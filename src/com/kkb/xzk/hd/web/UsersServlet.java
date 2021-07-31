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
        }else if("edit".equals(method)){
            edit(req, resp);
        }else if("delete".equals(method)){
            delete(req, resp);
        }else if("deleteBatch".equals(method)){
            deleteBatch(req, resp);
        }

    }

    protected void deleteBatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] userids = req.getParameterValues("one");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(userids == null || userids.length == 0){
            pw.println("<script>alert('没有选中任何用户！');location.href='/power/user/usersOperation?method=getAll'</script>");
            return;
        }

        int i = usersService.deleteBatch(userids);
        if(i > 0){
            pw.println("<script>alert('批量删除成功！');location.href='/power/user/usersOperation?method=getAll'</script>");
        }else{
            pw.println("<script>alert('批量删除失败！');location.href='/power/user/usersOperation?method=getAll'</script>");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userid = Integer.parseInt(req.getParameter("userid"));
        boolean f = usersService.delete(userid);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(f){
            pw.println("<script>alert('删除成功！');location.href='/power/user/usersOperation?method=getAll'</script>");
        }else{
            pw.println("<script>alert('删除失败！');location.href='/power/user/usersOperation?method=getAll'</script>");
        }
    }
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userid = Integer.parseInt(req.getParameter("userid"));
        String loginname = req.getParameter("loginname");
        String password = req.getParameter("password");
        String realname = req.getParameter("realname");
        Integer roleid = Integer.parseInt(req.getParameter("roleid"));
        Integer sex = Integer.parseInt(req.getParameter("sex"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String cardid = req.getParameter("cardid");
        String desc = req.getParameter("desc");

        Users u = new Users();
        u.setUserid(userid);
        u.setLoginname(loginname);
        u.setPassword(password);
        u.setRealname(realname);
        u.setRoleid(roleid);
        u.setSex(sex);
        u.setEmail(email);
        u.setPhone(phone);
        u.setAddress(address);
        u.setCardid(cardid);
        u.setDesc(desc);
        boolean f = usersService.updateUsers(u);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(f){
            pw.println("<script>alert('更新成功！');location.href='/power/user/usersOperation?method=getAll'</script>");
        }else{
            pw.println("<script>alert('更新失败！');location.href='/power/user/usersOperation?method=showRoleList&next=edit&userid="+userid+"'</script>");
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
        // 1.接收next参数
        String next = req.getParameter("next");
        //2. 调用service方法
        List<Role> roleList = usersService.getRoleList();

        req.setAttribute("roleList", roleList);
        if(next==null || "".equals(next)){
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        }else{
            // 通过userid查找用户
            int userid = Integer.parseInt(req.getParameter("userid"));
            Users u = usersService.getUsersById(userid);
            req.setAttribute("users",u);
            if("edit".equals(next)) {
                req.getRequestDispatcher("edit.jsp").forward(req, resp);
            }else if("info".equals(next)){
                req.getRequestDispatcher("info.jsp").forward(req, resp);
            }
        }

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
