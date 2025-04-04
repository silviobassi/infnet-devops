package br.edu.infnet.silvioluizbassi.Dtos.responses;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record InstrutorResponse(
        @Schema(example = "1")
        Integer id,
        @Schema(example = "Marta Soraia")
        String nome,
        @Schema(example = "1990-01-01T00:00:00")
        LocalDateTime dataNascimento,
        @Schema(example = "FEMININO")
        Genero genero,
        @Schema(example = "marta@marta.email.com")
        String email,
        @Schema(example = "+552199999-9999")
        String whatsApp,

        EnderecoResponse endereco,

        @Schema(example = "Graduada em Engenharia de Software")
        String formacao,
        @Schema(example = "Especialista em Arquitetura de Software")
        String especialidade
) {
}
