package br.edu.infnet.silvioluizbassi;

import br.edu.infnet.silvioluizbassi.model.domain.Endereco;
import br.edu.infnet.silvioluizbassi.model.service.EnderecoService;
import br.edu.infnet.silvioluizbassi.model.service.LocalizacaoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
@Order(1)
public class LoaderEnderecos implements ApplicationRunner {

    private final EnderecoService enderecoService;
    private final LocalizacaoService localizacaoService;

    public LoaderEnderecos(EnderecoService enderecoService, LocalizacaoService localizacaoService) {
        this.enderecoService = enderecoService;
        this.localizacaoService = localizacaoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/enderecos.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        while (line != null) {
            String[] campos = line.split(";");

            if (!campos[0].equalsIgnoreCase("E")) throw new Exception("❌ Não há endereços a serem carregados!");

            Endereco endereco = localizacaoService.findByCep(campos[7]);
            enderecoService.incluir(endereco);

            line = reader.readLine();
        }

        reader.close();
    }
}