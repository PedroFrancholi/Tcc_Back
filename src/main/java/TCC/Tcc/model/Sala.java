package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

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

    // fk - FORNECE/RECEBE - materialSala
    // fk - FORNECE - reserva
    // fk - RECEBE - bloco
}
