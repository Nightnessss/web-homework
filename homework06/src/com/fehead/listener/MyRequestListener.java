package com.fehead.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Nightessss 2020/5/14 14:13
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {
    private int count=0;
    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre)  {
        // TODO Auto-generated method stub
        HttpServletRequest request=(HttpServletRequest)sre.getServletRequest();
        if(request.getRequestURI().endsWith("onlineCount.jsp")) {
            count++;
            sre.getServletContext().setAttribute("count", new Integer(count));
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre)  {

    }
}
