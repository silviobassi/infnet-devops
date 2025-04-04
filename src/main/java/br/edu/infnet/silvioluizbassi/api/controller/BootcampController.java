package br.edu.infnet.silvioluizbassi.api.controller;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateBootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import br.edu.infnet.silvioluizbassi.api.openapi.BootcampControllerDocApi;
import br.edu.infnet.silvioluizbassi.model.service.BootcampService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bootcamps")
public class BootcampController implements BootcampControllerDocApi {

    private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/listar")
    public List<BootcampResponse> listarBootcamps() {
        return bootcampService.obterBootcamps();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/criar")
    public BootcampResponse incluirBootcamp(@RequestBody @Valid BootcampRequest bootcampRequest) {
        return bootcampService.incluir(bootcampRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/atualizar")
    public BootcampResponse atualizarBootcamp(@RequestBody @Valid UpdateBootcampRequest updateBootcampRequest) {
        return bootcampService.atualizar(updateBootcampRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/buscar")
    public BootcampResponse obterBootcampPorId(@PathVariable Integer id) {
        return bootcampService.obterBootcampPorId(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/excluir")
    public void excluirBootcampPorId(@PathVariable Integer id) {
        bootcampService.excluir(id);
    }
}
