package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tendereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String estado;
    private String cep;

    @Override
    public String toString() {
        return String.format("Endereco{cep='%s'}", cep);
    }
}
