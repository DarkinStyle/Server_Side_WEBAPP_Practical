package com.utar.myemployeeapp_full.weblisteners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class UserTrackingListener implements HttpSessionListener {

    private static int userId = 1000;
    private static int users = 0;
    public UserTrackingListener() {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        //users++;
        System.out.println("Session Life cycle starts");
        userId++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */

        //users--;
        System.out.println("Session Life cycle ends");
        userId--;
    }

//    public static int getActiveSessions() {
//
//
//        return users; }

    public static int getUserId() {
        return userId;
    }
}
