package br.edu.infnet.silvioluizbassi.api.openapi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateAlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Aluno", description = "Endpoints para gestão de alunos")
public interface AlunoControllerDocApi {

    @Operation(summary = "Lista todos os alunos", responses = {
            @ApiResponse(responseCode = "200", description = "Alunos listados")
    })
    List<AlunoResponse> listarAlunos();

    @Operation(summary = "Inclui um novo aluno", responses = {
            @ApiResponse(responseCode = "201", description = "Aluno incluído"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class))),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    AlunoResponse criarAluno(AlunoRequest alunoRequest);

    @Operation(summary = "Atualiza um aluno", responses = {
            @ApiResponse(responseCode = "200", description = "Aluno atualizado"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class))),
            @ApiResponse(responseCode = "400", description = "Verifique os campos em (errors)",
                    content = @Content(schema = @Schema(implementation = ProblemDetailFieldValidatorModel.class)))
    })
    AlunoResponse atualizarAluno(UpdateAlunoRequest updateAlunoRequest);

    @Operation(summary = "Busca um aluno pelo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    AlunoResponse obterAlunoPorId(@Parameter(description = "ID de um Aluno") Integer id);

    @Operation(summary = "Excluí um aluno pelo ID", responses = {
            @ApiResponse(responseCode = "204", description = "Aluno excluído"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado",
                    content = @Content(schema = @Schema(implementation = ProblemDetailModel.class)))
    })
    void excluirAlunoPorId(@Parameter(description = "ID de um Aluno") Integer id);
}
