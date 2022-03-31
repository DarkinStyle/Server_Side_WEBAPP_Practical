package com.utar.myemployeeapp_full.controller;

import com.utar.myemployeeapp_full.webservice.EmployeeWebService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class APIApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(EmployeeWebService.class);
        return set;
    }

}
