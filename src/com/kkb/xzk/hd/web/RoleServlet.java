package com.kkb.xzk.hd.web;

import com.kkb.xzk.hd.bean.Menu;
import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.service.MenuService;
import com.kkb.xzk.hd.service.MiddleService;
import com.kkb.xzk.hd.service.RoleService;
import com.kkb.xzk.hd.service.impl.MenuServiceImpl;
import com.kkb.xzk.hd.service.impl.MiddleServiceImpl;
import com.kkb.xzk.hd.service.impl.RoleServiceImpl;
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
 * @Date Created in 2021-07-30 0:09
 * @Modified By:
 */
@WebServlet(urlPatterns = {"/power/role/roleOperation"})
public class RoleServlet extends HttpServlet {
    RoleService roleService = new RoleServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("getAll".equals(method)){
            getAll(req, resp);
        }else if("selectMenus".equals(method)){
            selectMenus(req, resp);
        }else if("add".equals(method)){
            add(req, resp);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rolename = req.getParameter("rolename");
        Integer state = Integer.parseInt(req.getParameter("state"));
        String[] menuids = req.getParameterValues("menuid");

        int roleid = roleService.addRole(rolename, state);
        MiddleService middleService = new MiddleServiceImpl();
        int affectedRows = middleService.insertMiddle(roleid, menuids);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(affectedRows > 0){
            pw.println("<script>alert('添加成功！');location.href='/power/role/roleOperation?method=getAll'</script>");
        }else{
            pw.println("<script>alert('添加失败！');location.href='/power/role/roleOperation?method=selectMenus'</script>");
        }
    }

    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index = req.getParameter("index");
        int pageIndex = index==null||"".equals(index) ? 1 : Integer.parseInt(index);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageIndex(pageIndex);

        List<Role> roleList = roleService.getRoleList(pageIndex, pageUtil.getPageSize());
        pageUtil.setDataList(roleList);
        pageUtil.setTotal(roleService.total());

        req.setAttribute("p3", pageUtil);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    protected void selectMenus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuService menuService = new MenuServiceImpl();
        List<Menu> menuList = menuService.getMenuList();
        req.setAttribute("menuList", menuList);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
}