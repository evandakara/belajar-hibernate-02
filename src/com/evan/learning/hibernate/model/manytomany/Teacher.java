package com.evan.learning.hibernate.model.manytomany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table
@Entity
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long teacherId;
    private String teacherName;
    private String teacherSubject;
    private Set<Kelas> kelasStudents;

    public Teacher() {
    }

    public Teacher(String teacherName, String teacherSubject, Set<Kelas> kelasStudents) {
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
        this.kelasStudents = kelasStudents;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Column(name = "teacher_name")
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String name) {
        this.teacherName = name;
    }

    @Column(name = "teacher_subject")
    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String subject) {
        this.teacherSubject = subject;
    }

    @ManyToMany
    @JoinTable(
            name = "kelas_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "kelas_id"))
    public Set<Kelas> getKelasStudents() {
        return kelasStudents;
    }

    public void setKelasStudents(Set<Kelas> kelasStudents) {
        this.kelasStudents = kelasStudents;
    }
}
