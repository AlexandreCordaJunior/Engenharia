package br.com.g3.sistemadevagaseng.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Escola implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cnpj;
    private char estado;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavelPeloCadastro")
    private Funcionario responsavelPeloCadastro;

    @JsonIgnore
    @OneToMany(mappedBy = "escola", fetch = FetchType.LAZY)
    private List<Turma> turmas = new ArrayList<>();

    public Escola(Long id, String nome, String email, String telefone, String endereco, String cnpj, char estado, Funcionario responsavelPeloCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.estado = estado;
        this.responsavelPeloCadastro = responsavelPeloCadastro;
    }

    public Escola() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Funcionario getResponsavelPeloCadastro() {
        return responsavelPeloCadastro;
    }

    public void setResponsavelPeloCadastro(Funcionario responsavelPeloCadastro) {
        this.responsavelPeloCadastro = responsavelPeloCadastro;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {
        return "Escola{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", estado=" + estado +
                ", responsavelPeloCadastro=" + responsavelPeloCadastro +
                ", turmas=" + turmas +
                '}';
    }
}
