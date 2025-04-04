package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "taluno")
public class Aluno extends Pessoa {

    private boolean bolsista;
    private boolean enem;

    @Override
    public String toString() {
        return String.format("Aluno{nome='%s', dataNascimento=%s, genero=%s}", getNome(), getDataNascimento(), getGenero());
    }
}

