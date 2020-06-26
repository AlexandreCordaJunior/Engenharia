package br.com.g3.sistemadevagaseng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Matricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitacao")
    private Solicitacao solicitacao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma")
    private Turma turma;

    public Matricula(Long id, Solicitacao solicitacao, Turma turma) {
        this.id = id;
        this.solicitacao = solicitacao;
        this.turma = turma;
    }

    public Matricula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
