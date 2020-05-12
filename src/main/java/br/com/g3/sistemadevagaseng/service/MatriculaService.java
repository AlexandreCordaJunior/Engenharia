package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.Matricula;
import br.com.g3.sistemadevagaseng.domain.Solicitacao;
import br.com.g3.sistemadevagaseng.domain.Turma;
import br.com.g3.sistemadevagaseng.dto.MatriculaDTO;
import br.com.g3.sistemadevagaseng.repository.MatriculaRepository;
import br.com.g3.sistemadevagaseng.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository repo;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private SolicitacaoService solicitacaoService;

    public Matricula find(Long id){
        Optional<Matricula> opt = repo.findById(id);
        return opt.orElseThrow(() -> {
            return new ObjectNotFoundException("Id não encontrado - " + Matricula.class.getName());
        });
    }

    public List<Matricula> findAll(){
        return repo.findAll();
    }

    public Matricula update(Matricula obj){
        Matricula novoObj = find(obj.getId());
        updateData(novoObj, obj);
        return repo.save(novoObj);
    }

    private void updateData(Matricula novoObj, Matricula obj) {
        novoObj.setId(obj.getId());
        novoObj.setSolicitacao(obj.getSolicitacao());
        novoObj.setTurma(obj.getTurma());
    }

    public Matricula save(Matricula obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Matricula fromDTO(MatriculaDTO objDTO){

        Turma turma = turmaService.find(objDTO.getTurmaId());

        Solicitacao solicitacao = solicitacaoService.find(objDTO.getSolicitacaoId());

        return new Matricula(
                objDTO.getId(),
                solicitacao,
                turma
        );
    }

    public Page<Matricula> findPage(Integer page, Integer linesPerPage, String orderBy,
                                    String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
}
