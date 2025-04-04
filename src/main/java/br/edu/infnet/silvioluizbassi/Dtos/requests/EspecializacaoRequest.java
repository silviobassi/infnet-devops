package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.validation.TipoEspecializacaoValido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record EspecializacaoRequest(
        @NotBlank
        @Schema(example = "Especialização de Java")
        String titulo,
        @NotBlank
        @Schema(example = "Especialização de Java com Spring Boot")
        String descricao,
        @DecimalMin("1.00")
        @Schema(example = "1000.00")
        float valor,
        @DecimalMin("1")
        @Schema(example = "100")
        int cargaHoraria,
        @NotBlank
        @Schema(example = "Conhecimento básico em Java")
        String preRequisitos,
        @NotNull
        @Schema(example = "true")
        Boolean estagioObrigatorio,
        @TipoEspecializacaoValido
        @Schema(example = "EXTENSAO")
        String tipoDeEspecializacao,
        @Valid
        List<InstrutorRequestId> instrutores
) {
}
