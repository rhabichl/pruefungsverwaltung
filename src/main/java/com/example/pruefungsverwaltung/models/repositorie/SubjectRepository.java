package com.example.pruefungsverwaltung.models.repositorie;

import com.example.pruefungsverwaltung.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}