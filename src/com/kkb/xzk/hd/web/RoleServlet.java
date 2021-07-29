package com.kkb.xzk.hd.web;

import com.kkb.xzk.hd.bean.Role;
import com.kkb.xzk.hd.service.RoleService;
import com.kkb.xzk.hd.service.impl.RoleServiceImpl;
import com.kkb.xzk.hd.util.PageUtil;

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
}
