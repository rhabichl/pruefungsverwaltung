package com.example.pruefungsverwaltung.models.repositorie;

import com.example.pruefungsverwaltung.models.SchoolClass;
import com.example.pruefungsverwaltung.models.Student;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepositories extends JpaRepository<SchoolClass, Long> {

    @Query("SELECT distinct s from SchoolClass sc "+
            "INNER join Student s on (sc = s.schoolClass) " +
            "INNER join Grade g on (s = g.student) " +
            "where g.grade >= 5 AND sc = ?1")
    public List<Student> getFailedStudents(SchoolClass sc);
}

