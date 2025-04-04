package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdatePrecoCursoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoResponse;
import br.edu.infnet.silvioluizbassi.api.openapi.CursoControllerDocApi;
import br.edu.infnet.silvioluizbassi.model.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController implements CursoControllerDocApi {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/listar")
    public List<CursoResponse> listarCursos() {
        return cursoService.obterCursos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/listarPorPrecos")
    public List<CursoResponse> listarCursosPorPrecos(@RequestParam float precoInicial, @RequestParam float precoFinal) {
        return cursoService.obterCursosPorPrecos(precoInicial, precoFinal);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/preco/atualizar")
    public CursoResponse atualizarPreco(@RequestBody @Valid UpdatePrecoCursoRequest updatePrecoCursoRequest) {
        return cursoService.atualizarPreco(updatePrecoCursoRequest);
    }
}
