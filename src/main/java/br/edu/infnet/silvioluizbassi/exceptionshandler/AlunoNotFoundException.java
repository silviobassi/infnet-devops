package br.edu.infnet.silvioluizbassi.exceptionshandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends ModelNotFoundException {

    public AlunoNotFoundException() {
        super("Aluno não encontrado");
    }

    public AlunoNotFoundException(Integer id) {
        super("Aluno com %d não encontrado".formatted(id));
    }

}