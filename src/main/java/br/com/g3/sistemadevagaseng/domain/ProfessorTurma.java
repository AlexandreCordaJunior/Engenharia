package br.com.g3.sistemadevagaseng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProfessorTurma implements Serializable {

    @EmbeddedId
    private ProfessorTurmaId professorTurmaId = new ProfessorTurmaId();


    public ProfessorTurma(Professor professor, Turma turma) {
        this.professorTurmaId = new ProfessorTurmaId();
        this.professorTurmaId.setProfessorId(professor.getId());
        this.professorTurmaId.setTurmaId(turma.getId());
    }

    public ProfessorTurma() {
    }

    public ProfessorTurmaId getProfessorTurmaId() {
        return professorTurmaId;
    }

    public void setProfessorTurmaId(ProfessorTurmaId professorTurmaId) {
        this.professorTurmaId = professorTurmaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorTurma that = (ProfessorTurma) o;
        return Objects.equals(professorTurmaId, that.professorTurmaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorTurmaId);
    }
}
