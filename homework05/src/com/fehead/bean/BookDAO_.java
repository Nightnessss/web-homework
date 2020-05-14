package com.fehead.bean;

import java.sql.*;

/**
 * @author Nightessss 2020/5/14 16:31
 */
public class BookDAO_ {

    private static Connection con;

    //    public static void main(String[] args) {
//        try{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
//        con=DriverManager.getConnection(url,"root","980516");
//        BookBean book = new BookBean("110","test","me","陕西科技大学", (float) 12.1);
//        String sql="insert into books values('"+book.getBookId()+"','"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getPublisher()+"',"+book.getPrice()+")";
//        Statement st=con.createStatement();
//        boolean rs=st.execute(sql);
//            System.out.println(rs);
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
    public BookDAO_() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/web_homework?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        con= DriverManager.getConnection(url,"root","1948730080");
    }
    public BookBean searchBook(String bookId) throws SQLException, ClassNotFoundException
    {
        BookBean bookbean=new BookBean();
        Statement st=con.createStatement();
        String sql="select * from book where BOOKID="+bookId;
        ResultSet rs=st.executeQuery(sql);
        if(rs.next())
        {
            bookbean.setBookId(rs.getString(1));
            bookbean.setTitle(rs.getString(2));
            bookbean.setAuthor(rs.getString(3));
            bookbean.setPublisher(rs.getString(4));
            bookbean.setPrice(rs.getFloat(5));
        }else
        {
            return null;
        }
        return bookbean;

    }
    public boolean insertBook(BookBean book) throws SQLException
    {
        Statement st=con.createStatement();
        String sql="insert into book values('"+book.getBookId()+"','"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getPublisher()+"',"+book.getPrice()+")";
        boolean rs=st.execute(sql);
        if(!rs)
        {
            return true;
        }
        return false;
    }
}
