package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Turma")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TURMA", nullable = false)
    private Long id_turma;

    @Column(name = "DS_TURMA")
    private String ds_turma;

    //fk - RECEBE - curso
    //fk - FORNECE - grade
}
