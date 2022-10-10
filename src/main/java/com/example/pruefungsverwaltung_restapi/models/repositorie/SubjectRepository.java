package com.example.pruefungsverwaltung_restapi.models.repositorie;

import com.example.pruefungsverwaltung_restapi.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}