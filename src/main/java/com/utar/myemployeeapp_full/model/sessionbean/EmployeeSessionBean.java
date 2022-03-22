package com.utar.myemployeeapp_full.model.sessionbean;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.utar.myemployeeapp_full.model.entity.Employee;


import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {
    @PersistenceContext(unitName = "default")
    EntityManager em;

    public List<Employee> getAllEmployees() throws EJBException {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    @Override
        public List<Employee> readEmployee(int currentPage, int recordsPerPage, String keyword, String direction) throws EJBException {
        Query q = null;
        int start = 0;
        direction = " " + direction;
        if (keyword.isEmpty()) {
            q = em.createNativeQuery("SELECT * FROM employees.employee order by id" + direction, Employee.class);
            start = currentPage * recordsPerPage - recordsPerPage;
        } else {
            q = em.createNativeQuery("SELECT * from employees.employee WHERE concat(id,first_name,last_name,gender) LIKE ? order by id" + direction,Employee.class);
            start = currentPage * recordsPerPage - recordsPerPage;
            q.setParameter(1, "%" + keyword + "%");
        }
        //use of setMaxResults --> to replace LIMIT & setFirstResult --> to replace OFFSET
        List<Employee> results = q.setFirstResult(start).setMaxResults(recordsPerPage).getResultList();
        return results;

    }

//    public List<Employee> readEmployee(
//            int currentPage, int recordsPerPage, String keyword, String direction) throws EJBException {
//        Query q = null;
//        int start = 0;
//        direction = " " + direction;
//        System.out.println(keyword);
//
//        try {
//            if (keyword.isEmpty()) {
//                q =
//                        em.createNativeQuery(
//                                "SELECT * FROM employees.employee e order by e.id" + direction, Employee.class);
//                start = currentPage * recordsPerPage - recordsPerPage;
//            } else {
//                keyword = keyword.toLowerCase(Locale.ENGLISH);
//                q =
//                        em.createNativeQuery(
//                                "SELECT * from employees.employee e WHERE lower(concat(id,first_name,last_name,gender)) LIKE ? order by e.id" + direction,
//                                Employee.class);
//                start = currentPage * recordsPerPage - recordsPerPage; // Pagination
//                q.setParameter(1, "%" + keyword + "%");
//                System.out.println(q.getParameter(1));
//            }
//            System.out.println(start);
//            List<Employee> results =
//                    q.setFirstResult(start).setMaxResults(recordsPerPage).getResultList();
//            System.out.println(results);
//            return results;
//
//        } catch (Exception ex) {
//            System.out.println("You messed up kid");
//        }
//
//        return null;
//    }


    @Override
    public int getNumberOfRows(String keyword) throws EJBException {
        // TODO Auto-generated method stub
        Query q = null;
        if (keyword.isEmpty()) {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow FROM employees.employee");
        } else {
            q = em.createNativeQuery("SELECT COUNT(*) AS totalrow from employees.employee WHERE concat(id,first_name,last_name,gender) LIKE ?");
            q.setParameter(1, "%" + keyword + "%");
        }
        BigInteger results = (BigInteger) q.getSingleResult();
        int i = results.intValue();
        return i;
    }

    public Employee findEmployee(String id) throws EJBException {
        Query q = em.createNamedQuery("Employee.findbyId");
        q.setParameter("id", Long.valueOf(id));
        return (Employee) q.getSingleResult();
    }

    public void updateEmployee(String[] s) throws EJBException {
        Date dob = null;
        Date hd = null;
        Employee e = findEmployee(s[0]);
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(s[4]);
            hd = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(s[5]);
        } catch (Exception ex) {
        }
        java.sql.Date DOB = new java.sql.Date(dob.getTime());
        java.sql.Date HD = new java.sql.Date(hd.getTime());
        e.setFirstName(s[1]);
        e.setLastName(s[2]);
        e.setGender(s[3]);
        e.setBirthDate(DOB);
        e.setHireDate(HD);
        em.merge(e);
    }

    public void deleteEmployee(String id) throws EJBException {
        Employee e = findEmployee(id);
        em.remove(e);
    }

    public void addEmployee(String[] s) throws EJBException {
        Date dob = null;
        Date hd = null;
        try {
            dob = new SimpleDateFormat("yyyy-MM-dd").parse(s[4]);
            hd = new SimpleDateFormat("yyyy-MM-dd").parse(s[5]);
        } catch (Exception ex) {
        }
        Employee e = new Employee();
        java.sql.Date DOB = new java.sql.Date(dob.getTime());
        java.sql.Date HD = new java.sql.Date(hd.getTime());
        e.setFirstName(s[1]);
        e.setLastName(s[2]);
        e.setGender(s[3]);
        e.setBirthDate(DOB);
        e.setHireDate(HD);
        em.persist(e); }

}