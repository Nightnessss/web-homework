package com.fehead.servlert;

import com.fehead.bean.BookBean;
import com.fehead.bean.BookDAO_;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Nightessss 2020/5/14 16:35
 */
@WebServlet(name = "BookInsertServlet",urlPatterns = "/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        BookBean book = new BookBean(
                request.getParameter("bookId"),request.getParameter("title"),
                request.getParameter("author"),request.getParameter("publisher"),
                Float.parseFloat(request.getParameter("price"))
        );

        try {
            BookDAO_ bookdao = new BookDAO_();
            if(bookdao.insertBook(book)){
                RequestDispatcher view = request.getRequestDispatcher("jsp/display.jsp");
                view.forward(request, response);
            }else{
                RequestDispatcher view = request.getRequestDispatcher("jsp/errorPage.jsp");
                view.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
