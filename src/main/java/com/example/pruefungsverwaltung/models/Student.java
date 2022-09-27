package com.example.pruefungsverwaltung.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * table where the grades for each exam are stored
     */
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Grade> grade;
    @Column(name = "firstname")
    private String Firstname;
    @Column(name = "lastname")
    private String Lastname;
    @Column(name = "birthday")
    private Date Birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolClass_id")
    private SchoolClass schoolClass;
    /**
     * getter and setter section
     */
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public Set<Grade> getGrade() {
        return grade;
    }

    public void setGrade(Set<Grade> grade) {
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
