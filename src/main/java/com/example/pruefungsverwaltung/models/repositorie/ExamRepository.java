package com.example.pruefungsverwaltung.models.repositorie;

import com.example.pruefungsverwaltung.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}