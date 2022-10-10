package com.example.pruefungsverwaltung_restapi.controller;

import com.example.pruefungsverwaltung_restapi.models.SchoolClass;
import com.example.pruefungsverwaltung_restapi.models.Student;
import com.example.pruefungsverwaltung_restapi.models.repositorie.SchoolRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/class")
public class SchoolClassController {

    @Autowired
    SchoolRepositories r;


    @GetMapping("/")
    List<SchoolClass> getAll(){
        return r.findAll();
    }

    @PostMapping("/students")
    Set<Student> getByClass(@RequestBody MultiValueMap<String, String> formData){
        return r.findFirstByTitle(formData.getFirst("schoolClass")).getStudents();
    }

    @PostMapping("/c")
    SchoolClass addClass(@RequestBody SchoolClass schoolClass){
        r.save(schoolClass);
        r.flush();
        return schoolClass;
    }

}
