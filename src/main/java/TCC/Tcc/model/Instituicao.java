package TCC.Tcc.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

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
    @OneToMany(mappedBy = "instituicao")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Polo> polos;

    public Instituicao() {
    }

    public Long getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(Long id_instituicao) {
        this.id_instituicao = id_instituicao;
    }

    public String getNm_razaosoc() {
        return nm_razaosoc;
    }

    public void setNm_razaosoc(String nm_razaosoc) {
        this.nm_razaosoc = nm_razaosoc;
    }

    public String getCd_cpfcnpj() {
        return cd_cpfcnpj;
    }

    public void setCd_cpfcnpj(String cd_cpfcnpj) {
        this.cd_cpfcnpj = cd_cpfcnpj;
    }

    public String getNm_fantasia() {
        return nm_fantasia;
    }

    public void setNm_fantasia(String nm_fantasia) {
        this.nm_fantasia = nm_fantasia;
    }

    public List<Polo> getPolos() {
        return polos;
    }

    public void setPolos(List<Polo> polos) {
        this.polos = polos;
    }
}
