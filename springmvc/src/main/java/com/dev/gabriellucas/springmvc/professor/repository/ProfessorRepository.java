package com.dev.gabriellucas.springmvc.professor.repository;

import com.dev.gabriellucas.springmvc.professor.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
