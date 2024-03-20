package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Municipio")
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUNICIPIO", nullable = false)
    private Long id_municipio;

    @Column(name = "NM_MUNICIPIO", nullable = false)
    private String nm_municipio;

    //fk - FORNECE - polo
    //fk - RECEBE - estado
}
