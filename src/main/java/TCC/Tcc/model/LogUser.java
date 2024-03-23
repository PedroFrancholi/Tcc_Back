package TCC.Tcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "LogUser")
public class LogUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOGUSER", nullable = false)
    private Long id_logUser;

    @Column(name = "DT_LOG", nullable = false)
    private LocalDate dt_log;

    @Column(name = "NR_IP", nullable = false)
    private String nr_ip;

    @Column(name = "DS_ACAO",nullable = false)
    private String ds_acao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public LogUser() {
    }

    public Long getId_logUser() {
        return id_logUser;
    }

    public void setId_logUser(Long id_logUser) {
        this.id_logUser = id_logUser;
    }

    public LocalDate getDt_log() {
        return dt_log;
    }

    public void setDt_log(LocalDate dt_log) {
        this.dt_log = dt_log;
    }

    public String getNr_ip() {
        return nr_ip;
    }

    public void setNr_ip(String nr_ip) {
        this.nr_ip = nr_ip;
    }

    public String getDs_acao() {
        return ds_acao;
    }

    public void setDs_acao(String ds_acao) {
        this.ds_acao = ds_acao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
