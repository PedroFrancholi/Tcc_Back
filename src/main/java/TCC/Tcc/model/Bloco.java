package TCC.Tcc.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Bloco")
public class Bloco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BLOCO", nullable = false)
    private Long id_bloco;

    @Column(name = "NM_BLOCO", nullable = false)
    private String nm_bloco;

    //fk - polo
}
