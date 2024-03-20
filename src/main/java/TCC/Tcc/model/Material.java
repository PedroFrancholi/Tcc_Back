package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Material")
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIAL", nullable = false)
    private Long id_material;

    @Column(name = "DS_MATERIAL", nullable = false)
    private String ds_material;

    //fk - FORNECE - materialSala
}
