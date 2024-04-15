package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id_turma")
    private Turma turma;

    public Grade() {
    }

    public Long getId_grade() {
        return id_grade;
    }

    public void setId_grade(Long id_grade) {
        this.id_grade = id_grade;
    }

    public String getNm_professor() {
        return nm_professor;
    }

    public void setNm_professor(String nm_professor) {
        this.nm_professor = nm_professor;
    }

    public Long getNr_cargahr() {
        return nr_cargahr;
    }

    public void setNr_cargahr(Long nr_cargahr) {
        this.nr_cargahr = nr_cargahr;
    }

    public Long getQt_alunos() {
        return qt_alunos;
    }

    public void setQt_alunos(Long qt_alunos) {
        this.qt_alunos = qt_alunos;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
