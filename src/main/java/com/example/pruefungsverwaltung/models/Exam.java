package com.example.pruefungsverwaltung.models;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Exam {
    @Id
    @Column(name = "id")
    private Integer Id;


    @Column(name = "subject")
    private String Subject;
    @Column(name = "title")
    private String Title;

}
