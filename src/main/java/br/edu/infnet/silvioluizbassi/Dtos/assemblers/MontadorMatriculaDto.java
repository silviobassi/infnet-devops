package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Matricula;

import java.util.List;

public class MontadorMatriculaDto {

    public static MatriculaResponse toMatriculaResponse(Matricula matricula) {

        return new MatriculaResponse(
                matricula.getId(),
                matricula.getNumeroDaMatricula(),
                matricula.getDataMatricula(),
                matricula.isAtiva(),
                MontadorAlunoDto.toAlunoMatriculaResponse(matricula.getAluno()),
                MontadorCursoDto.toCursoMatriculaResponse(matricula.getCurso())
        );
    }

    public static List<MatriculaResponse> toMatriculasResponse(List<Matricula> matriculas) {
        return matriculas.stream().map(MontadorMatriculaDto::toMatriculaResponse).toList();
    }

}