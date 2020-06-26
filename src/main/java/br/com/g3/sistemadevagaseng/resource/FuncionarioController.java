package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.domain.Funcionario;
import br.com.g3.sistemadevagaseng.dto.FuncionarioDTO;
import br.com.g3.sistemadevagaseng.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> find(@PathVariable Long id){
        Funcionario obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){
        List<Funcionario> lista = service.findAll();
        lista = lista.stream().sorted(Comparator.comparing(Funcionario::getId)).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody FuncionarioDTO objDTO, @PathVariable Long id){
        Funcionario obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody FuncionarioDTO objDTO){
        Funcionario obj = service.fromDTO(objDTO);
        obj.setSenha(passwordEncoder.encode(obj.getSenha()));
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
