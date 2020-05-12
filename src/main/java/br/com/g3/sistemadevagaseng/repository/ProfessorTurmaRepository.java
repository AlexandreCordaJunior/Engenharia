package br.com.g3.sistemadevagaseng.repository;

import br.com.g3.sistemadevagaseng.domain.ProfessorTurma;
import br.com.g3.sistemadevagaseng.domain.ProfessorTurmaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorTurmaRepository extends JpaRepository<ProfessorTurma, ProfessorTurmaId> {
}
