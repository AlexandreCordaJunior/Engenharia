package br.com.g3.sistemadevagaseng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Solicitacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoAluno;
    private Date dataDeNascimentoDoAluno;
    private char sexoDoAluno;
    private String cpfDoResponsavel;
    private String nomeDoResponsavel;
    private String enderecoDoResponsavel;
    private String telefoneDoResponsavel;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turma")
    private Turma turma;

    private char periodo;
    private char estado;
    private Date dataDeInscricao;
    private String email;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavelPeloCadastro")
    private Funcionario responsavelPeloCadastro;

    public Solicitacao() {
    }

    public Solicitacao(Long id, String nomeDoAluno, Date dataDeNascimentoDoAluno, char sexoDoAluno, String cpfDoResponsavel, String nomeDoResponsavel, String enderecoDoResponsavel, String telefoneDoResponsavel, Turma turma, char periodo, char estado, Date dataDeInscricao, String email, Funcionario responsavelPeloCadastro) {
        this.id = id;
        this.nomeDoAluno = nomeDoAluno;
        this.dataDeNascimentoDoAluno = dataDeNascimentoDoAluno;
        this.sexoDoAluno = sexoDoAluno;
        this.cpfDoResponsavel = cpfDoResponsavel;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.enderecoDoResponsavel = enderecoDoResponsavel;
        this.telefoneDoResponsavel = telefoneDoResponsavel;
        this.turma = turma;
        this.periodo = periodo;
        this.estado = estado;
        this.dataDeInscricao = dataDeInscricao;
        this.email = email;
        this.responsavelPeloCadastro = responsavelPeloCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoAluno() {
        return nomeDoAluno;
    }

    public void setNomeDoAluno(String nomeDoAluno) {
        this.nomeDoAluno = nomeDoAluno;
    }

    public Date getDataDeNascimentoDoAluno() {
        return dataDeNascimentoDoAluno;
    }

    public void setDataDeNascimentoDoAluno(Date dataDeNascimentoDoAluno) {
        this.dataDeNascimentoDoAluno = dataDeNascimentoDoAluno;
    }

    public char getSexoDoAluno() {
        return sexoDoAluno;
    }

    public void setSexoDoAluno(char sexoDoAluno) {
        this.sexoDoAluno = sexoDoAluno;
    }

    public String getCpfDoResponsavel() {
        return cpfDoResponsavel;
    }

    public void setCpfDoResponsavel(String cpfDoResponsavel) {
        this.cpfDoResponsavel = cpfDoResponsavel;
    }

    public String getEnderecoDoResponsavel() {
        return enderecoDoResponsavel;
    }

    public void setEnderecoDoResponsavel(String enderecoDoResponsavel) {
        this.enderecoDoResponsavel = enderecoDoResponsavel;
    }

    public String getTelefoneDoResponsavel() {
        return telefoneDoResponsavel;
    }

    public void setTelefoneDoResponsavel(String telefoneDoResponsavel) {
        this.telefoneDoResponsavel = telefoneDoResponsavel;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public char getPeriodo() {
        return periodo;
    }

    public void setPeriodo(char periodo) {
        this.periodo = periodo;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Date getDataDeInscricao() {
        return dataDeInscricao;
    }

    public void setDataDeInscricao(Date dataDeInscricao) {
        this.dataDeInscricao = dataDeInscricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Funcionario getResponsavelPeloCadastro() {
        return responsavelPeloCadastro;
    }

    public void setResponsavelPeloCadastro(Funcionario responsavelPeloCadastro) {
        this.responsavelPeloCadastro = responsavelPeloCadastro;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }
}
