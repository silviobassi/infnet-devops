package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.BootcampRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.EspecializacaoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequestId;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.model.domain.NivelBootcamp;
import br.edu.infnet.silvioluizbassi.model.domain.TipoEspecializacao;
import br.edu.infnet.silvioluizbassi.model.service.BootcampService;
import br.edu.infnet.silvioluizbassi.model.service.EspecializacaoService;
import br.edu.infnet.silvioluizbassi.model.service.InstrutorService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(3)
public class LoaderCursos implements ApplicationRunner {

    private final InstrutorService instrutorService;
    private final BootcampService bootcampService;
    private final EspecializacaoService especializacaoService;

    public LoaderCursos(InstrutorService instrutorService, BootcampService bootcampService,
                        EspecializacaoService especializacaoService) {
        this.instrutorService = instrutorService;
        this.bootcampService = bootcampService;
        this.especializacaoService = especializacaoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/cursos.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        List<InstrutorResponse> instrutores = instrutorService.obterInstrutores();
        int countInstrutores = instrutores.size() - 1;

        while (line != null) {
            String[] campos = line.split(";");

            final List<InstrutorRequestId> instrutorRequestIds = new ArrayList<>();

            if (!instrutores.get(countInstrutores).id().equals(instrutores.size() - 1)) {
                instrutorRequestIds.add(new InstrutorRequestId(instrutores.get(countInstrutores).id()));
            }

            switch (campos[0].toUpperCase()) {
                case "BC" -> {

                    BootcampRequest bootcampRequest = new BootcampRequest(
                            campos[1],
                            campos[2],
                            Float.parseFloat(campos[3]),
                            Integer.parseInt(campos[4]),
                            campos[5],
                            Boolean.parseBoolean(campos[6]),
                            NivelBootcamp.valueOf(campos[9]).name(),
                            instrutorRequestIds
                    );

                    bootcampService.incluir(bootcampRequest);
                }
                case "EP" -> {

                    EspecializacaoRequest especializacaoRequest = new EspecializacaoRequest(
                            campos[1],
                            campos[2],
                            Float.parseFloat(campos[3]),
                            Integer.parseInt(campos[4]),
                            campos[5],
                            Boolean.parseBoolean(campos[6]),
                            TipoEspecializacao.valueOf(campos[8]).name(),
                            instrutorRequestIds
                    );

                    especializacaoService.incluir(especializacaoRequest);

                }
                default -> throw new Exception("❌ Não há cursos a serem carregados!");

            }

            countInstrutores--;

            line = reader.readLine();
        }

        reader.close();
    }
}