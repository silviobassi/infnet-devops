package br.edu.infnet.silvioluizbassi.Dtos.responses;

import br.edu.infnet.silvioluizbassi.model.domain.NivelBootcamp;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record BootcampResponse(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Bootcamp de Java")
        String titulo,
        @Schema(example = "Bootcamp de Java para iniciantes")
        String descricao,
        @Schema(example = "1000.00")
        float valor,
        @Schema(example = "100")
        int cargaHoraria,
        @Schema(example = "Conhecimento básico em Java")
        String preRequisitos,
        @Schema(example = "true")
        boolean estagioObrigatorio,
        @Schema(example = "true")
        boolean ativo,
        @Schema(example = "INTERMEDIARIO")
        NivelBootcamp nivel,
        List<InstrutorCursoResponse> instrutores
) {
}
