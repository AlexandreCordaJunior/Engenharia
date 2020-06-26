package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.Escola;
import br.com.g3.sistemadevagaseng.domain.Funcionario;
import br.com.g3.sistemadevagaseng.dto.EscolaDTO;
import br.com.g3.sistemadevagaseng.repository.EscolaRepository;
import br.com.g3.sistemadevagaseng.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {
    @Autowired
    private EscolaRepository repo;

    @Autowired
    private FuncionarioService funcionarioService;

    public Escola find(Long id){
        Optional<Escola> opt = repo.findById(id);
        return opt.orElseThrow(() -> {
            return new ObjectNotFoundException("Id não encontrado - " + Escola.class.getName());
        });
    }

    public List<Escola> findAll(){
        return repo.findAll();
    }

    public void delete(Long id){
        Escola obj = find(id);
        obj.setEstado('I');
        repo.save(obj);
    }

    public Escola update(Escola obj){
        Escola novoObj = find(obj.getId());
        updateData(novoObj, obj);
        return repo.save(novoObj);
    }

    private void updateData(Escola novoObj, Escola obj) {
        novoObj.setNome(obj.getNome());
        novoObj.setEmail(obj.getEmail());
        novoObj.setTelefone(obj.getTelefone());
        novoObj.setEndereco(obj.getEndereco());
        novoObj.setCnpj(obj.getCnpj());
        novoObj.setEstado(obj.getEstado());
        novoObj.setResponsavelPeloCadastro(obj.getResponsavelPeloCadastro());
    }

    public Escola save(Escola obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Escola fromDTO(EscolaDTO objDTO){
        Funcionario responsavel = funcionarioService.find(objDTO.getResponsavelPeloCadastroId());

        return new Escola(
                objDTO.getId(),
                objDTO.getNome(),
                objDTO.getEmail(),
                objDTO.getTelefone(),
                objDTO.getEndereco(),
                objDTO.getCnpj(),
                objDTO.getEstado(),
                responsavel
        );
    }
}
