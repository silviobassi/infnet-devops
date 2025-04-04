package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateAlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoMatriculaResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Contato;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.domain.Genero;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorEnderecoDto.toEndereco;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorEnderecoDto.toEnderecoResponse;

public class MontadorAlunoDto {

    public static AlunoMatriculaResponse toAlunoMatriculaResponse(Aluno aluno) {
        return new AlunoMatriculaResponse(aluno.getId(), aluno.getNome(), aluno.isBolsista(), aluno.isEnem());
    }

    public static AlunoResponse toAlunoResponse(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getGenero(),
                aluno.getContato().getEmail(),
                aluno.getContato().getWhatsApp(),
                toEnderecoResponse(aluno.getEndereco()),
                aluno.isBolsista(),
                aluno.isEnem()
        );
    }

    public static List<AlunoResponse> toAlunosResponse(List<Aluno> alunos) {
        return alunos.stream().map(MontadorAlunoDto::toAlunoResponse).toList();
    }

    public static Aluno toAluno(AlunoResponse alunoResponse) {

        Contato contato = new Contato();
        contato.setEmail(alunoResponse.email());
        contato.setWhatsApp(alunoResponse.whatsApp());

        Aluno aluno = new Aluno();
        aluno.setId(alunoResponse.id());
        aluno.setNome(alunoResponse.nome());
        aluno.setDataNascimento(alunoResponse.dataNascimento());
        aluno.setGenero(alunoResponse.genero());
        aluno.setContato(contato);
        aluno.setEndereco(toEndereco(alunoResponse.endereco()));
        aluno.setBolsista(alunoResponse.isBolsista());
        aluno.setEnem(alunoResponse.isEnem());
        return aluno;
    }

    public static Aluno toAluno(AlunoRequest alunoRequest) {

        Contato contato = new Contato();
        contato.setEmail(alunoRequest.email());
        contato.setWhatsApp(alunoRequest.whatsApp());

        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequest.nome());
        aluno.setDataNascimento(alunoRequest.dataNascimento());
        aluno.setGenero(Genero.valueOf(alunoRequest.genero()));
        aluno.setContato(contato);
        aluno.setBolsista(alunoRequest.isBolsista());
        aluno.setEnem(alunoRequest.isEnem());
        return aluno;
    }

    public static void toAluno(UpdateAlunoRequest updateAlunoRequest, Aluno aluno, Endereco endereco) {

        Contato contato = new Contato();
        contato.setEmail(updateAlunoRequest.email());
        contato.setWhatsApp(updateAlunoRequest.whatsApp());

        aluno.setNome(updateAlunoRequest.nome());
        aluno.setDataNascimento(updateAlunoRequest.dataNascimento());
        aluno.setGenero(Genero.valueOf(updateAlunoRequest.genero()));
        aluno.setContato(contato);
        aluno.setBolsista(updateAlunoRequest.isBolsista());
        aluno.setEnem(updateAlunoRequest.isEnem());
        aluno.setEndereco(endereco);
    }

}