package com.evan.learning.hibernate.model.onetoone;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
public class Identity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
