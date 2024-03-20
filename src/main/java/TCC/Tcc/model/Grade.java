package TCC.Tcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Grade")
public class Grade implements Serializable {

    @Column(name = "NM_PROFESSOR",nullable = false)
    private String nm_professor;

    @Column(name = "NR_CARGAHR",nullable = false)
    private Long nr_cargahr;

    @Column(name = "QT_ALUNOS",nullable = false)
    private Long qt_alunos;

    //fk - RECEBE - turma
    //fk - RECEBE - disciplina
}
