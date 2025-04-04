package br.edu.infnet.silvioluizbassi.validation;

import br.edu.infnet.silvioluizbassi.model.domain.Genero;
import br.edu.infnet.silvioluizbassi.model.domain.NivelBootcamp;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class NivelBootcampValidoValidator implements ConstraintValidator<NivelBootcampValido, String> {
    @Override
    public void initialize(NivelBootcampValido constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String bootcamp, ConstraintValidatorContext context) {
        return Arrays.stream(NivelBootcamp.values())
                .anyMatch(g -> g.name().equals(bootcamp));

    }
}
