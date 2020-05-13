package com.fehead.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Nightessss 2020/5/9 14:34
 */
@WebServlet(name = "ShowSessionInfo", urlPatterns = {"/session"})
public class ShowSessionInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        HttpSession session = request.getSession();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        // 输出文本
        PrintWriter out = response.getWriter();
        long creationTime = session.getCreationTime();
        long lastAccessTime = session.getLastAccessedTime();
        out.write("<div style=\"text-align: center;\">");
        out.write("<h1>Welcome Back</h1>");
        out.write("<h2>Information about your session</h2>");
        out.write("<table border=\"1\" align=\"center\">");
        out.write("<thead style=\"background-color: orange;text-align:center\">\n" +
                "            <tr>\n" +
                "                <td>Info Type</td>\n" +
                "                <td>Value</td>\n" +
                "            </tr>\n" +
                "    </thead>");
        out.write("<tbody>\n" +
                "            <tr>\n" +
                "                <td>ID</td>\n" +
                "                <td>" + session.getId() + "</td>\n" +
                "            </tr>");
        out.write("<tr>\n" +
                "                <td>Creation Type:</td>\n" +
                "                <td>" + new Date(creationTime) + "</td>\n" +
                "            </tr>");
        out.write("            <tr>\n" +
                "                <td>Time of last access:</td>\n" +
                "                <td>" + new Date(lastAccessTime) + "</td>\n" +
                "            </tr>");
        out.write("            <tr>\n" +
                "                <td>Access number:</td>\n" +
                "                <td>" + count + "</td>\n" +
                "            </tr>\n" +
                "            </tbody>");
        out.write("</table>\n" +
                "    </div>");

        servletContext.setAttribute("count", count);

    }
}
