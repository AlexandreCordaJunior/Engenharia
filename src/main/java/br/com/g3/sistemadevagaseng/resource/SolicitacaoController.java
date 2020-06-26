package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.domain.Solicitacao;
import br.com.g3.sistemadevagaseng.dto.SolicitacaoDTO;
import br.com.g3.sistemadevagaseng.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> find(@PathVariable Long id){
        Solicitacao obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Solicitacao>> findAll(){
        List<Solicitacao> lista = service.findAll();
        lista = lista.stream().sorted(Comparator.comparing(Solicitacao::getId)).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody SolicitacaoDTO objDTO, @PathVariable Long id){
        Solicitacao obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Solicitacao> save(@RequestBody SolicitacaoDTO objDTO){
        Solicitacao obj = service.fromDTO(objDTO);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
