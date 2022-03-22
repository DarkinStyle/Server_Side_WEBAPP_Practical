package com.utar.myemployeeapp_full.model.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DepartmentManagerId implements Serializable {
    private static final long serialVersionUID = 5054881356688748543L;
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;
    @Column(name = "department_id", nullable = false, length = 4)
    private String departmentId;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, employeeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DepartmentManagerId entity = (DepartmentManagerId) o;
        return Objects.equals(this.departmentId, entity.departmentId) &&
                Objects.equals(this.employeeId, entity.employeeId);
    }
}