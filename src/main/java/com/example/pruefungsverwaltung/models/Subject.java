package com.example.pruefungsverwaltung.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Subject {
    @Column(name = "title")
    private String Title;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private Set<Exam> exams;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
