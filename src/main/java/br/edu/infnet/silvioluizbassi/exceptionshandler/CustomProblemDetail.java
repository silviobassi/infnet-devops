package br.edu.infnet.silvioluizbassi.exceptionshandler;

import lombok.Getter;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class CustomProblemDetail extends ProblemDetail {

    public CustomProblemDetail(String title, String detail, int statusCode, Map<String, String> fieldErrorsMap) {
        super(statusCode);
        setTitle(title);
        setDetail(detail);
        setType(URI.create("https://infnet.com/%s".formatted(formatErrorType(title))));
        setProperty("timestamp", LocalDateTime.now());
        setProperty("errors", fieldErrorsMap);
    }

    public CustomProblemDetail(String title, String detail, int statusCode) {
        super(statusCode);
        setTitle(title);
        setDetail(detail);
        setType(URI.create("https://infnet.com/%s".formatted(formatErrorType(title))));
        setProperty("timestamp", LocalDateTime.now());
    }

    private String formatErrorType(String className) {
        return className
                .toLowerCase()
                .replaceAll(" ", "-")
                .replaceAll("-+", "-")
                .trim();
    }
}