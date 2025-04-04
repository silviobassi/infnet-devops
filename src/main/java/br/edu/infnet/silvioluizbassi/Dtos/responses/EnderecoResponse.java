package br.edu.infnet.silvioluizbassi.Dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnderecoResponse(
        @Schema(example = "1") Integer id,
        @Schema(example = "Alameda Bernardo Basaglia") String logradouro,
        @Schema(example = "2987") String numero,
        @Schema(example = "(Cond Prq Res Damha I)") String complemento,
        @Schema(example = "Ondas") String bairro,
        @Schema(example = "Piracicaba") String localidade,
        @Schema(example = "São Paulo") String estado,
        @Schema(example = "13403-775") String cep
) {
}
