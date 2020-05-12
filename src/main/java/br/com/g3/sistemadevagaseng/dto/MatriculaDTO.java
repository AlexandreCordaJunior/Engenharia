package br.com.g3.sistemadevagaseng.dto;

import br.com.g3.sistemadevagaseng.domain.Matricula;

import java.io.Serializable;

public class MatriculaDTO implements Serializable {
    private Long id;
    private Long solicitacaoId;
    private Long turmaId;

    public MatriculaDTO(Long id, Long solicitacaoId, Long turmaId) {
        this.id = id;
        this.solicitacaoId = solicitacaoId;
        this.turmaId = turmaId;
    }

    public MatriculaDTO() {
    }

    public MatriculaDTO(Matricula matricula){
        this.id = matricula.getId();
        this.solicitacaoId = matricula.getSolicitacao().getId();
        this.turmaId = matricula.getTurma().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSolicitacaoId() {
        return solicitacaoId;
    }

    public void setSolicitacaoId(Long solicitacaoId) {
        this.solicitacaoId = solicitacaoId;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }
}
