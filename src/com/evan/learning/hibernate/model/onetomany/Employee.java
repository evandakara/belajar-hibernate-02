package com.evan.learning.hibernate.model.onetomany;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table
@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private BigDecimal salary;
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
