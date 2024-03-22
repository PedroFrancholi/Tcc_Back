package TCC.Tcc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO",nullable = false)
    private Long id_usuario;

    @Column(name = "CD_CPFCNPJ", nullable = false)
    private String cd_cpfcnpj;

    @Column(name = "NM_USUARIO", nullable = false)
    private String nm_usuario;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dt_nascimento;

    @Column(name = "DS_EMAIL", nullable = false)
    private String ds_email;

    @Column(name = "DS_SENHA", nullable = false)
    private String ds_senha;

    @Column(name = "DS_FUNCAO")
    private String ds_funcao;

    @OneToMany(mappedBy = "usuario")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Log> logs;

    @OneToMany(mappedBy = "usuario")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Reserva> reservas;

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCd_cpfcnpj() {
        return cd_cpfcnpj;
    }

    public void setCd_cpfcnpj(String cd_cpfcnpj) {
        this.cd_cpfcnpj = cd_cpfcnpj;
    }

    public String getNm_usuario() {
        return nm_usuario;
    }

    public void setNm_usuario(String nm_usuario) {
        this.nm_usuario = nm_usuario;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDs_email() {
        return ds_email;
    }

    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }

    public String getDs_senha() {
        return ds_senha;
    }

    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }

    public String getDs_funcao() {
        return ds_funcao;
    }

    public void setDs_funcao(String ds_funcao) {
        this.ds_funcao = ds_funcao;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
