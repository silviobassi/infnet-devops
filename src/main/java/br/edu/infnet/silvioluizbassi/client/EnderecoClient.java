package br.edu.infnet.silvioluizbassi.client;

import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "enderecoClient", url = "https://viacep.com.br/ws")
public interface EnderecoClient {

    @GetMapping(value = "/{cep}/json")
    Endereco findByCep(@PathVariable String cep);
}
