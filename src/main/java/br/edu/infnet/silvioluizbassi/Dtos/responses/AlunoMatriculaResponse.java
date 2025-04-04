package br.edu.infnet.silvioluizbassi.Dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlunoMatriculaResponse(
        @Schema(example = "1")
        long id,
        @Schema(example = "Silvio Luiz Bassi")
        String nome,
        @Schema(example = "false")
        boolean bolsista,
        @Schema(example = "true")
        boolean enem
) {
}
