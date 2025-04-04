package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MatriculaRequest(
        @Min(1)
        @Schema(example = "2584965")
        long numeroDaMatricula,

        @NotNull
        @Valid
        AlunoRequestId aluno,

        @NotNull
        @Valid
        CursoRequestId curso
) {
}
