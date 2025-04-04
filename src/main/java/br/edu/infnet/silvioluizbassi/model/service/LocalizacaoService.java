package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.client.EnderecoClient;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    private final EnderecoClient enderecoClient;

    public LocalizacaoService(EnderecoClient enderecoClient) {
        this.enderecoClient = enderecoClient;
    }

    public Endereco findByCep(String cep) {
        return enderecoClient.findByCep(cep);
    }
}
