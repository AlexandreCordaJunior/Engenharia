package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.domain.ProfessorTurma;
import br.com.g3.sistemadevagaseng.service.ProfessorTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professor_turma")
public class ProfessorTurmaController {

    @Autowired
    private ProfessorTurmaService service;

    @GetMapping("/{professorId}/{turmaId}")
    public ResponseEntity<ProfessorTurma> find(@PathVariable Long professorId, @PathVariable Long turmaId){
        ProfessorTurma obj = service.find(professorId, turmaId);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorTurma>> findAll(){
        List<ProfessorTurma> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{professorId}/{turmaId}")
    public ResponseEntity<Void> delete(@PathVariable Long professorId, @PathVariable Long turmaId){
        service.delete(professorId, turmaId);
        return ResponseEntity.noContent().build();
    }

    /*@PostMapping
    public ResponseEntity<ProfessorTurma> save(@RequestBody ProfessorTurmaDTO objDTO){
        ProfessorTurma obj = service.fromDTO(objDTO);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }*/

}
