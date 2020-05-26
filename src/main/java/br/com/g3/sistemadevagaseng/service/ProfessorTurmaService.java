package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.*;
import br.com.g3.sistemadevagaseng.dto.ProfessorTurmaDTO;
import br.com.g3.sistemadevagaseng.repository.ProfessorTurmaRepository;
import br.com.g3.sistemadevagaseng.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorTurmaService {
    @Autowired
    private ProfessorTurmaRepository repo;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private TurmaService turmaService;

    public ProfessorTurma find(Long professorId, Long turmaId){
        Professor professor = professorService.find(professorId);
        Turma turma = turmaService.find(turmaId);
        Optional<ProfessorTurma> opt = repo.findById(new ProfessorTurma(professor, turma).getProfessorTurmaId());        return opt.orElseThrow(() -> {
            return new ObjectNotFoundException("Id não encontrado - " + ProfessorTurma.class.getName());
        });
    }

    public List<ProfessorTurma> findAll(){
        return repo.findAll();
    }

    public ProfessorTurma save(ProfessorTurma obj){
        try{
            find(obj.getProfessorTurmaId().getProfessor().getId(), obj.getProfessorTurmaId().getTurma().getId());
            return null;
        }
        catch (ObjectNotFoundException e){
            return repo.save(obj);
        }
    }

    public void delete(Long professorId, Long turmaId){
        find(professorId, turmaId);
        try{
            Professor professor = professorService.find(professorId);
            Turma turma = turmaService.find(turmaId);
            repo.deleteById(new ProfessorTurma(professor, turma).getProfessorTurmaId());
        }
        catch (DataIntegrityViolationException e){
            throw new RuntimeException("Não é possivel excluir");
        }

    }

    public Page<ProfessorTurma> findPage(Integer page, Integer linesPerPage, String orderBy,
                                    String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public ProfessorTurma fromDTO(ProfessorTurmaDTO objDTO){
        Professor professor = professorService.find(objDTO.getProfessor_id());
        Turma turma = turmaService.find(objDTO.getTurma_id());
        return new ProfessorTurma(professor, turma);
    }
}
