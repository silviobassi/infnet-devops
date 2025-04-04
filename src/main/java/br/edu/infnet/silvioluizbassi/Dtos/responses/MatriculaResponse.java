package br.edu.infnet.silvioluizbassi.Dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record MatriculaResponse(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "2584965")
        long numeroDaMatricula,
        @Schema(example = "2021-08-01T00:00:00")
        LocalDateTime dataMatricula,
        @Schema(example = "true")
        boolean ativa,

        AlunoMatriculaResponse aluno,
        CursoMatriculaResponse curso
) {
}