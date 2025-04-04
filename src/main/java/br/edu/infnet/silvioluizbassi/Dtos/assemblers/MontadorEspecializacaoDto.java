package br.edu.infnet.silvioluizbassi.Dtos.assemblers;

import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateEspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.EspecializacaoResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Especializacao;
import br.edu.infnet.silvioluizbassi.model.domain.TipoEspecializacao;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorInstrutorDto.toInstrutoresCursoResponse;

public class MontadorEspecializacaoDto {

    public static EspecializacaoResponse toEspecializacaoResponse(Especializacao especializacao) {
        return new EspecializacaoResponse(
                especializacao.getId(),
                especializacao.getTitulo(),
                especializacao.getDescricao(),
                especializacao.getValor(),
                especializacao.getCargaHoraria(),
                especializacao.getPreRequisitos(),
                especializacao.isEstagioObrigatorio(),
                especializacao.isAtivo(),
                especializacao.getTipoDeEspecializacao(),
                toInstrutoresCursoResponse(especializacao.getInstrutores())
        );
    }

    public static Especializacao toEspecializacao(EspecializacaoRequest especializacaoRequest) {
        Especializacao especializacao = new Especializacao();
        especializacao.setTitulo(especializacaoRequest.titulo());
        especializacao.setDescricao(especializacaoRequest.descricao());
        especializacao.setValor(especializacaoRequest.valor());
        especializacao.setCargaHoraria(especializacaoRequest.cargaHoraria());
        especializacao.setPreRequisitos(especializacaoRequest.preRequisitos());
        especializacao.setEstagioObrigatorio(especializacaoRequest.estagioObrigatorio());
        especializacao.setTipoDeEspecializacao(TipoEspecializacao.valueOf(especializacaoRequest.tipoDeEspecializacao()));

        return especializacao;
    }

    public static void toEspecializacao(UpdateEspecializacaoRequest updateEspecializacaoRequest, Especializacao especializacao) {

        especializacao.setTitulo(updateEspecializacaoRequest.titulo());
        especializacao.setDescricao(updateEspecializacaoRequest.descricao());
        especializacao.setValor(updateEspecializacaoRequest.valor());
        especializacao.setCargaHoraria(updateEspecializacaoRequest.cargaHoraria());
        especializacao.setPreRequisitos(updateEspecializacaoRequest.preRequisitos());
        especializacao.setEstagioObrigatorio(updateEspecializacaoRequest.estagioObrigatorio());
        especializacao.setTipoDeEspecializacao(
                TipoEspecializacao.valueOf(updateEspecializacaoRequest.tipoDeEspecializacao()));

    }

    public static Especializacao toEspecializacao(EspecializacaoResponse especializacaoResponse) {
        Especializacao especializacao = new Especializacao();
        especializacao.setTitulo(especializacaoResponse.titulo());
        especializacao.setDescricao(especializacaoResponse.descricao());
        especializacao.setValor(especializacaoResponse.valor());
        especializacao.setCargaHoraria(especializacaoResponse.cargaHoraria());
        especializacao.setPreRequisitos(especializacaoResponse.preRequisitos());
        especializacao.setEstagioObrigatorio(especializacaoResponse.estagioObrigatorio());
        especializacao.setTipoDeEspecializacao(especializacaoResponse.tipoDeEspecializacao());

        return especializacao;
    }

    public static List<EspecializacaoResponse> toEspecializacoesResponse(List<Especializacao> especializacoes) {
        return especializacoes.stream().map(MontadorEspecializacaoDto::toEspecializacaoResponse).toList();
    }

}