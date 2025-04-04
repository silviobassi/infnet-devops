package br.edu.infnet.silvioluizbassi.Dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

public record CursoRequestId(
        @Min(1)
        @Schema(example = "2")
        Integer id
) {
}
