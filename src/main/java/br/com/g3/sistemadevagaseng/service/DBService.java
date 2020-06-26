package br.com.g3.sistemadevagaseng.service;

import br.com.g3.sistemadevagaseng.domain.*;
import br.com.g3.sistemadevagaseng.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;

@Service
public class DBService {
    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorTurmaRepository professorTurmaRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void iniciarDatabase(){
        Funcionario funcionario1 = new Funcionario(null, "47618982830",
            "507992738", Calendar.getInstance().getTime(), 'M', "ale.corda01@gmail.com",
            "97979797", "Rua 1*Ita", "Alexandre", 'A', null, passwordEncoder.encode("senha"));

        Funcionario funcionario2 = new Funcionario(null, "4761898283",
            "50799738", Calendar.getInstance().getTime(), 'F', "alase.corda01@gmail.com",
            "97979797", "Rua 1*Ita", "Alexa", 'I', funcionario1, passwordEncoder.encode("senha"));

        funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2));
        /*--------------------------------------------------------------------*/

        Professor professor1 = new Professor(null, "47618982830",
                "507992738", Calendar.getInstance().getTime(), 'M', "ale.corda01@gmail.com",
                "97979797", "Rua 1*Ita", "Alexandre", 'A', funcionario2);

        Professor professor2 = new Professor(null, "4761898283",
                "50799738", Calendar.getInstance().getTime(), 'F', "alase.corda01@gmail.com",
                "97979797", "Rua 1*Ita", "Alexa", 'I', funcionario1);

        professorRepository.saveAll(Arrays.asList(professor1, professor2));
        /*--------------------------------------------------------------------*/

        Escola escola1 = new Escola(null, "Racanela", "raca@raca.com", "798754651321", "Rua 5*58", "646464646", 'A', funcionario1);
        Escola escola2 = new Escola(null, "Nilse", "nilse@raca.com", "798754651321", "Rua 59*58", "646464646", 'A', funcionario1);

        escolaRepository.saveAll(Arrays.asList(escola1, escola2));
        /*--------------------------------------------------------------------*/

        Turma turma1 = new Turma(null, "115" , 'T', "Maternal", 120, 'A', escola1, funcionario1);
        Turma turma2 = new Turma(null, "145" , 'M', "Maternal", 1020, 'A', escola1, funcionario2);

        escola1.getTurmas().addAll(Arrays.asList(turma1, turma2));

        turmaRepository.saveAll(Arrays.asList(turma1, turma2));
        /*--------------------------------------------------------------------*/

        ProfessorTurma professorTurma1 = new ProfessorTurma(professor1, turma1);
        ProfessorTurma professorTurma2 = new ProfessorTurma(professor2, turma2);

        professorTurmaRepository.saveAll(Arrays.asList(professorTurma1, professorTurma2));
        /*--------------------------------------------------------------------*/

        Solicitacao solicitacao1 = new Solicitacao(null, "Alfredo", Calendar.getInstance().getTime(),
            'M', "654654654654", "Adolfo", "Rua 15*Ipo", "97643164", turma1
            , 'A', Calendar.getInstance().getTime(), "alfredo@a.com", funcionario1);
        Solicitacao solicitacao2 = new Solicitacao(null, "Alfreda", Calendar.getInstance().getTime(),
                'F', "6546546154654", "Adolfa", "Rua 15*Ipoa", "976431644", turma1
                , 'A', Calendar.getInstance().getTime(), "alfreda@a.com", funcionario1);

        solicitacaoRepository.saveAll(Arrays.asList(solicitacao1, solicitacao2));
        /*--------------------------------------------------------------------*/

        Matricula matricula1 = new Matricula(null, solicitacao1, turma1);
        Matricula matricula2 = new Matricula(null, solicitacao2, turma1);

        matriculaRepository.saveAll(Arrays.asList(matricula1, matricula2));
        /*--------------------------------------------------------------------*/
    }
}
