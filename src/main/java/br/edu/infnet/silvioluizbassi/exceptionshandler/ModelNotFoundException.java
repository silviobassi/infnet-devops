package br.edu.infnet.silvioluizbassi.exceptionshandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ModelNotFoundException extends RuntimeException {

    private final String title;
    private final HttpStatus statusCode;

    public ModelNotFoundException(String message) {
        super(message);
        this.title = "Not Found";
        this.statusCode = HttpStatus.NOT_FOUND;
    }
}