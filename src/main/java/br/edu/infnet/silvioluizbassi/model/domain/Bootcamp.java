package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbootcamp")
public class Bootcamp extends Curso {
    @Enumerated(EnumType.STRING)
    private NivelBootcamp nivelBootcamp;

    @Override
    public String toString() {
        return String.format("Bootcamp{titulo='%s', descricao='%s', valor=%.2f, cargaHoraria=%d, nivel='%s'}",
                getTitulo(), getDescricao(), getValor(), getCargaHoraria(), nivelBootcamp);
    }
}
