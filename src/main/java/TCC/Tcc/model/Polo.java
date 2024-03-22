package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Polo")
public class Polo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_POLO", nullable = false)
    private Long id_polo;

    @Column(name = "DS_POLO")
    private String ds_polo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Instituicao instituicao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Municipio municipio;

    @OneToMany(mappedBy = "polo")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Bloco> blocos;

    public Polo() {
    }

    public Long getId_polo() {
        return id_polo;
    }

    public void setId_polo(Long id_polo) {
        this.id_polo = id_polo;
    }

    public String getDs_polo() {
        return ds_polo;
    }

    public void setDs_polo(String ds_polo) {
        this.ds_polo = ds_polo;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(List<Bloco> blocos) {
        this.blocos = blocos;
    }
}
