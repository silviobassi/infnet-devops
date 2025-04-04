package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateBootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Bootcamp", description = "Endpoints de Bootcamp")
public interface BootcampControllerDocApi {


    @Operation(summary = "Lista todos os bootcamps", responses = {
            @ApiResponse(responseCode = "200", description = "Bootcamps listados")
    })
    List<BootcampResponse> listarBootcamps();

    @Operation(summary = "Inclui um novo bootcamp", responses = {
            @ApiResponse(responseCode = "201", description = "Bootcamp incluído"),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    BootcampResponse incluirBootcamp(BootcampRequest bootcampRequest);

    @Operation(summary = "Atualiza um bootcamp", responses = {
            @ApiResponse(responseCode = "200", description = "Bootcamp atualizado"),
            @ApiResponse(responseCode = "404", description = "Bootcamp não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class))),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    BootcampResponse atualizarBootcamp(UpdateBootcampRequest updateBootcampRequest);

    @Operation(summary = "Busca um bootcamp pelo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    BootcampResponse obterBootcampPorId(@Parameter(description = "ID de um Bootcamp") Integer id);

    @Operation(summary = "Excluí um bootcamp pelo ID", responses = {
            @ApiResponse(responseCode = "204", description = "Bootcamp excluído"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    void excluirBootcampPorId(@Parameter(description = "ID de um Bootcamp") Integer id);
}
