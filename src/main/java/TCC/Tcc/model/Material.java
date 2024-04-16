package TCC.Tcc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Material")
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIAL", nullable = false)
    private Long id_material;

    @Column(name = "DS_MATERIAL", nullable = false)
    private String ds_material;

    @ManyToMany
    private Set<MaterialSala> materialSalas;

    public Material() {
    }

    public Long getId_material() {
        return id_material;
    }

    public void setId_material(Long id_material) {
        this.id_material = id_material;
    }

    public String getDs_material() {
        return ds_material;
    }

    public void setDs_material(String ds_material) {
        this.ds_material = ds_material;
    }

    public Set<MaterialSala> getMaterialSalas() {
        return materialSalas;
    }

    public void setMaterialSalas(Set<MaterialSala> materialSalas) {
        this.materialSalas = materialSalas;
    }
}
