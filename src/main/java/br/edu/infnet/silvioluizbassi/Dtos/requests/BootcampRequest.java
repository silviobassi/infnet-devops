package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.validation.NivelBootcampValido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BootcampRequest(
        @NotBlank
        @Schema(example = "Bootcamp de Java")
        String titulo,
        @NotBlank
        @Schema(example = "Bootcamp de Java com Spring Boot")
        String descricao,
        @DecimalMin(value = "1.0")
        @Schema(example = "1000.00")
        float valor,
        @Min(1)
        @Schema(example = "100")
        int cargaHoraria,
        @NotBlank
        @Schema(example = "Conhecimento básico em Java")
        String preRequisitos,
        @NotNull
        @Schema(example = "true")
        Boolean estagioObrigatorio,
        @NivelBootcampValido
        @Schema(example = "INTERMEDIARIO")
        String nivel,
        @Valid
        List<InstrutorRequestId> instrutores
) {
}
