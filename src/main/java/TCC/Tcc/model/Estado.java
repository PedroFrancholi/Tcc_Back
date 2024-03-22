package TCC.Tcc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Estado")
public class Estado implements Serializable {

    @Id
    @Column(name = "CD_ESTADO", nullable = false)
    private String cd_estado;

    @Column(name = "NM_ESTADO", nullable = false)
    private String nm_estado;

    @OneToMany(mappedBy = "estado")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Municipio> municipios;

    public Estado() {
    }

    public String getCd_estado() {
        return cd_estado;
    }

    public void setCd_estado(String cd_estado) {
        this.cd_estado = cd_estado;
    }

    public String getNm_estado() {
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
