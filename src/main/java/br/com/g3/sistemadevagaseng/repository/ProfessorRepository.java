package br.com.g3.sistemadevagaseng.repository;

import br.com.g3.sistemadevagaseng.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
