package br.com.g3.sistemadevagaseng.repository;

import br.com.g3.sistemadevagaseng.domain.Professor;
import br.com.g3.sistemadevagaseng.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query("select pt.professorTurmaId.professor from Turma turma inner join ProfessorTurma pt on pt.professorTurmaId.turma = turma where :id = turma.id")
    public List<Professor> findProfessor(@Param("id") Long id);
}
