package br.com.g3.sistemadevagaseng.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfessorTurmaId implements Serializable {

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Turma turma;

    public ProfessorTurmaId(Professor professor, Turma turma) {
        this.professor = professor;
        this.turma = turma;
    }

    public ProfessorTurmaId() {
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
