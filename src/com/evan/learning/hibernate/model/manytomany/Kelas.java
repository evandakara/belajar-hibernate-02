package com.evan.learning.hibernate.model.manytomany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table
@Entity
public class Kelas implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long kelasId;
    private String kelasName;
    private Set<Teacher> teachers;

    public Kelas() {
    }

    public Kelas(String kelasName) {
        this.kelasName = kelasName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kelas_id")
    public Long getKelasId() {
        return kelasId;
    }

    public void setKelasId(Long id) {
        this.kelasId = id;
    }

    @Column(name = "kelas_name")
    public String getKelasName() {
        return kelasName;
    }

    public void setKelasName(String kelasName) {
        this.kelasName = kelasName;
    }

    @ManyToMany(mappedBy = "kelasStudents")
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
