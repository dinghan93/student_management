package com.kkb.xzk.hd.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: HanDing
 * @Description:
 * @Date Created in 2021-07-27 15:59
 * @Modified By:
 */
@WebFilter(urlPatterns = "/index.jsp")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        System.out.println(uri);
        if((uri.endsWith("index.jsp") || uri.equals("/")) && request.getSession().getAttribute("u1")==null){
            response.getWriter().println("<script>location.href='login.jsp';alert('请先登录！');</script>");
            //response.sendRedirect("login.jsp");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
