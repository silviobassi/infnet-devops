package br.edu.infnet.silvioluizbassi.exceptionshandler;

import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Map<String, String> fieldErrorsMap = fieldErrors.stream()
                .collect(Collectors.toMap(FieldError::getField,
                        error -> error.getDefaultMessage() != null ? error.getDefaultMessage() : "Field error"));

        return new CustomProblemDetail("Bad Request Exception - Invalid Fields",
                "Verifique os campos em (errors)", e.getStatusCode().value(), fieldErrorsMap);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelException(ModelNotFoundException e) {
        return new CustomProblemDetail(e.getTitle(), e.getMessage(), e.getStatusCode().value());
    }
}