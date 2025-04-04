package br.edu.infnet.silvioluizbassi.Dtos.requests;

import br.edu.infnet.silvioluizbassi.validation.GeneroValido;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateInstrutorRequest(
        @Schema(example = "1")
        Integer id,
        @NotBlank
        @Schema(example = "Silvio Luiz Bassi")
        String nome,
        @NotNull
        @Schema(example = "1980-01-01T00:00:00")
        LocalDateTime dataNascimento,
        @GeneroValido
        @Schema(example = "MASCULINO")
        String genero,
        @Email
        @Schema(example = "silvio@email.com")
        String email,
        @NotBlank
        @Schema(example = "+552199999-9999")
        String whatsApp,
        @NotBlank
        @Schema(example = "13403-775")
        String cep,
        @NotBlank
        @Schema(example = "Engenheiro de Software")
        String formacao,
        @NotBlank
        @Schema(example = "Desenvolvimento de Software")
        String especialidade
) {
}
