package com.fehead.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.time.LocalTime;

/**
 * @author Nightessss 2020/5/14 11:14
 */
@WebListener
public class MyServletContextListener implements ServletContextListener, ServletContextAttributeListener {
    private ServletContext context = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Context ctx = null;
        DataSource dataSource = null;
        context = sce.getServletContext();
        try{
            ctx = new InitialContext();
            dataSource =
                    (DataSource)ctx.lookup("java:comp/env/jdbc/DBPool");
        }catch(NamingException ne){
            context.log("发生异常:"+ne);
        }
        context.setAttribute("dataSource",dataSource);
        context.log("应用程序已启动："+ LocalTime.now());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.removeAttribute("dataSource");
        context.log("应用程序已关闭："+ LocalTime.now());
    }
    @Override
    public void attributeAdded(ServletContextAttributeEvent sce){
        context = sce.getServletContext();
        context.log("添加一个属性："+sce.getName()+"："+sce.getValue());
    }
    @Override
    public void attributeRemoved(ServletContextAttributeEvent sce){
        context = sce.getServletContext();
        context.log("删除一个属性："+sce.getName()+"："+sce.getValue());
    }
    @Override
    public void attributeReplaced(ServletContextAttributeEvent sce){
        context = sce.getServletContext();
        context.log("替换一个属性："+sce.getName()+"："+sce.getValue());
    }

}
