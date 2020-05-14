package com.fehead.bean;

import java.sql.*;

/**
 * @author Nightessss 2020/5/14 16:30
 */
public class BookDAO {
    private static Connection con;

    public BookDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/web_homework?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
            con = DriverManager.getConnection(url, "root", "1948730080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet result() throws ClassNotFoundException, SQLException {
        Statement stmt = con.createStatement();
        String sql = "select * from book";
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
}
