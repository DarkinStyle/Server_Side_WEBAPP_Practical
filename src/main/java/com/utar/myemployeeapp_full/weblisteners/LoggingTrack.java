package com.utar.myemployeeapp_full.weblisteners;

import com.utar.myemployeeapp_full.utilities.LoggingGeneral;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class LoggingTrack implements ServletContextListener {

    public LoggingTrack() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */

        sce.getServletContext().setAttribute("log", new LoggingGeneral());
        System.out.println("Application Life cycle starts");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("Application Life cycle ends");
        sce.getServletContext().removeAttribute("log");
    }

}
