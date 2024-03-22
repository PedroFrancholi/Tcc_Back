package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Sala")
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALA",nullable = false)
    private Long id_sala;

    @Column(name = "NM_SALA",nullable = false)
    private String nm_sala;

    @Column(name = "QT_CAPACVIGILANCIA",nullable = false)
    private Long qt_capacvigilancia;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Bloco bloco;


    @ManyToMany(mappedBy = "salas")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<MaterialSala> materialSalas;

    @OneToMany(mappedBy = "sala")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Reserva> reservas;

    public Sala() {
    }

    public Long getId_sala() {
        return id_sala;
    }

    public void setId_sala(Long id_sala) {
        this.id_sala = id_sala;
    }

    public String getNm_sala() {
        return nm_sala;
    }

    public void setNm_sala(String nm_sala) {
        this.nm_sala = nm_sala;
    }

    public Long getQt_capacvigilancia() {
        return qt_capacvigilancia;
    }

    public void setQt_capacvigilancia(Long qt_capacvigilancia) {
        this.qt_capacvigilancia = qt_capacvigilancia;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public Set<MaterialSala> getMaterialSalas() {
        return materialSalas;
    }

    public void setMaterialSalas(Set<MaterialSala> materialSalas) {
        this.materialSalas = materialSalas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
