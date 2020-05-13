package com.fehead.servlet;

import com.fehead.beans.GoodsItem;
import com.fehead.beans.Product;
import com.fehead.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nightessss 2020/5/12 16:15
 */
@WebServlet(name = "controllerServlet", urlPatterns = {"/showProduct", "/deleteItem", "/addToCart", "/showCart"})
public class ControllerServlet extends HttpServlet {

    private final String BASE_URL = "/homework04/";
    private final String SHOW_PRODUCT = BASE_URL + "showProduct";
    private final String DELETE_ITEM = BASE_URL + "deleteItem";
    private final String ADD_TO_CART = BASE_URL + "addToCart";
    private final String SHOW_CART = BASE_URL + "showCart";

    private ProductDao productDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的URI地址信息
        String url = req.getRequestURI();
        // 截取其中的方法名
        String methodName = url;

        switch (methodName) {
            case SHOW_PRODUCT:
                showProduct(req, resp);
                break;
            case DELETE_ITEM:
                deleteItem(req, resp);
                break;
            case ADD_TO_CART:
                doPost(req, resp);
                break;
            case SHOW_CART:
                showCart(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addToCart(req, resp);
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> products = new ArrayList<>();
//        products.add(new Product(1, "发卡", "得力", 10.5, 20));
//        products.add(new Product(2, "帆布鞋", "匡威", 205.0, 210));
//        products.add(new Product(3, "玩具熊", "宝宝", 95.5, 52));
        products = productDao.selectProduct();
        request.setAttribute("products", products);
        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }
    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsItem> goodsItems = (List<GoodsItem>) request.getSession().getAttribute("goodsItems");
        request.setAttribute("goodsItem", goodsItems);
        request.getRequestDispatcher("jsp/showCart.jsp").forward(request, response);
    }
    private void deleteItem(HttpServletRequest request, HttpServletResponse response) {

    }
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id.isEmpty()) {
            return;
        }

        Product product = productDao.selectProductById(Integer.parseInt(id));
        GoodsItem goodsItem = new GoodsItem(product.getId(), product.getName(), product.getPrice());
        HttpSession session = request.getSession();
        List<GoodsItem> goodsItems = (List<GoodsItem>) session.getAttribute("goodsItems");
        if (goodsItems == null) {
            goodsItems = new ArrayList<>();
        }
        goodsItems.add(goodsItem);
        session.setAttribute("goodsItems", goodsItems);
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}
