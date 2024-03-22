package TCC.Tcc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURSO", nullable = false)
    private Long id_curso;

    @Column(name = "DS_CURSO", nullable = false)
    private String ds_curso;

    @OneToMany(mappedBy = "curso")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Turma> turmas;

    public Curso() {
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getDs_curso() {
        return ds_curso;
    }

    public void setDs_curso(String ds_curso) {
        this.ds_curso = ds_curso;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
