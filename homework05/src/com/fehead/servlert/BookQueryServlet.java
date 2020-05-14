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
 * @author Nightessss 2020/5/14 16:37
 */
@WebServlet(name = "BookQueryServlet",urlPatterns = "/BookQueryServlet")
public class BookQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setCharacterEncoding("utf-8");
        String bookId = request.getParameter("bookId");
        try {
            BookDAO_ bookdao = new BookDAO_();
            BookBean book = bookdao.searchBook(bookId);
            if(book!=null){
                request.getSession().setAttribute("book", book);
                RequestDispatcher view = request.getRequestDispatcher("jsp/display.jsp");
                view.forward(request, response);
            }else{
                RequestDispatcher view = request.getRequestDispatcher("jsp/errorPage.jsp");
                view.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
