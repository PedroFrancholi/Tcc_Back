package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.boot.model.source.spi.FetchCharacteristics;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVA", nullable = false)
    private Long id_reserva;

    @Column(name = "DT_RESERVA", nullable = false)
    private LocalDate dt_reserva;

    @Column(name = "HR_INICIO", nullable = false)
    private LocalTime hr_inicio;

    @Column(name = "HR_FIM", nullable = false)
    private LocalTime hr_fim;

    @Column(name = "DS_OBSERVACAO")
    private String ds_observacao;

    @Column(name = "ST_RESERVA", nullable = false)
    private String st_reserva;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Turma turma;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Sala sala;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public Reserva() {
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public LocalDate getDt_reserva() {
        return dt_reserva;
    }

    public void setDt_reserva(LocalDate dt_reserva) {
        this.dt_reserva = dt_reserva;
    }

    public LocalTime getHr_inicio() {
        return hr_inicio;
    }

    public void setHr_inicio(LocalTime hr_inicio) {
        this.hr_inicio = hr_inicio;
    }

    public LocalTime getHr_fim() {
        return hr_fim;
    }

    public void setHr_fim(LocalTime hr_fim) {
        this.hr_fim = hr_fim;
    }

    public String getDs_observacao() {
        return ds_observacao;
    }

    public void setDs_observacao(String ds_observacao) {
        this.ds_observacao = ds_observacao;
    }

    public String getSt_reserva() {
        return st_reserva;
    }

    public void setSt_reserva(String st_reserva) {
        this.st_reserva = st_reserva;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
