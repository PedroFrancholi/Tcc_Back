package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;

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

    //fk - RECEBE - log
    //fk - FORNECE - reserva

}
