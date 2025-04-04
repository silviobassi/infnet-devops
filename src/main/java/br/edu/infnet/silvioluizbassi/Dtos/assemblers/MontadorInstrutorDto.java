package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateInstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorCursoResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorMatriculaResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Contato;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.domain.Genero;
import br.edu.infnet.silvioluizbassi.model.domain.Instrutor;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorEnderecoDto.toEndereco;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorEnderecoDto.toEnderecoResponse;

public class MontadorInstrutorDto {

    public static InstrutorMatriculaResponse toInstrutorMatriculaResponse(Instrutor instrutor) {
        return new InstrutorMatriculaResponse(instrutor.getId(), instrutor.getNome());
    }

    public static List<InstrutorMatriculaResponse> toInstrutoresMatriculaResponse(List<Instrutor> instrutores) {
        return instrutores.stream()
                .map(instrutor -> new InstrutorMatriculaResponse(
                        instrutor.getId(),
                        instrutor.getNome()
                ))
                .toList();
    }

    public static InstrutorCursoResponse toInstrutorCursoResponse(Instrutor instrutor) {
        return new InstrutorCursoResponse(instrutor.getId(), instrutor.getNome());
    }

    public static List<InstrutorCursoResponse> toInstrutoresCursoResponse(List<Instrutor> instrutores) {
        return instrutores.stream()
                .map(MontadorInstrutorDto::toInstrutorCursoResponse)
                .toList();
    }

    public static InstrutorResponse toInstrutorResponse(Instrutor instrutor) {
        return new InstrutorResponse(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getDataNascimento(),
                instrutor.getGenero(),
                instrutor.getContato().getEmail(),
                instrutor.getContato().getWhatsApp(),
                toEnderecoResponse(instrutor.getEndereco()),
                instrutor.getFormacao(),
                instrutor.getEspecialidade()
        );
    }

    public static List<InstrutorResponse> toInstrutoresResponse(List<Instrutor> instrutores) {
        return instrutores.stream()
                .map(MontadorInstrutorDto::toInstrutorResponse)
                .toList();
    }

    public static Instrutor toInstrutor(InstrutorResponse instrutorResponse) {
        Contato contato = new Contato();
        contato.setEmail(instrutorResponse.email());
        contato.setWhatsApp(instrutorResponse.whatsApp());

        Instrutor instrutor = new Instrutor();
        instrutor.setId(instrutorResponse.id());
        instrutor.setNome(instrutorResponse.nome());
        instrutor.setDataNascimento(instrutorResponse.dataNascimento());
        instrutor.setGenero(instrutorResponse.genero());
        instrutor.setContato(contato);
        instrutor.setEndereco(toEndereco(instrutorResponse.endereco()));
        instrutor.setFormacao(instrutorResponse.formacao());
        instrutor.setEspecialidade(instrutorResponse.especialidade());

        return instrutor;
    }

    public static Instrutor toInstrutor(InstrutorRequest instrutorRequest) {
        Contato contato = new Contato();
        contato.setEmail(instrutorRequest.email());
        contato.setWhatsApp(instrutorRequest.whatsApp());

        Instrutor instrutor = new Instrutor();
        instrutor.setNome(instrutorRequest.nome());
        instrutor.setDataNascimento(instrutorRequest.dataNascimento());
        instrutor.setGenero(Genero.valueOf(instrutorRequest.genero()));
        instrutor.setContato(contato);
        instrutor.setFormacao(instrutorRequest.formacao());
        instrutor.setEspecialidade(instrutorRequest.especialidade());

        return instrutor;
    }

    public static void toInstrutor(UpdateInstrutorRequest updateInstrutorRequest, Instrutor instrutor, Endereco endereco) {
        Contato contato = new Contato();
        contato.setEmail(updateInstrutorRequest.email());
        contato.setWhatsApp(updateInstrutorRequest.whatsApp());

        instrutor.setNome(updateInstrutorRequest.nome());
        instrutor.setDataNascimento(updateInstrutorRequest.dataNascimento());
        instrutor.setGenero(Genero.valueOf(updateInstrutorRequest.genero()));
        instrutor.setContato(contato);
        instrutor.setFormacao(updateInstrutorRequest.formacao());
        instrutor.setEspecialidade(updateInstrutorRequest.especialidade());

        instrutor.setEndereco(endereco);

    }
}