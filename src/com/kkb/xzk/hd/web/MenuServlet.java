package com.kkb.xzk.hd.web;

import com.kkb.xzk.hd.bean.Menu;
import com.kkb.xzk.hd.service.MenuService;
import com.kkb.xzk.hd.service.impl.MenuServiceImpl;
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
 * @Date Created in 2021-07-31 23:21
 * @Modified By:
 */
@WebServlet(urlPatterns = "/power/menu/menuOperation")
public class MenuServlet extends HttpServlet {
    private MenuService menuService = new MenuServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("getAll".equals(method)) {
            showAllMenus(req, resp);
        } else if ("selectUpMenus".equals(method)) {
            selectUpMenus(req, resp);
        } else if ("edit".equals(method)) {
            edit(req, resp);
        } else if ("add".equals(method)) {
            add(req, resp);
        } else if ("delete".equals(method)) {
            delete(req, resp);
        } else if ("deleteBatch".equals(method)) {
            deleteBatch(req, resp);
        }
    }

    protected void deleteBatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] menuids = req.getParameterValues("one");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(menuids == null || menuids.length == 0){
            pw.println("<script>alert('没有选中任何用户！');location.href='/power/menu/menuOperation?method=getAll'</script>");
            return;
        }

        boolean f = menuService.deleteBatch(menuids);
        if(f){
            pw.println("<script>alert('批量删除成功！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }else{
            pw.println("<script>alert('批量删除失败！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer menuid = Integer.parseInt(req.getParameter("menuid"));
        boolean f = menuService.delete(menuid);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(f){
            writer.print("<script>alert('删除成功！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }else{
            writer.print("<script>alert('删除失败！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuname = req.getParameter("menuname");
        Integer upmenuid = Integer.parseInt(req.getParameter("upmenuid"));
        Integer state = Integer.parseInt(req.getParameter("state"));
        String url = req.getParameter("url");
        String desc = req.getParameter("desc");

        Menu menu = new Menu();
        menu.setMenuname(menuname);
        menu.setUpmenuid(upmenuid);
        menu.setState(state);
        menu.setUrl(url);
        menu.setDesc(desc);

        boolean f = menuService.insert(menu);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(f){
            writer.print("<script>alert('添加成功！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }else{
            writer.print("<script>alert('添加失败！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }

    }
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer menuid = Integer.parseInt(req.getParameter("menuid"));
        String menuname = req.getParameter("menuname");
        Integer upmenuid = Integer.parseInt(req.getParameter("upmenuid"));
        Integer state = Integer.parseInt(req.getParameter("state"));
        String url = req.getParameter("url");
        String desc = req.getParameter("desc");

        Menu menu = new Menu();
        menu.setMenuid(menuid);
        menu.setMenuname(menuname);
        menu.setUpmenuid(upmenuid);
        menu.setState(state);
        menu.setUrl(url);
        menu.setDesc(desc);

        boolean f = menuService.update(menu);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(f){
            writer.print("<script>alert('修改成功！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }else{
            writer.print("<script>alert('修改失败！');location.href='/power/menu/menuOperation?method=getAll'</script>");
        }

    }

    protected void selectUpMenus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String menuidS = req.getParameter("menuid");
        menuidS = menuidS==null||"".equals(menuidS) ? "1" : menuidS;
        Integer menuid = Integer.parseInt(menuidS);

        String next = req.getParameter("next");

        Menu menu = menuService.getMenuById(menuid);
        List<Menu> upMenuList = menuService.getUpMenuList();
        req.setAttribute("menu", menu);
        req.setAttribute("upMenuList", upMenuList);

        if("info".equals(next)) {
            req.getRequestDispatcher("info.jsp").forward(req, resp);
        }else if("edit".equals(next)){
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }else if("add".equals(next)){
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        }
    }
    protected void showAllMenus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index = req.getParameter("index");
        Integer pageIndex = (index==null || "".equals(index)) ? 1 : Integer.parseInt(index);
        PageUtil pageUtil = new PageUtil();

        List<Menu> menuList = menuService.getMenuList(pageIndex, pageUtil.getPageSize());

        pageUtil.setPageIndex(pageIndex);
        pageUtil.setTotal(menuService.total());
        pageUtil.setDataList(menuList);

        req.setAttribute("p4", pageUtil);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
