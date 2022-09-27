package com.example.pruefungsverwaltung.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SchoolClass {
    @Column(name = "title")
    private String Title;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    private Set<Student> students;
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }
}
