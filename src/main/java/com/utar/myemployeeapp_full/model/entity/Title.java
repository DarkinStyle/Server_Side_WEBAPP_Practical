package com.utar.myemployeeapp_full.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "title", schema = "employees")
public class Title {

    //bi-directional many-to-one association to Department
    @ManyToOne
    @JoinColumn(name="department_id",insertable=false, updatable=false)
    private Department department;
    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name="employee_id",insertable=false, updatable=false)
    private Employee employee;

    @EmbeddedId
    private TitleId id;
    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.LAZY)


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TitleId getId() {
        return id;
    }

    public void setId(TitleId id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}