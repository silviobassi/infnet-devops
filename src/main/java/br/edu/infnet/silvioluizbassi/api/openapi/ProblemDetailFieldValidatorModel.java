package br.edu.infnet.silvioluizbassi.api.openapi;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Schema(name = "ProblemDetailValidatorModel", description = "Detalhes do problema conforme a RFC 7807")
public interface ProblemDetailFieldValidatorModel {

    @Schema(example = "https://infnet.com/bad-request-exception-invalid-fields")
    String getType();

    @Schema(example = "Bad Request Exception - Invalid Fields")
    String getTitle();

    @Schema(example = "400")
    Integer getStatus();

    @Schema(example = "Aluno não encontrado")
    String getDetail();

    @Schema(example = "/10/excluir_aluno")
    String getInstance();

    @Schema(example = "2021-09-01T00:00:00")
    LocalDateTime getTimestamp();

    List<ErrorsModel> getErrors();

    interface ErrorsModel {
        @Schema(example = "dataNascimento")
        String getField();

        @Schema(example = "must not be null")
        String getMessage();
    }
}
