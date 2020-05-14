package com.fehead.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nightessss 2020/5/14 14:21
 */
@WebFilter(filterName = "auditFilter", urlPatterns = {"/*"})
public class AuditFilter extends HttpFilter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.config = fConfig;
    }
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 获得应用上下文对象
        ServletContext context = config.getServletContext();
        System.out.println("RemoteAddress："+request.getRemoteAddr());
        System.out.println("RemoteHost："+request.getRemoteHost());
        context.log("RemoteAddress："+request.getRemoteAddr());
        context.log("RemoteHost："+request.getRemoteHost());
        // 请求转到下一资源或下一过滤器
        chain.doFilter(request, response);
    }
}
