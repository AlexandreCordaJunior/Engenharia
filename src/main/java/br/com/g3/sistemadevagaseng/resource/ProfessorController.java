package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.domain.Professor;
import br.com.g3.sistemadevagaseng.dto.ProfessorDTO;
import br.com.g3.sistemadevagaseng.service.ProfessorService;
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
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Professor> find(@PathVariable Long id){
        Professor obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        List<Professor> lista = service.findAll();
        lista = lista.stream().sorted(Comparator.comparing(Professor::getId)).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ProfessorDTO objDTO, @PathVariable Long id){
        Professor obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ProfessorDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Professor> obj = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ProfessorDTO> listDTO = obj.map(o -> new ProfessorDTO(o));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Professor> save(@RequestBody ProfessorDTO objDTO){
        Professor obj = service.fromDTO(objDTO);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
