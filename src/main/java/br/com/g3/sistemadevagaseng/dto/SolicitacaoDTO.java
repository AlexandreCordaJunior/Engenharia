package br.com.g3.sistemadevagaseng.dto;

import br.com.g3.sistemadevagaseng.domain.Solicitacao;

import java.io.Serializable;
import java.util.Date;

public class SolicitacaoDTO implements Serializable {
    private Long id;
    private String nomeDoAluno;
    private Date dataDeNascimentoDoAluno;
    private char sexoDoAluno;
    private String cpfDoResponsavel;
    private String nomeDoResponsavel;
    private String enderecoDoResponsavel;
    private String telefoneDoResponsavel;
    private char periodo;
    private char estado;
    private Date dataDeInscricao;
    private String email;
    private Long turmaId;
    private Long responsavelPeloCadastroId;

    public SolicitacaoDTO(Long id, String nomeDoAluno, Date dataDeNascimentoDoAluno, char sexoDoAluno, String cpfDoResponsavel, String nomeDoResponsavel, String enderecoDoResponsavel, String telefoneDoResponsavel, char periodo, char estado, Date dataDeInscricao, String email, Long turmaId, Long responsavelPeloCadastroId) {
        this.id = id;
        this.nomeDoAluno = nomeDoAluno;
        this.dataDeNascimentoDoAluno = dataDeNascimentoDoAluno;
        this.sexoDoAluno = sexoDoAluno;
        this.cpfDoResponsavel = cpfDoResponsavel;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.enderecoDoResponsavel = enderecoDoResponsavel;
        this.telefoneDoResponsavel = telefoneDoResponsavel;
        this.periodo = periodo;
        this.estado = estado;
        this.dataDeInscricao = dataDeInscricao;
        this.email = email;
        this.turmaId = turmaId;
        this.responsavelPeloCadastroId = responsavelPeloCadastroId;
    }

    public SolicitacaoDTO() {
    }

    public SolicitacaoDTO(Solicitacao solicitacao) {
        this.id = solicitacao.getId();
        this.nomeDoAluno = solicitacao.getNomeDoAluno();
        this.dataDeNascimentoDoAluno = solicitacao.getDataDeNascimentoDoAluno();
        this.sexoDoAluno = solicitacao.getSexoDoAluno();
        this.cpfDoResponsavel = solicitacao.getCpfDoResponsavel();
        this.nomeDoResponsavel = solicitacao.getNomeDoResponsavel();
        this.enderecoDoResponsavel = solicitacao.getEnderecoDoResponsavel();
        this.telefoneDoResponsavel = solicitacao.getEnderecoDoResponsavel();
        this.periodo = solicitacao.getPeriodo();
        this.estado = solicitacao.getEstado();
        this.dataDeInscricao = solicitacao.getDataDeInscricao();
        this.email = solicitacao.getEmail();
        this.turmaId = solicitacao.getTurma().getId();
        this.responsavelPeloCadastroId = solicitacao.getResponsavelPeloCadastro().getId();
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

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
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

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    public Long getResponsavelPeloCadastroId() {
        return responsavelPeloCadastroId;
    }

    public void setResponsavelPeloCadastroId(Long responsavelPeloCadastroId) {
        this.responsavelPeloCadastroId = responsavelPeloCadastroId;
    }
}
