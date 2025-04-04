package br.edu.infnet.silvioluizbassi.model.repository;

import br.edu.infnet.silvioluizbassi.model.domain.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {
}
