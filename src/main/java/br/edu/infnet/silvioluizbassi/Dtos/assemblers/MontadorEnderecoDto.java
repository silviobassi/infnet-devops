package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.responses.EnderecoResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;

public class MontadorEnderecoDto {
    public static EnderecoResponse toEnderecoResponse(Endereco endereco) {
        return new EnderecoResponse(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getLocalidade(),
                endereco.getEstado(),
                endereco.getCep()
        );
    }

    public static Endereco toEndereco(EnderecoResponse enderecoResponse) {
        Endereco endereco = new Endereco();
        endereco.setId(enderecoResponse.id());
        endereco.setLogradouro(enderecoResponse.logradouro());
        endereco.setNumero(enderecoResponse.numero());
        endereco.setComplemento(enderecoResponse.complemento());
        endereco.setBairro(enderecoResponse.bairro());
        endereco.setLocalidade(enderecoResponse.localidade());
        endereco.setEstado(enderecoResponse.estado());
        endereco.setCep(enderecoResponse.cep());
        return endereco;
    }
}