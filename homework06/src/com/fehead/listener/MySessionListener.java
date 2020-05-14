package com.fehead.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * @author Nightessss 2020/5/14 14:03
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
    private ServletContext context=null;
    @Override
    public void sessionCreated(HttpSessionEvent se)  {
        HttpSession session=se.getSession();
        context=session.getServletContext();
        ArrayList<HttpSession> sessionList=(ArrayList<HttpSession>)context.getAttribute("sessionList");
        if(sessionList==null) {
            sessionList=new ArrayList<>();
            sessionList.add(session);
            context.setAttribute("sessionList", sessionList);
        }else {
            sessionList.add(session);
        }
        context.log("创建一个会话："+session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se)  {
        HttpSession session=se.getSession();
        context=session.getServletContext();
        ArrayList<HttpSession> sessionList=(ArrayList<HttpSession>)context.getAttribute("sessionList");
        sessionList.remove(session);
        context.log("销毁一个会话："+session.getId());
    }
}
