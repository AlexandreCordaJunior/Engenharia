package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.domain.Turma;
import br.com.g3.sistemadevagaseng.dto.TurmaDTO;
import br.com.g3.sistemadevagaseng.service.TurmaService;
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
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Turma> find(@PathVariable Long id){
        Turma obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        List<Turma> lista = service.findAll();
        lista = lista.stream().sorted(Comparator.comparing(Turma::getId)).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody TurmaDTO objDTO, @PathVariable Long id){
        Turma obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<TurmaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Turma> obj = service.findPage(page, linesPerPage, orderBy, direction);
        Page<TurmaDTO> listDTO = obj.map(o -> new TurmaDTO(o));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody TurmaDTO objDTO){
        Turma obj = service.fromDTO(objDTO);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
