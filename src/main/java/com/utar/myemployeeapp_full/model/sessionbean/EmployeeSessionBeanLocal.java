package com.utar.myemployeeapp_full.model.sessionbean;



import com.utar.myemployeeapp_full.model.entity.Employee;


import javax.ejb.EJBException;
import javax.ejb.Local;
import java.util.List;


@Local
public interface EmployeeSessionBeanLocal {

    public List<Employee> getAllEmployees() throws EJBException;
    public Employee findEmployee(String id) throws EJBException;
    public List<Employee> readEmployee(int currentPage, int recordsPerPage, String keyword, String direction) throws EJBException;
    public int getNumberOfRows(String keyword) throws EJBException ;
    public void updateEmployee(String[] s) throws EJBException;
    public void deleteEmployee(String id) throws EJBException;
    public void addEmployee(String[] s) throws EJBException;
    public List<Employee> searchEmployeeAjax(String empid) throws EJBException;

    // practical 9 Advanced EE Patterns
    public List<Employee> getEmployeeByName(String firstName, String lastName) throws EJBException;
    public List<Employee> getEmployee(String id) throws EJBException;

}
