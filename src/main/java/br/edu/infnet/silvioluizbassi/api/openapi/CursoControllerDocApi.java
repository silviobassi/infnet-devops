package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdatePrecoCursoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Curso", description = "Endpoints de Cursos")
public interface CursoControllerDocApi {

    @Operation(summary = "Lista todos os cursos", responses = {
            @ApiResponse(responseCode = "200", description = "Cursos listados")
    })
    List<CursoResponse> listarCursos();

    @Operation(summary = "Lista todos os cursos por preços fornecidos", responses = {
            @ApiResponse(responseCode = "200", description = "Cursos listados por preços fornecidos"),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    List<CursoResponse> listarCursosPorPrecos(float precoInicial, float precoFinal);

    @Operation(summary = "Atualiza o preço de um curso", responses = {
            @ApiResponse(responseCode = "200", description = "Preço do curso atualizado"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class))),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    CursoResponse atualizarPreco(UpdatePrecoCursoRequest updatePrecoCursoRequest);
}
