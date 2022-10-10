package com.example.pruefungsverwaltung_restapi.controller;

import com.example.pruefungsverwaltung_restapi.models.Student;
import com.example.pruefungsverwaltung_restapi.models.repositorie.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepositories repositories;

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/list")
    public List<Student> listAll(){
        return repositories.findAll();
    }
}
