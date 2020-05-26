package br.com.g3.sistemadevagaseng.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numTurma;
    private char periodo;
    private String tipo;
    private Integer quantidadeMaximaDeAlunos;
    private char estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "escola")
    private Escola escola;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavelPeloCadastro")
    private Funcionario responsaelPeloCadastro;

    @JsonIgnore
    @OneToMany(mappedBy = "turma", fetch = FetchType.LAZY)
    private List<Matricula> matriculas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "turma", fetch = FetchType.LAZY)
    private List<Solicitacao> solicitacoes = new ArrayList<>();

    public Turma() {
    }

    public Turma(Long id, String numTurma, char periodo, String tipo, Integer quantidadeMaximaDeAlunos, char estado, Escola escola, Funcionario responsaelPeloCadastro) {
        this.id = id;
        this.numTurma = numTurma;
        this.periodo = periodo;
        this.tipo = tipo;
        this.quantidadeMaximaDeAlunos = quantidadeMaximaDeAlunos;
        this.estado = estado;
        this.escola = escola;
        this.responsaelPeloCadastro = responsaelPeloCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumTurma() {
        return numTurma;
    }

    public void setNumTurma(String numTurma) {
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

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Funcionario getResponsaelPeloCadastro() {
        return responsaelPeloCadastro;
    }

    public void setResponsaelPeloCadastro(Funcionario responsaelPeloCadastro) {
        this.responsaelPeloCadastro = responsaelPeloCadastro;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Turma turma = (Turma) o;

        return id != null ? id.equals(turma.id) : turma.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
