package br.com.g3.sistemadevagaseng.dto;

import br.com.g3.sistemadevagaseng.domain.Escola;

import java.io.Serializable;

public class EscolaDTO implements Serializable {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cnpj;
    private char estado;
    private Long responsavelPeloCadastroId;

    public EscolaDTO(Long id, String nome, String email, String telefone, String endereco, String cnpj, char estado, Long responsavelPeloCadastroId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.estado = estado;
        this.responsavelPeloCadastroId = responsavelPeloCadastroId;
    }

    public EscolaDTO() {
    }

    public EscolaDTO(Escola escola){
        this.id = escola.getId();
        this.nome = escola.getNome();
        this.email = escola.getEmail();
        this.telefone = escola.getTelefone();
        this.endereco = escola.getEndereco();
        this.cnpj = escola.getCnpj();
        this.estado = escola.getEstado();
        this.responsavelPeloCadastroId = escola.getResponsavelPeloCadastro().getId();
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

    public Long getResponsavelPeloCadastroId() {
        return responsavelPeloCadastroId;
    }

    public void setResponsavelPeloCadastroId(Long responsavelPeloCadastroId) {
        this.responsavelPeloCadastroId = responsavelPeloCadastroId;
    }
}
