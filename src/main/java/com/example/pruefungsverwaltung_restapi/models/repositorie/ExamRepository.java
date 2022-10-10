package com.example.pruefungsverwaltung_restapi.models.repositorie;

import com.example.pruefungsverwaltung_restapi.models.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}