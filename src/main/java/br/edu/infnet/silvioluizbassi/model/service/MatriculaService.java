package br.edu.infnet.silvioluizbassi.model.service;

import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.UpdateMatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.MatriculaResponse;
import br.edu.infnet.silvioluizbassi.exceptionshandler.MatriculaNotFoundException;
import br.edu.infnet.silvioluizbassi.model.domain.Aluno;
import br.edu.infnet.silvioluizbassi.model.domain.Curso;
import br.edu.infnet.silvioluizbassi.model.domain.Matricula;
import br.edu.infnet.silvioluizbassi.model.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaDto.toMatriculaResponse;
import static br.edu.infnet.silvioluizbassi.Dtos.assemblers.MontadorMatriculaDto.toMatriculasResponse;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoService alunoService;
    private final CursoService cursoService;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoService alunoService, CursoService cursoService) {
        this.matriculaRepository = matriculaRepository;
        this.alunoService = alunoService;
        this.cursoService = cursoService;
    }

    public MatriculaResponse incluir(MatriculaRequest matriculaRequest) {
        Curso curso = cursoService.obterCursoPorId(matriculaRequest.curso().id());
        Aluno aluno = alunoService.getAlunoPorId(matriculaRequest.aluno().id());
        Matricula matricula = new Matricula();
        matricula.setNumeroDaMatricula(matriculaRequest.numeroDaMatricula());
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        return toMatriculaResponse(matriculaRepository.save(matricula));
    }

    public MatriculaResponse atualizar(UpdateMatriculaRequest updateMatriculaRequest) {
        Curso curso = cursoService.obterCursoPorId(updateMatriculaRequest.curso().id());
        Aluno aluno = alunoService.getAlunoPorId(updateMatriculaRequest.aluno().id());

        Matricula matricula = getMatriculaPorId(updateMatriculaRequest.id());

        matricula.setNumeroDaMatricula(updateMatriculaRequest.numeroDaMatricula());
        matricula.setCurso(curso);
        matricula.setAluno(aluno);

        return toMatriculaResponse(matriculaRepository.save(matricula));
    }

    public List<MatriculaResponse> obterMatriculas() {
        return toMatriculasResponse(matriculaRepository.findAll());
    }

    public long countMatriculas() {
        return matriculaRepository.count();
    }

    public MatriculaResponse obterMatriculaPorId(Integer id) {
        return toMatriculaResponse(getMatriculaPorId(id));
    }

    public void excluir(Integer id) {
        getMatriculaPorId(id);
        matriculaRepository.deleteById(id);
    }

    private Matricula getMatriculaPorId(Integer id) {
        return matriculaRepository.findById(id).orElseThrow(MatriculaNotFoundException::new);
    }
}