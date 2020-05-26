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
        this.professorTurmaId.setProfessor(professor);
        this.professorTurmaId.setTurma(turma);
    }

    public ProfessorTurma() {
    }

    public ProfessorTurmaId getProfessorTurmaId() {
        return professorTurmaId;
    }

    public void setProfessorTurmaId(ProfessorTurmaId professorTurmaId) {
        this.professorTurmaId = professorTurmaId;
    }
}
