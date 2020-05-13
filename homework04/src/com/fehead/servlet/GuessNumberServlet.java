package com.fehead.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nightessss 2020/5/10 18:34
 */
//@WebServlet(name = "GuessNumberServlet", urlPatterns = {"guessNumber"})
public class GuessNumberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int randInt = (int) (Math.random()*100 +1);
        session.setAttribute("randInt", randInt);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.write("<h2>猜猜随机数</h2>");
        out.write("<form action=\"guessNumber\" method=\"post\">");
        out.write("<p><input type=\"text\" name=\"guessNumber\" /></p>");
        out.write("<p><input type=\"submit\" value=\"提交\" /></p>");
        out.write("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String guessNumberStr = req.getParameter("guessNumber");
        Object randIntStr = session.getAttribute("randInt");
        if (guessNumberStr.isEmpty()) {
            out.write("传参不能为空");
            out.write("<form action=\"guessNumber\" method=\"post\">");
            out.write("<p><input type=\"text\" name=\"guessNumber\" /></p>");
            out.write("<p><input type=\"submit\" value=\"提交\" /></p>");
            out.write("</form>");
            return;
        }
        if (randIntStr == null) {
            out.write("session失效");
            out.write("<p><a href=\"http://localhost:8080/homework04/guessNumber\">再来一次</a></p>");
            return;
        }
        int guessNumber = 0;
        try {
            guessNumber = Integer.parseInt(guessNumberStr);
        } catch (NumberFormatException e) {
            out.write("请输入数字");
            out.write("<form action=\"guessNumber\" method=\"post\">");
            out.write("<p><input type=\"text\" name=\"guessNumber\" /></p>");
            out.write("<p><input type=\"submit\" value=\"提交\" /></p>");
            out.write("</form>");
            return;
        }
        int randInt = (int) randIntStr;
        if (guessNumber == randInt) {
            out.write("<h2>恭喜你猜对了！</h2>");
            out.write("<p><a href=\"http://localhost:8080/homework04/guessNumber\">再来一次</a></p>");
        } else if (guessNumber > randInt) {
            out.write("<h2>猜得大了</h2>");
            out.write("<form action=\"guessNumber\" method=\"post\">");
            out.write("<p><input type=\"text\" name=\"guessNumber\" /></p>");
            out.write("<p><input type=\"submit\" value=\"提交\" /></p>");
            out.write("</form>");
        } else {
            out.write("<h2>猜得小了</h2>");
            out.write("<form action=\"guessNumber\" method=\"post\">");
            out.write("<p><input type=\"text\" name=\"guessNumber\" /></p>");
            out.write("<p><input type=\"submit\" value=\"提交\" /></p>");
            out.write("</form>");
        }
    }
}
