package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.Solicitacao;
import br.com.g3.sistemadevagaseng.domain.Funcionario;
import br.com.g3.sistemadevagaseng.domain.Turma;
import br.com.g3.sistemadevagaseng.dto.SolicitacaoDTO;
import br.com.g3.sistemadevagaseng.repository.SolicitacaoRepository;
import br.com.g3.sistemadevagaseng.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoService {
    @Autowired
    private SolicitacaoRepository repo;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private TurmaService turmaService;

    public Solicitacao find(Long id){
        Optional<Solicitacao> opt = repo.findById(id);
        return opt.orElseThrow(() -> {
            return new ObjectNotFoundException("Id não encontrado - " + Solicitacao.class.getName());
        });
    }

    public List<Solicitacao> findAll(){
        return repo.findAll();
    }

    public void delete(Long id){
        Solicitacao obj = find(id);
        obj.setEstado('I');
        repo.save(obj);
    }

    public Solicitacao update(Solicitacao obj){
        Solicitacao novoObj = find(obj.getId());
        updateData(novoObj, obj);
        return repo.save(novoObj);
    }

    private void updateData(Solicitacao novoObj, Solicitacao obj) {
        novoObj.setId(obj.getId());
        novoObj.setNomeDoAluno(obj.getNomeDoAluno());
        novoObj.setDataDeNascimentoDoAluno(obj.getDataDeNascimentoDoAluno());
        novoObj.setSexoDoAluno(obj.getSexoDoAluno());
        novoObj.setCpfDoResponsavel(obj.getCpfDoResponsavel());
        novoObj.setNomeDoResponsavel(obj.getNomeDoResponsavel());
        novoObj.setEnderecoDoResponsavel(obj.getEnderecoDoResponsavel());
        novoObj.setTurma(obj.getTurma());
        novoObj.setPeriodo(obj.getPeriodo());
        novoObj.setEstado(obj.getEstado());
        novoObj.setDataDeInscricao(obj.getDataDeInscricao());
        novoObj.setEmail(obj.getEmail());
        novoObj.setResponsavelPeloCadastro(obj.getResponsavelPeloCadastro());
    }

    public Solicitacao save(Solicitacao obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Solicitacao fromDTO(SolicitacaoDTO objDTO){
        Funcionario responsavel = funcionarioService.find(objDTO.getResponsavelPeloCadastroId());

        Turma turma = turmaService.find(objDTO.getTurmaId());

        return new Solicitacao(
                objDTO.getId(),
                objDTO.getNomeDoAluno(),
                objDTO.getDataDeNascimentoDoAluno(),
                objDTO.getSexoDoAluno(),
                objDTO.getCpfDoResponsavel(),
                objDTO.getNomeDoResponsavel(),
                objDTO.getEnderecoDoResponsavel(),
                objDTO.getTelefoneDoResponsavel(),
                turma,
                objDTO.getPeriodo(),
                objDTO.getEstado(),
                objDTO.getDataDeInscricao(),
                objDTO.getEmail(),
                responsavel
        );
    }

    public Page<Solicitacao> findPage(Integer page, Integer linesPerPage, String orderBy,
                                    String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
}
