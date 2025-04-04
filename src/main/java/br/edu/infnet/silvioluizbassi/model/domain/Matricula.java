package br.edu.infnet.silvioluizbassi.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tmatricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private long numeroDaMatricula;

    @CreationTimestamp
    private LocalDateTime dataMatricula;
    private boolean ativa = true;

    @ManyToOne(optional = false)
    private Curso curso;

    @ManyToOne(optional = false)
    private Aluno aluno;

    @Override
    public String toString() {
        return String.format(
                "Matricula{numeroDaMatricula=%d, dataDaCompra=%s, ativa=%b, curso=%s, aluno=%s}",
                numeroDaMatricula, dataMatricula, ativa, curso, aluno
        );
    }

}
