package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Estado")
public class Estado implements Serializable {

    @Id
    @Column(name = "CD_ESTADO", nullable = false, unique = true)
    private String cd_estado;

    @Column(name = "NM_ESTADO", nullable = false)
    private String nm_estado;

    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Municipio> municipios;

    public Estado() {
    }

    public String getcd_estado() {
        return cd_estado;
    }

    public void setcd_estado(String cd_estado) {
        this.cd_estado = cd_estado;
    }

    public String getnm_estado() {
        return nm_estado;
    }

    public void setNm_estado(String nm_estado) {
        this.nm_estado = nm_estado;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
}
