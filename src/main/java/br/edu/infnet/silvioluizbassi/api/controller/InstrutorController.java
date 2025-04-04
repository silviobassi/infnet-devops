package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateInstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.api.openapi.InstrutorControllerDocApi;
import br.edu.infnet.silvioluizbassi.model.service.InstrutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/instrutores")
public class InstrutorController implements InstrutorControllerDocApi {

    private final InstrutorService instrutorService;

    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @GetMapping(value = "/listar")
    public List<InstrutorResponse> listarInstrutores() {
        return instrutorService.obterInstrutores();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/criar")
    public InstrutorResponse criarInstrutor(@RequestBody @Valid InstrutorRequest instrutorRequest) {
        return instrutorService.incluir(instrutorRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/atualizar")
    public InstrutorResponse atualizarInstrutor(@RequestBody @Valid UpdateInstrutorRequest updateInstrutorRequest) {
        return instrutorService.atualizar(updateInstrutorRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}/buscar")
    public InstrutorResponse obterInstrutorPorId(@PathVariable Integer id) {
        return instrutorService.obterInstrutorPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/excluir")
    public void excluirInstrutorPorId(@PathVariable Integer id) {
        instrutorService.excluirInstrutorPorId(id);
    }
}
