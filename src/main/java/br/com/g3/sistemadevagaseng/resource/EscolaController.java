package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.domain.Escola;
import br.com.g3.sistemadevagaseng.domain.Turma;
import br.com.g3.sistemadevagaseng.dto.EscolaDTO;
import br.com.g3.sistemadevagaseng.service.EscolaService;
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
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Escola> find(@PathVariable Long id){
        Escola obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Escola>> findAll(){
        List<Escola> lista = service.findAll();
        lista = lista.stream().sorted(Comparator.comparing(Escola::getId)).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody EscolaDTO objDTO, @PathVariable Long id){
        Escola obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<EscolaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Escola> obj = service.findPage(page, linesPerPage, orderBy, direction);
        Page<EscolaDTO> listDTO = obj.map(o -> new EscolaDTO(o));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Escola> save(@RequestBody EscolaDTO objDTO){
        Escola obj = service.fromDTO(objDTO);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}/turmas")
    public ResponseEntity<List<Turma>> escolasETurmas(@PathVariable Long id){
        Escola obj = service.find(id);
        return ResponseEntity.ok(obj.getTurmas());
    }
}
