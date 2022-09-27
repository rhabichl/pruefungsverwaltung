package com.example.pruefungsverwaltung.models.repositorie;

import com.example.pruefungsverwaltung.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepositories extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM student inner join grade on student.id = grade.student_id AND grade.grade = 5", nativeQuery = true)
    List<Student> findAllWithFailedExams();
   // List<Student> findByFirstnameAndLastname(String Firstname, String Lastname);
}
