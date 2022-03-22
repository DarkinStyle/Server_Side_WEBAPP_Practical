package com.utar.myemployeeapp_full.weblisteners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class RequestListenerTracking implements ServletRequestListener {

    public RequestListenerTracking() {
    }


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequestListener.super.requestDestroyed(sre);
        System.out.println("Request Life cycle ends");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequestListener.super.requestInitialized(sre);
        System.out.println("Request Life cycle starts");
    }
}
