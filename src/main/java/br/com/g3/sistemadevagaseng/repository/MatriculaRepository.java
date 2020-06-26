package br.com.g3.sistemadevagaseng.repository;

import br.com.g3.sistemadevagaseng.domain.Matricula;
import br.com.g3.sistemadevagaseng.domain.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    @Query("select sol from Matricula m inner join Solicitacao sol on sol.id = m.solicitacao.id inner join Turma t on t.id = m.turma.id where t.id = :id")
    public List<Solicitacao> getAll(@Param("id") Long id);

    @Query("select sol from Solicitacao sol where sol.id not in (select s.id from Solicitacao s inner join Matricula m on m.solicitacao.id = s.id) and sol.turma.id = :id and sol.estado = 'A'")
    public List<Solicitacao> semTurma(@Param("id") Long id);
}
