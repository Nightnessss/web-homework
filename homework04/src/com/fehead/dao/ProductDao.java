package com.fehead.dao;

import com.fehead.beans.GoodsItem;
import com.fehead.beans.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nightessss 2020/5/13 23:17
 */
public class ProductDao {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/web_homework" +
            "?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "1948730080";

    private Connection con;

    public ProductDao() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> selectProduct() {
        List<Product> result = new ArrayList<>();
        try {
            String strSQL = "SELECT * FROM product";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strSQL);
            result = select(rs);
            st.close();
            //关闭SQL语句执行对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Product selectProductById(int id) {
        Product product = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
            ps.close();
            //关闭SQL语句执行对象
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public GoodsItem selectGoodsItemById(int id) {
        GoodsItem goodsItem = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM goods_item WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            goodsItem = new GoodsItem(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            ps.close();
            //关闭SQL语句执行对象
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goodsItem;
    }

    private List<Product> select(ResultSet rs) throws SQLException {

        List<Product> result = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String brand = rs.getString(3);
            double price = rs.getDouble(4);
            int stock = rs.getInt(5);
            Product product = new Product(id, name, brand, price, stock);
            result.add(product);
        }
        return result;
    }
}
