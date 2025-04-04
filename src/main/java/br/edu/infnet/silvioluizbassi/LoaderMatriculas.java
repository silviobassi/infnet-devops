package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequestId;
import br.edu.infnet.silvioluizbassi.Dtos.requests.CursoRequestId;
import br.edu.infnet.silvioluizbassi.Dtos.requests.MatriculaRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.AlunoResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.CursoResponse;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.model.service.AlunoService;
import br.edu.infnet.silvioluizbassi.model.service.CursoService;
import br.edu.infnet.silvioluizbassi.model.service.MatriculaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

@Component
@Order(4)
public class LoaderMatriculas implements ApplicationRunner {

    private final AlunoService alunoService;
    private final MatriculaService matriculaService;
    private final CursoService cursoService;

    public LoaderMatriculas(AlunoService alunoService, MatriculaService matriculaService, CursoService cursoService) {
        this.alunoService = alunoService;
        this.matriculaService = matriculaService;
        this.cursoService = cursoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/matriculas.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        List<AlunoResponse> alunos = alunoService.obterAlunos();
        List<CursoResponse> cursos = cursoService.obterCursos();

        int countAlunos = alunos.size() - 1;
        int countCursos = cursos.size() - 1;

        while (line != null) {
            String[] campos = line.split(";");

            if (!campos[0].equalsIgnoreCase("M")) throw new Exception("❌ Não há matrículas a serem carregadas!");

            MatriculaRequest matriculaRequest = new MatriculaRequest(
                    Long.parseLong(campos[1]),
                    new AlunoRequestId(alunos.get(countAlunos).id()),
                    new CursoRequestId(cursos.get(countCursos).id()));

            countAlunos--;
            countCursos--;

            matriculaService.incluir(matriculaRequest);
            line = reader.readLine();

        }
        reader.close();
    }
}