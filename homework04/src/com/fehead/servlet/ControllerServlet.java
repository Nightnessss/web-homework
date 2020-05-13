package com.fehead.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Nightessss 2020/5/12 16:15
 */
@WebServlet(name = "controllerServlet", urlPatterns = {"/showProduct", "/deleteItem", "/addToCart"})
public class ControllerServlet extends HttpServlet {

        private final String SHOW_PRODUCT = "showProduct";
        private final String DELETE_ITEM = "deleteItem";
        private final String ADD_TO_CART = "addTdCart";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的URI地址信息
        String url = req.getRequestURI();
        // 截取其中的方法名
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));

        Method method = null;
        try {
            method = getClass().getMethod(methodName, HttpServletRequest.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        switch (methodName) {
            case SHOW_PRODUCT:
                showProduct();
                break;
            case DELETE_ITEM:
                deleteItem();
                break;
            case ADD_TO_CART:
                addTdCart();
                break;
            default:
                break;
        }


    }

    private void showProduct() {

    }
    private void deleteItem() {

    }
    private void addTdCart() {

    }
}
