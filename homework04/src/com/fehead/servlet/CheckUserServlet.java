package com.fehead.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nightessss 2020/5/12 19:50
 */
@WebServlet(name = "CheckUserServlet",urlPatterns = "/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("admin") && password.equals("admin")){
            if(request.getParameter("autoLogin").equals("on")){
                request.getSession().setAttribute("username",username);
                Cookie cUsername = new Cookie("username",username);
                Cookie cPassword = new Cookie("password",password);
                cUsername.setMaxAge(60*60);cUsername.setPath("/");
                cPassword.setMaxAge(60*60);cPassword.setPath("/");
                response.addCookie(cUsername);
                response.addCookie(cPassword);
            }
            out.println("Login succeed!");
            response.setHeader("refresh", "3;url=/CheckUserServlet");
        }else{
            out.println("<div>Login failed！</div>");
            response.setHeader("refresh", "3;url=/jsp/login.jsp");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //设置response
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("UTF-8");
        PrintWriter out = response.getWriter();

        String username=null;
        String password=null;
        //检测是否有cookie,cookie[0]是JSESSIONID!!!
        Cookie cookies[] = request.getCookies();
        if(cookies.length == 1 && ((String)cookies[0].getName()).equals("JSESSIONID")){
            out.println("Login failed! no cookie!");
            response.setHeader("refresh", "3;url=/jsp/login.jsp");
        }else{
        }
        //读cookie
        for(int i=0;i<cookies.length;i++){
            if((cookies[i].getName()).equals("username")){
                username = cookies[i].getValue();
            }
            if((cookies[i].getName()).equals("password")){
                password = cookies[i].getValue();
            }
        }
        //验证cookie合法
        if(username.equals("admin") && password.equals("admin")){
            out.println("Welcome!"+username);
        }else{
            response.setHeader("refresh", "3;url=/jsp/login.jsp");
        }
    }
}
