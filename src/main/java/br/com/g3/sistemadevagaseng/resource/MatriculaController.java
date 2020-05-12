package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.domain.Matricula;
import br.com.g3.sistemadevagaseng.dto.MatriculaDTO;
import br.com.g3.sistemadevagaseng.service.MatriculaService;
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
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> find(@PathVariable Long id){
        Matricula obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> findAll(){
        List<Matricula> lista = service.findAll();
        lista = lista.stream().sorted(Comparator.comparing(Matricula::getId)).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody MatriculaDTO objDTO, @PathVariable Long id){
        Matricula obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<MatriculaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Matricula> obj = service.findPage(page, linesPerPage, orderBy, direction);
        Page<MatriculaDTO> listDTO = obj.map(o -> new MatriculaDTO(o));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Matricula> save(@RequestBody MatriculaDTO objDTO){
        Matricula obj = service.fromDTO(objDTO);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
