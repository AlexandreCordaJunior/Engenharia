package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.dto.DadosDTO;
import br.com.g3.sistemadevagaseng.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DadosService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public DadosDTO getDados() {
        return new DadosDTO(
                funcionarioRepository.count(),
                professorRepository.count(),
                escolaRepository.count(),
                turmaRepository.count(),
                solicitacaoRepository.count()
        );
    }


}
