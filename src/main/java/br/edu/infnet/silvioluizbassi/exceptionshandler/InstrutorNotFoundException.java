package br.edu.infnet.silvioluizbassi.exceptionshandler;

import org.springframework.http.HttpStatus;

public class InstrutorNotFoundException extends ModelNotFoundException {
    public InstrutorNotFoundException() {
        super("Instrutor não encontrado");
    }

    public InstrutorNotFoundException(Integer id) {
        super("Instrutor com o id %d não encontrado".formatted(id));
    }
}