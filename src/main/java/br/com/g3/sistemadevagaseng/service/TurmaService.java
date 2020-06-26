package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.Escola;
import br.com.g3.sistemadevagaseng.domain.Funcionario;
import br.com.g3.sistemadevagaseng.domain.Professor;
import br.com.g3.sistemadevagaseng.domain.Turma;
import br.com.g3.sistemadevagaseng.dto.TurmaDTO;
import br.com.g3.sistemadevagaseng.repository.TurmaRepository;
import br.com.g3.sistemadevagaseng.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository repo;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EscolaService escolaService;

    public Turma find(Long id){
        Optional<Turma> opt = repo.findById(id);
        return opt.orElseThrow(() -> {
            return new ObjectNotFoundException("Id não encontrado - " + Turma.class.getName());
        });
    }

    public List<Turma> findAll(){
        return repo.findAll();
    }

    public List<Professor> getProfessor(Long id) {
        return repo.findProfessor(id);
    }

    public void delete(Long id){
        Turma obj = find(id);
        obj.setEstado('I');
        repo.save(obj);
    }

    public Turma update(Turma obj){
        Turma novoObj = find(obj.getId());
        updateData(novoObj, obj);
        return repo.save(novoObj);
    }

    private void updateData(Turma novoObj, Turma obj) {
        System.out.println(obj);
        novoObj.setId(obj.getId());
        novoObj.setNumTurma(obj.getNumTurma());
        novoObj.setPeriodo(obj.getPeriodo());
        novoObj.setTipo(obj.getTipo());
        novoObj.setQuantidadeMaximaDeAlunos(obj.getQuantidadeMaximaDeAlunos());
        novoObj.setEscola(obj.getEscola());
        novoObj.setEstado(obj.getEstado());
        novoObj.setResponsaelPeloCadastro(obj.getResponsaelPeloCadastro());
    }

    public Turma save(Turma obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Turma fromDTO(TurmaDTO objDTO){
        Funcionario responsavel = funcionarioService.find(objDTO.getResponsavelPeloCadastroId());
        Escola escola = escolaService.find(objDTO.getEscolaId());

        return new Turma(
                objDTO.getId(),
                objDTO.getNumTurma(),
                objDTO.getPeriodo(),
                objDTO.getTipo(),
                objDTO.getQuantidadeMaximaDeAlunos(),
                objDTO.getEstado(),
                escola,
                responsavel
        );
    }
}
