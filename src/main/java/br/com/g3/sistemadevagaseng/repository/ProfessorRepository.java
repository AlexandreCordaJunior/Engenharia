package br.com.g3.sistemadevagaseng.repository;

import br.com.g3.sistemadevagaseng.domain.Professor;
import br.com.g3.sistemadevagaseng.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("select pt.professorTurmaId.turma from Professor professor inner join ProfessorTurma pt on pt.professorTurmaId.professor = professor where :id = professor.id")
    public List<Turma> findTurma(@Param("id") Long id);

    @Query("select professor from Professor professor inner join ProfessorTurma pt on pt.professorTurmaId.professor = professor where :id <> pt.professorTurmaId.turma.id")
    public List<Professor> getAllThatDontBelogToTurma(@Param("id") Long id);

    @Query("select professor from Professor professor where professor.estado = 'A'")
    public List<Professor> ativos();
}
