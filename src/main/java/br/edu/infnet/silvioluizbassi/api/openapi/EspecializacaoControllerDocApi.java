package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateEspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Especialização", description = "Endpoints de Especialização")
public interface EspecializacaoControllerDocApi {


    @Operation(summary = "Lista todos as especializações", responses = {
            @ApiResponse(responseCode = "200", description = "Especializações listadas")
    })
    List<EspecializacaoResponse> listarEspecializacoes();

    @Operation(summary = "Inclui uma nova especialização", responses = {
            @ApiResponse(responseCode = "201", description = "Especialização incluída"),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    EspecializacaoResponse incluirEspecializacao(EspecializacaoRequest especializacaoRequest);

    @Operation(summary = "Atualiza uma especialização", responses = {
            @ApiResponse(responseCode = "200", description = "Especialização atualizada"),
            @ApiResponse(responseCode = "404", description = "Especialização não encontrada",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class))),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    EspecializacaoResponse atualizarEspecializacao(UpdateEspecializacaoRequest updateEspecializacaoRequest);

    @Operation(summary = "Busca uma Especialização pelo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    public EspecializacaoResponse obterEspecializacaoPorId(@Parameter(description = "ID de um Especialiação") Integer id);

    @Operation(summary = "Excluí uma Especialização pelo ID", responses = {
            @ApiResponse(responseCode = "204", description = "Especialização excluída"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    void excluirEspecializacaoPorId(@Parameter(description = "ID de uma Especialização") Integer id);
}
