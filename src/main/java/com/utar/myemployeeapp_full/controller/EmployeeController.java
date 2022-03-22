package com.utar.myemployeeapp_full.controller;

import com.utar.myemployeeapp_full.model.entity.Employee;
import com.utar.myemployeeapp_full.model.service.EmployeeService;
import com.utar.myemployeeapp_full.model.sessionbean.EmployeeSessionBeanLocal;
import com.utar.myemployeeapp_full.utilities.ValidateManageLogic;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmployeeController", value = "/EmployeeController")
public class EmployeeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private EmployeeSessionBeanLocal empbean;

//    @Inject
//    private EmployeeService empbean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        try {
            Employee emp = empbean.findEmployee(id);
            request.setAttribute("EMP", emp);
            RequestDispatcher req = request.getRequestDispatcher("EmployeeUpdate.jsp");
            req.forward(request, response);
        } catch (EJBException ex) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean flag = false;
        String eid = request.getParameter("id");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String hiredate = request.getParameter("hdate");
        PrintWriter out = response.getWriter();
// this line is to package the whole values into one array string variable -
// easier just pass one parameter object
        String[] s = { eid, fname, lname, gender, dob, hiredate };
        try {
            if (ValidateManageLogic.validateManager(request).equals("UPDATE")) {
// call session bean updateEmployee method
                empbean.updateEmployee(s);
                flag = true;
            } else if (ValidateManageLogic.validateManager(request).equals("AJAX")) {
                List<Employee> h = empbean.searchEmployeeAjax(eid);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String result = null;

                if(h != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(out, h);
                } else {
                    out.println(result);
                }
            }
            else if (ValidateManageLogic.validateManager(request).equals("DELETE")) {
// call session bean deleteEmployee method
                empbean.deleteEmployee(eid);
                flag = true;
// if ADD button is clicked
            } else {
// call session bean addEmployee method
                empbean.addEmployee(s);
                flag = true;
            }
// this line is to redirect to notify record has been updated and redirect to
// another page
            if(flag) {
                ValidateManageLogic.navigateJS(out);
            }
        } catch (EJBException ex) {
        }
    }
}
