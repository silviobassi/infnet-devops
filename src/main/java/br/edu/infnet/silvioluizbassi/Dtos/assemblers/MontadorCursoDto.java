package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoMatriculaResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutoresCursoResponse;

public class MontadorCursoDto {

    public static CursoMatriculaResponse toCursoMatriculaResponse(Curso curso) {
        return new CursoMatriculaResponse(curso.getId(), curso.getTitulo(), curso.getDescricao());
    }

    public static CursoResponse toCursoResponse(Curso curso) {
        return new CursoResponse(
                curso.getId(),
                curso.getTitulo(),
                curso.getValor(),
                curso.getCargaHoraria(),
                curso.getPreRequisitos(),
                curso.isEstagioObrigatorio(),
                curso.isAtivo(),
                toInstrutoresCursoResponse(curso.getInstrutores()));
    }

    public static List<CursoResponse> toCursosResponse(List<Curso> cursos) {
        return cursos.stream().map(MontadorCursoDto::toCursoResponse).toList();
    }
}