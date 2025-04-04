package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateMatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Matrícula", description = "Endpoints de Matriculas")
public interface MatriculaControllerDocApi {

    @Operation(summary = "Lista todas as matrículas", responses = {
            @ApiResponse(responseCode = "200", description = "Matrículas listadas")
    })
    List<MatriculaResponse> listarMatriculas();

    @Operation(summary = "Inclui uma nova matrícula", responses = {
            @ApiResponse(responseCode = "201", description = "Matrícula incluída"),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    MatriculaResponse criarMatricula(MatriculaRequest matriculaRequest);

    @Operation(summary = "Atualiza uma matrícula", responses = {
            @ApiResponse(responseCode = "200", description = "Matrícula atualizada"),
            @ApiResponse(responseCode = "404", description = "Matrícula não encontrada",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class))),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    MatriculaResponse atualizarMatricula(UpdateMatriculaRequest updateMatriculaRequest);

    @Operation(summary = "Busca uma matrícula pelo id", responses = {
            @ApiResponse(responseCode = "200", description = "Matrícula encontrada"),
            @ApiResponse(responseCode = "404", description = "Matrícula não encontrada",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    MatriculaResponse buscarMatricula(@Parameter(description = "ID da Matrícula") Integer id);

    @Operation(summary = "Exclui uma matrícula pelo id", responses = {
            @ApiResponse(responseCode = "204", description = "Matrícula excluída"),
            @ApiResponse(responseCode = "404", description = "Matrícula não encontrada",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    void excluirMatricula(@Parameter(description = "ID da Matrícula") Integer id);

}
