package br.com.g3.sistemadevagaseng.dto;

import java.io.Serializable;

public class DadosDTO implements Serializable {
    private Long funcionarioQtd;
    private Long professorQtd;
    private Long escolaQtd;
    private Long turmaQtd;
    private Long solicitacaoQtd;

    public DadosDTO(Long funcionarioQtd, Long professorQtd, Long escolaQtd, Long turmaQtd, Long solicitacaoQtd) {
        this.funcionarioQtd = funcionarioQtd;
        this.professorQtd = professorQtd;
        this.escolaQtd = escolaQtd;
        this.turmaQtd = turmaQtd;
        this.solicitacaoQtd = solicitacaoQtd;
    }

    public DadosDTO() {
    }

    public Long getFuncionarioQtd() {
        return funcionarioQtd;
    }

    public void setFuncionarioQtd(Long funcionarioQtd) {
        this.funcionarioQtd = funcionarioQtd;
    }

    public Long getProfessorQtd() {
        return professorQtd;
    }

    public void setProfessorQtd(Long professorQtd) {
        this.professorQtd = professorQtd;
    }

    public Long getEscolaQtd() {
        return escolaQtd;
    }

    public void setEscolaQtd(Long escolaQtd) {
        this.escolaQtd = escolaQtd;
    }

    public Long getTurmaQtd() {
        return turmaQtd;
    }

    public void setTurmaQtd(Long turmaQtd) {
        this.turmaQtd = turmaQtd;
    }

    public Long getSolicitacaoQtd() {
        return solicitacaoQtd;
    }

    public void setSolicitacaoQtd(Long solicitacaoQtd) {
        this.solicitacaoQtd = solicitacaoQtd;
    }
}
