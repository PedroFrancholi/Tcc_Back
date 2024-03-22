package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "MaterialSala_Sala",
            joinColumns = @JoinColumn(name = "id_materialsala"),
            inverseJoinColumns = @JoinColumn(name = "id_sala"))
    private Set<Sala> salas;

    @ManyToMany
    @JoinTable(name = "MaterialSala_Material",
            joinColumns = @JoinColumn(name = "id_materialsala"),
            inverseJoinColumns = @JoinColumn(name = "id_material"))
    private Set<Material> materials;

    public MaterialSala() {
    }

    public Long getId_materialsala() {
        return id_materialsala;
    }

    public void setId_materialsala(Long id_materialsala) {
        this.id_materialsala = id_materialsala;
    }

    public Double getQt_material() {
        return qt_material;
    }

    public void setQt_material(Double qt_material) {
        this.qt_material = qt_material;
    }

    public String getDs_materialSala() {
        return ds_materialSala;
    }

    public void setDs_materialSala(String ds_materialSala) {
        this.ds_materialSala = ds_materialSala;
    }

    public Set<Sala> getSalas() {
        return salas;
    }

    public void setSalas(Set<Sala> salas) {
        this.salas = salas;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
}
