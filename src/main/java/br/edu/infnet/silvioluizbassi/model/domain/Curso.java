package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tcurso")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descricao;
    private float valor;
    private int cargaHoraria;
    private String preRequisitos;
    private boolean estagioObrigatorio;
    private boolean ativo = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tcurso_instrutor",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "instrutor_id"))
    private List<Instrutor> instrutores = new ArrayList<>();

    public void alterarPreco(float preco) {
        this.valor = preco;
    }
}
