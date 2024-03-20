package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "Log")
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOG", nullable = false)
    private Long id_log;

    @Column(name = "DT_LOG", nullable = false)
    private LocalDate dt_log;

    @Column(name = "NR_IP", nullable = false)
    private String nr_ip;

    @Column(name = "DS_ACAO",nullable = false)
    private String ds_acao;

    //fk - FORNECE - usuario
}
