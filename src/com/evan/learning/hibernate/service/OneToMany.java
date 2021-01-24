package com.evan.learning.hibernate.service;

import com.evan.learning.hibernate.model.onetomany.Department;
import com.evan.learning.hibernate.model.onetomany.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        // create session factory object
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // create session object
        Session session = sessionFactory.openSession();

        // create transaction object
        Transaction transaction = session.beginTransaction();

        // create object
        Department department = new Department();
        department.setDepartmentName("IT");
        session.save(department);
        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setName("Evan");
        employee1.setSalary(BigDecimal.valueOf(1234));
        employee1.setAddress("Jakarta Selatan");
        session.save(employee1);
        employeeList.add(employee1);

        Employee employee2 = new Employee();
        employee2.setName("navE");
        employee2.setSalary(BigDecimal.valueOf(4321));
        employee2.setAddress("Jakarta Utara");
        session.save(employee2);
        employeeList.add(employee2);

        department.setEmployees(employeeList);
        transaction.commit();
        session.close();
    }
}
