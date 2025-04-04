package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorCursoDto;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdatePrecoCursoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoResponse;
import br.edu.infnet.silvioluizbassi.exceptionshandler.CursoNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import br.edu.infnet.silvioluizbassi.model.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorCursoDto.toCursoResponse;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<CursoResponse> obterCursos() {
        return MontadorCursoDto.toCursosResponse(cursoRepository.findAll());
    }

    public Curso obterCursoPorId(Integer id) {
        return cursoRepository.findById(id).orElseThrow(CursoNotFoundException::new);
    }

    public List<CursoResponse> obterCursosPorPrecos(float precoInicial, float precoFinal) {
        return MontadorCursoDto.toCursosResponse(cursoRepository.findCursoByValorBetween(precoInicial, precoFinal));
    }

    public CursoResponse atualizarPreco(UpdatePrecoCursoRequest precoCursoRequest) {
        Curso curso = obterCursoPorId(precoCursoRequest.id());
        curso.alterarPreco(precoCursoRequest.preco());
        return toCursoResponse(cursoRepository.save(curso));
    }
}