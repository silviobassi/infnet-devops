package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.Dtos.requests.AlunoRequest;
import br.edu.infnet.silvioluizbassi.Dtos.requests.InstrutorRequest;
import br.edu.infnet.silvioluizbassi.Dtos.responses.InstrutorResponse;
import br.edu.infnet.silvioluizbassi.model.domain.Contato;
import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.domain.Genero;
import br.edu.infnet.silvioluizbassi.model.service.AlunoService;
import br.edu.infnet.silvioluizbassi.model.service.EnderecoService;
import br.edu.infnet.silvioluizbassi.model.service.InstrutorService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Order(2)
public class LoaderPessoas implements ApplicationRunner {

    private final EnderecoService enderecoService;
    private final AlunoService alunoService;
    private final InstrutorService instrutorService;

    public LoaderPessoas(EnderecoService enderecoService, AlunoService alunoService, InstrutorService instrutorService) {
        this.enderecoService = enderecoService;
        this.alunoService = alunoService;
        this.instrutorService = instrutorService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/pessoas.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        Contato contato = null;

        List<Endereco> enderecos = enderecoService.obterEnderecos();
        int countEnderecos = enderecos.size() - 1;

        while (line != null) {
            String[] campos = line.split(";");

            switch (campos[0].toUpperCase()) {
                case "I" -> {
                    InstrutorRequest instrutorRequest = new InstrutorRequest(
                            campos[1],
                            LocalDateTime.parse(campos[2]),
                            Genero.valueOf(campos[3]).name(),
                            contato.getEmail(),
                            contato.getWhatsApp(),
                            enderecos.get(countEnderecos).getCep(),
                            campos[4],
                            campos[5]
                    );
                    instrutorService.incluir(instrutorRequest);

                    countEnderecos--;
                }
                case "A" -> {

                    AlunoRequest alunoRequest = new AlunoRequest(
                            campos[1],
                            LocalDateTime.parse(campos[2]),
                            Genero.valueOf(campos[3]).name(),
                            contato.getEmail(),
                            contato.getWhatsApp(),
                            enderecos.get(countEnderecos).getCep(),
                            Boolean.parseBoolean(campos[4]),
                            Boolean.parseBoolean(campos[5])
                    );
                    alunoService.incluir(alunoRequest);

                    countEnderecos--;
                }
                case "CT" -> {
                    contato = new Contato();
                    contato.setEmail(campos[1]);
                    contato.setWhatsApp(campos[2]);
                }
                default -> throw new Exception("❌ Não há pessoas a serem carregados!");

            }

            line = reader.readLine();
        }

        reader.close();

    }
}