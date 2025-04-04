package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateMatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.api.openapi.MatriculaControllerDocApi;
import br.edu.infnet.silvioluizbassi.model.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/matriculas")
public class MatriculaController implements MatriculaControllerDocApi {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping(value = "/listar")
    public List<MatriculaResponse> listarMatriculas() {
        return matriculaService.obterMatriculas();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar")
    public MatriculaResponse criarMatricula(@RequestBody @Valid MatriculaRequest matriculaRequest) {
        return matriculaService.incluir(matriculaRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/atualizar")
    public MatriculaResponse atualizarMatricula(@RequestBody @Valid UpdateMatriculaRequest updateMatriculaRequest) {
        return matriculaService.atualizar(updateMatriculaRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/buscar")
    public MatriculaResponse buscarMatricula(@PathVariable Integer id) {
        return matriculaService.obterMatriculaPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/excluir")
    public void excluirMatricula(@PathVariable Integer id) {
        matriculaService.excluir(id);
    }

}
