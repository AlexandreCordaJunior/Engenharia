package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.Funcionario;
import br.com.g3.sistemadevagaseng.dto.FuncionarioDTO;
import br.com.g3.sistemadevagaseng.repository.FuncionarioRepository;
import br.com.g3.sistemadevagaseng.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repo;

    public Funcionario find(Long id){
        Optional<Funcionario> opt = repo.findById(id);
        return opt.orElseThrow(() -> {
            return new ObjectNotFoundException("Id não encontrado - " + Funcionario.class.getName());
        });
    }

    public List<Funcionario> findAll(){
        return repo.findAll();
    }

    public void delete(Long id){
        Funcionario obj = find(id);
        obj.setEstado('I');
        repo.save(obj);
    }

    public Funcionario update(Funcionario obj){
        Funcionario novoObj = find(obj.getId());
        updateData(novoObj, obj);
        return repo.save(novoObj);
    }

    private void updateData(Funcionario novoObj, Funcionario obj) {
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

    public Funcionario save(Funcionario obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Funcionario fromDTO(FuncionarioDTO funcionarioDTO){
        Funcionario responsavel = find(funcionarioDTO.getResponsavelPeloCadastroId());

        return new Funcionario(
                funcionarioDTO.getId(),
                funcionarioDTO.getCpf(),
                funcionarioDTO.getRg(),
                funcionarioDTO.getDataDeNascimento(),
                funcionarioDTO.getSexo(),
                funcionarioDTO.getEmail(),
                funcionarioDTO.getTelefone(),
                funcionarioDTO.getEndereco(),
                funcionarioDTO.getNome(),
                funcionarioDTO.getEstado(),
                responsavel
        );
    }

    public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy,
                                    String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
}
