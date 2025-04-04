package br.edu.infnet.silvioluizbassi.validation;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class GeneroValidoValidator implements ConstraintValidator<GeneroValido, String> {
    @Override
    public void initialize(GeneroValido constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String genero, ConstraintValidatorContext context) {
        return Arrays.stream(Genero.values())
                .anyMatch(g -> g.name().equals(genero));

    }
}
