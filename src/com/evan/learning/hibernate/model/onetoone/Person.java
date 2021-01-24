package com.evan.learning.hibernate.model.onetoone;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private int age;
    private Identity identity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToOne(mappedBy = "person")
    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
}
