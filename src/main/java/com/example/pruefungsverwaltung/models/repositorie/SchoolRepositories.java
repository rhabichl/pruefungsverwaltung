package com.example.pruefungsverwaltung.models.repositorie;

import com.example.pruefungsverwaltung.models.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepositories extends JpaRepository<SchoolClass, Long> {
}
