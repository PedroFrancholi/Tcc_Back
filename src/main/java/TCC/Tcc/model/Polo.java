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

    @Column(name = "NM_POLO")
    private String nm_polo;

    @ManyToOne
    @JoinColumn(name = "id_instituicao", referencedColumnName = "id_instituicao")
    private Instituicao instituicao;

    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    private Municipio municipio;

    @OneToMany(mappedBy = "polo")
    @JsonIgnore
    private List<Bloco> blocos;

    public Polo() {
    }

    public Long getId_polo() {
        return id_polo;
    }

    public void setId_polo(Long id_polo) {
        this.id_polo = id_polo;
    }

    public String getNm_polo() {
        return nm_polo;
    }

    public void setNm_polo(String nm_polo) {
        this.nm_polo = nm_polo;
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
