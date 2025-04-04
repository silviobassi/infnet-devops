package br.edu.infnet.silvioluizbassi.api.openapi;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(name = "ProblemDetailModel", description = "Detalhes do problema conforme a RFC 7807")
public interface ProblemDetailModel {

    @Schema(example = "https://infnet.com/aluno-not-found")
    String getType();

    @Schema(example = "Aluno Not Found")
    String getTitle();

    @Schema(example = "404")
    Integer getStatus();

    @Schema(example = "Aluno não encontrado")
    String getDetail();

    @Schema(example = "/10/excluir_aluno")
    String getInstance();

    @Schema(example = "2021-09-01T00:00:00")
    LocalDateTime getTimestamp();
}
