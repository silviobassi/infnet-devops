package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tespecializacao")
public class Especializacao extends Curso {
    private TipoEspecializacao tipoDeEspecializacao;

    @Override
    public String toString() {
        return String.format("Especializacao{titulo='%s', descricao='%s', valor=%.2f, cargaHoraria=%d, nivelDeEspecializacao='%s'}",
                getTitulo(), getDescricao(), getValor(), getCargaHoraria(), tipoDeEspecializacao);
    }
}
