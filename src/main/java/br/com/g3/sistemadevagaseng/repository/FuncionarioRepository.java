package br.com.g3.sistemadevagaseng.repository;

import br.com.g3.sistemadevagaseng.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Transactional(readOnly = true)
    public Funcionario findByEmail(String email);
}
