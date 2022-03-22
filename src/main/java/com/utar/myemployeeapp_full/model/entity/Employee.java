package com.utar.myemployeeapp_full.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Date;

@Entity
@NamedQuery(name = "Employee.findbyId", query = "SELECT e FROM Employee e WHERE e.id = :id")
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")


@Table(name = "employee", schema = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @OneToMany(mappedBy = "employee")
    private Set<Salary> salaries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<DepartmentManager> departmentManagers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Title> titles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<DepartmentEmployee> departmentEmployees = new LinkedHashSet<>();

    public Set<DepartmentEmployee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(Set<DepartmentEmployee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    public Set<Title> getTitles() {
        return titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }

    public Set<DepartmentManager> getDepartmentManagers() {
        return departmentManagers;
    }

    public void setDepartmentManagers(Set<DepartmentManager> departmentManagers) {
        this.departmentManagers = departmentManagers;
    }

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

//package com.utar.myemployeeapp_full.model.entity;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "employee", schema = "employees")
//@NamedQuery(name = "Employee.findbyId", query = "SELECT e FROM Employee e WHERE e.id = :id")
//@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
//public class Employee implements java.io.Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Column(name = "birth_date", nullable = false)
//    private Date birthDate;
//
//    @Column(name = "first_name", nullable = false, length = 14)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false, length = 16)
//    private String lastName;
//
//    @Column(name = "gender", nullable = false, length = 1)
//    private String gender;
//
//    @Column(name = "hire_date", nullable = false)
//    private Date hireDate;
//
//    @OneToMany(mappedBy = "employee")
//    private Set<Salary> salaries = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "employee")
//    private Set<DepartmentManager> departmentManagers = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "employee")
//    private Set<Title> titles = new LinkedHashSet<>();
//
//    @OneToMany(mappedBy = "employee")
//    private Set<DepartmentEmployee> departmentEmployees = new LinkedHashSet<>();
//
//    public Set<DepartmentEmployee> getDepartmentEmployees() {
//        return departmentEmployees;
//    }
//
//    public void setDepartmentEmployees(Set<DepartmentEmployee> departmentEmployees) {
//        this.departmentEmployees = departmentEmployees;
//    }
//
//    public Set<Title> getTitles() {
//        return titles;
//    }
//
//    public void setTitles(Set<Title> titles) {
//        this.titles = titles;
//    }
//
//    public Set<DepartmentManager> getDepartmentManagers() {
//        return departmentManagers;
//    }
//
//    public void setDepartmentManagers(Set<DepartmentManager> departmentManagers) {
//        this.departmentManagers = departmentManagers;
//    }
//
//    public Set<Salary> getSalaries() {
//        return salaries;
//    }
//
//    public void setSalaries(Set<Salary> salaries) {
//        this.salaries = salaries;
//    }
//
//    public Date getHireDate() {
//        return hireDate;
//    }
//
//    public void setHireDate(Date hireDate) {
//        this.hireDate = hireDate;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//}