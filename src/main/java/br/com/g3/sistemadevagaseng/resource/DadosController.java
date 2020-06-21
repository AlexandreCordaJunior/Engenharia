package br.com.g3.sistemadevagaseng.resource;

import br.com.g3.sistemadevagaseng.dto.DadosDTO;
import br.com.g3.sistemadevagaseng.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    private DadosService dadosService;

    @GetMapping
    public ResponseEntity<DadosDTO> getDados() {
        return ResponseEntity.ok(dadosService.getDados());
    }

}
