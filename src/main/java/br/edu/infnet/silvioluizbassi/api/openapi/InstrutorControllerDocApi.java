package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateAlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateInstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Instrutor", description = "Endpoints de Instrutor")
public interface InstrutorControllerDocApi {

    @Operation(summary = "Lista todos os instrutores", responses = {
            @ApiResponse(responseCode = "200", description = "Instrutores listados")
    })
    List<InstrutorResponse> listarInstrutores();

    @Operation(summary = "Inclui um novo instrutor", responses = {
            @ApiResponse(responseCode = "201", description = "Instrutor incluído"),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    InstrutorResponse criarInstrutor(InstrutorRequest instrutorRequest);

    @Operation(summary = "Atualiza um instrutor", responses = {
            @ApiResponse(responseCode = "200", description = "Instrutor atualizado"),
            @ApiResponse(responseCode = "404", description = "Instrutor não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class))),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    InstrutorResponse atualizarInstrutor(UpdateInstrutorRequest updateInstrutorRequest);

    @Operation(summary = "Busca um Instrutor pelo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Instrutor encontrado"),
            @ApiResponse(responseCode = "404", description = "Instrutor não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    InstrutorResponse obterInstrutorPorId(@Parameter(description = "ID do Instrutor") Integer id);

    @Operation(summary = "Excluí um Instrutor pelo ID", responses = {
            @ApiResponse(responseCode = "204", description = "Instrutor excluído"),
            @ApiResponse(responseCode = "404", description = "Instrutor não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    void excluirInstrutorPorId(@Parameter(description = "ID do Instrutor") Integer id);
}
