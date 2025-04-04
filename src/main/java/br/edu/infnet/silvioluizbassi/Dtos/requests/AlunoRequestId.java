package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AlunoRequestId(
        @Schema(example = "1")
        @NotNull
        @Min(1)
        Integer id
) {
}
