package br.edu.infnet.silvioluizbassi.model.repository;

import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findCursoByValorBetween(float precoInicial, float precoFinal);
}
