package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "MaterialSala")
public class MaterialSala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIALSALA")
    private Long id_materialsala;

    @Column(name = "QT_MATERIAL",nullable = false)
    private Double qt_material;

    @Column(name = "DS_MATERIALSALA")
    private String ds_materialSala;

    //fk - RECEBE - material
    //fk - FORNECE/RECEBE - sala
}
