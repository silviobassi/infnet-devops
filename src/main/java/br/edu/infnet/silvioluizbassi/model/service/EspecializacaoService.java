package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateEspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import br.edu.infnet.silvioluizbassi.exceptionshandler.CursoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Especializacao;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.repository.EspecializacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorEspecializacaoDto.*;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutor;

@Service
public class EspecializacaoService {

    private final EspecializacaoRepository especializacaoRepository;
    private final InstrutorService instrutorService;

    public EspecializacaoService(EspecializacaoRepository especializacaoRepository, InstrutorService instrutorService) {
        this.especializacaoRepository = especializacaoRepository;
        this.instrutorService = instrutorService;
    }

    public EspecializacaoResponse incluir(EspecializacaoRequest especializacaoRequest) {
        Especializacao especializacao = toEspecializacao(especializacaoRequest);

        especializacaoRequest.instrutores().forEach(instrutorRequest -> {
            Instrutor instrutorAtual = toInstrutor(instrutorService.obterInstrutorPorId(instrutorRequest.id()));
            especializacao.getInstrutores().add(instrutorAtual);
        });

        return toEspecializacaoResponse(especializacaoRepository.save(especializacao));
    }

    public EspecializacaoResponse atualizar(UpdateEspecializacaoRequest updateEspecializacaoRequest) {

        Especializacao especializacao = getEspecializacaoPorId(updateEspecializacaoRequest.id());

        if (!updateEspecializacaoRequest.instrutores().isEmpty()) especializacao.getInstrutores().clear();

        updateEspecializacaoRequest.instrutores().forEach(instrutorRequest -> {
            Instrutor instrutorAtual = toInstrutor(instrutorService.obterInstrutorPorId(instrutorRequest.id()));
            especializacao.getInstrutores().add(instrutorAtual);
        });

        toEspecializacao(updateEspecializacaoRequest, especializacao);

        return toEspecializacaoResponse(especializacaoRepository.save(especializacao));
    }

    public List<EspecializacaoResponse> obterEspecializacoes() {
        return toEspecializacoesResponse(especializacaoRepository.findAll());
    }

    public long countBootcamps() {
        return especializacaoRepository.count();
    }

    public EspecializacaoResponse obterEspecializacaoPorId(Integer id) {
        return toEspecializacaoResponse(getEspecializacaoPorId(id));
    }


    public void excluir(Integer id) {
        getEspecializacaoPorId(id);
        especializacaoRepository.deleteById(id);
    }

    private Especializacao getEspecializacaoPorId(Integer id) {
        return especializacaoRepository.findById(id).orElseThrow(CursoNotFoundException::new);
    }
}