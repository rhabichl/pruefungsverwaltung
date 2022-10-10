package com.example.pruefungsverwaltung_restapi.models.repositorie;

import com.example.pruefungsverwaltung_restapi.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}