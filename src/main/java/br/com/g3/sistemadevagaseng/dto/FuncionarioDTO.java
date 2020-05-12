package br.com.g3.sistemadevagaseng.dto;

import br.com.g3.sistemadevagaseng.domain.Funcionario;

import java.io.Serializable;
import java.util.Date;

public class FuncionarioDTO implements Serializable {
    private Long id;
    private String cpf;
    private String rg;
    private Date dataDeNascimento;
    private char sexo;
    private String email;
    private String telefone;
    private String endereco;
    private String nome;
    private char estado;
    private Long responsavelPeloCadastroId;

    public FuncionarioDTO(Long id, String cpf, String rg, Date dataDeNascimento, char sexo, String email, String telefone, String endereco, String nome, char estado, Long responsavelPeloCadastroId) {
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nome = nome;
        this.estado = estado;
        this.responsavelPeloCadastroId = responsavelPeloCadastroId;
    }

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario funcionario){
        this.id = funcionario.getId();
        this.cpf = funcionario.getCpf();
        this.rg = funcionario.getRg();
        this.dataDeNascimento = funcionario.getDataDeNascimento();
        this.sexo = funcionario.getSexo();
        this.email = funcionario.getEmail();
        this.telefone = funcionario.getTelefone();
        this.endereco = funcionario.getEndereco();
        this.nome = funcionario.getNome();
        this.estado = funcionario.getEstado();
        this.responsavelPeloCadastroId = funcionario.getResponsavelPeloCadastro() == null ? null : funcionario.getResponsavelPeloCadastro().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
