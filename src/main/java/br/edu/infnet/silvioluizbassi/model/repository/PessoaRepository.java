package br.edu.infnet.silvioluizbassi.model.repository;

import br.edu.infnet.silvioluizbassi.model.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
