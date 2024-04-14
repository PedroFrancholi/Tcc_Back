package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Bloco")
public class Bloco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BLOCO", nullable = false)
    private Long id_bloco;

    @Column(name = "NM_BLOCO", nullable = false)
    private String nm_bloco;

    @ManyToOne
    @JoinColumn(name = "id_polo", referencedColumnName = "id_polo")
    private Polo polo;

    @OneToMany(mappedBy = "bloco")
    @JsonIgnore
    private List<Sala> salas;

    public Bloco() {
    }

    public Long getId_bloco() {
        return id_bloco;
    }

    public void setId_bloco(Long id_bloco) {
        this.id_bloco = id_bloco;
    }

    public String getNm_bloco() {
        return nm_bloco;
    }

    public void setNm_bloco(String nm_bloco) {
        this.nm_bloco = nm_bloco;
    }

    public Polo getPolo() {
        return polo;
    }

    public void setPolo(Polo polo) {
        this.polo = polo;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
