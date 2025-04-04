package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tinstrutor")
public class Instrutor extends Pessoa {
    private String formacao;
    private String especialidade;

    @Override
    public String toString() {
        return String.format("Instrutor{nome='%s', dataNascimento=%s, genero=%s, formacao=%s, especialidade=%s}",
                getNome(), getDataNascimento(), getGenero(), formacao, especialidade);
    }
}
