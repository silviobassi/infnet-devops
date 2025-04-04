package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.validation.GeneroValido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateAlunoRequest(
        @NotNull
        @Min(1)
        Integer id,
        @Schema(example = "Marta Soraia")
        @NotBlank
        String nome,
        @NotNull
        LocalDateTime dataNascimento,
        @Schema(example = "FEMININO")
        @GeneroValido
        String genero,
        @Schema(example = "marta@marta.email.com")
        @NotBlank
        @Email
        String email,
        @Schema(example = "+552199999-9999")
        @NotBlank
        String whatsApp,
        @Schema(example = "13403-775")
        @NotBlank
        String cep,
        @Schema(example = "true")
        @NotNull
        Boolean isBolsista,
        @Schema(example = "false")
        @NotNull
        Boolean isEnem
) {

}
