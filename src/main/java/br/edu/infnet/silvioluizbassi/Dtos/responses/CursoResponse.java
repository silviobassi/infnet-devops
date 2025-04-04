package br.edu.infnet.silvioluizbassi.Dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record CursoResponse(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Java")
        String titulo,
        @Schema(example = "890.00")
        float valor,
        @Schema(example = "40")
        int cargaHoraria,
        @Schema(example = "Conhecimento em lógica de programação")
        String preRequisitos,
        @Schema(example = "true")
        boolean estagioObrigatorio,
        @Schema(example = "true")
        boolean ativo,
        List<InstrutorCursoResponse> instrutores
) {
}