package com.evan.learning.hibernate.service;

import com.evan.learning.hibernate.model.manytomany.Kelas;
import com.evan.learning.hibernate.model.manytomany.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ManyToMany {
    public static void main(String[] args) {
        // create session factory object
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // create session object
        Session session = sessionFactory.openSession();

        // create transaction object
        Transaction transaction = session.beginTransaction();

        Set<Teacher> teacherSet = new HashSet<>();
        Set<Kelas> kelasSet = new HashSet<>();

        Teacher teacherA = new Teacher();
        teacherA.setTeacherName("A");
        teacherA.setTeacherSubject("Math");
        teacherSet.add(teacherA);

        Teacher teacherB = new Teacher();
        teacherB.setTeacherName("B");
        teacherB.setTeacherSubject("IPA");
        teacherSet.add(teacherB);

        Kelas kelas1 = new Kelas();
        kelas1.setKelasName("Kelas 1");
        kelas1.setTeachers(teacherSet);
        kelasSet.add(kelas1);

        Kelas kelas2 = new Kelas();
        kelas2.setKelasName("Kelas 2");
        kelas2.setTeachers(teacherSet);
        kelasSet.add(kelas2);

        teacherA.setKelasStudents(kelasSet);
        teacherB.setKelasStudents(kelasSet);

        session.save(kelas1);
        session.save(kelas2);
        session.save(teacherA);
        session.save(teacherB);
        transaction.commit();
        session.close();
    }
}
