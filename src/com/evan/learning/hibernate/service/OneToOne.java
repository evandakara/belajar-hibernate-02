package com.evan.learning.hibernate.service;

import com.evan.learning.hibernate.model.onetoone.Identity;
import com.evan.learning.hibernate.model.onetoone.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        // create session factory object
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // create session object
        Session session = sessionFactory.openSession();

        // create transaction object
        Transaction transaction = session.beginTransaction();

        // create object
        Identity identity1 = new Identity();

        Person person1 = new Person();
        person1.setName("Evan");
        person1.setAge(78);
        person1.setIdentity(identity1);

        identity1.setPerson(person1);

        // save object
        session.save(person1);
        session.save(identity1);
        transaction.commit();
        session.close();
    }
}
