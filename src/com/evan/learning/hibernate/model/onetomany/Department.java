package com.evan.learning.hibernate.model.onetomany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table
@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String departmentName;
    private List<Employee> employees;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @OneToMany(targetEntity = Employee.class,fetch = FetchType.LAZY)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
