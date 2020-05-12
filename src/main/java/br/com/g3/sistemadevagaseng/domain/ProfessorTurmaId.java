package br.com.g3.sistemadevagaseng.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfessorTurmaId implements Serializable {

    private Long professorId;

    private Long turmaId;

    public ProfessorTurmaId(Long professorId, Long turmaId) {
        this.professorId = professorId;
        this.turmaId = turmaId;
    }

    public ProfessorTurmaId() {
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorTurmaId that = (ProfessorTurmaId) o;
        return Objects.equals(professorId, that.professorId) &&
                Objects.equals(turmaId, that.turmaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, turmaId);
    }
}
