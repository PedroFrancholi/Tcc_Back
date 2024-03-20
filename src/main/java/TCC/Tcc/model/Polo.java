package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Polo")
public class Polo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_POLO", nullable = false)
    private Long id_polo;

    @Column(name = "DS_POLO")
    private String ds_polo;

    //fk - RECEBE - municipio
    //fk - RECEBE - instituicao
}
