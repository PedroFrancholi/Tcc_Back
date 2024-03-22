package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Municipio")
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUNICIPIO", nullable = false)
    private Long id_municipio;

    @Column(name = "NM_MUNICIPIO", nullable = false)
    private String nm_municipio;

    @OneToMany(mappedBy = "municipio")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Polo> polos;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;

    public Municipio() {
    }

    public Long getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Long id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getNm_municipio() {
        return nm_municipio;
    }

    public void setNm_municipio(String nm_municipio) {
        this.nm_municipio = nm_municipio;
    }

    public List<Polo> getPolos() {
        return polos;
    }

    public void setPolos(List<Polo> polos) {
        this.polos = polos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
