package com.utar.myemployeeapp_full.model.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "department", schema = "employees", indexes = {
        @Index(name = "idx_16979_dept_name", columnList = "dept_name", unique = true)
})
public class Department {
    @Id
    @Column(name = "id", nullable = false, length = 4)
    private String id;

    @Column(name = "dept_name", nullable = false, length = 40)
    private String deptName;

    @OneToMany(mappedBy = "department")
    private Set<DepartmentManager> departmentManagers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<DepartmentEmployee> departmentEmployees = new LinkedHashSet<>();

    public Set<DepartmentEmployee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(Set<DepartmentEmployee> departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }

    public Set<DepartmentManager> getDepartmentManagers() {
        return departmentManagers;
    }

    public void setDepartmentManagers(Set<DepartmentManager> departmentManagers) {
        this.departmentManagers = departmentManagers;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}