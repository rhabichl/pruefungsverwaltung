package com.example.pruefungsverwaltung_restapi.models.repositorie;

import com.example.pruefungsverwaltung_restapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface StudentRepositories extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student inner join grade on student.id = grade.student_id AND grade.grade = 5", nativeQuery = true)
    List<Student> findAllWithFailedExams();
   // List<Student> findByFirstnameAndLastname(String Firstname, String Lastname);
}
