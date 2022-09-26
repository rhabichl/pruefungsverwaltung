package com.example.pruefungsverwaltung.models;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
public class Student {
    @Column(name = "firstname")
    private String Firstname;
    @Column(name = "lastname")
    private String Lastname;


    private Date Birthday;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
