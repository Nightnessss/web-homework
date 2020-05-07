package com.demo;


import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Nightnessss 2020/4/6 23:07
 */
public class FirstServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String sno = request.getParameter("sno");
        String name = request.getParameter("name");
        Student student = new Student(sno, name);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/secondServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
