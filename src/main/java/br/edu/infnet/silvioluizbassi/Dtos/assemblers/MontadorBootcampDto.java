package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateBootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.BootcampResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Bootcamp;
import br.edu.infnet.silvioluizbassi.model.domain.NivelBootcamp;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutoresCursoResponse;

public class MontadorBootcampDto {

    public static BootcampResponse toBootcampResponse(Bootcamp bootcamp) {
        return new BootcampResponse(
                bootcamp.getId(),
                bootcamp.getTitulo(),
                bootcamp.getDescricao(),
                bootcamp.getValor(),
                bootcamp.getCargaHoraria(),
                bootcamp.getPreRequisitos(),
                bootcamp.isEstagioObrigatorio(),
                bootcamp.isAtivo(),
                bootcamp.getNivelBootcamp(),
                toInstrutoresCursoResponse(bootcamp.getInstrutores())
        );
    }

    public static Bootcamp toBootcamp(BootcampRequest bootcampRequest) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setTitulo(bootcampRequest.titulo());
        bootcamp.setDescricao(bootcampRequest.descricao());
        bootcamp.setValor(bootcampRequest.valor());
        bootcamp.setCargaHoraria(bootcampRequest.cargaHoraria());
        bootcamp.setPreRequisitos(bootcampRequest.preRequisitos());
        bootcamp.setEstagioObrigatorio(bootcampRequest.estagioObrigatorio());
        bootcamp.setNivelBootcamp(NivelBootcamp.valueOf(bootcampRequest.nivel()));

        return bootcamp;
    }

    public static Bootcamp toBootcamp(BootcampResponse bootcampResponse) {
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setTitulo(bootcampResponse.titulo());
        bootcamp.setDescricao(bootcampResponse.descricao());
        bootcamp.setValor(bootcampResponse.valor());
        bootcamp.setCargaHoraria(bootcampResponse.cargaHoraria());
        bootcamp.setPreRequisitos(bootcampResponse.preRequisitos());
        bootcamp.setEstagioObrigatorio(bootcampResponse.estagioObrigatorio());
        bootcamp.setNivelBootcamp(bootcampResponse.nivel());

        return bootcamp;
    }

    public static void toBootcamp(UpdateBootcampRequest updateBootcampRequest, Bootcamp bootcamp) {
        bootcamp.setTitulo(updateBootcampRequest.titulo());
        bootcamp.setDescricao(updateBootcampRequest.descricao());
        bootcamp.setValor(updateBootcampRequest.valor());
        bootcamp.setCargaHoraria(updateBootcampRequest.cargaHoraria());
        bootcamp.setPreRequisitos(updateBootcampRequest.preRequisitos());
        bootcamp.setEstagioObrigatorio(updateBootcampRequest.estagioObrigatorio());
        bootcamp.setNivelBootcamp(NivelBootcamp.valueOf(updateBootcampRequest.nivel()));
    }

    public static List<BootcampResponse> toBootcampsResponse(List<Bootcamp> bootcamps) {
        return bootcamps.stream().map(MontadorBootcampDto::toBootcampResponse).toList();
    }

}