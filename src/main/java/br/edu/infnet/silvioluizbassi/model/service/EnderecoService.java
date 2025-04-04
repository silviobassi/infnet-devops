package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco incluir(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterEnderecos() {
        return enderecoRepository.findAll();
    }
}