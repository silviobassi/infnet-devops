package br.edu.infnet.silvioluizbassi.Dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

public record InstrutorCursoResponse(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Silvio Bassi")
        String nome
) {
}
