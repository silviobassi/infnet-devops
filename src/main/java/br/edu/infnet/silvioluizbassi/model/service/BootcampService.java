package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateBootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import br.edu.infnet.silvioluizbassi.exceptionshandler.CursoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Bootcamp;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.repository.BootcampRepository;
import br.edu.infnet.silvioluizbassi.model.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorBootcampDto.*;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutor;

@Service
public class BootcampService {

    private final CursoRepository cursoRepository;
    private final BootcampRepository bootcampRepository;
    private final InstrutorService instrutorService;

    public BootcampService(CursoRepository cursoRepository, BootcampRepository bootcampRepository, InstrutorService instrutorService) {
        this.cursoRepository = cursoRepository;
        this.bootcampRepository = bootcampRepository;
        this.instrutorService = instrutorService;
    }

    public BootcampResponse incluir(BootcampRequest bootcampRequest) {
        Bootcamp bootcamp = toBootcamp(bootcampRequest);

        bootcampRequest.instrutores().forEach(instrutorRequest -> {
            Instrutor instrutorAtual = toInstrutor(instrutorService.obterInstrutorPorId(instrutorRequest.id()));
            bootcamp.getInstrutores().add(instrutorAtual);
        });

        return toBootcampResponse(cursoRepository.save(bootcamp));
    }

    public BootcampResponse atualizar(UpdateBootcampRequest updateBootcampRequest) {

        Bootcamp bootcamp = bootcampRepository.findById(updateBootcampRequest.id())
                .orElseThrow(CursoNotFoundException::new);

        if (!updateBootcampRequest.instrutores().isEmpty()) bootcamp.getInstrutores().clear();

        updateBootcampRequest.instrutores().forEach(instrutorRequest -> {
            Instrutor instrutorAtual = toInstrutor(instrutorService.obterInstrutorPorId(instrutorRequest.id()));
            bootcamp.getInstrutores().add(instrutorAtual);
        });

        toBootcamp(updateBootcampRequest, bootcamp);

        return toBootcampResponse(cursoRepository.save(bootcamp));
    }

    public List<BootcampResponse> obterBootcamps() {
        return toBootcampsResponse(bootcampRepository.findAll());
    }

    public long countBootcamps() {
        return bootcampRepository.count();
    }

    public BootcampResponse obterBootcampPorId(Integer id) {
        return toBootcampResponse(getBootcampPorId(id));
    }

    public void excluir(Integer id) {
        getBootcampPorId(id);
        bootcampRepository.deleteById(id);
    }

    private Bootcamp getBootcampPorId(Integer id) {
        return bootcampRepository.findById(id).orElseThrow(CursoNotFoundException::new);
    }

}