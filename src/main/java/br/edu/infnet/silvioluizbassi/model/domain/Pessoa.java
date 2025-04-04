package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tpessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private LocalDateTime dataNascimento;
    private Genero genero;

    @Embedded
    private Contato contato;

    @OneToOne(optional = false, orphanRemoval = true, fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Endereco endereco;

}
