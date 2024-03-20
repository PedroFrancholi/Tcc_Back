package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Disciplina")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCIPLINA")
    private Long id_disciplina;

    @Column(name = "NM_DISCIPLINA")
    private String nm_disciplina;

    //fk - FORNECE - grade
}
