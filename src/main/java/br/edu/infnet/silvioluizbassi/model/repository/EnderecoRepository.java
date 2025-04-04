package br.edu.infnet.silvioluizbassi.model.repository;

import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
