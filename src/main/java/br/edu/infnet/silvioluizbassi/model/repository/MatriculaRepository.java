package br.edu.infnet.silvioluizbassi.model.repository;

import br.edu.infnet.silvioluizbassi.model.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
