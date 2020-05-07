package com.demo;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nightnessss 2020/5/5 9:57
 */
@WebServlet(name = "ConfigDemoServlet",
            urlPatterns = { "/configDemo.do" },
            initParams = {
                    @WebInitParam(name = "email", value = "hacker@163.com"),
                    @WebInitParam(name = "telephone", value = "8899123")
            })
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        // 输出文本
        PrintWriter out = response.getWriter();
        out.write("<p>Servlet名称：" + this.getServletName() + "</p>");
        out.write("<p>Email地址：" + this.getInitParameter("email") + "</p>");
        out.write("<p>电话：" + this.getInitParameter("telephone") + "</p>");

    }
}
