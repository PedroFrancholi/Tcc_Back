package TCC.Tcc.model;

import jakarta.persistence.*;

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

    //fk - RECEBE - sala
    //fk - RECEBE - usuario
    //fk - RECEBE - turma
}
