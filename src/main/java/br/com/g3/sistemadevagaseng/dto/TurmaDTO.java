package br.com.g3.sistemadevagaseng.dto;

import br.com.g3.sistemadevagaseng.domain.Turma;

import java.io.Serializable;

public class TurmaDTO implements Serializable {
    private Long id;
    private Long numTurma;
    private char periodo;
    private String tipo;
    private Integer quantidadeMaximaDeAlunos;
    private char estado;
    private Long responsavelPeloCadastroId;
    private Long escolaId;

    public TurmaDTO(Long id, Long numTurma, char periodo, String tipo, Integer quantidadeMaximaDeAlunos, char estado, Long responsavelPeloCadastroId, Long escolaId) {
        this.id = id;
        this.numTurma = numTurma;
        this.periodo = periodo;
        this.tipo = tipo;
        this.quantidadeMaximaDeAlunos = quantidadeMaximaDeAlunos;
        this.estado = estado;
        this.responsavelPeloCadastroId = responsavelPeloCadastroId;
        this.escolaId = escolaId;
    }

    public TurmaDTO() {
    }

    public TurmaDTO(Turma turma) {
        this.id = turma.getId();
        this.numTurma = turma.getNumTurma();
        this.periodo = turma.getPeriodo();
        this.tipo = turma.getTipo();
        this.quantidadeMaximaDeAlunos = turma.getQuantidadeMaximaDeAlunos();
        this.estado = turma.getEstado();
        this.responsavelPeloCadastroId = turma.getResponsaelPeloCadastro().getId();
        this.escolaId = turma.getEscola().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumTurma() {
        return numTurma;
    }

    public void setNumTurma(Long numTurma) {
        this.numTurma = numTurma;
    }

    public char getPeriodo() {
        return periodo;
    }

    public void setPeriodo(char periodo) {
        this.periodo = periodo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidadeMaximaDeAlunos() {
        return quantidadeMaximaDeAlunos;
    }

    public void setQuantidadeMaximaDeAlunos(Integer quantidadeMaximaDeAlunos) {
        this.quantidadeMaximaDeAlunos = quantidadeMaximaDeAlunos;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Long getResponsavelPeloCadastroId() {
        return responsavelPeloCadastroId;
    }

    public void setResponsavelPeloCadastroId(Long responsavelPeloCadastroId) {
        this.responsavelPeloCadastroId = responsavelPeloCadastroId;
    }

    public Long getEscolaId() {
        return escolaId;
    }

    public void setEscolaId(Long escolaId) {
        this.escolaId = escolaId;
    }
}
