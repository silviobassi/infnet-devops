package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

public record UpdatePrecoCursoRequest(
        @Min(1)
        @Schema(example = "1")
        Integer id,
        @DecimalMin("1.00")
        @Schema(example = "1000.00")
        float preco
) {
}
