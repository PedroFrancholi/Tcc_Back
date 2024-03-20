package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Grade")
public class Grade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GRADE")
    private Long id_grade;

    @Column(name = "NM_PROFESSOR",nullable = false)
    private String nm_professor;

    @Column(name = "NR_CARGAHR",nullable = false)
    private Long nr_cargahr;

    @Column(name = "QT_ALUNOS",nullable = false)
    private Long qt_alunos;

    //fk - RECEBE - turma
    //fk - RECEBE - disciplina
}
