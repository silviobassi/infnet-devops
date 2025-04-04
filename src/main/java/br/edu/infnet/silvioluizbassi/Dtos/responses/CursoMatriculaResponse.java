package br.edu.infnet.silvioluizbassi.Dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

public record CursoMatriculaResponse(
        @Schema(example = "1")
        long id,
        @Schema(example = "Bootcamp de Java")
        String titulo,
        @Schema(example = "Bootcamp de Java com Spring Boot")
        String descricao
) {
}
