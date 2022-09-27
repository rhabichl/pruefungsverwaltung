package com.example.pruefungsverwaltung.models.repositorie;

import com.example.pruefungsverwaltung.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}