package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Disciplina")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCIPLINA")
    private Long id_disciplina;

    @Column(name = "NM_DISCIPLINA")
    private String nm_disciplina;

    @OneToMany(mappedBy = "disciplina")
    @JsonIgnore
    private List<Grade> grades;

    public Disciplina() {
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNm_disciplina() {
        return nm_disciplina;
    }

    public void setNm_disciplina(String nm_disciplina) {
        this.nm_disciplina = nm_disciplina;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
