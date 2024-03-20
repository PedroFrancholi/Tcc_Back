package TCC.Tcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "MaterialSala")
public class MaterialSala implements Serializable {

    @Column(name = "QT_MATERIAL",nullable = false)
    private Double qt_material;

    @Column(name = "DS_MATERIALSALA")
    private String ds_materialSala;

    //fk - RECEBE - material
    //fk - FORNECE/RECEBE - sala
}
