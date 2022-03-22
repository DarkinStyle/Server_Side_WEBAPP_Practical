package com.utar.myemployeeapp_full.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "department_manager", schema = "employees")
public class DepartmentManager {

//    //bi-directional many-to-one association to Department
//    @ManyToOne
//    @JoinColumn(name="department_id",insertable=false, updatable=false)
//    private Department department;
//    //bi-directional many-to-one association to Employee
//    @ManyToOne
//    @JoinColumn(name="employee_id",insertable=false, updatable=false)
//    private Employee employee;

    @EmbeddedId
    private DepartmentManagerId id;
    @MapsId("departmentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepartmentManagerId getId() {
        return id;
    }

    public void setId(DepartmentManagerId id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}