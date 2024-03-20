package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURSO", nullable = false)
    private Long id_curso;

    @Column(name = "DS_CURSO", nullable = false)
    private String ds_curso;

    //fk - FORNECE - turma
}
