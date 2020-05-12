package br.com.g3.sistemadevagaseng.repository;

import br.com.g3.sistemadevagaseng.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
