package TCC.Tcc.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Estado")
public class Estado implements Serializable {

    @Id
    @Column(name = "CD_ESTADO", nullable = false)
    private String cd_estado;

    @Column(name = "NM_ESTADO", nullable = false)
    private String nm_estado;

    //fk - FORNECE - Municipio
}
