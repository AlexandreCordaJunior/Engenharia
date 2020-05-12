package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.Funcionario;
import br.com.g3.sistemadevagaseng.domain.Professor;
import br.com.g3.sistemadevagaseng.dto.ProfessorDTO;
import br.com.g3.sistemadevagaseng.repository.ProfessorRepository;
import br.com.g3.sistemadevagaseng.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repo;

    @Autowired
    private FuncionarioService funcionarioService;

    public Professor find(Long id){
        Optional<Professor> opt = repo.findById(id);
        return opt.orElseThrow(() -> {
            return new ObjectNotFoundException("Id não encontrado - " + Professor.class.getName());
        });
    }

    public List<Professor> findAll(){
        return repo.findAll();
    }

    public void delete(Long id){
        Professor obj = find(id);
        obj.setEstado('I');
        repo.save(obj);
    }

    public Professor update(Professor obj){
        Professor novoObj = find(obj.getId());
        updateData(novoObj, obj);
        return repo.save(novoObj);
    }

    private void updateData(Professor novoObj, Professor obj) {
        novoObj.setCpf(obj.getCpf());
        novoObj.setRg(obj.getRg());
        novoObj.setDataDeNascimento(obj.getDataDeNascimento());
        novoObj.setSexo(obj.getSexo());
        novoObj.setEmail(obj.getEmail());
        novoObj.setTelefone(obj.getTelefone());
        novoObj.setEndereco(obj.getEndereco());
        novoObj.setNome(obj.getNome());
        novoObj.setEstado(obj.getEstado());
        novoObj.setResponsavelPeloCadastro(obj.getResponsavelPeloCadastro());
    }

    public Professor save(Professor obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Professor fromDTO(ProfessorDTO objDTO){
        Funcionario responsavel = funcionarioService.find(objDTO.getResponsavelPeloCadastroId());

        return new Professor(
                objDTO.getId(),
                objDTO.getCpf(),
                objDTO.getRg(),
                objDTO.getDataDeNascimento(),
                objDTO.getSexo(),
                objDTO.getEmail(),
                objDTO.getTelefone(),
                objDTO.getEndereco(),
                objDTO.getNome(),
                objDTO.getEstado(),
                responsavel
        );
    }

    public Page<Professor> findPage(Integer page, Integer linesPerPage, String orderBy,
                                    String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
}
