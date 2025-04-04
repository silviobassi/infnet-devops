package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateInstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.exceptionshandler.InstrutorNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;
import br.edu.infnet.silvioluizbassi.model.repository.InstrutorRepository;
import br.edu.infnet.silvioluizbassi.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.*;

@Service
public class InstrutorService {

    private final PessoaRepository pessoaRepository;
    private final InstrutorRepository instrutorRepository;
    private final LocalizacaoService localizacaoService;
    private final EnderecoService enderecoService;

    public InstrutorService(PessoaRepository pessoaRepository, InstrutorRepository instrutorRepository,
                            LocalizacaoService localizacaoService, EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.instrutorRepository = instrutorRepository;
        this.localizacaoService = localizacaoService;
        this.enderecoService = enderecoService;

    }

    public InstrutorResponse incluir(InstrutorRequest instrutorRequest) {
        Endereco endereco = localizacaoService.findByCep(instrutorRequest.cep());
        endereco = enderecoService.incluir(endereco);

        Instrutor instrutor = toInstrutor(instrutorRequest);

        instrutor.setEndereco(endereco);
        return toInstrutorResponse(pessoaRepository.save(instrutor));
    }

    public InstrutorResponse atualizar(UpdateInstrutorRequest updateInstrutorRequest) {
        Instrutor instrutor = getInstrutorPorId(updateInstrutorRequest.id());
        Endereco endereco = localizacaoService.findByCep(updateInstrutorRequest.cep());
        toInstrutor(updateInstrutorRequest, instrutor, endereco);
        return toInstrutorResponse(pessoaRepository.save(instrutor));
    }

    public List<InstrutorResponse> obterInstrutores() {
        return toInstrutoresResponse(instrutorRepository.findAll());
    }

    public long countInstrutores() {
        return instrutorRepository.count();
    }

    public InstrutorResponse obterInstrutorPorId(Integer id) {
        return toInstrutorResponse(getInstrutorPorId(id));
    }

    public void excluirInstrutorPorId(Integer id) {
        getInstrutorPorId(id);
        instrutorRepository.deleteById(id);
    }

    private Instrutor getInstrutorPorId(Integer id) {
        return instrutorRepository.findById(id).orElseThrow(InstrutorNotFoundException::new);
    }
}