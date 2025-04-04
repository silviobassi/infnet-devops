package br.edu.infnet.silvioluizbassi.validation;

import br.edu.infnet.silvioluizbassi.model.domain.TipoEspecializacao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class TipoEspecializacaoValidoValidator implements ConstraintValidator<TipoEspecializacaoValido, String> {
    @Override
    public void initialize(TipoEspecializacaoValido constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String tipoEspecializacao, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(TipoEspecializacao.values())
                .anyMatch(g -> g.name().equals(tipoEspecializacao));
    }
}
