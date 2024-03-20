package TCC.Tcc.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;

@Entity
@Table(name = "Instituicao")
public class Instituicao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_INSTITUICAO", nullable = false)
    private Long id_instituicao;

    @Column(name = "NM_RAZAOSOC", nullable = false)
    private String nm_razaosoc;

    @Column(name = "CD_CPFCNPJ",nullable = false)
    private String cd_cpfcnpj;

    @Column(name = "NM_FANTASIA",nullable = false)
    private String nm_fantasia;

    //fk - FORNECE - Polo
}
