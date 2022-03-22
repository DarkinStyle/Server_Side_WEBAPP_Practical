package com.utar.myemployeeapp_full.controller;

import com.utar.myemployeeapp_full.model.entity.Employee;
import com.utar.myemployeeapp_full.model.sessionbean.EmployeeSessionBeanLocal;
import com.utar.myemployeeapp_full.utilities.EmployeeSummary;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeSummaryController", value = "/EmployeeSummaryController")
public class EmployeeSummaryController extends HttpServlet {

    @EJB
    private EmployeeSessionBeanLocal empbean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

        String json = "";
        if (br != null) {
            json = br.readLine();
        }
        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 3. Convert received JSON to EmployeeSummary
        EmployeeSummary empsummary = mapper.readValue(json, EmployeeSummary.class);
        List<Employee> t = empbean.searchEmployeeAjax(empsummary.getId().toString());

        if(t!= null) {
            Employee e = t.get(0);
            empsummary.setFullname(e.getFirstName() + " " + e.getLastName());
            Date date = e.getBirthDate();

            Instant instant = date.toInstant();
            ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
            LocalDate givenDate = zone.toLocalDate();
            Period period = Period.between(givenDate, LocalDate.now());
            empsummary.setAge(period.getYears() + " years " + period.getMonths() + " months " + period.getDays() + " days");
            mapper.writeValue(response.getOutputStream(), empsummary);

        } else {
            //mapper.writeValue(response.getOutputStream(), t.get(0);
            mapper.writeValue(response.getWriter(), t);
        }

    }
}
