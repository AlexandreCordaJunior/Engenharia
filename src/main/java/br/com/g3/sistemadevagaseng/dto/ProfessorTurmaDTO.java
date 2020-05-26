package br.com.g3.sistemadevagaseng.dto;

public class ProfessorTurmaDTO {
    private Long professor_id;
    private Long turma_id;

    public ProfessorTurmaDTO(Long professor_id, Long turma_id) {
        this.professor_id = professor_id;
        this.turma_id = turma_id;
    }

    public ProfessorTurmaDTO() {
    }

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }

    public Long getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(Long turma_id) {
        this.turma_id = turma_id;
    }
}
